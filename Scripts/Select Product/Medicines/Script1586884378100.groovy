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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType

CustomKeywords.'verification.WriteStep.Write_Step'('Select the Product from the medicine catagory.', 'Product shall be selected and Product details page shall be displayed.')

// To Find the Element in WebTable we need to use Seleium Pakages
WebDriver driver = DriverFactory.getWebDriver()
KeywordLogger log = new KeywordLogger()

//Creating dynamic object to select the medicine catagory.
TestObject dynamicObject_SelectCatagory = new TestObject('dynamicObject_SelectCatagory').addProperty('Text', ConditionType.EQUALS, sProductCatagory, true)

WebUI.click(dynamicObject_SelectCatagory)

WebUI.waitForPageLoad(GlobalVariable.LongWait)

//Creating dynamic object to select the product.
TestObject dynamicObject_SelectProduct = new TestObject('dynamicObject_SelectProduct').addProperty('Text', ConditionType.EQUALS, sProductName, true)

WebUI.click(dynamicObject_SelectProduct)

CustomKeywords.'verification.VerifyOutput.Verify_Output'(true,WebUI.waitForElementPresent(findTestObject('ObjectRepository_Netmeds/Netmeds Product Details page/Btn_AddToCart'), 
	GlobalVariable.LongWait), 'Product is selected and Product details page is displayed successfully.','Failed to select Product and Failed to  display Product details page.', false)




