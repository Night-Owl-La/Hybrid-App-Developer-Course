package com.la.night_owl_signalLight;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TrafficSignal extends JFrame {

	JButton jbtRed = new JButton("Red On");
	JButton jbtYellow = new JButton("Yellow On");
	JButton jbtBlue = new JButton("Blue On");
	
	public TrafficSignal() {
		super("title");
		this.setSize(300, 100);
		this.setLocation(300, 300);
		setLayout(new GridLayout(1, 3));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		jbtRed.setBackground(Color.RED);
		jbtYellow.setBackground(Color.YELLOW);
		jbtBlue.setBackground(Color.BLUE);
		
		this.add(jbtRed);
		this.add(jbtYellow);
		this.add(jbtBlue);
		
		Runnable runnable = new SignalRunnable();
		Thread tRed = new Thread(runnable, "R");
		Thread tYellow = new Thread(runnable, "Y");
		Thread tBlue = new Thread(runnable, "B");
		
		tRed.start();
		tYellow.start();
		tBlue.start();
	}
	
	class SignalRunnable implements Runnable{
		
		synchronized void redOn() {
			jbtRed.setBackground(Color.RED);
			jbtYellow.setBackground(Color.GRAY);
			jbtBlue.setBackground(Color.GRAY);
			waitThread();
		}
		synchronized void yellowOn() {
			jbtRed.setBackground(Color.GRAY);
			jbtYellow.setBackground(Color.YELLOW);
			jbtBlue.setBackground(Color.GRAY);
			waitThread();
		}
		synchronized void blueOn() {
			jbtRed.setBackground(Color.GRAY);
			jbtYellow.setBackground(Color.GRAY);
			jbtBlue.setBackground(Color.BLUE);
			waitThread();
		}
		public void waitThread() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			
			while(true) {
				if(name.equals("R")) redOn();
				else if (name.equals("Y")) yellowOn();
				else if (name.equals("B")) blueOn();
			}
		}
	}	// class SignalRunnable end.
	

	public static void main(String[] args) {
		new TrafficSignal();
	}
}
