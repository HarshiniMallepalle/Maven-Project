  package SalesForceDotCom;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC7 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		logIn();
		userMenu();
		Thread.sleep(5000);
		mySetting();
		personal();
		Thread.sleep(5000);
		displayAndLayoutSalesforceChatter();
		Thread.sleep(5000);
		userMenu();
		Thread.sleep(5000);
		mySetting();
		Email();
		Thread.sleep(2000);
		calendarReminders();
		
	}

	 public static void logIn() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("harshini@software.com");
		WebElement pswd = driver.findElement(By.id("password"));
		pswd.sendKeys("Test@123");

		WebElement login = driver.findElement(By.id("Login"));
		login.click();
	}

	public static void userMenu() {

		WebElement menuDD = driver.findElement(By.id("userNavButton"));
		menuDD.click();
	}

	public static void mySetting() {
		WebElement mySettingDD = driver.findElement(By.xpath("//a[text()='My Settings']"));
		Explictwait(20, mySettingDD);
		mySettingDD.click();
	}

	public static void personal() throws InterruptedException {
		WebElement personalTab = driver.findElement(By.id("PersonalInfo_font"));
		Explictwait(10, personalTab);
		personalTab.click();

		WebElement LoginHistory = driver.findElement(By.id("LoginHistory_font"));
		Explictwait(10, LoginHistory);
		LoginHistory.click();

		WebElement DownloadLoginHistory = driver.findElement(By.xpath("//a[contains(text(),'Download login history')]"));
		Explictwait(10, DownloadLoginHistory);
		DownloadLoginHistory.click();
		
		WebElement mySettingTab = driver.findElement(By.xpath("//span[text()='My Settings']"));
		Explictwait(10, mySettingTab);
		mySettingTab.click();
		
	}
	
	public static void displayAndLayoutSalesforceChatter() throws InterruptedException {
		
		WebElement Display = driver.findElement(By.id("DisplayAndLayout_font"));
		Explictwait(50, Display);
		Display.click();

		WebElement CustomizeMyTab = driver.findElement(By.id("CustomizeTabs_font"));
		Explictwait(50, CustomizeMyTab);
		CustomizeMyTab.click();
		
		WebElement CustomApp =driver.findElement(By.id("p4"));
		Explictwait(10, CustomApp);
		Select custom=new Select(CustomApp);
        custom.selectByVisibleText("Salesforce Chatter");
        
        WebElement ReportSel = driver.findElement(By.id("duel_select_1"));
  		Explictwait(20, ReportSel);
        Select sel = new Select(ReportSel);
        sel.selectByValue("report");
        
        WebElement Remove =driver.findElement(By.xpath("//img[@alt='Remove']"));
        Remove.click();
        
        WebElement ReportTab = driver.findElement(By.id("duel_select_0"));
  		Explictwait(20, ReportTab);
        Select select = new Select(ReportTab);
        select.selectByValue("report");
  	  		
 		WebElement Add = driver.findElement(By.xpath("//img[@alt='Add']"));
		Explictwait(10, Add);
		Add.click();
		
		WebElement saveButton = driver.findElement(By.name("save"));
		Explictwait(10, saveButton);
		saveButton.click();
		
		WebElement TopRightDDwn = driver.findElement(By.id("tsid-arrow"));
		Explictwait(10, TopRightDDwn);
		TopRightDDwn.click();
		

		WebElement salesforcechatter =driver.findElement(By.xpath("//a[text()='Salesforce Chatter']"));
		Explictwait(60, salesforcechatter);
		salesforcechatter.click();
		
		Thread.sleep(5000);//we should use thread.sleep when new window occurs mostly
		WebElement close =driver.findElement(By.id("tryLexDialogX"));
		
		close.click();
		
		WebElement TopRightDDwn1 = driver.findElement(By.id("tsid-arrow"));
		Explictwait(60, TopRightDDwn1);
		TopRightDDwn1.click();
		

		WebElement Sales =driver.findElement(By.xpath("//a[text()='Sales']"));
		Explictwait(60, Sales);
		Sales.click();
		
		WebElement TopRightDDwn2 = driver.findElement(By.id("tsid-arrow"));
		Explictwait(60, TopRightDDwn2);
		TopRightDDwn2.click();
		

		WebElement Marketing =driver.findElement(By.xpath("//a[text()='Marketing']"));
		Explictwait(60, Marketing);
		Marketing.click();
	}

	public static void Email() throws InterruptedException {
				
		WebElement email =driver.findElement(By.id("EmailSetup_font"));
		Explictwait(10, email);
		email.click();
		
		WebElement myemail=driver.findElement(By.id("EmailSettings_font"));
		Explictwait(10, myemail);
		myemail.click();
		
		WebElement emailName =driver.findElement(By.id("sender_name"));
		Explictwait(10, emailName);
		emailName.clear();
		emailName.sendKeys("Harshini M");
		

		WebElement emailID =driver.findElement(By.id("sender_email"));
		Explictwait(10, emailID);
		emailID.clear();
		emailID.sendKeys("m.harshini.reddy@gmail.com");
		

		WebElement automaticBCC =driver.findElement(By.id("auto_bcc1"));
		Explictwait(10, automaticBCC);
		automaticBCC.click();
	
		WebElement saveemail =driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save' ]"));
		Explictwait(10, saveemail);
		saveemail.click();
		
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

	}
	
	
	public static void calendarReminders() throws InterruptedException {
		
		WebElement mySettingTab = driver.findElement(By.xpath("//span[text()='My Settings']"));
		Explictwait(10, mySettingTab);
		mySettingTab.click();
		
		WebElement CalenderRemindersLink = driver.findElement(By.xpath("//span[text()='Calendar & Reminders']"));
		Explictwait(10, CalenderRemindersLink);
		CalenderRemindersLink.click();
		
		WebElement ActivityReminder =driver.findElement(By.xpath("//span[text()='Activity Reminders']"));
		Explictwait(10, ActivityReminder);
        ActivityReminder.click();
        
        WebElement OpenReminder =driver.findElement(By.id("testbtn"));
		Explictwait(10, OpenReminder);
        OpenReminder.click();
        
        Thread.sleep(5000);
       Set<String> handle= driver.getWindowHandles();
        String[] indexOfWindows=handle.toArray(new String[handle.size()]);
        driver.switchTo().window(indexOfWindows[1]);
        
       WebElement validationText=driver.findElement(By.xpath("//th[text()='Subject']"));
       String actualValue=validationText.getText();
        Assert.assertEquals(actualValue, "Subject");       
	}

	
	public static void Explictwait(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
}
