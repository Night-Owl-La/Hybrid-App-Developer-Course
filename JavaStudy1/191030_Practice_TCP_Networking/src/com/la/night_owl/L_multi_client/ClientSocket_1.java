package com.la.night_owl.L_multi_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.la.night_owl.connect_interface.Connect_Interface;
import com.la.night_owl.connect_interface.User_Interface;

public class ClientSocket_1 {
	Socket client;
	private List<String>		user_List = new ArrayList<String>();

	public ClientSocket_1() {
		init_Client();
		send_ClientInfo();
		read_Message();
	}

	public List<String> getUser_List() {
		return user_List;
	}

	public void setUser_List(List<String> user_List) {
		this.user_List = user_List;
	}

	public void init_Client() {
		try { client = new Socket(Connect_Interface.SERVER_IP, Connect_Interface.PORT_NUMBER); } catch (IOException e) {}
	}
	
	public void close_Client() {
		try { client.close(); } catch (IOException e) {}
	}
	
	public void send_ClientInfo() {
		String send_data = String.format("IN#%s\n", User_Interface.USER_ID);
		try { client.getOutputStream().write(send_data.getBytes()); } 
		catch (IOException e) {}
	}
	
	public void read_Message() {
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(client.getInputStream());
			BufferedReader bfr = new BufferedReader(isr);
			
			new Thread(){
				public void run() {
					while(true) {
						String message;
						try {
							message = bfr.readLine();
							if(message==null) break;
							String [] msgs = message.split("#");
							
							service_Cotrol(msgs, message);
							
						} catch (IOException e) { break;}
						
					}// while end
				};
			}.start();
			
		} catch (IOException e) {}
	}
	
	public void service_Cotrol(String [] msgs, String message) {
		if(msgs[0].equals("IN")) {	// 입장처리
		}else if(msgs[0].equals("OUT")) {	// 퇴장처리
		}else if(msgs[0].equals("LIST")) {	// 목록처리
			display_UserList(message);
		}else if(msgs[0].equals("MSG")) {	// 대화처리
		}else if(msgs[0].equals("DRAW")) {	// 그림처리
		}
	}

	private void display_UserList(String message) {
		message = message.replaceAll("LIST#", "");
		user_List.add(message.split("#").toString());
		System.out.println("!!!!!!!!");
	}
	
	
}
