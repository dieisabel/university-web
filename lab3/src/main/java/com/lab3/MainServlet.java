package com.lab3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.ClassNotFoundException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("init");
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		    Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/lab3?user=lab3&password=123");
		    System.out.println("connected");
		} catch (Exception exception) {
		    exception.printStackTrace();	
		}
        // request.setAttribute("data", data);
        // request.getRequestDispatcher("/tabulation.jsp").forward(request, response);
    }
}
