package com.la.night_owl.generic_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonVo_ArrayList {
		public static void main(String[] args) {
			List<PersonVo> p_list = new ArrayList<PersonVo>();
			
			p_list.add(new PersonVo("GRE", 30, "010-111-1234"));
			p_list.add(new PersonVo("TRE", 20, "010-222-1234"));
			p_list.add(new PersonVo("WRE", 15, "010-333-1234"));
			p_list.add(new PersonVo("FRE", 50, "010-444-1234"));
			
			for (PersonVo personVo : p_list) {
				System.out.println(personVo.toString());
			}
			
			//---------------------------------//
			
			List<Integer> list = new ArrayList<Integer>();
			for (int $i = 0; $i < 5; $i++) list.add(-$i);
			
			Collections.sort(list);
			
			for (Integer integer : list) System.out.println(integer);
			
		}
}
