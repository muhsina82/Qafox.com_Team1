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



import Registration_2.NewsletterSubscription;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Utilities {

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


public void IBrowsers(String NameOfBrowser, String url ) {
	String ud=System.getProperty("user.dir");
	System.out.println(ud);
	if (NameOfBrowser.equalsIgnoreCase("Chrome")) {
		
	System.setProperty("webdriver.chrome.driver", ud+"\\Drivers\\chromedriver.exe");
	
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(url);
	driver.manage().window().maximize();
		
	}
	
	else if (NameOfBrowser.equalsIgnoreCase("Edge")) {
	
	System.setProperty("webdriver.edge.driver",ud +"\\Drivers\\msedgedriver.exe");
	driver= new EdgeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	
	}


}

public void Screenshot(String folder) throws IOException {
	
	Date object= new Date();
	System.out.println(object);
	
	String DFile= object.toString().replace(" ", "_").replace(":", "_");
	System.out.println(DFile);
	
	File HomePageSS =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	FileHandler.copy(HomePageSS,new File("D:\\QA\\Eclipse\\Qafox.com_Team1\\Screenshots\\"+folder+"\\" +DFile+" Home.jpg"));
	
	
}
 
}