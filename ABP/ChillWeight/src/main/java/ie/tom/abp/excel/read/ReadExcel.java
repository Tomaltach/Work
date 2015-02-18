package ie.tom.abp.excel.read;

import ie.tom.abp.entity.BigData;
import ie.tom.abp.entity.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ReadExcel {
	private String url;// = "C:\\Users\\tdonegan\\Desktop";
	private List<Integer> columns;
	private List<Integer> rows;
	private List<Data> data;
	Data info;
	
	public ReadExcel(String url) {
		this.url = url;
	}
	@SuppressWarnings({ "resource" })
	public BigData read() {
		rows = new ArrayList<Integer>();
		columns = new ArrayList<Integer>();
		data = new ArrayList<Data>();
		try {
			FileInputStream fileInputStream = new FileInputStream(url + "\\report1.xls");
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheet("AIBP Report");
			
			HSSFRow row;
			HSSFCell cell;
			String val = null;
			
			for(int i=2; i<100; i++) { //1162
				row = worksheet.getRow(i);
				rows.add(i);
				for(int j=0; j<21; j++) { //21
					row = worksheet.getRow(i);
					cell = row.getCell(j);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					val = cell.getStringCellValue();
					columns.add(j);
					
					info = new Data();
					info.setRow(i);
					info.setCol(j);
					info.setData(val);
					data.add(info);
				}
			}			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Make sure the you entered the File URL correctly!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BigData bg = new BigData();
		bg.setCols(columns);
		bg.setRows(rows);
		bg.setData(data);		
		
		return bg;
	}
}