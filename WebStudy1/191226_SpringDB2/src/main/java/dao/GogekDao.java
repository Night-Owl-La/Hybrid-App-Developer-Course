package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.GogekVo;

public class GogekDao {

	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;	
	}
	
	public List<GogekVo> selectList() {
		List<GogekVo> list= null;
		list = sqlSession.selectList("gogek.gogek_list");
		return list;
	}

}
