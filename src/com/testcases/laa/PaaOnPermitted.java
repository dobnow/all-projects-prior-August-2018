package com.testcases.laa;

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
import com.pages.DobPW3Page;
import com.pages.DobSOWPage;
import com.pages.CrmTaskFormPage;
import com.pages.DobDS1Page;
import com.relevantcodes.extentreports.LogStatus;
import com.pages.DobSignaturesPage;
import com.pages.DobTR1Page;
import com.pages.DobTR8Page;
import com.pages.LaaPage;
import com.base.TestBase;
import com.pages.CityPayPage;

public class PaaOnPermitted extends TestBase {
	
	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesesLaa);
	String testname = "PaaOnPermitted";
	
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

	@AfterSuite(alwaysRun=true)
	public void killDrivers() {
		killDriver();
	}

	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData(testname, xlsx);
	}
	
	LaaPage laa = new LaaPage();
	
	DobDashboardPage dash = new  DobDashboardPage();
	DobPW1Page pw1 = new  DobPW1Page();
	DobDS1Page ds1 = new DobDS1Page();
	DobSOWPage asw = new DobSOWPage();
	DobPW3Page pw3 = new DobPW3Page();
	DobTR1Page tr1 = new DobTR1Page();
	DobTR8Page tr8 = new DobTR8Page();
	DobSignaturesPage signature = new DobSignaturesPage();
	DobDocumentsPage docs = new DobDocumentsPage();
	
	@Test(priority = 0, dataProvider = "getTestData")
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		
		
		

		laa.filterAndAction(data.get("action"));
		laa.pAa(data.get("paa"));	
		laa.uploadDocuments(data.get("documents"));
		laa.signatures(data.get("signature"));
		laa.previewToFile(data.get("file"));
		successMessage(data.get("description"));
	}
	

	
}