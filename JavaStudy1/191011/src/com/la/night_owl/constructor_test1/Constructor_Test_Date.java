package com.la.night_owl.constructor_test1;

import java.util.Calendar;

public class Constructor_Test_Date {
	private int year;
	private int month;
	private int date;

	public Constructor_Test_Date() {
		// TODO Auto-generated constructor stub
		Calendar calendar = Calendar.getInstance();
		this.year = calendar.get(Calendar.YEAR);
		this.month = calendar.get(Calendar.MONTH)+1;
		this.date = calendar.get(Calendar.DATE);
	}
	public Constructor_Test_Date(int year) {
		this();
		this.year = year;
	}
	public Constructor_Test_Date(int year, int month) {
		this(year);
		this.month = month;
	}
	public Constructor_Test_Date(int year, int month, int date) {
		this(year,month);
		this.date = date;
	}
	
	public void displayDate() {
		System.out.println(year+"-"+month+"-"+date);
	}

}
