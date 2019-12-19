package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.VisitVo;

public class VisitDao {
	// Single-ton : 객체1개만 생성해서 서비스하자
	static VisitDao single = null;

	SqlSessionFactory factory;

	public VisitDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static VisitDao getInstance() {
		if (single == null)
			single = new VisitDao();
		return single;
	}

	// 방명록 조회.

	public List<VisitVo> selectList() {

		SqlSession sqlSession = factory.openSession();

		List<VisitVo> list = sqlSession.selectList("visit.visit_list");

		sqlSession.close();

		return list;
	}

	public List<VisitVo> selectList(Map<String, String> map) {
		SqlSession sqlSession = factory.openSession();

		List<VisitVo> list = sqlSession.selectList("visit.visit_list_condition", map);

		sqlSession.close();

		return list;
	}

	public VisitVo selectOne(int idx) {

		SqlSession sqlSession = factory.openSession();

		VisitVo vo = sqlSession.selectOne("visit.visit_list_one", idx);

		sqlSession.close();

		return vo;
	}

	public int insert(VisitVo vo) {
		int res = 0;

		SqlSession sqlSession = factory.openSession();

		sqlSession.insert("visit.visit_insert", vo);

		sqlSession.commit();

		sqlSession.close();

		return res;
	}

	public int update(VisitVo vo) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);

		sqlSession.update("visit.visit_update", vo);

		sqlSession.close();

		return res;
	}

	public int delete(int idx) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);

		sqlSession.delete("visit.visit_delete", idx);

		sqlSession.close();

		return res;
	}

}
