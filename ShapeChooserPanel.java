package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
//https://docs.oracle.com/javase/tutorial/2d/

class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	private JButton previousButton;
	
	public ShapeChooserPanel(View view) {
		this.view=view;
		
		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Line", "Polyline"};
		this.setLayout(new GridLayout(buttonLabels.length, 1));
		for (String label : buttonLabels) {
			JButton button = new JButton();
			ImageIcon icon = new ImageIcon(getClass().getResource(label+".png"));
			
			button.setIcon(icon);
			button.setActionCommand(label);
			this.add(button);
			button.addActionListener(this);
			
			if (label == "Circle") {
				previousButton = button;
				previousButton.setBackground(new Color (173, 184, 201));
				previousButton.setOpaque(true);
			}
		}
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		previousButton.setBackground(Color.LIGHT_GRAY);
		this.previousButton.setOpaque(false);
		
		JButton currentButton = (JButton)e.getSource();
		currentButton.setBackground(new Color (173, 184, 201));
		currentButton.setOpaque(true);
		
		this.previousButton = currentButton;
		
		this.view.getPaintPanel().setMode(e.getActionCommand());
		System.out.println(e.getActionCommand());

	}
	
}