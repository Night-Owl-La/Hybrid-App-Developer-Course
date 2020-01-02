package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.ProductVo;

@Repository ("product_Dao")
public class ProductDao_Impl implements ProductDao {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<ProductVo> selectList(String category) {
		return sqlSession.selectList("product.product_list", category);
	}

	@Override
	public ProductVo selectOne(int idx) {
		return sqlSession.selectOne("product.product_one", idx);
	}

	@Override
	public int insert(ProductVo vo) {
		int res = sqlSession.insert("product.product_insert", vo);
		return res;
	}

	@Override
	public int update(ProductVo vo) {
		int res = sqlSession.update("product.product_update", vo);
		return res;
	}

	@Override
	public int delete(int idx) {
		int res = sqlSession.delete("product.product_delete", idx);
		return res;
	}

}
