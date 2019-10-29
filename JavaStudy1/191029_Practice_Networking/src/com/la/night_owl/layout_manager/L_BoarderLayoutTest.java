package com.la.night_owl.layout_manager;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class L_BoarderLayoutTest extends JFrame {

	public L_BoarderLayoutTest() {
		super("title");
		this.setSize(300, 300);
		this.setLocation(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JButton jbt_east = new JButton("East");
		JButton jbt_west = new JButton("West");
		JButton jbt_south = new JButton("South");
		JButton jbt_north = new JButton("north");
		JButton jbt_center = new JButton("Center");
		this.add(jbt_east, BorderLayout.EAST);
		this.add(jbt_west, BorderLayout.WEST);
		this.add(jbt_south, BorderLayout.SOUTH);
		this.add(jbt_north, BorderLayout.NORTH);
		this.add(jbt_center);
		
		
	}

	public static void main(String[] args) {
		new L_BoarderLayoutTest();
	}
}
