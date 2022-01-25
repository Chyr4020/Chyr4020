package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class parameters_Data {
	
private static final String UserName = null;
static WebDriver driver;	
@Parameters({"Browser1","UserNam","Passwor","Nationalit"})
  @Test
  public void Data(String Browser,String UserName,String Password,String Nationality) throws Exception {
	
	
	parameters_Data.OpenOrangeHRM();
	parameters_Data.Login(UserName,Password);
	parameters_Data.National(Nationality);
	{
		if(Browser.equalsIgnoreCase("Chrome")) 
		 driver=TestBrowser.OpenChromeBrowser();
		}
		{
		if(Browser.equalsIgnoreCase("FireFox"))
		driver=TestBrowser.OpenFirefoxBrowser();
		}
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
		public static void OpenOrangeHRM() {
			driver.get("https://opensource-demo.orangehrmlive.com/");
			
		}
	
	
 
public static void Login(String userName, String password) throws Exception {
	findElement(By.name("txtUsername")).sendKeys(UserName);
	findElement(By.name("txtPassword")).sendKeys(password);
	findElement(By.id("btnLogin")).click();
	
}
public static   void National(String Nationality) throws Exception
{
	
	 
	findElement(By.linkText("Admin")).click();
	Thread.sleep(5000);
	findElement(By.linkText("Nationalities")).click();

	findElement(By.name("btnAdd")).click();
	findElement(By.id("nationality_name")).sendKeys(Nationality);
	findElement(By.id("btnSave")).click();
	
	
	
}
  
  
}
