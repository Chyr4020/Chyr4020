package cyr_prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Day_034_TestNG_Listeners.TestBrowser;

public class Pageobject01_skills {
	
WebDriver driver;
@BeforeTest
public void OpenBrowser()throws Exception{
driver=TestBrowser.OpenChromeBrowser();
String TestURL="https://opensource-demo.orangehrmlive.com/";
driver.get(TestURL);
}

  @Test
  public void f()throws Exception {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	Login2 L1=new Login2();
	L1.Login2(driver);
	L1.Login();
	
	Add_locations2 a1=new Add_locations2();
	a1.Add_locations2(driver);
	a1.Add_locations();
	
  }
 
}
