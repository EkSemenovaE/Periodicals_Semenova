package service;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSql {
    private UserSql() {};

    public static User getUser(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new User(resultSet.getInt(1),
            resultSet.getString(2), resultSet.getString(3),resultSet.getString(4), resultSet.getString(5));
        }
        return null;
    }

    public static List<User> getAllUsers(ResultSet resultSet) throws SQLException {
        List<User> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new User(resultSet.getInt(1),
                    resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5)));
        }
        return list;
    }
}
