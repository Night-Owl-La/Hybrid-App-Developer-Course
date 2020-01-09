package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MemberVo;

@Repository("memberDao")
public class MemberDao_Impl implements MemberDao {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<MemberVo> selectList() {
		return sqlSession.selectList("member.member_list");
	}

	@Override
	public MemberVo selectOne(int idx) {
		return sqlSession.selectOne("member.member_list_one_idx", idx);
	}

	@Override
	public MemberVo selectOne(String id) {
		return sqlSession.selectOne("member.member_list_one_id", id);
	}

	@Override
	public int insert(MemberVo vo) {
		int res = sqlSession.insert("member.member_insert", vo);
		return res;
	}

	@Override
	public int update(MemberVo vo) {
		int res = sqlSession.update("member.member_update", vo);
		return res;
	}

	@Override
	public int delete(int idx) {
		int res = sqlSession.delete("member.member_delete", idx);
		return res;
	}

}
