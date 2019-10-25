package com.la.night_owl.MovingEyes;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class Face_1 extends JFrame {
	static int GAME_W=800;		// 해상도 가로
	static int GAME_H=1000;		// 해상도 높이
	static Image back_image;
	static Image back_image_off;
	static {
		back_image = new ImageIcon("resource\\face.png").getImage();
		back_image_off = new ImageIcon("resource\\faceOff.png").getImage();
	}
	
	int eye_Radius;
	Point eye_Left=new Point();
	Point eye_Right=new Point();
	
	int eyeBall_Radius;
	Point eyeBall_Left=new Point();
	Point eyeBall_Right=new Point();
	
	Boolean isInEyes=false;
	
	JPanel jPanel;
	
	
	public Face_1() {		//Constructor
		super("title");
		
		// Initialization.
		setResizable(false);
		this.setLocation(300, 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GAME_W=back_image.getWidth(null);
		GAME_H=back_image.getHeight(null);
		
		
		eye_Radius = (GAME_W/6);
		eyeBall_Radius = eye_Radius/2;
		init_JPanel();
		init_eye_position();
		init_eyeball_position();
		init_MouseEvent();
		
		pack();
	}
	
	private void init_JPanel() {
		jPanel=new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				draw_backGround(g);
				draw_LeftEyes(g);
				draw_RightEyes(g);
			}
		};
		jPanel.setPreferredSize(new Dimension(back_image.getWidth(null), back_image.getHeight(null)));
		this.add(jPanel);
	}
	private void draw_backGround(Graphics g) {
		g.clearRect(0,0,back_image.getWidth(null),back_image.getHeight(null));
		g.drawImage(back_image, 0,0, null);
	}
	private void draw_LeftEyes(Graphics g) {
		g.fillOval(eyeBall_Left.x-eyeBall_Radius, eyeBall_Left.y-eyeBall_Radius, eyeBall_Radius*2, eyeBall_Radius*2);
		if(isInEyes==true) close_Eyes(g);
	}
	private void draw_RightEyes(Graphics g) {
		g.fillOval(eyeBall_Right.x-eyeBall_Radius, eyeBall_Right.y-eyeBall_Radius, eyeBall_Radius*2, eyeBall_Radius*2);
		if(isInEyes==true) close_Eyes(g);
	}
	private void close_Eyes(Graphics g) {
		g.clearRect(0,0,back_image.getWidth(null),back_image.getHeight(null));
		g.drawImage(back_image_off, 0,0, null);
	}
	private void init_eye_position() {
		eye_Left.x=(GAME_W/3)-30;
		eye_Left.y=(GAME_H/4)+25;
		eye_Right.x=(GAME_W/3)*2+25;
		eye_Right.y=GAME_H/4+25;
	}
	private void init_eyeball_position() {
		eyeBall_Left.x=eye_Left.x;
		eyeBall_Left.y=eye_Left.y;
		eyeBall_Right.x=eye_Right.x;
		eyeBall_Right.y=eye_Right.y;
	}
	private void init_MouseEvent() {
		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("Dragged");
				Point p = e.getPoint();
				
				positioning_LeftEyeBall(p);
				positioning_RightEyeBall(p);
				jPanel.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Pressed");
				Point p = e.getPoint();
				positioning_LeftEyeBall(p);
				positioning_RightEyeBall(p);
				jPanel.repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Released");
				init_eyeball_position();
				jPanel.repaint();
			}
		};
		jPanel.addMouseListener(adapter);
		jPanel.addMouseMotionListener(adapter);
	}
	private void positioning_LeftEyeBall(Point p) {
		int cx = p.x-eye_Left.x;
		int cy = p.y-eye_Left.y;
		double r = Math.sqrt(cx*cx + cy*cy);
		double rate = eyeBall_Radius/r;
		
		eyeBall_Left.x=(int)(eye_Left.x+cx*rate);
		eyeBall_Left.y=(int)(eye_Left.y+cy*rate);
	
		isInEyes(r);
	}
	private void positioning_RightEyeBall(Point p) {
		int cx = p.x-eye_Right.x;
		int cy = p.y-eye_Right.y;
		double r = Math.sqrt(cx*cx + cy*cy);
		double rate = eyeBall_Radius/r;
		
		eyeBall_Right.x=(int)(eye_Right.x+cx*rate);
		eyeBall_Right.y=(int)(eye_Right.y+cy*rate);
		
		if(!isInEyes) isInEyes(r);
	}
	private void isInEyes(double r) {
		if(r<=eye_Radius) isInEyes=true;
		else isInEyes=false;
	}
	public static void main(String[] args) {
		new Face_1();
	}
}
