package service.product_service;

import java.util.Map;

import vo.product_vo.ProductVo;

public interface ProductService {
	public Map selectList();
	public int insert_in(ProductVo vo);
	public int insert_out(ProductVo vo) throws Exception;
	public int delete_in(int idx) throws Exception;
	public int delete_out(int idx) throws Exception;
}

