package service;

import java.sql.SQLException;
import java.util.List;
import model.User;
import model.Periodical;

public interface UserService {
    void createUser(User user) ;
    User deleteUser(long userId);
    User getById(long userId);
    List<User> getAll();
}
