package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * DrawingCommand is an interface that follows the Command Design Pattern
 * Each shape (ie. Circle) implements this interface and has access to the
 * execute() method. This means that each shape can draw itself, and 
 * can be "commanded" to be executed.
 *
 */
public interface DrawingCommand {

	/**
	 * Draw a Shape using Graphics2D, setting the appropriate dimensions,
	 * positions, Line Width, Color, and Fill appropriately.
	 * @param g2d
	 */
	public void execute(Graphics2D g2d);
	
}
