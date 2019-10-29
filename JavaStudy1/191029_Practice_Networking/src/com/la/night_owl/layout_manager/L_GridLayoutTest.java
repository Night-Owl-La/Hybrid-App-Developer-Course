package com.la.night_owl.layout_manager;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class L_GridLayoutTest extends JFrame {

	public L_GridLayoutTest() {
		super("title");
		this.setSize(300, 300);
		this.setLocation(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3,4));

	}

	public static void main(String[] args) {
		new L_GridLayoutTest();
	}
}

