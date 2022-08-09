package Excelfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Fetchdatafromexcel {

	public static void main(String[] args) throws IOException {
	
		
		String excelfilepath = "C:\\Users\\kartikpc\\eclipse-workspace\\SDETDataProvider\\src\\Datafiles\\registration.xlsx";
		FileInputStream inputstram = new FileInputStream(excelfilepath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputstram);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		
//		  for(int r=0;r<=rows ;r++)
//		  {
//			  XSSFRow row = sheet.getRow(r);
//					  
//					  for(int c=0;c<cols;c++)
//					  {
//						  XSSFCell cell = row.getCell(c);
//						  cell.getCellType();
//						  switch(cell.getCellType())
//						  {
//						  case STRING :System.out.print(cell.getStringCellValue());break;
//						  case NUMERIC:System.out.print(cell.getNumericCellValue());break;
//						  case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
//						  }
//						  System.out.print(" | ");
//					  }
//					  System.out.println();
//		  }
		
		   Iterator iterator = sheet.iterator();
		   while(iterator.hasNext())
		   {
			   
			   XSSFRow row = (XSSFRow) iterator.next();
			   Iterator CellIterator = row.cellIterator();
			   
			   while(CellIterator.hasNext())
			   {
				   XSSFCell cell = (XSSFCell) CellIterator.next();
				   switch(cell.getCellType())
					  {
					  case STRING :System.out.print(cell.getStringCellValue());break;
					  case NUMERIC:System.out.print(cell.getNumericCellValue());break;
					  case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
					  }
				   System.out.print("   ");
			   }
			   System.out.println();
			 }
		
		
		

	}

}
