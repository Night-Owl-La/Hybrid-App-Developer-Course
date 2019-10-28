package com.la.night_owl.input_stream;

import java.io.*;

public class L_File_Input {

	public static void main(String[] args) throws IOException {
		File file = new File("src/com/la/night_owl/input_stream/test.txt");
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		
		while(true) {
//			int ch = inputStream.read();
			int ch = inputStreamReader.read();
			if(ch==-1) break;
			System.out.print((char)ch);
		} // while end
		
		inputStreamReader.close();
		inputStream.close();
	}
}
