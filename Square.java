package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * A Square is a Shape. Squares have all methods and attributes of Shape and
 * then some more. Square implements Drawing Command, meaning that the
 * every instance of Square can be told to "draw" itself.
 * 
 */
public class Square extends Rectangle {

	/**
	 * Initialize a square at a given point, with given width.
	 * 
	 * @param startPoint	the starting point of the square.
	 * @param width			the desire width of the square.
	 */
	public Square(Point startPoint, int width) {
		super(startPoint, width, width);
		
	}
	
	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.Rectangle#execute(java.awt.Graphics2D)
	 * 
	 * Draws the Square with corresponding x and y coordinates, and width of
	 * the shape.
	 * 
	 */
	@Override
	public void execute(Graphics2D g2d) {
		int x = this.getStartPoint().getX() - this.getWidth();
		int y = this.getStartPoint().getY() - this.getWidth();
		int width = this.getWidth();
		int lineWidth = this.getLineWidth();
		Color lineColor = this.getShapeColor();
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.setColor(lineColor);
			
		if (this.getShapeFill()) {
			// width*2 since we put the startPoint in the center for square
			// and "drawRect" draws shapes from a corner.
			g2d.fillRect(x, y, width*2, width*2);
		} else {
			g2d.drawRect(x, y, width*2, width*2);
		}
	}
	
	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.Rectangle#mouseDragged(ca.utoronto.utm.paint.Point)
	 * 
	 * Sets the width to the max difference between the starting point of
	 * Square and the point where the mouse is dragged.
	 * 
	 */
	@Override
	public void mouseDragged(Point point) {
		int widthX = Math.abs(this.getStartPoint().getX() - point.getX());
		int widthY = Math.abs(this.getStartPoint().getY() - point.getY());
		int maxWidth = Math.max(widthX, widthY);
		
		this.setWidth(maxWidth);
	}
	
}
