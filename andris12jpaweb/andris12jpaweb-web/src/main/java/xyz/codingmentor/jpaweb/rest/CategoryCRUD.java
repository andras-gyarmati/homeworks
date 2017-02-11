package xyz.codingmentor.jpaweb.rest;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.api.CategoryCRUDResource_;
import xyz.codingmentor.jpaweb.api.CategoryCRUDService_;
import xyz.codingmentor.jpaweb.entity.CategoryEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 * REST Web Service
 *
 * @author brianelete
 */
@Path("cat")
@RequestScoped
public class CategoryCRUD implements CategoryCRUDResource_ {

    private final CategoryCRUDService_ categoryCRUDService;

    public CategoryCRUD(CategoryCRUDService_ categoryCRUDService) {
        this.categoryCRUDService = categoryCRUDService;
    }
    
    @Override
    public Response createEntity(CategoryEntity category) throws RepoException {
        categoryCRUDService.createEntity(category);
        return Response.ok(category, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response getEntityById(Long Id) throws RepoException {
        return Response.ok(categoryCRUDService.getEntityById(Id), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response updateEntity(CategoryEntity category) throws RepoException {
        categoryCRUDService.updateEntity(category);
        return Response.ok(category, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response deleteEntityById(Long Id) throws RepoException {
        categoryCRUDService.removeEntity(Id);
        return Response.ok().build();
    }

}
