package ca.utoronto.utm.paint;


/**
 * Point is a point with an x and y coordinates.
 *
 */
public class Point {
	
	int x, y;
	
	/**
	 * Creates a point with an x and y coordinates.
	 * 
	 * @param x	an integer indicating horizontal position.
	 * @param y an integer indicating vertical position.
	 */
	public Point(int x, int y) {
		this.x = x;	this.y = y;
	}
	
	/**
	 * @return the x coordinate of the point.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the new x coordinate of the point to integer x.
	 * 
	 * @param x an integer indicating horizontal position.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y coordinate of the point.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the new y coordinate of the point to integer y.
	 * 
	 * @param y an integer indicating vertical position.
	 */
	public void setY(int y) {
		this.y = y;
	}

}
