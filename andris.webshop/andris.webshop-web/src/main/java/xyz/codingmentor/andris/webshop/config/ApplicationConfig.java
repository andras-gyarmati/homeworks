package xyz.codingmentor.andris.webshop.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author beianelete
 */
@javax.ws.rs.ApplicationPath("/shop")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(xyz.codingmentor.andris.webshop.exception.AuthenticationFailureExceptionMapper.class);
        resources.add(xyz.codingmentor.andris.webshop.exception.GeneralExceptionMapper.class);
        resources.add(xyz.codingmentor.andris.webshop.exception.NotLoggedInExceptionMapper.class);
        resources.add(xyz.codingmentor.andris.webshop.rest.CartRESTService.class);
        resources.add(xyz.codingmentor.andris.webshop.rest.UserRESTService.class);
    }

}
