package SalesForceDotCom;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC6 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		logIn();
		userMenu();
		Thread.sleep(2000);
		myProfile();
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

	public static void myProfile() throws InterruptedException {
		WebElement myProfileTab = driver.findElement(By.xpath("//a[text()='My Profile']"));
		Explictwait(10, myProfileTab);
		myProfileTab.click();

		WebElement edit = driver
				.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img[@alt='Edit Profile']"));
		edit.click();

		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		Explictwait(10, frame1);
		driver.switchTo().frame(frame1);

		WebElement about = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		Explictwait(10, about);
		about.click();

		WebElement lastname = driver.findElement(By.id("lastName"));
		Explictwait(10, lastname);
		lastname.clear();
		lastname.sendKeys("M");

		WebElement saveall = driver.findElement(By.xpath("//input[@value='Save All']"));
		Explictwait(10, saveall);
		saveall.click();

		WebElement post = driver.findElement(By.xpath("//span[text()='Post']"));
		Explictwait(50, post);
		post.click();

		WebElement frame2 = driver.findElement(By.xpath("//iframe[@frameborder='0']"));
		Explictwait(30, frame2);
		driver.switchTo().frame(frame2);

		WebElement textarea = driver.findElement(By.xpath("//body[contains(text(),'Share an update')]"));
		Explictwait(30, textarea);
		textarea.sendKeys("Java, Selenium using TestNG framework");

		driver.switchTo().parentFrame();//span[text()='File']

		WebElement shareButton = driver.findElement(By.id("publishersharebutton"));
		Explictwait(30, shareButton);
		shareButton.click();
		
		Thread.sleep(2000);
		WebElement file = driver.findElement(By.xpath("//span[text()='File']"));
		Explictwait(30, file);
		file.click();
		
		WebElement ClickUploadFile =driver.findElement(By.id("chatterUploadFileAction"));
		ClickUploadFile.click();
		
		WebElement chooseFile =driver.findElement(By.id("chatterFile"));
		Explictwait(60, chooseFile);
		chooseFile.sendKeys("C:\\Users\\harsh\\OneDrive\\Desktop\\FilePhoto.jpg");
		
		
		WebElement shareButton1 = driver.findElement(By.id("publishersharebutton"));
		Explictwait(60, shareButton);
		shareButton1.click();
		
		Thread.sleep(5000);
		WebElement profilePhoto = driver.findElement(By.xpath("//span[@class='profileImage chatter-avatarFull chatter-avatar']//img[@class='chatter-photo']"));
		Actions action = new Actions(driver);
		action.moveToElement(profilePhoto).build().perform();
		
		WebElement AddPhoto = driver.findElement(By.id("uploadLink"));
		Explictwait(30, AddPhoto);
		AddPhoto.click();
		
		 Thread.sleep(5000);
		WebElement photoframe = driver.findElement(By.id("uploadPhotoContentId"));
		Explictwait(60, photoframe);
		driver.switchTo().frame(photoframe);
		
		WebElement choosefile1 = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
		Explictwait(60, choosefile1);
		choosefile1.sendKeys("C:\\Users\\harsh\\OneDrive\\Desktop\\ProfilePhoto.jpg");
		
		WebElement save =driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		Explictwait(50, save);
		save.click();
		 Thread.sleep(5000);
		WebElement cropper =driver.findElement(By.xpath("//div[@class='imgCrop_handle imgCrop_handleSW']"));
		Actions crop = new Actions(driver);
		crop.clickAndHold(cropper).moveByOffset(20,10).build().perform();
		
		WebElement cropper1 =driver.findElement(By.xpath("//div[@class='imgCrop_handle imgCrop_handleSE']"));
		Actions crop1 = new Actions(driver);
		crop1.clickAndHold(cropper1).moveByOffset(20,10).build().perform();
		
//		WebElement cropper2 =driver.findElement(By.xpath("//div[@class='imgCrop_handle imgCrop_handleNE']"));
//		Actions crop2 = new Actions(driver);
//		crop2.clickAndHold(cropper2).moveByOffset(20,10).build().perform();
//
//		WebElement cropper3 =driver.findElement(By.xpath("//div[@class='imgCrop_handle imgCrop_handleNW']"));
//		Actions crop3 = new Actions(driver);
//		crop3.clickAndHold(cropper3).moveByOffset(20,30).build().perform();
		
		WebElement save1 = driver.findElement(By.id("j_id0:j_id7:save"));
		Explictwait(50, save1);
		save1.click();
		
		
	}

	public static void Explictwait(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
}
