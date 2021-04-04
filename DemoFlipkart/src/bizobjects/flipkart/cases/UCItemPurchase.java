package bizobjects.flipkart.cases;

/*
 * @author - Ajujgar
 * @Date - 20th Mar 2021
 * @Task - Item Purchase flow
 */

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bizobjects.flipkart.screens.ScrCart;
import bizobjects.flipkart.screens.ScrHome;
import bizobjects.flipkart.screens.ScrItemDetails;
import bizobjects.flipkart.screens.ScrLogin;
import bizobjects.flipkart.screens.ScrOppoMobilePhones;
import bizobjects.flipkart.screens.ScrOrderSummary;
import bizobjects.flipkart.screens.ScrPaymentOptions;
import commonutils.CommonBusiness;

public class UCItemPurchase extends CommonBusiness {


	/**
	 * This method will complete the flow of item purchase.
	 * 
	 * The processItemPurchase method is a method that is in charge of orchestrating the events necessary to access the 'Item Purchase' flow.
	 * @param driver (WebDriver)		- The instance of the WebDriver created at the time of launching the browser.
	 * @param prop (Properties)			- Properties object with the test data read while launching the browser
	 * @TASK  Complete the item purchase flow to buy Oppo mobile
	 */
	public void processItemPurchase(WebDriver driver, Properties prop) {

		ScrHome scrh = new ScrHome();
		ScrOppoMobilePhones scromp = new ScrOppoMobilePhones();
		ScrItemDetails scrid = new ScrItemDetails();
		ScrCart scrc = new ScrCart();
		ScrLogin scrl = new ScrLogin();
		ScrOrderSummary scros = new ScrOrderSummary();
		ScrPaymentOptions scrpo = new ScrPaymentOptions();
		String methodName = getCallingMethod(0);

		logStartMethod(methodName);
		try {

			driver.findElement(By.xpath("//body/div[2]/div/div/button")).click(); //Closes pop up

			scrh.clickOnButton_Link(driver, "Mobiles");

			scrh.clickOnButton_Link(driver, "Electronics");
			scrh.clickOnButton_Link(driver, "OPPO");
			scromp.clickOnButton_Link(driver, "View All");
			String mobileName = prop.getProperty("elementToScroll");
			mobileName= mobileName.replaceAll("[^a-zA-Z0-9]", ""); //This will remove the spaces and special characters

			scromp.pageScrollDown(driver, mobileName);
			scromp.clickOnButton_Link(driver, mobileName);
			switchToChildWindow(driver);
			scrid.clickOnButton_Link(driver, "AddToCart");
			scrh.clickOnButton_Link(driver, "FlipkartLogo");

			driver.findElement(By.xpath("//body/div[3]/div/div/button")).click(); //Closes pop up

			scrh.clickOnButton_Link(driver, "Cart");
			//scrc.isElementVisible(driver, mobileName);
			scrc.clickOnButton_Link(driver, "PlaceOrder");
			String userName = prop.getProperty("username");
			String pass = prop.getProperty("password");

			scrl.fillText(driver, "Email_phone", userName);
			scrl.clickOnButton_Link(driver, "Continue");

			//scrl.isElementVisible(driver, "Password");
			scrl.fillText(driver, "Password", pass);

			scrl.isElementEnable(driver, "Login");

			scrl.clickOnButton_Link(driver, "Login");

			scros.clickOnButton_Link(driver, "Continue");

			scrpo.clickOnButton_Link(driver, "NetBanking");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}