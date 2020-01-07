package dao.product_dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.product_vo.ProductVo;

public class Product_Out_Dao_Impl implements ProductDao {

	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Product_Out_Dao_Impl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ProductVo> list() {
		return sqlSession.selectList("product_out.product_list");
	}
	
	@Override
	public ProductVo selectOne(int idx) {
		return sqlSession.selectOne("product_out.product_one_idx", idx);
	}

	@Override
	public ProductVo selectOne(String name) {
		return sqlSession.selectOne("product_out.product_one_name", name);
	}

	@Override
	public int insert(ProductVo vo) {
		return sqlSession.insert("product_out.product_insert", vo);
	}

	@Override
	public int update(ProductVo vo) {
		return sqlSession.update("product_out.product_update", vo);
	}

	@Override
	public int delete(int idx) {
		return sqlSession.delete("product_out.product_delete", idx);
	}

	@Override
	public int delete(String name) {
		// TODO Auto-generated method stub
		return 0;
	}
}
