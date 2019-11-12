package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.la.night_owl.score_management.service.DB_Service;
import com.la.night_owl.score_management.vo.Score_Vo;

public class Test_DAO {
	private static Test_DAO single = new Test_DAO();

	public static Test_DAO getInstance() {
		return single;
	}
	
	public List<Score_Vo> selectList() {
		List<Score_Vo> list = new ArrayList<Score_Vo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {
			conn = DB_Service.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				Score_Vo vo = new Score_Vo();

				// 현재 레코드 -> Vo 포장. TODO
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
