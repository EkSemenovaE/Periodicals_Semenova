package service;

import dao.PeriodicalDaoImpl;
import dao.SubscriptionDaoImpl;
import model.Periodical;
import model.Subscription;

import java.sql.SQLException;
import java.util.List;

public class SubscriptionService {
    private final SubscriptionDaoImpl subscriptionDao = new SubscriptionDaoImpl();

    public List<Subscription> getSubscriptionByUserId(int userId) throws SQLException {
        return subscriptionDao.getAllSubscriptionByUserId(userId);
    }

    public List<Subscription> getSubscriptionByPeriodicalId(int periodicalId) throws SQLException {
        return subscriptionDao.getAllSubscriptionByPeriodicalId(periodicalId);
    }

    public List<Subscription> getAllSubscription() throws SQLException {
        return subscriptionDao.getAllSubscriptions();
    }

    public boolean createSubscription(Subscription subscription) {
        return subscriptionDao.createSubscription(subscription);
    }

    public boolean removeSubscriptionByPeriodicalId(int periodicalId) {

        return subscriptionDao.removeSubscriptionByPeriodicalId(periodicalId);
    }

    public boolean removeSubscriptionByUserId(int userId) {

        return subscriptionDao.removeSubscriptionByUserId(userId);
    }





}
