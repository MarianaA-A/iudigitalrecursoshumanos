package com.mycompany.iuDigitalRecursosHumanos.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {
        
    private static final String URL = "jdbc:mysql://localhost:3306/iuDigitalRecursosHumanos";
    private static final String USER = "root";
    private static final String PASSWORD = "05102020";
    
    public static Connection getConnection () throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}