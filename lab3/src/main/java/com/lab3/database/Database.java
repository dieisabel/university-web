package com.lab3.database;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

import com.lab3.Config;

public class Database {
	private static String CONNECTION_STRING = Config.CONNECTION_STRING;

	public static Connection createConnection() {
		try {
			// Tomcat unregister it later
			DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
			
			return DriverManager.getConnection(Database.CONNECTION_STRING);
		} catch (SQLException exception) {
			exception.printStackTrace();
			// TODO: ????????
			return null;
		}
	}

	public static void closeResultSet(ResultSet set) {
		try {
			if (set != null) {
				set.close();
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void closeStatement(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void closePreparedStatement(PreparedStatement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
}
