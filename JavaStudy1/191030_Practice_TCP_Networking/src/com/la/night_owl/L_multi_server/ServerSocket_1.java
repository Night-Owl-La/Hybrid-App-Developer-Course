package com.la.night_owl.L_multi_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.la.night_owl.connect_interface.Connect_Interface;

public class ServerSocket_1 {
	private ServerSocket 		server;
	private String 				message="초기값";
	private int 				userCount=0;
	private List<ChildSocket> 	socket_List = new ArrayList<ChildSocket>();
	
	public ServerSocket_1() {
		init_Server();
	}

	
	private void init_Server(){
			try {
				server = new ServerSocket(Connect_Interface.PORT_NUMBER);
				
				new Thread() {
					@Override
					public void run() {
						while(true) {
							try {
								ChildSocket child = new ChildSocket(server.accept());
								child.start();
								
								socket_List.add(child);
								
								System.out.println("연결 성공 - 쓰레드 작동중"); //TODO DELETE THIS LINE
								setUserCount(socket_List.size());
							} catch (Exception e) {
								setMessage("연결 실패.");
							}
						} // while() end.
					}// run() end.
				}.start();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public int getUserCount() {
		return this.userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	class ChildSocket extends Thread {	// Inner Class
		Socket child;
		BufferedReader bfr;
		
		public ChildSocket(Socket child) {
			this.child = child;
			try {
				InputStream is			 = child.getInputStream();
				InputStreamReader isr	 = new InputStreamReader(is);
				bfr = new BufferedReader(isr);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public void run() {
			while(true) {
				try {
					String message = bfr.readLine();
					if(message==null) break;
				} catch (IOException e) {
					break;
				}
			} // while end
			System.out.println("연결 끊어짐"); // TODO DELETE
			ServerSocket_1.this.socket_List.remove(this);
			setUserCount(socket_List.size());
		} // run end
		
	} // class ChildSocket end
	
	
}
