package com.laa;

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
import com.pages.LaaPage;
import com.relevantcodes.extentreports.LogStatus;

public class EwnNumber extends TestBase {
	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesesLaa);
	String testname = "EwnNumber";

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

	@AfterSuite(alwaysRun=true)
	public void killDrivers() {
		killDriver();
	}

	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData(testname, xlsx);
	}

	LaaPage laa = new LaaPage();
	
	@Test(priority = 0, dataProvider = "getTestData", invocationCount = 1)
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping the test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		
		
		
		laa.clickEWN(data.get("user_info"));		
		laa.locationImfo(data.get("address"));
		laa.applicantInfo(data.get("user_info"));
		laa.saveGI("Y");
		laa.uploadDocuments(data.get("documents"));
		laa.signatures(data.get("signature"));
		laa.submitEwn(data.get("file"));		
		laa.selectWorkType(data.get("user_info"));
		laa.emergencyWorkNotification(data.get("ewn"));
		laa.feeAssessment(data.get("fee_assessment"));
		laa.saveGI("Y");
		laa.scopeOfWork(data.get("sow"));
		laa.uploadDocuments(data.get("documents"));
		laa.signatures(data.get("signature"));
		laa.previewToFile(data.get("file"));
		successMessage(data.get("description"));
	}

}