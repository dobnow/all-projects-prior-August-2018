package com.antennacurbcut;

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
import com.pages.CrmTaskFormPage;
import com.base.TestBase;
import com.pages.CrmPW2Page;
import com.relevantcodes.extentreports.LogStatus;

public class AnPermitRenewalTest extends TestBase {
	
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
	
	@AfterClass
	public void setChrome() {
		setConfigBrowser("Chrome");
	}

	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData("AnPermitRenewalTest", xlsx);
	}
	
	@Test(priority = 0, dataProvider = "getTestData")
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("AnPermitRenewalTest", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());		
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		

		
		dash.renewPermit(data.get("filter"));
		switchToIE(data.get("filter"));
		dash.renewPermitPay(data.get("filter"));
		dash.filePermit(data.get("renew_permit"), "Permit Entire");		
	}

	// QA SUPERVISER
	@Test(priority = 1, dataProvider = "getTestData", dependsOnMethods={ "Portal"})
	public void QaSuperviserRenewal(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.assignTo(data.get("qa_superviser"));
	}

	// QA ADMIN
	@Test(priority = 2, dataProvider = "getTestData", dependsOnMethods={ "QaSuperviserRenewal"})
	public void QaAdministratorRenewal(Hashtable<String, String> data) {
		CrmPW2Page pw2 = PageFactory.initElements(driver, CrmPW2Page.class);
		pw2.viewAcceptPW2Docs(data.get("qa_administrator_renewal"), data.get("accept_pw2_docs_renewal"));
	}

	// ISSUE PERMIT
	@Test(priority = 3, dataProvider = "getTestData", dependsOnMethods={ "QaAdministratorRenewal"})
	public void IssuePermitRenewal(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.isuePermit(data.get("qa_administrator_renewal"));
		successMessage(data.get("description"));
	}
	
}