package ie.tom.abp.excel;

import ie.tom.abp.email.SendEmailReport;
import ie.tom.abp.entity.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	private List<Employee> emp;
	private String ip;
	private String emails;
	private String date;
	private final static String PATH = "C:\\ITManningSheets\\ManningSheets\\";

	public WriteExcel(List<Employee> emp, String ip, String emails, String date) {
		this.emp = emp;
		this.ip = ip;
		this.emails = emails;
		this.date = date;
		init();
	}
	private void init() {
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Manning");
		
		int rownum = 0;
		Row row = sheet.createRow(rownum++);
		Cell cell = row.createCell(0);
		cell.setCellValue((String) "Clock Number");
		cell = row.createCell(1);
		cell.setCellValue((String) "Job Area");
		cell = row.createCell(2);
		cell.setCellValue((String) "Job Type");
		
		Iterator<Employee> iterator = emp.iterator();
		while(iterator.hasNext()) {
			Employee data = iterator.next();
			String clock = data.getClock();
			String jobarea = data.getJobarea();
			String jobtype = data.getJobtype();
			
			row = sheet.createRow(rownum++);
			cell = row.createCell(0);
			cell.setCellValue((String) clock);
			cell = row.createCell(1);
			cell.setCellValue((String) jobarea);
			cell = row.createCell(2);
			cell.setCellValue((String) jobtype);
		}
        
		try {
			//Write the workbook in file system
			String fileName = "Manning - " + date + ".xlsx";
			FileOutputStream out = new FileOutputStream(new File(PATH + fileName));
			workbook.write(out);
			out.close();
			System.out.println(PATH + fileName + " written successfully on disk.");
			new SendEmailReport(PATH, fileName, ip, emails);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}