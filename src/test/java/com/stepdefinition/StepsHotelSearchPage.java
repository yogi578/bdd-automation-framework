package com.stepdefinition;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;

import com.exception.AutoFWConfigException;
import com.exception.AutoFWException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.pages.HotelDetailsPage;
import com.pages.HotelSearchPage;
import com.utility.Util;
import com.web.BrowserManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */

@Log4j2
public class StepsHotelSearchPage {

	WebDriver driver;

	HotelSearchPage hotelSearchPage;

	public StepsHotelSearchPage() throws AutoFWConfigException  {
		driver = Util.getDriver();
		hotelSearchPage = new HotelSearchPage(driver);

	}

	@Given("User navigates to cleartrip search hotels page {string}")
	public void user_navigates_to_cleartrip_search_hotels_page(String url) {
	    hotelSearchPage.openDefaultHotelSearchPage(url);
	}

	@Given("User enters location as {string}")
	public void enterLocation(String string) {
		hotelSearchPage.enterDestination(string);
	}

	@Given("User enters check in date as {string}")
	public void enterCheckInDate(String string) throws  AutoFWConfigException {

		hotelSearchPage.enterCheckInDate(Util.stringToDate("dd/MM/yyyy", string));
	}

	@Given("User enters check out date as {string}")
	public void enterCheckoutDate(String string) throws  AutoFWConfigException {
		
		hotelSearchPage.enterCheckOutDate(Util.stringToDate("dd/MM/yyyy", string));
	}

	@Given("User enters rooms and guest as  {string}")
	public void enterGuestAndRooms(String string) {
		hotelSearchPage.selectRoomAndGuestCriteria(string);
	}

	@When("User clicks on Search hotels button")
	public void clickSearchHotelButton()  {
		hotelSearchPage.searchHotels();
	}

}
