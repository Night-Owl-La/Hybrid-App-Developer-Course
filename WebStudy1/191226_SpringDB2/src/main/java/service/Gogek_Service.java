package service;

import java.util.List;

import dao.GogekDao;
import vo.GogekVo;

public class Gogek_Service {
	GogekDao gogek_dao;

	public GogekDao getGogek_dao() {
		return gogek_dao;
	}

	public void setGogek_dao(GogekDao gogek_dao) {
		this.gogek_dao = gogek_dao;
	}

	public List<GogekVo> selectList() {
		List<GogekVo> list= null;
		list = gogek_dao.selectList();
		return list;
	}

}
