package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.stepdefinition.StepsHotelDetailsPage;
import com.web.BrowserManager;
import com.web.WebElementManager;

import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */

@Log4j2
public class RoomDetailsPage {

	WebDriver driver;
	WebElementManager wem ;
	
	//Select room button
	By selectRoom= By.xpath("//button[text()=\"Select room\"]//parent::div[@class=\"flex flex-nowrap\"]");
	
	// ------------------------------------- Workflow/Action methods  ------------------------------------------
	
	   public RoomDetailsPage(WebDriver driver) {
				this.driver=driver;
				wem=new WebElementManager(driver);
			}
	
	public void validateHotelName(String expectedHotelName) {
		
		String currentPageTitle= driver.getTitle();
		log.info("...........Current page title :- "+ currentPageTitle);
		String actualHotelName=driver.findElement(By.xpath("//h2[contains(text(),'"+expectedHotelName+"')]")).getText();
		log.info("Actual hotel name :- "+ actualHotelName);
		log.info("Expected hotel name :- "+ expectedHotelName);
		
		//Use of assertion to validate selected hotel name on the next page
		Assert.assertEquals(actualHotelName, expectedHotelName, "Hotel name matched!");
		
	}
	
	public void clickSelectRoomButton() {
		
		WebElement selectRoomButton=driver.findElement(selectRoom);
		wem.pause(2);
		wem.scrollToElement(selectRoomButton);
		//wem.waitforElementToBeclickable(Duration.ofSeconds(5), selectRoomButton);
		selectRoomButton.click();
		wem.pause(5);
		
	}
	
	public void bookRoomAsPerCriteria(String criteria) {
		
				wem.pause(5);	
				WebElement bookButtonDesiredRoom=driver.findElement(By.xpath("//h4[text()=\""+criteria+"\"]//ancestor::div[@class=\"flex-column w-100p\"]//following-sibling::div[@class=\"flex flex-between flex-top w-100p\"]//following-sibling::div[@class=\"flex nmt-1\"]/button"));
				wem.waitforElementToBeclickable(Duration.ofSeconds(5), bookButtonDesiredRoom);
				bookButtonDesiredRoom.click();
				wem.pause(5);
				BrowserManager.switchToNewTab(driver);
	}
	

}
