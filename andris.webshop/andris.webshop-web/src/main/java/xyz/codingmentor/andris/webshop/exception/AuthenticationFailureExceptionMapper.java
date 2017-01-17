package xyz.codingmentor.andris.webshop.exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import xyz.codingmentor.andris.webshop.dto.ResultDTO;
import xyz.codingmentor.andris.webshop.dto.ResultType;

/**
 *
 * @author beianelete
 */
@Provider
public class AuthenticationFailureExceptionMapper implements ExceptionMapper<AuthenticationFailureException> {

    private static final Logger LOGGER = Logger.getLogger(AuthenticationFailureExceptionMapper.class.getName());

    @Override
    public Response toResponse(AuthenticationFailureException throwable) {
        LOGGER.log(Level.SEVERE, "General Exception", throwable);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ResultDTO(ResultType.ERROR, throwable.getMessage() + " - " + throwable.getCause())).type(MediaType.APPLICATION_JSON).build();
    }

}
