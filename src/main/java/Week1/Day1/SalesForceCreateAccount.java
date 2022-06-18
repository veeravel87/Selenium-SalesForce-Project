package Week1.Day1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceCreateAccount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//String title = "Account"+" "+ "\"veeravel\"";
		String title ="\"Veeravel\"";
		//String title="Veeravel";
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
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Veeravel");
		//driver.findElement(By.xpath("//label[text()='Ownership']")).click();
		WebElement findElement2 = driver.findElement(By.xpath("(//label[text()='Ownership']/following::button)[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		 executor1.executeScript("arguments[0].click();",findElement2);
//driver.findElement(By.xpath("(//label[text()='Ownership']/following::button)[1]")).click();
 driver.findElement(By.xpath("//span[text()='Public']")).click();
		//driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Public']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		Thread.sleep(2000);
		
		String text = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		System.out.println(text);
		System.out.println(title);
		
		if(text.contains(title))
		
		{
			System.out.println("Name has been created");
		}
		else
		{
			System.out.println("Name has not been created");
		}
		}

}
