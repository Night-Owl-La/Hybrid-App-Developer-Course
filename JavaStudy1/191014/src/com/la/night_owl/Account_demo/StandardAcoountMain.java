package com.la.night_owl.Account_demo;

public class StandardAcoountMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StandardAccount user1 = new StandardAccount("È«±æµ¿", 100000);
		StandardAccount user2 = new StandardAccount("±èÈ«µ¿", 200000);
		StandardAccount user3 = new StandardAccount("µ¿È«±è", 300000);
		
		user1.display_AllUserinfo();
		System.out.println();
		user2.display_AllUserinfo();
		System.out.println();
		user3.display_AllUserinfo();
	}

}
