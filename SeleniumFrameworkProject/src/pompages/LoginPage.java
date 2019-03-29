package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//Declare WebElement
	@FindBy(name = "username")
	WebElement unTB;
	
	@FindBy(name = "pwd")
	WebElement pwdTB;
	
	@FindBy(id = "loginButton")
	WebElement loginBtn;
	
	//Initialize WebElement
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilize WebElement
	public void setUsername(String un)
	{
		unTB.clear();
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pwd)
	{
		pwdTB.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginBtn.click();
	}
	

}
