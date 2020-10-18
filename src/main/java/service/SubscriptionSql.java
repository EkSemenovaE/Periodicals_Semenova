package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Subscription;

public class SubscriptionSql {
    private  SubscriptionSql() {}


    public static Subscription getSubscription(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Subscription(resultSet.getInt(1), resultSet.getInt(2),
                    resultSet.getInt(3), resultSet.getTimestamp(4).toLocalDateTime());
        }
        return null;
    }

    public static List<Subscription> getAllSubscriptions(ResultSet resultSet) throws SQLException {
        List<Subscription> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new Subscription(resultSet.getInt(1), resultSet.getInt(2),
                    resultSet.getInt(3), resultSet.getTimestamp(4).toLocalDateTime()));
        }
        return list;
    }


}


