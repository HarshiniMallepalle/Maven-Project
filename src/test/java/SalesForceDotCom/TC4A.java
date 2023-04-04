package SalesForceDotCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC4A {
 static WebDriver driver;
	public static void main(String[] args) {
       logIn();
       forgotPwd();
	}
	public static void logIn() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
			
	}
	public static void forgotPwd() {
		
		WebElement forgotpw = driver.findElement(By.id("forgot_password_link"));
		forgotpw.click();
		
		//mhr@software.com
		WebElement username =driver.findElement(By.id("un"));
		username.sendKeys("mhr@software.com");
		WebElement continuepwd = driver.findElement(By.id("continue"));
		continuepwd.click();
		
	}

}
