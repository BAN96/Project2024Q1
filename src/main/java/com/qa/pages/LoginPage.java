package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By username=By.id("input-email");
	By password=By.id("input-password");
	By forgetpassword=By.xpath("//input[@id='input-password']//following-sibling::a[text()='Forgotten Password']");
	By loginBtn=By.xpath("button[type='submit']");
	By validationMsg=By.xpath("//div[@class='alert alert-danger alert-dismissible']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void enterUserName(String user) {
		driver.findElement(username).sendKeys(user);
	}
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	public void clickOnLoginButton() {
		driver.findElement(loginBtn).click();
	}
	public void clickOnforgetPasswordLink() {
		driver.findElement(forgetpassword).click();
	}
	
	public void doLogin(String user,String pass) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
	}
	
	public String getValidationMsgOnFailure() {
		return driver.findElement(validationMsg).getText();
	}
	
}
