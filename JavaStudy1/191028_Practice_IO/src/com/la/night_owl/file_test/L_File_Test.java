package com.la.night_owl.file_test;

import java.io.*;

public class L_File_Test {
	public static void main(String[] args) throws IOException {
		File file = new File("src/com/la/night_owl/file_test/test");

		File [] f_array = file.listFiles();
		
		for (File file2 : f_array) {
			String kind = "";

			if(file2.isDirectory()) kind = "폴더";
			if(file2.isHidden()) kind += "숨김";
			if(file2.isFile()) kind += "파일";
			if(file2.isAbsolute()) kind += "유일";
			
			System.out.printf("%s | %s | %d", kind, file2.getName(), file2.length());
			System.out.println();
			
			if(file2.getName().equals("삭제할파일.txt")) {
				file2.delete();
				System.out.println("####삭제됨");
			}
			
		}//for end
	}
}
