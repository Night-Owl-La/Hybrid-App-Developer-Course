package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DB_Service;
import vo.MemberVo;

public class MemberDao {

//Single-ton : 객체1개만 생성해서 서비스하자
	static MemberDao single = null;

	public static MemberDao getInstance() {
		if (single == null)
			single = new MemberDao();
		return single;
	}

	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member order by idx desc";

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
				MemberVo vo = new MemberVo();

				// 현재레코드->Vo포장
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setIp(rs.getString("ip"));
				vo.setGrade(rs.getString("grade"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setModifydate(rs.getString("modifydate"));

				// 리스트 추가
				list.add(vo);
			}

		} catch (Exception e) {
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
				e.printStackTrace();
			}
		}

		return list;
	}

	public MemberVo selectOne(int idx) {

		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where idx=?";

		try {
			// 1.Connection 얻어오기
			conn = DB_Service.getInstance().getConnection();
			// 2.PreparedStatement(명령처리객체) 얻기
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter설정
			pstmt.setInt(1, idx);

			// 4.ResultSet(결과행처리객체) 얻어
			rs = pstmt.executeQuery();

			// 5.전체레코드 읽어오기
			if (rs.next()) {
				// 1건의 데이터(레코드)를 담을 객체
				vo = new MemberVo();

				// 현재레코드->Vo포장
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setIp(rs.getString("ip"));
				vo.setGrade(rs.getString("grade"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setModifydate(rs.getString("modifydate"));

			}

		} catch (Exception e) {
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
				e.printStackTrace();
			}
		}

		return vo;
	}

	public MemberVo selectOne(String id) {

		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";

		try {
			// 1.Connection 얻어오기
			conn = DB_Service.getInstance().getConnection();
			// 2.PreparedStatement(명령처리객체) 얻기
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter설정
			pstmt.setString(1, id);

			// 4.ResultSet(결과행처리객체) 얻어
			rs = pstmt.executeQuery();

			// 5.전체레코드 읽어오기
			if (rs.next()) {
				// 1건의 데이터(레코드)를 담을 객체
				vo = new MemberVo();

				// 현재레코드->Vo포장
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setIp(rs.getString("ip"));
				vo.setGrade(rs.getString("grade"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setModifydate(rs.getString("modifydate"));

			}

		} catch (Exception e) {
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
				e.printStackTrace();
			}
		}

		return vo;
	}

	public int insert(MemberVo vo) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into member values(seq_member_idx.nextVal, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate)";

		try {
			// 1.Connection얻기
			conn = DB_Service.getInstance().getConnection();
			// 2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt's parameter채우기
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getZipcode());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getIp());
			pstmt.setString(7, vo.getGrade());
			// 4.DB SQL 전송
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// 닫기(역순)
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public int update(MemberVo vo) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update member set name=?, pwd=?, zipcode=?, address=?, modifydate=sysdate, grade=? where idx=?";

		try {
			// 1.Connection얻기
			conn = DB_Service.getInstance().getConnection();
			// 2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt's parameter채우기
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getZipcode());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getGrade());
			pstmt.setInt(6, vo.getIdx());

			// 4.DB SQL 전송
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// 닫기(역순)
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	public int delete(int idx) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from member where idx=?";

		try {
			// 1.Connection얻기
			conn = DB_Service.getInstance().getConnection();
			// 2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt's parameter채우기
			pstmt.setInt(1, idx);

			// 4.DB SQL 전송
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// 닫기(역순)
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}
