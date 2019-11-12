package com.la.night_owl.score_management.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Service {
	
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER_ID = "test";
	public static final String USER_PASSWORD = "test";

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private DB_Service() {
		super();
	}

	private static DB_Service single = new DB_Service();

	public static DB_Service getInstance() {
		return single;
	}

	public Connection getConnection() throws SQLException {

		Connection conn = DriverManager.getConnection(URL, USER_ID, USER_PASSWORD);

		return conn;
	}

}