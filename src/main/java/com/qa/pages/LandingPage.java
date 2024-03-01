package com.qa.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.ElementUtil;

public class LandingPage {
	WebDriver driver;
	
	private By loginLink=By.id("login2");
	private By signupLink=By.id("signin2");
	private By cartLink=By.id("cartur");
	private By logoutLink=By.id("logout2");
	private By welcomeTitle=By.id("nameofuser");
	private By abouUsLink=By.xpath("//a[text()='About us']");
	private By contactLink=By.xpath("//a[text()='Contact']");
	private By HomeLink=By.xpath("//a[contains(text(),'Home')]");
	private By logo=By.xpath("//a[@id='nava']/img");
	private By logoName=By.xpath("//a[@id='nava']");
	
	private By nextBtn=By.id("next2");
	private By prevBtn=By.id("prev2");
	private By productTitle=By.xpath("//div[@id='tbodyid']//h4[@class='card-title']/a");
	private By productPrice=By.xpath("//div[@id='tbodyid']//div[@class='card-block']/h5");
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage clickLogin() {
		//new WebDriverWait(driver, Duration.ofSeconds(30)).until();
		ElementUtil.expectedCondition(driver, ExpectedConditions.elementToBeClickable(loginLink));
		driver.findElement(loginLink).click();
		return new LoginPage(driver);
	}
	
	public void clickSignup() {
		driver.findElement(signupLink).click();
	}
	public void clickOnCart() {
		driver.findElement(cartLink).click();
		
	}
	public void clickonAboutUS() {
		driver.findElement(abouUsLink).click();
		
	}
	public void clickOnContact() {
		driver.findElement(contactLink).click();
		
	}
	public void clickonHome() {
		driver.findElement(HomeLink).click();
	}
	
	public void getLogo() {
		File actualImg=driver.findElement(logo).getScreenshotAs(OutputType.FILE);
		try {
			org.openqa.selenium.io.FileHandler.copy(actualImg, new File(".\\src\\main\\java\\com\\qa\\images\\"+getLogoName().trim().replaceAll(" ", "_")+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getLogoName() {
		return driver.findElement(logoName).getText().trim();
	}
	public String getwelcomeMsg() {
		ElementUtil.waitfor(driver, welcomeTitle);
		//ElementUtil.expectedCondition(driver,ExpectedConditions.visibilityOf(driver.findElement(welcomeTitle)));
		return driver.findElement(welcomeTitle).getText().trim();
	}
	
	public void clickOnCategory(String category) {
		ElementUtil.waitfor(driver, By.xpath("//a[@id='cat']/following-sibling::a[contains(text(),'"+category+"')]"));
		driver.findElement(By.xpath("//a[@id='cat']/following-sibling::a[contains(text(),'"+category+"')]")).click();
	}
	
	public boolean searchProduct(String productname) {
		boolean isProductAValible=false;
		List<WebElement> products=driver.findElements(productTitle);
		for(WebElement product:products) {
			//ElementUtil.waitfor(driver, product);
			if(product.getText().trim().equalsIgnoreCase(productname)) {
				System.out.println(product.getText());
				isProductAValible=true;
				break;
			}
		}
		if(!isProductAValible) {
			driver.findElement(nextBtn).click();
			searchProduct(productname);
		}
		return isProductAValible;
	}
	public String getProductPrice(String productname) {
		ElementUtil.waitfor(driver, By.xpath("//a[text()='"+productname+"']/parent::h4/following-sibling::h5"));
		return driver.findElement(By.xpath("//a[text()='"+productname+"']/parent::h4/following-sibling::h5")).getText();
	}

}
