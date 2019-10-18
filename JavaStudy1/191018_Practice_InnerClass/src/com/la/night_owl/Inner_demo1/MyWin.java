package com.la.night_owl.Inner_demo1;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class MyWin extends JFrame {
		
	public MyWin() {
		super("title");
		
		class ButtonActionHandler implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
			MyWin.this.setTitle("#########");
			}
			
		}
		
		this.setSize(300, 300);
		this.setLocation(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setLayout(new GridLayout(4, 1));
		
		JButton btn_1 = new JButton("Hi !");
		JButton btn_2 = new JButton("Hi !!");
		JButton btn_3 = new JButton("Hi !!!");
		JButton btn_4 = new JButton("Hi !!!!");
		
		btn_1.addActionListener(new ButtonActionHandler());
		btn_2.addActionListener(new ButtonActionHandler());
		btn_3.addActionListener(new ButtonActionHandler());
		btn_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_4.setText("aaaa");
			}
		});
		
		this.add(btn_1);
		this.add(btn_2);
		this.add(btn_3);
		this.add(btn_4);
		
	}

	
	
	
	public static void main(String[] args) {
		new MyWin();
	}
}
