package service;

import java.util.List;

import dao.MemberDao;
import vo.MemberVo;

public class MemberService {
	MemberDao member_dao;

	public MemberDao getMember_dao() {
		return member_dao;
	}

	public void setMember_dao(MemberDao member_dao) {
		this.member_dao = member_dao;
	}

	public List<MemberVo> selectList() {
		List<MemberVo> list = null;
		list = member_dao.selectList();

		return list;
	}

	public MemberVo selectOne(int idx) {

		MemberVo vo = member_dao.selectOne(idx);
		return vo;
	}

	public MemberVo selectOne(String id) {

		MemberVo vo = member_dao.selectOne(id);

		return vo;
	}

	public int insert(MemberVo vo) {
		int res = 0;

		res = member_dao.insert(vo);

		return res;
	}

	public int update(MemberVo vo) {
		int res = 0;

		res = member_dao.update(vo);

		return res;
	}

	public int delete(int idx) {
		int res = 0;

		res = member_dao.delete(idx);

		return res;
	}
}
