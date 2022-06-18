package Week2.Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verifyappstoreloaded {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 1.Launch Salesforce application https://login.salesforce.com/
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");

		// 2.Login with username as "makaia@testleaf.com" and password as "India@123"
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();

		Thread.sleep(4000);
		// 3.Click on the sliding icon until "See System Status" is displayed
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']"))
				.click();
		driver.findElement(By.xpath("(//span[text()='See System Status']/following::button/span)[1]")).click();

		Set<String> winset = driver.getWindowHandles();
		List<String> winlist = new ArrayList<String>(winset);
		driver.switchTo().window(winlist.get(1));
		driver.findElement(By.xpath("//p[text()='Home']")).click();

		driver.findElement(By.xpath("//p[contains(text(),'Compliance')]")).click();
		driver.findElement(By.xpath("//a[text()='Services']")).click();
		Thread.sleep(4000);
		List<WebElement> services = driver.findElements(By.xpath("//h2[@class='mb2 lh-title']"));

		int size = services.size();
		System.out.println(size);
		List<String> lst = new ArrayList<String>();

		Thread.sleep(5000);
		for (WebElement eachEle : services) {
			String text = eachEle.getText();
			lst.add(text);
		}

		System.out.println(lst);
		List<String> explst = new ArrayList<String>(lst);
		Collections.sort(explst);
		System.out.println(explst);
		boolean equals = lst.equals(explst);
		System.out.println(equals);
		if (equals == true) {
			System.out.println("Lists are equal");
		} else {
			System.out.println("Lists are not equal");
		}

	}

}
