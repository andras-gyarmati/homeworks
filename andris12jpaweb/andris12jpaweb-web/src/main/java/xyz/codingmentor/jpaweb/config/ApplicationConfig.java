package xyz.codingmentor.jpaweb.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author brianelete
 */
@javax.ws.rs.ApplicationPath("rest")
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
        resources.add(xyz.codingmentor.jpaweb.exception.GeneralExceptionMapper.class);
        resources.add(xyz.codingmentor.jpaweb.exception.RepoExceptionMapper.class);
        resources.add(xyz.codingmentor.jpaweb.rest.ActorCRUD.class);
        resources.add(xyz.codingmentor.jpaweb.rest.CategoryCRUD.class);
        resources.add(xyz.codingmentor.jpaweb.rest.Connect.class);
        resources.add(xyz.codingmentor.jpaweb.rest.MovieCRUD.class);
        resources.add(xyz.codingmentor.jpaweb.rest.Query.class);
        resources.add(xyz.codingmentor.jpaweb.rest.TrailerCRUD.class);
    }
    
}
