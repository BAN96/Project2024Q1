package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.util.ElementUtil;

public class AdminLoginPage {

	WebDriver driver;
	//By Locators
	private By user=By.id("input-username");
	private By pass=By.id("input-password");
	private By loginBtn=By.xpath("//form[@id='form-login']//button[@type='submit']");
	private By forgetPassword=By.xpath("//a[contains(text(),'Forgotten Password')]");
	private By validationMsg=By.xpath("//body/div[@id='container']/div[@id='alert']/div[1]");
	
	public AdminLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterUserName(String username) {
		driver.findElement(user).clear();
		driver.findElement(user).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(pass).clear();
		driver.findElement(pass).sendKeys(password);
	}
	public void clickOnSubmit() {
		driver.findElement(loginBtn).click();
		//return new AdminDashboardPage(driver);
	}
	
	public void clickOnForgetPasswordLink() {
		driver.findElement(forgetPassword).click();
		//return new AdminForgetPasswordPage(driver);
	}
	
	public void login(String username,String password) {
		driver.findElement(user).clear();
		driver.findElement(user).sendKeys(username);
		driver.findElement(pass).clear();
		driver.findElement(pass).sendKeys(password);
		driver.findElement(loginBtn).click();
		
	}
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getValidationMsg() {
		return driver.findElement(validationMsg).getText();
	}
	
}
