package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	
	static WebDriver driver;
	
	@DataProvider(name = "cyr123")
	  public static Object[][] t1() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","api","api1 decc"},
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","api2","api2 decc"},
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","api3","api3 decc"},
	        	};
	}
	
  @Test(dataProvider="cyr123")
  public void provider(String url,String Username,String password,String jobtitle,String jobdesc) throws Exception {
	  
	  dataprovider.OpenChromeBrowser();
	  dataprovider.OpenOrangeHRM(url);
	  dataprovider.Login(Username,password);
	  dataprovider.Addskills(jobtitle,jobdesc);
	  
  }
	  
	  public static void OpenChromeBrowser() throws Exception {	
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.manage().window().maximize();
	  }
	  public static void OpenOrangeHRM(String url) throws Exception {	
		  
		  driver.get(url);
		    
	  }
	  public static void Login(String Username,String password) throws Exception {	
		  
		  driver.findElement(By.id("txtUsername")).sendKeys(Username);
		  driver.findElement(By.id("txtPassword")).sendKeys(password);
		  driver.findElement(By.id("btnLogin")).click();
		    
	}
	  public static void Addskills(String jobtitle,String jobdesc) throws Exception {
		  
		  driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
		  driver.findElement(By.xpath("//*[@id=\"menu_admin_Qualifications\"]")).click();
		  driver.findElement(By.id("menu_admin_viewSkills")).click();
		  driver.findElement(By.id("btnAdd")).click();
		  driver.findElement(By.id("skill_name")).sendKeys(jobtitle);
		  driver.findElement(By.id("skill_description")).sendKeys(jobdesc);
		  driver.findElement(By.id("btnSave")).click();  
	}

}
  

