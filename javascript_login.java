package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class javascript_login {
	
	WebDriver driver;
  @Test
  public void example() {
	  
	 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	WebElement username=driver.findElement(By.id("txtUsername"));
	WebElement Password=driver.findElement(By.id("txtPassword"));
	WebElement Login=driver.findElement(By.id("btnLogin"));
	
	WebElement admin=driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b"));
	WebElement nationality=driver.findElement(By.id("menu_admin_nationality"));
	WebElement Add=driver.findElement(By.id("btnAdd"));
	WebElement name=driver.findElement(By.id("nationality_name"));
	WebElement Save=driver.findElement(By.id("btnSave"));
	
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	 js.executeScript("argument[0],setAttribute('value','Admin')",username);
	 js.executeScript("argument[0],setAttribute('value','admin123')",Password);
	 js.executeScript("argument[0],Click()",Login);
	 
	js.executeScript("argument[0],Click()",admin);
	 js.executeScript("argument[0],Click()",nationality);
	 js.executeScript("argument[0],Click()",Add);
	js.executeScript("argument[0],setAttribute('value','kenya')",name);
	js.executeScript("argument[0],Click()",Save);
	 
	 
	 
	 js.executeScript("arguments[0].style.border='3px solid red'", username);
	 js.executeScript("arguments[0].style.border='3px solid red'", Password);
	 js.executeScript("arguments[0].style.border='3px solid red'", Login);
	 
	 js.executeScript("arguments[0].style.border='3px solid red'", admin);
	 js.executeScript("arguments[0].style.border='3px solid red'", nationality);
	 js.executeScript("arguments[0].style.border='3px solid red'", Add);
	 js.executeScript("arguments[0].style.border='3px solid red'", name);
	 js.executeScript("arguments[0].style.border='3px solid red'", Save);
  }

}
