package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.SawonDao;
import vo.SawonVo;

public class SawonService_Impl implements SawonService {

	@Autowired
	SawonDao sawon_Dao;
	
	@Override
	public List<SawonVo> selectList() {
		return sawon_Dao.selectList();
	}

	@Override
	public SawonVo selectOne(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(SawonVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(SawonVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(SawonVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
