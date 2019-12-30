package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import vo.PhotoVo;

public class PhotoDao {
	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<PhotoVo> selectList() {

		// 2. 작업수행.
		List<PhotoVo> list = sqlSession.selectList("photo.photo_list");

		return list;
	}

	public PhotoVo selectOne(int p_idx) {

		// 2. 작업수행.
		PhotoVo vo = sqlSession.selectOne("photo.photo_list_p_idx", p_idx);

		return vo;
	}

	public int insert(PhotoVo vo) {
		int res = 0;

		res = sqlSession.insert("photo.photo_insert", vo);

		return res;
	}

	public int update(PhotoVo vo) {
		int res = 0;

		res = sqlSession.update("photo.photo_update", vo);

		return res;
	}

	public int delete(int p_idx) {
		int res = 0;

		res = sqlSession.delete("photo.photo_delete", p_idx);

		return res;
	}
}
