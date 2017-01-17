package xyz.codingmentor.andris.webshop.rest;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.andris.webshop.bean.DeviceEntity;
import xyz.codingmentor.andris.webshop.exception.NotLoggedInException;
import xyz.codingmentor.andris.webshop.service.Cart;

/**
 *
 * @author beianelete
 */
@Path("/cart")
@Produces(MediaType.APPLICATION_JSON)
@SessionScoped
public class CartRESTService implements Serializable {

    @Inject
    private Cart cartService;

    /**
     * http://localhost:8080/andriswebshop/shop/cart
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public List<DeviceEntity> addToCart(@Context HttpServletRequest request, DeviceEntity device) {
        checkCredentials(request);
        return cartService.addDevice(device, 1);
    }

    /**
     * http://localhost:8080/andriswebshop/shop/cart
     */
    @GET
    public List<DeviceEntity> getCart(@Context HttpServletRequest request) {
        checkCredentials(request);
        return cartService.getDevices();
    }

    /**
     * http://localhost:8080/andriswebshop/shop/cart/buyCart
     */
    @POST
    @Path("/buyCart")
    public List<DeviceEntity> buyCart(@Context HttpServletRequest request) {
        checkCredentials(request);
        List<DeviceEntity> devicesToBuy = cartService.buy();
        request.getSession().invalidate();
        return devicesToBuy;
    }

    private void checkCredentials(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute(UserRESTService.USER_KEY) == null) {
            throw new NotLoggedInException("You should log in before put anything in the cart!");
        }
    }
}
