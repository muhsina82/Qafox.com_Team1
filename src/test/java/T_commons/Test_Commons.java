package T_commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

public class Test_Commons {

	public WebDriver driver;
	
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
	 
	
	public void SwitchToOpenWindow (String Parent) {
		Set<String> wins= driver.getWindowHandles();
		 for (String sesid:wins) {
			 if (sesid!=Parent) {
				 driver.switchTo().window(sesid);
			 }
		 }
	}
	


	public void WaitForElementClickable(WebElement elementVariable) {
		
		WebDriverWait wait= new WebDriverWait (driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(elementVariable));
		
	}
	
	public void PageTitle(String PageTitle) {
		
		WebDriverWait wait= new WebDriverWait (driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(PageTitle));
	}
	
	//Click
	
	   public void Click (WebElement element)  {
			
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			jsExecutor.executeScript("arguments[0].click()", element);	
	   }
		
		//Scroll upto element
		public void ScrollInToView (WebElement element)  {
			
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

	}
		//Scroll bottom of the page
		public void ScrollPageDown(WebElement element) {
			
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)", element);
			
			
		}
		
		//Flashing or Blinking
			public void ChangeColor (String color, WebElement element)  {
				
				JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
				jsExecutor.executeScript("arguments[0].style.backgroundColor='" + color + "'" , element);
				
				try {
					Thread.sleep(2000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
		
	}
	         public void flash (WebElement element)  {
				String bgcolor= element.getCssValue("backgroundColor");
				System.out.println(bgcolor);
				
				for(int i=0; i<20; i++) {
					ChangeColor ("#FF0000",element);
					ChangeColor (bgcolor,element);
				}
		
	         }

	         public void drawBorder (WebElement element)  {
	        	 JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
	 			//jsExecutor.executeScript("arguments[0].style.border='3px solid red'" , element);
	 			jsExecutor.executeScript("arguments[0].style.border='5px solid green'" , element);
				
		
	}
	         
	         public void generateAlret (String message)  {
	        	 JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
	 			jsExecutor.executeScript("alert('"+ message +"')");
				
		
	}
	        public void ExplicitWait(WebElement element) {
	        	 
	        WebDriverWait ExWait= new WebDriverWait(driver,Duration.ofSeconds(30));
	 		ExWait.until(ExpectedConditions.elementToBeClickable(element));
	         
	         }
}