package selenium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsPractice {

	public static void main(String[] args) {

	}

	WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void validateTitle(String browser ) { // Here 'brsr' is variable

		if (browser.equalsIgnoreCase("edge")) {

			// System.setProperty("webdriver.chrome.driver","//Users//saiful//Downloads//chromedriver-mac-arm64//chromedriver");

			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();

			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
		} else if (browser.equalsIgnoreCase("chrome")) {

			// System.setProperty("webdriver.edge.driver","/Users/saiful/Downloads/edgedriver_mac64/msedgedriver");

			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
			// Launcing AUT
		}
	}

	@Test
	public void title() {


		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);// this method would compare between
		// whatever the url it gates and whatever the expected url ,if this are matching
		// then it would pass the test cases.Otherwise it would through a failuar
		// exception.

	}
	
	@AfterMethod
		public void teardown() {
		 driver.close();
		}
	}

