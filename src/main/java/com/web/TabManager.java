package com.web;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */
@Log4j2
public class TabManager {

	WebDriver driver;

	String defaultWindowHandle;
	String newTabWindowHandle;

	public TabManager(WebDriver driver) {
		this.driver = driver;
	}

	// switch to new tab
	public static void switchToNewTab(WebDriver driver) {

		// Get list of window handles
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
		log.info("Switched to new tab");
	}

	// switch back to default tab and close all other open tab
	public static void switchToDefaultTab(WebDriver driver) {
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		// int windowHandleSize = windowHandles.size();
		String defaultWindowHandle = windowHandles.get(0);
		for (int tabCounter = windowHandles.size() - 1; tabCounter > 0; tabCounter--) {

			if (!defaultWindowHandle.equals(windowHandles.get(tabCounter))) {
				System.out.println("Closing current window" + tabCounter);
				driver.switchTo().window(windowHandles.get(tabCounter));
				driver.close();
			}

			log.info("Switched to default tab");
			driver.switchTo().window(defaultWindowHandle);

		}

	}

}
