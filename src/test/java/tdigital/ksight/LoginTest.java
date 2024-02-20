package tdigital.ksight;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	@Test
	public void TC_login1() throws InterruptedException
	{
		
		Logger logger = Logger.getLogger("LoginTest");
		DOMConfigurator.configure("log4j.xml");
		
		//PropertyConfigurator.configure("log4j.properties");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		logger.info("Browser Lanched");
		String url = "https://www.rahulshettyacademy.com/locatorspractice/";
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				
		//Input Data
		String my_name = "Testing";
		String my_email = "test@vmial.com";
		String ph_num = "489324702";
		
		
		//Web Elements
		logger.info(ph_num+"entered");
		WebElement forgot_password = driver.findElement(By.xpath("//div/a"));
		forgot_password.click();
		
		WebElement name = driver.findElement(By.cssSelector("input[placeholder='Name']"));
		name.sendKeys(my_name);
		
		WebElement email = driver.findElement(By.cssSelector("input[placeholder='Email']"));
		email.sendKeys(my_email);
		
		logger.info("Phone number entered");
		WebElement phone_number = driver.findElement(By.cssSelector("input[placeholder='Phone Number']"));
		phone_number.sendKeys(ph_num);
		
		WebElement reset = driver.findElement(By.className("reset-pwd-btn"));
		reset.click();
		
		//Grabbing password from the Paragraph text
		String info_text = driver.findElement(By.xpath("//form/p")).getText();
		System.out.println(info_text);
		String[] get_password = info_text.strip().split("'");
		
		/*
		for(int i = 0;i<new_password.length;i++)
		{
			System.out.println(new_password[i]);
		}
		//System.out.println(new_password[1]);
		*/
		String new_password = get_password[1];
		System.out.println(new_password);
		
		//Web elements
		WebElement go_to_login = driver.findElement(By.className("go-to-login-btn"));
		go_to_login.click();
		
		WebElement user_name = driver.findElement(By.cssSelector("input[id*='Username']"));
		user_name.sendKeys(my_name);
		
		WebElement password = driver.findElement(By.name("inputPassword"));
		password.sendKeys(new_password);
		
		Thread.sleep(3000);
		WebElement checkbox_1 = driver.findElement(By.xpath("//div//span//input[@name='chkboxOne']"));
		checkbox_1.click();
		
		WebElement checkbox_2 = driver.findElement(By.xpath("//div//span//input[@name='chkboxTwo']"));
		checkbox_2.click();
		
		WebElement sign_in = driver.findElement(By.cssSelector(".submit.signInBtn"));
		sign_in.click();
		
		Thread.sleep(3000);
				
		String success_msg = driver.findElement(By.tagName("p")).getText();
		System.out.println("Message="+success_msg);
		
		//Validating the Success Message
		Assert.assertEquals("You are successfully logged in.", success_msg);
		logger.info("Test Passed");
		WebElement log_out = driver.findElement(By.className("logout-btn"));
		log_out.click();
		
		//Browser shutdown
		System.out.println("Closing Browser");
		driver.quit();
		//driver.close();
	}

	}

