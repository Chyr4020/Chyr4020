package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider2 {
	
	static WebDriver driver;
	
	@DataProvider(name = "cyr123") 
	Object[] myDataProvider() {
	  
	 
		
		      
		     Object data[][]=  new Object[2][6];
		     
		     
		     data[0][0]= "https://opensource-demo.orangehrmlive.com/"; 
		     data[0][1]= "Admin";
		     data[0][2]= "admin123";
		     data[0][3]= "s1";
		     data[0][4]= "s1 descr";
		     data[0][5]= "s1 Note";
		     
		     data[1][0]= "https://opensource-demo.orangehrmlive.com/"; 
		     data[1][1]= "Admin";
		     data[1][2]= "admin123";
		     data[1][3]= "c12";
		     data[1][4]= "c12 descr";
		     data[1][5]= "c12 Note";
			return data;
		     
		 }	      
	
  @Test(dataProvider="cyr123")
  public void provider(String url,String Username,String password,String jobtitle,String jobdesc,String jobnote) throws Exception {
	  
	  dataprovider2.OpenChromeBrowser();
	  dataprovider2.OpenOrangeHRM(url);
	  dataprovider2.Login(Username,password);
	  dataprovider2.Addskills(jobtitle,jobdesc,jobnote);
	  
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
	  public static void Addskills(String jobtitle,String jobdesc,String jobnote) throws Exception {
		  
		  driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
		  driver.findElement(By.xpath("//*[@id=\"menu_admin_Job\"]")).click();
		  driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		  driver.findElement(By.id("btnAdd")).click();
		  driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(jobtitle);
		  driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(jobdesc);
		  driver.findElement(By.xpath("jobTitle_note")).sendKeys(jobnote);
		  driver.findElement(By.id("btnSave")).click();  
	}

} 

