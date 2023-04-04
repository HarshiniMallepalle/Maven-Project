package SalesForceDotCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC2 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
        System.out.println(driver.getTitle());
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("mhr@software.com");
		WebElement pswd = driver.findElement(By.id("password"));
		pswd.sendKeys("salesforce@89");
	    WebElement login = driver.findElement(By.id("Login"));
		login.click();
		Thread.sleep(5000);
		String ActualValue = driver.getTitle();
		Assert.assertEquals(ActualValue, "Home Page ~ Salesforce - Developer Edition");
	}
}


