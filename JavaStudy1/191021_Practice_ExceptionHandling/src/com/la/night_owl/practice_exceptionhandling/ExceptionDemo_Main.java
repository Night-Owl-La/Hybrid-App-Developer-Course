package com.la.night_owl.practice_exceptionhandling;

public class ExceptionDemo_Main {

	public static void main(String[] args) {
		
		_ArrayList_Demo list = new _ArrayList_Demo();
		
		list.add("asd");
		list.add("ert");
		list.add("123");
		list.add("789");
		
		try {
			list.get(4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			list.remove(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println(list.size());
		
		for (int i = 0; i < list.size(); i++) {
			try {
				System.out.println(list.get(i));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}			
		}
		
		
	}
}
