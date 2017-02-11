package xyz.codingmentor.jpaweb.exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import xyz.codingmentor.jpaweb.dto.ErrorDTO;

/**
 *
 * @author brianelete
 */
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Exception> {

    private static final Logger LOGGER = Logger.getLogger(GeneralExceptionMapper.class.getName());

    @Override
    public Response toResponse(Exception exception) {
        LOGGER.log(Level.SEVERE, "General Exception", exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorDTO(exception.getMessage() + " - " + exception.getCause())).type(MediaType.APPLICATION_JSON).build();
    }
}
