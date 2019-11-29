package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vo.SawonVo;

import service.DB_Service;

public class SawonDao {

	// Single-ton : 객체1개만 생성해서 서비스하자
	static SawonDao single = null;

	public static SawonDao getInstance() {
		if (single == null)
			single = new SawonDao();
		return single;
	}

	public List<SawonVo> selectList() {

		List<SawonVo> list = new ArrayList<SawonVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon";

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
				SawonVo vo = new SawonVo();

				// 현재레코드->Vo포장
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setSasex(rs.getString("sasex"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSahire(rs.getString("sahire"));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));
				
				// 리스트 추가
				list.add(vo);
			}

		} catch (Exception e) {
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
				e.printStackTrace();
			}
		}

		return list;
	}
}
