package xyz.codingmentor.jpaweb.exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import xyz.codingmentor.jpaweb.dto.ErrorDTO;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
@Provider
public class RepoExceptionMapper implements ExceptionMapper<RepoException> {

    private static final Logger LOGGER = Logger.getLogger(RepoExceptionMapper.class.getName());

    @Override
    public Response toResponse(RepoException exception) {
        LOGGER.log(Level.SEVERE, "Repository Exception", exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorDTO(exception.getMessage() + " - " + exception.getCause())).type(MediaType.APPLICATION_JSON).build();
    }
}
