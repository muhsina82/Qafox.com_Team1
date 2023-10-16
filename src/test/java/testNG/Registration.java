package testNG;


import org.testng.annotations.Test;

import Registration_Muhsina.NewsletterSubscription;
import TestNG_Utilities.Utilities;



public class Registration extends Utilities{
	

	
  @Test
  public void f() throws InterruptedException {
	  
	  NewsletterSubscription NLS = new NewsletterSubscription(driver);
	  
	
	  NLS.visibleNewsLetterBtn();
	  Thread.sleep(2000);
	  NLS.ClickButton();
	  
  }
  
  
}
