package repository;

import entity.Play;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FootballPlayRepository extends MyConnection {

    public FootballPlayRepository() throws SQLException {
    }

    public void creatFootballPlayTable() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("create table footballplaytbl" +
                "( firstClub varchar(50) not null, " + " secondClub varchar(50) not null," + " numberOfGoalClub1 int not null," +
                " numberOfGoalClub2 int not null, status varchar(10) not null )");
        preparedStatement.executeUpdate();
    }

    public void insertPlay(Play play) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into footballplaytbl " +
                " values(?,?,?,?,?)");
        preparedStatement.setString(1, play.getFirstClub());
        preparedStatement.setString(2, play.getSecondClub());
        preparedStatement.setInt(3, play.getNumberOfGoalClub1());
        preparedStatement.setInt(4, play.getNumberOfGoalClub2());
        preparedStatement.setString(5, play.getStatuse().toString());
        preparedStatement.executeUpdate();
    }

    public List<Play> selectByName(String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from footballplaytbl" +
                " where firstClub = ?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Play> list = new ArrayList<>();
        Play play;
        while (resultSet.next()) {
            play = new Play(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getString(5));
            list.add(play);
        }
        return list;
    }
}
