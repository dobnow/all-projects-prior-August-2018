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
import com.pages.DobPW1Page;
import com.pages.DobPW3Page;
import com.relevantcodes.extentreports.LogStatus;
import com.base.TestBase;
import com.pages.CityPayPage;

public class PaySubsByCreditCardTest extends TestBase {
	
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
		quitDriver();
		killDriver();
	}

	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData("PaySubsByCreditCardTest", xlsx);
	}

	@Test(priority = 0, dataProvider = "getTestData")
	public void Base(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("PaySubsByCreditCardTest", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		DobPW1Page pw1 = PageFactory.initElements(driver, DobPW1Page.class);
		DobPW3Page pw3 = PageFactory.initElements(driver, DobPW3Page.class);
		
		CityPayPage pay = PageFactory.initElements(driver, CityPayPage.class);
		pay.cityPay(data.get("pay_now"));
		
		dash.subsFilingAction(data.get("filter"));
		dash.selectWorkTypeSubs(data.get("work_type_subs"));
		pw1.workOnFloors(data.get("work_on_floors"));
		pw1.applicantInfo(data.get("user_info"));
		pw1.directive14acceptanceRequested(data.get("job_project_type"));
		pw1.workTypes(data.get("new_existing_both"));
		pw1.additionalInfoSubs(data.get("cost_floor_area_build_type"));
		pw1.additionalConciderationsAntenna(data.get("demolition"));
		pw1.complianceNYCECC(data.get("nycecc"));
		pw1.zonningCharacteristics(data.get("dist_overlay_spec_dist_map"));
		pw1.buildingCharacteristics(data.get("building_charcteristics"));
		pw1.fireProtectionEquipment(data.get("fire_equipment"));
		pw1.siteCharacteristics(data.get("site_characteristics"));
		pw1.savePW1(data.get("pw1_subs")); 
		pw3.costAffidavit(data.get("pw3"));
		setConfigBrowser("IE");
	}

	// PAY NOW / CITY PAY
	@Test(priority = 2, dataProvider = "getTestData", dependsOnMethods = {"Base"})
	public void CityPay(Hashtable<String, String> data) {
		CityPayPage pay = PageFactory.initElements(driver, CityPayPage.class);
		pay.cityPay(data.get("pay_now"));
		successMessage(data.get("description"));
	}

}