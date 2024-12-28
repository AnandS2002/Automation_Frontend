package com.maven.automation.testing.step;

import static org.junit.Assert.assertTrue;

import com.maven.automation.testing.login.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	private LoginPage loginpage;
	@Given("I opened the Page using (.*)")
	public void openPage(String url) {
		loginpage.openAt(url);
	}
	@When("I have the (.*) and (.*)")
	public void performLogin(String username,String password)
	{
		loginpage.type("//*[@id=\"username\"]", username);
		loginpage.type("//*[@id=\"password\"]", password);
	}
	@Then("Perform Login")
	public void login()
	{
		loginpage.click("//*[@id=\"submit\"]");

	}
	@And ("Verify the current url contains (.*)")
	public void urlCheck(String targetUrl)
	{
		assertTrue(loginpage.checkTargerUrl(targetUrl));
	}
	@And ("the page contains Logged In Successfully")
	public void checkContent()
	{
		assertTrue(loginpage.contentCheck("//*[@id=\"loop-container\"]/div/article/div[1]/h1"));

	}
	@Then ("Logout")
	public void logout() 
	{
		loginpage.click("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a");
	}
	@And ("Validate the page displays an (.*)")
	public void invalidUsername(String errorMessage)
	{
		assertTrue(loginpage.invalidUserCheck("//*[@id=\"error\"]",errorMessage));
	}

}
