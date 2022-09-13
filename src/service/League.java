package entity;

import java.sql.SQLException;

public interface League {

    void addClubToLeague() throws SQLException;

    void deleteClubFromLeague() throws SQLException;

    void addPlayToLeague() throws SQLException;

    void showClubInformation() throws SQLException;

    void ShowClubSorted() throws SQLException;
}
