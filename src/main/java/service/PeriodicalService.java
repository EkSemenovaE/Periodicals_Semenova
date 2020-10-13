package service;

import model.Periodical;
import model.User;

import java.sql.SQLException;
import java.util.List;

public interface PeriodicalService {
    void createPeriodical(Periodical periodical) ;
    Periodical deletePeriodical(long periodicalId);
    Periodical getPeriodicalById(long periodicalId);
    List<Periodical> getPeriodicalsByUser(long userId) throws SQLException;
}
