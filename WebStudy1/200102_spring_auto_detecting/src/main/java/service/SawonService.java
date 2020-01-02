package service;

import java.util.List;

import vo.SawonVo;

public interface SawonService {
	List<SawonVo> selectList();
	SawonVo selectOne(int idx);
	int insert(SawonVo vo);
	int update(SawonVo vo);
	int delete(SawonVo vo);
}
