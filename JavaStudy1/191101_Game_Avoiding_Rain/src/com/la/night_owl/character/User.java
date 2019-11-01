package com.la.night_owl.character;

import java.awt.Color;
import java.awt.Graphics;

import com.la.night_owl.avoiding_rain.Option;

public class User extends Item {

	int movePixel = 10;

	public User() {
		this.position.width = Option.USER_IMAGE.getWidth(null);
		this.position.height = Option.USER_IMAGE.getHeight(null);
		this.position.x = Option.GameOption.GAME_RESOLUTION_W / 2 - position.width / 2;
		this.position.y = Option.GameOption.GAME_RESOLUTION_H - position.height - 10;
		this.color = Color.BLUE;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
//		g.fillRect(position.x, position.y, position.width, position.height);
		g.drawImage(Option.USER_IMAGE, position.x, position.y, null);
	}

	public void move_Left() {
		if (position.x + position.width / 2 < 0)
			position.x = position.width;
//			position.x = (0 - position.width) + position.width / 3;
		position.x -= movePixel;
	}

	public void move_Right() {
		if (position.x + position.width / 2 > Option.GameOption.GAME_RESOLUTION_W)
			position.x = Option.GameOption.GAME_RESOLUTION_W - position.width / 2;
		position.x += movePixel;
	}

}
