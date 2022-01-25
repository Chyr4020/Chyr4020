package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Addskills {
	
	WebDriver driver;
  @Test
  public void Login() {
	  
	 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).click();
	  driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
	  driver.findElement(By.xpath("//*[@id=\"menu_admin_Qualifications\"]")).click();
	  driver.findElement(By.id("menu_admin_viewSkills")).click();
	  driver.findElement(By.id("btnAdd")).click();
	  driver.findElement(By.id("skill_name")).sendKeys("sel");
	  driver.findElement(By.id("skill_description")).sendKeys("sel decc");
	  driver.findElement(By.id("btnSave")).click();
	  
  }
}
