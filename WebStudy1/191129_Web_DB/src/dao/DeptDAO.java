package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DB_Service;
import vo.DeptVo;

public class DeptDAO {

//Single-ton : 객체1개만 생성해서 서비스하자
	static DeptDAO single = null;

	public static DeptDAO getInstance() {
		if (single == null)
			single = new DeptDAO();
		return single;
	}

	public List<DeptVo> selectList() {

		List<DeptVo> list = new ArrayList<DeptVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from dept";

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
				DeptVo vo = new DeptVo();
				System.out.println("test1");
				// 현재레코드->Vo포장
				vo.setDeptno(rs.getInt("deptno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getInt("loc"));

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