package com.genki.algo.algorithm.graphical.components;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public abstract class JCanvas extends JPanel {

	private static final long serialVersionUID = -4112620799770010097L;

	private final List<IDrawable> drawables = new LinkedList<IDrawable>();

	public JCanvas() {
		this.addListeners();
	}

	protected abstract void addListeners();

	@Override
	public void paint(final Graphics g) {
		super.paint(g);
		for (final IDrawable d : this.drawables) {
			d.draw(g);
		}
	}

	public void addDrawable(final IDrawable d) {
		this.drawables.add(d);
		this.repaint();
	}

	public void removeDrawable(final IDrawable d) {
		this.drawables.remove(d);
		this.repaint();
	}

	public void clear() {
		this.drawables.clear();
		this.repaint();
	}

}
