package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * A Line is a Shape. Lines have all methods and attributes of Shape and
 * then some more. Line implements Drawing Command, meaning that the
 * every instance of Line can be told to "draw" itself.
 */
public class Line extends Shape implements DrawingCommand{
	
	private Point endPoint;
	
	/**
	 * Initialize a Line at a given point.
	 * 
	 * @param startPoint 	Point at which to start Line.
	 * @param endPoint 		Point at which to end Line.
	 */
	public Line(Point startPoint, Point endPoint){
		super(startPoint);
		this.endPoint = endPoint;
	}
	
	/**
	 * Set the endPoint of the Line to the desired Point.
	 * 
	 * @param p Point at which to end Line.
	 */
	public void setEndPoint(Point p){
		this.endPoint = p;
	}
	
	/**
	 * Return the endPoint of this Line.
	 * 
	 * @return Point endPoint.
	 */
	public Point getEndPoint(){
		return this.endPoint;
	}
	
	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.Shape#execute(java.awt.Graphics2D)
	 * 
	 * Draw this Line.
	 * 
	 */
	@Override
	public void execute(Graphics2D g2d){
		int lineWidth = this.getLineWidth();
		Color lineColor = this.getShapeColor();
		
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.setColor(lineColor);
		g2d.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), 
				this.endPoint.getX(), this.endPoint.getY());
	}

	@Override
	public void mouseMoved() {
		
	}

	@Override
	public void mouseClicked() {
		
	}

	/* (non-Javadoc)
	 * Set endPoint of this Line
	 */
	@Override
	public void mouseDragged(Point point) {
		this.setEndPoint(point);
		
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
