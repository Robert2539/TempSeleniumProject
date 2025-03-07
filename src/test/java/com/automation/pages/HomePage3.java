package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage3 {

	private WebDriver driver;

	// Locators for elements on the Home Page
	private By welcomeText = By.id("welcomeText");
	private By logoutButton = By.id("logoutButton");

	// Constructor to initialize WebDriver
	public HomePage3(WebDriver driver) {
		this.driver = driver;
	}

	// Page Methods
	public String getWelcomeText() {
		return driver.findElement(welcomeText).getText();
	}

	public void clickLogoutButton() {
		driver.findElement(logoutButton).click();
	}
}
