package com.crm.autodesk.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using apache POI libraries which used to handle microsoft excel sheet
 * @author mrinm
 *
 */
public class ExcelUtility {
	
	
	/**
	 * It is used to read the data from the excel base dom below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		String data=row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
		
	}
	
	
	
	
	
	/**
	 * Used to get the last used row number on specified sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	
	
	
	public void setDataExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos= new FileOutputStream("./src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();
	}

}
