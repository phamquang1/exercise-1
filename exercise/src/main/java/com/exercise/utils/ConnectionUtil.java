package com.exercise.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static String DB_URL = "jdbc:mysql://localhost:3306/javacore72022";
	private static final String USER = "root";
	private static final String PASS = "1234";

	public static Connection getConnection() {
		try {
			return (Connection) DriverManager.getConnection(DB_URL, ConnectionUtil.USER, ConnectionUtil.PASS);
		} catch (SQLException e) {
			// TODO: handle exception
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}
}
