package xyz.codingmentor.beanvalidation.andris.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *
 * @author brianelete
 */
public class UserDB {

    private Map<String, UserEntity> users = new HashMap<>();

    public UserDB() {
        // empty
    }

    public UserEntity addUser(UserEntity user) {
        if (null != users.get(user.getUsername())) {
            throw new IllegalArgumentException("Error! Username is taken.");
        }
        Date currentDate = new Date();
        user.setRegistrationDate(currentDate);
        user.setLastModifiedDate(currentDate);
        this.users.put(user.getUsername(), user);
        return user;
    }

    public UserEntity getUser(String username) {
        if (null == users.get(username)) {
            throw new NoSuchElementException();
        }
        return users.get(username);
    }

    public boolean authenticate(String username, String password) {
        UserEntity user = users.get(username);
        return null != user && user.getPassword().equals(password);
    }

    public UserEntity modifyUser(UserEntity user) {
        if (null == users.get(user.getUsername())) {
            throw new NoSuchElementException();
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
