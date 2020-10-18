package dao;

import model.Periodical;
import model.Subscription;
import model.User;

import java.sql.SQLException;
import java.util.List;

public interface SubscriptionDao {
    boolean createSubscription(Subscription subscription);
    boolean removeSubscriptionByUserId(int userId);
    boolean removeSubscriptionByPeriodicalId(int periodicalId);
    List<Subscription> getAllSubscriptionByUserId(int userId) throws SQLException;
    List<Subscription> getAllSubscriptionByPeriodicalId(int periodicalId) throws SQLException;
    List<Subscription> getAllSubscriptions() throws SQLException;

}
