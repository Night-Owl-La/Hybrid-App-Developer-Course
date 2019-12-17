package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CartVo;

public class CartDao {

//Single-ton : 객체1개만 생성해서 서비스하자
	static CartDao single = null;

	SqlSessionFactory factory;

	public static CartDao getInstance() {
		if (single == null)
			single = new CartDao();
		return single;
	}

	public CartDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<CartVo> selectList() {

		SqlSession sqlSession = factory.openSession();
		List<CartVo> list = sqlSession.selectList("cart.cart_list");
		sqlSession.close();

		return list;
	}

	public CartVo selectOne(int idx) {

		SqlSession sqlSession = factory.openSession();
		CartVo vo = sqlSession.selectOne("cart.cart_list_one_idx", idx);
		sqlSession.close();

		return vo;
	}

	public CartVo selectOne(String id) {

		SqlSession sqlSession = factory.openSession();
		CartVo vo = sqlSession.selectOne("cart.cart_list_one_id", id);
		sqlSession.close();

		return vo;
	}

	public int insert(CartVo vo) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.insert("cart.cart_insert", vo);
		sqlSession.close();

		return res;
	}

	public int update(CartVo vo) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.update("cart.cart_update", vo);
		sqlSession.close();

		return res;
	}

	public int delete(int idx) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		res = sqlSession.delete("cart.cart_delete", idx);
		sqlSession.close();

		return res;
	}
}
