package StepDefinations;

import java.util.Properties;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	ConfigReader configreader;
	Properties prop;
	@Given("user opens the url")
	public void user_opens_the_url() {
		configreader=new ConfigReader();
		prop=configreader.init_Properties();
	    DriverFactory.getDriver().get(prop.getProperty("demoURL"));
	}

	@Given("click on My Account Dropmenu")
	public void click_on_My_Account_dropmenu() {
	    
	}

	@Given("click on Login option")
	public void click_on_Login_option() {
	    
	}

	@When("user enters Email {string}")
	public void user_enters_email(String string) {
	    
	}

	@When("user enters Password {string}")
	public void user_enters_password(String string) {
	    
	}

	@Then("user gets the validation message {string}")
	public void user_gets_the_validation_message(String string) {
	    
	}
}
