
package com.runner;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import cucumber.api.junit.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "", features = {"src/test/resources/com/testcases"}, glue = {"com.stepdefinition"},plugin = {})
public class CucumberRunnerTest extends AbstractTestNGCucumberTests{
  
}
