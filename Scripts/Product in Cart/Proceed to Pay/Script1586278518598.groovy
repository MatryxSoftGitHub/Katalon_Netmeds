import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'verification.WriteStep.Write_Step'('Click on Review Order button and proceed to payment.', 'Netmeds Payment Page shall be displayed.')

//Creating dynamic object for Proceed button
text = 'Proceed'

TestObject dynamicObject_ProceedToPay = new TestObject('dynamicObject_ProceedToPay').addProperty('Text', ConditionType.EQUALS, 
    text, true)

WebUI.click(dynamicObject_ProceedToPay)

WebUI.check(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Chk_Upload Prescription'))

WebUI.verifyElementChecked(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Chk_Upload Prescription'), GlobalVariable.ShortWait)

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Btn_Review Order'))

CustomKeywords.'verification.VerifyOutput.Verify_Output'(true,WebUI.waitForElementPresent(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Btn_Pay'), 
    GlobalVariable.LongWait), 'Netmeds Payment Page is displayed successfully.', 'Failed to display Netmeds Payment Page.', false)
