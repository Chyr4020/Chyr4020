package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class dataprovider_browser {
	
	static WebDriver driver;
	
	@DataProvider(name ="cyr12")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C:\\data\\Excel_Data.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
		     
		 }	      
	
  @Test(dataProvider ="cyr12")
  public void provider(String TestURL,String UserName,String Password,String Job_Title
,String Job_Description,String Job_Note) throws Exception 
  
  {
	  
	 
	 driver=TestBrowser.OpenChromeBrowser();
	  dataprovider_browser.OpenOrangeHRM(TestURL);
	  dataprovider_browser.Login(UserName,Password);
	  dataprovider_browser.Addskills(Job_Title,Job_Description,Job_Note);
  }
  
  
	  public static void OpenOrangeHRM(String TestURL) throws Exception {	
		  
		  driver.get(TestURL);
		    
	  }
	  public static void Login(String UserName,String Password) throws Exception {	
		  
		  driver.findElement(By.id("txtUsername")).sendKeys(UserName);
		  driver.findElement(By.id("txtPassword")).sendKeys(Password);
		  driver.findElement(By.id("btnLogin")).click();
		    
	}
	  public static void Addskills(String Job_Title,String Job_Description,String Job_Note) throws Exception {
		  
		  driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
		  driver.findElement(By.xpath("//*[@id=\"menu_admin_Job\"]")).click();
		  driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		  driver.findElement(By.id("btnAdd")).click();
		  driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(Job_Title);
		  driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(Job_Description);
		  driver.findElement(By.xpath("jobTitle_note")).sendKeys(Job_Note);
		  driver.findElement(By.id("btnSave")).click();  
	}

} 

