package com.plspsd;

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

import com.base.TestBase;
import com.pages.DobDashboardPage;
import com.pages.DobDocumentsPage;
import com.pages.DobPW1Page;
import com.pages.DobSOWPage;
import com.pages.DobPW3Page;
import com.pages.DobTR1Page;
import com.pages.DobTR8Page;
import com.pages.DobSignaturesPage;
import com.relevantcodes.extentreports.LogStatus;

public class SpNew extends TestBase {
	
	String testname = "SpNew";
	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesPlm);
	
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

	@DataProvider(parallel = true)
	public Object[][] getTestData() {
		return TestUtil.getData(testname, xlsx);
	}

	@Test(dataProvider = "getTestData",invocationCount = 1)
	public void Base(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		DobPW1Page pw1 = PageFactory.initElements(driver, DobPW1Page.class);
		DobSOWPage asw = PageFactory.initElements(driver, DobSOWPage.class);
		DobPW3Page pw3 = PageFactory.initElements(driver, DobPW3Page.class);
		DobTR1Page tr1 = PageFactory.initElements(driver, DobTR1Page.class);
		DobTR8Page tr8 = PageFactory.initElements(driver, DobTR8Page.class);
		DobSignaturesPage signature = PageFactory.initElements(driver, DobSignaturesPage.class);
		DobDocumentsPage docs = PageFactory.initElements(driver, DobDocumentsPage.class);

		

		
		dash.selectWorkTypePlumbing(data.get("work_type"));
		pw1.locationImfo(data.get("address"));
		type(Constants.pw1_1_apt_suite_number, testname);
		pw1.workOnFloors(data.get("work_on_floors"));
		pw1.applicantInfoPlumbing(data.get("user_info"));
		pw1.reviewtype(data.get("filing_review_type"));
		pw1.workTypesPlumbing(data.get("new_existing_both"));
		pw1.additionalInforPlumbing(data.get("additional_info"));
		pw1.additionalConciderations(data.get("additional_conciderations"));
		pw1.complianceNYCECC(data.get("nycecc"));
		pw1.buildingCharacteristics(data.get("building_charcteristics"));
		pw1.siteCharacteristics(data.get("site_characteristics"));
		pw1.savePW1(data.get("save_pw1"));
		asw.scopeOfWorkPlumbingNew(data.get("asw"));
//		asw.scopeOfWorkPlumbingLegalization(data.get("asw"));
		pw3.costAffidavitPlumbingNew(data.get("pw3"));
//		pw3.costAffidavitPlumbingLegalization(data.get("pw3"));
		tr1.specialInspectionPlumbing(data.get("tr1"));
		tr1.specialInspectorSignaturePlumbing(data.get("tr1"));
		tr8.energyCodeProgressPlumbing(data.get("tr8"));
		tr8.energyCodeSignaturePlumbing(data.get("tr8"));
		signature.applicantStatementsSignature(data.get("signatures"));
		signature.ownerSignature(data.get("owner_signature"));
		docs.uploadDocuments(data.get("documents"));
//		pw1.previewToFile(data.get("preview_to_file"));
		successMessage(data.get("description"));
	}

	
/*
	// CPE VIEW-ACCEPT DOCS
	@Test(priority = 13, dataProvider = "getTestData", dependsOnMethods = {"PreviewToFile"})
	public void CPEAcceptDocsTest(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.viewAcceptDocuments(data.get("chief_plan_examiner"));
	}

	// CPE ASSIGN
	@Test(priority = 14, dataProvider = "getTestData", dependsOnMethods = {"CPEAcceptDocsTest"})
	public void ChiefPlanExaminerTest(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.cpeAction(data.get("chief_plan_examiner"));
	}

	// PE ACTION
	@Test(priority = 15, dataProvider = "getTestData", dependsOnMethods = {"ChiefPlanExaminerTest"})
	public void PlanExaminerTest(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.peAction(data.get("plan_examiner"));
	}

	// PW2-2
	@Test(priority = 16, dataProvider = "getTestData", dependsOnMethods = {"PlanExaminerTest"})
	public void WorkPermit2Test(Hashtable<String, String> data) {
		DobPW2Page pw2 = PageFactory.initElements(driver, DobPW2Page.class);
		pw2.workPermitPlumbing(data.get("pw2_2"));
		pw2.uploadDocuments(data.get("pw2_2_documents"));
	}

	// QA SUPERVISER
	@Test(priority = 17, dataProvider = "getTestData", dependsOnMethods = {"WorkPermit2Test"})
	public void QaSuperviserTest(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		CrmTR1Page tr1 = PageFactory.initElements(driver, CrmTR1Page.class);
		CrmTR8Page tr8 = PageFactory.initElements(driver, CrmTR8Page.class);
		task_form.viewAcceptDocuments(data.get("qa_superviser"));
		tr1.viewAcceptTR1Plumbing(data.get("tr_docs"));
		tr8.viewAcceptTR8PDocs(data.get("qa_superviser"), data.get("tr_docs"));
		task_form.assignTo(data.get("qa_superviser"));
	}

	// QA ADMIN ACCEPT PW2 DOCS
	@Test(priority = 18, dataProvider = "getTestData", dependsOnMethods = {"QaSuperviserTest"})
	public void QaAdministratorAcceptPW2Test(Hashtable<String, String> data) {
		CrmPW2Page pw2 = PageFactory.initElements(driver, CrmPW2Page.class);
		pw2.viewAcceptPW2Docs(data.get("qa_administrator"), data.get("accept_pw2_docs"));
	}

	// ISSUE PERMIT
	@Test(priority = 19, dataProvider = "getTestData", dependsOnMethods = {"QaAdministratorAcceptPW2Test"})
	public void IssuePermitTest(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.isuePermit(data.get("qa_administrator"));
		successMessage(data.get("description"));
	}
*/
}