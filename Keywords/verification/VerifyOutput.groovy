package verification

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable


import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

//Classes imported
//import com.kms.katalon.core.Util.KeywordUtil.markPassed as markPassed
import org.openqa.selenium.Keys as keys
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
//import com.kms.katalon.core.util.KeywordUtil

public class VerifyOutput {

	@Keyword
	def Verify_Output(Object ExpectedOutput, Object ActualOutput, String SuccessMessage, String FailureMessage,
			Boolean bNotcontinue) {
		bNotcontinue = true;

		// Success Block
		if (ExpectedOutput == ActualOutput) {
			if (!SuccessMessage.isEmpty()) {
				WebUI.comment("SuccessMessage - " + SuccessMessage)
			}
		}

		// Failure Block
		else {
			String sScreenshotPath=RunConfiguration.getProjectDir()+'/Screenshots/'+FailureMessage+'.png';
			WebUI.takeScreenshot(sScreenshotPath)

			if (bNotcontinue)
			{
				//ReportLogs.logFailed("FailureMessage - " + FailureMessage)
				WebUI.comment("FailureMessage - " + FailureMessage)
			}
		}
	}
}