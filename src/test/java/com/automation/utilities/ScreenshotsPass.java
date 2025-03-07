package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.automation.base.BaseClass;


public class ScreenshotsPass {
//	public ScreenshotsPass(WebDriver d) {
//		BaseClass.driver = d;
//	}

	public static final SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

	public static String captureScreenshot(WebDriver driver, String fileName) {
		File scrFile = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
		String des = System.getProperty("user.dir") + "\\ScreenshotsPass\\" + fileName + ".png";
		try {
			File finalDestination = new File(des);
			FileUtils.copyFile(scrFile, finalDestination);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return des;

	}

	public static String generateFileName(ITestResult result) {
		Date d = new Date();
		// String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		String fileName = result.getName() + "_" + df.format(d);
		return fileName;

	}

}