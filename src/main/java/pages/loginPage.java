package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactory;

public class loginPage {

	private WebDriver driver;
	
	@FindBy(css="#email")
	private WebElement username;
	
	@FindBy(css="#passwd")
	private WebElement password;
	
	@FindBy(css="button[id='SubmitLogin']")
	private WebElement LoginBtn;
	
	public loginPage(WebDriver driver)
	{
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage doLogin(String userID, String passwd)
	{
		username.sendKeys(userID);
		password.sendKeys(passwd);
		LoginBtn.click();
		
		return new HomePage(driver);
	}
	
}
	

