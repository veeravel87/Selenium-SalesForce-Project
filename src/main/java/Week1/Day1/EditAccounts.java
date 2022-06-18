package Week1.Day1;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class EditAccounts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);
		  //String text="";	
	String phone="(978) 972-5676";
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
	     driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("veeravel"+Keys.ENTER);
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("(//a[contains(@class,'slds-button slds-button--icon-x-small')])[1]")).click();
	     //executor.executeScript("arguments[0].click();",findElement2);
	     driver.findElement(By.xpath("//a[@title='Edit']")).click();
	     driver.findElement(By.xpath("(//label[text()='Type']/following::button)[1]")).click();
	     WebElement findElement2 = driver.findElement(By.xpath("//span[@title='Technology Partner']"));
	     executor.executeScript("arguments[0].click();",findElement2);
	     driver.findElement(By.xpath("(//label[text()='Industry']/following::button)[1]")).click();
	     WebElement findElement3 = driver.findElement(By.xpath("//span[@title='Healthcare']"));
	     executor.executeScript("arguments[0].click();",findElement3);
	     driver.findElement(By.xpath("(//textarea[@name='street'])[1]")).sendKeys("Chennai");
	     driver.findElement(By.xpath("(//textarea[@name='street'])[2]")).sendKeys("Madurai");
	     WebElement findElement5 = driver.findElement(By.xpath("(//label[text()='Customer Priority']/following::button)[1]"));
	     executor.executeScript("arguments[0].click();",findElement5);
	     WebElement findElement4 = driver.findElement(By.xpath("//span[@title='Low']"));
	     executor.executeScript("arguments[0].click();",findElement4);
	     driver.findElement(By.xpath("(//label[text()='SLA']/following::button)[1]")).click();
	   driver.findElement(By.xpath("//span[@title='Silver']")).click();
	   driver.findElement(By.xpath("(//label[text()='Active']/following::button)[1]")).click();
	   driver.findElement(By.xpath("//span[@title='No']")).click();
	   driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys("9789725676");
	   WebElement findElement6 = driver.findElement(By.xpath("(//label[text()='Upsell Opportunity']/following::button)[1]"));
	   executor.executeScript("arguments[0].click();",findElement6);
	   driver.findElement(By.xpath("//span[@title='No']")).click();
	   driver.findElement(By.xpath("//button[text()='Save']")).click();
	   List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
	   Thread.sleep(2000);
	   
	    //  Thread.sleep(2000);
	   int rsize = rows.size();

	   System.out.println(rsize);
	
	   Thread.sleep(3000);
	          
	  /* for (int i = 1;i<=rsize; i++) {
		   List<WebElement> header = driver.findElements(By.xpath("//tbody/tr["+i+"]/td"));
		   int csize=header.size();
		   System.out.println(csize);
		   for (int j = 1;j<=csize; j++) {
			   	text = driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+"]")).getText();*/
		
		// break;
		
		
	//}
		   String text = driver.findElement(By.xpath("//span[@class='forceOutputPhone slds-truncate']")).getText();
		  System.out.println(text);
	  
	  // }
		   
	   
	  
			   	
	   if(text.contains(phone))
	   {
		   System.out.println("Phone number updated");
	   }
	   else
	   {
		   System.out.println("Phone number is not updated");
	   }
	}


}
