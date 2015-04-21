package ie.tom.abp.gui;

import ie.tom.abp.calendar.Calendar;
import ie.tom.abp.entity.Employee;
import ie.tom.abp.excel.WriteExcel;
import ie.tom.abp.startup.Startup;
import ie.tom.abp.textfile.ReadFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.BoxLayout;
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
	private static final String HEADER = "Clock |Job Area |Job Type\n------+---------+------------\n";
	private Calendar calendar = new Calendar();
	private Startup startup;
	private String clock = "";
	private List<String> area = new ArrayList<String>();
	private List<String> position = new ArrayList<String>();
	private List<Employee> emp = new ArrayList<Employee>();
	private static final float LARGE_TEXT = 48;
	private static final float MEDIUM_TEXT = 36;
	private static final int SMALL_TEXT = 24;
	private String ip;
	private String jobareas;
	private String jobtypes;
	private String emails;
	private String path;
	JComboBox<?> jobarea;
	JComboBox<?> jobtype;
	
	public GUI(String ip, String jobareas, String jobtypes, String emails, String path, Startup startup) {
		super("Manning Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
		this.ip = ip;
		this.jobareas = jobareas;
		this.jobtypes = jobtypes;
		this.emails = emails;
		this.path = path;
		this.startup = startup;
		
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();
		setSize(dim.width, dim.height);
		
		reload();
		init();
		
		setVisible(true);
	}
	private void init() {
		final JTextArea textarea = new JTextArea(5, 5);
		Font myFont = new Font("Courier", Font.BOLD, SMALL_TEXT);
		textarea.setFont(myFont);
		textarea.setEditable(false);
		textarea.setText(HEADER);
		JScrollPane pane = new JScrollPane(textarea);
		
		JPanel jobs = jobtypes();
		JPanel keypad = keypad(textarea);
		JPanel options = options(textarea);
				
		JPanel body = new JPanel();
		body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
		body.add(keypad);
		body.add(jobs);
		body.add(pane);
		body.add(options);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(body, BorderLayout.CENTER);
		
		add(panel);		
	}
	private JPanel jobtypes() {
		jobarea = new JComboBox<Object>(area.toArray());
		jobarea.setPreferredSize(new Dimension(360,60));
		jobarea.setFont(jobarea.getFont().deriveFont(LARGE_TEXT));
				
		jobtype = new JComboBox<Object>(position.toArray());
		jobtype.setPreferredSize(new Dimension(10,60));
		jobtype.setFont(jobtype.getFont().deriveFont(LARGE_TEXT));
		
		JPanel jobs = new JPanel(new BorderLayout());
		jobs.add(jobarea, BorderLayout.WEST);
		jobs.add(jobtype, BorderLayout.CENTER);
				
		return jobs;	
	}
	private JPanel options(final JTextArea textarea) {
		JButton reload = new JButton("Reload");
		reload.setPreferredSize(new Dimension(40, 100));
		reload.setFont(reload.getFont().deriveFont(MEDIUM_TEXT));
		reload.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent e) {
				reload();
                jobarea.removeAllItems();
                jobarea.setModel(new DefaultComboBoxModel(area.toArray()));
                jobtype.removeAllItems();
                jobtype.setModel(new DefaultComboBoxModel(position.toArray()));
            }
		});
		JButton export = new JButton("Export");
		export.setPreferredSize(new Dimension(40, 100));
		export.setFont(export.getFont().deriveFont(MEDIUM_TEXT));
		export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t1 = new Thread(new Runnable() {
				     public void run() {
				    	 if(!calendar.getDate().equals(" ")) {
					    	 new WriteExcel(emp, ip, ReadFile.readEmail(path, emails), calendar.getDate());				
					    	 textarea.setText(HEADER);
					    	 emp.clear();
				    	 } else {
				    		 textarea.setText("\n\n\tMust enter Date!!\n\n");
				    	 }
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
 	private JPanel keypad(final JTextArea textarea) {
		final JTextField clockNumber = new JTextField(20);
		clockNumber.setFont(clockNumber.getFont().deriveFont(MEDIUM_TEXT));
		clockNumber.setEditable(false);
		clockNumber.setBackground(Color.WHITE);
		clockNumber.setText(clock);
		
		final JButton one = new JButton("1");
		one.setPreferredSize(new Dimension(40, 100));
		one.setFont(one.getFont().deriveFont(MEDIUM_TEXT));
		one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += one.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton two = new JButton("2");
		two.setPreferredSize(new Dimension(40, 100));
		two.setFont(two.getFont().deriveFont(MEDIUM_TEXT));
		two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += two.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton three = new JButton("3");
		three.setPreferredSize(new Dimension(40, 100));
		three.setFont(three.getFont().deriveFont(MEDIUM_TEXT));
		three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += three.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton four = new JButton("4");
		four.setPreferredSize(new Dimension(40, 100));
		four.setFont(four.getFont().deriveFont(MEDIUM_TEXT));
		four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += four.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton five = new JButton("5");
		five.setPreferredSize(new Dimension(40, 100));
		five.setFont(five.getFont().deriveFont(MEDIUM_TEXT));
		five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += five.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton six = new JButton("6");
		six.setPreferredSize(new Dimension(40, 100));
		six.setFont(six.getFont().deriveFont(MEDIUM_TEXT));
		six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += six.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton seven = new JButton("7");
		seven.setPreferredSize(new Dimension(40, 100));
		seven.setFont(seven.getFont().deriveFont(MEDIUM_TEXT));
		seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += seven.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton eight = new JButton("8");
		eight.setPreferredSize(new Dimension(40, 100));
		eight.setFont(eight.getFont().deriveFont(MEDIUM_TEXT));
		eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += eight.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton nine = new JButton("9");
		nine.setPreferredSize(new Dimension(40, 100));
		nine.setFont(nine.getFont().deriveFont(MEDIUM_TEXT));
		nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += nine.getText();
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		final JButton zero = new JButton("0");
		zero.setPreferredSize(new Dimension(40, 100));
		zero.setFont(zero.getFont().deriveFont(MEDIUM_TEXT));
		zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock += zero.getText();
                clockNumber.setText(clock);
                repaint();
            }
        });  
		final JButton clear = new JButton("Clear");
		clear.setPreferredSize(new Dimension(40, 100));
		clear.setFont(clear.getFont().deriveFont(MEDIUM_TEXT));
		clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock = "";
                clockNumber.setText(clock);
                repaint();
            }
        }); 
		JButton save = new JButton("Save");
		save.setPreferredSize(new Dimension(40, 100));
		save.setFont(save.getFont().deriveFont(MEDIUM_TEXT));
		save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validate(textarea, clockNumber);
            }
        });
		
		JPanel keypad = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(keypad);
		layout.row().grid().add(clockNumber).grid().add(calendar.getTextField()).add(calendar.getCalendarButton());
		layout.row().grid().add(one).add(two).add(three);
		layout.row().grid().add(four).add(five).add(six);
		layout.row().grid().add(seven).add(eight).add(nine);
		layout.row().grid().add(clear).add(zero).add(save);
		
		return keypad;
	}
	private String output(String clock, String jobtype, String jobarea) {
		emp.add(new Employee(clock, jobtype, jobarea));
		String out = "";
		ListIterator<Employee> li = emp.listIterator(emp.size());		
		while(li.hasPrevious()) {			
			Employee e = li.previous();
			out = out + e.getClock() + "  |" + e.getJobarea() + "\t|" + e.getJobtype() + "\n";
		}
		return HEADER + out;
	}
 	private void validate(JTextArea textarea, JTextField clockNumber) {
 		if(clock.length() == 4 && !jobarea.getSelectedItem().equals("--- Job Area ---")
 				&& !jobtype.getSelectedItem().equals("--- Job Type ---")
        		&& !jobtype.getSelectedItem().equals("--- FQ ---")
        		&& !jobtype.getSelectedItem().equals("--- HQ ---")
        		&& !jobtype.getSelectedItem().equals("--- PAD ---")
        		&& !jobtype.getSelectedItem().equals("--- Packing ---")
        		&& !jobtype.getSelectedItem().equals("--- Abbatoir")
        		&& !jobtype.getSelectedItem().equals("")) {
        	System.out.println(clock + " | " + jobarea.getSelectedItem() + "\t| " + jobtype.getSelectedItem());
        	textarea.setText(output(clock, ""+jobtype.getSelectedItem(), ""+jobarea.getSelectedItem()));
        	                    
        	clock = "";
            clockNumber.setText(clock);
            repaint();
        }
 	}
	private void reload() {
 		startup.reloadCache();
 		area = ReadFile.readJobType(path, jobareas);
		position = ReadFile.readJobType(path, jobtypes);
	}
}
