package SalesForceDotCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC3 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("mhr@software.com");
		WebElement pswd = driver.findElement(By.id("password"));
		pswd.sendKeys("salesforce@89");
		WebElement rememberMe = driver.findElement(By.id("rememberUn"));
		rememberMe.click();
		
		WebElement login = driver.findElement(By.id("Login"));
		Explictwait(2, login);
		login.click();
		WebElement userMenuDD = driver.findElement(By.id("userNav-arrow"));
		userMenuDD.click();
		WebElement logOut = driver.findElement(By.xpath("//a[text()='Logout']"));
		Explictwait(5, logOut);

		logOut.click();

		Thread.sleep(5000);
		WebElement username1 = driver.findElement(By.xpath("//span[@id='idcard-identity']"));
		String Actualvalue = username1.getText();
		Assert.assertEquals(Actualvalue, "mhr@software.com");
		
	}

	public static void Explictwait(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
}
