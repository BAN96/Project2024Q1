package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.util.ElementUtil;

public class LoginPage {
	WebDriver driver;
	
	private By username=By.id("loginusername");
	private By password=By.id("loginpassword");
	private By popupTitle=By.id("logInModalLabel");
	private By closeBtn=By.xpath("//button[text()='Log in']/preceding-sibling::button");
	private By loginBtn=By.xpath("//button[text()='Log in']");
	private By crossIconBtn=By.xpath("//h5[@id='logInModalLabel']/following-sibling::button[@aria-label='Close']/span");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getpopupHeader() {
		//ElementUtil.expectedCondition(driver, ExpectedConditions.visibilityOf(driver.findElement(popupTitle)));
		ElementUtil.waitfor(driver, popupTitle);
		return driver.findElement(popupTitle).getText().trim();
	}
	
	public void enterUserName(String user) {
		ElementUtil.waitfor(driver, username);
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(user);
	}
	public void enterPassword(String pass) {
		ElementUtil.waitfor(driver, password);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
		//ElementUtil.expectedCondition(driver, ExpectedConditions.visibilityOf(driver.findElement(loginBtn)));
	}
	public void clickOnLoginButton() {
		ElementUtil.waitfor(driver, loginBtn);
		driver.findElement(loginBtn).click();
	}
	public void clickOnCloseBtn() {
		driver.findElement(closeBtn).click();
	}
	
	public void doLogin(String user,String pass) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
	}
	
	public LandingPage userNavigateToHomePage() {
		return new LandingPage(driver);
	}
	
	public String getValidationMsgOnFailure() {
		ElementUtil.expectedCondition(driver, ExpectedConditions.alertIsPresent());
		return ElementUtil.switchToAlertandGetText(driver);
		
	}
	
}
