package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.SawonVo;

public class SawonDao {
	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;	
	}

	public List<SawonVo> selectList() {
		List<SawonVo> list= null;
		list = sqlSession.selectList("sawon.sawon_list");
		return list;
	}

}
