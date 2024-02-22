package SeleniumPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Scenario2 {

	@Test
	public void secondScenario() {
		String searchingProduct="MacBook";
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@aria-label='Search for anything']")).sendKeys(searchingProduct);
		WebElement searchCategoryDropdown=driver.findElement(By.id("gh-cat"));
		
		Select select=new Select(searchCategoryDropdown);
		select.selectByVisibleText("Computers/Tablets & Networking");
		driver.findElement(By.id("gh-btn")).click();
		String pageTitle=driver.getTitle().trim();
		Assert.assertEquals(pageTitle, "MacBook in Computers/Tablets & Networking for sale | eBay");
		WebElement firstElement=new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(@id,'item')][1]//div[@class='s-item__title']/span[@role='heading']"))));
		//=driver.findElement(By.xpath("//li[contains(@id,'item')][1]//div[@class='s-item__title']/span[@role='heading']"));
		String firstelemntTitle=firstElement.getText();
		System.out.println(firstelemntTitle);
		if(firstelemntTitle.contains(searchingProduct)) {
			System.out.println("testcase pass");
		}
		else {
			System.out.println("testcase fail");
		}
	}

}
