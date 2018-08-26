package ca.utoronto.utm.paint;

/**
 * ShapeManipulatorStrategy is an interface to resemble the 
 * Strategy Design Pattern. Each Shape has its own ManipulatorStrategy
 * (ie. CircleManipulatorStrategy), which implements this interface.
 * These strategies are then responsible for creating an instance
 * of the indicated Shape. This shape is responsible for user's 
 * mouse events, and calling repaint at appropriate times. 
 */
public interface ShapeManipulatorStrategy {
	
	
	/**
	 * Creates an instance of Shape.
	 * @param startPoint Point at which to create Shape
	 */
	public Shape createShape(Point startPoint);
	
}
