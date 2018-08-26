package ca.utoronto.utm.paint;

/**
 * StrategyFactory is a Factory Design Pattern. Creates an instance of the
 * corresponding ShapeManipulatorStrategy and returns it.
 *
 */
public class StrategyFactory {
	
	/**
	 * Creates and returns an instance of ShapeManipulatorStrategy.
	 * 
	 * @param shapeName String that specifies which instance of
	 * 					ShapeManipulatorStrategy to create.
	 * @return A ShapeManipulatorStrategy.
	 */
	public ShapeManipulatorStrategy makeStrategy(String shapeName) {
		
		ShapeManipulatorStrategy strategy = null;
		
		if (shapeName == "Circle") {
			strategy = new CircleManipulatorStrategy();
			
		} else if (shapeName == "Rectangle") {
			strategy = new RectangleManipulatorStrategy();
			
		} else if (shapeName == "Square") {
			strategy = new SquareManipulatorStrategy();
			
		} else if (shapeName == "Squiggle") {
			strategy = new SquiggleManipulatorStrategy();
			
		} else if (shapeName == "Polyline") {
			strategy = new PolylineManipulatorStrategy();
			
		} else if (shapeName == "Line") {
			strategy = new LineManipulatorStrategy();
		}
		
		return strategy;
	}
}
