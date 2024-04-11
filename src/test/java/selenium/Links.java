package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) {
	

		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		//driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.manage().window().maximize();
		
		
		/*
		List <WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());

		for (WebElement link : links) {

			System.out.println(link.getText());

			//System.out.println(link.getAttribute("href"));
		}

		*/
		  
		  List<WebElement> links = driver.findElements(By.tagName("a"));
		  System.out.println(links.size());
		  
		  for (int i = 0; i < links.size(); i++) {
		  
		  System.out.print((i + 1) + " "); 
		  System.out.println(links.get(i).getText());
		  
		 // System.out.println(links.get(i).getAttribute("name"));
		  
		  }
		  
		  
		  
		 
		driver.quit();
		
		
		
		
		
		
	}

}
