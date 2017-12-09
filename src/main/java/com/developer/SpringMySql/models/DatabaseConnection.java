package com.developer.SpringMySql.models;

/**
 * Created by George Stratulat on 27/11/2017.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection /*used for accessing mySql database and the tables*/ {
    private final static String URL = "jdbc:mysql://localhost:3306/";
    private final static String DB_NAME = "mydbtech";
    private final static String USER = "tech";
    private final static String PASS = "password";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    URL + DB_NAME + "?useSSL=false",
                    USER,
                    PASS);
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
