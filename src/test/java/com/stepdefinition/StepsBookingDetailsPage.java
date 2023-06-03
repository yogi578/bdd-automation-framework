package com.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.exception.AutoFWConfigException;
import com.pages.BookingDetailsPage;
import com.pages.HotelDetailsPage;
import com.utility.Util;

import io.cucumber.java.en.*;

/**
 * @author Yogesh Padekar
 *
 */
public class StepsBookingDetailsPage {

	WebDriver driver;

	BookingDetailsPage bookingDetailsPage;

	public StepsBookingDetailsPage() throws AutoFWConfigException  {
		driver = Util.getDriver();
		bookingDetailsPage = new BookingDetailsPage(driver);

	}
	
		@Given("User enters mobile number as {string}")
		public void userEntersMobileNumber(String mobileNumber) {
			bookingDetailsPage.validateBookingPageLoads();
			bookingDetailsPage.enterMobileNumber(mobileNumber);
		}
		
		@Given("User enters email as {string}")
		public void userEntersEmail(String emailAdddress) {
		    // Write code here that turns the phrase above into concrete actions
			bookingDetailsPage.enterEmail(emailAdddress);
		}
		
		@Given("User select title as  {string}")
		public void userSelectsTitle(String title) {
		    // Write code here that turns the phrase above into concrete actions
			bookingDetailsPage.enterTitle(title);
		}
		
		@Given("User enters firstname as {string}")
		public void userEntersFirstName(String firstName) {
		    // Write code here that turns the phrase above into concrete actions
			bookingDetailsPage.enterFirstName(firstName);
		}
		
		@Given("User enters lastname as {string}")
		public void userEntersLastName(String lastName) {
		    // Write code here that turns the phrase above into concrete actions
			bookingDetailsPage.EnterLastName(lastName);
		}
		
		
		@Given("User clicks on Continue to payment  room button")
		public void userContinuesToPaymentPage() {
		    // Write code here that turns the phrase above into concrete actions
			bookingDetailsPage.continueToPay();
			bookingDetailsPage.validatePaymentPage();
		}
	
}
