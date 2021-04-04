package bizobjects.flipkart.screens;

/*
 * @author - Ajujgar
 * @Date - 20th Mar 2021
 * @Description - This file is to save all the objects of Home screen and perform required actions on the page
 */


import java.util.TreeMap;

import org.openqa.selenium.WebDriver;

import commonutils.CommonBusiness;

public class ScrHome extends CommonBusiness {

	TreeMap<String, String> scrObjects = new TreeMap<String, String>();

	public ScrHome(){

		//Objects of Home page
		scrObjects.put("Mobiles"		, 		"xpath://img[@alt='Mobiles']" );
		scrObjects.put("Electronics"	, 		"xpath://span[text()='Electronics']" );
		scrObjects.put("OPPO"			, 		"xpath://a[text()='OPPO']");
		scrObjects.put("FlipkartLogo"	, 		"xpath://img[@alt='Flipkart']/..");
		scrObjects.put("Cart"			, 		"xpath://span[text()='Cart']");
	}

	public void clickOnButton_Link(WebDriver driver, String objectName) {
		try {
			if(checkVisibilityOfElement(driver, scrObjects, objectName)) {
				clickOnElement(driver, scrObjects, objectName);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}