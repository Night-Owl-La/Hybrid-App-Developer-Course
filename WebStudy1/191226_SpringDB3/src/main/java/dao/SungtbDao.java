package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.SungtbVo;

public class SungtbDao {
	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<SungtbVo> selectList() {
		List<SungtbVo> list= null;
		list = sqlSession.selectList("sungtb.sungtb_list");
		return list;
	}

}
