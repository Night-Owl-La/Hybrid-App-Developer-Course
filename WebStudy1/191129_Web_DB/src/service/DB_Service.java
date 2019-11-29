package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DB_Service {

	DataSource ds = null;

	static DB_Service single = null;

	private DB_Service() {
		try {
			// JNDI 기능을 처리하는 객체.
			InitialContext ic = new InitialContext();
			// 자원검색.
			Context ctx = (Context) ic.lookup("java:comp/env");
			// context내에 등록된 자원 검색.
			ds = (DataSource) ctx.lookup("jdbc/oracle_test");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static DB_Service getInstance() {
		if (single == null)
			single = new DB_Service();
		return single;
	}
	
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
