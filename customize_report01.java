package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Day_010_Custimize_EmailableReport_Lab1.Reporter1;
import Day_034_TestNG_Listeners.TestBrowser;

public class customize_report01 {
	
WebDriver driver;	
Reporter1 c1;
public String username="ap_email";
public String password="ap_password";
  @Test
  public void custom() throws Exception {
	  driver=TestBrowser.OpenChromeBrowser();  
	  
	  String sel = "selenium";
	  c1=new Reporter1(driver,sel);
	  
	  String TestURL="https://www.amazon.in/";
	  
	  driver.get(TestURL);
	  c1.TakeScreenShotAuto(driver,"Opened Amazon","Pass");
	  
	  findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
	  c1.TakeScreenShotAuto(driver,"sign in","Pass");
	  
	  findElement(By.id(username)).sendKeys("8886784020");
	  c1.TakeScreenShotAuto(driver,"user name entred","Pass");
	  
	  findElement(By.id("continue")).click();
	  c1.TakeScreenShotAuto(driver,"sign in","Pass");
	  
	  findElement(By.id(password)).sendKeys("Chepyala@12");
	  c1.TakeScreenShotAuto(driver,"password entred","Fail");
	  
	  findElement(By.id("signInSubmit")).click();
	  c1.TakeScreenShotAuto(driver,"signin","Pass");
	  
	  
	  
	  
	  
	  
	  
	  
  }
  public  WebElement findElement(By by) throws Exception 
  {
  			
  	 WebElement elem = driver.findElement(by);    	    
  	// draw a border around the found element
  	 
  	if (driver instanceof JavascriptExecutor) 
  	{
  	 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
   
  	}
  	
  	return elem;
  
}
}

