package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Addskills1 {
	
	WebDriver driver;
  
  public void Addskills1(WebDriver driver) 
  {
	  this.driver=driver;
  }
  public void Addskills() throws Exception
  {
	  driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
	  driver.findElement(By.xpath("//*[@id=\"menu_admin_Qualifications\"]")).click();
	  driver.findElement(By.id("menu_admin_viewSkills")).click();
	  driver.findElement(By.id("btnAdd")).click();
	  driver.findElement(By.id("skill_name")).sendKeys("api1");
	  driver.findElement(By.id("skill_description")).sendKeys("api1 decc");
	  driver.findElement(By.id("btnSave")).click();
  }
  
}
