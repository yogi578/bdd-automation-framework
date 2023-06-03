package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import com.web.BrowserManager;
import com.web.WebElementManager;

import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */
@Log4j2
public class BookingDetailsPage {

	WebDriver driver;
	WebElementManager wem ;
	
	//Select room button
	By mobileNumberTextbox= By.xpath("//input[@data-testid=\"mobileNumber\"]");
	By emailAdddressTextbox= By.xpath("//input[@data-testid=\"email\"]");
	
	//Room1 Info
	By userTitle= By.xpath("//span[text()=\"Title\"]");
	By titleValue= By.xpath("//li[text()=\"Mr.\"]");
	By firstName= By.xpath("//input[@name=\"firstName\"]");
	By lastName= By.xpath("//input[@name=\"lastName\"]");
	By specialRequest=By.xpath("//p[text()=\"Special requests for your booking\"]");

	//Continue to Pay button
	By continueToPay= By.xpath("//button[text()=\"Continue to payment\"]");
	
	// ------------------------------------- Workflow/Action methods  ------------------------------------------
	
	   public BookingDetailsPage(WebDriver driver) {
				this.driver=driver;
				wem=new WebElementManager(driver);
			}
	   
	   
		public void validateBookingPageLoads() {
			
			String currentPageTitle= driver.getTitle();
			log.info(".........Current page title :- "+ currentPageTitle);
			Assert.assertEquals(currentPageTitle, "Online Hotel Booking | Book Luxury, Budget and Cheap Hotels","You are on booking page!");	
		}
		
		public void enterMobileNumber(String mobileNo) {
			
			WebElement mobileNumber=driver.findElement(mobileNumberTextbox);
			wem.scrollToElement(mobileNumber);
			mobileNumber.sendKeys(mobileNo);
			log.info(".........User entered mobileNumber :-" + mobileNo);
		}		
		
		
		public void enterEmail(String emailAdddress) {
			
			WebElement emailId=driver.findElement(emailAdddressTextbox);
			wem.scrollToElement(emailId);
			emailId.sendKeys(emailAdddress);
			log.info(".........User entered email adddress :-" + emailAdddress);
		}		

		public void enterTitle(String title) {
			wem.pause(1);
			WebElement usertitle=driver.findElement(userTitle);
			wem.scrollToElement(usertitle);
			WebElement specialR=driver.findElement(specialRequest);
			wem.pause(1);
			wem.scrollToElement(specialR);
			wem.pause(2);
			usertitle.click();
			driver.findElement(titleValue).click();
		}
		public void enterFirstName(String fName) { 
			driver.findElement(firstName).sendKeys(fName);
			log.info(".........User entered first name :-" + fName);
		}
		
		public void EnterLastName(String lName) {
			driver.findElement(lastName).sendKeys(lName);
			log.info(".........User entered last name :-" + lName);
		}
		
		
		// Click on continue to Pay button
		public void continueToPay() {
		WebElement continueButton=driver.findElement(continueToPay);
		//wem.scrollToElement(continueButton);
		log.info(".........User clicked on continue to pay button!");
		driver.findElement(continueToPay).click();
		wem.pause(5);
		 BrowserManager.switchToNewTab(driver);
	}
		
		public void validatePaymentPage() {
			
			String currentPageTitle= driver.getTitle();
			log.info(".........Current page title :- "+ currentPageTitle);
			Assert.assertEquals(currentPageTitle, "Cleartrip | Pay securely","Payment page tile matched!");	
		}
}
