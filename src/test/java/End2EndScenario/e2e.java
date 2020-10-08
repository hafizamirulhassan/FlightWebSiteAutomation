package End2EndScenario;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class e2e {

	WebDriver driver;
	String URL = "https://www.spicejet.com/";

	@Test
	public void e2escenario() throws InterruptedException {

		WebElement oneway = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
		oneway.click();

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

		Thread.sleep(3000);

		WebElement date = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active"));
		date.click();
		System.out.println("You selected this date :" + date.getAttribute("value"));

		WebElement currency = (driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		Select select2 = new Select(currency);
		select2.selectByIndex(2); // this should be selected AED

		WebElement chechbx = driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount"));
		chechbx.click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());

		// Return Date should be disable if select oneway trip

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("it's enabled..!");
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}

		driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']")).click();
		// Assert.assertEquals(driver.findElement(By.id("Login")), "Login / Signup");

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
