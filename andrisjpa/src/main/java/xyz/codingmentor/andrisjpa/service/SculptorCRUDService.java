package xyz.codingmentor.andrisjpa.service;

import java.util.Date;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import xyz.codingmentor.andrisjpa.api.RepositoryException;
import xyz.codingmentor.andrisjpa.entity.SculptorEntity;
import xyz.codingmentor.andrisjpa.jpa.JPASculptorRepo;

/**
 *
 * @author brianelete
 */
public class SculptorCRUDService {

    private JPASculptorRepo sculptorRepo;

    public SculptorCRUDService() {

    }

    @Inject
    public SculptorCRUDService(JPASculptorRepo sculptorRepo) {
        this.sculptorRepo = sculptorRepo;
    }

    public SculptorEntity createSculptor(Date birtdate, String name) throws RepositoryException {
        return sculptorRepo.createSculptor(birtdate, name);
    }

    public SculptorEntity findSculptor(Date birthday, String name) throws RepositoryException {
        return sculptorRepo.findSculptor(birthday, name);
    }

    public void updateSculptor(SculptorEntity sculptor) throws RepositoryException {
        sculptorRepo.updateSculptor(sculptor);
    }

    public void deleteSculptor(Date birthday, String name) throws RepositoryException {
        sculptorRepo.deleteSculptor(birthday, name);
    }

    @PreDestroy
    private void preDestroy() {
        sculptorRepo.close();
    }
}
