package com.la.night_owl.avoiding_rain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.la.night_owl.character.CollisionManager;
import com.la.night_owl.character.DdongManager;
import com.la.night_owl.character.User;

public class Avoiding_Rain extends JFrame {

	JPanel gamePan;
	Timer timer;
	int key_State;

	public User user = new User();
	DdongManager ddongManager = new DdongManager();
	CollisionManager collisionManager;

	public Avoiding_Rain() {
		super("Avoiding Rain!");
		collisionManager = new CollisionManager(ddongManager, this);
		init_GamePan();
		init_KeyEvent();
		init_Timer();
		
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void init_GamePan() {
		gamePan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(Option.TREE_IMAGE, 0, 0, null);
				ddongManager.draw_All(g);
				user.draw(g);
				g.setColor(Color.LIGHT_GRAY);
				g.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 50));
				g.drawString(String.valueOf(collisionManager.key_Count),
						Option.GameOption.GAME_COLLISIONCOUNT_DISPLAY_W,
						Option.GameOption.GAME_COLLISIONCOUNT_DISPLAY_H); // TODO ºÎµúÄ£ È½¼ö ±×¸®±â.
			}
		};
		gamePan.setPreferredSize(
				new Dimension(Option.GameOption.GAME_RESOLUTION_W, Option.GameOption.GAME_RESOLUTION_H));
		this.add(gamePan, BorderLayout.CENTER);
	}

	public void init_Timer() {
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeLocation();
				gamePan.repaint();
			}
		};

		timer = new Timer(Option.GameOption.GAME_Timer_SPEED, actionListener);
		timer.start();
	}

	private void init_KeyEvent() {
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				switch (key) {
				case KeyEvent.VK_LEFT:
					key_State = key_State | Option.Key.GAME_LEFT;
					break;
				case KeyEvent.VK_RIGHT:
					key_State = key_State | Option.Key.GAME_RIGHT;
					break;
				case KeyEvent.VK_UP:
					key_State = key_State | Option.Key.GAME_UP;
					break;
				case KeyEvent.VK_DOWN:
					key_State = key_State | Option.Key.GAME_DOWN;
					break;
				default:
					key_State = Option.Key.GAME_NONE;
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				switch (key) {
				case KeyEvent.VK_LEFT:
					key_State = key_State ^ Option.Key.GAME_LEFT;
					break;
				case KeyEvent.VK_RIGHT:
					key_State = key_State ^ Option.Key.GAME_RIGHT;
					break;
				case KeyEvent.VK_UP:
					key_State = key_State ^ Option.Key.GAME_UP;
					break;
				case KeyEvent.VK_DOWN:
					key_State = key_State ^ Option.Key.GAME_DOWN;
					break;
				default:
					key_State = Option.Key.GAME_NONE;
					break;
				}
			}

		});
	}

	protected void changeLocation() {
		ddongManager.make_Ddong();
		ddongManager.move_All();
		collisionManager.collision_User_Ddong();
		move_user();
	}

	private void move_user() {

		if ((key_State & Option.Key.GAME_LEFT) == Option.Key.GAME_LEFT) {
			user.move_Left();
		} else if ((key_State & Option.Key.GAME_RIGHT) == Option.Key.GAME_RIGHT) {
			user.move_Right();
		}

	}

	public static void main(String[] args) {
		new Avoiding_Rain();
	}
}
