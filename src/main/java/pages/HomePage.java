package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactory;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(css = ".info-account")
	private WebElement welcomeMessage;
	
	@FindBy(css="#center_column div ul li")
	private List<WebElement> accountList;
	
	@FindBy(xpath="//span[text()='My personal information']")
	private WebElement personalInfo;
	
	@FindBy(css=".info-account")
	private WebElement headr;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public List<String> getAccountList()
	{
		List<String> new_list = new ArrayList<>();
		for(WebElement list: accountList)
		{			 
			 new_list.add(list.getText());
		}
		
		return new_list;
	}
	
	public String getWelcomeMessage()
	{
		return welcomeMessage.getText();
	}
	
	public String getHeader()
	{
		return headr.getText();
	}
	
	public int getCount()
	{
		return accountList.size();
	}
	
	public PersonalAccountPage clickPersonalInfo()
	{
		personalInfo.click();
		return new PersonalAccountPage(driver);
	}

}
