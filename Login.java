package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Day_034_TestNG_Listeners.TestBrowser;

public class Login {
	
	WebDriver driver;
  @Test
  public void Login() throws Exception{
	  
	  driver=TestBrowser.OpenChromeBrowser();
	  driver.get("https://www.flipkart.com/");
	 
  }
	 
	
	  
	
		  
}
