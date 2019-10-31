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
	private List<String>		user_List = new ArrayList<String>();
	
	private Object syncObject = new Object();
	
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
				
			} catch (IOException e) {}
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
	public List<String> getUser_List() {
		return user_List;
	}

	public void setUser_List(List<String> user_List) {
		this.user_List = user_List;
	}

	public void sendUser_List() {
		StringBuffer stringBuffer = new StringBuffer("LIST#");
		for (String user : user_List) {
			stringBuffer.append(user);
			stringBuffer.append("#");
		}
		stringBuffer.append("\n");
		
		String send_data = stringBuffer.toString();
		send_Message_all(send_data);
	}

	private void send_Message_all(String send_data) {
		for (ChildSocket childSocket : socket_List) {
			try {
				childSocket.child.getOutputStream().write(send_data.getBytes());
			} catch (IOException e) {}
		}
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
			} catch (IOException e) {}
		}

		@Override
		public void run() {
			while(true) {
				try {
					String message = bfr.readLine();
					if(message==null) break;
					
					String [] msgs = message.split("#");
					
					if(msgs[0].equals("IN")) {	// 입장처리
						synchronized (syncObject) {
							user_List.add(msgs[1]);
							sendUser_List();						
						}
					}
					
				} catch (IOException e) { break; }
			} // while end
			System.out.println("연결 끊어짐"); // TODO DELETE
			
			synchronized (syncObject) {
				user_List.remove(getDelete_Index());
				sendUser_List();
				} // 퇴장 처리.
			
			ServerSocket_1.this.socket_List.remove(this);
			setUserCount(socket_List.size());
		} // run end
		
		public int getDelete_Index() {
			return socket_List.indexOf(this);
		}
		
		public String getDelete_NickName() {
			return user_List.get(getDelete_Index());
		}
		
		
	} // class ChildSocket end
	
	
}
