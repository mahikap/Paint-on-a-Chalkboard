import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class ColorChooserPanel extends JPanel implements ActionListener {
	private View view;
	private Color c = new Color (173, 184, 201);
	private JToggleButton fill;
	private boolean fillPressed = false;
	
	/**
	 * Create "Eraser", "Color", and "Fill" buttons with respective icons. For each buttons,
	 * a corresponding ActionListener is called.
	 * @param view View
	 */
	public ColorChooserPanel(View view){
		this.view = view;
		
		JButton eraser = new JButton();
		ImageIcon icon_e = new ImageIcon(getClass().getResource("Eraser.png"));
		eraser.setIcon(icon_e);
		eraser.setActionCommand("Eraser");
		eraser.addActionListener(this);
		
		JButton color = new JButton();
		ImageIcon icon = new ImageIcon(getClass().getResource("Color_Map.png"));
		color.setIcon(icon);
		color.setActionCommand("Color");
		color.addActionListener(this);
		
		this.fill = new JToggleButton ();
		ImageIcon fill_icon = new ImageIcon(getClass().getResource("Bucket_Fill.png"));
		fill.setIcon(fill_icon);
		fill.setActionCommand("Fill");
		fill.addActionListener(this);
		
		this.add(color);
		this.add(fill);
		this.add(eraser);
		
	}
	
	/**
	 * Return the color chosen
	 * @return color chosen
	 */
	public Color getColor(){
		return c;
	}


	/**
	 * Return whether or not the button is pressed
	 * @return boolean
	 */
	public boolean isFillPressed(){
		return fillPressed;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * Control actions when "Color", "Fill", and "Eraser" are pressed. 
	 * Color: 	When color is clicked, it is initialized as white. 
	 * 			If either colorbutton or fillbutton is clicked then the background of the button 
	 * 			is changed to the chosen color.
	 * 			Set chosen color to PaintPanel.
	 * Fill:	If fill button is clicked, set background of the button to the choosen color.
	 * 			If fill button is not clicked, change the background of the button to opaque and
	 * 			the original color.
	 * Eraser:	Set eraser to PaintPanel.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Color") {
			Color c = JColorChooser.showDialog(null, "Choose a Color", Color.white);
			this.c = c;
			System.out.println(c);
			//resource: http://www.java2s.com/Tutorial/Java/0240__Swing/UseaColorChooser.htm
			
			((JButton)e.getSource()).setBackground(this.getColor());
			((JButton)e.getSource()).setOpaque(true);
			
			if (this.isFillPressed()) {
				this.fill.setBackground(this.getColor());
				this.fill.setOpaque(true);
			}
			
			this.view.getPaintPanel().setColor(getColor());
			this.view.getPaintPanel().nullShape();
			
		} else if (e.getActionCommand() == "Fill") {
			if (fillPressed){
				fillPressed = false;
				
				// turn off highlight to notify that fill is not active
				((JToggleButton)e.getSource()).setOpaque(false);
				
				this.view.getPaintPanel().setIsFilled(false);
				
			} else {
				fillPressed = true;
				
				// highlight button to notify that fill is active
				((JToggleButton)e.getSource()).setBackground(this.getColor());
				((JToggleButton)e.getSource()).setOpaque(true);

				this.view.getPaintPanel().setIsFilled(true);
			}
			
		} else if (e.getActionCommand() == "Eraser") {
			this.view.getPaintPanel().setMode(e.getActionCommand());
		}	
	}
}
