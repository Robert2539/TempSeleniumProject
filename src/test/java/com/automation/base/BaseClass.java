package com.automation.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.utilities.PropertyReader;
import com.automation.utilities.ReusableMethods;


public class BaseClass {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	protected Logger log = Logger.getLogger(BaseClass.class);
	ReusableMethods reusableMethods;

	@Parameters({ "browser" })
	@BeforeMethod
	public void initDriver(String browser) throws Exception {
		if (browser == null || browser.isEmpty()) {
			browser = PropertyReader.getProperty("browser"); // fallback to config.property
		}

		if (browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
		} else {
			throw new RuntimeException("Invalid Browser in config browser");
		}

		getDriver().manage().window().maximize();
		log.info("@@@@@@@@@@@@@@@ maximized window @@@@@@@@@@@@@@");
		getDriver().get(PropertyReader.getProperty("url"));
		log.info("@@@@@@@@@@@@@@@ opebed URL @@@@@@@@@@@@@@");
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	@AfterMethod
	public void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			log.info("@@@@@@@@@@@@@@@ closed browser @@@@@@@@@@@@@@");
			driver.remove();
		}
	}
	
	
	@BeforeSuite
    public void beforeSuite() {
        try {
        	reusableMethods = new ReusableMethods(driver, log);
            // Perform cleanup before the entire suite runs
        	reusableMethods.deleteOldReports();  // Delete old reports and screenshots
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
	@BeforeClass
    public void setUp() {
        // Instantiate ReusableMethods class only once, passing the driver and logger
        
    }
}
