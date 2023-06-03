package com.testdata;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;

import com.config.Config;
import com.exception.AutoFWConfigException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utility.Util;
import com.web.BrowserManager;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j2;

/**
 * @author Yogesh Padekar
 *
 */
@Log4j2
public class TestDataOperations {

	private static CorporateSignUpTestData tdConfig;
	private static final String testDataPath = "src//test//resources//com//testdata//";
	
	private static TestDataOperations testDataOperations;
	
	private TestDataOperations() {
		
	}
	
	public static TestDataOperations getTestDataOperation() {
		
		if(testDataOperations==null) {
			testDataOperations=new TestDataOperations();
		}
		
		return testDataOperations;
		
	}
	

	public CorporateSignUpTestData getTdConfig(String fileName) throws AutoFWConfigException {
		if (null == tdConfig) {
			try {
				tdConfig = new ObjectMapper().readValue(Files.readAllBytes(Paths.get(testDataPath+fileName)),
						CorporateSignUpTestData.class);
			} catch (Exception ex) {
				log.info(ex.getMessage(),ex);
				throw new AutoFWConfigException("Failed to read test data file");
			}
		}
		return tdConfig;
	}
	
	public CorporateSignUpTestData getTestData() {
		return tdConfig;
	}

}
