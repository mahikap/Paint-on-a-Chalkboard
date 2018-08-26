package ca.utoronto.utm.paint;

public class SquareManipulatorStrategy implements ShapeManipulatorStrategy {
	
	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.ShapeManipulatorStrategy#createShape(ca.utoronto.utm.paint.Point)
	 * 
	 * Creates and returns the instance of Square.
	 */
	@Override
	public Shape createShape(Point startPoint) {
		Shape square = new Square(startPoint, 0);
		return square;
	}
}
