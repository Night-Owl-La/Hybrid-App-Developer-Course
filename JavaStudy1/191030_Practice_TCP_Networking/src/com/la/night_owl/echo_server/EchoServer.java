package com.la.night_owl.echo_server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.la.night_owl.connect_interface.Connect_Interface;

public class EchoServer {
	static ServerSocket server;
	static Socket child;
	static String message;
	public static void main(String[] args) throws Exception {
		
		// 서버소켓 생성 : 포트 할당.
		server = new ServerSocket(Connect_Interface.PORT_NUMBER);
		System.out.println("S : # 서버 대기중");
		
		while(true) {
			// sub Socket 생성 : 클라이언트 연결요청 접속.
			child = server.accept();
			message = getMessage();
			System.out.println("S : (수신) " + message);
			
			sendMessage();
			
			// 클라이언트 주소 받아내기.
//			InetAddress ia = child.getInetAddress();
//			System.out.printf("[%s] 접속", ia.getHostAddress());
		}
	}
	
	private static void sendMessage() throws Exception {
		OutputStream os = child.getOutputStream();
		os.write("S : 수신함.".getBytes());
	}

	private static String getMessage() throws Exception {
		InputStream is = child.getInputStream();
		byte [] buff = new byte[100];
		int len = is.read(buff);
		
		return new String(buff,0,len);
	}

}
