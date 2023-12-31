package M_commons;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main_Commons {

	public WebDriver driver;
	
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
			public void ChangeColor (String color, WebElement element , WebDriver driver)  {
				
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
					ChangeColor("#FF0000",element,driver);
					ChangeColor(bgcolor,element,driver);
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
	        	 
	        WebDriverWait ExWait= new WebDriverWait(driver, Duration.ofSeconds(30));
	 		ExWait.until(ExpectedConditions.elementToBeClickable(element));
	         
	         }
}