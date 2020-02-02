package com.mw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=CET";
        String user = "hbstudent";
        String password = "hbstudent";

        System.out.println("Connecting to database: " + jdbcUrl);
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
