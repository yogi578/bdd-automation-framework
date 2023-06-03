package com.pages;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.exception.AutoFWConfigException;
import com.utility.Util;
import com.web.BrowserManager;

import com.web.WebElementManager;

import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */

@Log4j2
public class HotelSearchPage {	

	WebDriver driver;
	WebElementManager wem ;
	


	// Close button default pop-up
	By closeIcon = By.xpath("//div[@class=\" px-1 flex flex-middle nmx-1 pb-1\"]");

	// Destination text box
	By destinationTextBox = By.name("search");

	// Check in date field
	By checkInDateField = By.xpath("//*[@tabindex=\"2\"][@variant=\"select\"]/div[1]");

	// Check out date field
	By checkOutDateField = By.xpath("//*[@tabindex=\"3\"][@variant=\"select\"]/div[1]");

	// Rooms and guest criteria field
	By roomsGuestCriteriaField = By.xpath("//*[@tabindex=\"4\"][@variant=\"select\"]/div[1]");

	// Search hotels button
	By searchHotelsButton = By.xpath("//div[text()=\"Search hotels\"]");
	

	// ------------------------------------- Workflow/Action methods  ------------------------------------------

		public HotelSearchPage(WebDriver driver) {
		this.driver=driver;
		wem= new WebElementManager(driver);
		
	}
	
	// Open default hotel search page
		public void openDefaultHotelSearchPage(String url) {
		driver.get(url);
		driver.findElement(closeIcon).click();
	}

	// Enter destination
		public void enterDestination(String destination) {
		driver.findElement(destinationTextBox).sendKeys(destination);
		log.info(".........User entered destination :-" + destination);
		WebElement destinationField = driver.findElement(By.xpath("//*[contains(text(),'Popular destinations')]/following-sibling::li/p[contains(text(),'"+ destination + "')]"));
		destinationField.click();

	}

	// Enter check in date
		public void enterCheckInDate(Date checkInDate) throws AutoFWConfigException {
		log.info(".........User entered checkin date : {} ",Util.dateToString("E MM dd yyyy", checkInDate));
		driver.findElement(checkInDateField).click();
		WebElement checkindate = driver.findElement(By.xpath("//div[@aria-label=\"" +Util.dateToString("E MMM dd yyyy", checkInDate)+ "\"]//div[text()=" + Util.dateToString("dd", checkInDate) + "]"));
		wem.scrollToElement(checkindate);
		wem.pause(1);
		checkindate.click();

	}

	// Enter check out date
		public void enterCheckOutDate(Date checkOutDate) throws AutoFWConfigException {
		log.info(".........User entered checkout date : {} ",Util.dateToString("E MM dd yyyy", checkOutDate));
		WebElement checkoutdate = driver.findElement(By.xpath("//div[@aria-label=\"" +Util.dateToString("E MMM dd yyyy", checkOutDate)+ "\"]//div[text()=" + Util.dateToString("dd", checkOutDate) + "]"));
		wem.scrollToElement(checkoutdate);
		wem.waitforElementToBeclickable(Duration.ofSeconds(5), checkoutdate);
		wem.pause(1);
		checkoutdate.click();

	}

	// Enter rooms and guest criteria
		public void selectRoomAndGuestCriteria(String criteria) {

		WebElement destinationtextbox = driver.findElement(destinationTextBox);
		wem.scrollToElement(destinationtextbox);
		wem.pause(1);
		driver.findElement(roomsGuestCriteriaField).click();
		WebElement guestroomcriteriaoption = driver.findElement(By.xpath("//li[text()=\"" + criteria + "\"]"));
		log.info(".........User selected guest & rooms criteria as :-" + criteria);
		guestroomcriteriaoption.click();
	
	}

	// Click on search hotels button
		public void searchHotels() {
		log.info(".........User clicked on search button!");
		driver.findElement(searchHotelsButton).click();
		wem.pause(2);
	}

}
