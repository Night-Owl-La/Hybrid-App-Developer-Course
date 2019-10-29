package com.la.night_owl.multicast;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import javax.swing.*;

public class L_UDP_Chat_Multicast extends JFrame {
	JTextArea jta_ChattingDisplay;	// 채팅창
	JTextField jtf_Address;
	JTextField jtf_Message;
	
	JList<String> jlist_group;
	
	Font font = new Font("굴림체", Font.BOLD, 20);
	
	String nick_Name = "lll";
	
	DatagramSocket client;

	public L_UDP_Chat_Multicast() {
		super("title");
		this.setSize(300, 300);
		this.setLocation(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		init_Display();
		init_Input();
		init_GroupList();
		init_KeyEvent();
//		init_Socket();
		
		this.pack();
	}

	private void init_GroupList() {
		jlist_group = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist_group);
		jsp.setPreferredSize(new Dimension(120,0));
		this.add(jsp, BorderLayout.EAST);
		
		String[] join_array = {"244,0,0,1","244,0,0,2","244,0,0,3"};
		jlist_group.setListData(join_array);
	}

	private void init_Display() {
		jta_ChattingDisplay = new JTextArea();
		
		JScrollPane jsp = new JScrollPane(jta_ChattingDisplay);
		jsp.setPreferredSize(new Dimension(300, 400));
		this.add(jsp, BorderLayout.CENTER);
		
		jta_ChattingDisplay.setEditable(false);
		jta_ChattingDisplay.setFont(font);
		jta_ChattingDisplay.append("채팅내용 출력 \r\n");
	}
	private void init_Input() {
		JPanel p = new JPanel(new GridLayout(3, 1));
		jtf_Address = new JTextField("255.255.255.255");
		jtf_Message = new JTextField();
		jtf_Address.setFont(font);
		jtf_Message.setFont(font);
		
		JPanel btn_p = new JPanel(new GridLayout(1,2));
		JButton jbt_Join = new JButton("가입");
		JButton jbt_Leave = new JButton("탈퇴");
		btn_p.add(jbt_Join);
		btn_p.add(jbt_Leave);
		
		p.add(jtf_Address);
		p.add(btn_p);
		p.add(jtf_Message);
		
		this.add(p, BorderLayout.SOUTH);
		
		jbt_Join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				joinTo_Group();
			}
		});
		jbt_Leave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				leaveFrom_Group();
			}
		});
		
	}

	protected void joinTo_Group() {
		// TODO Auto-generated method stub
		
	}
	protected void leaveFrom_Group() {
		// TODO Auto-generated method stub
		
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
						jta_ChattingDisplay.append(display_Message);
						jta_ChattingDisplay.setCaretPosition(jta_ChattingDisplay.getDocument().getLength());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	
	public static void main(String[] args) {
		new L_UDP_Chat_Multicast();
	}
}
