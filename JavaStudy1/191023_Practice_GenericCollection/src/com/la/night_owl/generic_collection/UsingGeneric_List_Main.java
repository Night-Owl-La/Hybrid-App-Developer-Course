package com.la.night_owl.generic_collection;

import java.util.ArrayList;
import java.util.List;

public class UsingGeneric_List_Main {

	public static void main(String[] args) {
		// Case 1. not using the Generic.
		List list = new ArrayList();
		list.add("Hello");
		String msg = (String) list.get(0);
		
		// Case 2. using the Generic.
		List<String> list_1 = new ArrayList<String>();
		list_1.add("Hello");
		String msg1=list_1.get(0);
		
		
	}

}
