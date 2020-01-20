package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.VisitVo;

@Repository("visit_dao")
public class VisitDao {
	
	@Autowired
	SqlSession sqlSession;

	// 방명록 조회
	public List<VisitVo> selectList() {
		List<VisitVo> list = null;
		/*/		Spring이 해줌
		 * 		Spring 객체
		 * 		SqlSessionTemplate기능 : 1)openSession()	3)close()
		 * // 1.작업객체 가져오기 SqlSession sqlSession = factory.openSession();
		 */
		// 2.작업
		list = sqlSession.selectList("visit.visit_list");
		/*		Spring이 해줌
		 * // 3.반환하기 sqlSession.close();
		 */
		
		return list;
	}
	
	
	public List<VisitVo> selectList(Map map) {
		List<VisitVo> list = null;
		
		// 2.작업
		list = sqlSession.selectList("visit.visit_list_condition", map);
				
		return list;
	}
	
	// 방명록 1건 가져오기(idx에 해당되는 게시글)
	public VisitVo selectOne(int idx) {
		VisitVo vo = null;
		
		// 2.작업
		vo = sqlSession.selectOne("visit.visit_one", idx);
				
		return vo;
	}
	
	// 방명록 추가
	public int insert(VisitVo vo) {
		int res = 0;
		
		// 2.작업
		res = sqlSession.insert("visit.visit_insert", vo);
				
		return res;
	}
	
	// 방명록수정
	public int update(VisitVo vo) {
		int res = 0;
		
		// 2.작업
		res = sqlSession.update("visit.visit_update", vo);
		
		return res;
	}
	
	// 방명록 삭제
	public int delete(int idx) {
		int res = 0;
		// 2.작업
		res = sqlSession.delete("visit.visit_delete", idx);
		
		return res;
	}

}
