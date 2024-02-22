package StepDefinations;

import java.util.Properties;

import org.testng.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LandingPageSteps {

	ConfigReader configreader;
	Properties prop;
	LandingPage landingpage=new LandingPage(DriverFactory.getDriver());
	LoginPage loginpage;
	
	String explogoName;
	
	@Given("^user opens the url$")
	public void user_opens_the_url() {
		configreader=new ConfigReader();
		prop=configreader.init_Properties();
	    DriverFactory.getDriver().get(prop.getProperty("url"));
	}
	
	@Given("^click on Login option$")
	public void click_on_login_option() {
		loginpage=landingpage.clickLogin();
	}
	
	@When("^user get the page header$")
	public void user_get_the_page_header() {
		explogoName=landingpage.getLogoName();
	}

	@Then("Page Header should be {string}")
	public void page_header_should_be(String actualHeader) {
	    Assert.assertEquals(explogoName, actualHeader);
	}
}
