package xyz.codingmentor.andris.rest.config;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author brianelete
 */
@ApplicationPath("/rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(xyz.codingmentor.andris.rest.exception.IdNotMatchExceptionMapper.class);
        resources.add(xyz.codingmentor.andris.rest.service.UserRESTService.class);
    }
}