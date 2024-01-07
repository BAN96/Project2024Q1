package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

public class Hooks {
	private Properties properties;
	private ConfigReader configreader;
	private DriverFactory driverfactory;
	WebDriver driver;
	
	@Before(order=0)
	public void getProperties() {
		configreader=new ConfigReader();
		properties=configreader.init_Properties();
	}
	
	@Before(order=1)
	public void launchBrowser() {
		driverfactory=new DriverFactory();
		driver=driverfactory.init_driver(properties.getProperty("browser"));
		
	}
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	@After(order=1)
	public void teardown(Scenario scenario) {
		if(scenario.isFailed()) {
			String imgName=scenario.getName().replaceAll(" ", "_");
			byte[] errorImg=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(errorImg, "image/png", imgName);
		}
	}

}
