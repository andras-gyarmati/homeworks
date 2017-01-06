package xyz.codingmentor.confusing.andris.reflection;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.confusing.andris.annotation.Confusing;

/**
 *
 * @author brianelete
 */
public class Reflection {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    private Reflection() {
        //empty
    }

    public static void analyze(final Class<?> clazz) {
        Confusing annotationClass = clazz.getAnnotation(Confusing.class);
        if (null != annotationClass) {
            LOGGER.log(Level.INFO, "Class name: {0}, Package: {1}, Super class: {2}, Methods: ", new Object[]{clazz.getName(), clazz.getPackage(), clazz.getSuperclass()});
        }

        for (final Method method : clazz.getDeclaredMethods()) {
            Confusing annotationMethod = method.getAnnotation(Confusing.class);
            if (null != annotationMethod) {
                LOGGER.log(Level.INFO, "name: {0}, parameters: {2}, return type: {2}", new Object[]{method.getName(), method.getParameterCount(), method.getReturnType()});
            }
        }
    }
}
