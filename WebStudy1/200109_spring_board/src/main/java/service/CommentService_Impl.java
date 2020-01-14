package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CommentDao;
import vo.CommentVo;

@Service("commentService")
public class CommentService_Impl implements CommentService {

	@Autowired
	CommentDao commentDao;

	@Override
	public List selectList() {
		return commentDao.selectList();
	}

	@Override
	public List selectList(Map map) {
		return commentDao.selectList(map);
	}
	
	@Override
	public List selectList(int board_idx) {
		return commentDao.selectList(board_idx);
	}
	
	@Override
	public int selectRowTotal(int board_idx) {
		return commentDao.selectRowTotal(board_idx);
	}

	@Override
	public int insert(CommentVo vo) {
		return commentDao.insert(vo);
	}

	@Override
	public int update(CommentVo vo) {
		return commentDao.update(vo);
	}

	@Override
	public int delete(int idx) {
		return commentDao.delete(idx);
	}

}
