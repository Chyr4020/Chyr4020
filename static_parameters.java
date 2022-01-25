package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class static_parameters {

	static WebDriver driver;
	static String TestURL="https://opensource-demo.orangehrmlive.com/";
	static String username="Admin",password="admin123";
	static String jobTitle="api",jobDesc="api desc",jobnote="api note";
  @Test
  public static void Addjobs() throws Exception { 
	 
	  
	  static_parameters.OpenChromeBrowser();
	  static_parameters.OpenOrangeHRM(TestURL);
	  static_parameters.Login(username,password);
	  static_parameters.Addjobs(jobTitle,jobDesc,jobnote);
	 
  }
  public static void OpenChromeBrowser()throws Exception { 
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	
}
  public static void OpenOrangeHRM(String TestURL)throws Exception { 
	  
	  driver.get(TestURL);
	  
  }
public static void Login(String username,String password)throws Exception {
	
	findElement(By.id("txtUsername")).sendKeys(username);
	findElement(By.id("txtPassword")).sendKeys(password); 
	findElement(By.id("btnLogin")).click();
  }
public static void Addjobs(String jobTitle,String jobDesc,String jobnote )throws Exception {
	
	findElement(By.xpath("//*[@id=\'menu_admin_viewAdminModule\']/b")).click();
	findElement(By.id("menu_admin_Job")).click();
	findElement(By.id("menu_admin_viewJobTitleList")).click();
	findElement(By.id("btnAdd")).click();
	findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitle);
	findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDesc);
	findElement(By.id("jobTitle_note")).sendKeys(jobnote);
	findElement(By.id("btnSave")).click();
}
public static  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
}