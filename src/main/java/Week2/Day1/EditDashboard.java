package Week2.Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Week1.Day2.CreateDashBoard;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditDashboard extends CreateDashBoard{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 1.Login to https://login.salesforce.com

				//String title = "salesforce";
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

				// 4.Click on the Dashboard option
				WebElement dashboards = driver.findElement(By.xpath("(//span[text()='Dashboards'])[1]"));
				executor.executeScript("arguments[0].click();", dashboards);
				
				//5. Search the Dashboard 'Salesforce Automation by Your Name'
				driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("");
				
				
				//6.Click on the Dropdown icon and Select Edit
				driver.findElement(By.xpath("(//span[@class='slds-grid slds-align_absolute-center slds-grid_align-spread'])[1]")).click();
				driver.findElement(By.xpath("//span[text()='Edit']")).click();
				
				//7.Click on the Edit Dashboard Properties icon
				WebElement findElement = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
				driver.switchTo().frame(findElement);
				WebElement Edit = driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']"));
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOf(Edit));
				driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")).click();
				
				//8.Enter Description as 'SalesForce' and click on save.
				driver.findElement(By.id("dashboardDescriptionInput")).sendKeys("Salesforce desc");
				driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
				
				//9. Click on Done and  Click on save in the popup window displayed.
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[text()='Save'])")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[text()='Done'])")).click();
				
				
				String desc = driver.findElement(By.xpath("//div[@class='slds-col slds-align-bottom']/p")).getText();
				if(desc.contains("Salesforce desc"))
				{
					System.out.println("description is updated");
				}
				else
				{
					System.out.println("description is not updated");
				}
	}

}
