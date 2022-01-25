package cyr_prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Day_034_TestNG_Listeners.TestBrowser;

public class Pagefactory_skill {
	
WebDriver driver;
@BeforeTest
public void OpenBrowser()throws Exception{
driver=TestBrowser.OpenChromeBrowser();
String TestURL="https://opensource-demo.orangehrmlive.com/";
driver.get(TestURL);
}

  @Test
  public void f()throws Exception {
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	Login2 L2=new Login2();
	L2.Login2(driver);
	L2.Login();
	
	skills A1=new skills();
	A1.skills(driver);
	A1.Addskills();
  }
 
}
