package testscripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bizobjects.flipkart.cases.UCItemPurchase;
import commonutils.CommonBusiness;

public class Test_Purchase extends CommonBusiness {

	Properties prop = null;
	WebDriver driver = null;

	@BeforeTest
	@Parameters({"Browser"})
	public void LaunchBrowser(String Browser) {

		String url = null;
		String method = getCallingMethod(0);
		logStartMethod(method);
		try {
			String projectLoc = System.getProperty("user.dir");
			prop = readDataFile(projectLoc + "\\testdata\\data.properties");
			url = prop.getProperty("url");

			driver = launchBrowser(Browser,url);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void processItemPurchase() {
		UCItemPurchase ucip = new UCItemPurchase();
		ucip.processItemPurchase(driver, prop);
		takeScreenshot(driver);
	}

	@AfterTest
	public void closeBrowser() throws Exception {

		String method = getCallingMethod(0);
		logStartMethod(method);
		driver.close();
		driver.quit();
	}
}