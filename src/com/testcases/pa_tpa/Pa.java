package com.testcases.pa_tpa;

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
import com.base.TestBase;
import com.pages.CrmTaskFormPage;
import com.pages.PaPage;
import com.relevantcodes.extentreports.LogStatus;

public class Pa extends TestBase {

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
		return TestUtil.getData("Pa", xlsx);
	}

	@Test(priority = 0, dataProvider = "getTestData", invocationCount = 1)
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("Pa", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping the test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		PaPage pa = new PaPage();
		

		
		pa.selectWorkTypePa(data.get("work_type"));
		pa.locationImfo(data.get("address"));
		pa.workOnFloors(data.get("work_on_floors"));
		pa.zonning(data.get("work_on_floors"));
		pa.applicantInfo(data.get("user_info"));
		pa.reviewtype(data.get("filing_review_type"));
		pa.ownerinfo(data.get("owner_info"));
		pa.party(data.get("party"));
		pa.saveGI("Y");
		pa.scopeOfWorkPa(data.get("event_info"));
		pa.techReport(data.get("tech_report"));
		pa.progressInspector(data.get("tech_report"));
		pa.signatures(data.get("signature"));
		pa.owner(data.get("owner"));
		pa.uploadDocuments(data.get("documents"));
		pa.previewToFile(data.get("file"));
		successMessage(data.get("description"));
	}

/*	// CPE VIEW-ACCEPT DOCS
	@Test(priority = 7, dataProvider = "getTestData", dependsOnMethods = { "Portal" })
	public void CPEAcceptDocs(Hashtable<String, String> data) {
		CrmTaskFormPage crm_task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		crm_task_form.viewAcceptDocsElv(data.get("cpe"));
	}

	// CPE ASSIGN TO PE
	@Test(priority = 8, dataProvider = "getTestData", dependsOnMethods = { "CPEAcceptDocs" })
	public void ChiefPlanExaminer(Hashtable<String, String> data) {
		CrmTaskFormPage crm_task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		crm_task_form.cpeAssignToSelfElv(data.get("cpe"));
	}

	// PE Permit Issued
	@Test(priority = 9, dataProvider = "getTestData", dependsOnMethods = { "ChiefPlanExaminer" })
	public void PlanExaminer(Hashtable<String, String> data) {
		CrmTaskFormPage crm_task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		crm_task_form.cpeActionElv(data.get("cpe_action"));
		successMessage(data.get("description"));
	}*/

}