package xyz.codingmentor.beanvalidation.andris.producer;

import javax.enterprise.inject.Produces;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import xyz.codingmentor.beanvalidation.andris.annotation.ValidatorQualifier;

/**
 *
 * @author brianelete
 */
public class ValidatorProducer {
    
    @Produces @ValidatorQualifier
    public Validator produceLogger() {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        return vf.getValidator();
    }
}
