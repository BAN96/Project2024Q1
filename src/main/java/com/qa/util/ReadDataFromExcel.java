package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
	
	@Test
	public void getData() throws FileNotFoundException, IOException {
		
		XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(".\\src\\test\\resources\\ExcelResources\\Data.xlsx"));
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		XSSFRow row=sheet.getRow(0);
		XSSFCell cell=row.getCell(0);
		
		String xlstr=cell.getStringCellValue();
		System.out.println(xlstr);
		
		String finalString=getMiddleUpperCaseRemovedString(xlstr);
		
		XSSFCell newcell=row.createCell(1);
		newcell.setCellValue(finalString);
		
		FileOutputStream out = new FileOutputStream(new File(".\\src\\test\\resources\\ExcelResources\\Data.xlsx")); 
	  
	        workbook.write(out); 
	        out.close(); 
		
	}
	
	public String getMiddleUpperCaseRemovedString(String str) {
		
		String finalStr="";
		finalStr=finalStr+str.charAt(0);
		for(int i=1;i<str.length()-1;i++) {
			if(!Character.isUpperCase(str.charAt(i))) {
				finalStr=finalStr+str.charAt(i);
			}
		}
		finalStr=finalStr+str.charAt(str.length()-1);
		return finalStr;
	}
	
	

}
