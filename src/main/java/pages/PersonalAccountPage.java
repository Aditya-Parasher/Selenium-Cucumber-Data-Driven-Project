package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactory;

public class PersonalAccountPage {
	
	private WebDriver driver;
	
	@FindBy(css="#firstname")
	private WebElement firstName;
	
	@FindBy(css="#lastname")
	private WebElement lastName;
	
	@FindBy(css="#email")
	private WebElement email;
	
	public PersonalAccountPage(WebDriver driver)
	{
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void fill_Details_Of_AccountHolder(String title, String fName, String lName, String emailAdd)
	{
		driver.findElement(By.xpath("//label[normalize-space()= '"+title+"']")).click();
		
		firstName.click();
		firstName.clear();
		firstName.sendKeys(fName);
		
		lastName.click();
		lastName.clear();
		lastName.sendKeys(lName);
		
		email.click();
		email.clear();
		email.sendKeys(emailAdd);
	}
}
