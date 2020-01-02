package dao;

import java.util.List;

import vo.CartVo;

public interface CartDao {
	
	public List<CartVo> selectList(int m_idx);
	public int selectAmount_Total(int m_idx); 
	public int insert(CartVo vo); 
	public int update(CartVo vo); 
	public int delete(int c_idx);
	
}
