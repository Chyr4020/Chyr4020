package cyr_prac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Day_034_TestNG_Listeners.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class web_table {
	
	WebDriver driver;
	
	
	
	
@BeforeTest
public void OpenBrowser()throws Exception{
driver=TestBrowser.OpenChromeBrowser();
String TestURL="https://opensource-demo.orangehrmlive.com/";
driver.get(TestURL);
}
@Test
  public void ip()throws Exception {
	 Login2 l2=new Login2(); 
	 l2. Login2(driver);
	 l2. Login();
	 
	 Addskills1 s1=new Addskills1();
	 s1. Addskills1(driver);
	 s1.Addskills();
  }
  public WebElement findElement(By by)throws Exception {
	    WebElement elem = driver.findElement(by);
	 
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	    } 
	    Thread.sleep(1000);
	    
	    return elem;
	}

  public  void ExportEmployees()throws Exception
	{ 
		 
      //No. of columns
		 String Empcoloums="//*[@id=\'recordsListTable\']/thead/tr/th";
		 List<WebElement>  columns = driver.findElements(By.xpath(Empcoloums)); 
	      System.out.println("No of columns in WebTable : " + columns.size());

	   
		 
		 
      //No.of rows 
		 String EmpRows=" //*[@id=\'recordsListTable\']/tbody/tr/td[2]";
      List<WebElement>   rows = driver.findElements(By.xpath(EmpRows)); 
      System.out.println("No of rows in WebTable : " + rows.size());
      
      ExcelApiTest4 eat = new ExcelApiTest4();
		
	    for ( int i=1 ; i<=75 ;i++)  // i=1;  1<=40 ; i=i+1
	    {
	    	  for ( int j=2 ,k=0; j<=3 ;j++,k++) //j=2 ; J<=8 ; j++
	    	   {
	      		   String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
	      		   
	      	
	      		   
	      		   //*[@id="resultTable"]/tbody/tr[1]/td[2]
	      		   
	      		    //*[@id="resultTable"]/tbody/tr[1]/td[2]
	    		    WebElement Ele=findElement(By.xpath(str1));
	    		    
	    		    Thread.sleep(5000);
	    		   
	    	        String WebElementText = Ele.getText();
	    	       //System.out.println("Get Text Value is from the WebElement: " + valueIneed1);
	    	        
	    	        if (WebElementText !=null)
	    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//Import01.xlsx","Sheet1",i,k,WebElementText);
	    	        else
	    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//Import01.xlsx","Sheet1",i,k,"Blank Data");
	    	        	
	    	   }
	    }
	    

}

}

