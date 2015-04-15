package com.tom.abp.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.tom.abp.gui.panel.TopPanel;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	public GUI() {
		super("Admin Utilities");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
		setup();
		
		setSize(500,500);
		setLocation(50,100);
		setVisible(true);
	}
	private void setup() {
		add(TopPanel.getPanel(), BorderLayout.NORTH);
	}
}
