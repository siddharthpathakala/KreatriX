package tdigital.ksight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Auth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		System.out.println("Page Title = "+driver.getTitle());
		driver.close();
	}

}
