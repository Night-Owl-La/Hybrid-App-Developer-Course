package com.la.night_owl.practiceThread;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBar_Demo extends JFrame {

	JProgressBar jpb_red;
	JProgressBar jpb_blue;
	JProgressBar jpb_green;
	boolean bRedRunning = true, bBlueRunning = true, bGreenRunning = true;
	
	public ProgressBar_Demo() {
		super("title");
		this.setSize(300, 300);
		this.setLocation(300, 300);
		setLayout(new GridLayout(3, 1));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		jpb_red = new JProgressBar();
		jpb_blue = new JProgressBar();
		jpb_green = new JProgressBar();
		
		jpb_red.setValue(10);
		jpb_blue.setValue(50);
		jpb_green.setValue(70);
		
		
		jpb_red.setForeground(Color.red);
		jpb_blue.setForeground(Color.blue);
		jpb_green.setForeground(Color.green);
		
		this.add(jpb_red);
		this.add(jpb_blue);
		this.add(jpb_green);
		
		run();
		
	}
	
	public void run() {
		Thread tRed = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					int value = jpb_red.getValue();
					value++;
					if(value>jpb_red.getMaximum()) value=0;
					jpb_red.setValue(value);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread tBlue = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					int value = jpb_blue.getValue();
					value+=5;
					if(value>jpb_blue.getMaximum()) value=0;
					jpb_blue.setValue(value);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread tGreen = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					int value = jpb_green.getValue();
					value+=2;
					if(value>jpb_green.getMaximum()) value=0;
					jpb_green.setValue(value);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		tRed.start();
		tBlue.start();
		tGreen.start();
		
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_R) bRedRunning = !bRedRunning;
				else if (e.getKeyCode()==KeyEvent.VK_B) bBlueRunning = !bBlueRunning;
				else if (e.getKeyCode()==KeyEvent.VK_G) bGreenRunning = !bGreenRunning;
				
				if(bRedRunning) tRed.resume();
				else tRed.suspend();
				
				if(bBlueRunning) tBlue.resume();
				else tBlue.suspend();
				
				if(bGreenRunning) tGreen.resume();
				else tGreen.suspend();
				
			}
			
		});
		
	}

	public static void main(String[] args) {
		new ProgressBar_Demo();
	}
}
