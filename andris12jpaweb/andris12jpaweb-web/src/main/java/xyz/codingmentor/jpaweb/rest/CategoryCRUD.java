package xyz.codingmentor.jpaweb.rest;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.api.CategoryCRUDResource_;
import xyz.codingmentor.jpaweb.api.CategoryCRUDService_;
import xyz.codingmentor.jpaweb.dto.CategoryDTO;
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

    public CategoryCRUD() {
        categoryCRUDService = null;
    }

    @Inject
    public CategoryCRUD(CategoryCRUDService_ categoryCRUDService) {
        this.categoryCRUDService = categoryCRUDService;
    }
    
    @Override
    public Response create(CategoryDTO category) throws RepoException {
        categoryCRUDService.create(category);
        return Response.ok(category, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response read(Long Id) throws RepoException {
        return Response.ok(categoryCRUDService.read(Id), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response update(CategoryDTO category) throws RepoException {
        categoryCRUDService.update(category);
        return Response.ok(category, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response delete(Long Id) throws RepoException {
        categoryCRUDService.delete(Id);
        return Response.ok().build();
    }

}
