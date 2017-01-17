package xyz.codingmentor.andris.async.service;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private static final Logger LOGGER = Logger.getLogger(AsyncService.class.getName());

    public Future<Integer> doStuffFuture() {
        LOGGER.log(Level.INFO, "FUTURE START");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
        Integer status = 1;
        if (ctx.wasCancelCalled()) {
            return new AsyncResult<>(2);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
        LOGGER.log(Level.INFO, "FUTURE STOP");
        return new AsyncResult<>(status);
    }

    public void doStuffVoid() {
        LOGGER.log(Level.INFO, "VOID START");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
        LOGGER.log(Level.INFO, "VOID STOP");
    }

}
