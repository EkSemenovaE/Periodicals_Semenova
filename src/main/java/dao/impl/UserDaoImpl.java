package dao.impl;

import dao.UserDao;
import util.ConnectionFactory;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void createUser(User user) {
        try (Connection cn = ConnectionFactory.getConnection();
             PreparedStatement ps = cn.prepareStatement("INSERT INTO users (name, surname, email, phone) " +
                     "VALUES (?, ?, ?, ?")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());

            int i = ps.executeUpdate();

            if (i != 1) {
                throw new SQLException("Some text about user");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User deleteUser(long userId) {
        try (Connection cn = ConnectionFactory.getConnection();
             Statement st = cn.createStatement();
             PreparedStatement ps = cn.prepareStatement("DELETE FROM users WHERE id=?")) {

            ps.setLong(1, userId);
            User user = getUserById(userId);

            int i = ps.executeUpdate();
            if (i == 1) {
                return user;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }



    @Override
    public User getUserById(long userId) {
        try {
            Connection cn = ConnectionFactory.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE id=" + userId);

            while (rs.next()) {
                return parseResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        try (Connection cn = ConnectionFactory.getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM users")) {

            List<User> users = new ArrayList<User>();
            while (rs.next()) {
                users.add(parseResultSet(rs));
            }

            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    private User parseResultSet(ResultSet rs) {
        try {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            return user;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
