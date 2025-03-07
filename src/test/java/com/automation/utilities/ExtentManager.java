package com.automation.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	static ExtentReports extent;
	 

	public static ExtentReports createInstance(String fileName) {
		System.out.println(fileName);
		ExtentHtmlReporter spark = new ExtentHtmlReporter(fileName);;
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle(fileName);
        spark.config().setEncoding("utf-8");
        spark.config().setReportName(fileName);
        
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Automation Tester", "Ricxon");
        extent.setSystemInfo("Organization", "Way2Automation");
        extent.setSystemInfo("Build no", "W2A-1234");	
        return extent;

	}

//	private static ExtentReports extent;
//
//	// Create and initialize the ExtentReports instance
//	public static ExtentReports createInstance(String fileName) {
//		// Check if the ExtentReports instance is null (to avoid creating multiple
//		// instances)
//		if (extent == null) {
//			// Path where the report will be stored
//			
//
////			// Create directory if it doesn't exist
////			File file = new File(fileName);
////			if (!file.exists()) {
////				file.mkdirs();
////			}
//
//			// Create an ExtentSparkReporter instance
//			ExtentSparkReporter spark = new ExtentSparkReporter(fileName);
//			spark.config().setTheme(Theme.STANDARD); // You can change it to Theme.DARK if you prefer a dark theme
//			spark.config().setDocumentTitle(fileName); // Set the report document title
//			spark.config().setEncoding("utf-8");
//			spark.config().setReportName(fileName); // Report name
//
//			// Create an ExtentReports instance
//			extent = new ExtentReports();
//			extent.attachReporter(spark);
//
//			// Set system information for the report
//			extent.setSystemInfo("Automation Tester", "Ricxon");
//			extent.setSystemInfo("Organization", "Way2Automation");
//			extent.setSystemInfo("Build no", "W2A-1234");
//		}
//
//		return extent;
//	}
//
//	// To return the same instance of ExtentReports
//	public static ExtentReports getExtent() {
//		return extent;
//	}
}
