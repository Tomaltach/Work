package ie.tom.abp.gui;

import ie.tom.abp.gui.panel.DisplayPanel;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	public GUI() {
		super("Chill Weight");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		build();
				
		pack();
		setSize(500,500);
		setResizable(false);
		setVisible(true);
	}
	private void build() {
		DisplayPanel dis = new DisplayPanel();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.add(dis.topPanel(), BorderLayout.NORTH);
		panel.add(dis.bottomPanel(), BorderLayout.CENTER);
		
		add(panel);
	}
}