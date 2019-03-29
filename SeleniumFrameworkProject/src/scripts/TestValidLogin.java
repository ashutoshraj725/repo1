package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Library;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest
{
	@Test
	public void testLogin()
	{
	LoginPage lp = new LoginPage(driver);
	//enter username : admin
	String un = Library.getCellValue("ValidLogin", 1, 0);
	lp.setUsername(un);
	//enter password : manager
	lp.setPassword(Library.getCellValue("ValidLogin", 1, 1));
	//click on login button
	lp.clickLogin();
	String actHomePageTitle = driver.getTitle();
	/*if(actHomePageTitle.equals("actiTIME - Enter Time_Track")) 
	{
		System.out.println("Login successful");
	} 
	else {
		System.out.println("Login failed");	
	}*/
	Assert.assertEquals(actHomePageTitle,"actiTIME - Enter Time-Track123" );
	}
}
