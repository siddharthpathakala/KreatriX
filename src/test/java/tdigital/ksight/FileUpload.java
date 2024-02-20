package tdigital.ksight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		WebElement Uploadbutton=driver.findElement(By.xpath("//*[@onchange='uploadimg()']"));
		Thread.sleep(3000);	
		Uploadbutton.click();
		System.out.println("Clicked");
		
		driver.close();
		
	}

}
