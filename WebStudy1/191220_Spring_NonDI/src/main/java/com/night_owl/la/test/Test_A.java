package com.night_owl.la.test;

public class Test_A implements Test_A_Interface {

	int number1;
	int number2;

	public Test_A() {
		number1 = 1;
		number2 = 2;
		sub();
	}

	@Override
	public int add(int number1, int number2) {
		System.out.println("start add.");
		
		return number1+number2;
	}

	public void sub() {
		System.out.println("sub");
		System.out.println(number1-number2);
	}

}
