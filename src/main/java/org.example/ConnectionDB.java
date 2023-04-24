package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

        public static Connection getConnection () throws SQLException {
                return  DriverManager.getConnection ("jdbc:mysql://localhost:3306/test", "root", "root");
            }




}
