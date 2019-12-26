package service;

import java.util.List;

import dao.DeptDao;
import vo.DeptVo;

public class DeptService {

	DeptDao dept_dao;

	public DeptService() {
	}

	public DeptDao getDept_dao() {
		return dept_dao;
	}

	public void setDept_dao(DeptDao dept_dao) {
		this.dept_dao = dept_dao;
	}

	public List<DeptVo> selectList() {
		List<DeptVo> list = dept_dao.selectList();
		return list;
	}

}
