package service;

import java.util.List;

import dao.SawonDao;
import vo.SawonVo;

public class SawonService {

	SawonDao sawon_dao;

	public SawonService() {
	}

	public SawonDao getSawon_dao() {
		return sawon_dao;
	}

	public void setSawon_dao(SawonDao sawon_dao) {
		this.sawon_dao = sawon_dao;
	}

	public List<SawonVo> selectList() {
		List<SawonVo> list = sawon_dao.selectList();
		return list;
	}

}
