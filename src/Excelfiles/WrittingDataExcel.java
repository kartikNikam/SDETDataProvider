package Excelfiles;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WrittingDataExcel {

	
	//workbook --> sheet --> rows --> cols
	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();  // workbook
		
		XSSFSheet sheet = workbook.createSheet("Empinfo"); // sheet
		
		ArrayList<Object[]> empdata = new ArrayList<Object[]>(); // using Arraylist
		empdata.add(new Object[] {"EMPID","Name","Job"});
		empdata.add(new Object[] {101,"abc","Eng"});
		empdata.add(new Object[]  {102,"xyz","manager"});
		empdata.add(new Object[]  {103,"pqr","Analyst"});
		
		
//		
//		Object empdata[][]= {  {"EMPID","Name","Job"},
//				               {101,"abc","Eng"},
//				               {102,"xyz","manager"},
//				               {103,"pqr","Analyst"}
//		                 	};
		
		  //using normal for loop
		
	/*	int rows = empdata.length;
		int cols = empdata[0].length;
		System.out.println(rows);  
		
		System.out.println(cols);
		
		
		    for(int r=0 ; r<rows ; r++)
		    {
		    XSSFRow	row=sheet.createRow(r);
		    
		    	for(int c=0; c<cols; c++)
		    	{
		    		XSSFCell cell=row.createCell(c);
		    		Object value = empdata[r][c];
		    		
		    		if(value instanceof String)
		    			cell.setCellValue((String)value);
		    		if(value instanceof Integer)
		    			cell.setCellValue((Integer)value);
		    		if(value instanceof Boolean)
		    			cell.setCellValue((Boolean)value);
		    				    				    				    		
		    	}
		    }*/
		
		
		
		//using foreach loop
//		int rowCount=0;
//		for(Object emp[]:empdata)
//		{
//		XSSFRow	row = sheet.createRow(rowCount++);  //one row is created
//		 int ColCount=0;
//			
//			for(Object value:emp)
//			{
//				XSSFCell cell= row.createCell(ColCount++);
//
//	    		if(value instanceof String)
//	    			cell.setCellValue((String)value);
//	    		if(value instanceof Integer)
//	    			cell.setCellValue((Integer)value);
//	    		if(value instanceof Boolean)
//	    			cell.setCellValue((Boolean)value);
//				
//			}
//		}
		
		int rownum=0;
		
		for(Object[] emp : empdata)
		{
		XSSFRow	row =sheet.createRow(rownum++);
		  int cellnum=0;
			for(Object value:emp)
			{
				XSSFCell cell= row.createCell(cellnum++);
				
					    		if(value instanceof String)
					    			cell.setCellValue((String)value);
					    		if(value instanceof Integer)
					    			cell.setCellValue((Integer)value);
					    		if(value instanceof Boolean)
					    			cell.setCellValue((Boolean)value);
			}
		}
		 	
		 String filepath = "C:\\Users\\kartikpc\\eclipse-workspace\\SDETDataProvider\\src\\Datafiles\\employee1.xlsx";
		 FileOutputStream outstream = new  FileOutputStream(filepath);
		 workbook.write(outstream);
		 outstream.close();
		 System.out.println("file wriiten succesfully1");
		
	}

}
  