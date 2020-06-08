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

CustomKeywords.'verification.WriteStep.Write_Step'('Select the Product by name.', 'Product is selected and Product details page shall be displayed.')

WebDriver driver = DriverFactory.getWebDriver()
KeywordLogger log = new KeywordLogger()

WebUI.setText(findTestObject('ObjectRepository_Netmeds/Netmeds Main Page/Txt_SearchItem'), SearchMedicine)

WebUI.click(findTestObject('ObjectRepository_Netmeds/Netmeds Main Page/Btn_SearchIcon'))

// To get the count of total medicines avilable
def eleCount = driver.findElements(By.className('ais-InfiniteHits-item')).size()

println(eleCount)

// To Fetch Text values from list
for (int i = 1; i <= eleCount; i++) {
  
    String sMedicineType = driver.findElement(By.xpath(('//*[@id="algolia_hits"]/li[' + i) + ']/div/div/div[2]/a/div')).getText()
    println(sMedicineType)

	// To Select Particular Medicine
	    if (sMedicineType == MedicineName) {
        println((sMedicineType + ' is same with ') + MedicineName)

        driver.findElement(By.xpath(('//*[@id="algolia_hits"]/li[' + i) + ']/div/div/div[2]/a/div')).click()
    }
}

CustomKeywords.'verification.VerifyOutput.Verify_Output'(true,WebUI.waitForElementPresent(findTestObject('ObjectRepository_Netmeds/Netmeds Product Details page/Btn_AddToCart'),
	 GlobalVariable.LongWait), 'Product is selected and Product details page is displayed successfully.','Failed to select Product and Failed to  display Product details page.', false)
