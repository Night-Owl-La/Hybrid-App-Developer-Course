package com.la.night_owl.output_stream;

import java.io.*;

public class L_File_Output {
	public static void main(String[] args) throws Exception {
		File file = new File("src/com/la/night_owl/output_stream/test.txt");
		OutputStream os = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		
//		os.write("aaaa".getBytes());
		
		osw.write("bbbb");
		
		os.close();
	}
}
