package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Library;
import pompages.LoginPage;

public class TestInValidLogin extends BaseTest
{
	@Test
	public void testInvalidLogin() 
	{
		LoginPage lp = new LoginPage(driver);
		for(int i = 1; i <= Library.getRowCount("InvalidLogin"); i++) 
		{
			String username = Library.getCellValue("InvalidLogin", i, 0);
			lp.setUsername(username);
			String password =Library.getCellValue("InvalidLogin", i, 1);
			lp.setPassword(password);
			lp.clickLogin();
		}	
	}
}
