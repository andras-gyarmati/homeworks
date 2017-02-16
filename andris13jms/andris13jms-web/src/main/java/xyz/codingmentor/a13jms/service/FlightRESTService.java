package xyz.codingmentor.a13jms.service;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.a13jms.api.IService;
import xyz.codingmentor.a13jms.api.ITopic;
import xyz.codingmentor.a13jms.entity.Flight;
import xyz.codingmentor.a13jms.ex.RepoEx;

/**
 * REST Web Service
 *
 * @author brianelete
 */
@Path("flight")
public class FlightRESTService {

    @Inject
    private IService iService;
 
    @Inject
    private ITopic iTopic;
 
    public FlightRESTService() {
        //empty
    }
 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Flight flight) throws RepoEx {
        iService.create(flight);
        return Response.ok(flight).build();
    }
 
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id") Long flightId) throws RepoEx {
        Flight flight = iService.read(flightId);
        return Response.ok(flight).build();
    }
 
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Flight flight) throws RepoEx {
        Flight updatedFlight = iService.update(flight);
        iTopic.sendUpdate(flight);
        return Response.ok(updatedFlight).build();
    }
 
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long flightId) throws RepoEx {
        Flight deletedFlight = iService.read(flightId);
        iTopic.sendDelete(deletedFlight);
        iService.delete(flightId);
        return Response.ok().build();
    }
}
