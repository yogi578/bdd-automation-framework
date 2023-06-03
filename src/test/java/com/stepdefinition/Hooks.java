package com.stepdefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.exception.AutoFWConfigException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.pages.HotelSearchPage;
import com.utility.Util;
import com.web.BrowserManager;
import com.web.TabManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */
@Log4j2
public class Hooks {
	
	static WebDriver driver;
	
	
	// Step to be performed before test scenario
	@Before
	public static void initialSetup(Scenario scenario) throws AutoFWConfigException {
		driver=Util.getDriver();
		log.info("");
		log.info("-----------------------------------------------------------------------------------------------");
		log.info("------------- Excution started for scenario:"+ scenario.getName()+" -------------");
		
	}
	
	
	//Steps to be performed post execution of test scenario
	@After
	public static void cleanUp(Scenario scenario) {
		
		//if scenario fails take screen shot
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()); 

            log.error("------------- Excution failed for scenario:"+ scenario.getName()+" -------------");
        	log.error("-----------------------------------------------------------------------------------------------");
        
    		//TabManager.switchToDefaultTab(driver);
        }   
         
        log.info("------------- Excution completed for scenario:"+ scenario.getName()+"-------------");
    	log.info("-----------------------------------------------------------------------------------------------");
    	log.info("");
		log.info("");
		TabManager.switchToDefaultTab(driver);
		
	}
}
