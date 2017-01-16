package xyz.codingmentor.andris.async.restservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.andris.async.service.AsyncService;

/**
 *
 * @author brianelete
 */
@Path("/async")
@Produces(MediaType.APPLICATION_JSON)
public class AsyncRESTService {

    private static final Logger LOGGER = Logger.getLogger(AsyncRESTService.class.getSimpleName());
    @Inject
    private AsyncService asyncService;

    /**
     * http://localhost:8080/async-web/async/future/{id}
     */
    @GET
    @Path("/future/{id}")
    public String getAsyncFuture(@PathParam("id") String id) throws InterruptedException, ExecutionException {
        Future<Integer> status = asyncService.doStuffFuture();
        LOGGER.log(Level.INFO, "GET VALUE");
        Integer statusValue = status.get();
        LOGGER.log(Level.INFO, "RETURN FUTURE");
        return id + " finished, statusValue: " + statusValue;
    }

    /**
     * http://localhost:8080/async-web/async/void/{id}
     */
    @GET
    @Path("/void/{id}")
    public String getAsyncVoid(@PathParam("id") String id) throws InterruptedException {
        asyncService.doStuffVoid();
        LOGGER.log(Level.INFO, "RETURN VOID");
        return id + " finished.";
    }
}
