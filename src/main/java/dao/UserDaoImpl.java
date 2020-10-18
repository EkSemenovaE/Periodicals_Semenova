package dao;
import service.UserSql;
import util.ConnectionFactory;
import model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


    private static final String USERS_SELECT_ALL = "SELECT * FROM periodicals.users";
    private static final String USER_INSERT = "INSERT INTO periodicals.users (first_name, last_name, email, phone) " + "VALUES (?, ?, ?, ?)";
    private static final String USER_SELECT_BY_ID = "SELECT * FROM periodicals.users WHERE id = ?";
    private static final String USER_DELETE_BY_ID = "DELETE FROM periodicals.users WHERE id = ?";
    private static final String USER_UPDATE_BY_ID = "UPDATE periodicals.users SET first_name = ?, last_name = ?, email = ?, phone = ? WHERE id = ?";

    @Override
    public boolean addUser(User user) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(USER_INSERT)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            if (preparedStatement.executeUpdate() > 0) {
               return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
           return false;
        }
    }

    @Override
    public User getUser(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(USER_SELECT_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
        //    return new UserService(); TODO
        } catch (SQLException e) {

        }
        return null;
    }

    @Override
    public boolean updateUser(User user) {


        if (getUser(user.getId()) != null) {
            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(USER_UPDATE_BY_ID)) {
                preparedStatement.setString(1, user.getFirstName());
                preparedStatement.setString(2, user.getLastName());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPhone());
                preparedStatement.setInt(5, user.getId());
                if (preparedStatement.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException e) {
                return false;
            }
        } else {

            return false;
        }
        return false;

    }

    @Override
    public boolean removeUser(int id) {
        if (getUser(id) != null) {
            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(USER_DELETE_BY_ID)) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
                return true;
            } catch (SQLException e) {

                return false;
            }
        } else
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();


        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(USERS_SELECT_ALL)) {
             list = UserSql.getAllUsers(resultSet);

                    }
        catch (SQLException e) {

        }
        return list;
    }
    }


