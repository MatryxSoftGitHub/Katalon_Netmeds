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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'verification.WriteStep.Write_Step'('Click on the logout button.', 'The User shall be loggedout and Netmeds Home page shall be displayed.')

KeywordLogger log = new KeywordLogger()

WebUI.callTestCase(findTestCase('MainPage/SelectUserAccount'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Link Logout'))

CustomKeywords.'verification.VerifyOutput.Verify_Output'(true,WebUI.waitForElementPresent(findTestObject('ObjectRepository_Netmeds/Netmeds Sign In Page/Link Sign in'), 
    GlobalVariable.LongWait), 'The User has successfully loggedout from Netmeds.', 'The User have Failed to logg out from Netmeds.',
	false)
