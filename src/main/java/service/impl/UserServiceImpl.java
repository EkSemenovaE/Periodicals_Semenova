package service.impl;

import java.sql.SQLException;
import java.util.List;
import dao.PeriodicalDao;
import dao.UserDao;
import dao.impl.PeriodicalDaoImpl;
import dao.impl.UserDaoImpl;
import model.Periodical;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDaoImpl = new UserDaoImpl();

    @Override
    public void createUser(User user) {
        userDaoImpl.createUser(user);
    }

    @Override
    public User deleteUser(long userId) {
        return userDaoImpl.deleteUser(userId);
    }

    @Override
    public User getById(long userId) {
        return userDaoImpl.getUserById(userId);
    }

    @Override
    public List<User> getAll() {
        return userDaoImpl.getAllUsers();
    }
}
