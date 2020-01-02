package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.SawonVo;

@Repository("sawon_Dao")
public class SawonDao_Impl implements SawonDao {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<SawonVo> selectList() {
		return sqlSession.selectList("sawon.sawon_list");
	}

	@Override
	public SawonVo selectOne(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(SawonVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(SawonVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(SawonVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
