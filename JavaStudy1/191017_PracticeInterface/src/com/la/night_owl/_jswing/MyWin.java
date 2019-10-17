package com.la.night_owl._jswing;

import java.awt.event.*;
import javax.swing.JFrame;

public class MyWin extends JFrame {

	public MyWin() {
		super("인터페이스 활용 예제");
		this.setSize(300, 300);
		this.setLocation(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.addWindowListener(new L_WindowHandler()); 
	}
	class L_WindowHandler extends WindowAdapter{

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("1. 활성!");
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("2. 닫혀버렸다!!");
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("3. 종료!!!");
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("4. 비활성!");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("5. Deiconified!!");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("6. iconified!!");
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("7. 열었다!!");
		}
		
	}

	public static void main(String[] args) {
		new MyWin();
		
	}
}
