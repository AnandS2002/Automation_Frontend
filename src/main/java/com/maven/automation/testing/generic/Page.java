package com.maven.automation.testing.generic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.booleanThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;

public class Page extends PageObject {
	private WebDriver driver;

	public Page(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		driver.manage().window().maximize();
	}
	public void type(String xpath,String value) {
		element(By.xpath(xpath)).waitUntilVisible().type(value);
	}
	public void click(String xpath)
	{
		element(By.xpath(xpath)).waitUntilVisible().waitUntilClickable().click();
	}
	public boolean checkTargerUrl(String targetUrl)
	{
		String currentUrl=driver.getCurrentUrl();
		if(currentUrl.contains(targetUrl))
		{
			System.out.println("URL Matched");
			return true;
		}
		return false;
	}
	public boolean contentCheck(String xpath)
	{
		 boolean value=element(By.xpath(xpath)).containsOnlyText("Logged In Successfully");
		 return value;
	}
	public boolean invalidUserCheck(String xpath,String errorMessage)
	{
		boolean value = element(By.xpath(xpath)).waitUntilVisible().containsOnlyText(errorMessage);
		return value;
	}
}
