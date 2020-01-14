package service;

import java.util.List;
import java.util.Map;

import vo.CommentVo;
import vo.MemberVo;

public interface CommentService {
	List selectList();
	List selectList(Map map);
	List selectList(int board_idx);	
	int selectRowTotal(int board_idx);
	int insert(CommentVo vo);
	int update(CommentVo vo);
	int delete(int idx);
}
