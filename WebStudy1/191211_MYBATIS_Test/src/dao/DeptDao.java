package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVo;
import vo.SawonVo;

public class DeptDao {
	// single-ton : ��ü1���� ���� ����
	static DeptDao single = null;

	// SessionFactory�����ϴ� ��ü
	SqlSessionFactory factory;

	public DeptDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static DeptDao getInstance() {

		if (single == null)
			single = new DeptDao();

		return single;
	}

	public List<DeptVo> selectList() {

		// 1. MyBatis 작업세션
		SqlSession sqlSession = factory.openSession();

		// 2. 작업수행.
		List<DeptVo> list = sqlSession.selectList("dept.dept_list");

		// 3. 커넥션 반환.
		sqlSession.close();

		return list;
	}

}
