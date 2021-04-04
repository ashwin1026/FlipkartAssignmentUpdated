package bizobjects.flipkart.screens;

/*
 * @author - Ajujgar
 * @Date - 20th Mar 2021
 * @Description - This file is to save all the objects of Oppo Mobile Phones screen and perform required actions on the page
 */

import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonutils.CommonBusiness;

public class ScrOppoMobilePhones extends CommonBusiness {

	TreeMap<String, String> scrObjects = new TreeMap<String, String>();

	public ScrOppoMobilePhones(){

		scrObjects.put("View All"		, 	"xpath://h2[contains(text(),'10K')]/../following-sibling::div[1]//span" );
		scrObjects.put("OPPOA3sRed16GB"	, 	"xpath://div[text()='OPPO A3s (Red, 16 GB)']");
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

	public void pageScrollDown(WebDriver driver, String elementToScroll) {
		String elementXpath = scrObjects.get(elementToScroll);

		String[] stratInfo = new String[2];
		stratInfo[0] = elementXpath.substring(0, elementXpath.indexOf(":"));
		stratInfo[1] = elementXpath.substring(elementXpath.indexOf(":") + 1, elementXpath.length());

		WebElement ele = driver.findElement(By.xpath(stratInfo[1]));

		pageScrollDown(driver,ele);
	}
}