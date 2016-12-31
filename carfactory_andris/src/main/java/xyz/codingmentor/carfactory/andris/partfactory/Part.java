package xyz.codingmentor.carfactory.andris.partfactory;

/**
 *
 * @author brianelete
 */
public abstract class Part {

    private String serialNo;
    private String brand;

    protected Part(String serialNo, String brand) {
        this.serialNo = serialNo;
        this.brand = brand;
    }
    
    @Override
    public String toString() {
        return this.getClass() + " serialNo=" + serialNo + ", brand=" + brand + '}';
    }
    
}
