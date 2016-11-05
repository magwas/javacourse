package org.rulez.magwas.javacourse;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class CanvasBase extends JPanel implements ITurtleCanvas {

	private static final long serialVersionUID = 1L;
	private BufferedImage traceImage;
	private BufferedImage turtleImage;
	private Graphics2D traceGraphics;
	private Graphics2D turtleGraphics;
	private int width;
	private int height;
	
	CanvasBase() {
		width = 200;
		height = 200;
		this.setSize(width, height);
		init();
	}

	private void init() {
		traceImage = new BufferedImage(width,
				height,
                BufferedImage.TYPE_INT_ARGB);
		turtleImage = new BufferedImage(width,
				height,
                BufferedImage.TYPE_INT_ARGB);
		traceGraphics = traceImage.createGraphics();
		turtleGraphics = turtleImage.createGraphics();
		traceGraphics.setColor(Color.blue);
		traceGraphics.clearRect(0, 0, width, height);
		clearTurtles();
	}
	
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2D = (Graphics2D)g;
	    g2D.drawImage(traceImage, 0, 0, this);
	    g2D.drawImage(turtleImage, 0, 0, this);
	}
	
	/* (non-Javadoc)
	 * @see org.rulez.magwas.javacourse.ITurtleCanvas#drawLine(int, int, int, int)
	 */
	@Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		Graphics2D g = traceImage.createGraphics();
		g.setColor(Color.WHITE);
		g.drawLine(x1, y1, x2, y2);
		repaint();
	}
	
	/* (non-Javadoc)
	 * @see org.rulez.magwas.javacourse.ITurtleCanvas#drawTurtle(int, int, double)
	 */
	@Override
	public void drawTurtle(int x, int y, double direction) {
		double angle = Math.toRadians(direction);
		int p1x = (int) (x + Math.sin(angle)*16);
		int p1y = (int) (y - Math.cos(angle)*16);
		int p2x = x+(x-p1x)/2 + (y-p1y)/2;
		int p2y = y+(y-p1y)/2 - (x-p1x)/2;
		int p3x = x+(x-p1x)/2 - (y-p1y)/2;
		int p3y = y+(y-p1y)/2 + (x-p1x)/2;
		turtleGraphics.setColor(Color.BLUE);
		turtleGraphics.drawLine(p1x, p1y, p2x, p2y);
		turtleGraphics.drawLine(p2x, p2y, p3x, p3y);
		turtleGraphics.drawLine(p3x, p3y, p1x, p1y);
		repaint();
	}
	/* (non-Javadoc)
	 * @see org.rulez.magwas.javacourse.ITurtleCanvas#clearTurtles()
	 */
	@Override
	public void clearTurtles() {
		turtleGraphics.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
		turtleGraphics.fillRect(0, 0, width, height);
		turtleGraphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
	}
}
