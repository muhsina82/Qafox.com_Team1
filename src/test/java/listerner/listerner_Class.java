package listerner;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import TestNG_Utilities.Utilities;


public class listerner_Class extends Utilities implements ITestListener {
	
	

	@Override
	public void onTestSuccess(ITestResult result) {
		
		this.driver= ((Utilities)result.getInstance()).driver;
		
		try {
			Screenshot("Passed");
		} catch (IOException e) {
			e.printStackTrace();
		}



	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		this.driver= ((Utilities)result.getInstance()).driver;
		try {
			Screenshot("Failed");
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void onTestSkipped (ITestResult result) {
		
		this.driver= ((Utilities)result.getInstance()).driver;


	}
	
	

}
	


