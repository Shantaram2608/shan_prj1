package selenium;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInExcelsheetByusingArrayListAndPOI {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("EmpInformation");

		ArrayList<Object[]> alemp = new ArrayList<Object[]>();
		alemp.add(new Object[] { "EmpId", "Name", "Job" });
		alemp.add(new Object[] { 111, "Shan", "Tester" });
		alemp.add(new Object[] { 112, "kishor", "QA" });
		alemp.add(new Object[] { 113, "karan", "devloper" });

		int rowCount = 0;
		for (Object[] emp : alemp) {
			XSSFRow row = sheet.createRow(rowCount++);
			int columnCount = 0;
			for (Object value : emp) {
				XSSFCell cell = row.createCell(columnCount++);
				if(value instanceof String)
					cell.setCellValue((String) value);
				if(value instanceof Integer)
					cell.setCellValue((Integer) value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean) value);
			}
		}
		
		String filepath=".\\Datafiles\\workersss.xlsx";
		FileOutputStream fo = new FileOutputStream(filepath);
		workbook.write(fo);
		fo.close();
		System.out.println("workersss.xlsx file writen successfully");

		
	}

}
