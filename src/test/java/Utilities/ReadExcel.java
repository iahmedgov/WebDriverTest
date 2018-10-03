package Utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {

	public static void main(String[] args) throws IOException{
        
FileInputStream fis = new FileInputStream("C:\\Users\\iahmed\\Documents\\Test.xlsx");
XSSFWorkbook workbook = new XSSFWorkbook(fis);
XSSFSheet sheet = workbook.getSheetAt(0);
        
        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
int x = 0;
//for (x = 0; x<=4;x++) {
//System.out.println(sheet.getLastRowNum());
int numOfRows = sheet.getLastRowNum();
System.out.println("Number of Rows: "+ ++numOfRows);

for (x = 0; x<numOfRows;++x) {
Row row = sheet.getRow(x);

	   Cell cell = row.getCell(0);
       //System.out.println(cell);
       String name = cell.toString();
       System.out.println("Name: "+name);
       
       cell = row.getCell(1);
       String stAddress = cell.toString();
       System.out.println("Street Address: "+stAddress);
       
       cell = row.getCell(2);
       String city = cell.toString();
       System.out.println("City: "+city);
       
       cell = row.getCell(3);
       String state = cell.toString();
       System.out.println("State: "+state);
       
       cell = row.getCell(4);
       if (cell != null) {
    	   String zip = cell.toString();
       System.out.println("ZIP: "+zip.toString().replaceAll("\\.0*$", ""));}
       else
       { System.out.println("ZIP is missing, Don't populate it ");}
       
}
//}
//System.out.println(sheet.getRow(0).getCell(0));
//String cellval = cell.getStringCellValue();
//System.out.println(cellval);
workbook.close();
} 
}
