package repository;

import entity.Club;
import entity.SortByScore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FootballClubRepository extends MyConnection {
    public FootballClubRepository() throws SQLException {
    }

    public void creatFootballClubTable() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("create table footballclubtbl" +
                "( name varchar(50) not null," + " numberOfPlay int not null," + " numberOfWin int not null," +
                " numberOfLost int," + " numberOfEqual int, " + " drawGoal int," + " forGoal int, " +
                " score int )");
        preparedStatement.executeUpdate();
    }

    public void addClub(Club club) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into footballclubtbl" +
                " values (?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, club.getName());
        preparedStatement.setInt(2, club.getNumberOfPlay());
        preparedStatement.setInt(3, club.getNumberOfWin());
        preparedStatement.setInt(4, club.getNumberOfLost());
        preparedStatement.setInt(5, club.getNumberOfEqual());
        preparedStatement.setInt(6, club.getDrawGoal());
        preparedStatement.setInt(7, club.getForGoal());
        preparedStatement.setInt(8, club.getScore());

        preparedStatement.executeUpdate();
    }

    public void deleteClub(String clubName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from footballclubtbl" +
                " where name=?");
        preparedStatement.setString(1, clubName);
        preparedStatement.executeUpdate();
    }

    public Club viewClubInformation(String clubName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from footballclubtbl" +
                " where name=?");
        preparedStatement.setString(1, clubName);
        ResultSet resultSet = preparedStatement.executeQuery();
        Club resultClub = null;
        while (resultSet.next()) {
            resultClub = new Club(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getInt(7),
                    resultSet.getInt(8)
            );
        }
        return resultClub;
    }

    public List<Club> showFootballClubSorted() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from footballclubtbl");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Club> clubList = new ArrayList<>();
        Club resultClub;

        while (resultSet.next()) {
            resultClub = new Club(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getInt(7),
                    resultSet.getInt(8)
            );
            clubList.add(resultClub);
        }
        Collections.sort(clubList, new SortByScore());
        return clubList;
    }
    public void updateClub(Club club) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update footballclubtbl " +
                "set numberOfPlay=?,numberOfWin=?,numberOfLost=?," +
                "numberOfEqual=?,drawGoal=?,forGoal=?,score=? where name=? ");

        preparedStatement.setInt(1, club.getNumberOfPlay());
        preparedStatement.setInt(2, club.getNumberOfWin());
        preparedStatement.setInt(3, club.getNumberOfLost());
        preparedStatement.setInt(4, club.getNumberOfEqual());
        preparedStatement.setInt(5, club.getDrawGoal());
        preparedStatement.setInt(6, club.getForGoal());
        preparedStatement.setInt(7, club.getScore());
        preparedStatement.setString(8, club.getName());
    }
}