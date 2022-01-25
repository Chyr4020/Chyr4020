package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;

public class Excel_Dataprovider {
	static WebDriver driver;
	@DataProvider(name="ten")
	 public static Object[][] Test1() throws Exception {
		
		ExcelApiTest4 Job = new ExcelApiTest4();
		Object[][] testObjArray = Job.getTableArray("C:\\data\\Excel_Data.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
  @Test(dataProvider="ten")
  public void Excel(String TestURL,String UserName,String Password,String Job_Title,String Job_Description,String Job_Note)throws Exception 
  {

		  Excel_Dataprovider.OpenChromeBrowser();
		  Excel_Dataprovider.OpenOrangeHRM(TestURL);
		  Excel_Dataprovider.Login(UserName,Password);
		  Excel_Dataprovider.Addjobs(Job_Title,Job_Description,Job_Note);
		  
  }
	
 public static void OpenChromeBrowser()throws Exception { 
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	
}
 public static void OpenOrangeHRM(String TestURL)throws Exception { 
	  
	  driver.get(TestURL);
	  
  }
  
  public static void Login(String UserName,String Password) throws Exception
	{
	  driver.findElement(By.id("txtUsername")).sendKeys(UserName);
	  driver.findElement(By.id("txtPassword")).sendKeys(Password);
	  driver.findElement(By.id("btnLogin")).click();
	}
  public static void Addjobs(String Job_Title,String Job_Description,String Job_Note)throws Exception 
  {
		
	  driver.findElement(By.xpath("//*[@id=\'menu_admin_viewAdminModule\']/b")).click();
	  driver.findElement(By.id("menu_admin_Job")).click();
	  driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
	  driver.findElement(By.id("btnAdd")).click();
	  driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(Job_Title);
	  driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(Job_Description);
	  driver.findElement(By.id("jobTitle_note")).sendKeys(Job_Note);
	  driver.findElement(By.id("btnSave")).click();
  }
}
