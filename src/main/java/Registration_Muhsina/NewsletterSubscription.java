package Registration_Muhsina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import M_commons.Main_Commons;







public class NewsletterSubscription extends Main_Commons {
	
	
	
	@FindBy (linkText = "Newsletter") WebElement Newsletter;
	@FindBy (xpath = "(//input[@value='1'])[2]") WebElement YesButton;
	@FindBy (xpath = "(//input[@value='0'])") WebElement NoButton;
	
	

	public void visibleNewsLetterBtn() {
		
		ExplicitWait(Newsletter);
		ScrollInToView(Newsletter);


		
		ExplicitWait(Newsletter);
		drawBorder(Newsletter);
		
	}
	



	public void ClickButton() {
		
		ExplicitWait(Newsletter);
		YesButton.click();

		NoButton.click();
		
		
	}

     public NewsletterSubscription(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		
	}
	
}
