package com.gmail.rak.aleh.util.impl;

import com.gmail.rak.aleh.util.ConnectionService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionServiceImpl implements ConnectionService {
    private Connection connection;

    @Override
    public Connection createConnectionSQLite() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("org.sqlite.JDBC driver does not exist");
        }
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:homework4.db");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("failed to connect to homework4.db");
        }
        return connection;
    }
}
