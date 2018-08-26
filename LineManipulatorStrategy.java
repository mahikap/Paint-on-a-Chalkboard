public class LineManipulatorStrategy implements ShapeManipulatorStrategy {

	/* (non-Javadoc)
	 * @see ca.utoronto.utm.paint.ShapeManipulatorStrategy#createShape(ca.utoronto.utm.paint.Point)
	 * 
	 * Creates and returns the instance of Line.
	 */
	@Override
	public Shape createShape(Point startPoint) {
		Shape line = new Line(startPoint, startPoint);
		return line;
	}

}
