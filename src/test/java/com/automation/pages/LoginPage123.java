package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage123 {
	private WebDriver driver;

	// Locators for elements on the Login Page
	private By usernameField = By.id("username");
	private By passwordField = By.id("password");
	private By loginButton = By.id("loginButton");

	// Constructor to initialize WebDriver
	public LoginPage123(WebDriver driver) {
		this.driver = driver;
	}

	// Page Methods
	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	public boolean isLoginButtonEnabled() {
		return driver.findElement(loginButton).isEnabled();
	}
}
