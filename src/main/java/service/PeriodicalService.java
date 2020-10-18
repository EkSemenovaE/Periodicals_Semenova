package service;

import dao.PeriodicalDaoImpl;
import model.Periodical;

import java.sql.SQLException;
import java.util.List;

public class PeriodicalService{

    private final PeriodicalDaoImpl periodicalDao = new PeriodicalDaoImpl();

    public Periodical getPeriodicalByID(int id) {
        return periodicalDao.getPeriodicalById(id);
    }

    public List<Periodical> getAllPeriodicals() throws SQLException {
        return periodicalDao.getAllPeriodicals();
    }

    public boolean addPeriodical(Periodical periodical) {
        return periodicalDao.addPeriodical(periodical);
    }

    public boolean updatePeriodical(Periodical periodical) {
        return periodicalDao.updatePeriodical(periodical);
    }

    public boolean removePeriodical(int id) {
        return periodicalDao.removePeriodical(id);
    }
    }








