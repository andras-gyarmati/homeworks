package xyz.codingmentor.andris.webshop.database;

import java.io.Serializable;
import xyz.codingmentor.andris.webshop.exceptions.UserNotFoundException;
import xyz.codingmentor.andris.webshop.exceptions.UsernameTakenException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import xyz.codingmentor.andris.webshop.bean.UserEntity;
import xyz.codingmentor.andris.webshop.exceptions.AuthenticationFailureException;
import xyz.codingmentor.andris.webshop.interceptor.ValidatorInterceptor;

/**
 *
 * @author brianelete
 */
@Singleton
@Interceptors(ValidatorInterceptor.class)
public class UserDB implements Serializable {

    private final Map<String, UserEntity> USERS = new HashMap<>();

    public UserDB() {
        //empty
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

    public UserEntity authenticateUser(UserEntity user) throws AuthenticationFailureException {
        if (!USERS.containsKey(user.getUsername()) || !user.getPassword().equals(USERS.get(user.getUsername()).getPassword())) {
            throw new AuthenticationFailureException();
        }
        return USERS.get(user.getUsername());
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
        return new ArrayList(USERS.values());
    }
}
