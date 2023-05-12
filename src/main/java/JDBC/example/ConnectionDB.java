package JDBC.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
        public static Connection getConnection () throws SQLException {
                return  DriverManager.getConnection ("jdbc:postgresql://localhost:5432/postgres", "root", "root");
            }
}
