package xyz.codingmentor.andris.webshop.constraint;

import xyz.codingmentor.andris.webshop.enums.Color;
import xyz.codingmentor.andris.webshop.bean.DeviceEntity;
import xyz.codingmentor.andris.webshop.enums.Manufacturer;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author brianelete
 */
public class DeviceColorValidator implements ConstraintValidator<DeviceColor, DeviceEntity> {

    @Override
    public void initialize(DeviceColor a) {
        //empty
    }

    @Override
    public boolean isValid(DeviceEntity deviceEntity, ConstraintValidatorContext cvc) {
        if (deviceEntity.getManufacturer() == Manufacturer.APPLE && (deviceEntity.getColor() != Color.WHITE && deviceEntity.getColor() != Color.BLACK)) {
            return false;
        } else if (deviceEntity.getManufacturer() == Manufacturer.SAMSUNG && deviceEntity.getColor() == Color.GREEN) {
            return false;
        }
        return true;
    }

}
