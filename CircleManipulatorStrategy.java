package ca.utoronto.utm.paint;

public class CircleManipulatorStrategy implements ShapeManipulatorStrategy{

	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.ShapeManipulatorStrategy#createShape(ca.utoronto.utm.paint.Point)
	 * 
	 * Creates and returns the instance of Circle.
	 */
	@Override
	public Shape createShape(Point startPoint) {
		Shape circle = new Circle(startPoint, 0);
		return circle;
	}
	
}
