package Excelfiles;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Hashmaptoexcel {

	public static void main(String[] args) throws IOException {
		
	     XSSFWorkbook workbook = new  XSSFWorkbook();
	     
	 XSSFSheet sheet = workbook.createSheet("Student Data");
	 
	 Map<String,String> data = new HashMap<String,String>();
	 data.put("101", "amit");
	 data.put("102", "pravin");
	 data.put("103", "Suresh");
	 data.put("104", "prakash");
	 data.put("105", "Rakesh");
	 data.put("106", "jai");
	 
	 int rowno = 0;
	 
	 for(Map.Entry entry:data.entrySet())
	 {
		XSSFRow row = sheet.createRow(rowno++); 
	row.createCell(0).setCellValue((String)entry.getKey());
	row.createCell(1).setCellValue((String)entry.getValue());
		 
	 }
	 
	 String filepath = "C:\\Users\\kartikpc\\eclipse-workspace\\SDETDataProvider\\src\\Datafiles\\employee2.xlsx";
	 FileOutputStream outstream = new  FileOutputStream(filepath);
	 workbook.write(outstream);
	 outstream.close();
	 System.out.println("file wriiten succesfully1");
		
		
		
		
		
		
		
		
		
		
	}

}

