package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Wrapper;

public class DBConnection {
    private static final String URL="jdbc:postgresql://localhost:5432/Banking-DB";
    private static final String USER ="postgres";
    private static final String PASSWORD ="Navitha@21";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
