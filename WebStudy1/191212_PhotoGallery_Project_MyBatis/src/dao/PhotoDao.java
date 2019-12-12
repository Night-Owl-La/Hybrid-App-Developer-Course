package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.PhotoVo;

public class PhotoDao {

	// Single-ton : 객체1개만 생성해서 서비스하자
	static PhotoDao single = null;

	SqlSessionFactory factory;

	public PhotoDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static PhotoDao getInstance() {
		if (single == null)
			single = new PhotoDao();
		return single;
	}

	public List<PhotoVo> selectList() {

		SqlSession sqlSession = factory.openSession();

		// 2. 작업수행.
		List<PhotoVo> list = sqlSession.selectList("photo.photo_list");

		// 3. 커넥션 반환.
		sqlSession.close();

		return list;
	}

	public PhotoVo selectOne(int p_idx) {

		SqlSession sqlSession = factory.openSession();

		// 2. 작업수행.
		PhotoVo vo = sqlSession.selectOne("photo.photo_list_p_idx", p_idx);

		// 3. 커넥션 반환.
		sqlSession.close();

		return vo;
	}

	public int insert(PhotoVo vo) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);

		res = sqlSession.insert("photo.photo_insert", vo);

		sqlSession.close();

		return res;
	}

	public int update(PhotoVo vo) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);

		res = sqlSession.update("photo.photo_update", vo);

		sqlSession.close();

		return res;
	}

	public int delete(int p_idx) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);

		res = sqlSession.delete("photo.photo_delete", p_idx);

		sqlSession.close();

		return res;
	}
}
