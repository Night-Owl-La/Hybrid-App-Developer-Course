package com.la.night_owl.character;

import java.awt.Color;
import java.awt.Graphics;

import com.la.night_owl.avoiding_rain.Option;

public class Ddong extends Item {

	public static final int DDONG_W = Option.DDONG_IMAGE.getWidth(null);
	public static final int DDONG_H = Option.DDONG_IMAGE.getHeight(null);

	int speed = 1;

	public Ddong() {
		this.position.width = Option.DDONG_IMAGE.getWidth(null);
		this.position.height = Option.DDONG_IMAGE.getHeight(null);
		this.position.x = Option.GameOption.GAME_RESOLUTION_W / 2 - position.width / 2;
		this.position.y = Option.GameOption.GAME_RESOLUTION_H - position.height - 10;
		this.color = Color.MAGENTA;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawImage(Option.DDONG_IMAGE, position.x, position.y, null);

		// TODO DEBUG
//		g.setColor(Color.GRAY);
//		g.drawRect(position.x, position.y, position.width, position.height);
	}

	@Override
	public boolean move() {
		position.y += speed;
		return (position.y > Option.GameOption.GAME_RESOLUTION_H);
	}

}
