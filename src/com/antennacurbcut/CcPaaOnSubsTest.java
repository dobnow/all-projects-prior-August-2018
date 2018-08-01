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
import com.pages.DobDocumentsPage;
import com.pages.DobPW1Page;
import com.pages.CrmTaskFormPage;
import com.pages.DobSignaturesPage;
import com.base.TestBase;
import com.pages.CityPayPage;
import com.relevantcodes.extentreports.LogStatus;

public class CcPaaOnSubsTest extends TestBase {
	
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
	
	@AfterClass
	public void setChrome() {
		setConfigBrowser("Chrome");
	}

	@AfterSuite
	public void killDrivers() {
		quitDriver();
		killDriver();
	}

	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData("CcPaaOnSubsTest", xlsx);
	}

	@Test(priority = 0, dataProvider = "getTestData")
	public void Base(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("CcPaaOnSubsTest", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		setConfigBrowser("Chrome");
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		DobPW1Page pw1 = PageFactory.initElements(driver, DobPW1Page.class);		
		DobSignaturesPage signature = PageFactory.initElements(driver, DobSignaturesPage.class);
		DobDocumentsPage docs = PageFactory.initElements(driver, DobDocumentsPage.class);
		
		
		
		
		dash.paa(data.get("filter"));
		pw1.pAa(data.get("paa"));	
		signature.applicantSignature(data.get("signatures_paa"));
		signature.ownerSignature(data.get("owner_signature"));		
		docs.uploadDocuments(data.get("docs_paa"));
		setConfigBrowser("IE");
	}

	// PAY NOW CITY PAY
	@Test(priority = 4, dataProvider = "getTestData", dependsOnMethods = {"Base"})//
	public void PayNowCityPayTest(Hashtable<String, String> data) {
		CityPayPage pay = PageFactory.initElements(driver, CityPayPage.class);
		pay.cityPay(data.get("pay_now_paa"));
	}
	
	// PREVIEW TO FILE
	@Test(priority = 5, dataProvider = "getTestData", dependsOnMethods = {"PayNowCityPayTest"})//
	public void PreviewToFilePaaTest(Hashtable<String, String> data) {
		DobPW1Page pw1 = PageFactory.initElements(driver, DobPW1Page.class);
		pw1.previewToFile(data.get("preview_to_file_paa"));
	}
	
/*// CPE VIEW-ACCEPT DOCS
	@Test(priority= 6, dataProvider="getTestData", dependsOnMethods={"PreviewToFilePaaTest"})
	public void CPEAcceptDocsPaaTest(Hashtable<String,String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.viewAcceptDocuments(data.get("cpe_docs_paa"));
	}
	  // CPE ASSIGN TO PE
 	@Test(priority=7, dataProvider="getTestData", dependsOnMethods={"CPEAcceptDocsPaaTest"})
	public void ChiefPlanExaminerPaaTest(Hashtable<String,String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.cpeAction(data.get("cpe_docs_paa"));
	}	
	// PE ASSERT PAA APPROVED
		@Test(priority=8, dataProvider="getTestData", dependsOnMethods={"ChiefPlanExaminerPaaTest"})
		public void PlanExaminerAssertPaatest(Hashtable<String,String> data) {
			CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
			task_form.peAction(data.get("pe_approved_paa"));
			successMessage(data.get("description"));
		}*/	
}