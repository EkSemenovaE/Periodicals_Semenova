package dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dao.PeriodicalDao;
import model.Periodical;
import util.ConnectionFactory;


public class PeriodicalDaoImpl implements PeriodicalDao {
    @Override
    public boolean createPeriodical(Periodical periodical) {
        try (Connection cn = ConnectionFactory.getConnection();
             PreparedStatement ps = cn.prepareStatement("INSERT INTO periodicals (user_id, title, body, category) " +
                     "VALUES (?, ?, ?, ?)")) {
            ps.setInt(1, periodical.getUserId());
            ps.setString(2, periodical.getTitle());
            ps.setString(3, periodical.getBody());
            ps.setString(4, periodical.getCategory());


            int i = ps.executeUpdate();

            if (i != 1) {
                throw new SQLException();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return true;
    }

    @Override
    public Periodical deletePeriodical(long periodicalId) {
        try (Connection cn = ConnectionFactory.getConnection();
             Statement st = cn.createStatement();
             PreparedStatement ps = cn.prepareStatement("DELETE FROM periodicals WHERE id=?")) {

            ps.setLong(1, periodicalId);
            Periodical periodical = getPeriodicalById(periodicalId);

            int i = ps.executeUpdate();
            if (i == 1) {
                return periodical;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Periodical getPeriodicalById(long periodicalId) {
        try {
            Connection cn = ConnectionFactory.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM periodicals WHERE id=" + periodicalId);

            while (rs.next()) {
                return parseResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Periodical> getPeriodicalsByUserId(long userId) throws SQLException {
        Connection cn = ConnectionFactory.getConnection();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM periodicals WHERE user_id=" + userId);

        List<Periodical> list = new ArrayList();
        while (rs.next()) {
            list.add(parseResultSet(rs));
        }

        return list;
    }


    private Periodical parseResultSet(ResultSet rs) throws SQLException {
        Periodical periodical = new Periodical();
        periodical.setId(rs.getInt("id"));
        periodical.setUserId(rs.getInt("user_id"));
        periodical.setTitle(rs.getString("title"));
        periodical.setBody(rs.getString("body"));
        periodical.setCategory(rs.getString("category"));
        periodical.setCreated(rs.getDate("created"));
        return periodical;
    }

}
