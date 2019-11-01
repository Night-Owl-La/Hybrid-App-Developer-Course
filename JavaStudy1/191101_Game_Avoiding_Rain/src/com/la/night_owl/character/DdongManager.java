package com.la.night_owl.character;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.la.night_owl.avoiding_rain.Option;

public class DdongManager {
	public static final int MAKE_INTERVAL = 30;
	List<Ddong> ddongList = new ArrayList<Ddong>();
	Random rand = new Random();
	int make_Interval = MAKE_INTERVAL;

	public void make_Ddong() {
		if (make_Interval == MAKE_INTERVAL) {
			Ddong ddong = new Ddong();
			ddong.position.width = Ddong.DDONG_W;
			ddong.position.height = Ddong.DDONG_H;
			ddong.speed = rand.nextInt(5) + 2;
			ddong.position.x = rand.nextInt(Option.GameOption.GAME_RESOLUTION_W) - Ddong.DDONG_W / 2;
			ddong.position.y = -Ddong.DDONG_H;
			ddong.color = new Color(rand.nextInt(200), rand.nextInt(200), rand.nextInt(200));
			ddongList.add(ddong);
		}
		make_Interval--;
		if (make_Interval < 0)
			make_Interval = MAKE_INTERVAL;
	}

	public void draw_All(Graphics g) {
		for (Ddong ddong : ddongList) {
			Ddong t_Ddong = ddong;
			t_Ddong.draw(g);
		}
	}

	public void move_All() {
		for (int i = 0; i < ddongList.size(); i++) {
			Ddong ddong = ddongList.get(i);
			if (ddong.move())
				ddongList.remove(ddong);

		}
	}

}
