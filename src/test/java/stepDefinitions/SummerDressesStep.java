package stepDefinitions;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import de.erichseifert.vectorgraphics2d.Document;
import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage;
import utilities.commonMethods;
import utilities.configReader;
import pages.SummerDressesPage;

public class SummerDressesStep {

	private HomePage HomePage = new HomePage(DriverFactory.getDriver());
	private configReader configReader = new configReader();
	private Properties prop;
	private SummerDressesPage SummerDressesPage = new SummerDressesPage(DriverFactory.getDriver());
	private Actions action = new Actions(DriverFactory.getDriver());
	private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);

	@Then("User navigates to homepage having message as {string}")
	public void user_navigates_to_homepage_having_message_as(String expectedMsg) {
		String actualMsg = HomePage.getWelcomeMessage();
		System.out.println("Welcome message is: " + actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@Then("User must validate the title as {string}")
	public void user_must_validate_the_title_as(String expectedTitle) {
		String actualTitle = HomePage.getTitle();
		System.out.println("Title of the Homepgae is : " + actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Given("User hower to the Women option")
	public void user_hower_to_the_women_option() {
		action.moveToElement(DriverFactory.getDriver().findElement(By.xpath("//li/a[@title='Women']"))).build()
				.perform();
	}

	@When("User clicks on the Summer Dresses")
	public void user_clicks_on_the_summer_dresses() {
		SummerDressesPage.clickSummerDresses();
	}

	@And("User sees the title of the page as {string}")
	public void user_sees_the_title_of_the_page_as(String expctdTitle) {
		String actTitle = SummerDressesPage.getTitle();
		System.out.println("Title of the summer dresses page is: " + actTitle);
		Assert.assertEquals(expctdTitle, actTitle);
	}

	@And("User clicks on Add to cart button")
	public void user_clicks_on_add_to_cart_button() {
		List<WebElement> list = DriverFactory.getDriver()
				.findElements(By.cssSelector(".left-block .product-image-container"));
		JavascriptExecutor js = (JavascriptExecutor)DriverFactory.getDriver();
		for(WebElement e: list)
		{
			js.executeScript("arguments[0].scrollIntoView(true);", e);
			action.moveToElement(e).build().perform();
			js.executeScript("arguments[0].click();",e.findElement(By.xpath("//a[@title='Add to cart']")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));
			DriverFactory.getDriver().findElement(By.xpath("//span[@title='Close window']")).click();	
			
		}
	}

	@When("User clicks on proceed to checkout button")
	public void user_clicks_on_proceed_to_checkout_button() {
		SummerDressesPage.clickCheckOutBtnTxt();
	}
	

}
