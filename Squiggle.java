package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * A Squiggle is a Shape. Squiggles have all methods and attributes of Shape and
 * then some more. Squiggle implements Drawing Command, meaning that the
 * every instance of Squiggle can be told to "draw" itself.
 */
public class Squiggle extends Shape implements DrawingCommand{
	
	private ArrayList<Point> points = new ArrayList<Point>();

	/**
	 * Initialized a squiggle with the give start point.
	 * 
	 * @param firstPoint, the first point of the squiggle.
	 */
	public Squiggle(Point firstPoint) {
		super(firstPoint);
		this.points.add(firstPoint);
	}

	/**
	 * Add a new point to Squiggle at point p. 
	 * 
	 * @param p, 	the next point to create a new squiggle, 
	 * 				in continuation of the squiggle shape.
	 */
	public void addPoint(Point p) {
		this.points.add(p);
	}
	
	/**
	 * Return the ArrayList of Points that makes up the Squiggle.
	 * 
	 * @return ArrayList of Points
	 */
	public ArrayList<Point> getPoints() {
		return this.points;
	}
	
	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.Shape#execute(java.awt.Graphics2D)
	 * 
	 * Draws lines between each point in the Squiggle's list of points.
	 * 
	 */
	@Override
	public void execute(Graphics2D g2d) {
		int lineWidth = this.getLineWidth();
		Color lineColor = this.getShapeColor();
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.setColor(lineColor);
		for (int i = 0; i < points.size() - 1; i++) {
			Point p1 = points.get(i);
			Point p2 = points.get(i + 1);
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}

	@Override
	public void mouseMoved() {
		
	}

	@Override
	public void mouseClicked() {
		
	}

	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.Shape#mouseDragged(ca.utoronto.utm.paint.Point)
	 * 
	 * Adds the current mouse point to Squiggle's list of points.
	 * 
	 */
	@Override
	public void mouseDragged(Point point) {
		this.addPoint(point);
	}

	/**
	 * If User has selected "Eraser", set color of squiggle to background color
	 * of PaintPanel to give erasing effect.
	 * Else, set it to desire color. 
	 */
	@Override
	public void mousePressed(PaintPanel paintPanel, Point point) {
		if (paintPanel.getMode() == "Eraser") {
			this.setShapeColour(new Color(60,63,68));
			
		} else {
			this.setShapeColour(paintPanel.getColor());

		}
		
		this.setLineWidth(paintPanel.getLineWidth());
		
	}

	@Override
	public void mouseReleased(PaintModel paintModel, Point point) {
		
	}

	@Override
	public void mouseEntered() {
		
	}

	@Override
	public void mouseExited() {
		
	}
	
}
