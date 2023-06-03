package com.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.exception.AutoFWConfigException;
import com.exception.AutoFWException;
import com.pages.CorporateSignUpPage;
import com.testdata.CorporateSignUpTestData;
import com.testdata.TestDataOperations;
import com.utility.Util;
import com.web.WebElementManager;

import io.cucumber.java.en.*;
import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */

@Log4j2

public class StepsCorporateSignup {

	
	WebDriver driver;
	CorporateSignUpPage corporateSignUpPage;
	CorporateSignUpTestData corporateData;

	public StepsCorporateSignup() throws AutoFWConfigException {
		driver = Util.getDriver();
		corporateSignUpPage = new CorporateSignUpPage(driver);

	}

	@Given("User reads test data from file {string}")
	public void readTestData(String fileName) throws AutoFWConfigException {
		corporateData = TestDataOperations.getTestDataOperation().getTdConfig(fileName);
	}

	// hit url
	@Given("User hits url {string}")
	public void userHitsUrl(String url) {
		
		corporateSignUpPage.getCorporateDetailsPage(url);
		//WebElementManager wem=new WebElementManager(driver);
		

	}

	// enter inputvalue
	@Then("User enters {string}")
	public void userEntersValue(String paramName) {
		switch (paramName) {

		case "companyname":
			corporateSignUpPage.enterCompanyName(corporateData.getCompanyName());

			break;

		case "firstname":
			corporateSignUpPage.enterFirstName(corporateData.getFirstName());
			break;

		case "lastname":
			corporateSignUpPage.enterLastName(corporateData.getLastName());
			break;

		case "address":
			corporateSignUpPage.enterAddress(corporateData.getAddress());

			break;

		case "city":
			corporateSignUpPage.enterCity(corporateData.getCity());

			break;

		case "pancardno":
			corporateSignUpPage.enterPan(corporateData.getPanCardNo());
			break;

		case "email":
			corporateSignUpPage.enterEmail(corporateData.getEmail());
			break;

		case "mobileno":
			corporateSignUpPage.enterMobileNo(corporateData.getMobileNo());
			break;
			
	

		default:

			throw new AutoFWException("Value not found in file!");

		}

	}

	// click element
	@Then("User clicks on sign up")
	public void userClicksElement() {
		corporateSignUpPage.clicksOnSignUp();
	}

}
