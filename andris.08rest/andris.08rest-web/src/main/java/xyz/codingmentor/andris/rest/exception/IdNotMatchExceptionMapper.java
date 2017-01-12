package xyz.codingmentor.andris.rest.exception;

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

    @Override
    public Response toResponse(IdNotMatchException exception) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorDTO(exception.getMessage())).type(MediaType.APPLICATION_JSON).build();
    }

}
