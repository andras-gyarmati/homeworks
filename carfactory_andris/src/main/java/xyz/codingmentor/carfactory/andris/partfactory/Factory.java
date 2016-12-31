package xyz.codingmentor.carfactory.andris.partfactory;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import java.util.UUID;
import java.util.logging.Level;
import xyz.codingmentor.carfactory.andris.annotation.FaultyPart;

/**
 *
 * @author brianelete
 */
public class Factory {

    private static final Logger LOGGER = Logger.getLogger(Factory.class.getName());
    
    private List<Part> parts;

    public Factory() {
        this.parts = new ArrayList<>();
    }

    public void listFaultyParts() {
        List<Class> classes = new ArrayList<>();
        classes.add(Gear.class);
        classes.add(Mirror.class);
        classes.add(PowerWindow.class);
        classes.add(TurnSignal.class);
        classes = faultyClasses(classes);
        LOGGER.log(Level.INFO, "Faulty part(s):");
        for (Part part : parts) {
            if (classes.contains(part.getClass())) {
                LOGGER.log(Level.INFO, part.toString());
            }
        }
    }

    private List<Class> faultyClasses(List<Class> classes) {
        List<Class> tmpClasses = new ArrayList<>();
        for (final Class clazz : classes) {
            if (null != clazz.getAnnotation(FaultyPart.class)) {
                tmpClasses.add(clazz);
            }
        }
        return tmpClasses;
    }

    private String currentTime(){
         return " time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }
    
    public void makePart(CarTypes carType, PartTypes partType) {
        Part tmpPart;
        switch (partType) {
            case GEAR:
                tmpPart = new Gear(UUID.randomUUID().toString(), carType.toString());
                parts.add(tmpPart);
                LOGGER.log(Level.INFO, tmpPart.toString() + currentTime());
                break;
            case MIRROR:
                tmpPart = new Mirror(UUID.randomUUID().toString(), carType.toString());
                parts.add(tmpPart);
                LOGGER.log(Level.INFO, tmpPart.toString() + currentTime());
                break;
            case POWERWINDOW:
                tmpPart = new PowerWindow(UUID.randomUUID().toString(), carType.toString());
                parts.add(tmpPart);
                LOGGER.log(Level.INFO, tmpPart.toString() + currentTime());
                break;
            case TURNSIGNAL:
                tmpPart = new TurnSignal(UUID.randomUUID().toString(), carType.toString());
                parts.add(tmpPart);
                LOGGER.log(Level.INFO, tmpPart.toString() + currentTime());
                break;
            default:
                break;
        }
    }
}
