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

// To Find the Element in WebTable we need to use Seleium Pakages
WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'verification.WriteStep.Write_Step'('Select the Alphabet from the Medicine Catagory.', 'List of Medicine for the selected alphabet shall be displayed.')

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds Main Page/Link_SelectCatagory'))

WebUI.waitForPageLoad(GlobalVariable.LongWait)

WebUI.waitForElementClickable(findTestObject('ObjectRepository_Netmeds/Netmeds MedicineCatagory/Lbl_Alphabet'), GlobalVariable.LongWait)

// To get the count of total alphabets avilable
def AlphaCount = driver.findElements(By.className('alpha-drug-list')).size()
println(AlphaCount)

// To Fetch Text values from the alphabet list
for (int i = 1; i <= AlphaCount; i++) {
 
    String sAlphabet = driver.findElement(By.xpath(('//*[@id="list-nav-nav"]/div/a[' + i) + ']')).getText()
    println(sAlphabet)

	// To Select Particular Alphabet
    if (sAlphabet == SelectAlphabet) 
	{
        println((sAlphabet + 'Matches') + SelectAlphabet)

        driver.findElement(By.xpath(('//*[@id="list-nav-nav"]/div/a[' + i) + ']')).click()

        break
    }
}

CustomKeywords.'verification.VerifyOutput.Verify_Output'(true,WebUI.verifyElementText(findTestObject('ObjectRepository_Netmeds/Netmeds MedicineCatagory/Txt_VeriftAlpha'), 
    SelectAlphabet), 'List of medicines for the selected alphabet is displayed successfully.', 'Failed to display list of medicines for the selected alphabet.', false)