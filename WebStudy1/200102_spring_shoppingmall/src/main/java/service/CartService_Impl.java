package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CartDao;
import vo.CartVo;

@Service("cart_Service")
public class CartService_Impl implements CartService {

	@Autowired
	CartDao cart_Dao;

	@Override
	public List<CartVo> selectList(int m_idx) {
		return cart_Dao.selectList(m_idx);
	}

	@Override
	public int selectAmount_Total(int m_idx) {
		return cart_Dao.selectAmount_Total(m_idx);
	}

	@Override
	public int insert(CartVo vo) {
		int res = cart_Dao.insert(vo);
		return res;
	}

	@Override
	public int update(CartVo vo) {
		int res = cart_Dao.update(vo);
		return res;
	}

	@Override
	public int delete(int c_idx) {
		int res = cart_Dao.delete(c_idx);
		return res;
	}

}
