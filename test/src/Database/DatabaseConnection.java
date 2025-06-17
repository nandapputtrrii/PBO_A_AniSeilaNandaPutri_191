package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/perpustakaan";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Open a connection
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Database connection established successfully!");
            } catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC Driver not found!");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Connection failed! Check output console");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed successfully!");
            } catch (SQLException e) {
                System.out.println("Error closing connection!");
                e.printStackTrace();
            }
        }
    }
}