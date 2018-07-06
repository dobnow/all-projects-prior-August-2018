package com.testcases.ancc;

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
import com.pages.DobDashboardPage;
import com.pages.DobPW3Page;
import com.base.TestBase;
import com.pages.CityPayPage;
import com.pages.DobSOWPage;
import com.relevantcodes.extentreports.LogStatus;

public class PayInitialByCheckTest extends TestBase {
	
	Xls_Reader xlsx = new Xls_Reader(Constants.testCases);
	
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
		return TestUtil.getData("PayInitialByCheckTest", xlsx);
	}

	@Test(priority = 0, dataProvider = "getTestData")
	public void Base(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("PayInitialByCheckTest", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		setConfigBrowser("Chrome");
		
	}

	// INITIAL
	@Test(priority = 1, dataProvider = "getTestData", dependsOnMethods = {"Base"})
	public void Filter(Hashtable<String, String> data) {
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		dash.filterJob(data.get("filter"));
		addToProps("job_number", text(Constants.job_label).trim().substring(6, 15).trim());	

	}
	
	// ASOW ANTENNA SCOPE OF WORK
	@Test(priority = 2, dataProvider = "getTestData", dependsOnMethods = {"Filter"})
	public void ASOW(Hashtable<String, String> data) {
		DobSOWPage asw = PageFactory.initElements(driver, DobSOWPage.class);
		asw.scopeOfWork(data.get("asw"));
	}

	// PW3
	@Test(priority = 3, dataProvider = "getTestData", dependsOnMethods = {"ASOW"})
	public void PW3(Hashtable<String, String> data) {
		DobPW3Page pw3 = PageFactory.initElements(driver, DobPW3Page.class);
		pw3.costAffidavit(data.get("pw3"));
		setConfigBrowser("IE");
		initConfigurations();
	}
	
	// PAY NOW / CITY PAY
	@Test(priority = 4, dataProvider = "getTestData", dependsOnMethods = {"PW3"})
	public void CityPay(Hashtable<String, String> data) {
		CityPayPage pay = PageFactory.initElements(driver, CityPayPage.class);
		pay.cityPay(data.get("pay_now"));
		successMessage(data.get("description"));
	}
	// SET CHROME
	@Test(priority=5, dataProvider = "getTestData")
	public void SetBrowserToChrome(Hashtable<String, String> data) {
		setConfigBrowser("Chrome");
	}
}