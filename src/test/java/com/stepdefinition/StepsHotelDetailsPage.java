package com.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.exception.AutoFWConfigException;
import com.pages.HotelDetailsPage;
import com.pages.HotelSearchPage;
import com.utility.Util;

import io.cucumber.java.en.*;
import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */
@Log4j2
public class StepsHotelDetailsPage {
	
	
	WebDriver driver;

	HotelDetailsPage hotelDetailsPage;

	public StepsHotelDetailsPage() throws AutoFWConfigException  {
		driver = Util.getDriver();
		hotelDetailsPage = new HotelDetailsPage(driver);

	}

	@Then("User enters price range from {string} to {string} in filter criteria")
	public void enterPriceRangeCriteria(String minPrice, String maxPrice) {
	    hotelDetailsPage.enterPriceRangeCriteria(minPrice, maxPrice);
	}
	
	
	@Then("User selects hotel class as {string}")
	public void userSelectsHotelClass(String hclass) throws AutoFWConfigException {
		hotelDetailsPage.selectHotelClass(hclass);
		
	}
	
	@Then("User selects tripadvisor rating as {string}")
	public void userSelectsTripAdvisor(String rating) throws AutoFWConfigException {
	   hotelDetailsPage.selectTripAdviorRating(rating);

	}
	
	@Then("User selects hotel {string}")
	public void userSelectsHotel(String hoteName) throws AutoFWConfigException {
	
		hotelDetailsPage.selectHotel(hoteName);
	}

	
	
	/*

	
	}
	@Then("User selects top most hotel from given list of hotels")
	public void user_selects_top_most_hotel_from_given_list_of_hotels() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("User clicks on View details button")
	public void user_clicks_on_view_details_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/
	}
