package StepDefinations;

import java.util.Properties;

import org.testng.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.AdminLoginPage;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AdminLoginPageSteps {
	AdminLoginPage adminlogin=new AdminLoginPage(DriverFactory.getDriver());
	ConfigReader configreader;
	
	String title;

	@Given("user opens the admin url")
	public void user_opens_the_admin_url() {
		configreader=new ConfigReader();
		Properties  prop=configreader.init_Properties();
	    DriverFactory.getDriver().get(prop.getProperty("adminUrl"));
	}
	
	@Then("user gets the page title and page Title should be {string}")
	public void user_gets_the_page_title_and_page_title_should_be(String pageTitle) {
		ElementUtil.waitForTitle(DriverFactory.getDriver(),pageTitle);
		title=adminlogin.getTitle();
		Assert.assertEquals(pageTitle, title);
		
	}

	@When("user enters the username {string} password {string}")
	public void user_enters_the_username_password(String user, String pass) {
	    adminlogin.enterUserName(user);
	    adminlogin.enterPassword(pass);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    adminlogin.clickOnSubmit();
	}

	@When("user clicks on Forgetten password")
	public void user_clicks_on_forgetten_password() {
	    adminlogin.clickOnForgetPasswordLink();
	}
}
