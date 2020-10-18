package dao;

import model.Subscription;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDaoImpl implements  SubscriptionDao{

    private static final String SUBSCRIPTION_SELECT_ALL = "SELECT * FROM periodicals.subscription";
    private static final String SUBSCRIPTION_SELECT_BY_USER_ID = "SELECT * FROM periodicals.subscription WHERE user_id = ?";
    private static final String SUBSCRIPTION_SELECT_BY_PERIODICALS_ID = "SELECT * FROM periodicals.subscription WHERE periodical_id = ?";
    private static final String SUBSCRIPTION_INSERT = "INSERT INTO periodicals.subscription " +
            "(user_id, periodical_id, subscription_added_date) " + "VALUES (?, ?, ?)";
    private static final String SUBSCRIPTION_DELETE_BY_USER_ID = "DELETE FROM periodicals.subscription WHERE user_id = ?";
    private static final String SUBSCRIPTION_DELETE_BY_PERIODICAL_ID = "DELETE FROM periodicals.subscription WHERE periodical_id = ?";


    @Override
    public boolean createSubscription(Subscription subscription) {
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SUBSCRIPTION_INSERT)) {
            preparedStatement.setInt(1, subscription.getUserId());
            preparedStatement.setInt(2, subscription.getPeriodicalId());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(subscription.dateAdded()));
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
    public boolean removeSubscriptionByUserId(int userId) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SUBSCRIPTION_DELETE_BY_USER_ID)) {
            preparedStatement.setInt(1, userId);
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
    public boolean removeSubscriptionByPeriodicalId(int periodicalId) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SUBSCRIPTION_DELETE_BY_PERIODICAL_ID)) {
            preparedStatement.setInt(1, periodicalId);
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
    public List<Subscription> getAllSubscriptionByUserId(int userId) throws SQLException {
        List<Subscription> list = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SUBSCRIPTION_SELECT_BY_USER_ID)) {
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Subscription subscription = new Subscription(resultSet.getInt(1), resultSet.getInt(2),
                            resultSet.getInt(3), resultSet.getTimestamp(4).toLocalDateTime());
                    list.add(subscription);
                }
            }
        } catch (SQLException e) {

        }
        return list;

    }

    @Override
    public List<Subscription> getAllSubscriptionByPeriodicalId(int periodicalId) throws SQLException {
        List<Subscription> list = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SUBSCRIPTION_SELECT_BY_PERIODICALS_ID)) {
            preparedStatement.setInt(1, periodicalId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Subscription subscription = new Subscription(resultSet.getInt(1), resultSet.getInt(2),
                            resultSet.getInt(3), resultSet.getTimestamp(4).toLocalDateTime());
                    list.add(subscription);
                }
            }
        } catch (SQLException e) {

        }
        return list;
    }

    @Override
    public List<Subscription> getAllSubscriptions() throws SQLException {
        List<Subscription> list = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SUBSCRIPTION_SELECT_ALL)) {
             try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Subscription subscription = new Subscription(resultSet.getInt(1), resultSet.getInt(2),
                            resultSet.getInt(3), resultSet.getTimestamp(4).toLocalDateTime());
                    list.add(subscription);
                }
            }
        } catch (SQLException e) {

        }
        return list;
    }





}

