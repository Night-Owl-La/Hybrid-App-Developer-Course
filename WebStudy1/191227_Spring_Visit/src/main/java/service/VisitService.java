package service;

import java.util.List;
import java.util.Map;

import dao.VisitDao;
import vo.VisitVo;

public class VisitService {
	VisitDao visit_dao;

	public VisitDao getVisit_dao() {
		return visit_dao;
	}

	public void setVisit_dao(VisitDao visit_dao) {
		this.visit_dao = visit_dao;
	}

	public List<VisitVo> selectList() {
		List<VisitVo> list = null;
		list = visit_dao.selectList();
		return list;
	}
	

	public List<VisitVo> selectList(Map<String, String> map) {
		List<VisitVo> list = visit_dao.selectList(map);
		return list;
	}

	public VisitVo selectOne(int idx) {
		VisitVo vo = visit_dao.selectOne(idx);
		return vo;
	}

	public int insert(VisitVo vo) {
		int res = 0;
		visit_dao.insert(vo);
		return res;
	}

	public int update(VisitVo vo) {
		int res = 0;
		visit_dao.update(vo);
		return res;
	}

	public int delete(int idx) {
		int res = 0;
		visit_dao.delete(idx);
		return res;
	}

}
