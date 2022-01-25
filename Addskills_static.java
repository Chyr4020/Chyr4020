package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Addskills_static {

	static WebDriver driver;
  @Test
  public static void example() throws Exception { 
	 
	  
	  Addskills_static.OpenChromeBrowser();
	  Addskills_static.OpenOrangeHRM();
	  Addskills_static.Login();
	  Addskills_static.Addjobs();
	  Addskills_static.CloseBrowser();
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
  public static void OpenChromeBrowser()throws Exception  { 
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	
}
  public static void OpenOrangeHRM()throws Exception  { 
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
  }
public static void Login()throws Exception  {
	
	findElement(By.id("txtUsername")).sendKeys("Admin");
	findElement(By.id("txtPassword")).sendKeys("admin123"); 
	findElement(By.id("btnLogin")).click();
  }
public static void Addjobs()throws Exception  {
	
	findElement(By.xpath("//*[@id=\'menu_admin_viewAdminModule\']/b")).click();
	findElement(By.id("menu_admin_Job")).click();
	findElement(By.id("menu_admin_viewJobTitleList")).click();
	findElement(By.id("btnAdd")).click();
	findElement(By.id("jobTitle_jobTitle")).sendKeys("cyr03");
	findElement(By.id("jobTitle_jobDescription")).sendKeys("cyr03 ");
	findElement(By.id("jobTitle_note")).sendKeys("cyr003 note");
	findElement(By.id("btnSave")).click();
}
public static void CloseBrowser() throws Exception { 
	
	
}
}