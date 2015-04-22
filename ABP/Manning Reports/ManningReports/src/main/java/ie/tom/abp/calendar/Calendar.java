package ie.tom.abp.calendar;

import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JTextField;

import net.sourceforge.jcalendarbutton.JCalendarButton;

public class Calendar {
	public JTextField txtDate = new JTextField(""); 
	private JCalendarButton btnCalendar;
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
	private static final float MEDIUM_TEXT = 36;
	private String dateString = " ";

	public JCalendarButton getCalendarButton() {
		btnCalendar = new JCalendarButton();
		btnCalendar.setPreferredSize(new Dimension(20,50));
        btnCalendar.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                dateOnlyPopupChanged(evt);
            }
        });
		 
		return btnCalendar;
	}
	public JTextField getTextField() {
		txtDate.setPreferredSize(new Dimension(20,50));
		txtDate.setFont(txtDate.getFont().deriveFont(MEDIUM_TEXT));
		txtDate.setEditable(false);
		
		return txtDate;
	}
	public String getDate() {
		return dateString;
	}
	private void dateOnlyPopupChanged(PropertyChangeEvent evt) {
        if(evt.getNewValue() instanceof Date)
            setDate((Date)evt.getNewValue());
    }
    private void setDate(Date date){
        dateString = "";
        if(date != null) {
            dateString = dateFormat.format(date);
        }
        txtDate.setText(dateString);
        btnCalendar.setTargetDate(date);
    }
}