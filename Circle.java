import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * A Circle is a Shape. Circles have all methods and attributes of Shape and
 * then some more. Circle implements Drawing Command, meaning that the
 * every instance of Circle can be told to "draw" itself.
 * 
 */
public class Circle extends Shape implements DrawingCommand{
	
	private int radius;
	
	/**
	 * Initialize a circle at a given point, with a given radius.
	 * 
	 * @param center, the center Point of the Circle.
	 * @param radius, the desired radius integer.
	 */
	public Circle(Point centre, int radius) {
		super(centre);
		this.radius = radius;
	}

	/**
	 * Return the radius of this Circle.
	 * 
	 * @return integer radius.
	 */
	public int getRadius() {
		return this.radius;
	}

	/**
	 * Set the radius of this circle to the given radius.
	 * 
	 * @param radius integer to set the radius as.
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.Shape#execute(java.awt.Graphics2D)
	 * 
	 * Draws the Circle with corresponding x, y, and radius of the
	 * shape.
	 * 
	 */
	@Override
	public void execute(Graphics2D g2d) {
		int x = this.getStartPoint().getX();
		int y = this.getStartPoint().getY();
		int radius = this.radius;
		int lineWidth = this.getLineWidth();
		Color lineColor = this.getShapeColor();
		
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.setColor(lineColor);
		
		if (this.getShapeFill()) {
			g2d.fillOval(x-radius, y-radius, radius*2, radius*2);	
		} else {
			g2d.drawOval(x-radius, y-radius, radius*2, radius*2);
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
	 * Sets the radius to the max distance between the x coordinate of the
	 * starting point of circle and the x coordinate of the mouse.
	 * 
	 */
	@Override
	public void mouseDragged(Point point) {
		this.setRadius(Math.abs(point.getX() - this.getStartPoint().getX()));
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
