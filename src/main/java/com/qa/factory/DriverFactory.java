package com.qa.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();

	public WebDriver init_driver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("edge")) {
			tlDriver.set(new EdgeDriver());
		}
		else {
			System.out.println("Selected browser should be Chrome,Firefox,Edge");
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		getDriver().manage().deleteAllCookies();
		return getDriver();
	}
	
	
	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}
}
