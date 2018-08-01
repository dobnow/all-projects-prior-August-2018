package com.antennacurbcut;

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
import com.pages.CrmTaskFormPage;
import com.base.TestBase;
import com.pages.CrmPW2Page;
import com.pages.DobAHVPage;
import com.relevantcodes.extentreports.LogStatus;

public class AnAhvTest extends TestBase {
	
	Xls_Reader xlsx = new Xls_Reader(Constants.testCases);
	String testname = "AnAhvTest";
	
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
		return TestUtil.getData("testname", xlsx);
	}

	@Test(priority = 0, dataProvider = "getTestData")
	public void Base(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("testname", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		

	}
	
	// AHV
	@Test(priority = 1, dataProvider = "getTestData", dependsOnMethods={"Base"})
	public void AHVTest(Hashtable<String, String> data) {
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		dash.ahv(data.get("ahv"), data.get("filter"));
		DobAHVPage ahv = PageFactory.initElements(driver, DobAHVPage.class);
		ahv.antennaAHV(data.get("ahv"));
	}
	// 020 ACCEPT PW2 DOCS
	@Test(priority = 2, dataProvider = "getTestData", dependsOnMethods = {"AHVTest"})
	public void AcceptPW2Docs(Hashtable<String, String> data) {
		CrmPW2Page pw2 = PageFactory.initElements(driver, CrmPW2Page.class);
		pw2.viewAcceptPW2DocsAhv(data.get("qa_superviser_ahv"));
	}
	
	// 020 ACCEPT AHW DOCS
	@Test(priority = 3, dataProvider = "getTestData", dependsOnMethods = {"AcceptPW2Docs"})
	public void AcceptAHWDocs(Hashtable<String, String> data) {
/*		CrmPW2Page pw2 = PageFactory.initElements(driver, CrmPW2Page.class);
		pw2.viewAcceptAhvPW2Docs(data.get("qa_superviser_ahv"));*/
	}
	
	// CRM QA SUPERVISER
	@Test(priority = 4, dataProvider = "getTestData", dependsOnMethods = {"AcceptAHWDocs"})
	public void QaSuperviserAhv(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.assignToSelfAhv(data.get("qa_superviser_ahv"));
	}

	// QA DECISION
	@Test(priority = 5, dataProvider = "getTestData", dependsOnMethods = {"QaSuperviserAhv"})
	public void QaDecisionTest(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.qaAction(data.get("qa_superviser_ahv"));
		successMessage(data.get("description"));
	}
	
}