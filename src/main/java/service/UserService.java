package service;

import java.util.List;

import dao.UserDao;
import model.User;

public class UserService{
    private final UserDao userDao = new UserDao() {
        @Override
        public boolean addUser(User user) {
            return userDao.addUser(user);
        }

        @Override
        public User getUser(int id) {
            return userDao.getUser(id);
        }

        @Override
        public boolean updateUser(User user) {
            return userDao.updateUser(user);
        }

        @Override
        public boolean removeUser(int id) {
            return userDao.removeUser(id);
        }

        @Override
        public List<User> getAllUsers() {
            return userDao.getAllUsers();
        }
    };


}
