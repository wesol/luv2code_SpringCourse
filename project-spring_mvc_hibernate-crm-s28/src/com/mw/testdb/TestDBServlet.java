package com.mw.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {

    private static final long serialVetsionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user = "springstudent";
        String password = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";

        try {

            PrintWriter out = response.getWriter();
            out.println("Connecting to database: " + jdbcUrl);

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);

           out.println("Success");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new ServletException();
        }

    }


}
