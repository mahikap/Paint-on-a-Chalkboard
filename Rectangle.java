package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * A Rectangle is a Shape. Rectangles have all methods and attributes of Shape and
 * then some more. Rectangle implements Drawing Command, meaning that the
 * every instance of Rectangle can be told to "draw" itself.
 * 
 */
public class Rectangle extends Shape implements DrawingCommand {

	private int width;
	private int height;
	private Point endPoint;
	
	/**
	 * Initialize a rectangle at a given point, with given width and height.
	 * 
	 * @param startPoint 	the starting point of the rectangle.
	 * @param width			the desire width of the rectangle.
	 * @param height		the desire height of the rectangle.
	 */
	public Rectangle(Point startPoint, int width, int height) {
		super(startPoint);
		this.width = width;
		this.height = height;
		this.endPoint = new Point(startPoint.getX(), startPoint.getY());
	}
	
	/**
	 * Return the width of the rectangle.
	 * 
	 * @return integer width.
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Set the width of the rectangle with the given width.
	 * 
	 * @param w	integer to set the width of the rectangle.
	 */
	public void setWidth(int w) {
		this.width = w;
	}
	
	/**
	 * Return the height of the rectangle.
	 * 
	 * @return integer height.
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Set the height of the rectangle with the given height.
	 * 
	 * @param h	integer to set the height of the rectangle.
	 */
	public void setHeight(int h) {
		this.height = h;
	}
	
	/**
	 * Return the end point of the rectangle.
	 * 
	 * @return point end point.
	 */
	public Point getEndPoint() {
		return this.endPoint;
	}
	
	/**
	 * Set the end point of the rectangle with the given point.
	 * 
	 * @param p	point to set the end point of the rectangle.
	 */
	public void setEndPoint(Point p) {
		this.endPoint = p;
	}
	
	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.Shape#execute(java.awt.Graphics2D)
	 * 
	 * Draws the Rectangle with corresponding x, y, width, and height of the
	 * shape.
	 */
	@Override
	public void execute(Graphics2D g2d) {
		int x = Math.min(this.getStartPoint().getX(), this.getEndPoint().getX());
		int y = Math.min(this.getStartPoint().getY(), this.getEndPoint().getY());
		int width = this.getWidth();
		int height = this.getHeight();
		int lineWidth = this.getLineWidth();
		Color lineColor = this.getShapeColor();
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.setColor(lineColor);
		
		if (this.getShapeFill()) {
			g2d.fillRect(x, y, width, height);
		} else {
			g2d.drawRect(x, y, width, height);
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
	 * Checks where mouse coordinates is dragged to with respect to the point
	 * where the mouse is pressed. And sets the new x and y coordinates where
	 * the rectangle is to be drawn. As well as the new width and height.
	 */
	@Override
	public void mouseDragged(Point point) {
		if (point.getX() < this.getEndPoint().getX()) {
			this.getStartPoint().setX(point.getX());
		}
		
		if (point.getY() < this.getEndPoint().getY()) {
			this.getStartPoint().setY(point.getY());
		}
		
		this.setWidth(Math.abs(point.getX() - this.getEndPoint().getX()));
		this.setHeight(Math.abs(point.getY() - this.getEndPoint().getY()));
		
	}

	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.Shape#mousePressed(ca.utoronto.utm.paint.PaintPanel, ca.utoronto.utm.paint.Point)
	 * 
	 * Sets the line width, shape color, and if shape is to be filled at the
	 * first press of the mouse.
	 */
	@Override
	public void mousePressed(PaintPanel paintPanel, Point point) {
		this.setLineWidth(paintPanel.getLineWidth());
		this.setShapeColour(paintPanel.getColor());
		this.setShapeFill(paintPanel.getIsFilled());
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
