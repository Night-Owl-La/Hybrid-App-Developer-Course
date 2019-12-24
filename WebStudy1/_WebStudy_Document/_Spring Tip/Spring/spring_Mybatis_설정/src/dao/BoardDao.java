package dao;


import org.apache.ibatis.session.SqlSession;

import action.BoardListAction;

public class BoardDao{
	
	SqlSession sqlMapper;
    
	public BoardDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SqlSession getSqlMapper() {
		return sqlMapper;
	}



	public void setSqlMapper(SqlSession sqlMapper) {
		this.sqlMapper = sqlMapper;
	}


	
}
