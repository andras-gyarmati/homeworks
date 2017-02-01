package xyz.codingmentor.andrisjpa.service;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import xyz.codingmentor.andrisjpa.api.RepositoryException;
import xyz.codingmentor.andrisjpa.entity.SculptureEntity;
import xyz.codingmentor.andrisjpa.jpa.JPASculptureRepo;

/**
 *
 * @author brianelete
 */
public class SculptureCRUDService {

    private JPASculptureRepo sculptureRepo;

    public SculptureCRUDService() {

    }

    @Inject
    public SculptureCRUDService(JPASculptureRepo sculptureRepo) {
        this.sculptureRepo = sculptureRepo;
    }

    public SculptureEntity createSculpture() throws RepositoryException {
        return sculptureRepo.createSculpture();
    }

    public SculptureEntity findSculpture(String id) throws RepositoryException {
        return sculptureRepo.readSculpture(id);
    }

    public void updateSculpture(SculptureEntity sculpture) throws RepositoryException {
        sculptureRepo.updateSculpture(sculpture);
    }

    public void deleteSculpture(String id) throws RepositoryException {
        sculptureRepo.deleteSculpture(id);
    }

    @PreDestroy
    private void preDestroy() {
        sculptureRepo.close();
    }
}
