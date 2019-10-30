package com.la.night_owl.udp_networking;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import javax.swing.*;

public class L_UDP_Chat_Broadcast extends JFrame {
	JTextArea jta_Display;
	JTextField jtf_Address;
	JTextField jtf_Message;
	Font font = new Font("굴림체", Font.BOLD, 20);
	
	String nick_Name = "lll";
	
	DatagramSocket client;

	public L_UDP_Chat_Broadcast() {
		super("title");
		this.setSize(300, 300);
		this.setLocation(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		init_Display();
		init_Input();
		init_KeyEvent();
		init_Socket();
		
		this.pack();
	}

	private void init_Display() {
		jta_Display = new JTextArea();
		
		JScrollPane jsp = new JScrollPane(jta_Display);
		jsp.setPreferredSize(new Dimension(300, 400));
		this.add(jsp, BorderLayout.CENTER);
		
		jta_Display.setEditable(false);
		jta_Display.setFont(font);
		jta_Display.append("채팅내용 출력 \r\n");
	}
	
	private void init_Input() {
		JPanel p = new JPanel(new GridLayout(2, 1));
		jtf_Address = new JTextField("255.255.255.255");
		jtf_Message = new JTextField();
		
		jtf_Address.setFont(font);
		jtf_Message.setFont(font);
		
		p.add(jtf_Address);
		p.add(jtf_Message);
		
		this.add(p, BorderLayout.SOUTH);
	}
	private void init_KeyEvent() {
		KeyAdapter adapter = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				send_Message();
			}
		};
		jtf_Message.addKeyListener(adapter);
	}
	protected void send_Message() {
		String message = jtf_Message.getText().trim();
		if(message.isEmpty()) {
			jtf_Message.setText("");
			return;
		}
		
		try {
			String send_Data = String.format("%s#%s", nick_Name, message);
			String ip = jtf_Address.getText();
			InetAddress ia = InetAddress.getByName(ip);
			
			byte [] send_buff = send_Data.getBytes();
			DatagramPacket dp = new DatagramPacket(send_buff, send_buff.length, ia, 5000);
			client.send(dp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jtf_Message.setText("");
		
	}
	private void init_Socket() {
		try {
			client = new DatagramSocket(5000);
			read_Message();
		} catch (SocketException e) {
			
			e.printStackTrace();
		}
	}


	private void read_Message() {
		new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						byte[] read_buff = new byte[512];
						DatagramPacket dp = new DatagramPacket(read_buff, read_buff.length);
						client.receive(dp);
						
						byte[] read_data = dp.getData();
						
						String read_Message = new String(read_data).trim();
						String [] msg_array = read_Message.split("#");
						
						String display_Message = String.format("[%s] : %s\r\n", msg_array[0], msg_array[1]);
						jta_Display.append(display_Message);
						jta_Display.setCaretPosition(jta_Display.getDocument().getLength());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}


	
	
	
	
	
	public static void main(String[] args) {
		new L_UDP_Chat_Broadcast();
	}
}
