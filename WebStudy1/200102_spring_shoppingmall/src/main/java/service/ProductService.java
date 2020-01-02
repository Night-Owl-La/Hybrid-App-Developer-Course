package service;

import java.util.List;

import vo.ProductVo;

public interface ProductService {

	public List<ProductVo> selectList(String category);  
	public ProductVo selectOne(int idx);  
	public int insert(ProductVo vo);  
	public int update(ProductVo vo);  
	public int delete(int idx);  

}
