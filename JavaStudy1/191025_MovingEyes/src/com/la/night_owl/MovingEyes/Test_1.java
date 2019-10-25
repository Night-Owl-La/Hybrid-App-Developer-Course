package com.la.night_owl.MovingEyes;

import java.awt.*;
import javax.swing.*;

public class Test_1 extends JFrame {
	
	static Image back_image;
	static {
		back_image = new ImageIcon("resource\\respaul_1.jpg").getImage();
	}
	JPanel jPanel;
	Font font = new Font("Snap ITC", Font.BOLD, 30);
	Point point = new Point(400, 50);
	
	public Test_1() {
		super("title");
		this.setSize(1000, 1000);
		this.setLocation(200,100);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				//g.drawImage(back_image, 0, 0, this);
				g.setFont(font);
				
				// Font Shadow.
				g.setColor(Color.WHITE);
				g.drawString("draw Practice", point.x+2, point.y+2);
				
				// Font.
				g.setColor(Color.BLUE);
				g.drawString("draw Practice", point.x, point.y);
				
				// Rect.
				g.drawRect(800, 80, 100, 100);
				g.fillRect(600, 80, 100, 100);
				
				// Circle.
				g.setColor(Color.GREEN);
				g.fillOval(400, 80, 100, 100);
				
				// Line.
				g.setColor(Color.WHITE);
				g.drawLine(200, 80, 300, 80);
				
				for (int i = 0; i < 256; i++) {
					Color color = new Color(255,220,i);
					g.setColor(color);
					g.drawLine(100+i, 400, 300+i, 400);
				}
			}};
		this.add(jPanel);
		
	}

	public static void main(String[] args) {
		new Test_1();
	}
}
