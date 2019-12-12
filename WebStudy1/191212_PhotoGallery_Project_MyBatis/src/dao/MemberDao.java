package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVo;

public class MemberDao {

//Single-ton : 객체1개만 생성해서 서비스하자
	static MemberDao single = null;

	SqlSessionFactory factory;

	public static MemberDao getInstance() {
		if (single == null)
			single = new MemberDao();
		return single;
	}

	public MemberDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<MemberVo> selectList() {

		SqlSession sqlSession = factory.openSession();

		List<MemberVo> list = sqlSession.selectList("member.member_list");

		sqlSession.close();

		return list;
	}

	public MemberVo selectOne(int idx) {

		SqlSession sqlSession = factory.openSession();

		MemberVo vo = sqlSession.selectOne("member.member_list_one_idx", idx);

		sqlSession.close();

		return vo;
	}

	public MemberVo selectOne(String id) {

		SqlSession sqlSession = factory.openSession();

		MemberVo vo = sqlSession.selectOne("member.member_list_one_id", id);

		sqlSession.close();

		return vo;
	}

	public int insert(MemberVo vo) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);

		res = sqlSession.insert("member.member_insert", vo);

		sqlSession.close();

		return res;
	}

	public int update(MemberVo vo) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);

		res = sqlSession.update("member.member_update", vo);

		sqlSession.close();

		return res;
	}

	public int delete(int idx) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);

		res = sqlSession.delete("member.member_delete", idx);

		sqlSession.close();

		return res;
	}
}
