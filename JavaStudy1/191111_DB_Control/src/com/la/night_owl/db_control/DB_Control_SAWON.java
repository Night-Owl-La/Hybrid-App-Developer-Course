package com.la.night_owl.db_control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Control_SAWON {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";

		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("DB OK");

		Statement statement = conn.createStatement();

		String sql = "SELECT * FROM SAWON";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			int sabun = rs.getInt("sabun");
			String saname = rs.getString("saname");
			String sasex = rs.getString("sasex");
			int deptno = rs.getInt("deptno");
			String sajob = rs.getString("sajob");
			String sahire = rs.getString("sahire").substring(0, 10);
			int samgr = rs.getInt("samgr");
			int sapay = rs.getInt("sapay");

			System.out.println(String.format("%d | %s | %s | %d | %s | %s | %s | %d", sabun, saname, sasex, deptno,
					sajob, sahire, samgr, sapay));
		}

		rs.close();
		statement.close();
		conn.close();
		
		
	}
}
