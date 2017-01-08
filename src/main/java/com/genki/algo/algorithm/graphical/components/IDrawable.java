package com.genki.algo.algorithm.graphical.components;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface IDrawable {
	public void draw(Graphics g);

	public Rectangle getRectangle();
}