package com.la.night_owl.Singleton_test;

public class Singletone_test1 {
	
	private static Singletone_test1 singletone_test1 = new Singletone_test1();
	
	private Singletone_test1() {
		// TODO Auto-generated constructor stub
		System.out.println("Singleton_test1 is instanced.");
	}

	public static Singletone_test1 getInstance() { return singletone_test1;	}
	public int add(int n1, int n2) { return n1+n2; }

}
