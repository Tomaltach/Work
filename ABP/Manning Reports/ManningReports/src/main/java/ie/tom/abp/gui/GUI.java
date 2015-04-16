package ie.tom.abp.gui;

import ie.tom.abp.entity.Employee;
import ie.tom.abp.excel.WriteExcel;
import ie.tom.abp.textfile.ReadFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.java.dev.designgridlayout.DesignGridLayout;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	private static final String HEADER = "Clock | Job Type\n--------+------------\n";
	private String clock = "";
	private List<String> position = new ArrayList<String>();
	private List<Employee> emp = new ArrayList<Employee>();
	
	public GUI() {
		super("Manning Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setResizable(false);
		setSize(300,700);
		
		reload();
		init();
		
		setVisible(true);
	}
	private void init() {
		final JComboBox<?> jobtype = new JComboBox<Object>(position.toArray());
		jobtype.setPreferredSize(new Dimension(10,20));
		final JTextArea textarea = new JTextArea(5, 5);
		textarea.setEditable(false);
		textarea.setText(HEADER);
		JScrollPane pane = new JScrollPane(textarea);
		
		JPanel keypad = keypad(jobtype, textarea);
		JPanel options = options(jobtype, textarea);
		
		JPanel body = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(body);
		layout.row().grid().add(keypad);
		layout.row().grid().add(jobtype);
		layout.row().grid().add(pane);
		layout.row().grid().add(options);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(body, BorderLayout.CENTER);
		
		add(panel);		
	}
	private JPanel options(final JComboBox<?> jobtype, final JTextArea textarea) {
		JButton reload = new JButton("Reload");
		reload.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent e) {
				reload();
                jobtype.removeAllItems();
                jobtype.setModel(new DefaultComboBoxModel(position.toArray()));
            }
		});
		JButton export = new JButton("Export");
		export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t1 = new Thread(new Runnable() {
				     public void run() {
						new WriteExcel(emp);				
						textarea.setText(HEADER);
						emp.clear();
				     }
				});  
				t1.start();
            }
		});
		
		JPanel options = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(options);
		layout.row().grid().add(reload).add(export);
		
		return options;
	}
 	private JPanel keypad(final JComboBox<?> jobtype, final JTextArea textarea) {
		final JTextField clockNumber = new JTextField(20);
		clockNumber.setEditable(false);
		clockNumber.setBackground(Color.WHITE);
		clockNumber.setText(clock);
		
		final JButton one = new JButton("1");
		one.setPreferredSize(new Dimension(40, 40));
		one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += one.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton two = new JButton("2");
		two.setPreferredSize(new Dimension(40, 40));
		two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += two.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton three = new JButton("3");
		three.setPreferredSize(new Dimension(40, 40));
		three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += three.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton four = new JButton("4");
		four.setPreferredSize(new Dimension(40, 40));
		four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += four.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton five = new JButton("5");
		five.setPreferredSize(new Dimension(40, 40));
		five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += five.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton six = new JButton("6");
		six.setPreferredSize(new Dimension(40, 40));
		six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += six.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton seven = new JButton("7");
		seven.setPreferredSize(new Dimension(40, 40));
		seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += seven.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton eight = new JButton("8");
		eight.setPreferredSize(new Dimension(40, 40));
		eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += eight.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton nine = new JButton("9");
		nine.setPreferredSize(new Dimension(40, 40));
		nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += nine.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton zero = new JButton("0");
		zero.setPreferredSize(new Dimension(40, 40));
		zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += zero.getText();
                clockNumber.setText(clock);
                repaint();
            }
        });  
		final JButton clear = new JButton("Clear");
		clear.setPreferredSize(new Dimension(40, 40));
		clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock = "";
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		JButton save = new JButton("Save");
		save.setPreferredSize(new Dimension(40, 40));
		save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clock.length() == 4 && !jobtype.getSelectedItem().equals("Job Type")) {
                	System.out.println(clock + "| " + jobtype.getSelectedItem());
                	textarea.setText(output(clock, ""+jobtype.getSelectedItem()));
                	
                	emp.add(new Employee(clock, ""+jobtype.getSelectedItem()));
                    
                	clock = "";
                    clockNumber.setText(clock);
                    repaint();
                }
            }
        });
		
		JPanel keypad = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(keypad);
		layout.row().grid().add(clockNumber);
		layout.row().grid().add(one).add(two).add(three);
		layout.row().grid().add(four).add(five).add(six);
		layout.row().grid().add(seven).add(eight).add(nine);
		layout.row().grid().add(clear).add(zero).add(save);
		
		return keypad;
	}
	private String output(String clock1, String jobtype) {
		emp.add(new Employee(clock, jobtype));
		String out = "";
		ListIterator<Employee> li = emp.listIterator(emp.size());		
		while(li.hasPrevious()) {			
			Employee e = li.previous();
			out = e.getClock() + "  | " + e.getJobtype() + "\n" + out;
		}
		return HEADER + out;
	}
 	private void reload() {
		position = ReadFile.readJobType();
	}
}
