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
import com.pages.DobDocumentsPage;
import com.pages.DobPW1Page;
import com.base.TestBase;
import com.pages.CrmTaskFormPage;
import com.pages.DobSOWPage;
import com.pages.DobPW3Page;
import com.pages.DobDS1Page;
import com.pages.DobTR1Page;
import com.pages.DobTR8Page;
import com.relevantcodes.extentreports.LogStatus;
import com.pages.DobSignaturesPage;

public class AnOnCcSubsTest extends TestBase {
	
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
		return TestUtil.getData("AnOnCcSubsTest", xlsx);
	}

	@Test(priority = 0, dataProvider = "getTestData")
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("AnOnCcSubsTest", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		DobPW1Page pw1 = PageFactory.initElements(driver, DobPW1Page.class);
		DobDS1Page ds1 = PageFactory.initElements(driver, DobDS1Page.class);
		DobSOWPage asw = PageFactory.initElements(driver, DobSOWPage.class);
		DobPW3Page pw3 = PageFactory.initElements(driver, DobPW3Page.class);
		DobTR1Page tr1 = PageFactory.initElements(driver, DobTR1Page.class);
		DobTR8Page tr8 = PageFactory.initElements(driver, DobTR8Page.class);
		DobSignaturesPage signature = PageFactory.initElements(driver, DobSignaturesPage.class);
		DobDocumentsPage docs = PageFactory.initElements(driver, DobDocumentsPage.class);
		


		

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
		ds1.demolitionSubmittal(data.get("ds1"));
		asw.scopeOfWork(data.get("asw"));
		pw3.costAffidavit(data.get("pw3"));
		tr1.specialInspection(data.get("tr1"));
		tr1.specialInspectorSignature(data.get("tr1"));
		tr1.progressInspecSign(data.get("tr1"));
		tr8.energyCodeProgressInspection(data.get("tr8"));
		tr8.energyCodeSignature(data.get("tr8"));
		signature.applicantStatementsSignature(data.get("signatures"));
		signature.ownerSignature(data.get("owner_signature"));
		docs.uploadDocuments(data.get("documents"));
		pw1.previewToFile(data.get("preview_to_file"));
		
	}

/*	// CPE VIEW-ACCEPT DOCS
	@Test(priority = 13, dataProvider = "getTestData", dependsOnMethods = {"Portal"})
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

	// PE ACTION APPROVED
	@Test(priority = 15, dataProvider = "getTestData", dependsOnMethods = {"ChiefPlanExaminerTest"})
	public void PlanExaminerTest(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.peAction(data.get("plan_examiner"));
		successMessage(data.get("description"));
	}*/


}