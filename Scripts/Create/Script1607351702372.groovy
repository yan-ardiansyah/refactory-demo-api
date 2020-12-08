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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Send Request to POST https://reqres.in/api/users'
response = WS.sendRequest(findTestObject('Create'))

'Call JSON Slurper function'
def slurper = new groovy.json.JsonSlurper()

'Parse the response and save in variable "result"'
def result = slurper.parseText(response.getResponseBodyContent())

'Take the "id" value and save in "ids" variable'
ids = result.id

'print the "ids" variable'
println(ids)

'Extract value of "ids" and get last of the char and save it to "lastid" char'
lastid = ids.substring(2)

'print last char and save it to "lastid" variable'
println(lastid)

'Change the value type of "lastid" variable to Integer and save it to "id_int" variable'
id_int = Integer.parseInt(lastid)

'Compare the "lastid" variable value and "id_int" variable value'
WS.verifyEqual(lastid, id_int, FailureHandling.STOP_ON_FAILURE)

