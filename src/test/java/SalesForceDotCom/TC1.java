package SalesForceDotCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC1 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    //driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("mhr@software.com");
		WebElement pswd = driver.findElement(By.id("password"));
		pswd.sendKeys("");
	    WebElement login = driver.findElement(By.id("Login"));
		login.click();
		WebElement error = driver.findElement(By.xpath("//div[text()='Please enter your password.']"));
		Thread.sleep(5000);
        String errormsg = error.getText();
		Assert.assertEquals(errormsg,"Please enter your password.");

	}
}
