package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Add_locations {

	WebDriver driver;
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String username="Admin",password="admin123";
	String addJobVacancy="test",hiringManager="test manage",jobtitle="EA";
  @Test
  public void Addcountry() throws Exception { 
	 
	  Add_locations E1=new Add_locations();
	  E1.OpenChromeBrowser();
	  E1.OpenOrangeHRM(TestURL);
	  E1.Login(username,password);
	  E1.Addlocations(addJobVacancy,hiringManager);
  }
  public void OpenChromeBrowser()throws Exception { 
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	
}
  public void OpenOrangeHRM(String TestURL)throws Exception { 
	  
	  driver.get(TestURL);
	  
  }
public void Login(String username,String password)throws Exception {
	
	findElement(By.id("txtUsername")).sendKeys(username);
	findElement(By.id("txtPassword")).sendKeys(password); 
	findElement(By.id("btnLogin")).click();
  }
public void Addlocations(String addJobVacancy,String hiringManager)throws Exception {
	
	findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/b")).click();
	findElement(By.id("menu_recruitment_viewJobVacancy")).click();
	findElement(By.id("btnAdd")).click();
	
	
	
	Select d1=new Select(findElement(By.id("addJobVacancy_jobTitle")));
	d1.selectByVisibleText("EA");
	
	findElement(By.id("addJobVacancy_name")).sendKeys(addJobVacancy);
	findElement(By.id("addJobVacancy_hiringManager")).sendKeys(hiringManager);
	
	
	findElement(By.id("btnSave")).click();

}
public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
	
}