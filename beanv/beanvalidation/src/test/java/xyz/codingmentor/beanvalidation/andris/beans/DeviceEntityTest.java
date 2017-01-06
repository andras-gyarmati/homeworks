package xyz.codingmentor.beanvalidation.andris.beans;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author brianelete
 */
public class DeviceEntityTest {

    private static ValidatorFactory vf;
    private static Validator validator;

    private DeviceEntity deviceEntity;

    @BeforeClass
    public static void init() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }

    @AfterClass
    public static void close() {
        vf.close();
    }

    @Test
    public void shouldRaiseNoConstraintViolationAppleColors() {
        deviceEntity = new DeviceEntity("12345678_12345678_12345678_123456789", Manufacturer.APPLE, "Six", 240000, Color.BLACK, 0);
        deviceEntity = new DeviceEntity("12345678_12345678_12345678_123456789", Manufacturer.APPLE, "Seven", 290000, Color.WHITE, 0);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void shouldRaiseConstraintViolationAppleColors() {
        deviceEntity = new DeviceEntity("12345678_12345678_12345678_123456789", Manufacturer.APPLE, "Six", 240000, Color.RED, 0);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{DeviceColor.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void shouldRaiseNoConstraintViolationSamsungColors() {
        deviceEntity = new DeviceEntity("12345678_12345678_12345678_123456789", Manufacturer.SAMSUNG, "Galaxy S2", 500, Color.BLUE, 0);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void shouldRaiseConstraintViolationSamsungColors() {
        deviceEntity = new DeviceEntity("12345678_12345678_12345678_123456789", Manufacturer.SAMSUNG, "Galaxy S2", 500, Color.GREEN, 0);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(deviceEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{DeviceColor.message}", violations.iterator().next().getMessageTemplate());
    }
}
