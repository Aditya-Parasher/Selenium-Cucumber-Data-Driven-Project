package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.loginPage;
import utilities.configReader;

public class loginPageStep {
	
	private Properties prop;
	
	loginPage loginPage = new loginPage(DriverFactory.getDriver());
	configReader configReader = new configReader();
	private static String title;
	private WebDriver driver;
	
	@Given("User is on the Login Page")
	public void user_is_on_the_login_page() {
		prop = configReader.init_prop();
		DriverFactory.getDriver().get(prop.getProperty("LoginPageURL"));
	    
	}

	@Then("User checks the title of the page")
	public void user_checks_the_title_of_the_page() {
		prop = configReader.init_prop();
		title = loginPage.getTitle();
		Assert.assertEquals(title, prop.getProperty("LoginPageTitle"));
	}

	@When("User enters the <username> and <password>")
	public HomePage user_enters_the_username_and_password(DataTable dataTable) {
	     List<Map<String,String>> data = dataTable.asMaps();
	     String username = data.get(0).get("username");
	     String password = data.get(0).get("password");
	     loginPage.doLogin(username, password);	  
	     return new HomePage(driver);
	}



}
