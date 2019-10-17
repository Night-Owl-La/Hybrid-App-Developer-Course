<<<<<<< HEAD
package com.la.night_owl.mywindows1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
public class MyWindows_Main extends JFrame {
	private int screen_w=0;
	private int screen_h=0;
	private Point point= new Point();
	
	public MyWindows_Main(){
		// TODO Auto-generated constructor stub
		super.setLocation(100, 100);
		super.setSize(100, 100);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		screen_w=+d.width;
		screen_h=+d.height;
		
		setMoveEvent();
	}
	
	public void setMoveEvent() {
		super.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int moveScale=100;
				
				switch(e.getKeyCode()){
					case KeyEvent.VK_UP : 		point.y -=moveScale; break;
					case KeyEvent.VK_DOWN :		point.y +=moveScale; break;
					case KeyEvent.VK_LEFT : 	point.x -=moveScale; break;
					case KeyEvent.VK_RIGHT :	point.x +=moveScale; break;
					default:
				}
				setLocation_AfterMove();
				isOut_OfEndLine();
			} // keyPressed close.
		}); // addKeyListener close.
	}
	public void setLocation_AfterMove() { this.setLocation(this.point); }
	public void isOut_OfEndLine() {
		if(this.getLocation().x > screen_w)			this.point.x=0;
		else if(this.getLocation().x < 0 ) 			this.point.x=2048;
		else if(this.getLocation().y > screen_h)	this.point.y=0;
		else if(this.getLocation().y < 0)			this.point.y=1152;
		setLocation_AfterMove();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyWindows_Main M_win = new MyWindows_Main();
		System.out.printf("%d , %d", M_win.screen_w, M_win.screen_h);
	}

}
=======
package com.la.night_owl.mywindows1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
public class MyWindows_Main extends JFrame {
	private int screen_w=0;
	private int screen_h=0;
	private Point point= new Point();
	
	public MyWindows_Main(){
		// TODO Auto-generated constructor stub
		super.setLocation(100, 100);
		super.setSize(100, 100);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		screen_w=+d.width;
		screen_h=+d.height;
		
		setMoveEvent();
	}
	
	public void setMoveEvent() {
		super.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int moveScale=100;
				
				switch(e.getKeyCode()){
					case KeyEvent.VK_UP : 		point.y -=moveScale; break;
					case KeyEvent.VK_DOWN :		point.y +=moveScale; break;
					case KeyEvent.VK_LEFT : 	point.x -=moveScale; break;
					case KeyEvent.VK_RIGHT :	point.x +=moveScale; break;
					default:
				}
				setLocation_AfterMove();
				isOut_OfEndLine();
			} // keyPressed close.
		}); // addKeyListener close.
	}
	public void setLocation_AfterMove() { this.setLocation(this.point); }
	public void isOut_OfEndLine() {
		if(this.getLocation().x > screen_w)			this.point.x=0;
		else if(this.getLocation().x < 0 ) 			this.point.x=2048;
		else if(this.getLocation().y > screen_h)	this.point.y=0;
		else if(this.getLocation().y < 0)			this.point.y=1152;
		setLocation_AfterMove();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyWindows_Main M_win = new MyWindows_Main();
		System.out.printf("%d , %d", M_win.screen_w, M_win.screen_h);
	}

}
>>>>>>> 58a1e39d7133271e9e2d47e88a57401a2065a6ec
