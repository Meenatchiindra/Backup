package org.sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ex {
	public static void main(String[] args) throws IOException {
		FileInputStream excel=new FileInputStream("C:\\Users\\HP\\Desktop\\Store.xlsx");
		Workbook w=new XSSFWorkbook(excel);
		Sheet sheet = w.getSheet("Sheet2");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(1);
		System.out.println(cell);
		String value="";
		if(cell.getCellType()==CellType.STRING) {
			value=cell.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(cell))
		{
		Date dd = cell.getDateCellValue();
		SimpleDateFormat dateFormat=new SimpleDateFormat("mm-dd-yyyy");
		value=dateFormat.format(dd);
		}
		else {
		double numericCellValue = cell.getNumericCellValue();

		
			
		}
		

		
		
		
	}

}
