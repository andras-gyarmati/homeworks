package xyz.codingmentor.jpaweb.rest;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.dto.CategoryDTO;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.api.ICategoryCRUDService;
import xyz.codingmentor.jpaweb.api.ICategoryCRUDResource;

/**
 * REST Web Service
 *
 * @author brianelete
 */
@Path("cat")
@RequestScoped
public class CategoryCRUD implements ICategoryCRUDResource {

    private final ICategoryCRUDService categoryCRUDService;

    public CategoryCRUD() {
        categoryCRUDService = null;
    }

    @Inject
    public CategoryCRUD(ICategoryCRUDService categoryCRUDService) {
        this.categoryCRUDService = categoryCRUDService;
    }
    
    @Override
    public Response create(CategoryDTO category) throws RepoException {
        categoryCRUDService.create(category);
        return Response.ok(category, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response read(Long id) throws RepoException {
        return Response.ok(categoryCRUDService.read(id), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response update(CategoryDTO category) throws RepoException {
        categoryCRUDService.update(category);
        return Response.ok(category, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response delete(Long id) throws RepoException {
        categoryCRUDService.delete(id);
        return Response.ok().build();
    }

}
