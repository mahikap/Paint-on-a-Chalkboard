package ca.utoronto.utm.paint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LineThicknessSelectorPanel extends JPanel implements ActionListener {
	
	private View view;
	
	/**
	 * Creates a drop down menu to select a shape (or eraser's) line width.
	 * @param view View
	 */
	public LineThicknessSelectorPanel(View view) {
		this.view = view;
		
		view.getPaintPanel().setLineWidth(1);
		
		// ComboBox options
		String[] widthStrings = {"width 1", "width 5", "width 10", "width 15", "width 20"};
		
		// Make ComboBox
		JComboBox widthOptions = new JComboBox(widthStrings);
		widthOptions.addActionListener(this);
		
		// Layout
		this.add(widthOptions);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * According to a user's selection, this sets the line width for new shapes.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox combo = (JComboBox)e.getSource();
		String widthString = (String)combo.getSelectedItem();
		int widthInt = Integer.parseInt(widthString.substring(6));
		
		this.view.getPaintPanel().setLineWidth(widthInt);
		this.view.getPaintPanel().nullShape();
	}
}
