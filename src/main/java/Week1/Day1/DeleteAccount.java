package Week1.Day1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteAccount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement findElement1 = driver.findElement(By.xpath("(//span[text()='Accounts'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();",findElement1);
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Kumar"+Keys.ENTER);
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("(//a[contains(@class,'slds-button slds-button--icon-x-small')])[1]")).click();
	     //executor.executeScript("arguments[0].click();",findElement2);
	     driver.findElement(By.xpath("//a[@title='Delete']")).click();
	     driver.findElement(By.xpath("//span[text()='Delete']")).click();
	     driver.findElement(By.xpath("//input[@name='Account-search-input']")).clear();
	     
	     driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Kumar"+Keys.ENTER);
	     String text = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
	     if(text.contains("No items"))	     {
	     System.out.println("Item has been deleted");
	     }
	     else
	     {
	    	 System.out.println("Itam has not deleted");
	     }
	}

}
