package com.developer.SpringMySql.models;

/**
 * Created by George Stratulat on 27/11/2017.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection /*used for accessing mySql database and the tables*/ {
    private final static String URL = "jdbc:mysql://localhost:3306/";
    private final static String DB_NAME = "swc3tech2";
    private final static String USER = "root";
    private final static String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    URL + DB_NAME,
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
