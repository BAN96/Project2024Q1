package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPage {
	WebDriver driver;
	
	//By locators
	By dashboardPopupTitle=By.xpath("//h5[@class='modal-title text-danger']");
	By dashboardPopupClose=By.xpath("//button[@class='btn-close']");
	
	
	public AdminDashboardPage(WebDriver driver) {
		this.driver=driver;
	}
}
