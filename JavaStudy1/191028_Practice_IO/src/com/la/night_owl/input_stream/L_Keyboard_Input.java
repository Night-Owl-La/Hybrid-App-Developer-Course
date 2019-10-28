package com.la.night_owl.input_stream;

import java.io.*;

public class L_Keyboard_Input {

	public static void main(String[] args) throws IOException {
//		InputStream inputStream = System.in;
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		System.out.println("EXIT : ctrl+z");
		
		while(true) {
//			int ch = inputStream.read();
			int ch = inputStreamReader.read();
			if(ch==-1) break;
			System.out.print((char)ch);
		} // while end
		
		inputStreamReader.close();
//		inputStream.close();
	}
}
