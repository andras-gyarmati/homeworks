package xyz.codingmentor.andrisjpa.service;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import xyz.codingmentor.andrisjpa.api.RepositoryException;
import xyz.codingmentor.andrisjpa.entity.SculptorEntity;
import xyz.codingmentor.andrisjpa.entity.SculptureEntity;
import xyz.codingmentor.andrisjpa.entity.WorkshopEntity;
import xyz.codingmentor.andrisjpa.jpa.JPASculptorRepo;

/**
 *
 * @author brianelete
 */
public class SculptorJPQLService {

    private JPASculptorRepo sculptureRepo;

    public SculptorJPQLService() {
        //empty
    }

    @Inject
    public SculptorJPQLService(JPASculptorRepo sculptureRepo) {
        this.sculptureRepo = sculptureRepo;
    }

    public List<SculptorEntity> getAllSculptor() throws RepositoryException {
        return sculptureRepo.getAllSculptor();
    }

    public List<SculptorEntity> findSculptorByName(String name) throws RepositoryException {
        return sculptureRepo.findSculptorByName(name);
    }

    public List<WorkshopEntity> findWorkshopsBySculptor(String name) throws RepositoryException {
        return sculptureRepo.findWorkshopsBySculptor(name);
    }

    public List<SculptorEntity> findSculptorsByWorkshop(WorkshopEntity workshop) throws RepositoryException {
        return sculptureRepo.findSculptorsByWorkshop(workshop);
    }

    public List<SculptureEntity> findSculpturesBySculptor(String name) throws RepositoryException {
        return sculptureRepo.findSculpturesBySculptor(name);
    }

    @PreDestroy
    public void preDestroy() {
        sculptureRepo.close();
    }
}
