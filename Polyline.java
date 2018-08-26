package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * A Polyline is a Shape. Polylines have all methods and attributes of Shape and
 * then some more. Polyline implements Drawing Command, meaning that the
 * every instance of Polyline can be told to "draw" itself. Polyline contains
 * a list of Lines, which is composes an entire Polyline Shape. 
 */
public class Polyline extends Shape {
	
	private ArrayList<Line> lines = new ArrayList<Line>();
	private Line line;

	/**
	 * @param startPoint Point at which to start first line of
	 * Polyline Shape
	 */
	public Polyline(Point startPoint) {
		super(startPoint);
		this.line = new Line(startPoint, startPoint);
	}
	
	/**
	 * Add a new line to Polyline at Point p
	 * @param p Point at which to create a new line, 
	 * 			in continuation of Polyline Shape
	 */
	public void addPoint(Point p) {
		this.line = new Line(this.line.getEndPoint(), p);
		this.lines.add(this.line);
	}
	
	/**
	 * Return the ArrayList of Line objects that make up this Polyline
	 * @return ArrayList of Lines
	 */
	public ArrayList<Line> getPoints() {
		return this.lines;
	}
	
	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.Shape#execute(java.awt.Graphics2D)
	 * 
	 * Draw all lines in this Polyline Shape.
	 * 
	 */
	@Override
	public void execute(Graphics2D g2d) {
		int lineWidth = this.getLineWidth();
		Color lineColor = this.getShapeColor();
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.setColor(lineColor);
		for (Line l: lines) {
			l.setLineWidth(lineWidth);
			l.execute(g2d);
		}
	}

	@Override
	public void mouseMoved() {
		
	}

	@Override
	public void mouseClicked() {
		
	}

	@Override
	public void mouseDragged(Point point) {
		
	}

	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.Shape#mousePressed(ca.utoronto.utm.paint.PaintPanel, ca.utoronto.utm.paint.Point)
	 * 
	 * Sets the line width, shape color, and if shape is to be filled at the
	 * first press of the mouse.
	 * 
	 */
	@Override
	public void mousePressed(PaintPanel paintPanel, Point point) {
		this.line.setEndPoint(point);
		this.setLineWidth(paintPanel.getLineWidth());
		this.setShapeColour(paintPanel.getColor());
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
