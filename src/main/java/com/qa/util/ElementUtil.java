package com.qa.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	public static void expectedCondition(WebDriver driver,ExpectedCondition ec) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ec);
		
	}
	
	public static void waitForTitle(WebDriver driver,String pageTitle) {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.titleContains(pageTitle));
		
	}
	
	public static void javaScriptExector(WebDriver driver,By element) {
		JavascriptExecutor jsexcutor=((JavascriptExecutor)driver);
		jsexcutor.executeScript("arguent", null);
	}
}
