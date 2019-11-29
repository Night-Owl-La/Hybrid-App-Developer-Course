package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DB_Service;
import vo.GogekVo;

public class GogekDao {

	static GogekDao single = null;

	public static GogekDao getInstance() {
		if (single == null)
			single = new GogekDao();
		return single;
	}

	public List<GogekVo> selectList() {

		List<GogekVo> list = new ArrayList<GogekVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from gogek";

		try {
			// 1.Connection 얻어오기
			conn = DB_Service.getInstance().getConnection();
			// 2.PreparedStatement(명령처리객체) 얻기
			pstmt = conn.prepareStatement(sql);

			// 3.pstmt parameter설정

			// 4.ResultSet(결과행처리객체) 얻어
			rs = pstmt.executeQuery();

			// 5.전체레코드 읽어오기
			while (rs.next()) {
				// 1건의 데이터(레코드)를 담을 객체
				GogekVo vo = new GogekVo();

				// 현재레코드->Vo포장
				vo.setGobun(rs.getInt("gobun"));
				vo.setGoname(rs.getString("goname"));
				vo.setGoaddr(rs.getString("goaddr"));
				vo.setGojumin(rs.getString("gojumin"));
				vo.setGodam(rs.getInt("godam"));

				// 리스트 추가
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			try {
				// 닫기(열린역순)
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}

		return list;
	}

}
