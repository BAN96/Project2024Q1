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

public class LoginPageSteps {
	String expectedValue;
	LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	LandingPage landingPage;
	
	
	@Then("user gets the page title and page Title should be {string}")
	public void user_gets_the_page_title_and_page_title_should_be(String actualValue) {
		expectedValue=loginpage.getpopupHeader();
		Assert.assertEquals(expectedValue, actualValue);
	}
	@When("user enters username {string}")
	public void user_enters_username(String user) {
	    loginpage.enterUserName(user);
	}
	@When("user enters Password {string}")
	public void user_enters_password(String pass) {
	    loginpage.enterPassword(pass);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    loginpage.clickOnLoginButton();
	}

	@Then("user goto Homepage and WelcomeMsg should be {string}")
	public void user_goto_homepage_and_welcome_msg_should_be(String actualValue) {
		landingPage=loginpage.userNavigateToHomePage();
		expectedValue=landingPage.getwelcomeMsg();
		Assert.assertEquals(expectedValue, actualValue);
	}

	@Then("Alert will show with message {string}")
	public void alert_will_show_with_message(String actualValue) {
		expectedValue=loginpage.getValidationMsgOnFailure();
		Assert.assertEquals(expectedValue, actualValue);
	}
}
