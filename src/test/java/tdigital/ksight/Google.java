package tdigital.ksight;

import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Google {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Logger logger = Logger.getLogger("Google");
		DOMConfigurator.configure("log4j.xml");
		
		PropertyConfigurator.configure("log4j.properties");
		
		SoftAssert softassert = new SoftAssert();
		//WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://www.willow.tv");
		logger.info("Browser Opened");
		//System.out.println("Page Title = "+driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), "WatchCricket Live streaming, Replay, Highlights much more| Willow");
		softassert.assertEquals(driver.getTitle(), "WatchCricket Live streaming, Replay, Highlights much more| Willow");
		System.out.println(driver.getCurrentUrl());
		Set<Cookie> cookies= driver.manage().getCookies();
		System.out.println("Total Cookies = "+cookies.size());
		for(Cookie cookie :cookies)
		{
			System.out.println(cookie.getName()+" : "+cookie.getValue());
		}
		driver.close();
	}

}
