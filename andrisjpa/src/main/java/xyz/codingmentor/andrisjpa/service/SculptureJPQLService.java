package xyz.codingmentor.andrisjpa.service;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import xyz.codingmentor.andrisjpa.jpa.JPASculptureRepo;

/**
 *
 * @author brianelete
 */
public class SculptureJPQLService {

    private JPASculptureRepo sculptureRepo;

    public SculptureJPQLService() {

    }

    @Inject
    public SculptureJPQLService(JPASculptureRepo sculptureRepo) {
        this.sculptureRepo = sculptureRepo;
    }

    
    
    @PreDestroy
    private void preDestroy() {
        sculptureRepo.close();
    }
}
