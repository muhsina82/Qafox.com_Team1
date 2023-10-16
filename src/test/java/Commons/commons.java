package Commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commons  {
	

	public WebDriver driver;
	public String ud=System.getProperty("user.dir");
	 
	  public void IBrowsers(String NameOfBrowser, String url ) {
			String ud=System.getProperty("user.dir");
			if (NameOfBrowser.equalsIgnoreCase("Chrome")) {
				
			System.setProperty("webdriver.chrome.driver", ud+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
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
	  
	  public void Screenshot(String Folder) throws IOException {
			
			Date object= new Date();
			System.out.println(object);
			
			String DFile= object.toString().replace(" ", "_").replace(":", "_");
			System.out.println(DFile);
			
			File HomePageSS =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileHandler.copy(HomePageSS,new File("D:\\QA\\Eclipse\\Qafox.com_Team1\\Screenshots\\"+Folder+"\\" +DFile+" Home.jpg"));
			
			
	}
	
	
	public void SwitchToOpenWindow (String Parent, WebDriver driver) {
		Set<String> wins= driver.getWindowHandles();
		 for (String sesid:wins) {
			 if (sesid!=Parent) {
				 driver.switchTo().window(sesid);
			 }
		 }
	}
	


	public void WaitForElementClickable(WebElement elementVariable, WebDriver driver) {
		
		WebDriverWait wait= new WebDriverWait (driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(elementVariable));
		
	}
	
	public void PageTitle(String PageTitle, WebDriver driver) {
		
		WebDriverWait wait= new WebDriverWait (driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(PageTitle));
	}
	
	//Click
	
	   public static void Click (WebDriver driver, WebElement element)  {
			
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			jsExecutor.executeScript("arguments[0].click()", element);	
	   }
		
		//Scroll upto element
		public static void ScrollInToView (WebDriver driver, WebElement element)  {
			
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

	}
		//Scroll bottom of the page
		public static void ScrollPageDown(WebDriver driver) {
			
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			
			
		}
		
		//Flashing or Blinking
			public static void ChangeColor (String color, WebElement element , WebDriver driver)  {
				
				JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
				jsExecutor.executeScript("arguments[0].style.backgroundColor='" + color + "'" , element);
				
				try {
					Thread.sleep(2000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
		
	}
	         public static void flash (WebElement element , WebDriver driver)  {
				String bgcolor= element.getCssValue("backgroundColor");
				System.out.println(bgcolor);
				
				for(int i=0; i<20; i++) {
					ChangeColor("#FF0000",element,driver);
					ChangeColor(bgcolor,element,driver);
				}
		
	         }

	         public static void drawBorder (WebElement element , WebDriver driver)  {
	        	 JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
	 			//jsExecutor.executeScript("arguments[0].style.border='3px solid red'" , element);
	 			jsExecutor.executeScript("arguments[0].style.border='5px solid green'" , element);
				
		
	}
	         
	         public static void generateAlret (WebDriver driver, String message)  {
	        	 JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
	 			jsExecutor.executeScript("alert('"+ message +"')");
				
		
	}
	        public static void ExplicitWait(WebElement element, WebDriver driver) {
	        	 
	        WebDriverWait ExWait= new WebDriverWait(driver,Duration.ofSeconds(10));
	 		ExWait.until(ExpectedConditions.elementToBeClickable(element));
	         
	         }
}