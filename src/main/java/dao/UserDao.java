package dao;

import java.sql.SQLException;
import model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user) ;
    User deleteUser(long userId);
    User getUserById(long userId) ;
    List<User> getAllUsers() ;
}
