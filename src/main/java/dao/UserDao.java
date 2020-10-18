package dao;

import java.sql.SQLException;
import model.User;

import java.util.List;



public interface UserDao {
    boolean addUser(User user);
    User getUser(int id);
    boolean updateUser(User user);
    boolean removeUser(int id);
    List<User> getAllUsers();


}
