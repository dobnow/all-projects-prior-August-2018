package com.electrical;

import com.util.Constants;
import com.util.TestUtil;
import com.util.Xls_Reader;
import java.util.Hashtable;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.support.PageFactory;

import com.pages.DobDashboardPage;
import com.pages.ElectricalDashboardPage;
import com.pages.ElectricalGIPage;
import com.pages.ElectricalSOWPage;
import com.pages.ElectricalDocsPage;
import com.pages.ElectricalSignaturesPage;
import com.relevantcodes.extentreports.LogStatus;
import com.base.TestBase;

public class ElOnElSubsTest extends TestBase {
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
	public void closeChromeDriver() {
		killDriver();
	}
	
	@AfterClass
	public void setChrome() {
		setConfigBrowser("Chrome");
	}
	
	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData("ElOnElSubsTest", xlsx);
	}

	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesesEctrical);

	@Test(priority = 1, dataProvider = "getTestData")
	public void GI(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("ElOnElSubsTest", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping the test");
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Data");
		test.log(LogStatus.INFO, data.toString());
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		ElectricalDashboardPage dashel = PageFactory.initElements(driver, ElectricalDashboardPage.class);
		ElectricalGIPage gi = PageFactory.initElements(driver, ElectricalGIPage.class);
		ElectricalSOWPage sow = PageFactory.initElements(driver, ElectricalSOWPage.class);
		ElectricalSignaturesPage signature = PageFactory.initElements(driver, ElectricalSignaturesPage.class);
		ElectricalDocsPage docs = PageFactory.initElements(driver, ElectricalDocsPage.class);
		
		
		
		dashel.subsFilingAction(user, data.get("filter"));
		dashel.selectWorkTypeSubs(data.get("work_type_subs"));
		gi.subsFiling(data.get("owner_info_subs"));
		sow.workDescription(data.get("sow_subs"));
		signature.signaturesEl(data.get("sign_subs"));
		docs.uploadDocumentsEl(data.get("documents_subs"));
		gi.previewToFile(data.get("preview_to_file_subs"));
		successMessage(data.get("description"));
		
	}

}