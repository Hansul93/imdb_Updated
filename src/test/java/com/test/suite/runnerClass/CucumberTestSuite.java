package com.test.suite.runnerClass;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report" }, features = "resources", glue = {
		"com.test.suite.stepDefinitions" }, tags = { "@All" })

public class CucumberTestSuite {

}