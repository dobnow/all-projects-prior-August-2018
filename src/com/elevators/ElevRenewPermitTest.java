package com.elevators;

import com.util.Constants;
import com.util.TestUtil;
import com.util.Xls_Reader;
import java.util.Hashtable;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;
import com.pages.DobDashboardPage;
import com.relevantcodes.extentreports.LogStatus;
import com.pages.CityPayPage;


public class ElevRenewPermitTest extends TestBase {

	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesesElevator);
	String testname = "ElevRenewPermitTest";

	@BeforeSuite
	public void BeforeSuite() {
		initConfigurations();
	}

	@BeforeMethod
	public void init() {
		initDriver();
		getEnvironmentDetails();
	}

	@AfterMethod
	public void quit() {
		quitDriver();
	}

	@AfterSuite
	public void killDrivers() {
		killDriver();
	}

	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData(testname, xlsx);
	}

	@Test(priority = 0, dataProvider = "getTestData")
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
		if (!TestUtil.isExecutable("ElevRenewPermitTest", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping the test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		

		setConfigBrowser("IE");
	}

	@Test(priority = 1, dataProvider = "getTestData", dependsOnMethods = {"Portal"})
	public void renewPermit(Hashtable<String, String> data) {
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		CityPayPage pay = PageFactory.initElements(driver, CityPayPage.class);
		dash.renewPermitElv(data.get("filter"));
		pay.cityPay(data.get("pay_now"));
		dash.submitPermit(data.get("renew"));
		successMessage(data.get("description"));
	}

}