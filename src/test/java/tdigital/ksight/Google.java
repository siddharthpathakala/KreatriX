package tdigital.ksight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Google {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SoftAssert softassert = new SoftAssert();
		//WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
	
		driver.get("https://www.willow.tv");
		
		//System.out.println("Page Title = "+driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), "WatchCricket Live streaming, Replay, Highlights much more| Willow");
		softassert.assertEquals(driver.getTitle(), "WatchCricket Live streaming, Replay, Highlights much more| Willow");
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}

}
