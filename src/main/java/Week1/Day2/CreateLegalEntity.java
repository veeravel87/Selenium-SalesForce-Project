package Week1.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;

public class CreateLegalEntity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.Login to https://login.salesforce.com
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

		// 3. Click view All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		// 4. Click on the Dropdown icon in the legal Entities tab
		WebElement findElement1 = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", findElement1);
		driver.findElement(
				By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']"))
				.click();

		// 5. Click on New Legal Entity
		WebElement findElement2 = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		executor.executeScript("arguments[0].click();", findElement2);

		// 6. Enter the Company name as 'Tetsleaf'.
		driver.findElement(By.xpath("((//span[text()='Name'])[2]/following::input)[1]")).sendKeys("Testleaf");

		// 7. Enter Description as 'SalesForce'.
		driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).sendKeys("Salesforce");

		// 8.Select Status as 'Active'
		driver.findElement(By.xpath("(//span[text()='Status']/following::a)[1]")).click();
		WebElement findElement3 = driver.findElement(By.xpath("//a[@title='Active']"));
		executor.executeScript("arguments[0].click();", findElement3);

		// 9.Click on Save
		driver.findElement(By.xpath(" (//span[text()='Save'])[2]")).click();

		// 10. Verify the Alert message (Complete this field) displayed for Name
		String text = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
				.getText();
		String value = "\"Testleaf\"";
		String Actual = "Legal Entity " + value + " was created.";
		System.out.println(text);
		System.out.println(Actual);
		if (text.contains(Actual)) {
			System.out.println("Legal Entity has created");
		} else {
			System.out.println("Legal Entity has not created");
		}

	}

}
