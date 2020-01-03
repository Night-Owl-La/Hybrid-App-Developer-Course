package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VisitDao;
import vo.VisitVo;

@Service("vs")
public class VisitService {
	
	@Autowired
	VisitDao visit_dao;

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
		int res = visit_dao.insert(vo);
		return res;
	}

	public int update(VisitVo vo) {
		int res = visit_dao.update(vo);
		return res;
	}

	public int delete(int idx) {
		int res = visit_dao.delete(idx);
		return res;
	}

}
