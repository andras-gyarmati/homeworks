package xyz.codingmentor.andris.webshop.rest;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.andris.webshop.bean.DeviceEntity;
import xyz.codingmentor.andris.webshop.bean.UserEntity;
import xyz.codingmentor.andris.webshop.database.DeviceDB;
import xyz.codingmentor.andris.webshop.dto.ResultDTO;
import xyz.codingmentor.andris.webshop.dto.ResultType;
import xyz.codingmentor.andris.webshop.exception.NotLoggedInException;

/**
 *
 * @author beianelete
 */
@Path("/devices")
public class DeviceRESTService implements Serializable {

    public static final String USER_KEY = "user";

    @EJB
    private DeviceDB deviceDB;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO addDevice(@Context HttpServletRequest request, DeviceEntity newDevice) {
        HttpSession session = request.getSession();
        if (isLoggedIn(session).isAdmin()) {
            DeviceEntity returnedDevice = deviceDB.addDevice(newDevice);
            return new ResultDTO(ResultType.SUCCESS, returnedDevice);
        }
        return new ResultDTO(ResultType.ERROR, newDevice);
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO deleteDevice(@Context HttpServletRequest request, DeviceEntity deleteDevice) {
        HttpSession session = request.getSession();
        if (isLoggedIn(session).isAdmin()) {
            deviceDB.deleteDevice(deleteDevice);
            return new ResultDTO(ResultType.SUCCESS, deleteDevice);
        }
        return new ResultDTO(ResultType.ERROR, deleteDevice);
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DeviceEntity getDevice(@PathParam("id") String id) {
        return deviceDB.getDevice(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DeviceEntity> getAllDevice() {
        return deviceDB.getAllDevice();
    }

    private static UserEntity isLoggedIn(HttpSession session) {
        if (session.getAttribute(UserRESTService.USER_KEY) == null) {
            throw new NotLoggedInException("You should log in first!");
        }
        return (UserEntity) session.getAttribute(USER_KEY);
    }
}
