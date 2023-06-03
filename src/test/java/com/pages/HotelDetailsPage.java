package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.exception.AutoFWConfigException;
import com.exception.AutoFWException;
import com.web.BrowserManager;
import com.web.TabManager;
import com.web.WebElementManager;

import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */

@Log4j2
public class HotelDetailsPage {

	WebDriver driver;
	WebElementManager wem ;

	 

	// Price From
		By priceFrom = By.cssSelector("[data-testid=\"priceMin\"]");
		
	// Price To
		By priceTo = By.cssSelector("[placeholder=\"max\"]");
		
	//hotelClass
	   By hotelClass=By.cssSelector("[class=\"checkbox__input o-0\"]");
	
	//TripAdvisor Rating
	   By tripARatingSectionLabel=By.xpath("//p[text()=\"TripAdvisor rating\"]");
	   
	 //Hotel Class 
	   By hotelClassSectionLabel=By.xpath("//p[text()=\"Hotel class\"]");

	// ------------------------------------- Workflow/Action methods  ------------------------------------------
	
	   public HotelDetailsPage(WebDriver driver) {
			this.driver=driver;
			wem=new WebElementManager(driver);
			
		}
	   
	   public void enterPriceRangeCriteria(String minprice, String maxprice) {
		
		   WebElement pricefrom=driver.findElement(priceFrom);
		   wem.waitforElementToBeclickable(Duration.ofSeconds(5), pricefrom);
	
		   driver.findElement(priceFrom).clear();
		   driver.findElement(priceFrom).sendKeys(minprice);
		   driver.findElement(priceTo).clear();
		   driver.findElement(priceTo).sendKeys(maxprice);
		   wem.pause(2);
		   log.info(".........User entered min price: {}",minprice);
		   log.info(".........User entered max price: {}",maxprice);
		
		   
	   }
	   
	   public void selectHotelClass(String hclass) throws AutoFWConfigException {
		  // wem.pause(1);
		   WebElement hotelClassSection=driver.findElement(hotelClassSectionLabel);
		   wem.scrollToElement(hotelClassSection);
		   WebElement hotelClassCheckbox=driver.findElement(By.xpath("//input[@value=\""+hclass.toLowerCase()+"\"]/following-sibling::span"));
		   wem.pause(1);
		   wem.waitforElementToBeclickable(Duration.ofSeconds(5), hotelClassCheckbox);
		   //BrowserManager.browserRefresh();
		   hotelClassCheckbox.click();
			//wem.pause(5);
			log.info(".........User selected hotel class as :-" + hclass);
			//wem.pause(5);
			}
	   
	   
	   public void selectTripAdviorRating(String rating) throws AutoFWConfigException {
		   wem.pause(2);
		   WebElement tripAdvisorSection=driver.findElement(tripARatingSectionLabel);
		   wem.scrollToElement(tripAdvisorSection);
		   WebElement tripAdvisorRatingRadioButton=driver.findElement(By.xpath("//input[@id="+rating+"]/following-sibling::span"));
		   wem.pause(1);
		   wem.waitforElementToBeclickable(Duration.ofSeconds(5), tripAdvisorRatingRadioButton);
		   //BrowserManager.browserRefresh();
			tripAdvisorRatingRadioButton.click();
			wem.pause(5);
			log.info(".........User selected trip advisor rating as :-" + rating);
			//wem.pause(5);
			}
	
	   
	   public void selectHotel(String hotelName) throws AutoFWConfigException {
		   wem.pause(5);
		   
		   try {
			   
			 
			   WebElement hotelname=driver.findElement(By.xpath("//h2[text()=\""+hotelName+"\"]"));
			   wem.scrollToElement(hotelname);
			   WebElement tripAdvisorSection=driver.findElement(tripARatingSectionLabel);
			   wem.scrollToElement(tripAdvisorSection);
			   wem.pause(5);
			   //wem.waitforElementToBeclickable(Duration.ofSeconds(5), hotelname);
			   hotelname.click();
			   
			 //  WebElement viewDetailsButtonDesiredHotel=driver.findElement(By.xpath("//h2[text()=\""+hotelName+"\"]//ancestor::div[@class=\"\"]//following-sibling::div[@class=\"flex flex-between\"][2]//following-sibling::div[@class=\"flex flex-middle\"]/button"));
			   //wem.scrollToElement(viewDetailsButtonDesiredHotel);
		
			   
			   wem.pause(5);
			   TabManager.switchToNewTab(driver);
		   		
		   }catch(NoSuchElementException e) {
			   throw new AutoFWException("Hotel name does not exist in the search list!");
		   }
		  
			log.info(".........User selected hotel :-" + hotelName);
			//wem.pause(5);
			}
	   
	   
}



