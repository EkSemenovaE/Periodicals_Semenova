package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Periodical;
import service.PeriodicalSql;
import util.ConnectionFactory;


public class PeriodicalDaoImpl implements PeriodicalDao {

    private static final String PERIODICALS_SELECT_ALL = "SELECT * FROM periodicals.periodicals";
    private static final String PERIODICALS_SELECT_BY_ID = "SELECT * FROM periodicals.periodicals WHERE id = ?";
    private static final String PERIODICALS_INSERT = "INSERT INTO periodicals.periodicals " +
            "(id, title, body, category, created_date) " + "VALUES (?, ?, ?, ?, ?)";
     private static final String PERIODICALS_DELETE_BY_ID = "DELETE FROM periodicals.periodicals WHERE id = ?";

    private int id;
    private String title;
    private String body;
    private String category;
    private Date dateAdded;


    @Override
    public boolean addPeriodical(Periodical periodical) {
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(PERIODICALS_INSERT)) {
            preparedStatement.setString(1, periodical.getTitle());
            preparedStatement.setString(2, periodical.getBody());
            preparedStatement.setString(3, periodical.getCategory());
            preparedStatement.setString(4, String.valueOf(periodical.getDateAdded()));

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
    public boolean updatePeriodical(Periodical periodical) {
        return false;
    }

    @Override
    public boolean removePeriodical(int id) {

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(PERIODICALS_DELETE_BY_ID)) {
            preparedStatement.setInt(1, id);
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
    public Periodical getPeriodicalById(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(PERIODICALS_SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            return PeriodicalSql.getPeriodical(preparedStatement.executeQuery());
        } catch (SQLException e) {

        }
        return null;
    }


    @Override
    public List<Periodical> getAllPeriodicals() throws SQLException {
        List<Periodical> list = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(PERIODICALS_SELECT_ALL)) {
             list = PeriodicalSql.getAllNPeriodicals(resultSet);
        } catch (SQLException e) {

        }
        return list;
    }
    }
