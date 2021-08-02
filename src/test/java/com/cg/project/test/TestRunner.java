package com.cg.project.test;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"Features"} , glue = {"com.cg.project.stepdefs"},
			//plugin = "html:Reports//Github.html"
			//plugin = "json:Reports//GitHub.json"
			//plugin = "junit:Reports//GitHub.xml" 
				plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunner {
	
}
