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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'verification.WriteStep.Write_Step'('Enter the UserName and Password in the login page.', 'The User shall be loggedin and Netmeds Main page shall be displayed.')

KeywordLogger log = new KeywordLogger()

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds Main Page/Link_Sign up'))

WebUI.setText(findTestObject('ObjectRepository_Netmeds/Netmeds Sign In Page/Txt_MobileNumber'), UserName)

//Get the value from the UserName textfield and Verift the UserName.
InputUserName = WebUI.getAttribute(findTestObject('ObjectRepository_Netmeds/Netmeds Sign In Page/Txt_MobileNumber'), 'value')

WebUI.verifyMatch(UserName, InputUserName, false)

println(InputUserName)

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds Sign In Page/Btn_Use Password'))

WebUI.waitForElementPresent(findTestObject('ObjectRepository_Netmeds/Netmeds Sign In Page/Txt_Password'), GlobalVariable.ShortWait)

WebUI.setEncryptedText(findTestObject('ObjectRepository_Netmeds/Netmeds Sign In Page/Txt_Password'), '3wYZpRJo3+1KkJ0X3Megxw==')

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds Sign In Page/Btn_Sign in'))

CustomKeywords.'verification.VerifyOutput.Verify_Output'(true, WebUI.waitForElementPresent(findTestObject('ObjectRepository_Netmeds/Netmeds Main Page/Link_CustomerName'), 
        GlobalVariable.LongWait), 'The User has logged in successfully into Netmeds.', 'Failed to login into Netmeds.', 
    false)

WebUI.delay(GlobalVariable.LongWait)

