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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

CustomKeywords.'verification.WriteStep.Write_Step'('Add the Delivery Address and click on Paymet button.', 'Netmeds Payment details page shall be displayed.')

KeywordLogger log = new KeywordLogger()

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Link_ChangeAddress'))

WebUI.waitForElementPresent(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Link_AddNewAddress'), GlobalVariable.ShortWait)

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Link_AddNewAddress'))

WebUI.setText(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Txt_Address_PinCode'), PinCode)

//Get the value from the pincode textfield and Verift the picode.
InputPincode = WebUI.getAttribute(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Txt_Address_PinCode'), 'value')

WebUI.verifyMatch(PinCode, InputPincode, false)

WebUI.setText(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Txt_Address_Street'), StreetName)

//Get the value from the StreetName textfield and Verift the StreetName.
InputStreetName = WebUI.getAttribute(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Txt_Address_Street'),
		'value')

WebUI.verifyMatch(StreetName, InputStreetName, false)

WebUI.setText(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Txt_Address_Landmark'), Landmark)

//Get the value from the Landmark textfield and Verift the Landmark.
InputLandmark = WebUI.getAttribute(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Txt_Address_Landmark'),
		'value')

WebUI.verifyMatch(Landmark, InputLandmark, false)

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/btn_Save Address'))

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Address'))

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Btn_Pay'))

CustomKeywords.'verification.VerifyOutput.Verify_Output'(true,WebUI.waitForElementPresent(findTestObject('ObjectRepository_Netmeds/Netmeds MyCart Page/Txt_Payment Details'),
		GlobalVariable.LongWait), 'Netmeds Payment details page is displayed successfully.', 'Failed to display Netmeds Payment Page.', false)

