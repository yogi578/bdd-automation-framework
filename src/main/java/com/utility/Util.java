package com.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.config.Config;
import com.exception.AutoFWConfigException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.BrowserManager;

public class Util {
	private static Config config;
	private static final String configPath="src//main//resources//config.json";
	
	public static Config getConfig() throws AutoFWConfigException {
		if(null==config) {
			try {
			config= new ObjectMapper().readValue(Files.readAllBytes(Paths.get(configPath)), Config.class);
			}catch(Exception ex) 
			{
				throw new AutoFWConfigException("Failed to read config file");
			}
		}
		return config;
	}
	
	// get browser name from config
	public static WebDriver getDriver() throws AutoFWConfigException {
		return BrowserManager.getBrowserManager().getDriver(Util.getConfig().getBrowser());
	}
	
	//convert string/pattern to date
	public static Date stringToDate(String pattern,String value) throws AutoFWConfigException {
		try {
		SimpleDateFormat sdf= new SimpleDateFormat(pattern);
		return sdf.parse(value);	
		}catch(Exception ex) {
			throw new AutoFWConfigException("Invalid date format! Valid format is dd/mm/yyyy");
		}
	}
	
	//convert  date to string/pattern
	public static String dateToString(String pattern,Date date) throws AutoFWConfigException {
		try {
		SimpleDateFormat sdf= new SimpleDateFormat(pattern);
		return sdf.format(date);
	}catch(Exception ex) {
		throw new AutoFWConfigException("Invalid date format!");
	}
	
	
	

}}
