package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.github.dockerjava.api.model.Driver;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.configReader;

public class AppHooks {
	
	Properties prop;
	private configReader configReader;
	private DriverFactory DriverFactory;
	private WebDriver driver;
	
	@Before(order=0)
	public void getProperty()
	{
		configReader = new configReader();
		prop = configReader.init_prop();		 
	}
	
	@Before(order=1)
	public void launchBrowser()
	{
		String browserName = prop.getProperty("browser");
		DriverFactory = new DriverFactory();
		driver = DriverFactory.init_driver(browserName);		
	}
	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String scenarioName = scenario.getName().replaceAll("", "_");
			byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", scenarioName);
		}
	}

}
