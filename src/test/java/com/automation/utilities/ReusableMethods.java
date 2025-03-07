package com.automation.utilities;

import java.io.File;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.base.BaseClass;

public class ReusableMethods {
	
	 // WebDriver instance
    WebDriver driver;
    
    // Logger instance, will be passed from BaseClass
    Logger logger;

    // Constructor to initialize WebDriver and logger
    public ReusableMethods(ThreadLocal<WebDriver> driver2, Logger logger) {
        this.driver= BaseClass.getDriver();
        this.logger = logger;
    }
    
	public static void deleteFilesInFolder(String folderPath) {
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            // Get all files inside the folder
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    // If it's a file, delete it
                    if (file.isFile()) {
                        file.delete();
                    }
                }
            }
        }
    }
	
	
	 public static void deleteOldReports() {
	        // Folder paths to delete
	        String reportFolderPath = System.getProperty("user.dir") + "\\ExtentReports\\";
	        String screenshotPassFolder = System.getProperty("user.dir") + "\\ScreenshotsPass\\";
	        String screenshotFailFolder = System.getProperty("user.dir") + "\\ScreenshotsFail\\";

	        // Delete files in the specified folders
	        deleteFilesInFolder(reportFolderPath);
	        deleteFilesInFolder(screenshotPassFolder);
	        deleteFilesInFolder(screenshotFailFolder);
	    }
	 
	 
	 public static void fail() {
		 Assert.fail();
	 }
	 
//	 /**
//	     * Method to wait for an element to be visible
//	     * @param locator By locator of the element
//	     */
//	    public void waitForElementVisible(By locator) {
//	        try {
//	            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
//	            logger.info("Element is visible: " + locator);
//	        } catch (Exception e) {
//	            logger.error("Error while waiting for element to be visible: " + locator, e);
//	        }
//	    }
	    
	    
	    /**
	     * Method to click on an element
	     * @param locator By locator of the element
	     */
	    public void clickElement(By locator) {
	        try {
	            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
	                    .until(ExpectedConditions.elementToBeClickable(locator));
	            element.click();
	            logger.info("Clicked on the element: " + locator);
	        } catch (Exception e) {
	            logger.error("Error while clicking on the element: " + locator, e);
	        }
	    }
	    
	    /**
	     * Method to verify if the text is present on the page
	     * @param expectedText Text to be verified
	     * @return boolean true if text is present, false otherwise
	     */
	    public boolean verifyText(String expectedText) {
	        try {
	            boolean isTextPresent = driver.getPageSource().contains(expectedText);
	            if (isTextPresent) {
	                logger.info("Text found: " + expectedText);
	            } else {
	                logger.warn("Text not found: " + expectedText);
	            }
	            return isTextPresent;
	        } catch (Exception e) {
	            logger.error("Error while verifying text: " + expectedText, e);
	            return false;
	        }
	    }
	    
	    
	    /**
	     * Method to scroll to an element
	     * @param locator By locator of the element to scroll to
	     */
	    public void scrollToElement(By locator) {
	        try {
	            WebElement element = driver.findElement(locator);
	            Actions actions = new Actions(driver);
	            actions.moveToElement(element).perform();
	            logger.info("Scrolled to the element: " + locator);
	        } catch (Exception e) {
	            logger.error("Error while scrolling to the element: " + locator, e);
	        }
	    }
	    
	    
	    /**
	     * Method to wait for an element to be visible
	     * @param locator By locator of the element
	     */
	    public void waitForElementVisible(By locator) {
	        try {
	            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	            logger.info("Element is visible: " + locator);
	        } catch (Exception e) {
	            logger.error("Error while waiting for element to be visible: " + locator, e);
	        }
	    }
	    
	    
	    

}
