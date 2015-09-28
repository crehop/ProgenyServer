package gui;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JFrame;


public class Terminal extends GUI{
	
	private JLabel overview;
	
	public Terminal() {
		super("Terminal");
		overview = new JLabel("Server Overview");

		super.constraints.gridx = 0;
		super.constraints.gridy = 0;
		panel.add(overview,constraints);
		panel.setBorder(BorderFactory.createTitledBorder(
	                BorderFactory.createEtchedBorder(), "Server Information Panel"));
		
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setSize(300, 700);
	}
	
}
