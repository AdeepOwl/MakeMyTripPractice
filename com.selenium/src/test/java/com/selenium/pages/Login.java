package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import com.selenium.utilities.Utility;

public class Login {
	WebDriver driver;
	Utility utility;
	
	public Login(WebDriver driver){
		this.driver=driver;
	}

	public void login() {
		utility=new Utility(driver);
		String url =utility.navigateToUrl();
		driver.get(url);
	}

	public void validatePage() {
		String actualTitle=driver.getTitle();
		String expectedTitle="MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
		
		Assert.assertTrue(actualTitle.equals(expectedTitle));
		
	}

	public void invalidValidatePage(){
		String actualTitle=driver.getTitle();
		String expectedTitle="akeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
		try {
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("title is correct");
		}else {
			throw new Exception("Title not correct");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}

}
