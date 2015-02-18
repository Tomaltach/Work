package ie.tom.abp.gui.panel;

import ie.tom.abp.entity.BigData;
import ie.tom.abp.entity.Data;
import ie.tom.abp.entity.Report;
import ie.tom.abp.excel.read.ReadExcel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DisplayPanel {
	private List<Integer> columns;
	private List<Integer> rows;
	private List<Data> data;
	private Data info;
	private Report report;
	private double high = 0.0;
	private double low = 0.0;
	private int count = 0;
	private JTextArea output;
	private JButton submit;

	public JPanel topPanel() {
		JLabel lblUrl = new JLabel("File location");
		final JTextField fileUrl = new JTextField(20);
		submit = new JButton("Submit");
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				submit.setEnabled(false);
				output.setText("");
				final Thread submitThread = new Thread() {
					public void run() {
						ReadExcel read = new ReadExcel(fileUrl.getText());
						printInfo(read.read());
					}
				};
				final Thread counterThread = new Thread() {
					public void run() {
						int time = 0;
						while(submitThread.isAlive()) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							time++;
							output.setText("Time waiting: " + time + "\n");
						}
						printReport();
					}
				};
				submitThread.start();
				counterThread.start();
			}
		});
		
		JPanel panel = new JPanel();
		
		panel.add(lblUrl);
		panel.add(fileUrl);
		panel.add(submit);
		
		return panel;
	}
	public JPanel bottomPanel() {
		output = new JTextArea(20, 40);
		JScrollPane scroll = new JScrollPane(output);
		output.setEditable(false);
		
		JPanel panel = new JPanel();
		panel.add(scroll);
		
		return panel;
	}
	private void printInfo(BigData bigData) {
		rows = bigData.getRows();
		columns = bigData.getCols();
		data = bigData.getData();
		report = new Report();
		
		double total = 0;
		ListIterator<Integer> rowloop = rows.listIterator();
		while(rowloop.hasNext()) {
			int r_struct = rowloop.next();
			ListIterator<Integer> colloop = columns.listIterator();
			int cc = 0;
			while(colloop.hasNext()) {
				int c_struct = colloop.next();
				ListIterator<Data> dataloop = data.listIterator();
				while(dataloop.hasNext()) {
					info = dataloop.next();
					int row = info.getRow();
					int col = info.getCol();
					if(cc == 20) {
						if(row == r_struct && col == c_struct) {
							try {
								double val = Double.parseDouble(info.getData());
								total = addTotal(val, total);
							} catch(Exception e) {
								System.out.println("Number!!!");
							}
						}
					}
				}
				cc++;
			}	
			addToReport(total);
		}
		printReport();
	}
	private double addTotal(double val, double total) {
		if(high < val) {
			high = val;
		}
		if(low > val) {
			low = val;
		}
		total += val;	
		
		return total;
	}
	private void addToReport(double total) {
		report.setHigh(high);
		report.setLow(low);
		report.setCount(count++);
		total += report.getTotal();
		report.setTotal(total);		
	}
	private void printReport() {
		String message = "";
		
		double average = report.getTotal() / report.getCount();
		System.out.println("total: " + report.getTotal() + " count: " + report.getCount());
		message = "Chill 1:\t" + report.getCount();
		message += "\n\tTotal: " + report.getTotal();
		message += "\n\tHighest: " + report.getHigh();
		message += "\n\tLowest: " + report.getLow();
		message += "\n\tAverage: " + average + "\n";
		
		output.append(message);
		
		high = 0.0;
		low = 0.0;
		average = 0.0;
		count = 1;
		
		submit.setEnabled(true);
	}
}