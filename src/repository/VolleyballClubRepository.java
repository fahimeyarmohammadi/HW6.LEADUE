package repository;


import entity.VolleyballClub;
import entity.VolleyballSortByScore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VolleyballClubRepository extends MyConnection {
    public VolleyballClubRepository() throws SQLException {
    }

    public void creatVolleyballClubTable() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("create table volleyballclubtbl" +
                " ( name varchar(50) not null,numberOfPlay int, numberOfWin int, numberOfLost int , " +
                " numberOfSetWin int , numberOfSetLost int ,score int)");
        preparedStatement.executeUpdate();
    }

    public void addVolleyballClub(VolleyballClub club) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into  volleyballclubtbl" +
                " values (?,?,?,?,?,?,?)");
        preparedStatement.setString(1, club.getName());
        preparedStatement.setInt(2, club.getNumberOfPlay());
        preparedStatement.setInt(3, club.getNumberOfWin());
        preparedStatement.setInt(4, club.getNumberOfLost());
        preparedStatement.setInt(5, club.getNumberOfSetWin());
        preparedStatement.setInt(6, club.getNumberOfSetLost());
        preparedStatement.setInt(7, club.getScore());

        preparedStatement.executeUpdate();
    }

    public void deleteVolleyballClub(String clubName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from volleyballclubtbl" +
                " where name=?");
        preparedStatement.setString(1, clubName);
        preparedStatement.executeUpdate();
    }

    public VolleyballClub viewVolleyballClubInformation(String clubName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from volleyballclubtbl" +
                " where name=?");
        preparedStatement.setString(1, clubName);
        ResultSet resultSet = preparedStatement.executeQuery();
        VolleyballClub resultClub = null;
        while (resultSet.next()) {
            resultClub = new VolleyballClub(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getInt(7)
            );
        }
        return resultClub;
    }

    public List<VolleyballClub> showVolleyballClubSorted() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from volleyballclubtbl");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<VolleyballClub> clubList = new ArrayList<>();
        VolleyballClub resultClub;

        while (resultSet.next()) {
            resultClub = new VolleyballClub(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getInt(7)
            );
            clubList.add(resultClub);
        }
        return clubList;
    }

    public void updateVolleyballClub(VolleyballClub club) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update volleyballclubtbl " +
                "set numberOfPlay=?,numberOfWin=?,numberOfLost=?," +
                " numberOfSetWin=?,numberOfSetLost=?,score=? where name=?; ");
        preparedStatement.setInt(1, club.getNumberOfPlay());
        System.out.println(club.getNumberOfPlay());
        preparedStatement.setInt(2, club.getNumberOfWin());
        System.out.println(club.getNumberOfWin());
        preparedStatement.setInt(3, club.getNumberOfLost());
        System.out.println(club.getNumberOfLost());
        preparedStatement.setInt(4, club.getNumberOfSetWin());
        preparedStatement.setInt(5, club.getNumberOfSetLost());
        preparedStatement.setInt(6, club.getScore());
        preparedStatement.setString(7, club.getName());
        preparedStatement.executeUpdate();
    }

    public boolean isExist(String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select from volleyballclubtbl" +
                " where name = ?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        return(resultSet.next());
    }
}