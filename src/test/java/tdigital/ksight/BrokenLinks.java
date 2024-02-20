package tdigital.ksight;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrokenLinks {

	public static void main(String[] args) throws IOException, InterruptedException{

		//options.addArguments("--headless");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com//");
		System.out.println(driver.getTitle());
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int no_of_links = links.size();
		System.out.println("Total no.of links = "+no_of_links);
		for(int i=0;i<no_of_links;i++)
		{
			WebElement element = links.get(i);
			String url =element.getAttribute("href");
			//System.out.println(url);
			
			URL link = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			
			Thread.sleep(2000);
			httpConn.connect();
			
			int resCode = httpConn.getResponseCode();
			if (resCode>=400)
			{
				System.out.println("Broken link - "+url);
			}
			else
			{
				System.out.println("Valid link - "+url);
			}
			
		}
		
		driver.close();
	}

}
