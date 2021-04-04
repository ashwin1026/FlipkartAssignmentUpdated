package bizobjects.flipkart.screens;

/*
 * @author - Ajujgar
 * @Date - 20th Mar 2021
 * @Description - This file is to save all the objects of Item Detail screen and perform required actions on the page
 */

import java.util.TreeMap;
import org.openqa.selenium.WebDriver;
import commonutils.CommonBusiness;

public class ScrItemDetails extends CommonBusiness {

	TreeMap<String, String> scrObjects = new TreeMap<String, String>();

	public ScrItemDetails(){

		scrObjects.put("AddToCart", "xpath://button[text()='ADD TO CART']" );

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