package generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Library implements IAutoConstant 
{
	public static Workbook wb;
	public static String getCellValue(String sheetName, int rowNum, int colNum) 
	{
		String cellValue = "";
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			cellValue = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();
		} catch (Exception e) {
		}
		return cellValue;
	}
	public static int getRowCount(String sheetName) 
	{
		int rowCount = 0;
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			rowCount = wb.getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {
		}
		return rowCount;
	}
	public static String getPropertyValue(String propertyName) 
	{
		String propertyValue = "";
		Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(CONFIG_PATH));
			} catch (Exception e) {
			}
		propertyValue = prop.getProperty(propertyName);
		return propertyValue;
	}
	public static void captureScreenshot(WebDriver driver, String testMethodName) 
	{
		try {
		String currentDateAndTime = new Date().toString().replaceAll(":","_");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		System.out.println(srcfile);
		File destfile = new File(SCREENSHOT_PATH + testMethodName + currentDateAndTime + ".png");		
		Files.copy(srcfile, destfile);
		} catch (Exception e) {
		}
	}
}
