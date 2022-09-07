package repository;

import entity.Play;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FootballPlayRepository extends MyConnection {

    public FootballPlayRepository() throws SQLException {
    }

    public void creatFootballPlayTable() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("create table footballplaytbl" +
                "( firstClub varchar(50) not null, " + " secondClub varchar(50) not null," + " numberOfGoalClub1 int not null," +
                " numberOfGoalClub2 int not null)");
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void insertPlay(Play play) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into footballplaytbl " +
                " values(?,?,?,?)");
        preparedStatement.setString(1,play.getFirstClub());
        preparedStatement.setString(2, play.getSecondClub());
        preparedStatement.setInt(3, play.getNumberOfGoalClub1());
        preparedStatement.setInt(4, play.getNumberOfGoalClub2());

        preparedStatement.executeUpdate();
        connection.close();
    }
}
