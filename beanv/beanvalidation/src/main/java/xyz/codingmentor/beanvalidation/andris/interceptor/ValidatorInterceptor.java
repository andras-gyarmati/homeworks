package xyz.codingmentor.beanvalidation.andris.interceptor;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import xyz.codingmentor.beanvalidation.andris.annotation.Validate;
import xyz.codingmentor.beanvalidation.andris.annotation.ValidatorQualifier;
import xyz.codingmentor.beanvalidation.andris.exception.ValidationException;

/**
 *
 * @author brianelete
 */
@Interceptor
@BeanValidation
public class ValidatorInterceptor {

    @Inject
    @ValidatorQualifier
    private Validator validator;

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        validateParameters(ic.getParameters());
        return ic.proceed();
    }

    private void validateParameters(Object[] parameters) {
        Arrays.asList(parameters)
                .stream()
                .filter(p -> p.getClass().isAnnotationPresent(Validate.class))
                .forEach(p -> validateBean(p));
    }

    private void validateBean(Object o) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        Optional<String> errorMessage;
        errorMessage = violations.stream().map((ConstraintViolation<Object> e) -> e.getMessage()).reduce(String::concat);
        if (errorMessage.isPresent()) {
            throw new ValidationException(errorMessage.get());
        }
    }

}
