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
import com.base.TestBase;
import com.pages.CrmTaskFormPage;
import com.pages.DobSignaturesPage;
import com.relevantcodes.extentreports.LogStatus;

public class AnCorrectionsTest extends TestBase {	
	
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
 	public Object[][] getTestData()	{
 		return TestUtil.getData("AnCorrectionsTest", xlsx);
 	}
 	
	@Test(priority = 0, dataProvider = "getTestData")
	public void Base(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("AnCorrectionsTest", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());

	}

	// PW1
	@Test(priority = 1, dataProvider = "getTestData", dependsOnMethods = {"Base"})
	public void Correction(Hashtable<String, String> data) {
		if (!data.get("filing_review_type").equals("")) {
			DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
			dash.correction(data.get("filter"));
			DobPW1Page pw1 = PageFactory.initElements(driver, DobPW1Page.class);
			pw1.correction(data.get("correction"), data.get("description"));
			DobSignaturesPage signature = PageFactory.initElements(driver, DobSignaturesPage.class);
			signature.applicantSignature(data.get("correction"));
			signature.ownerSignature(data.get("correction"));
	  		pw1.previewToFile(data.get("resubmit"));
		}
	}
	 // CPE VIEW-ACCEPT DOCS
	 	@Test(priority=4, dataProvider="getTestData", dependsOnMethods={"Correction"})
	 	public void CPEAcceptDocsTest(Hashtable<String,String> data) {
			CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
			task_form.viewAcceptDocuments(data.get("chief_plan_examiner"));
	 	}
	 // CPE
	 	@Test(priority=5, dataProvider="getTestData", dependsOnMethods={"CPEAcceptDocsTest"})
		public void ChiefPlanExaminerTest(Hashtable<String,String> data) {
			CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
			task_form.cpeAction(data.get("chief_plan_examiner"));
		}
	// PE 	
		@Test(priority=6, dataProvider="getTestData", dependsOnMethods={"ChiefPlanExaminerTest"})
		public void PlanExaminerAssert(Hashtable<String,String> data) {
			CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
			task_form.assertCorrection(data.get("plan_examiner"), data.get("correction"));
		}	

		@Test(priority=7, dataProvider="getTestData", dependsOnMethods={"PlanExaminerAssert"})
		public void PlanExaminerTest(Hashtable<String,String> data) {
			CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);		
			task_form.peAction(data.get("plan_examiner"));
			successMessage(data.get("description"));
		}
	
}