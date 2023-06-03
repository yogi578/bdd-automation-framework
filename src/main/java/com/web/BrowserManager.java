package com.web;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.exception.AutoFWConfigException;
import com.exception.AutoFWException;
import com.utility.Util;

import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */
@Log4j2
public class BrowserManager {

	// for browser and corresponding driver instance
	private static Map<String,WebDriver> webDrivers= new HashMap<String, WebDriver>() ;
	
	private static BrowserManager browserManager;
	
	// get default project directory
	String driverPath= System.getProperty("user.dir");
	
	//Private constructor to ensure instance can not be created outside class. 
	private BrowserManager() {		
	}
	
	//Method to check if the instance is created , if not create a instance
	public static BrowserManager  getBrowserManager() {
		
		if(browserManager==null) {
			browserManager= new BrowserManager();
		}
		
		return browserManager;
	}
	
	// Return current driver instance
	
	public  WebDriver getDriver(String browserName) {
		if(null==webDrivers.get(browserName)) {
			webDrivers.put(browserName, createDriverInstance(browserName));
		}
		return webDrivers.get(browserName);
	}
	
	// In case need to enable multiple browser support
	private WebDriver createDriverInstance(String browserName) {
		log.info("Creating new driver for browser : "+ browserName);
		WebDriver driver;
		switch(browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", driverPath+"\\src\\main\\resources\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
			return driver;
		
		case "firefox":
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
			return driver;
		default:
			throw new AutoFWException("Browser is not configured!");
			
		}
	}
	
	public static void switchToNewTab(WebDriver driver) {
		
		// Get list of window handles 
		ArrayList<String> windowHandles=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(windowHandles.size()-1));
		log.info("Switched to new tab");
		
		
	}
	
	//Refresh browser
	public static WebDriver browserRefresh(WebDriver driver) throws AutoFWConfigException {
		driver.navigate().refresh();
		return driver;
	}
	
	//Close browser instance at the end of execution and reset class instance to null
	public static void exit() {
		webDrivers.values().forEach(driver->driver.quit());
   } 
	
}
