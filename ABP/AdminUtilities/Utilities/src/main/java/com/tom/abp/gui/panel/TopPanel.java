package com.tom.abp.gui.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel {

	public static JPanel getPanel() {
		JPanel panel = new JPanel();
		
		return setupPanel(panel);
	}
	private static JPanel setupPanel(JPanel panel) {
		JLabel lblTemplate = new JLabel("Template");
		
		panel.add(lblTemplate);
		
		return panel;
	}
}
