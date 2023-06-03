package com.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.exception.AutoFWConfigException;
import com.pages.HotelDetailsPage;
import com.pages.RoomDetailsPage;
import com.utility.Util;

import io.cucumber.java.en.Given;
import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */

@Log4j2
public class StepsRoomDetailsPage {

	WebDriver driver;

	RoomDetailsPage roomDetailsPage;

	public StepsRoomDetailsPage() throws AutoFWConfigException  {
		driver = Util.getDriver();
		roomDetailsPage = new RoomDetailsPage(driver);

	}
	
	
	@Given("User verifies hotel name {string}")
	public void userVerifiesHotelName(String expectedHotelName) {
		roomDetailsPage.validateHotelName(expectedHotelName);
		log.info(".........Hotel name matched!");
	}
	
	@Given("User clicks on Select room button")
	public void clickSelectRoomButton() {
		roomDetailsPage.clickSelectRoomButton();
		log.info(".........User clicks Select room button!");
	}
	@Given("User clicks on Book room button for desired room as per criteria {string}")
	public void clickBookRoomButton(String criteria) {
		roomDetailsPage.bookRoomAsPerCriteria(criteria);
	}
	/*@Given("User clicks on Book button")
	public void user_clicks_on_book_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/
	
	
}
