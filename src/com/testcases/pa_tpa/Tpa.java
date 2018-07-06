package com.testcases.pa_tpa;

import com.util.Constants;
import com.util.TestUtil;
import com.util.Xls_Reader;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.base.TestBase;
import com.pages.CrmTaskFormPage;
import com.pages.PaPage;
import com.relevantcodes.extentreports.LogStatus;

public class Tpa extends TestBase {

	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesesAssembly);

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
		return TestUtil.getData("Tpa", xlsx);
	}

	@Test(priority = 0, dataProvider = "getTestData", invocationCount = 19)
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("Tpa", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping the test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		PaPage pa = new PaPage();		
		CrmTaskFormPage task_form = new CrmTaskFormPage();
		
//		pa.owner(data.get("owner"));
//		task_form.viewAcceptDocuments(data.get("cpe"));
		
		pa.selectWorkTypePa(data.get("work_type"));
		pa.locationImfo(data.get("address"));
		pa.workOnFloors(data.get("work_on_floors"));
		pa.applicantInfo(data.get("user_info"));
		pa.reviewtype(data.get("filing_review_type"));
		pa.ownerinfo(data.get("owner_info"));
//		pa.party(data.get("party"));	
		pa.saveGI("Y");
		pa.scopeOfWorkTpa(data.get("event_info"));
		pa.techReport(data.get("tech_report"));
		pa.progressInspector(data.get("tech_report"));
		pa.signatures(data.get("signature"));
		pa.owner(data.get("owner"));
		pa.uploadDocuments(data.get("documents"));
		pa.previewToFile(data.get("file"));
		successMessage(data.get("description"));
	}

	// ASSIGN TO TEAM
	@Test(priority = 1, dataProvider = "getTestData", dependsOnMethods = {"Portal"})
	public void CentralAssigner(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.centralAssigner(data.get("cpe_acpe"));
	}

	// CPE VIEW-ACCEPT DOCS ASSIGN TO PE
	@Test(priority = 2, dataProvider = "getTestData", dependsOnMethods = {"CentralAssigner"})
	public void CpeAssign(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.cpeAssign(data.get("cpe"));
		task_form.viewAcceptDocuments(data.get("cpe"));
		task_form.viewAcceptDocuments(data.get("cpe"));
	}
	
	
	
	
	// PE 2 ACTION
	@Test(priority = 3, dataProvider = "getTestData", dependsOnMethods = {"CpeAssign"})
	public void secondaryPeAction(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.viewAcceptDocuments(data.get("secondary_pe"));
	}
	// PE 1 ACTION
	@Test(priority = 4, dataProvider = "getTestData", dependsOnMethods = {"CpeAssign"})
	public void primaryPeAction(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.peAction(data.get("primary_pe"));
	}
	// CPE ACTION
	@Test(priority = 5, dataProvider = "getTestData", dependsOnMethods = {"primaryPeAction","secondaryPeAction"})
	public void CpeAction(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.cpeAction(data.get("chief_plan_examiner"));
	}

}