package com.genki.algo.algorithm.graphical.components;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Line implements IDrawable {
	private final int x1;
	private final int y1;

	private final int x2;
	private final int y2;

	public Line(final int x1, final int y1, final int x2, final int y2) {
		this.x1 = x1;
		this.y1 = y1;

		this.x2 = x2;
		this.y2 = y2;
	}

	public void draw(final Graphics g) {
		g.drawLine(this.x1, this.y1, this.x2, this.y2);
	}

	public Rectangle getRectangle() {
		return null;
	}

}
