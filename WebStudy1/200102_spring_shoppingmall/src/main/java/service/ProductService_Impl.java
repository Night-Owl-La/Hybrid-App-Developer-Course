package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDao;
import vo.ProductVo;

@Service("product_Service")
public class ProductService_Impl implements ProductService {
	
	@Autowired
	ProductDao product_Dao;

	@Override
	public List<ProductVo> selectList(String category) {
		return product_Dao.selectList(category);
	}

	@Override
	public ProductVo selectOne(int idx) {
		return product_Dao.selectOne(idx);
	}

	@Override
	public int insert(ProductVo vo) {
		int res = product_Dao.insert(vo);
		return res;
	}

	@Override
	public int update(ProductVo vo) {
		int res = product_Dao.update(vo);
		return res;
	}

	@Override
	public int delete(int idx) {
		int res = product_Dao.delete(idx);
		return res;
	}

}
