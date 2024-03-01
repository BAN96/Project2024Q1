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
	
	@Given("user logged in with credentials User {string} and Password {string}")
	public void user_logged_in_with_credentials_user_and_password(String user, String pass) {
		landingpage=loginpage.doLogin(user, pass);
	}

	@When("user clicks on category {string}")
	public void user_clicks_on_category(String category) {
		landingpage.clickOnCategory(category);
	}

	@Then("search for a product {string} with price {string}")
	public void search_for_a_product_with_price(String productName, String productPrice) {
	    boolean isProductAvalible=landingpage.searchProduct(productName);
	    String price="";
	    if(isProductAvalible) {
	    	price=landingpage.getProductPrice(productName);
	    }
	    else {
	    	price=landingpage.getProductPrice(productName);
	    }
	    
	    Assert.assertEquals(price, productPrice);
	    
	}
}
