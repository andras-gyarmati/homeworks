package xyz.codingmentor.andrisjpa;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import xyz.codingmentor.andrisjpa.api.RepositoryException;
import xyz.codingmentor.andrisjpa.entity.Address;
import xyz.codingmentor.andrisjpa.entity.SculptorEntity;
import xyz.codingmentor.andrisjpa.entity.SculptureEntity;
import xyz.codingmentor.andrisjpa.entity.WorkshopEntity;
import xyz.codingmentor.andrisjpa.enums.Material;
import xyz.codingmentor.andrisjpa.enums.Sex;
import xyz.codingmentor.andrisjpa.service.SculptorCRUDService;
import xyz.codingmentor.andrisjpa.service.SculptorJPQLService;

/**
 *
 * @author brianelete
 */
public class App {

    private SculptorCRUDService sculptureCRUDService;
    private SculptorJPQLService sculptureJPQLService;
    @Inject
    private Logger logger;

    public App() {
        //empty
    }

    @Inject
    public App(SculptorCRUDService sculptureCRUDService, SculptorJPQLService sculptureJPQLService) {
        this.sculptureCRUDService = sculptureCRUDService;
        this.sculptureJPQLService = sculptureJPQLService;
    }

    public void execute() throws RepositoryException {
        sculptureCRUDService.createSculptor(newDate(1994, 3, 4), "John Doe");
        SculptorEntity sculptor01 = sculptureCRUDService.findSculptor(newDate(1994, 3, 4), "John Doe");
        sculptor01.setSex(Sex.MALE);
        WorkshopEntity workshop01 = new WorkshopEntity();
        Address address01 = new Address();
        address01.setCity("Budapest");
        address01.setCountry("Hungary");
        address01.setState("Pest");
        address01.setStreet("Váci út 10");
        address01.setZipcode("1138");
        workshop01.setAddress(address01);
        workshop01.setMaterial(Material.CLAY);
        workshop01.setName("Workshop 01");
        List sculptors = new ArrayList<>();
        sculptors.add(sculptor01);
        workshop01.setSculptors(sculptors);
        List workshops = new ArrayList<>();
        workshops.add(workshop01);
        sculptor01.setWorkshops(workshops);
        SculptureEntity sculpture01 = new SculptureEntity();
        sculpture01.setCreationDate(new Date());
        sculpture01.setMaterial(Material.CLAY);
        sculpture01.setName("Sculpture 01");
        sculpture01.setCreator(sculptor01);
        List sculptures = new ArrayList<>();
        sculptures.add(sculpture01);
        sculptor01.setSculptures(sculptures);
        sculptureCRUDService.updateSculptor(sculptor01);
        List<SculptorEntity> allSculptors = sculptureJPQLService.getAllSculptor();
        List<SculptorEntity> foundSculptorsByName = sculptureJPQLService.findSculptorByName(allSculptors.get(0).getName());
        List<WorkshopEntity> foundWorkshopsBySculptor = sculptureJPQLService.findWorkshopsBySculptor(foundSculptorsByName.get(0).getName());
        List<SculptorEntity> foundSculptorsByWorkshop = sculptureJPQLService.findSculptorsByWorkshop(foundWorkshopsBySculptor.get(0));
        List<SculptureEntity> foundSculpturesBySculptor = sculptureJPQLService.findSculpturesBySculptor(foundSculptorsByWorkshop.get(0).getName());
        logger.log(Level.INFO, foundSculpturesBySculptor.get(0).getName());
        sculptureCRUDService.deleteSculptor(sculptor01.getBirthDate(), sculptor01.getName());
    }

    private static Date newDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}
