package cyr_prac;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonUtil.TestBrowser;
import Day_009_Extent_Reports.ExtentReport;

public class extended_report {
	WebDriver driver;
	
	ExtentTest logger;
	 ExtentReports extent; 
	 String screenShotPath;
	 public static String TestScriptName = "amazon";
	 public static String TestName;
  @Test
  public void Extend() throws Exception {
	  
	  driver=TestBrowser.OpenChromeBrowser();
	// step3 start here - ExtendsHtmlReport starts
			 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
			 Date now = new Date();
			 String strDate = sdfDate.format(now);
			 
			 TestName=TestScriptName+"_"+strDate+".html";
			 TestScriptName=TestScriptName+"_"+strDate;
			  String TestHtmlName="C:/HTML Report/test-output/ExtentReportScreenShots/"+ TestScriptName +"/"+TestName;
			  
			 //String TestHtmlName=TestName;
			 ExtentHtmlReporter reporter=new ExtentHtmlReporter(TestHtmlName);
			 
			 System.out.println("Html Report path is : "+TestHtmlName);
			 
			 extent=new ExtentReports();
			 extent.attachReporter(reporter);
			 logger=extent.createTest(TestName);
			
			
	  
			 String TestURL = "https://www.amazon.in/";
				driver.get(TestURL);
	  
	  findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
		screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("pass_hello sighin",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		

		findElement(By.id("ap_email")).sendKeys("8886784020");	
		screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("pass_enter mobile number",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		
		findElement(By.id("continue")).click();
		screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.fail("pass_click on continue",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		findElement(By.id("ap_password")).sendKeys("Chepyala@12");	
		screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("pass_enter password",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		findElement(By.id("signInSubmit")).click();
		screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.fail("pass_click on signin",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
extent.flush();
		
		
		driver.close();
  }		
		//Step4
		
		public  WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			// draw a border around the found element
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
  
  
}
}
