package ie.tom.abp.gui.panel;

import ie.tom.abp.entity.BigData;
import ie.tom.abp.entity.Data;
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
	private double high = 0;
	private double low = 0;
	private int count = 0;
	private JTextArea output;

	public JPanel topPanel() {
		JLabel lblUrl = new JLabel("File location");
		final JTextField fileUrl = new JTextField(20);
		JButton submit = new JButton("Submit");
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReadExcel read = new ReadExcel(fileUrl.getText());
				
				printInfo(read.read());
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
		
		output.setText("");
		String message = "";
		double total = 0;
		ListIterator<Integer> rowloop = rows.listIterator();
		while(rowloop.hasNext()) {
			System.out.println("rowloop: " + count);
			ListIterator<Integer> colloop = columns.listIterator();
			count = 0;
			while(colloop.hasNext()) {
				System.out.print("colloop: " + count);
				output.append("thff lkh");
				System.out.print(" size: " + columns.size());
				int i = colloop.next();
				System.out.println(" int: " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ListIterator<Data> dataloop = data.listIterator();
				while(dataloop.hasNext()) {
					System.out.println("dataloop: " + count);
					info = dataloop.next();
					int row = info.getRow();
					int col = info.getCol();
					if(row == rowloop.next() && col == colloop.next()) {
						try {
							double val = Double.parseDouble(info.getData());
							total = addTotal(val, total);
						} catch(Exception e) {
							System.out.println("Number!!!");
						}
					}
				}
				count++;
			}
			double average = total / count;

			message = "Chill 1:\n\tHighest: " + high + "\n\tLowest: " + low + "\n\tAverage: " + average + "\n";
			
			output.append(message);
		}
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
}