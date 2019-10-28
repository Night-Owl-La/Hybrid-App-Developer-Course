package com.la.night_owl.input_stream;

import java.io.*;
import java.net.*;

// https://www.naver.com
public class L_Network_Input {
	public static void main(String[] args) throws Exception {
		
		String str_url = "https://www.naver.com/";
		URL url = new URL (str_url);
		InputStream inputStream = url.openStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
		BufferedReader bufferedInputStream = new BufferedReader(inputStreamReader);
		
		while(true) {
//			int ch = inputStream.read();
//			int ch = inputStreamReader.read();
			String readStr = bufferedInputStream.readLine();
			if(readStr==null) break;
			System.out.println(readStr);
		} // while end
		bufferedInputStream.close();
		inputStreamReader.close();
		inputStream.close();
	}
}
