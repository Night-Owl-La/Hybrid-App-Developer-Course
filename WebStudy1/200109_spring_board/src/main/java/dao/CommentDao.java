package dao;

import java.util.List;
import java.util.Map;

import vo.CommentVo;

public interface CommentDao {
	List selectList();
	List selectList(Map map);
	List selectList(int board_idx);	
	int selectRowTotal(int board_idx);
	int insert(CommentVo vo);
	int update(CommentVo vo);
	int delete(int idx);
}
