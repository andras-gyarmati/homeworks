package xyz.codingmentor.beanvalidation.andris.beans;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.beanvalidation.andris.annotation.Validate;
import xyz.codingmentor.beanvalidation.andris.constraint.DeviceColor;

/**
 *
 * @author brianelete
 */
@DeviceColor
@Validate
public class DeviceEntity {

    @NotNull
    @Size(min = 36, max = 36)
    private String id;
    @NotNull
    private Manufacturer manufacturer;
    @NotNull
    @Size(min = 3)
    private String type;
    @NotNull
    @DecimalMin("0")
    private int price;
    @NotNull
    private Color color;
    @NotNull
    @DecimalMin("0")
    private int count;

    public DeviceEntity() {
        // empty
    }

    public DeviceEntity(String id, Manufacturer manufacturer, String type, int price, Color color, int count) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.type = type;
        this.price = price;
        this.color = color;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    public int getCount() {
        return count;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
