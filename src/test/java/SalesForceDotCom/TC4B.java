package SalesForceDotCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC4B {
static WebDriver driver;

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("123");
		WebElement pswd = driver.findElement(By.id("password"));
		pswd.sendKeys("22131");
		
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
	}

}
