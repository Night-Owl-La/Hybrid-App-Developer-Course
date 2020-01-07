package dao.product_dao;

import java.util.List;

import vo.product_vo.ProductVo;

public interface ProductDao {
	List<ProductVo> list();
	ProductVo selectOne(int idx);
	ProductVo selectOne(String name);
	int insert(ProductVo vo);
	int update(ProductVo vo);
	int delete(int idx);
	int delete(String name);
}