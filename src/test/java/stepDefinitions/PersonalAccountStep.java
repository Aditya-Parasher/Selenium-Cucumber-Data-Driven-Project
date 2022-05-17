package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.loginPage;
import pages.HomePage;
import utilities.ExcelReader;
import utilities.configReader;
import pages.PersonalAccountPage;

public class PersonalAccountStep {
	
	private loginPage loginPage = new loginPage(DriverFactory.getDriver());
	private configReader configReader = new configReader();
	private Properties prop;
	private HomePage HomePage = new HomePage(DriverFactory.getDriver());
	private PersonalAccountPage PersonalAccountPage = new PersonalAccountPage(DriverFactory.getDriver());	
	
	@SuppressWarnings("deprecation")
	@Then("user is on the HomePage and validates the title of the page as {string}")
	public void user_is_on_the_home_page_and_validates_the_title_of_the_page_as(String expectedTitle) {
		String actualTitle = HomePage.getTitle();
		System.out.println("Title of the Page is: "+actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Given("User navigates to Personal Account Information page")
	public void user_navigates_to_personal_account_information_page() {		
		PersonalAccountPage = HomePage.clickPersonalInfo(); 
	}
	

}
