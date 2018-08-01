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
import com.pages.DobPW1Page;
import com.pages.DobPW2Page;
import com.base.TestBase;
import com.pages.CrmPW2Page;
import com.pages.CrmTR1Page;
import com.pages.CrmTR8Page;
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
	public void Correction(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("AnCorrectionsTest", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		DobPW1Page pw1 = PageFactory.initElements(driver, DobPW1Page.class);
		DobSignaturesPage signature = PageFactory.initElements(driver, DobSignaturesPage.class);
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		
		

		task_form.cpeAssign(data.get("chief_plan_examiner"));
		
		
		

		dash.correction(data.get("filter"));
		pw1.correction(data.get("correction"), data.get("description"));
		signature.applicantSignature(data.get("correction"));
		signature.ownerSignature(data.get("correction"));
		pw1.previewToFile(data.get("resubmit"));
		//
		task_form.cpeAssign(data.get("chief_plan_examiner"));
		
		task_form.viewAcceptDocuments(data.get("primary_pe"));
		task_form.cpeAction(data.get("primary_pe"));
	}
	
	
/*	// ASSIGN TO TEAM
	@Test(priority = 1, dataProvider = "getTestData", dependsOnMethods = {"Portal"})
	public void CentralAssigner(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.centralAssigner(data.get("cpe_acpe"));
	}*/

	// CPE VIEW-ACCEPT DOCS ASSIGN TO PE
/*	@Test(priority = 2, dataProvider = "getTestData", dependsOnMethods = {"Correction"})
	public void CpeAssign(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.cpeAssign(data.get("chief_plan_examiner"));
	}*/
	
	// PE 2 ACTION
	@Test(priority = 3, dataProvider = "getTestData", dependsOnMethods = {"Correction"})
	public void secondaryPeAction(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.viewAcceptDocuments(data.get("secondary_pe"));
	}
	// PE 1 ACTION
	@Test(priority = 4, dataProvider = "getTestData", dependsOnMethods = {"secondaryPeAction"})
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
	
	// PW2-2
	@Test(priority = 16, dataProvider = "getTestData", dependsOnMethods = {"CpeAction"})
	public void WorkPermit2Test(Hashtable<String, String> data) {
		DobPW2Page pw2 = PageFactory.initElements(driver, DobPW2Page.class);
		pw2.workPermit(data.get("pw2_2"));
//		pw2.uploadDocuments(data.get("pw2_2_documents"));
	}

	// QA SUPERVISER
	@Test(priority = 17, dataProvider = "getTestData", dependsOnMethods = {"WorkPermit2Test"})
	public void QaSuperviserTest(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		CrmTR1Page crmtr1 = PageFactory.initElements(driver, CrmTR1Page.class);
		CrmTR8Page crmtr8 = PageFactory.initElements(driver, CrmTR8Page.class);
//		task_form.viewAcceptDocuments(data.get("qa_superviser"));
		crmtr1.viewAcceptTR1Fuel(data.get("qa_superviser"), data.get("accept_tr"));
		crmtr1.viewAcceptTR1Fina(data.get("qa_superviser"), data.get("accept_tr"));
		crmtr8.viewAcceptTR8PDocs(data.get("qa_superviser"), data.get("accept_tr"));
		task_form.qaSuperviser(data.get("qa_superviser"));
	}

	// QA ADMIN ACCEPT PERMIT DOCUMENTSS / ISSUE PERMIT
	@Test(priority = 18, dataProvider = "getTestData", dependsOnMethods = {"QaSuperviserTest"})
	public void QaAdministratorAcceptPW2Test(Hashtable<String, String> data) {
		
		CrmPW2Page pw2 = PageFactory.initElements(driver, CrmPW2Page.class);
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		pw2.viewAcceptPW2Docs(data.get("qa_administrator"), data.get("accept_pw2_docs"));
		task_form.isuePermit(data.get("qa_administrator"));
		successMessage(data.get("description"));
		
/*		CrmPW2Page pw2 = PageFactory.initElements(driver, CrmPW2Page.class);
		pw2.viewAcceptPW2Docs(data.get("qa_administrator"), data.get("accept_pw2_docs"));*/
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	 // CPE VIEW-ACCEPT DOCS
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
		}*/
	
}