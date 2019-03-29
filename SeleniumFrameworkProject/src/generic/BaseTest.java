package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant
{
	public static WebDriver driver = null;
	static 
	{
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(IE_KEY, IE_PATH);
	}
	@BeforeMethod
	public void openApplication() 
	{
		//launch the browser
		driver = new FirefoxDriver();
		//enter the url
		String url = Library.getPropertyValue("URL");
		driver.get(url);
		//specify the implicit wait time period
		String ito = Library.getPropertyValue("IMPLICIT_TIMEOUT");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(ito), TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApplication(ITestResult res) 
	{
		if(ITestResult.FAILURE == res.getStatus()) {
			Library.captureScreenshot(driver, res.getName());
		}
		//close the browser
		driver.close();	
	}

}
