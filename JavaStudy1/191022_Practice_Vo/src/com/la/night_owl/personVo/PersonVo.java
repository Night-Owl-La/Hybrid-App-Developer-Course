package com.la.night_owl.personVo;

import java.util.Arrays;

public class PersonVo {
		String name;
		String addr;
		int age;
		PersonComp pComp;
		
		public PersonVo() {
			super();
		}
		public PersonVo(String name, int age, String addr) {
			super();
			this.name = name;
			this.addr = addr;
			this.age = age;
			
		}

		@Override
		public String toString() {
		return String.format("[%s-%d-%s]", this.name, this.age, this.addr);
		}
		
		public String getName() {
			return name;
		}
		public String getAddr() {
			return addr;
		}
		public int getAge() {
			return age;
		}
		public static void main(String[] args) {
			int [] nr = { 7, 6, 5, 4, 3, 2, 1};
			
			Arrays.sort(nr);
			
			for (int $i : nr) {
				System.out.printf(" %d", $i);
			}
			System.out.println();
			
			// ------------------------------------------------------- //
			
			PersonVo [] p_array= {
				new PersonVo("A", 1 ,"丑"),
				new PersonVo("E", 4 ,"元"),
				new PersonVo("H", 2 ,"之"),
				new PersonVo("W", 7 ,"中"),
				new PersonVo("B", 5 ,"六"),
			};
			
			PersonComp pComp = new PersonComp();
			Arrays.sort(p_array, pComp);
			pComp.setSort_method(PersonComp.SORT_METHOD_DESC);
			Arrays.sort(p_array, pComp);
			
			for (PersonVo personVo : p_array) {
				System.out.println(personVo);
			}
			
		}
		
}
