package xyz.codingmentor.andris.rest.exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author brianelete
 */
@Provider
public class IdNotMatchExceptionMapper implements ExceptionMapper<IdNotMatchException> {

    private static final Logger LOGGER = Logger.getLogger(IdNotMatchExceptionMapper.class.getSimpleName());
    
    @Override
    public Response toResponse(IdNotMatchException exception) {
        LOGGER.log(Level.SEVERE, "ID not matches!", exception);
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorDTO(exception.getMessage())).type(MediaType.APPLICATION_JSON).build();
    }

}
