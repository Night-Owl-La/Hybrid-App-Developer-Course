package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	// single-ton : ��ü1���� ���� ����
	static SawonDao single = null;

	// SessionFactory�����ϴ� ��ü
	SqlSessionFactory factory;

	public SawonDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();

		return single;
	}

	public List<SawonVo> selectList() {

		// 1. MyBatis 작업세션
		SqlSession sqlSession = factory.openSession();

		// 2. 작업수행.
		List<SawonVo> list = sqlSession.selectList("sawon.sawon_list");

		// 3. 커넥션 반환.
		sqlSession.close();

		return list;
	}

	public List<SawonVo> selectList(int deptno) {

		// 1. MyBatis 작업세션
		SqlSession sqlSession = factory.openSession();

		// 2. 작업수행.
		List<SawonVo> list = sqlSession.selectList("sawon.sawon_list_deptno", deptno);

		// 3. 커넥션 반환.
		sqlSession.close();

		return list;
	}

	public List<SawonVo> selectList(String sajob) {

		// 1. MyBatis 작업세션
		SqlSession sqlSession = factory.openSession();

		// 2. 작업수행.
		List<SawonVo> list = sqlSession.selectList("sawon.sawon_list_sajob", sajob);

		// 3. 커넥션 반환.
		sqlSession.close();

		return list;
	}

	public List<SawonVo> selectList(Map<String, Integer> map) {
		// 1. MyBatis 작업세션
		SqlSession sqlSession = factory.openSession();

		// 2. 작업수행.
		List<SawonVo> list = sqlSession.selectList("sawon.sawon_list_sapay", map);

		// 3. 커넥션 반환.
		sqlSession.close();

		return list;
	}

	public List<SawonVo> selectList_ByYear(Map<String, Integer> map) {
		// 1. MyBatis 작업세션
		SqlSession sqlSession = factory.openSession();

		// 2. 작업수행.
		List<SawonVo> list = sqlSession.selectList("sawon.sawon_list_sahire", map);

		// 3. 커넥션 반환.
		sqlSession.close();

		return list;
	}

}
