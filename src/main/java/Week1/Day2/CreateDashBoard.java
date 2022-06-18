package Week1.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDashBoard {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 1.Login to https://login.salesforce.com

		String title="salesforce automation by veera";
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();

		// 2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement findElement1 = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", findElement1);

		// 4.Click on the New Dashboard option
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
		
		Thread.sleep(2000);

		// 5.Enter Name as 'Salesforce Automation by Your Name ' and Click on Create
		WebElement findElement = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		
		driver.switchTo().frame(findElement);
		Thread.sleep(2000);
		
		//WebElement Name = driver.findElement(By.xpath("(//label[text()='Name']/following::input)[1]"));
	
		 WebElement Name = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
		 
		//executor.executeScript("arguments[0].value='salesforce automation by veera';",Name);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(Name));
		Name.sendKeys("salesforce automation by veera");
		Thread.sleep(2000);
		WebElement create=driver.findElement(By.xpath("//button[text()='Create']"));
		executor.executeScript("arguments[0].click();",create);
driver.switchTo().defaultContent();
Thread.sleep(5000);

		driver.switchTo().frame(findElement);
		Thread.sleep(2000);
		
		 WebElement savebtn = driver.findElement(By.xpath("//button[text()='Save']"));
		wait.until(ExpectedConditions.stalenessOf(savebtn));
				
		// WebElement savebtn = driver.findElement(By.xpath("//button[text()='Save']"));
		 Actions act=new Actions(driver);
		
		act.moveToElement(savebtn).click().perform();
		 
			
			 // WebDriverWait wait3=new WebDriverWait(driver, Duration.ofSeconds(20));
			  //wait3.until(ExpectedConditions.stalenessOf(savebtn)); //
			 		//  savebtn.click();
		  //executor.executeScript("arguments[0].click();", savebtn);
		 
		 
		 
		 
			/*
			 * WebElement verify = driver.findElement(By.
			 * xpath("(//label[text()='Edit Dashboard name']/following-sibling::div//span)[1]"
			 * )); WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
			 * wait1.until(ExpectedConditions.visibilityOf(verify)); String text =
			 * driver.findElement(By.
			 * xpath("(//label[text()='Edit Dashboard name']/following-sibling::div//span)[1]"
			 * )).getText(); System.out.println(text);
			 * 
			 * if(text.contains(title)) {
			 * System.out.println("Dashboard has been created successfully"); } else {
			 * System.out.println("Dashboard is not created"); }
			 */

	}

}
