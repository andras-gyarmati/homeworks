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

    @BeforeClass
    public static void init() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }

    @AfterClass
    public static void close() {
        vf.close();
    }

    public Date beforeAfterDays(int days) {
        Calendar beforeDays = Calendar.getInstance();
        beforeDays.add(Calendar.DAY_OF_YEAR, days);
        return beforeDays.getTime();
    }

    @Test
    public void positiveTestBothNullOrRequired() {

        Date registrationDate = beforeAfterDays(-2);
        Date dateOfBirth = beforeAfterDays(-3);

        userEntity = new UserEntity.Builder()
                .username("adamDomafoldi")
                .password("adaM123=")
                .firstname("asd")
                .lastname("asd")
                .address("0000Törökbálint")
                .phone("06306849277")
                .email("email@rmail.com")
                .sex(Sex.MALE)
                .registrationDate(registrationDate)
                .lastModifiedDate(registrationDate)
                .dateOfBirth(dateOfBirth)
                .build();

        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);

        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void negativeTestBothNullOrRequired() {

        Date registrationDate = beforeAfterDays(-2);
        Date dateOfBirth = beforeAfterDays(-3);

        userEntity = new UserEntity.Builder()
                .username("adamDomafoldi")
                .password("adaM123=")
                .firstname("asd")
                .lastname(null)
                .address("0000Törökbálint")
                .phone("06306849277")
                .email("email@rmail.com")
                .sex(Sex.MALE)
                .registrationDate(registrationDate)
                .lastModifiedDate(registrationDate)
                .dateOfBirth(dateOfBirth)
                .build();

        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);

        Assert.assertEquals(1, violations.size());

        Assert.assertEquals("{Name.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void positiveTestPassword() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validateValue(UserEntity.class, "password", "adaM123=");
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void negativeTestPassword() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validateValue(UserEntity.class, "password", "adaM123255");
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void positiveTestAddres() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validateValue(UserEntity.class, "address", "0000Törökbálint");

        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void negativeTestAddres() {

        Set<ConstraintViolation<UserEntity>> violations = validator.validateValue(UserEntity.class, "address", "000Törökbálint");

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void positiveTestPhone() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validateValue(UserEntity.class, "phone", "06306849277");

        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void negativeTestPhone() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validateValue(UserEntity.class, "phone", "006306849277");

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void positiveTestBornBeforeRegister() {

        Date registrationDate = beforeAfterDays(-2);
        Date dateOfBirth = beforeAfterDays(-3);
        userEntity = new UserEntity.Builder()
                .username("adamDomafoldi")
                .password("adaM123=")
                .firstname(null)
                .lastname(null)
                .address("0000Törökbálint")
                .phone("06306849277")
                .email("email@rmail.com")
                .sex(Sex.MALE)
                .registrationDate(registrationDate)
                .lastModifiedDate(registrationDate)
                .dateOfBirth(dateOfBirth)
                .build();

        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        Assert.assertEquals(0, violations.size());

    }

    @Test
    public void negativeTestBornBeforeRegister() {

        Date registrationDate = beforeAfterDays(-3);
        Date dateOfBirth = beforeAfterDays(-2);
        userEntity = new UserEntity.Builder()
                .username("adamDomafoldi")
                .password("adaM123=")
                .firstname(null)
                .lastname(null)
                .address("0000Törökbálint")
                .phone("06306849277")
                .email("email@rmail.com")
                .sex(Sex.MALE)
                .registrationDate(registrationDate)
                .lastModifiedDate(registrationDate)
                .dateOfBirth(dateOfBirth)
                .build();

        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);

        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{BirthDate.message}", violations.iterator().next().getMessageTemplate());
    }
}
