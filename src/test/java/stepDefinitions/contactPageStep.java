package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assume;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;
import pages.PersonalAccountPage;
import pages.contactPage;
import utilities.ExcelReader;
import utilities.commonMethods;
import utilities.configReader;

public class contactPageStep{
	
	private loginPage loginPage = new loginPage(DriverFactory.getDriver());
	private contactPage contactPage = new contactPage(DriverFactory.getDriver());
	private configReader configReader = new configReader();	
	private PersonalAccountPage PersonalAccountPage= new PersonalAccountPage(DriverFactory.getDriver());
	private commonMethods commonMethods = new commonMethods();
	private Properties prop;

	@Given("User navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		prop = configReader.init_prop();   
		DriverFactory.getDriver().get(prop.getProperty("contactPageURL"));   
	}

	@When("User fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		//ExcelReader reader = new ExcelReader();
		//List<Map<String,String>> data = reader.getData("Excel File\\DataDrivenSample.xlsx", sheetName);
//		String subHeading = data.get(rowNum).get("Subject Heading");
//		String emailAddress = data.get(rowNum).get("Email address");
//		String ordrRf = data.get(rowNum).get("Order reference");
//		String Mssg = data.get(rowNum).get("Message");
//		contactPage.fillDetails(subHeading, emailAddress, ordrRf, Mssg);
		
//		String socialTitle = data.get(rowNum).get("Social title");
//		String fName = data.get(rowNum).get("First name");
//		String lName = data.get(rowNum).get("Last name");
//		String email = data.get(rowNum).get("E-mail address");
//		PersonalAccountPage.fill_Details_Of_AccountHolder(socialTitle, fName, lName, email);
//      
		if(sheetName == "Inputs")
		{
			commonMethods.fillContactPageDetails(sheetName, rowNum);
		}
		else{
		commonMethods.fillAccountHolderDetails(sheetName, rowNum);
		}
		
	}

	@When("User clicks on send button")
	public void user_clicks_on_send_button() {
	    contactPage.clickSendBtn();
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expectdTxt) {
	   Assert.assertEquals(contactPage.final_messg(), expectdTxt);
	}
}
