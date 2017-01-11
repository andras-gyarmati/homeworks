package xyz.codingmentor.beanvalidation.andris.beans;

import xyz.codingmentor.beanvalidation.andris.exception.UserNotFoundException;
import xyz.codingmentor.beanvalidation.andris.exception.UsernameTakenException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import xyz.codingmentor.beanvalidation.andris.interceptor.BeanValidation;
import xyz.codingmentor.beanvalidation.andris.interceptor.ValidatorInterceptor;

/**
 *
 * @author brianelete
 */
@BeanValidation
@Interceptors(ValidatorInterceptor.class)
public class UserDB {

    private Map<String, UserEntity> users = new HashMap<>();

    public UserDB() {
        // empty
    }

    @ExcludeClassInterceptors
    public UserEntity addUser(UserEntity user) {
        if (null != users.get(user.getUsername())) {
            throw new UsernameTakenException("Error! Username is taken.");
        }
        Date currentDate = new Date();
        user.setRegistrationDate(currentDate);
        user.setLastModifiedDate(currentDate);
        this.users.put(user.getUsername(), user);
        return user;
    }

    public UserEntity getUser(String username) {
        if (null == users.get(username)) {
            throw new UserNotFoundException("Error! User: " + username + " is can not be found!");
        }
        return users.get(username);
    }

    public boolean authenticate(String username, String password) {
        UserEntity user = users.get(username);
        return null != user && user.getPassword().equals(password);
    }

    public UserEntity modifyUser(UserEntity user) {
        if (null == users.get(user.getUsername())) {
            throw new UserNotFoundException("Error! User: " + user.getUsername() + " is can not be found!");
        }
        Date currentDate = new Date();
        user.setLastModifiedDate(currentDate);
        users.put(user.getUsername(), user);
        return users.get(user.getUsername());
    }

    public UserEntity deleteUser(UserEntity user) {
        UserEntity deletedUser = getUser(user.getUsername());
        users.remove(user.getUsername());
        return deletedUser;
    }

    public List<UserEntity> getAllUser() {
        List<UserEntity> userList = new ArrayList();
        userList.addAll(users.values());
        return userList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.users);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserDB other = (UserDB) obj;
        if (!Objects.equals(this.users, other.users)) {
            return false;
        }
        return true;
    }
}
