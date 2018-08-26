package ca.utoronto.utm.paint;

public class RectangleManipulatorStrategy implements ShapeManipulatorStrategy {

	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.ShapeManipulatorStrategy#createShape(ca.utoronto.utm.paint.Point)
	 * 
	 * Creates and returns the instance of Rectangle.
	 */
	@Override
	public Shape createShape(Point startPoint) {
		Shape rectangle = new Rectangle(startPoint, 0, 0);
		return rectangle;
	}

}
