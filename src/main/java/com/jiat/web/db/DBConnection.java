package com.jiat.web.db;

import com.jiat.web.db.util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() throws Exception {

        ApplicationProperties applicationProperties = ApplicationProperties.getInstance();
        Class.forName(applicationProperties.getProperty("driver"));

        connection = DriverManager.getConnection(applicationProperties.getProperty("sql.connection.url"),
                applicationProperties.getProperty("sql.connection.username"), applicationProperties.getProperty("sql.connection.password"));

        return connection;

    }
}
