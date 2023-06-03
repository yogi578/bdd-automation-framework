package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testdata.CorporateSignUpTestData;
import com.testdata.TestDataOperations;
import com.web.WebElementManager;

import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */

@Log4j2
public class CorporateSignUpPage {

	WebDriver driver;
	WebElementManager wem ;
	
		// company name
			By companyName = By.xpath("//input[@data-schemaname=\"Company\"]");
					
		
			
		// first name
			By firstName = By.xpath("//input[@data-schemaname=\"FirstName\"]");
			
		//last name
		   By lastName=By.xpath("//input[@data-schemaname=\"LastName\"]");
		
		//address
		   By address=By.xpath("//input[@data-schemaname=\"mx_Address\"]");
		   
		 //city
		   By city=By.xpath("//input[@data-schemaname=\"mx_City\"]");
		   
		   //pan card no
		   By panCardNo=By.xpath("//input[@data-schemaname=\"mx_Pan_Card_Number\"]");
		   
		   //email
		   By email=By.xpath("//input[@data-schemaname=\"EmailAddress\"]");
		   
		   //email
		   By mobileNo=By.xpath("//label[contains(text(),'Phone Number')]/../../span/div/input[2]");
		   
		   By signUp = By.xpath("//button[text()='Sign Up']");
		   
		   
	
	// ------------------------------------- Workflow/Action methods  ------------------------------------------
	
		   public CorporateSignUpPage(WebDriver driver) {
				this.driver=driver;
				wem=new WebElementManager(driver);
			}
		   
		   public void getCorporateDetailsPage(String url) {
			   driver.get(url);
			   wem.pause(5);
		   }
		   
		   public void enterCompanyName(String companyNameValue) {
			   
			   WebElement cmpName= driver.findElement(companyName);
			   wem.scrollToElement(cmpName);
			   wem.waitforElementToBeclickable(Duration.ofSeconds(30), cmpName);
			   cmpName.sendKeys(companyNameValue);
			 //  driver.findElement(companyName).sendKeys(companyNameValue);
		   }
		   
		   public void enterFirstName(String firstNameValue) {
			   driver.findElement(firstName).sendKeys(firstNameValue);
		   }
		   
		   public void enterLastName(String lastNameValue) {
			   driver.findElement(lastName).sendKeys(lastNameValue);
		   }
		   
		   public void enterAddress(String addressValue) {
			   driver.findElement(address).sendKeys(addressValue);
		   }
		   
		   public void enterCity(String cityValue) {
			   driver.findElement(city).sendKeys(cityValue);
		   }
		   public void enterPan(String panValue) {
			   driver.findElement(panCardNo).sendKeys(panValue);
		   }
		   
		   public void enterEmail(String emailValue) {
			   driver.findElement(email).sendKeys(emailValue);
		   }
		   public void enterMobileNo(String mobileNoValue) {
			   driver.findElement(mobileNo).sendKeys(mobileNoValue);
		   }
		   public void clicksOnSignUp() {
			   WebElement signUpBtn= driver.findElement(signUp);
			   wem.waitforElementToBeclickable(Duration.ofSeconds(30), signUpBtn);
			   wem.scrollToElement(signUpBtn);
			   driver.findElement(signUp).click();
		   }
		   
		   
	
		   
		   
}
