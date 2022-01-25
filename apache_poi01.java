package cyr_prac;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class apache_poi01 {
	
	public WebDriver driver;
	
	public FileInputStream fis;	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	 String TestUrl,username,password,skillname,skilldescription;
  @Test
  public void Data() throws Exception {
	 
	  apache_poi01 input=new apache_poi01();
	  
	  TestUrl=input.getCellData("C:\\HTML Report\\OrangeHRM6\\TC01_Skills_14.xlsx","Sheet1",1,0);
	username=input.getCellData("C:\\\\HTML Report\\\\OrangeHRM6\\\\TC01_Skills_14.xlsx","Sheet1",1,1);
	password=input.getCellData("C:\\\\HTML Report\\\\OrangeHRM6\\\\TC01_Skills_14.xlsx","Sheet1",1,2);
	skillname=input.getCellData("C:\\\\HTML Report\\\\OrangeHRM6\\\\TC01_Skills_14.xlsx","Sheet1",2,3);
	skilldescription=input.getCellData("C:\\\\HTML Report\\\\OrangeHRM6\\\\TC01_Skills_14.xlsx","Sheet1",1,4);
	
	 System.out.println("TestURL Cell Value is :"+TestUrl);
	 System.out.println("UserName Cell Value is :"+username);
	 System.out.println("Password Cell Value is :"+password);
	 System.out.println("skillname Cell Value is :"+skillname);
	 System.out.println("skilldescription Cell Value is :"+skilldescription);
	
	 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
     driver =new ChromeDriver();
	 driver.manage().window().maximize() ;	
	 driver.get(TestUrl);
	 
	 findElement(By.name("txtUsername")).sendKeys(username);
	 findElement(By.name("txtPassword")).sendKeys(password);
	 findElement(By.id("btnLogin")).click();
	findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
	findElement(By.xpath("//*[@id=\"menu_admin_Qualifications\"]")).click();
	  findElement(By.id("menu_admin_viewSkills")).click();
	  findElement(By.id("btnAdd")).click();
	 findElement(By.id("skill_name")).sendKeys(skillname);
	 findElement(By.id("skill_description")).sendKeys(skilldescription);
	  findElement(By.id("btnSave")).click();
	
  }
  
  public String getCellData(String xlFilePath,String sheetName,int rowNum,int column) throws Exception
  {
  	fis = new FileInputStream(xlFilePath);  //excel File path
      workbook = new XSSFWorkbook(fis);   // workbook open
      sheet = workbook.getSheet(sheetName); //Sheet1 open
      row = sheet.getRow(rowNum); // 1st will be highlighted
      cell = row.getCell(column); // 1th column will be highlited
     
      if(cell.getCellTypeEnum() == CellType.STRING)
      {	
      	String str6=cell.getStringCellValue();
      	System.out.println("Cell Value is :"+str6);
      	
      	workbook.close();
      	fis.close();
          return str6;
      }
      
      else if(cell.getCellTypeEnum() == CellType.NUMERIC)
      {	
      	
      	int i = (int)cell.getNumericCellValue(); 
      	
      	String str6 = String.valueOf(i); 
      	workbook.close();
      	fis.close();
          return str6;
      }
      else 
      {
      	String str6=cell.getStringCellValue();
      	workbook.close();
      	fis.close();
          return str6;
      }
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
