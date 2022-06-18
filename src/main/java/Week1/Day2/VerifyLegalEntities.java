package Week1.Day2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyLegalEntities {

	public static void main(String[] args) throws InterruptedException, ParseException {
		// TODO Auto-generated method stub
		// 1.Login to https://login.salesforce.com
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();

		// 2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click view All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement findElement1 = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", findElement1);
		// 4. Click on the legal Entities tab
		driver.findElement(By.xpath("(//span[text()='Legal Entities'])[1]")).click();

		// 5. Click the sort arrow in the Last Modified Date.
		// Thread.sleep(4000);
		WebElement findElement2 = driver.findElement(By.xpath("//span[text()='Last Modified Date']"));
		executor.executeScript("arguments[0].click();", findElement2);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Last Modified Date']")));
		Thread.sleep(3000);
		WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Last Modified Date']"));
		executor.executeScript("arguments[0].click();", findElement3);
		//WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/th/following-sibling::td/span/span")));
		Thread.sleep(2000);

		// 6. Verify the Legal Entities displayed in ascending order by Last Modified
		// Date.

		String strDate1 = driver.findElement(By.xpath("//tbody/tr/th/following-sibling::td/span/span")).getText();
		System.out.println(strDate1);
		String strDate2 = driver.findElement(By.xpath("//tbody/tr[2]/th/following-sibling::td/span/span")).getText();
		System.out.println(strDate2);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy, hh:mm a");
		Date date1 = dateFormat.parse(strDate1);
		System.out.println(date1);
		//SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy, hh:mm a");
		Date date2 = dateFormat.parse(strDate2);
		System.out.println(date2);
		int compareTo = date1.compareTo(date2);
		System.out.println(compareTo);
		if (date1.compareTo(date2) >= 0) {
			System.out.println("Descending order");
		} else {
			System.out.println("Ascending order");
		}

	}

}
