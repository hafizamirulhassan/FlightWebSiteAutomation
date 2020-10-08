package StaticDropdown_Currency;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Staticdropdown {
	WebDriver driver;
	String URL="https://www.spicejet.com/";

	@Test
	public void currencydropdown() {

		
		WebElement currency=(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		Select select=new Select(currency);
		select.selectByIndex(2); // this should be selected AED
	}
	@BeforeMethod
	public void beforeMethod() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Flight_Site_Automation\\Resouces\\chromedriver.exe");	
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
