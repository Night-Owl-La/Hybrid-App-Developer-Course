//RRN = Resident Registration Number.

package com.la.night_owl.user_RegidentRegistrationNumber;

import java.util.Scanner;

public class UserManagement_Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		UserRRN_Manager userManager = new UserRRN_Manager();
		Scanner scan = new Scanner(System.in);
		
		String resident_Registration_Number=null;	// 주민등록번호
		
		while(true) {
			System.out.println("Push Your Resident Registration Number | form-> 123456-1234567");
			System.out.println("*If you want to close program, push 'EXIT'");
			
			closeProgram(resident_Registration_Number=scan.next());
			
			userManager.setResident_Registration_Number(resident_Registration_Number);
			userManager.display_AllInfo();
			
		} // while end
		
	}
	
	public static void closeProgram(String in) {
		if(in.equalsIgnoreCase("EXIT")) System.exit(0);
	}

}
