package dao;

import java.util.List;

import vo.DeptVo;

public interface DeptDao {
	List<DeptVo> selectList();
	int insert();
	int update();
	int delete();
}
