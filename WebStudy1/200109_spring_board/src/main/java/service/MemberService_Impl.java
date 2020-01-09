package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import vo.MemberVo;

@Service("memberService")
public class MemberService_Impl implements MemberService {
	
	@Autowired
	MemberDao memberDao;

	@Override
	public List<MemberVo> selectList() {
		return memberDao.selectList();
	}

	@Override
	public MemberVo selectOne(int idx) {
		return memberDao.selectOne(idx);
	}

	@Override
	public MemberVo selectOne(String id) {
		return memberDao.selectOne(id);
	}

	@Override
	public int insert(MemberVo vo) {
		int res = memberDao.insert(vo);
		return res;
	}

	@Override
	public int update(MemberVo vo) {
		int res = memberDao.update(vo);
		return res;
	}

	@Override
	public int delete(int idx) {
		int res = memberDao.delete(idx);
		return res;
	}

}
