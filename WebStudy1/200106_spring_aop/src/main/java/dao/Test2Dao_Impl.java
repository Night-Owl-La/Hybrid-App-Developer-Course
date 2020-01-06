package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

public class Test2Dao_Impl implements Test2Dao {

	@Override
	public List list() {
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");

		return list;
	}
}