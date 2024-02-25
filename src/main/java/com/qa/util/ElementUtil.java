package com.qa.util;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	public static void expectedCondition(WebDriver driver,ExpectedCondition ec) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ec);
		
	}
	
	public static void waitForTitle(WebDriver driver,String pageTitle) {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.titleContains(pageTitle));
		
	}
	
	public static void javaScriptExector(WebDriver driver,By element) {
		JavascriptExecutor jsexcutor=((JavascriptExecutor)driver);
		jsexcutor.executeScript("arguent", null);
	}
	
	public static String switchToAlertandGetText(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		String alertMessage=alert.getText();
		alert.accept();
		return alertMessage;
	}
	
	public static void waitfor(WebDriver driver,By byLocator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(Duration.ofSeconds(30))
			    .pollingEvery(Duration.ofSeconds(5))
			    .ignoring(Exception.class);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	
}
