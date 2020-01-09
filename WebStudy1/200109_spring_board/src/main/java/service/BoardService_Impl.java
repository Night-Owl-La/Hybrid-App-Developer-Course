
package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;
import vo.BoardVo;

@Service("boardService")
public class BoardService_Impl implements BoardService {

	@Autowired
	BoardDao boardDao;

	public BoardService_Impl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BoardVo> selectList() {
		return boardDao.selectList();
	}

	@Override
	public List<BoardVo> selectList(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVo selectOne(int idx) {
		return boardDao.selectOne(idx);
	}

	@Override
	public int insert(BoardVo vo) {
		return boardDao.insert(vo);
	}

	@Override
	public int update(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update_ViewCount(BoardVo vo) {
		return boardDao.update_ViewCount(vo);
	}

	@Override
	public int delete(int idx) {
		// TODO Auto-generated method stub
		return 0;
	}

}
