package xyz.codingmentor.beanvalidation.andris.constraint;

import xyz.codingmentor.beanvalidation.andris.beans.Color;
import xyz.codingmentor.beanvalidation.andris.beans.DeviceEntity;
import xyz.codingmentor.beanvalidation.andris.beans.Manufacturer;
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
