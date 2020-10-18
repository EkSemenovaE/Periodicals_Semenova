package service;

import model.Periodical;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeriodicalSql {
    public static Periodical getPeriodical(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Periodical(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getTimestamp(5).toLocalDateTime());
        }
        return null;
        }

    public static List<Periodical> getAllNPeriodicals(ResultSet resultSet) throws SQLException {
        List<Periodical> list = new ArrayList<>();
        while (resultSet.next()) {
                    list.add(new Periodical(resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getTimestamp(5).toLocalDateTime()));
        }
        return list;
    }

}
