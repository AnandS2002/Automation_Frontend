package com.maven.automation.testing;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
 
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/login.feature", plugin = {
		"rerun:target/rerun.txt" }, glue = {
				"com.maven.automation.testing.step" }, tags = { "" }, format = { "pretty" })

public class RunnerClass {
    
 
}
