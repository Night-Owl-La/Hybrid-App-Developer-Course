package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVo;
import vo.ProductVo;

public class ProductDao {
	static ProductDao single = null;

	SqlSessionFactory factory;

	public ProductDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static ProductDao getInstance() {

		if (single == null)
			single = new ProductDao();

		return single;
	}

	public List<ProductVo> selectList(String category) {

		List<ProductVo> list = null;

		SqlSession sqlSession = factory.openSession();

		list = sqlSession.selectList("product.product_list", category);

		sqlSession.close();

		return list;
	}

	public ProductVo selectOne(int idx) {
		ProductVo vo = null;

		SqlSession sqlSession = factory.openSession();

		vo = sqlSession.selectOne("product.product_one", idx);

		sqlSession.close();

		return vo;
	}

	public int insert(ProductVo vo) {
		int res = 0;
		SqlSession sqlSession = factory.openSession(true);

		res = sqlSession.insert("product.product_insert", vo);

		sqlSession.close();

		return res;
	}
	
	public int update(ProductVo vo) {
		int res = 0;

		SqlSession sqlSession = factory.openSession(true);

		res = sqlSession.update("product.product_update", vo);

		sqlSession.close();

		return res;
	}
	
	public int delete(int idx) {
		int res;
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.delete("product.product_delete", idx);
		
		sqlSession.close();
		
		return res;
	}
	
	

}
