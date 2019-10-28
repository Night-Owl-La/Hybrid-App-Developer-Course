package com.la.night_owl.output_stream;

import java.io.IOException;
import java.io.OutputStream;

public class L_Monitor_Output {
	public static void main(String[] args) throws IOException {
		OutputStream os = System.out;
		
		String msg = "ㅎㅇ";
		
		os.write(msg.getBytes());
		os.write(65);
		os.flush();
	}
}
