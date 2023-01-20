package com.onlinebanking.genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

public class ExcelUtility 
{
	/**
	 * This method is to get data from excel
	 * @param SheetName
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String SheetName,int rowno,int cellno) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath); 
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		String data = sh.getRow(rowno).getCell(cellno).getStringCellValue();
		return data;
	}
	/**
	 * This method is to get LastRow Number
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(SheetName);
		 int count = sh.getLastRowNum();
		 return count;
	}
	/**
	 * This method is to write data into excel
	 * @param SheetName
	 * @param rowno
	 * @param cellno
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String SheetName,int rowno,int cellno,String data) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowno);
		Cell cel = row.createCell(cellno);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fos);
	}
	/**
	 * This method is to get test datas from excel
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public ArrayList<String> getList(String sheetName) throws Throwable  
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		ArrayList<String> al = new ArrayList<String>();
		for(int i=0;i<=count;i++)
		{
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			al.add(value);
		}
		return al;
	}
	public ArrayList<String> getArrayExcel(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		ArrayList<String> al1 = new ArrayList<String>();
		for(int i=0;i<count;i++)
		{
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			al1.add(value);
		}
		return al1;
	}
	
	public Map<String, String> getList1(String sheetName, int keyCell, int valueCell) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		Map<String, String> map = new HashMap<String, String>();
		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value = sh.getRow(i).getCell
					(valueCell).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	public Object[][] getMultipleSetOfData(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastrow = sh.getLastRowNum()+1;
		int lastcell=sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
		
		
		
		
	}
	
	
	
	
	

