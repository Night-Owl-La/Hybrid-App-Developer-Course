package com.la.night_owl.layout_manager;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class L_FrowLayoutTest extends JFrame {

	public L_FrowLayoutTest() {
		super("title");
		this.setSize(300, 300);
		this.setLocation(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
		
		
		for (int i = 0; i < 10; i++) {
			JButton jbt = new JButton("aaa");
			this.add(jbt);
		}
		
		
		
	}

	public static void main(String[] args) {
		new L_FrowLayoutTest();
	}
}
