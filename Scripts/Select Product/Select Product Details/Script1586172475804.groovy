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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'verification.WriteStep.Write_Step'('Select the Product details of the product.', 'Product details shall be selected and Netmeds Main page shall be displayed.')

KeywordLogger log = new KeywordLogger()

WebUI.selectOptionByValue(findTestObject('ObjectRepository_Netmeds/Netmeds Product Details page/Pop_ProductQuantity'), ProductQuantity, 
    true)

WebUI.verifyOptionSelectedByValue(findTestObject('ObjectRepository_Netmeds/Netmeds Product Details page/Pop_ProductQuantity'), 
    ProductQuantity, false, GlobalVariable.ShortWait)

WebUI.setText(findTestObject('ObjectRepository_Netmeds/Netmeds Product Details page/Txt_Pincode'), PinCode)

InputPincode = WebUI.getAttribute(findTestObject('ObjectRepository_Netmeds/Netmeds Product Details page/Txt_Pincode'), 'value')

WebUI.verifyMatch(PinCode, InputPincode, false)

WebUI.check(findTestObject('ObjectRepository_Netmeds/Netmeds Product Details page/Btn_Check'))

WebUI.callTestCase(findTestCase('Product in Cart/AddToCart'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'verification.VerifyOutput.Verify_Output'(true,WebUI.waitForElementNotPresent(findTestObject('ObjectRepository_Netmeds/Netmeds Product Details page/Btn_AddToCart'), 
    GlobalVariable.LongWait), 'Product details are selected and Netmeds Main page is displayed successfully.', 'Failed to select Product details and Failed to display Netmeds Main page.', 
    false)

