package com.la.night_owl.echo_client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.la.night_owl.connect_interface.Connect_Interface;

public class EchoClient {
	static Socket client;
	static String message="";
	
	public static void main(String[] args) throws Exception {
		// 클라이언트 생성 : 접속 요청.
		client = new Socket(Connect_Interface.SERVER_IP ,
							Connect_Interface.PORT_NUMBER);
		System.out.println("C : 연결 성공.");
		
		sendMessage();
		
		message = getMessage();
		System.out.println("C : (수신) "+message);
		
	}
	
	private static String getMessage() throws Exception {
		InputStream is = client.getInputStream();
		byte [] buff = new byte[100];
		int len = is.read(buff);
		
		return new String(buff,0,len);
	}
	
	private static void sendMessage() throws Exception {
		String message = "C : Hello Server.";
		OutputStream os = client.getOutputStream();
		os.write(message.getBytes());
		System.out.println("C : (송신) "+message);
	}

}
