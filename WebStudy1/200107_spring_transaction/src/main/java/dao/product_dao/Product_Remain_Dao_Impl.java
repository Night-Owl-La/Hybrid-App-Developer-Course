package dao.product_dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.product_vo.ProductVo;

public class Product_Remain_Dao_Impl implements ProductDao {

	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Product_Remain_Dao_Impl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ProductVo> list() {
		return sqlSession.selectList("product_remain.product_list");
	}
	
	@Override
	public ProductVo selectOne(int idx) {
		return sqlSession.selectOne("product_remain.product_one_idx", idx);
	}

	@Override
	public ProductVo selectOne(String name) {
		return sqlSession.selectOne("product_remain.product_one_name", name);
	}

	@Override
	public int insert(ProductVo vo) {
		return sqlSession.insert("product_remain.product_insert", vo);
	}

	@Override
	public int update(ProductVo vo) {
		return sqlSession.update("product_remain.product_update", vo);
	}

	@Override
	public int delete(int idx) {
		return sqlSession.delete("product_remain.product_delete", idx);
	}
	
	@Override
	public int delete(String name) {
		return sqlSession.delete("product_remain.product_delete_name", name);
	}

}
