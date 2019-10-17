package com.la.night_owl.constructor_test1;

public class Constructor_Test_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Constructor_Test_Date ctd = new Constructor_Test_Date();
		Constructor_Test_Date ctd1 = new Constructor_Test_Date(1111);
		Constructor_Test_Date ctd2 = new Constructor_Test_Date(2222, 22);
		Constructor_Test_Date ctd3 = new Constructor_Test_Date(3333, 33, 33);
		
		ctd.displayDate();
		ctd1.displayDate();
		ctd2.displayDate();
		ctd3.displayDate();
	}

}
