package com.automation.testcases;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.utilities.ExcelUtility;


public class SampleTest extends BaseClass {

	//@Test
	public void x() throws InterruptedException {

		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/input")));
		searchBox.sendKeys("Tesla");
		Thread.sleep(3000);
		
		Actions actions = new Actions(getDriver());
		actions.moveToElement(searchBox).sendKeys(Keys.ENTER).perform();
		log.info("@@@@@@@@@@@@@@@ entered keyword in search box @@@@@@@@@@@@@@");
		System.out.println(getDriver().getCurrentUrl());
		log.info("@@@@@@@@@@@@@@@ printed title @@@@@@@@@@@@@@");
	}

	
	@Test//(dataProvider = "googleSearchData")
	public void testGoogleSearch() throws Throwable {//String searchQuery
//		getDriver().findElement(By.name("q")).sendKeys("Selenium Automation");
//		getDriver().findElement(By.name("q")).submit();
//		System.out.println(getDriver().getTitle());
		
		//getDriver().findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/input")).click();
		
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//fieldset/legend/div/div/parent::*//parent::legend//parent::fieldset//preceding-sibling::div/following-sibling::input")));
		searchBox.sendKeys("Kia");
		Thread.sleep(3000);
		
		Actions actions = new Actions(getDriver());
		actions.moveToElement(searchBox).sendKeys(Keys.ENTER).perform();
		//searchBox.sendKeys(Keys.ENTER);
		
		
		//getDriver().findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/input")).sendKeys("kia",Keys.ENTER);
		
		log.info("@@@@@@@@@@@@@@@ entered keyword in search box @@@@@@@@@@@@@@");
		System.out.println(getDriver().getCurrentUrl());
		log.info("@@@@@@@@@@@@@@@ printed title @@@@@@@@@@@@@@");
		//ReusableMethods.fail();
		
		
		
		
		//// Now you can use the reusableMethods instance in all test methods
        //reusableMethods.clickElement(By.id("exampleButton"));
        //reusableMethods.selectFromDropdown(By.id("exampleDropdown"), "Option 1");
        //reusableMethods.verifyText("Welcome to the Automation");
        //reusableMethods.scrollToElement(By.id("targetElement"));
        //reusableMethods.waitForElementVisible(By.id("newElement"));
		
		//reusableMethods.clickElement(By.id("anotherButton"));
        //reusableMethods.verifyText("Another Text");
	

	}
	
	
	 @DataProvider(name = "googleSearchData", parallel=true)
	  public Object[][] getData() throws IOException {
	        return ExcelUtility.getTestData("src\\test\\resources\\DataExcel.xlsx", "Sheet1");
	    }

}