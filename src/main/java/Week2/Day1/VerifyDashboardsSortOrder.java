package Week2.Day1;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;

public class VerifyDashboardsSortOrder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// String title = "salesforce";
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

		// 4. Click on the Dashboards tab
		WebElement dashboards = driver.findElement(By.xpath("(//span[text()='Dashboards'])[1]"));
		executor.executeScript("arguments[0].click();", dashboards);

		// 5.Click the sort arrow in the Dashboard Name.
		driver.findElement(By.xpath("//span[text()='Dashboard Name']")).click();
		Thread.sleep(3000);

		// 6. Verify the Dashboard displayed in ascending order by Dashboard name.
		String text2 = driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy uiOutputText']")).getText();
		String expString = text2.replaceAll("\\D", "");
		System.out.println(expString);
		int noOfRows = Integer.parseInt(expString);
		System.out.println(noOfRows);
		List<String> lst = new ArrayList<String>();
		for (int i = 1; i <=noOfRows; i++) {
			WebElement rows = driver.findElement(By.xpath("//tbody/tr[" + i + "]/th[1]//a"));
			driver.executeScript("arguments[0].scrollIntoView();", rows);
			String text = rows.getText();
			String textUpper = text.toUpperCase(); // Thread.sleep(2000);
			lst.add(textUpper);
		}
		System.out.println(lst);
		List<String> explst = new ArrayList<String>(lst);
		Collections.sort(explst);
		System.out.println(explst);
		boolean equals = lst.equals(explst);
		if (equals == true) {
			System.out.println("Both the lists are equal");
		} else {
			System.out.println("Both the lists are not equal");
		}

	}

}
