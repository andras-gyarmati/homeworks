package xyz.codingmentor.beanvalidation.andris.database;

import java.io.IOException;
import xyz.codingmentor.beanvalidation.andris.exception.UsernameTakenException;
import xyz.codingmentor.beanvalidation.andris.exception.UserNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.codingmentor.beanvalidation.andris.bean.UserEntity;

/**
 *
 * @author brianelete
 */
public enum UserDBSingleton {

    INSTANCE;

    private final Map<String, UserEntity> users = new HashMap<>();

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
        return new ArrayList(users.values());
    }
    
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        //sonar
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        //sonar
    }
}
