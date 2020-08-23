package com.FreeCRM.qa.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.FreeCRM.qa.Baseclass.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String TestDataSheetPath="D:\\Mavan\\FreeCRMAutomation\\src\\main\\java\\com"
			+"\\FreeCRM\\qa\\TestData\\TestData.xlsx";
	static Workbook book;
	static XSSFSheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");

	}
	public static Object[][] getTestData(String sheetName){
		FileInputStream fins=null;
		try {
			fins=new FileInputStream(TestDataSheetPath);
			 book=WorkbookFactory.create(fins);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=(XSSFSheet) book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}}
		return data;
				
			}
	 public static void takeScreenShotAtEndOfTest() throws IOException {
		 File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String currentDir=System.getProperty("user.dir");
		 FileHandler.copy(srcfile,new File(currentDir+"/screenshot/"+System.currentTimeMillis()+".png"));
	 }
		}
		
	


