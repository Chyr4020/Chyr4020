package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Addskills_methods {
	
	
	WebDriver driver;
	
  @Test
  public void Practice() throws Exception {
	  
	  Addskills_methods c1=new Addskills_methods();
	  c1.OpenChromeBrowser();
	  c1.OpenOrangeHRM();
	  c1.Login();
	  c1.Addskills();
  }	
	
  public void OpenChromeBrowser() throws Exception {	
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.manage().window().maximize();
	    
}
  public void OpenOrangeHRM() throws Exception {	
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	    
  }
  public void Login() throws Exception {	
	  
	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).click();
	    
}
  public void Addskills() throws Exception {
	  
	  driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
	  driver.findElement(By.xpath("//*[@id=\"menu_admin_Qualifications\"]")).click();
	  driver.findElement(By.id("menu_admin_viewSkills")).click();
	  driver.findElement(By.id("btnAdd")).click();
	  driver.findElement(By.id("skill_name")).sendKeys("api1");
	  driver.findElement(By.id("skill_description")).sendKeys("api1 decc");
	  driver.findElement(By.id("btnSave")).click();  
}
  
}