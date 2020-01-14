package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.CommentVo;

@Repository("commentDao")
public class CommentDao_Impl implements CommentDao {
	
	@Autowired
	SqlSession sqlSession;

	public CommentDao_Impl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectList(Map map) {
		return sqlSession.selectList("comment.comment_RowTotal_List", map);
	}
	
	@Override
	public List selectList(int board_idx) {
		return sqlSession.selectList("comment.comment_List", board_idx);
	}
	
	@Override
	public int selectRowTotal(int board_idx) {
		return sqlSession.selectOne("comment.comment_Total_List", board_idx);
	}

	@Override
	public int insert(CommentVo vo) {
		return sqlSession.insert("comment.comment_Insert", vo);
	}

	@Override
	public int update(CommentVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int idx) {
		return sqlSession.delete("comment.comment_Delete", idx);
	}

}
