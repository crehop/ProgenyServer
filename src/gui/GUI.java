package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI extends JFrame {
	
	GridBagConstraints constraints;
	JPanel panel;
	
	public GUI(String name) {
		super(name);
		panel = new JPanel(new GridBagLayout());
		
		constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
	}

	public GridBagConstraints getConstraints() {
		return constraints;
	}

	public void setConstraints(GridBagConstraints constraints) {
		this.constraints = constraints;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
