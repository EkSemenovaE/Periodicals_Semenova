package dao;

import java.sql.SQLException;
import java.util.List;
import model.Periodical;

public interface PeriodicalDao {
    boolean createPeriodical(Periodical advert) ;
    Periodical deletePeriodical(long id);
    Periodical getPeriodicalById(long id);
    List<Periodical> getPeriodicalsByUserId(long userId) throws SQLException;
}
