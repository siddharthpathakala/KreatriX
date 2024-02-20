package tdigital.ksight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DragandDrop {

	WebDriver driver;
	public void method_test() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Actions a = new Actions(driver);
		WebElement drag =driver.findElement(By.id("draggable"));
		WebElement drop =driver.findElement(By.id("droppable"));
		a.clickAndHold(drag).moveToElement(drop).click().build().perform();
		//a.dragAndDrop(drag, drop);
		System.out.println("Drag and Drop success");
		WebElement dropped = driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]"));
		if(dropped.getText().contains("Dropped"))
		{
			System.out.println("Passed test");
			tearDown();
			
	}
		else
		{
			System.out.println("Failed test");
		}
		System.out.print("Completed Method Exectuion");
		
	}
	public void tearDown()
	{
		System.out.println("Closing the browser");
		driver.close();
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//WebDriver driver= new ChromeDriver();
		DragandDrop d = new DragandDrop();
		d.method_test();
		
	}
	

}
