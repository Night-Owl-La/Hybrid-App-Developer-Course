package dao;

import java.util.List;

import vo.ProductVo;

public interface ProductDao {

	public List<ProductVo> selectList(String category);  
	public ProductVo selectOne(int idx);  
	public int insert(ProductVo vo);  
	public int update(ProductVo vo);  
	public int delete(int idx);  

}
