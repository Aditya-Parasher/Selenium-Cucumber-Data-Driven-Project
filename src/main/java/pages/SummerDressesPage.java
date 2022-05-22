package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driverFactory.DriverFactory;

public class SummerDressesPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="(//li/a[@title = 'Summer Dresses'])[1]")
	private WebElement summerDress;	

	@FindBy(css = "[title='Proceed to checkout']")
	private WebElement chckOutBtn;
	
	@FindBy(css = "[title='Close window']")
	private WebElement closeWindw;
	
	
	public SummerDressesPage(WebDriver driver)
	{
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void clickSummerDresses()
	{
		summerDress.click();		
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void clickCheckOutBtnTxt()
	{
		chckOutBtn.click();
	}
	
	public void closWindw()
	{
		closeWindw.click();
	}

}
