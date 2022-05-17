package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assume;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.loginPage;
import pages.HomePage;
import pages.PersonalAccountPage;
import utilities.configReader;

public class homePageStep {
	
	private loginPage loginPage = new loginPage(DriverFactory.getDriver());
	private configReader configReader = new configReader();
	private HomePage HomePage = new HomePage(DriverFactory.getDriver()); 
	private Properties prop;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
	   prop = configReader.init_prop();
	   DriverFactory.getDriver().get(prop.getProperty("LoginPageURL"));
	   List<Map<String,String>> data = dataTable.asMaps();
	   String username = data.get(0).get("username");
	   String password = data.get(0).get("password");
	   HomePage = loginPage.doLogin(username, password);
	}
	
	@Given("User is on the Home Page")
	public void user_is_on_the_home_page() {			
		String actualTitle = HomePage.getTitle();
		System.out.println("Title of the HomePage is: "+actualTitle);		
	}
	
	@Then("User validates the header of the page")
	public void user_validates_the_header_of_the_page() {
	   HomePage.getHeader();
	}

	@When("Then user gets accounts section")
	public void then_user_gets_accounts_section(DataTable dataTable) {
	    List<String> expectdAccList = dataTable.asList();
	    System.out.println("Expected List is: "+expectdAccList);
	    List<String> actualAccList = HomePage.getAccountList();
	    System.out.println("Actual list is: "+actualAccList);
	    Assert.assertEquals(actualAccList, expectdAccList);
	}

	@When("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer count) {
	    Assume.assumeTrue(HomePage.getCount()==count);
	}

	@When("User clicks on personal information list item")
	public void user_clicks_on_list_item() {
		HomePage.clickPersonalInfo();
	}

	


}
