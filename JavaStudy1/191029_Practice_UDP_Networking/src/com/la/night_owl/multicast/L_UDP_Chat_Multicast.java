package com.la.night_owl.multicast;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import javax.swing.*;
import java.util.*;

public class L_UDP_Chat_Multicast extends JFrame {
	public static final String MULTI_CAST_ADDRESS = "224.0.0.2";
	public static final int PORT_ID = 6000;
	
	JTextArea jta_ChattingDisplay;	// 채팅창
	JTextField jtf_Address;
	JTextField jtf_Message;
	
	JList<String> jlist_group;	// 우측 주소창
	java.util.List<String> group_List = new ArrayList<String>();
	
	Font font = new Font("굴림체", Font.BOLD, 20);
	
	String nick_Name = "lll";
	
	MulticastSocket client;

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
		init_Socket();
		
		this.pack();
	}

	private void init_GroupList() {
		jlist_group = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist_group);
		jsp.setPreferredSize(new Dimension(120,0));
		this.add(jsp, BorderLayout.EAST);
		
//		String[] join_array = {"244,0,0,1","244,0,0,2","244,0,0,3"};
//		jlist_group.setListData(join_array);
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
		jtf_Address = new JTextField(MULTI_CAST_ADDRESS);
		jtf_Message = new JTextField();
		jtf_Address.setFont(font);
		jtf_Message.setFont(font);
		
		JPanel btn_Panel = new JPanel(new GridLayout(1,2));
		JButton btn_Join = new JButton("가입");
		JButton btn_Leave = new JButton("탈퇴");
		btn_Panel.add(btn_Join);
		btn_Panel.add(btn_Leave);
		
		p.add(jtf_Address);
		p.add(btn_Panel);
		p.add(jtf_Message);
		
		this.add(p, BorderLayout.SOUTH);
		
		btn_Join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				joinTo_Group();
			}
		});
		btn_Leave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				leaveFrom_Group();
			}
		});
		
	}

	protected void joinTo_Group() {
		String ipAddr = jtf_Address.getText().trim();
		// 1. 내용이 비어있으면
		if(ipAddr.isEmpty()) { JOptionPane.showMessageDialog(this, "가입할 주소를 입력하세요."); return; }
		
		// 2. 가입 여부 확인.
		if(group_List.contains(ipAddr)) { JOptionPane.showMessageDialog(this, "이미 가입된 주소임."); return; }
		
		try {
			// 가입 시킴.
			InetAddress ia = InetAddress.getByName(ipAddr);
			client.joinGroup(ia);
			group_List.add(ipAddr);
			
			//(EAST)창에 가입목록 출력.
			String [] group_array = new String[group_List.size()];
			group_List.toArray(group_array);
			
			jlist_group.setListData(group_array);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("실패");
		}
		
	}
	protected void leaveFrom_Group() {
		String ipAddr = jlist_group.getSelectedValue();
		// 1. 내용이 비어있으면
		if(ipAddr==null || ipAddr.isEmpty()) { JOptionPane.showMessageDialog(this, "탈퇴할 주소를 입력해주세요."); return; }
		// 2. 가입 여부 확인.
		if(! group_List.contains(ipAddr)) { JOptionPane.showMessageDialog(this, "없는 주소임."); return; }
		
		int result = JOptionPane.showConfirmDialog(this, "정말 탈퇴합니까?", "그룹탈퇴", JOptionPane.YES_NO_OPTION);
		if(result==JOptionPane.NO_OPTION) return; 
		
		try {
			// 탈퇴 시킴.
			InetAddress ia = InetAddress.getByName(ipAddr);
			client.leaveGroup(ia);
			group_List.remove(ipAddr);
			
			//(EAST)창에 가입목록 출력.
			String [] group_array = new String[group_List.size()];
			if(group_array.length == -1) { group_array= new String[0];}	// 널 포인트 익셉션 핸들링.
			group_List.toArray(group_array);
			
			jlist_group.setListData(group_array);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("실패");
		}
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
			DatagramPacket dp = new DatagramPacket(send_buff, send_buff.length, ia, PORT_ID);
			client.send(dp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jtf_Message.setText("");
		
	}
	private void init_Socket() {
		try {
			client = new MulticastSocket(PORT_ID);
			read_Message();
		} catch (Exception e) {
			
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
