package com.la.night_owl.avoiding_rain;

import java.awt.Image;

import javax.swing.ImageIcon;

public interface Option {

	public static final Image USER_IMAGE = new ImageIcon("resource/User1.png").getImage();
	public static final Image DDONG_IMAGE = new ImageIcon("resource/Ddong1.png").getImage();
	public static final Image TREE_IMAGE = new ImageIcon("resource/Tree.png").getImage();

	public static class GameOption {
		public static final int GAME_RESOLUTION_W = TREE_IMAGE.getWidth(null);
		public static final int GAME_RESOLUTION_H = TREE_IMAGE.getHeight(null);
		public static final int GAME_COLLISIONCOUNT_DISPLAY_W = GAME_RESOLUTION_W - 70;
		public static final int GAME_COLLISIONCOUNT_DISPLAY_H = GAME_RESOLUTION_H - 30;
		public static final int GAME_Timer_SPEED = 10;
	}

	public static class Key {
		public static final int GAME_NONE = 0;
		public static final int GAME_LEFT = 1;
		public static final int GAME_UP = 2;
		public static final int GAME_RIGHT = 4;
		public static final int GAME_DOWN = 8;

		public static final int GAME_LEFTUP = GAME_LEFT | GAME_UP;
		public static final int GAME_LEFTDOWN = GAME_LEFT | GAME_DOWN;
		public static final int GAME_RIGHTUP = GAME_RIGHT | GAME_UP;
		public static final int GAME_RIGHTDOWN = GAME_RIGHT | GAME_DOWN;
	}
}
