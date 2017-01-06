package xyz.codingmentor.beanvalidation.andris.beans;

import java.util.Calendar;
import java.util.Date;
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
public class UserEntityTest {

    private static ValidatorFactory vf;
    private static Validator validator;

    private UserEntity userEntity;
    
    public UserEntity initUser() {
        Date registrationDate = daysBefore(1);
        Date dateOfBirth = daysBefore(7);
        UserEntity user = new UserEntity.Builder()
                .username("brianelete")
                .password("Pa++w0rd")
                .firstname("John")
                .lastname("Doe")
                .address("1111Budapest")
                .phone("06123456789")
                .email("someone@example.com")
                .sex(Sex.MALE)
                .registrationDate(registrationDate)
                .lastModifiedDate(registrationDate)
                .dateOfBirth(dateOfBirth)
                .build();
        return user;
    }

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
    public void shouldRaiseNoConstraintViolationFirstnameLastnameNull() {
        userEntity = initUser();
        userEntity.setFirstname(null);
        userEntity.setLastname(null);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void shouldRaiseConstraintViolationFirstnameLastnameNull() {
        userEntity = initUser();
        userEntity.setLastname(null);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{Name.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void shouldRaiseNoConstraintViolationPassword() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validateValue(UserEntity.class, "password", "Pa++w0rd");
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void shouldRaiseConstraintViolationPassword() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validateValue(UserEntity.class, "password", "pwA123");
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void shouldRaiseNoConstraintViolationAddres() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validateValue(UserEntity.class, "address", "1111Budapest");
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void shouldRaiseConstraintViolationAddres() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validateValue(UserEntity.class, "address", "Budapest1111");
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void shouldRaiseNoConstraintViolationPhone() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validateValue(UserEntity.class, "phone", "06123456789");
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void shouldRaiseConstraintViolationPhone() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validateValue(UserEntity.class, "phone", "006123456789");
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void shouldRaiseNoConstraintViolationBirthDate() {
        userEntity = initUser();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void shouldRaiseConstraintViolationBirthDate() {
        userEntity = initUser();
        userEntity.setDateOfBirth(daysBefore(0));
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{BirthDate.message}", violations.iterator().next().getMessageTemplate());
    }
    
    private Date daysBefore(int days) {
        Calendar pastDate = Calendar.getInstance();
        pastDate.add(Calendar.DAY_OF_YEAR, -days);
        return pastDate.getTime();
    }
}
