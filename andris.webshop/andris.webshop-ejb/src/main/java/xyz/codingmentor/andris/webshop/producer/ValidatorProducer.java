package xyz.codingmentor.andris.webshop.producer;

import javax.enterprise.inject.Produces;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import xyz.codingmentor.andris.webshop.annotation.ValidatorQualifier;

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
