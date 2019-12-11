package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.GogekVo;
import vo.SawonVo;

public class GogekDao {
	// single-ton : ��ü1���� ���� ����
	static GogekDao single = null;

	// SessionFactory�����ϴ� ��ü
	SqlSessionFactory factory;

	public GogekDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static GogekDao getInstance() {

		if (single == null)
			single = new GogekDao();

		return single;
	}

	public List<GogekVo> selectList() {

		// 1. MyBatis 작업세션
		SqlSession sqlSession = factory.openSession();

		// 2. 작업수행.
		List<GogekVo> list = sqlSession.selectList("gogek.gogek_list");

		// 3. 커넥션 반환.
		sqlSession.close();

		return list;
	}

	public List<GogekVo> selectList(int gobun) {

		// 1. MyBatis 작업세션
		SqlSession sqlSession = factory.openSession();

		// 2. 작업수행.
		List<GogekVo> list = sqlSession.selectList("gogek.gogek_list_gobun", gobun);

		// 3. 커넥션 반환.
		sqlSession.close();

		return list;
	}

	public List<GogekVo> selectList(String goname) {

		// 1. MyBatis 작업세션
		SqlSession sqlSession = factory.openSession();

		// 2. 작업수행.
		List<GogekVo> list = sqlSession.selectList("gogek.gogek_list_goname", goname);

		// 3. 커넥션 반환.
		sqlSession.close();

		return list;
	}

}
