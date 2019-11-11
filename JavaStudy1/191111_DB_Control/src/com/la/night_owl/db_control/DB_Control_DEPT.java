package com.la.night_owl.db_control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Control_DEPT {

	// 0. Oracle driver loading.
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		// 1. Connection get.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";

		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("DB OK");

		// 2. SQL 명령 처리객체 얻어오기.
		Statement statement = conn.createStatement();

//		String sql = "CREATE TABLE TTT(no int)";
//		String sql = "DROP TABLE TTT";
//		String sql = "insert into TTT values(1)";
//		String sql = "update TTT set no=100 where no=1";
//		String sql = "delete from TTT where no=100";
//		int res = statement.executeUpdate(sql);

		String sql = "SELECT deptno,dname,loc FROM DEPT";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			int deptno = rs.getInt("deptno");
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");

			System.out.println(String.format("%d | %s | %s", deptno, dname, loc));
		}

		System.out.println();

		rs.close();
		statement.close();
		conn.close();

	}
}
