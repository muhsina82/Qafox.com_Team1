package TestNG_Utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Registration_Muhsina.NewsletterSubscription;
import T_commons.Test_Commons;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Utilities extends Test_Commons{

	public WebDriver driver;

	
  @AfterMethod
  public void afterMethod() throws IOException {
	  
	  Screenshot("Registration_picture");
	  
  }

  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  
	  IBrowsers("Chrome", "https://tutorialsninja.com/demo/index.php?route=account/register");
	  
	 
	  
  }
  
  
@AfterClass
  public void afterClass() {
	  
	  
  //driver.close();
  
  
  }



}