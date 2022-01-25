package cyr_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Add_locations2 {

	WebDriver driver;
	public void Add_locations2 (WebDriver driver) {
		this.driver=driver;
	}
  
  public void Add_locations() throws Exception { 
	 
	  
	
  
	findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/b")).click();
	findElement(By.id("menu_recruitment_viewJobVacancy")).click();
	findElement(By.id("btnAdd")).click();
	
	
	
	Select d1=new Select(findElement(By.id("addJobVacancy_jobTitle")));
	d1.selectByVisibleText("EA");
	
	findElement(By.id("addJobVacancy_name")).sendKeys("SE");
	findElement(By.id("addJobVacancy_hiringManager")).sendKeys("SE Manager");
	
	
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