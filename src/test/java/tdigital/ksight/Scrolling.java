package tdigital.ksight;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scrolling {

	@Test
	public void scrollByPixel()
	{
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.countries-ofthe-world.com/all-countries.html");
	driver.manage().window().maximize();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//1.By using Pixel
	//js.executeScript("window.scrollBy(0,1000)", "");
	
	//2.Scroll till element if found
	WebElement text =driver.findElement(By.xpath("//li[contains(text(),'New Zealand')]"));
	js.executeScript("arguments[0].scrollIntoView();", text);
	
	//3.Scroll till bottom
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	
	}
}