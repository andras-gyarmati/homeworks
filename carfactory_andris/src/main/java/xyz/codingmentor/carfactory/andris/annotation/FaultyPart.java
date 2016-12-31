package xyz.codingmentor.carfactory.andris.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author brianelete
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.TYPE,       
})
public @interface FaultyPart {
    String description();
}
