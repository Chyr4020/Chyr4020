package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Addskills_methods1 {

	WebDriver driver;
  @Test
  public void example() { 
	 
	  Addskills_methods1 E1=new Addskills_methods1();
	  E1.OpenChromeBrowser();
	  E1.OpenOrangeHRM();
	  E1.Login();
	  E1.Addjobs();
	  E1.CloseBrowser();
  }
  public void OpenChromeBrowser() { 
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	
}
  public void OpenOrangeHRM() { 
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
  }
public void Login() {
	
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123"); 
	driver.findElement(By.id("btnLogin")).click();
  }
public void Addjobs() {
	
	driver.findElement(By.xpath("//*[@id=\'menu_admin_viewAdminModule\']/b")).click();
	driver.findElement(By.id("menu_admin_Job")).click();
	driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
	driver.findElement(By.id("btnAdd")).click();
	driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("cyr");
	driver.findElement(By.id("jobTitle_jobDescription")).sendKeys("cyr01 ");
	driver.findElement(By.id("jobTitle_note")).sendKeys("cyr01 note");
	driver.findElement(By.id("btnSave")).click();
}
public void CloseBrowser() { 
	
	driver.quit();
}
}