package com.la.night_owl.generic_collection;

import java.util.*;

public class Set_Test_Main {
		public static void main(String[] args) {
			Set<String> set = new HashSet<String>();
			
			set.add("A");
			set.add("E");
			set.add("B");
			set.add("D");
			set.add("W");
			set.add("F");
			
			System.out.println(set);
			
			for (Iterator iterator = set.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				
			}
			
		}
}
