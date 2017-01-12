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
 
    private UserDBSingleton userDB = UserDBSingleton.INSTANCE.INSTANCE;
 
    @ExcludeClassInterceptors
    public UserEntity addUser(UserEntity user) {
        UserEntity addedUser = userDB.addUser(user);
        return addedUser;
    }
 
    public UserEntity getUser(String username) {
        return userDB.getUser(username);
    }
 
    public boolean authenticate(String username, String password) {
        return userDB.authenticate(username, password);
    }
 
    public UserEntity modifyUser(UserEntity user) {
        UserEntity modifiedUser = userDB.modifyUser(user);
        return modifiedUser;
    }
 
    public UserEntity deleteUser(UserEntity user) {
        UserEntity deletedUser = userDB.deleteUser(user);
        return deletedUser;
    }
 
    public List<UserEntity> getAllUser() {
        return userDB.getAllUser();
    }
}