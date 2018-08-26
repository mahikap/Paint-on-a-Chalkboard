package ca.utoronto.utm.paint;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener  {
	private int i = 0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	private StrategyFactory factory;

	private String mode; 
	private int lineWidth;
	private Color lineColor = Color.white;
	private Boolean isFilled = false;

	private Polyline polyline;
	private Shape shape;
	private ShapeManipulatorStrategy strategy;
	
	
	public PaintPanel(PaintModel model, View view) {
		this.setBackground(new Color(51,51,51));
		this.setPreferredSize(new Dimension(600,400));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		this.mode = "Circle";
		
		this.model = model;
		this.model.addObserver(this);
		
		this.view = view;
		
		//create a factory to make strategies, which the user will trigger
		this.factory = new StrategyFactory();
		
	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
        
		// Origin is at the top left of the window 50 over, 75 down
		g2d.setColor(Color.white);
        g2d.drawString("i="+i, 50, 75);
		i=i+1;
		
		//call PaintModel to draw all Shapes
		this.model.drawShapes(g2d);
			
		//During mouseDragged event, show Shape feedback
		if (this.shape != null) {
			this.model.repaintShape(g2d, this.shape);	
		}
			
		g2d.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}
	
	/**
	 *  Controller aspect of this
	 */
	public void setMode(String mode) {
		this.polyline = null;
		this.mode = mode;
	}
	
	/**
	 * Return the String representation of this mode
	 * 
	 * @return String current mode
	 */
	public String getMode() {
		return this.mode;
	}
	
	/**
	 * Set shape attribute to null
	 */
	public void nullShape() {
		this.shape = null;
	}
	
	/**
	 * Set Line Width of this Shape to desired width
	 * 
	 * @param width desired Line Width
	 */
	public void setLineWidth(int width) {
		this.lineWidth = width;
	}
	
	/**
	 * Return current Line Width
	 * 
	 * @return int current Line Width
	 */
	public int getLineWidth() {
		return this.lineWidth;
	}
	
	/**
	 * Set color of this Shape to desired color
	 * 
	 * @param color desired Color
	 */
	public void setColor(Color color) {
		this.lineColor = color;
	}
	
	/**
	 * Return the Color of this shape
	 * 
	 * @return Color color of this shape
	 */
	public Color getColor() {
		return this.lineColor;
	}
	
	/**
	 * Set isFilled to Boolean b, 
	 * to indicate if Shape is filled or not
	 * 
	 * @param b True or False
	 */
	public void setIsFilled(Boolean b) {
		this.isFilled = b;
	}
	
	/**
	 * Return if this Shape is filled or not
	 * 
	 * @return boolean True or False
	 */
	public Boolean getIsFilled() {
		return this.isFilled;
	}
	
	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {

	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {

	}
	
	/* 
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 * 
	 * Call paintComponent repaint() to redraw shape for Shape feedback
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		this.shape.mouseDragged(new Point(e.getX(), e.getY()));
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point point = new Point(e.getX(), e.getY());
		
		//if Polyline is being drawn, continue adding points to this shape
		if ((this.mode == "Polyline") && (this.shape != null)) {
			((Polyline)this.shape).addPoint(point);
			
		} else {
			
			//Eraser creates a Squiggle Strategy
			if (this.mode == "Eraser") {
				this.strategy = this.factory.makeStrategy("Squiggle");
			}
			
			else {
				this.strategy = this.factory.makeStrategy(this.mode);
			}
			
			//Strategy creates a Shape
			this.shape = this.strategy.createShape(point);
			this.shape.mousePressed(this, point);
		}
	}

	/* 
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 * 
	 * Add the created Shape to the model.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		
		this.shape.mouseReleased(this.model, new Point(e.getX(), e.getY()));
		this.model.addShape(this.shape);
		
		if (!(this.mode == "Polyline")) {
			this.shape = null;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}