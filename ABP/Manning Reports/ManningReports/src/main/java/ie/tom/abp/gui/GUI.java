package ie.tom.abp.gui;

import ie.tom.abp.textfile.ReadFile;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.java.dev.designgridlayout.DesignGridLayout;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	private String clock = "";
	private List<String> position = new ArrayList<String>();
	
	public GUI() {
		super("Manning Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(500,300);
		
		reload();
		init();
		
		setVisible(true);
	}
	private void init() {
		JPanel keypad = keypad();
		final JComboBox<?> jobtype = new JComboBox<Object>(position.toArray());
		
		JPanel options = options(jobtype);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(keypad, BorderLayout.CENTER);
		panel.add(jobtype, BorderLayout.WEST);
		panel.add(options, BorderLayout.SOUTH);
		
		add(panel);		
	}
	private JPanel options(final JComboBox<?> jobtype) {
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clock.length() == 4) {
                	System.out.println(clock + " | " + jobtype.getSelectedItem());
                }
            }
        });
		JButton reload = new JButton("Reload");
		reload.addActionListener(new ActionListener() {
            @SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent e) {
                reload();
                jobtype.removeAllItems();
                jobtype.setModel(new DefaultComboBoxModel(position.toArray()));
            }
        });
		
		JPanel options = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(options);
		layout.row().grid().add(reload).add(save);
		
		return options;
	}
	private JPanel keypad() {
		final JTextField clockNumber = new JTextField();
		clockNumber.setEnabled(false);
		clockNumber.setText(clock);
		
		final JButton one = new JButton("1");
		one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += one.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton two = new JButton("2");
		two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += two.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton three = new JButton("3");
		three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += three.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton four = new JButton("4");
		four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += four.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton five = new JButton("5");
		five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += five.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton six = new JButton("6");
		six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += six.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += seven.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += eight.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton nine = new JButton("9");
		nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += nine.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton zero = new JButton("0");
		zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += zero.getText();
                clockNumber.setText(clock);
                repaint();
            }
        });  
		final JButton clear = new JButton("CLR");
		clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock = "";
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		
		JPanel keypad = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(keypad);
		layout.row().grid().add(clockNumber);
		layout.row().grid().add(one).add(two).add(three);
		layout.row().grid().add(four).add(five).add(six);
		layout.row().grid().add(seven).add(eight).add(nine);
		layout.row().grid().empty().add(zero).add(clear);
		
		return keypad;
	}
	private void reload() {
		position = ReadFile.readJobType();
	}
}
