package test;

import java.sql.Connection;
import java.sql.SQLException;

import com.la.night_owl.score_management.service.DB_Service;

public class Test_Connection {

	public static void main(String[] args) throws SQLException {

		Connection conn = DB_Service.getInstance().getConnection();

		System.out.println("ok");

		conn.close();
	}

}
