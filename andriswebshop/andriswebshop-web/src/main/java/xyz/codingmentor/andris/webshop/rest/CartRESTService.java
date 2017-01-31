package xyz.codingmentor.andris.webshop.rest;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.andris.webshop.bean.DeviceEntity;
import xyz.codingmentor.andris.webshop.dto.ResultDTO;
import xyz.codingmentor.andris.webshop.dto.ResultType;
import xyz.codingmentor.andris.webshop.exception.NotLoggedInException;
import xyz.codingmentor.andris.webshop.service.Cart;

/**
 *
 * @author beianelete
 */
@Path("/cart")
@SessionScoped
@Produces(MediaType.APPLICATION_JSON)
public class CartRESTService implements Serializable {

    @EJB
    private Cart cart;

    /**
     * http://localhost:8080/andriswebshop-web/shop/cart
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO addToCart(@Context HttpServletRequest request, DeviceEntity device) {
        checkCredentials(request);
        return new ResultDTO(ResultType.SUCCESS, cart.addDevice(device.getId(), device.getCount()));
    }
    
    /**
     * http://localhost:8080/andriswebshop-web/shop/cart
     */
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO deleteFromCart(@Context HttpServletRequest request, DeviceEntity device) {
        checkCredentials(request);
        return new ResultDTO(ResultType.SUCCESS, cart.removeDevice(device, device.getCount()));
    }

    /**
     * http://localhost:8080/andriswebshop-web/shop/cart
     */
    @GET
    public List<DeviceEntity> getCart(@Context HttpServletRequest request) {
        checkCredentials(request);
        return cart.getCart();
    }

    /**
     * http://localhost:8080/andriswebshop-web/shop/cart/buyCart
     */
    @POST
    @Path("/buyCart")
    public List<DeviceEntity> buyCart(@Context HttpServletRequest request) {
        checkCredentials(request);
        List<DeviceEntity> devicesToBuy = cart.buyCart();
        request.getSession().invalidate();
        return devicesToBuy;
    }

    private static void checkCredentials(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null == session.getAttribute(UserRESTService.USER_KEY)) {
            throw new NotLoggedInException("You should log in first!");
        }
    }
}
