package com.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory

{

	private static Connection conn = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/akshay", "root", "12345");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}

}
