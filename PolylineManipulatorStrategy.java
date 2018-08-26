package ca.utoronto.utm.paint;

public class PolylineManipulatorStrategy implements ShapeManipulatorStrategy {

	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.ShapeManipulatorStrategy#createShape(ca.utoronto.utm.paint.Point)
	 * 
	 * Creates and returns the instance of Polyline.
	 */
	@Override
	public Shape createShape(Point startPoint) {
		Shape polyline = new Polyline(startPoint);
		return polyline;
	}

}
