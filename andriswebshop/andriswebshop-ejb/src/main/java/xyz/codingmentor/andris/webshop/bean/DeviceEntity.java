package xyz.codingmentor.andris.webshop.bean;

import java.io.Serializable;
import java.util.Objects;
import xyz.codingmentor.andris.webshop.enums.Color;
import xyz.codingmentor.andris.webshop.enums.Manufacturer;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.andris.webshop.annotation.Validate;
import xyz.codingmentor.andris.webshop.constraint.DeviceColor;

/**
 *
 * @author brianelete
 */
@DeviceColor
@Validate
public class DeviceEntity implements Serializable {

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

    @Override
    public String toString() {
        return "DeviceEntity{" + "id=" + id + ", manufacturer=" + manufacturer + ", type=" + type + ", price=" + price + ", color=" + color + ", count=" + count + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DeviceEntity other = (DeviceEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
