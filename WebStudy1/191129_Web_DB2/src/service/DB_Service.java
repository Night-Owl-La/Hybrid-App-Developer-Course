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

	public DB_Service() {

		try {
			InitialContext ic = new InitialContext();
			Context ctx = (Context) ic.lookup("java:comp/env");

			ds = (DataSource) ctx.lookup("jdbc/oracle_test");
		} catch (NamingException e) {
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
