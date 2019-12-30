package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVo;

public class MemberDao {
	
	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;	
	}
	
	public List<MemberVo> selectList() {
		List<MemberVo> list = null;
		list = sqlSession.selectList("member.member_list");

		return list;
	}

	public MemberVo selectOne(int idx) {

		MemberVo vo = sqlSession.selectOne("member.member_list_one_idx", idx);
		return vo;
	}

	public MemberVo selectOne(String id) {

		MemberVo vo = sqlSession.selectOne("member.member_list_one_id", id);

		return vo;
	}

	public int insert(MemberVo vo) {
		int res = 0;
		System.out.println(vo.toString());
		res = sqlSession.insert("member.member_insert", vo);

		return res;
	}

	public int update(MemberVo vo) {
		int res = 0;

		res = sqlSession.update("member.member_update", vo);

		return res;
	}

	public int delete(int idx) {
		int res = 0;

		res = sqlSession.delete("member.member_delete", idx);

		return res;
	}
}
