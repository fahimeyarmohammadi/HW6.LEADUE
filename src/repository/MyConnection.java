package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    public MyConnection() throws SQLException {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "Fy4965285");
    }
    protected  Connection connection =getConnection();

}
