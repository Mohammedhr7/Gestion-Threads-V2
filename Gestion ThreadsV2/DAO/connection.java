package DAO;

import java.sql.Connection;
import java.sql.*;

public class connection {

    private static final String URL = "jdbc:mysql://localhost:3306/tp5";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, "root", "");
            System.out.println("Holly!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur!");
        }

        return conn;
    }

    //

    public static void closeConnection(connection conn) {
        closeConnection(conn);
    }

}
