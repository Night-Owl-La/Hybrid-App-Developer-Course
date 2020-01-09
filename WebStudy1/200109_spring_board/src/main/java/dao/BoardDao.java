package dao;

import java.util.List;
import java.util.Map;

import vo.BoardVo;

public interface BoardDao {
	List<BoardVo> selectList();
	List<BoardVo> selectList(Map map);
	BoardVo selectOne(int idx);
	
	int insert(BoardVo vo);
	int update(BoardVo vo);
	int update_ViewCount(BoardVo vo);
	int delete(int idx);
}

