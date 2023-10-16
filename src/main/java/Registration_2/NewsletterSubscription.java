package Registration_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.Commons;



public class NewsletterSubscription extends Commons {
	
	
	
	@FindBy (linkText = "Newsletter") WebElement Newsletter;
	@FindBy (xpath = "(//input[@value='1'])[2]") WebElement YesButton;
	@FindBy (xpath = "(//input[@value='0'])") WebElement NoButton;
	
	

	public void visibleNewsLetterBtn() {
		
		ScrollPageDown(driver);
		ExplicitWait(Newsletter, driver);
		
		drawBorder(Newsletter,driver);
		
	}
	
	public void ClickButton() {
		
		ExplicitWait(Newsletter, driver);
		YesButton.click();
		
		ExplicitWait(Newsletter, driver);
		NoButton.click();
		
		
	}

     public NewsletterSubscription(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		
	}
	
}
