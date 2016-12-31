package xyz.codingmentor.carfactory.andris.main;

import xyz.codingmentor.carfactory.andris.partfactory.CarTypes;
import xyz.codingmentor.carfactory.andris.partfactory.Factory;
import xyz.codingmentor.carfactory.andris.partfactory.PartTypes;

/**
 *
 * @author brianelete
 */
public class Main {

    private Main() {
        //empty
    }

    public static void main(String[] args) {

        Factory factory = new Factory();
        factory.makePart(CarTypes.FORD, PartTypes.GEAR);
        factory.makePart(CarTypes.FORD, PartTypes.MIRROR);
        factory.makePart(CarTypes.FORD, PartTypes.POWERWINDOW);
        factory.makePart(CarTypes.FORD, PartTypes.TURNSIGNAL);
        factory.makePart(CarTypes.MAZDA, PartTypes.GEAR);
        factory.makePart(CarTypes.MAZDA, PartTypes.MIRROR);
        factory.makePart(CarTypes.MAZDA, PartTypes.POWERWINDOW);
        factory.makePart(CarTypes.MAZDA, PartTypes.TURNSIGNAL);
        factory.makePart(CarTypes.AUDI, PartTypes.GEAR);
        factory.makePart(CarTypes.AUDI, PartTypes.MIRROR);
        factory.makePart(CarTypes.AUDI, PartTypes.POWERWINDOW);
        factory.makePart(CarTypes.AUDI, PartTypes.TURNSIGNAL);
        factory.makePart(CarTypes.TOYOTA, PartTypes.GEAR);
        factory.makePart(CarTypes.TOYOTA, PartTypes.MIRROR);
        factory.makePart(CarTypes.TOYOTA, PartTypes.POWERWINDOW);
        factory.makePart(CarTypes.TOYOTA, PartTypes.TURNSIGNAL);

        factory.listFaultyParts();
    }

}
