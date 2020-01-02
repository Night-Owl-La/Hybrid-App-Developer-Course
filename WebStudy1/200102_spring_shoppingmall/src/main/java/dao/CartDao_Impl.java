package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.CartVo;

@Repository("cart_Dao")
public class CartDao_Impl implements CartDao {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<CartVo> selectList(int m_idx) {
		return sqlSession.selectList("cart.cart_list_idx", m_idx);
	}

	@Override
	public int selectAmount_Total(int m_idx) {

		return sqlSession.selectOne("cart.cart_total_amount", m_idx);
	}

	@Override
	public int insert(CartVo vo) {
		int res = 0;
		
		// 장바구니에 이미 같은 상품이 있으면 해당 레코드의 상품 수 +1.
		List<CartVo> list = sqlSession.selectList("cart.cart_list_idx", vo.getM_idx());
		for (CartVo cartVo : list) {
			if (cartVo.getP_idx() == vo.getP_idx()) {
				vo = cartVo;
				vo.setC_cnt(cartVo.getC_cnt() + 1);
				update(vo);
				return res;
			}
		}
		res = sqlSession.insert("cart.cart_insert", vo);

		return res;
	}

	@Override
	public int update(CartVo vo) {
		int res = sqlSession.update("cart.cart_update", vo);
		return res;
	}

	@Override
	public int delete(int c_idx) {
		int res = sqlSession.delete("cart.cart_delete", c_idx);
		return res;
	}

}
