package bizobjects.flipkart.screens;

/*
 * @author - Ajujgar
 * @Date - 21st Mar 2021
 * @Description - This file is to save all the objects of Login screen and perform required actions on the page
 */

import java.util.TreeMap;
import org.openqa.selenium.WebDriver;
import commonutils.CommonBusiness;

public class ScrLogin extends CommonBusiness {

	TreeMap<String, String> scrObjects = new TreeMap<String, String>();

	public ScrLogin(){

		scrObjects.put("Email_phone", 		"xpath://input[1]");
		scrObjects.put("Password", 			"xpath://input[@type='password']");
		scrObjects.put("Continue", 			"xpath://span[text()='CONTINUE']");
		scrObjects.put("Login", 			"xpath://span[text()='Login']");

	}

	public void fillText(WebDriver driver, String objectName, String testData) {
		fillScreen(driver, scrObjects, objectName, testData);
	}

	public void clickOnButton_Link(WebDriver driver, String objectName) {
		try {
			if(checkVisibilityOfElement(driver,scrObjects,objectName)) {
				clickOnElement(driver, scrObjects, objectName);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}		

	public boolean isElementEnable(WebDriver driver, String objectName) {
		return checkEnabilityOfElement(driver, scrObjects, objectName);
	}
}