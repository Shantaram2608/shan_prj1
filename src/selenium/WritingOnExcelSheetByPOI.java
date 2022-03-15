package selenium;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingOnExcelSheetByPOI {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("emp Info");

		Object empdata[][] = { { "EmpID", "Name", "Job" }, { 101, "Ram", "Engineer" }, { 102, "Kishor", "Manager" },
				{ 103, "Shantaram", "Developer" } };
		
		//*******By using for loop********
	/*	int rows = empdata.length;
		int cols = empdata[0].length;
		System.out.println(rows);
		System.out.println(cols);
		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheet.createRow(r);
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = row.createCell(c);
				Object value = empdata[r][c];
				if (value instanceof String)
					cell.setCellValue((String) value);
				if (value instanceof Integer)
					cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					cell.setCellValue((Boolean) value);
			}
		}*/
		
		//**********By using for each loop***********
		int rowCount=0;
		for(Object emp[]:empdata) {
			XSSFRow row = sheet.createRow(rowCount++);
			int columnCount=0;
			for(Object value:emp) {
				XSSFCell cell = row.createCell(columnCount++);
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
			}
		}
		//String filepath=".\\Datafiles\\employee.xlsx";
		String filepath=".\\Datafiles\\worker.xlsx";
		FileOutputStream fo = new FileOutputStream(filepath);
		workbook.write(fo);
		fo.close();
		System.out.println("worker.xlsx file writen successfully");

	}

}
