package xyz.codingmentor.andris.async.service;

import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author brianelete
 */
@Stateless
@Asynchronous
public class AsyncService {
     
    @Resource
    SessionContext ctx;
 
    public Future<Integer> doStuffFuture() throws InterruptedException {
        Integer status = 0;
        Thread.sleep(5000);
        status = 1;
        if(ctx.wasCancelCalled()) {
            return new AsyncResult<>(2);
        }
        Thread.sleep(5000);
        return new AsyncResult<>(status);
    }
    
    public void doStuffVoid() throws InterruptedException {
        Thread.sleep(10000);
    }
     
}