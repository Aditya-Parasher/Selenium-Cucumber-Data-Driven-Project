package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import driverFactory.DriverFactory;

public class contactPage {
	
	private WebDriver driver;
	
	@FindBy(css="#id_contact")
	private WebElement dropDwn;
	
	@FindBy(css="#email")
	private WebElement emailAddress;
	
	@FindBy(css="#id_order")
	private WebElement order;

	@FindBy(css="#message")
	private WebElement msgBox;
	
	@FindBy(css="#submitMessage")
	private WebElement sendBtn;
	
	@FindBy(css=".alert-success")
	private WebElement finalMsg;
	
	public contactPage(WebDriver driver)
	{
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver,this);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void fillDetails(String heading, String email, String ordrRef, String msg)
	{
		Select select = new Select(dropDwn);
		select.selectByVisibleText(heading);
		
		emailAddress.sendKeys(email);
		order.sendKeys(ordrRef);
		msgBox.sendKeys(msg);
	}
	
	public void clickSendBtn()
	{
		sendBtn.click();
	}
	
	public String final_messg()
	{
		return finalMsg.getText();
	}

}
