package dynamic_calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class calenderhandling {

	WebDriver driver;
	String URL = "https://www.path2usa.com/travel-companions";

	@Test
	public void Calender() throws InterruptedException {
		
		Thread.sleep(3000);
		//April 23
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();

		Thread.sleep(3000);
// This will check the April month from calender then click.
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April"))
		{
			// This line code is about next button click.
			
			Thread.sleep(3000);
			
		driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}


		Thread.sleep(3000);
		
		// This code is about day selection
		List<WebElement> dates= driver.findElements(By.className("day"));
		//Grab common attribute//Put into list and iterate
		int count=driver.findElements(By.className("day")).size();

		Thread.sleep(3000);
		for(int i=0;i<count;i++)
		{
		String text=driver.findElements(By.className("day")).get(i).getText();
		if(text.equalsIgnoreCase("23"))
		{
			Thread.sleep(3000);
		driver.findElements(By.className("day")).get(i).click();
		break;
		}

		}
	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Flight_Site_Automation\\Resouces\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {

	}
}
