import java.util.Stack;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {
	
	// Initializing ArrayList and Stacks of shapes.
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Stack<Shape> undo_stack = new Stack<Shape>();
	
	/**
	 * Draw all shapes in the array list of shapes.
	 * 
	 * @param g2d Graphics Component.
	 */
	public void drawShapes(Graphics2D g2d) {
		for (Shape s: this.shapes) {
			s.execute(g2d);
		}
	}
	
	/**
	 * Add Shape s to the array list of shapes. Then notifies observers. 
	 * 
	 * @param s a Shape object
	 */
	public void addShape(Shape s) {
		this.shapes.add(s);
		this.setChanged();
		this.notifyObservers();
	}
	
	public Shape removeShape(){
		if (!this.shapes.isEmpty()){
			Shape last = this.shapes.get(this.shapes.size()-1);
			this.undo_stack.push(last);
			this.shapes.remove(this.shapes.size()-1);
			return last;
		}
		return null;
		
	}
	
	public void redrawShape(){
		if (!this.undo_stack.isEmpty()){
			this.shapes.add(this.undo_stack.pop());
		}
	}
	
	/**
	 * Clear array list and stack of shapes.
	 */
	public void clearShapes(){
		this.shapes.clear();
		this.undo_stack.clear();
	}
	
	/**
	 * @return the array list of shapes.
	 */
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	
	/**
	 * Redraw Shape s.
	 * 
	 * @param g2d 	Graphics Component
	 * @param s		a Shape object
	 */
	public void repaintShape(Graphics2D g2d, Shape s){
		((Shape)s).execute(g2d);
	}
	
}
	

	
	


