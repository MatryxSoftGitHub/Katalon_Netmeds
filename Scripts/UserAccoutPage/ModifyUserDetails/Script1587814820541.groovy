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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

CustomKeywords.'verification.WriteStep.Write_Step'('Change the User Account Details.', 'The User account details shall be changed and user shall be navigated to User accout page.')

WebDriver driver = DriverFactory.getWebDriver()

KeywordLogger log = new KeywordLogger()

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds UserAccout Page/Link_Modify'))

WebUI.setText(findTestObject('ObjectRepository_Netmeds/Netmeds UserAccout Page/Txt_ProfileFirstname'), FirstName)

WebUI.setText(findTestObject('ObjectRepository_Netmeds/Netmeds UserAccout Page/Txt_ProfileLastname'), LastName)

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds UserAccout Page/Txt_DateOfBirth'))

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds UserAccout Page/Txt_Date'))

//Creating dynamic object to select Birth Year.
TestObject dynamicObject_BirthYear = new TestObject('dynamicObject_BirthYear').addProperty('Text', ConditionType.EQUALS, 
    BirthYear, true)

WebUI.click(dynamicObject_BirthYear)

//Creating dynamic object to select Birth Month.
TestObject dynamicObject_BirthMonth = new TestObject('dynamicObject_BirthMonth').addProperty('Text', ConditionType.EQUALS, 
    BirthMonth, true)

WebUI.click(dynamicObject_BirthMonth)

//Creating dynamic object to select Birth Day.
TestObject dynamicObject_BirthDay = new TestObject('dynamicObject_BirthDay').addProperty('Text', ConditionType.EQUALS, BirthDay, 
    true)

WebUI.click(dynamicObject_BirthDay)

driver.findElement(By.xpath('//*[@id="mat-select-0"]/div/div[1] ')).click()

//To get the count of Gender
def eleCount = driver.findElements(By.className('mat-option-text')).size()

println(eleCount)

// To Fetch Text values from list
for (int i = 1; i <= eleCount; i++) {
   
    String sGender = driver.findElement(By.xpath(('//*[@id="mat-option-' + i) + '"]')).getText()
    println(sGender)
	
	// To Select Gender
    if (sGender == Gender) {
        println((sGender + ' is same with ') + Gender)
        driver.findElement(By.xpath(('//*[@id="mat-option-' + i) + '"]')).click()
        break
    }
}

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds UserAccout Page/Btn_Save Changes'))

WebUI.waitForPageLoad(GlobalVariable.LongWait)

CustomKeywords.'verification.VerifyOutput.Verify_Output'(true, WebUI.waitForElementPresent(findTestObject('ObjectRepository_Netmeds/Netmeds UserAccout Page/Lbl_Your Account'), 
    GlobalVariable.LongWait), 'The User has successfully navigated to User accout page.', 'The User have Failed to navigate to User accout page.',
	false)
