package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class nonstatic_parameters {

	WebDriver driver;
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String username="Admin",password="admin123";
	String jobTitle="api",jobDesc="api desc",jobnote="api note";
  @Test
  public void Addjobs() throws Exception { 
	 
	  nonstatic_parameters E1=new nonstatic_parameters();
	  E1.OpenChromeBrowser();
	  E1.OpenOrangeHRM(TestURL);
	  E1.Login(username,password);
	  E1.Addjobs(jobTitle,jobDesc,jobnote);
	  E1.CloseBrowser();
  }
  public void OpenChromeBrowser()throws Exception { 
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	
}
  public void OpenOrangeHRM(String TestURL)throws Exception { 
	  
	  driver.get(TestURL);
	  
  }
public void Login(String username,String password)throws Exception {
	
	findElement(By.id("txtUsername")).sendKeys(username);
	findElement(By.id("txtPassword")).sendKeys(password); 
	findElement(By.id("btnLogin")).click();
  }
public void Addjobs(String jobTitle,String jobDesc,String jobnote )throws Exception {
	
	findElement(By.xpath("//*[@id=\'menu_admin_viewAdminModule\']/b")).click();
	findElement(By.id("menu_admin_Job")).click();
	findElement(By.id("menu_admin_viewJobTitleList")).click();
	findElement(By.id("btnAdd")).click();
	findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitle);
	findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDesc);
	findElement(By.id("jobTitle_note")).sendKeys(jobnote);
	findElement(By.id("btnSave")).click();
}
public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
public void CloseBrowser()throws Exception{ 
	
	driver.quit();
}
}