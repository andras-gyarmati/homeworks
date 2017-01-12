package xyz.codingmentor.beanvalidation.andris.constraint;

import xyz.codingmentor.beanvalidation.andris.bean.UserEntity;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author brianelete
 */
public class BirthDateValidator implements ConstraintValidator<BirthDate, UserEntity> {

    @Override
    public void initialize(BirthDate a) {
        // empty
    }

    @Override
    public boolean isValid(UserEntity user, ConstraintValidatorContext cvc) {
        if (user.getDateOfBirth() != null) {
            return user.getDateOfBirth().before(user.getRegistrationDate());
        }
        return true;
    }

}
