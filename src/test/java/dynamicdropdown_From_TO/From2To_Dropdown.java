package dynamicdropdown_From_TO;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class From2To_Dropdown {

	WebDriver driver;
	String URL = "https://www.spicejet.com/";

	@Test
	public void From_and_To() throws InterruptedException {

		WebElement FROM = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		FROM.click();
		Thread.sleep(5000);
		WebElement Bengaluru = driver.findElement(By.xpath("//a[@value='BLR']"));
		Bengaluru.click();
		System.out.println("You selected: " + Bengaluru.getAttribute("value"));
		Thread.sleep(3000);
		WebElement TO = driver.findElement(By.xpath("(//a[@value='MAA'])[2]"));
		TO.click();
		System.out.println("You selected: " + TO.getAttribute("value"));

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
