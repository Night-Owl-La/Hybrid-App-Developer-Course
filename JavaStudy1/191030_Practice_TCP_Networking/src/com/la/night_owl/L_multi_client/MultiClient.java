package com.la.night_owl.L_multi_client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.la.night_owl.connect_interface.Connect_Interface;

public class MultiClient extends JFrame {

	private JTextArea		jta_Monitor;
	private JTextField		jtf_Message;
	private JButton			jbt_Connect;
	private JList<String>	jlist_UserList;
	boolean					bConnect = false;
	
	private Font font = new Font("맑은 고딕", Font.BOLD, 20);
	
	public MultiClient() {
		super("title");
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		init_Jta_Monitor();
		init_Jlist_UserList();
		init_Jtf_Message();
		
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
	private void init_Jlist_UserList() {
		jlist_UserList = new JList<String>();
		JScrollPane jScrollPane = new JScrollPane(jlist_UserList);
		jScrollPane.setPreferredSize(new Dimension(120, 0));
		
		this.add(jScrollPane, BorderLayout.EAST);
	}
	private void init_Jtf_Message() {
		JPanel jPanel = new JPanel(new BorderLayout());
		jtf_Message = new JTextField();
		jbt_Connect = new JButton("연결");

		jtf_Message.setFont(font);
		jbt_Connect.setFont(font);
		jbt_Connect.setPreferredSize(new Dimension(120,0));
		jbt_Connect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				on_Jbt_Connect();
			}
		});
		
		
		jPanel.add(jtf_Message, BorderLayout.CENTER);
		jPanel.add(jbt_Connect, BorderLayout.EAST);
		
		
		this.add(jPanel,BorderLayout.SOUTH);
	}
	
	
	Socket client; // TODO DELETE SOCKET
	protected void on_Jbt_Connect() {
		bConnect = !bConnect;
		
		if(bConnect) {
			try {
				client=new Socket("localhost", Connect_Interface.PORT_NUMBER);
			} catch (IOException e) {
				
			}
		}else {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		jbt_Connect.setText(bConnect ? "연결끊기" : "연결");
	}
	
}
