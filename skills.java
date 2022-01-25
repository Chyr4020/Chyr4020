package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class skills {
	
	WebDriver driver;
  
  public void skills(WebDriver driver) 
  {
	  this.driver=driver;
	  PageFactory.initElements(driver,this);
  }
  public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
  @FindBy(xpath="//*[@id=\'menu_admin_viewAdminModule\']/b")
  WebElement Admin;
  
  @FindBy(id="menu_admin_Qualifications")
  WebElement Qualification;
  
  @FindBy(id="menu_admin_viewSkills")
  WebElement Viewskills;
  
  @FindBy(id="btnAdd")
  WebElement Add;
  
  @FindBy(id="skill_name")
  WebElement Name;
  
  @FindBy(id="skill_description")
  WebElement Desc;
  
  @FindBy(id="btnSave")
  WebElement Save;
  
  public void Addskills() throws Exception
  {
	
	  Admin.click();
	  Qualification.click();
	  Viewskills.click();
	  Add.click();
	  Name.sendKeys("sel");
	  Desc.sendKeys("sel decc");
	  Save.click();
	  
  }
  
}
