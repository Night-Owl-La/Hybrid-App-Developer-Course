package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVo;

public class VisitDao {
	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<VisitVo> selectList() {
		List<VisitVo> list = null;
		list = sqlSession.selectList("visit.visit_list");
		return list;
	}

	public List<VisitVo> selectList(Map<String, String> map) {
		List<VisitVo> list = sqlSession.selectList("visit.visit_list_condition", map);
		return list;
	}

	public VisitVo selectOne(int idx) {
		VisitVo vo = sqlSession.selectOne("visit.visit_list_one", idx);
		return vo;
	}

	public int insert(VisitVo vo) {
		int res = 0;
		sqlSession.insert("visit.visit_insert", vo);
		return res;
	}

	public int update(VisitVo vo) {
		int res = 0;
		sqlSession.update("visit.visit_update", vo);
		return res;
	}

	public int delete(int idx) {
		int res = 0;
		sqlSession.delete("visit.visit_delete", idx);
		return res;
	}

}
