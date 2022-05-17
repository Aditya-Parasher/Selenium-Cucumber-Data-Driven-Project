package utilities;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import pages.contactPage;
import pages.PersonalAccountPage;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import driverFactory.DriverFactory;

public class commonMethods {
	
	private contactPage contactPage = new contactPage(DriverFactory.getDriver());
	private PersonalAccountPage PersonalAccountPage = new PersonalAccountPage(DriverFactory.getDriver());
	
	ExcelReader reader = new ExcelReader();
	
	public contactPage fillContactPageDetails(String sheetName, int rowNum) throws InvalidFormatException, IOException {
		List<Map<String,String>> data = reader.getData("Excel File\\DataDrivenSample.xlsx", sheetName);
		String subHeading = data.get(rowNum).get("Subject Heading");
		String emailAddress = data.get(rowNum).get("Email address");
		String ordrRf = data.get(rowNum).get("Order reference");
		String Mssg = data.get(rowNum).get("Message");
		contactPage.fillDetails(subHeading, emailAddress, ordrRf, Mssg);
		return contactPage;
	}
	
	public PersonalAccountPage fillAccountHolderDetails(String sheetName, int rowNum) throws InvalidFormatException, IOException
	{
		List<Map<String,String>> data = reader.getData("Excel File\\DataDrivenSample.xlsx", sheetName);
		String socialTitle = data.get(rowNum).get("Social title");
		String fName = data.get(rowNum).get("First name");
		String lName = data.get(rowNum).get("Last name");
		String email = data.get(rowNum).get("E-mail address");
		PersonalAccountPage.fill_Details_Of_AccountHolder(socialTitle, fName, lName, email);
		return PersonalAccountPage;
	}
	
	
	
}
