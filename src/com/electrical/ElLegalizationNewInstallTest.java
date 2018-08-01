package com.electrical;

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
import com.pages.ElectricalDashboardPage;
import com.pages.ElectricalGIPage;
import com.pages.ElectricalSOWPage;
import com.pages.ElectricalDocsPage;
import com.pages.ElectricalSignaturesPage;
import com.relevantcodes.extentreports.LogStatus;
import com.base.TestBase;
import com.pages.CityPayPage;

public class ElLegalizationNewInstallTest extends TestBase {
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
	public void closeChromeDriver() {
		killDriver();
	}

	@AfterClass
	public void setChrome() {
		setConfigBrowser("Chrome");
	}
	
	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData("ElLegalizationNewInstallTest", xlsx);
	}

	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesesEctrical);

	@Test(priority = 1, dataProvider = "getTestData")
	public void GI(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("ElLegalizationNewInstallTest", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping the test");
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Data");
		test.log(LogStatus.INFO, data.toString());
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		ElectricalGIPage gi = PageFactory.initElements(driver, ElectricalGIPage.class);
		ElectricalDashboardPage dash = PageFactory.initElements(driver, ElectricalDashboardPage.class);
		ElectricalSOWPage sow = PageFactory.initElements(driver, ElectricalSOWPage.class);
		ElectricalSignaturesPage signature = PageFactory.initElements(driver, ElectricalSignaturesPage.class);
		ElectricalDocsPage docs = PageFactory.initElements(driver, ElectricalDocsPage.class);
		

		
		loginToPortal(user);
		dash.jobFiling(data.get("work_type"));
		gi.locationInfo(data.get("address"),data.get("description"),data.get("calendar"),data.get("joint_venue"),data.get("use_type"));
		gi.applicantInfo(data.get("applicant_info"));
//		gi.saveGI(data.get("save_gi"));
		gi.ownerInfo(data.get("owner_info"));
		gi.additionalInfo(data.get("additional_info"));
		gi.calendar(data.get("calendar"));
		gi.saveGI(data.get("save_gi"));
		sow.workDescription(data.get("sow"));
		signature.signaturesEl(data.get("sign"));
		verifyText("//span[contains(.,'Legalization Filing Fee')]", "$520.00");
		docs.uploadDocumentsEl(data.get("documents"));
		setConfigBrowser("IE");
		initConfigurations();
	}

	// PAY NOW
	@Test(priority = 2, dataProvider = "getTestData", dependsOnMethods = {"GI"})
	public void PayNow(Hashtable<String, String> data) {
		CityPayPage pay = PageFactory.initElements(driver, CityPayPage.class);
		setConfigBrowser("IE");
		pay.cityPay(data.get("pay_now"));
	}
		
	// FILE
	@Test(priority = 7, dataProvider = "getTestData", dependsOnMethods = {"PayNow"})
	public void PreviewToFile(Hashtable<String, String> data) {
		ElectricalGIPage gi = PageFactory.initElements(driver, ElectricalGIPage.class);
		gi.previewToFile(data.get("preview_to_file"));
		successMessage(data.get("description"));
	}
}