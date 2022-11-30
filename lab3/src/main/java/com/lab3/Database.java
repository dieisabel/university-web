package com.lab3;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

class Database {
	private static String CONNECTION_STRING = "jdbc:mariadb://localhost:3306/lab3?user=lab3&password=123";

	public static Connection createConnection() {
		try {
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
