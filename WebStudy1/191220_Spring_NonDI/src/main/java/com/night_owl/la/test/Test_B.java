package com.night_owl.la.test;

public class Test_B {
	
	int number1 = 10;
	int number2 = 20;
	
	public Test_B() {
		Test_A_Interface ta = new Test_A();
		System.out.println(ta.add(number1, number2));
	}
}
