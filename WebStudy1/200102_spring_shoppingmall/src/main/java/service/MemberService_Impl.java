package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import vo.MemberVo;

@Service("member_Service")
public class MemberService_Impl implements MemberService {
	
	@Autowired
	MemberDao member_Dao;

	@Override
	public List<MemberVo> selectList() {
		return member_Dao.selectList();
	}

	@Override
	public MemberVo selectOne(int idx) {
		return member_Dao.selectOne(idx);
	}

	@Override
	public MemberVo selectOne(String id) {
		return member_Dao.selectOne(id);
	}

	@Override
	public int insert(MemberVo vo) {
		int res = member_Dao.insert(vo);
		return res;
	}

	@Override
	public int update(MemberVo vo) {
		int res = member_Dao.update(vo);
		return res;
	}

	@Override
	public int delete(int idx) {
		int res = member_Dao.delete(idx);
		return res;
	}

}
