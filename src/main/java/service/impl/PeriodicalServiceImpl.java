package service.impl;

import dao.impl.PeriodicalDaoImpl;
import model.Periodical;
import service.PeriodicalService;

import java.sql.SQLException;
import java.util.List;

public class PeriodicalServiceImpl implements PeriodicalService{
    private PeriodicalDaoImpl periodicalDao = new PeriodicalDaoImpl();

    @Override
    public void createPeriodical(Periodical periodical) {
        periodicalDao.createPeriodical(periodical);
    }

    @Override
    public Periodical deletePeriodical(long periodicalId) {
        return periodicalDao.deletePeriodical(periodicalId);
    }

    @Override
    public Periodical getPeriodicalById(long periodicalId) {
        return periodicalDao.getPeriodicalById(periodicalId);
    }

    @Override
    public List<Periodical> getPeriodicalsByUser(long userId) throws SQLException {
        return periodicalDao.getPeriodicalsByUserId(userId);
    }
}
