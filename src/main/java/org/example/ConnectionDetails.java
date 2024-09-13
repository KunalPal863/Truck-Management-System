package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDetails {
    //No need because we already import the sql files from the local drive by maven build tool
   // public static final String LoadDriver = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/truckdb";
    public static final String UserName = "root";
    public static final String Password = "Kunal9634@#";

    public static Connection getConnection() throws SQLException {
     return DriverManager.getConnection(URL,UserName,Password);
    }
}
