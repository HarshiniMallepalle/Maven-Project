package SalesForceDotCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.jar.asm.Handle;

public class TC5 {
static WebDriver driver;
	public static void main(String[] args) {
      logIn();
      userMenu();
	}
	public static void logIn() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("mhr@software.com");
		WebElement pswd = driver.findElement(By.id("password"));
		pswd.sendKeys("salesforce@89");
		
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
	}
	public static void userMenu() {
		
	
		WebElement menuDD =driver.findElement(By.id("userNavButton"));
		menuDD.click();
		List<WebElement> menuValues = driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));
		System.out.println(menuValues.size());
	    String[] A= {"My Profile","My Settings","Developer Console1","Switch to Lightning Experience","Logout"};
			
	        for(int i=0;i<menuValues.size();i++) {
		
			if(menuValues.get(i).getText().equalsIgnoreCase(A[i])) {
				System.out.println("ActualValue : "+menuValues.get(i).getText()+" Excepted value : "+A[i]);
				
			}
		else {
			System.out.println("This line text didn't match");
		}
		}
	}

}
