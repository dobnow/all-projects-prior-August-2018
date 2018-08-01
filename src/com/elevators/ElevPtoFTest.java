package com.elevators;

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
import com.pages.DobDashboardPage;
import com.pages.ElevatorsPage;
import com.relevantcodes.extentreports.LogStatus;

public class ElevPtoFTest extends TestBase {

	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesesElevator);
	String testname = "ElevPtoFTest";

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
		return TestUtil.getData(testname, xlsx);
	}
	
	ElevatorsPage elv = new ElevatorsPage();
	DobDashboardPage dash = new DobDashboardPage();

	@Test(priority = 0, dataProvider = "getTestData")
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping the test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());

		
		
		
		dash.jobFilingElev(data.get("work_type"));
		elv.searchAddDevice(data.get("address"));
		elv.deviceInfo2(data.get("device_info"));
		elv.machineRoom(data.get("machine_room"));
		elv.deviceGeneralinfo(data.get("device_general_info"));
		elv.carsCounterweight(data.get("cars_counterweight"));
		elv.hoistwayOpeneing(data.get("hoistway_opening"));
		elv.pitAndBuffers(data.get("pit_and_buffers"));
		elv.insuranceFeeInfo(data.get("insurance_fee"));
		elv.documents(data.get("documents"));
		elv.signatures(data.get("signatures"));
		elv.previewToFile(data.get("preview_to_file"));
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
	public void ApproveDevice(Hashtable<String, String> data) {
		CrmTaskFormPage crm_task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		crm_task_form.peApproveDevice(data.get("cpe_action"));
		successMessage(data.get("description"));
	}*/

}