package xyz.codingmentor.carfactory.andris.partfactory;

import xyz.codingmentor.carfactory.andris.annotation.FaultyPart;

/**
 *
 * @author brianelete
 */
@FaultyPart(description = "Faulty Mirror")
public class Mirror extends Part {

    public Mirror(String serialNo, String brand) {
        super(serialNo, brand);
    }
  
}
