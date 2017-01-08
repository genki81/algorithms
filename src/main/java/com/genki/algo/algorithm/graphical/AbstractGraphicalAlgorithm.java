package com.genki.algo.algorithm.graphical;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.genki.algo.algorithm.AbstractAlgorithm;
import com.genki.algo.algorithm.graphical.components.JCanvas;
import com.genki.algo.algorithm.graphical.components.Line;

public abstract class AbstractGraphicalAlgorithm extends AbstractAlgorithm {

	private final int width;
	private final int height;

	private int x;
	private int y;

	private double theta;
	private int rho;

	private int px;
	private int py;

	private double ptheta;
	private int prho;

	private JCanvas panel;

	public AbstractGraphicalAlgorithm(final int width, final int height) {
		this.width = width;
		this.height = height;

		this.initGraphical();

		this.reset();
	}

	private void initGraphical() {
		this.panel = new JCanvas() {

			@Override
			protected void addListeners() {
				this.addMouseListener(new MouseListener() {

					public void mouseReleased(final MouseEvent e) {
					}

					public void mousePressed(final MouseEvent e) {
					}

					public void mouseExited(final MouseEvent e) {
					}

					public void mouseEntered(final MouseEvent e) {
					}

					public void mouseClicked(final MouseEvent e) {
						AbstractGraphicalAlgorithm.this.run();
					}
				});

			}
		};
		this.panel.setSize(this.width, this.height);
	}

	@Override
	final protected void postNext() {
		this.draw();
	}

	@Override
	final protected void postInit() {
		this.draw();
	}

	protected abstract void draw();

	protected void reset() {
		this.x = 0;
		this.y = 0;
		this.px = 0;
		this.py = 0;
		this.theta = 0;
		this.rho = 0;
		this.ptheta = 0;
		this.prho = 0;
		this.panel.clear();
	}

	protected void move(final int dx, final int dy) {
		this.px = this.x;
		this.py = this.y;
		this.x = this.x + dx;
		this.y = this.y + dy;
	}

	protected void move(final int drho) {
		this.prho = this.rho;
		this.rho = this.rho + drho;
	}

	protected void rotate(final double dtheta) {
		this.ptheta = this.theta;
		this.theta = this.theta + dtheta / (2 * Math.PI);
	}

	protected void addLine() {
		this.panel.addDrawable(new Line(this.px, this.py, this.x, this.y));
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public JCanvas getPanel() {
		return this.panel;
	}
}
