package ca.utoronto.utm.paint;

public class SquiggleManipulatorStrategy implements ShapeManipulatorStrategy {

	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.ShapeManipulatorStrategy#createShape(ca.utoronto.utm.paint.Point)
	 * 
	 * Creates and returns the instance of Squiggle.
	 */
	@Override
	public Shape createShape(Point startPoint) {
		Shape squiggle = new Squiggle(startPoint);
		return squiggle;
	}
}
