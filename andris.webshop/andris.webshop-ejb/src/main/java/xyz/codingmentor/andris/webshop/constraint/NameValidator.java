package xyz.codingmentor.andris.webshop.constraint;

import xyz.codingmentor.andris.webshop.bean.UserEntity;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author brianelete
 */
public class NameValidator implements ConstraintValidator<Name, UserEntity> {

    @Override
    public void initialize(Name a) {
        // empty
    }

    @Override
    public boolean isValid(UserEntity userEntity, ConstraintValidatorContext cvc) {

        boolean isBothNull = userEntity.getfirstname() == null && userEntity.getlastname() == null;
        boolean isBothFilled = userEntity.getfirstname() != null && userEntity.getlastname() != null;

        return isBothNull || isBothFilled;
    }

}
