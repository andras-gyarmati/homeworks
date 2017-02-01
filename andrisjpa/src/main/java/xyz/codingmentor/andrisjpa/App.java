package xyz.codingmentor.andrisjpa;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import xyz.codingmentor.andrisjpa.api.RepositoryException;
import xyz.codingmentor.andrisjpa.service.SculptureCRUDService;
import xyz.codingmentor.andrisjpa.service.SculptureJPQLService;

/**
 *
 * @author brianelete
 */
public class App {
    
    private SculptureCRUDService sculptureCRUDService;
    private SculptureJPQLService sculptureJPQLService;

    public App() {
    }

    @Inject
    public App(SculptureCRUDService sculptureCRUDService, SculptureJPQLService sculptureJPQLService) {
        this.sculptureCRUDService = sculptureCRUDService;
        this.sculptureJPQLService = sculptureJPQLService;
    }
    
    void execute() {
        try {
            sculptureCRUDService.createSculpture();
        } catch (RepositoryException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
