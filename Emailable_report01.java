package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Emailable_report01 {
	
	WebDriver driver;
	
	
  @Test
  public void email() throws Exception {
	  
	  driver = TestBrowser.OpenChromeBrowser();  
	  String TestURL = "https://www.amazon.in/";
	  
	  driver.get(TestURL);
	  Reporter.log("pass_websiteurl");
	  
	
	  
	  driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
	  Reporter.log("pass_hellosighin");
	  
	  driver.findElement(By.id("ap_email")).sendKeys("8886784020");
	  Reporter.log("pass_entermobilenum");
	  
	  driver.findElement(By.id("continue")).click();
	  Reporter.log("pass_clickoncontinue");
	  
	  driver.findElement(By.id("ap_password")).sendKeys("Chepyala@12");
	  Reporter.log("pass_enterpassword");
	  
	  driver.findElement(By.id("signInSubmit")).click();
	  Reporter.log("pass_clickonsignin");
  }


  
}
