package com.web;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.exception.AutoFWException;
import com.utility.Util;

import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */

@Log4j2
public class WebElementManager {

	WebDriver driver;
	WebElement element;


	public WebElementManager(WebDriver driver) {
		this.driver=driver;
	}

	//Method to scroll to element in view
	public void scrollToElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
		log.info("Scrolled to :-"+element);
	}
	
	//Method to scroll down at the bottom of the page
	
	public void scrollDownPageBottom() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		log.info("Scrolled to the bottom of the page");

	}
	
	//Method to scroll down at the bottom of the page
	
			public void scrollUpPageTop() {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,0)");
			log.info("Scrolled to the top of the page");
			
		}
			
	
			//Method to pause for given time - in seconds
			public void pause(int seconds) {
				try {
					Thread.sleep(seconds*1000);
					log.info("Execution paused :- "+seconds);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				throw new AutoFWException("Execution Interrupted :-" + e.getMessage());
				}
				}
			
			//Method to wait until element is clickable 
			public  void waitforElementToBeclickable(Duration waitTimeInSec, WebElement element) {		
				log.info("Waiting for : {}",waitTimeInSec,"seconds for element: {}",element);
				WebDriverWait wait = new WebDriverWait(driver, waitTimeInSec);
				this.element = wait.until(ExpectedConditions.elementToBeClickable(element));
			
			}
						

}
