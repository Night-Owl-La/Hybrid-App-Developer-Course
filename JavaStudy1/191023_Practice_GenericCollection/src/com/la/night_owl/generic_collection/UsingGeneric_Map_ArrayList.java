package com.la.night_owl.generic_collection;

import java.util.*;

public class UsingGeneric_Map_ArrayList {
	public static void main(String[] args) {
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		Map<String, PersonVo> p_map = new HashMap<String, PersonVo>();
		
		for(int i=1; i<=100; i++) {
			String name = String.format("길동_%03d", i);
			int age = 20+i%11;
			String tel = String.format("010-%d11-1234", i%10);
			
			PersonVo p = new PersonVo(name, age, tel);
			
			p_list.add(p);
			p_map.put(name, p);
		}
		
		// 연산 횟수 체크.
		
		String search_name="길동_050";
		int count=0;
		
		for (PersonVo personVo : p_list) {
			count ++;
			if(personVo.getName().equals(search_name)) System.out.println(count);
		}
		
		System.out.println(p_map.get(search_name));
	
	}
	
}
