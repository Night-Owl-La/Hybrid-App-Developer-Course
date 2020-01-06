package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Test2Dao;
import dao.TestDao;

public class TestService_Impl implements TestService {

	TestDao test_Dao;
	Test2Dao test2_Dao;

	public TestDao getTest_Dao() {
		return test_Dao;
	}

	public void setTest_Dao(TestDao test_Dao) {
		this.test_Dao = test_Dao;
	}

	public Test2Dao getTest2_Dao() {
		return test2_Dao;
	}

	public void setTest2_Dao(Test2Dao test2_Dao) {
		this.test2_Dao = test2_Dao;
	}

	@Override
	public Map list() {

		List alphabet_List = test_Dao.list();
		List number_List = test2_Dao.list();
		
		try {
			Thread.sleep(1234);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map map = new HashMap();
		map.put("alphabet_List", alphabet_List);
		map.put("number_List", number_List);

		return map;
	}
}
