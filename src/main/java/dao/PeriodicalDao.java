package dao;

import java.sql.SQLException;
import java.util.List;
import model.Periodical;

public interface PeriodicalDao {
    boolean addPeriodical(Periodical periodical);
    boolean updatePeriodical(Periodical periodical);
    boolean removePeriodical(int id);
    Periodical getPeriodicalById(int id);
    List<Periodical> getAllPeriodicals() throws SQLException;




}
