package ca.utoronto.utm.paint;

import java.awt.*;

/**
 * A Shape has a StartPoint, Line Width, Color, Fill Color (all of which can be modified).
 * 
 */
public abstract class Shape {
	
	private int lineWidth;
	private Point startPoint;
	private Color shapeColor;
	private Boolean shapeFill;
	
	/**
	 * Initialize a new Shape at the given Point.
	 * 
	 * @param startPoint Point at which to draw the shape.
	 */
	public Shape(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	/**
	 * Change the Line Width of the shape to the given integer.
	 * 
	 * @param w desired Line Width, integer.
	 */
	public void setLineWidth(int w) {
		this.lineWidth = w;
	}
	
	/**
	 * Return the current Line Width of the shape.
	 * 
	 * @return integer representing line width.
	 */
	public int getLineWidth() {
		return this.lineWidth;
	}

	/**
	 * Set the Point at which to draw the shape.
	 * 
	 * @param p desired Point.
	 */
	public void setStartPoint(Point p){
		this.startPoint = p;
	}
	
	/**
	 * Return the start Point of the current shape.
	 * 
	 * @return Point, representing location of Shape.
	 */
	public Point getStartPoint() {
		return this.startPoint;
	}
	
	/**
	 * Change color of Shape to desired color. 
	 * 
	 * @param c desired Color.
	 */
	public void setShapeColour(Color c){
		this.shapeColor = c;
	}
	
	/**
	 * Return the current color of the shape.
	 * 
	 * @return Color of shape.
	 */
	public Color getShapeColor() {
		return this.shapeColor;
	}
	
	/**
	 * Set whether the Shape Fill is True, meaning it is filled,
	 * or False, meaning it is not filled.
	 * 
	 * @param b boolean True or False.
	 */
	public void setShapeFill(Boolean b){
		this.shapeFill = b;
	}
	
	/**
	 * Return whether the shape is filled, or not.
	 * 
	 * @return True or False.
	 */
	public Boolean getShapeFill() {
		return this.shapeFill;
	}

	/**
	 * Draw the Shape with the correct Line Width, Shape Color, Fill Color
	 * attributes.
	 * 
	 * @param g2d Graphic component.
	 */
	public void execute(Graphics2D g2d) {
		
	}
	
	public abstract void mouseMoved();
	
	public abstract void mouseClicked();
	
	public abstract void mouseDragged(Point point);
	
	public abstract void mousePressed(PaintPanel paintPanel, Point point);
	
	public abstract void mouseReleased(PaintModel paintModel, Point point);
	
	public abstract void mouseEntered();
	
	public abstract void mouseExited();
	
}
