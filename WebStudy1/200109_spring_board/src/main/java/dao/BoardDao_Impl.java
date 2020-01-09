package dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.BoardVo;

@Repository("boardDao")
public class BoardDao_Impl implements BoardDao {

	@Autowired
	SqlSession sqlSession;

	public BoardDao_Impl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BoardVo> selectList() {
		return sqlSession.selectList("board.board_List");
	}

	@Override
	public List<BoardVo> selectList(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVo selectOne(int idx) {
		return sqlSession.selectOne("board.board_List_Idx", idx);
	}

	@Override
	public int insert(BoardVo vo) {
		return sqlSession.insert("board.board_Insert", vo);
	}

	@Override
	public int update(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update_ViewCount(BoardVo vo) {
		return sqlSession.update("board.board_Update_ViewCount", vo);
	}

	@Override
	public int delete(int idx) {
		// TODO Auto-generated method stub
		return 0;
	}

}
