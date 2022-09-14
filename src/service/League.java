package service;

import java.sql.SQLException;

public interface League {

    void addClubToLeague() throws SQLException;

    void deleteClubFromLeague() throws SQLException;

    void addPlayToLeague() throws SQLException;

    String showClubInformation() throws SQLException;

    String ShowClubSorted() throws SQLException;
}
