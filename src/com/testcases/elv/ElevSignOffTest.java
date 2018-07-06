package com.testcases.elv;

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
import com.pages.CrmTaskFormPage;
import com.pages.DobDashboardPage;
import com.pages.ElevatorsGeneralInfoPage;
import com.pages.ElevatorsDevicedetailsPage;
import com.pages.ElevatorsInsurancePage;
import com.pages.ElevatorsDocumentsPage;
import com.pages.ElevatorsSignaturesPage;
import com.relevantcodes.extentreports.LogStatus;
import com.pages.SignOffPage;


public class ElevSignOffTest extends TestBase {

	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesesElevator);

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
		return TestUtil.getData("ElevSignOffTest", xlsx);
	}

	@Test(priority = 0, dataProvider = "getTestData")
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("ElevSignOffTest", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping the test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		ElevatorsGeneralInfoPage gi = PageFactory.initElements(driver, ElevatorsGeneralInfoPage.class);
		ElevatorsDevicedetailsPage dd = PageFactory.initElements(driver, ElevatorsDevicedetailsPage.class);
		ElevatorsInsurancePage ins = PageFactory.initElements(driver, ElevatorsInsurancePage.class);
		ElevatorsDocumentsPage doc = PageFactory.initElements(driver, ElevatorsDocumentsPage.class);
		ElevatorsSignaturesPage dig = PageFactory.initElements(driver, ElevatorsSignaturesPage.class);
		dash.jobFilingElev(data.get("work_type"));
		gi.searchAddDevice(data.get("address"));
		dd.deviceInfo2(data.get("device_info"));
		dd.machineRoom(data.get("machine_room"));
		dd.deviceGeneralinfo(data.get("device_general_info"));
		dd.carsCounterweight(data.get("cars_counterweight"));
		dd.hoistwayOpeneing(data.get("hoistway_opening"));
		dd.pitAndBuffers(data.get("pit_and_buffers"));
		ins.insuranceFeeInfo(data.get("insurance_fee"));
		doc.documents(data.get("documents"));
		dig.signaturesSignOff(data.get("signatures"));
		gi.previewToFile(data.get("preview_to_file"));
		successMessage(data.get("description"));
	}

/*	// CPE VIEW-ACCEPT DOCS
	@Test(priority = 7, dataProvider = "getTestData", dependsOnMethods = {"Portal"})
	public void CPEAcceptDocs(Hashtable<String, String> data) {
		CrmTaskFormPage crm_task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		crm_task_form.viewAcceptDocsElv(data.get("cpe"));
	}

	// CPE ASSIGN TO PE
	@Test(priority = 8, dataProvider = "getTestData", dependsOnMethods = {"CPEAcceptDocs"})
	public void ChiefPlanExaminer(Hashtable<String, String> data) {
		CrmTaskFormPage crm_task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		crm_task_form.cpeAssignToSelfElv(data.get("cpe"));
	}

	// PE Permit Issued
	@Test(priority = 9, dataProvider = "getTestData", dependsOnMethods = {"ChiefPlanExaminer"})
	public void PlanExaminer(Hashtable<String, String> data) {
		CrmTaskFormPage crm_task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		crm_task_form.cpeActionElv(data.get("cpe_action"));
	}

	// Sign Off
	@Test(priority = 10, dataProvider = "getTestData", dependsOnMethods = {"PlanExaminer"})
	public void SignOff(Hashtable<String, String> data) {
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		dash.requestSinOff(data.get("action"));
		SignOffPage off = PageFactory.initElements(driver, SignOffPage.class);
		off.inspectingAgencyinfo(data.get("sign_off_info"));
		off.testInfo(data.get("sign_off_info"));
		off.signatures(data.get("sign_off_info"));
		off.submit(data.get("sign_off_info"));
		successMessage(data.get("description"));
	}*/
	
}