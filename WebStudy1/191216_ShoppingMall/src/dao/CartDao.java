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

	public List<CartVo> selectList(int m_idx) {

		SqlSession sqlSession = factory.openSession();

		List<CartVo> list = sqlSession.selectList("cart.cart_list_idx", m_idx);

		sqlSession.close();

		return list;
	}

	public int selectAmount_Total(int m_idx) {
		int total_Amount = 0;

		SqlSession sqlSession = factory.openSession();
		total_Amount = sqlSession.selectOne("cart.cart_total_amount", m_idx);

		sqlSession.close();

		return total_Amount;
	}

	public int insert(CartVo vo) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		
		// 장바구니에 이미 같은 상품이 있으면 해당 레코드의 상품 수 +1.
		List<CartVo> list = sqlSession.selectList("cart.cart_list_idx", vo.getM_idx());
		for (CartVo cartVo : list) {
			if(cartVo.getP_idx() == vo.getP_idx()) {
				vo = cartVo;
				vo.setC_cnt(cartVo.getC_cnt()+1);
				update(vo);
				
				sqlSession.close();
				return res;
			}
		}
		
		// 장바구니에 새로 들어오는 상품이면 삽입.
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

	public int delete(int c_idx) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);

		res = sqlSession.delete("cart.cart_delete", c_idx);

		sqlSession.close();

		return res;
	}

}
