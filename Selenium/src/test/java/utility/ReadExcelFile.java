package utility;

import java.io.*;

import org.apache.poi.xssf.usermodel.*;

public class ReadExcelFile {
	
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static String getCellValue(String filepath,String sheetname,int rownumber,int cellnumber)
	{
		try 
		{
			fis=new FileInputStream(filepath);
			workbook=new XSSFWorkbook(fis);
			String cellvalue=workbook.getSheet(sheetname).getRow(rownumber).getCell(cellnumber).getStringCellValue();
			
			workbook.close();
			
			return cellvalue;
			
		}
		catch (Exception e) 
		{
			return "";
		}
	}
	
	public static int getRowCount(String filepath,String sheetname)
	{
		try 
		{
			fis=new FileInputStream(filepath);
			workbook=new XSSFWorkbook(fis);
			
			int rowcount=workbook.getSheet(sheetname).getLastRowNum()+1;
			
			return rowcount;
		} 
		catch (Exception e) 
		{
			return 0;
		}
		
	}
	
	public static int getColumnCount(String filepath,String sheetname)
	{
		try 
		{
			fis=new FileInputStream(filepath);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetname);
			
			int columncount=sheet.getRow(0).getLastCellNum();
			
			workbook.close();
			
			return columncount;
		} 
		catch (Exception e) 
		{
			return 0;
		}
	}
	
	public static String getStringData(int sheetindex,int rownumber,int columnnumber)
	{
		return workbook.getSheetAt(sheetindex).getRow(rownumber).getCell(columnnumber).getStringCellValue();
	}
	
	public static String getStringData(String sheetname,int rownumber,int columnnumber)
	{
		return workbook.getSheet(sheetname).getRow(rownumber).getCell(columnnumber).getStringCellValue();
	}
	
	public static double getNumericData(String sheetname,int rownumber,int columnnumber)
	{
		return workbook.getSheet(sheetname).getRow(rownumber).getCell(columnnumber).getNumericCellValue();
	}
}
