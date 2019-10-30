package com.la.night_owl.L_multi_server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiServer extends JFrame {
	
	private JTextArea		jta_Monitor;
	private JTextField		jtf_UserCount;
	private JList<String>	jlist_UserList;
	
	private ServerSocket_1 s_Socket;
	
	private Font font = new Font("맑은 고딕", Font.BOLD, 20);
	
	
	public MultiServer() {
		super("title");
		this.setLocation(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		s_Socket = new ServerSocket_1();
		
		init_Jta_Monitor();
		init_Jtf_UserCount();
		init_Jlist_UserList();
		
		
		display_Message(s_Socket.getMessage());
		
		this.pack();
	}
	
	
	private void init_Jta_Monitor() {
		jta_Monitor = new JTextArea();
		jta_Monitor.setEditable(false);
		jta_Monitor.setFont(font);
		
		JScrollPane jScrollPane = new JScrollPane(jta_Monitor);
		jScrollPane.setPreferredSize(new Dimension(300, 400));
		this.add(jScrollPane, BorderLayout.CENTER);
		
	}
	private void init_Jtf_UserCount() {
		JPanel jPanel = new JPanel(new GridLayout(1, 3));
		
		jtf_UserCount = new JTextField("0");
		JLabel jLabel = new JLabel("접속자 수 : ", JLabel.RIGHT);
		JLabel jLabel2 = new JLabel("(명)");
		
		jLabel.setFont(font);
		jLabel2.setFont(font);
		jtf_UserCount.setFont(font);
		jtf_UserCount.setHorizontalAlignment(JTextField.CENTER);
		
		new Thread() {
			public void run() {
				System.out.println("INIT-USER-COUNT-THREAD START");	//TODO DELETE.
				while(true)
					display_UserCount(s_Socket.getUserCount());
			};
		}.start();
		
		jPanel.add(jLabel);
		jPanel.add(jtf_UserCount);
		jPanel.add(jLabel2);
		
		this.add(jPanel, BorderLayout.SOUTH);
	}
	private void init_Jlist_UserList() {
		jlist_UserList = new JList<String>();
		JScrollPane jScrollPane = new JScrollPane(jlist_UserList);
		jScrollPane.setPreferredSize(new Dimension(120, 0));
		
		this.add(jScrollPane, BorderLayout.EAST);
	}

	private void display_Message(String message) {
		jta_Monitor.append(message + "\r\n");
		entered();
	}
	private void entered() {
		int position = jta_Monitor.getDocument().getLength();
		jta_Monitor.setCaretPosition(position);
	}
	
	private void display_UserCount(int userCount) {
		jtf_UserCount.setText(String.valueOf(userCount));
	}

	
	
}
