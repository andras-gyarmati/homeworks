package xyz.codingmentor.beanvalidation.andris.database;

import xyz.codingmentor.beanvalidation.andris.exception.UserNotFoundException;
import xyz.codingmentor.beanvalidation.andris.exception.UsernameTakenException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import xyz.codingmentor.beanvalidation.andris.bean.UserEntity;
import xyz.codingmentor.beanvalidation.andris.interceptor.ValidatorInterceptor;

/**
 *
 * @author brianelete
 */
@Interceptors(ValidatorInterceptor.class)
public class UserDB {

    private static final Map<String, UserEntity> USERS = new HashMap<>();

    public UserDB() {
        // empty
    }

    @ExcludeClassInterceptors
    public UserEntity addUser(UserEntity user) {
        if (null != USERS.get(user.getUsername())) {
            throw new UsernameTakenException("Error! Username is taken.");
        }
        Date currentDate = new Date();
        user.setRegistrationDate(currentDate);
        user.setLastModifiedDate(currentDate);
        USERS.put(user.getUsername(), user);
        return user;
    }

    public UserEntity getUser(String username) {
        if (null == USERS.get(username)) {
            throw new UserNotFoundException("Error! User: " + username + " is can not be found!");
        }
        return USERS.get(username);
    }

    public boolean authenticate(String username, String password) {
        UserEntity user = USERS.get(username);
        return null != user && user.getPassword().equals(password);
    }

    public UserEntity modifyUser(UserEntity user) {
        if (null == USERS.get(user.getUsername())) {
            throw new UserNotFoundException("Error! User: " + user.getUsername() + " is can not be found!");
        }
        Date currentDate = new Date();
        user.setLastModifiedDate(currentDate);
        USERS.put(user.getUsername(), user);
        return USERS.get(user.getUsername());
    }

    public UserEntity deleteUser(UserEntity user) {
        UserEntity deletedUser = getUser(user.getUsername());
        USERS.remove(user.getUsername());
        return deletedUser;
    }

    public List<UserEntity> getAllUser() {
        List<UserEntity> userList = new ArrayList();
        userList.addAll(USERS.values());
        return userList;
    }
}
