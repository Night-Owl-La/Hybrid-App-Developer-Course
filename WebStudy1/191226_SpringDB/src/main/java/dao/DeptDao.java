package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVo;

public class DeptDao {
	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;	
	}

	public List<DeptVo> selectList() {
		List<DeptVo> list= null;
		list = sqlSession.selectList("dept.dept_list");
		return list;
	}

}
