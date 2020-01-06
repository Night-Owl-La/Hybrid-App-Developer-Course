package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

public class TestDao_Impl implements TestDao {

	@Override
	public List list() {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		
		return list;
	}

}

