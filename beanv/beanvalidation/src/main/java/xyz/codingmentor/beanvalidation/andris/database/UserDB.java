package xyz.codingmentor.beanvalidation.andris.database;

import java.util.List;
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

    private final UserDBSingleton userDBSingleton;

    public UserDB() {
        this.userDBSingleton = UserDBSingleton.INSTANCE;
    }

    @ExcludeClassInterceptors
    public UserEntity addUser(UserEntity user) {
        return userDBSingleton.addUser(user);
    }

    public UserEntity getUser(String username) {
        return userDBSingleton.getUser(username);
    }

    public boolean authenticate(String username, String password) {
        return userDBSingleton.authenticate(username, password);
    }

    public UserEntity modifyUser(UserEntity user) {
        return userDBSingleton.modifyUser(user);
    }

    public UserEntity deleteUser(UserEntity user) {
        return userDBSingleton.deleteUser(user);
    }

    public List<UserEntity> getAllUser() {
        return userDBSingleton.getAllUser();
    }
}
