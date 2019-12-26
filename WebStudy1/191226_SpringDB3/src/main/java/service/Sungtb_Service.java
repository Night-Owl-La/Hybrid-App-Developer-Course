package service;

import java.util.List;

import dao.SungtbDao;
import vo.SungtbVo;

public class Sungtb_Service {
	SungtbDao sungtb_dao;

	public SungtbDao getSungtb_dao() {
		return sungtb_dao;
	}

	public void setSungtb_dao(SungtbDao sungtb_dao) {
		this.sungtb_dao = sungtb_dao;
	}

	public List<SungtbVo> selectList() {
		List<SungtbVo> list = null;
		list = sungtb_dao.selectList();
		return list;
	}
}
