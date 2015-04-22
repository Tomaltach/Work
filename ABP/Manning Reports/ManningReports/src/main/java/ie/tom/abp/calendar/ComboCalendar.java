package ie.tom.abp.calendar;

import ie.tom.abp.calendar.dates.DetermineLeapYear;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.joda.time.DateTime;

import net.java.dev.designgridlayout.DesignGridLayout;

public class ComboCalendar {
	private JComboBox<?> day;
	private JComboBox<?> month;
	private JComboBox<?> year;
	private static final float MEDIUM_TEXT = 36;
	private static final String[] DAYS = {
		"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
		"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
		"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
		"30"
	};
	private static final String[] MONTHS = {
		"January", "Feburary", "March", "April",
		"May", "June", "July", "August",
		"September", "October", "November", "December"
	};
	private String[] years = {
		"2013", "2014", "2015", "2016"
	};
	
	public ComboCalendar() {
		dayCombo();
		monthCombo();
		yearCombo();
		setDate();
	}
	public JPanel calendar(){
		JPanel panel = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(panel);
		layout.row().grid().add(day).grid().add(month).grid().add(year);
		
		return panel;
	}
	public String getDate() {
		return day.getSelectedItem().toString() + " " +
				month.getSelectedItem().toString() + " " +
				year.getSelectedItem().toString();
	}
	public JComboBox<?> getDay() {
		return day;
	}
	public JComboBox<?> getMonth() {
		return month;
	}
	public JComboBox<?> getYear() {
		return year;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void dayCombo() {
		day = new JComboBox<Object>();
		day.setPreferredSize(new Dimension(20,50));
		day.setFont(day.getFont().deriveFont(MEDIUM_TEXT));
		day.setModel(new DefaultComboBoxModel(DAYS));
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void monthCombo() {
		month = new JComboBox<Object>();
		month.setPreferredSize(new Dimension(20,50));
		month.setFont(month.getFont().deriveFont(MEDIUM_TEXT));
		month.setModel(new DefaultComboBoxModel(MONTHS));
		month.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validate();
			}			
		});
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void yearCombo() {
		year = new JComboBox<Object>();
		year.setPreferredSize(new Dimension(20,50));
		year.setFont(year.getFont().deriveFont(MEDIUM_TEXT));
		year.setModel(new DefaultComboBoxModel(years));
		year.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validate();
			}			
		});
	}
	private void validate() {
		int cy = 2015;
		try {
			cy = Integer.parseInt(year.getSelectedItem().toString());
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		String cm = month.getSelectedItem().toString();
		if(DetermineLeapYear.checkYear(cy) == true) {			
			if(cm.equals("Feburary")) {
				fillDays(29);
			} else if(cm.equals("April") || cm.equals("June") || cm.equals("September") || cm.equals("November")) {
				fillDays(30);
			} else {
				fillDays(31);
			}
		} else {
			if(cm.equals("Feburary")) {
				fillDays(28);
			} else if(cm.equals("April") || cm.equals("June") || cm.equals("September") || cm.equals("November")) {
				fillDays(30);
			} else {
				fillDays(31);
			}
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void fillDays(int max) {
		String[] temp = new String[max];
		for(int i=0; i<max; i++) {
			temp[i] = DAYS[i];
		}
		day.setModel(new DefaultComboBoxModel(temp));
	}
	private void setDate() {
		DateTime date = new DateTime();
		
		int d = date.getDayOfMonth();
		int m = date.getMonthOfYear();
		int y = date.getYear();
		
		String sy = "" + y;
		int i = 0;
		while(!year.getItemAt(i).equals(sy)) {
			i++;
		}
		year.setSelectedIndex(i);
		month.setSelectedIndex(m-1);
		day.setSelectedIndex(d-1);
	}
}