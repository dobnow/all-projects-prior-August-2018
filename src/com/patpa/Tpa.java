package com.patpa;

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
import com.pages.CrmTR1Page;
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
	
	PaPage pa = new PaPage();
	CrmTaskFormPage task_form = new CrmTaskFormPage();
	CrmTR1Page crmtr1 = new CrmTR1Page();	

	@Test(priority = 0, dataProvider = "getTestData", invocationCount = 1)
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("Tpa", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping the test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());

		


		
		
		pa.selectWorkTypePa(data.get("work_type"));
		pa.locationImfo(data.get("address"));
		pa.workOnFloors(data.get("work_on_floors"));
		pa.applicantInfo(data.get("user_info"));
		pa.reviewtype(data.get("filing_review_type"));
		pa.ownerinfo(data.get("owner_info"));
//		pa.party(data.get("party"));	
		pa.saveGI("Y");
		pa.scopeOfWorkTpa(data.get("sow"));
		pa.techReport(data.get("tech_report"));
		pa.progressInspector(data.get("tech_report"));
		pa.signatures(data.get("signature"));
		pa.owner(data.get("owner"));
		pa.uploadDocuments(data.get("documents"));
		pa.previewToFile(data.get("file"));
		task_form.centralAssigner(data.get("cpe_acpe"));
	}

	// CPE ACTIONS
	@Test(priority = 1, dataProvider = "getTestData", dependsOnMethods = { "Portal" })
	public void CPEActiona(Hashtable<String, String> data) {
		task_form.cpeActions(data.get("cpe"));
		task_form.viewAcceptDocuments(data.get("cpe"));
		pa.crmTechnicalReport(data.get("cpe"), "Y");
		task_form.primaryPeAction(data.get("primary_pe"));
		successMessage(data.get("description"));
		
	}

}