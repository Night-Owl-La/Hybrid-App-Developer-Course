package service;

import java.util.List;

import vo.MemberVo;

public interface MemberService {
	
	public List<MemberVo> selectList();
	public MemberVo selectOne(int idx);
	public MemberVo selectOne(String id);
	public int insert(MemberVo vo);
	public int update(MemberVo vo);
	public int delete(int idx);

}
