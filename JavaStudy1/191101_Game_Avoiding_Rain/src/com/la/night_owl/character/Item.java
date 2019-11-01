package com.la.night_owl.character;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Item {
	public Rectangle position = new Rectangle();
	public Color color = Color.BLACK;

	public abstract void draw(Graphics g);
	
	public boolean move() {
		return false;
	}

}
