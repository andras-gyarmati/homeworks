package xyz.codingmentor.beanvalidation.andris.beans;

import xyz.codingmentor.beanvalidation.andris.bean.UserEntity;
import xyz.codingmentor.beanvalidation.andris.enums.Sex;
import xyz.codingmentor.beanvalidation.andris.exception.UserNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import xyz.codingmentor.beanvalidation.andris.database.UserDB;

/**
 *
 * @author brianelete
 */
public class UserDBTest {

    private static UserDB userDB;

    public UserDBTest() {
        // empty
    }

    @BeforeClass
    public static void init() {
        userDB = new UserDB();
    }

    @Before
    public void initDB() {
        List<UserEntity> users = userDB.getAllUser();
        for (UserEntity user : users) {
            userDB.deleteUser(user);
        }
    }

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

    @Test
    public void addUser() {
        Assert.assertEquals(0, userDB.getAllUser().size());
        userDB.addUser(initUser());
        Assert.assertEquals(1, userDB.getAllUser().size());
    }

    @Test
    public void getUser() {
        UserEntity user = initUser();
        userDB.addUser(user);
        Assert.assertEquals(user, userDB.getUser(user.getUsername()));
    }

    @Test
    public void authenticate() {
        UserEntity user = initUser();
        userDB.addUser(user);
        Assert.assertTrue(userDB.authenticate(user.getUsername(), user.getPassword()));
    }

    @Test
    public void modifyUser() {
        UserEntity user = initUser();
        userDB.addUser(user);
        String newPhone = "06987654321";
        user.setPhone(newPhone);
        Assert.assertEquals(newPhone, userDB.modifyUser(user).getPhone());
    }

    @Test
    public void removeUser() {
        UserEntity user = initUser();
        userDB.addUser(user);
        userDB.deleteUser(user);
        Assert.assertEquals(0, userDB.getAllUser().size());
    }

    @Test(expected = UserNotFoundException.class)
    public void removeUserFromEmpty() {
        userDB.deleteUser(initUser());
    }

    @Test
    public void getAllUser() {
        userDB.addUser(initUser());
        UserEntity user2 = initUser();
        user2.setUsername("johndoe");
        userDB.addUser(user2);
        Assert.assertEquals(2, userDB.getAllUser().size());
    }

    private Date daysBefore(int days) {
        Calendar pastDate = Calendar.getInstance();
        pastDate.add(Calendar.DAY_OF_YEAR, -days);
        return pastDate.getTime();
    }
}
