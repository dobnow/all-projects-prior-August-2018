package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ExtentManager;
import com.util.Constants;
import com.util.ErrorUtil;
import com.util.Xls_Reader;

public class TestBase {

	public static Logger APPLICATION_LOGS = null;
	public static Properties CONFIG = null;
	public static WebDriver driver = null;
	public static boolean isLoggedIn = false;
	public static Properties OR_PROPERTIES = null;
	public static Properties TEXT_PROPERTIES = null;
	public static Properties JOB_NUMBER = null;
	public static final String browsername = null;
	public static String pagesource = null;
	public static String timestamp = null;
	public static String dob_now_url = null;
	public static String crm_url = null;
//	public static String location = null;

	public static String user = null;
	public static String owner = null;
	public static String tr1_user = null;
	public static String tr8_user = null;
	public static String pw2_user = null;
	public static String tr1_lic = null;
	public static String tr8_lic = null;
	public static String pw2_lic = null;
	public static String testname;
	

	public static String exctracted_job_number = null;
	public static String job_number_value = null;

	Xls_Reader xlsx = new Xls_Reader(Constants.testCases);
	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;
	public Assertion hardAssert = new Assertion();
	public SoftAssert softAssertion= new SoftAssert();
	public SoftAssert softAssert= new SoftAssert();
	public String emailpreview;
	
	public void setConfigBrowser(String browser) {
		try {
			System.out.println(convertedTimestamp() + " **************** Set Config Browser to " +browser);
			FileInputStream fileName = new FileInputStream(Constants.CONFIG_FILE_PATH);
			Properties props = new Properties();
			props.load(fileName);
			props.setProperty("browser", browser);
			fileName.close();
			FileOutputStream outFileName = new FileOutputStream(Constants.CONFIG_FILE_PATH);
			props.store(outFileName, "# BROWSERS :: IE  Chrome  ENVIRONMENTS ::  443 444 8085 + WORK TYPES:: antenna curbcut plumbing electrical elevators fab4 laa patpa");
			outFileName.close();
			// props.load(fileName);
			FileInputStream fs = new FileInputStream(Constants.CONFIG_FILE_PATH);
			CONFIG.load(fs);
			test.log(LogStatus.PASS, "Driver set to " +browser);
		} catch (IOException io) {
			io.printStackTrace();
		}
/*		if(driver != null)
			killDriver();*/
	}

	public void initConfigurations() {
		if (CONFIG == null) {
			CONFIG = new Properties();
			try {
				FileInputStream fs = new FileInputStream(Constants.CONFIG_FILE_PATH);
				CONFIG.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (OR_PROPERTIES == null) {
//			APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
			OR_PROPERTIES = new Properties();
			try {
				FileInputStream fs = new FileInputStream(Constants.OR_PROPERTIES);
				OR_PROPERTIES.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (TEXT_PROPERTIES == null) {
//			APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
			TEXT_PROPERTIES = new Properties();
			try {
				FileInputStream fs = new FileInputStream(Constants.TEXT_PROPERTIES);
				TEXT_PROPERTIES.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (JOB_NUMBER == null) {
//			APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
			JOB_NUMBER = new Properties();
			try {
				FileInputStream fs = new FileInputStream(Constants.JOB_NUMBER);
				JOB_NUMBER.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void initDriver() {
		if (driver == null) {
/*			try {
				Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2");
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			if (CONFIG.getProperty("browser").equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", Constants.chromePath);
				System.setProperty("webdriver.chrome.silentOutput", "true");
				
/*				System.setProperty("webdriver.chrome.logfile", "NUL");
                System.setProperty("webdriver.chrome.args", "--disable-logging");
                System.setProperty("webdriver.chrome.silentOutput", "true");*/
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--log-level=3");
				options.addArguments("--silent");
				options.addArguments("--start-maximized");
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-web-security");
				options.addArguments("--no-proxy-server");
				options.addArguments("--disable-default-apps");
				options.addArguments("disable-infobars");
				options.addArguments("test-type");
				options.addArguments("no-sandbox");
				options.addArguments("--allow-running-insecure-content");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				driver = new ChromeDriver(options);
				String window_name_chrome = driver.getWindowHandle();
				driver.switchTo().window(window_name_chrome);
				// addToPropFile("window_name_chrome", window_name_chrome);
			} else if (CONFIG.getProperty("browser").equals("Mozilla")) {
				System.setProperty("webdriver.gecko.driver", Constants.geckoPath);
				FirefoxOptions options = new FirefoxOptions();
				options.setBinary(Constants.firefoxPath);
				driver = new FirefoxDriver(options);
				driver.manage().window().maximize();
			}

			else if (CONFIG.getProperty("browser").equals("IE")) {
				System.setProperty("webdriver.ie.driver", Constants.iePath);
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,	true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability("silent", true);
				capabilities.setCapability("InPrivate", true);
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
			}
		}
	}
/*	public static Hashtable<String,String> table;
	public static Hashtable<String,String> getEnvDetails(){
		if(table==null){
			table = new Hashtable<String,String>();
			if(ENV.equals("ant444")){
				table.put("url", stg444);
				table.put("user_name", AJOETEST2);
				table.put("owner", APPLEROME18);
			}else if(ENV.equals("plb8085")){
				table.put("url", tst8085);
				table.put("user_name", AJOETEST2);
				table.put("owner", APPLEROME18);
				table.put("tr1", DOBTESTING123);
				table.put("tr8", DOBTESTING123);
				table.put("pw2", MRCTEST003);
				
			}
		}
		return table;
	}*/
	
	public void getEnvironmentDetails() {
		if (CONFIG.getProperty("env").contains("443")) {
			dob_now_url = Constants.dob_now_protocol_stage + Constants.stage_443;
			crm_url = Constants.crm_stage;
		}
		else if (CONFIG.getProperty("env").contains("8085")) {
			dob_now_url = Constants.tst8085;
			crm_url = Constants.crm_test;
		}
		else if (CONFIG.getProperty("env").contains("444")) {
			dob_now_url = Constants.dob_now_protocol_stage + Constants.stage_444;
			crm_url = Constants.crm_stage;
		}
		if (CONFIG.getProperty("env").contains("antenna") || CONFIG.getProperty("env").contains("curbcut") || CONFIG.getProperty("env").contains("patpa")) {
			user = Constants.AJOETEST2;
			owner = Constants.APPLEROME18;
/*			tr1_user = Constants.DOBTESTING123;
			tr1_lic = Constants.PROFENG;
			tr8_user = Constants.DOBTESTING123;
			tr8_lic = Constants.PROFENG;*/
			pw2_user = Constants.AJOETEST2;
			pw2_lic = Constants.PROFENG;
		}		
		if (CONFIG.getProperty("env").contains("plumbing")) {
			user = Constants.AJOETEST2;
			owner = Constants.APPLEROME18;
			tr1_user = Constants.DOBTESTING123;
			tr1_lic = Constants.PROFENG;
			tr8_user = Constants.DOBTESTING123;
			tr8_lic = Constants.PROFENG;
			pw2_user = Constants.MRCTEST003;
			pw2_lic = Constants.MSTRPLMR;
		}
		if (CONFIG.getProperty("env").contains("electrical")) {
			user = Constants.DOBELECTRICIAN8;
		}
		if (CONFIG.getProperty("env").contains("elevators")) {
			user = Constants.DOBELVDIRECTOR;
			owner = Constants.APPLEROME18;
			tr1_user = Constants.DOBTESTING123;
			tr1_lic = Constants.PROFENG;
			tr8_user = Constants.DOBTESTING123;
			tr8_lic = Constants.PROFENG;
		}
		if (CONFIG.getProperty("env").contains("sign") || CONFIG.getProperty("env").contains("fab4")) {
			user = Constants.AJOETEST2;
			owner = Constants.APPLEROME18;
			tr1_user = Constants.AJOETEST2;
			tr1_lic = Constants.PROFENG;
			tr8_user = Constants.DOBTESTING123;
			tr8_lic = Constants.PROFENG;
/*			pw2_user = Constants.MRCTEST003;
			pw2_lic = Constants.MSTRPLMR;*/
		}
		if (CONFIG.getProperty("env").contains("laa")) {
			user = Constants.DOBTEST05;
		}
		
		
/*		if (CONFIG.getProperty("env").equals("ant_444")) {
			dob_now_url = Constants.dob_now_protocol_stage + Constants.dob_now_stage_444;
			crm_url = Constants.crm_stage;
		}*/
/*		if (CONFIG.getProperty("env").equals("el_444")) {
			dob_now_url = Constants.dob_now_protocol_stage + Constants.electrical_stage_444;
		}*/
	}
	
/*	public void XaddToPropFile(String property, String value) {
		if (!property.equals("")) {
			try {
				test = rep.startTest("Add to Props");
				FileInputStream fileName = new FileInputStream(Constants.OR_PROPERTIES);
				Properties props = new Properties();
				props.load(fileName);
				props.setProperty(property, value);
				fileName.close();
				FileOutputStream outFileName = new FileOutputStream(Constants.OR_PROPERTIES);
				props.store(outFileName, "# BROWSERS::  IE  Chrome  Mozilla # ENVIRONMENTS ::  443 444 8085 + WORK TYPES:: antenna curbcut plumbing electrical elevators fab4");
				outFileName.close();
				// props.load(fileName);
				FileInputStream fs = new FileInputStream(Constants.OR_PROPERTIES);
				OR_PROPERTIES.load(fs);
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}*/

	public void navigate(String urlKey) {
		test = rep.startTest("Test URL");
		test.log(LogStatus.INFO, "Navigate to  " + urlKey);
		driver.get(urlKey);
		waitUntilISpinnersInvisible();
		waitForPageToLoad();
		scrollAllWayUp();
	}

	public void takeScreenShot(){
		Date d=new Date();
		String screenshotFile=d.toString().replaceAll(" EDT 2018", "").replace(":", "_").replace(" ", "_")+".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,"FAILURE "+ test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
	}

	public void reportFailure(String msg) {
		test.log(LogStatus.FAIL, msg);
		takeScreenShot();
		Assert.fail(msg);
	}

	public WebElement getElement(String locatorKey) {
		waitForPageToLoad();
		WebElement e = null;
		try {
			waitForPageToLoad();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((locatorKey))));
			e = driver.findElement(By.xpath(locatorKey));
		} catch (Exception ex) {
			reportFailure(ex.getMessage());
			ex.printStackTrace();
			Assert.fail("Failed the test - " + ex.getMessage());
		}
		return e;
	}
/*	public WebElement XgetElementSoft(String locatorKey) {
		waitForPageToLoad();
		WebElement e = null;
		try {
			e = driver.findElement(By.xpath(locatorKey));
		} catch (Exception ex) {
		}
		return e;
	}*/
	public void waitVisible(String locatorKey) {
		waitForPageToLoad();
		waitUntilElementVisible(locatorKey, 30);
	}
	public void waitInvisible(String locatorKey) {
		waitForPageToLoad();
		waitUntilElementInVisible(locatorKey, 30);
	}

	public void waitVisible60(String locatorKey) {
		waitForPageToLoad();
		waitUntilElementVisible(locatorKey, 60);
	}

	public void waitInvisible60(String locatorKey) {
		waitForPageToLoad();
		waitUntilElementInVisible(locatorKey, 60);
	}



	public void refreshPage() {
		test = rep.startTest("Refresh Page");
		test.log(LogStatus.INFO, "Refreshing Page");
		driver.navigate().refresh();
		waitForPageToLoad();
		waitUntilISpinnersInvisible();
	}

	public int count(String locatorKey) {
		waitForPageToLoad();
		int number_of_elements = driver.findElements(By.xpath(locatorKey)).size();
		return number_of_elements;
	}
	
/*	public boolean verifyElementAbsent(String locatorKey) {
//		int i = 1;
		while (true) {
			WebElement display = driver.findElement(By.xpath(locatorKey));
			// System.out.println(display);
			if (display.isDisplayed() == true) {
				return true;
			} else
				return false;
		}
	}*/
	
	public boolean elementVisible(String locatorKey) {
	    try {
	        driver.findElement(By.xpath(locatorKey)).isDisplayed();
	        return true;
	      }
	    catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	      }
	}
	
	public void waitUntilISpinnersInvisible() {
		ifAlertExistAccept();
		if (elementVisible(Constants.loading) == true || elementVisible(Constants.please_wait) == true) {
			waitInvisible(Constants.please_wait);
			waitInvisible(Constants.loading);
		}
	}

	public void click(String locatorKey) {
		test.log(LogStatus.INFO, "Clicking on " + locatorKey);
		waitForPageToLoad();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(locatorKey)));
		if (getElement(locatorKey).isEnabled() || getElement(locatorKey).isDisplayed())
			getElement(locatorKey).click();
		try {
			Alert alert = new WebDriverWait(driver, 1).until(ExpectedConditions.alertIsPresent());
			if (alert != null) {
				driver.switchTo().alert().accept();
			} else {
				throw new Throwable();
			}
		} catch (Throwable e) {
			// System.err.println("Alert isn't present!!");
		}
		waitForPageToLoad();
		report();
	}
	public void click1or2(String locatorKey,String locatorKey2) {
		test.log(LogStatus.INFO, "Clicking on " + locatorKey + " or " + locatorKey2);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(getElement(locatorKey)));
			driver.findElement(By.xpath(locatorKey)).click();;
		} catch (Exception ex) {
			wait.until(ExpectedConditions.elementToBeClickable(getElement(locatorKey)));
			driver.findElement(By.xpath(locatorKey2)).click();;
		}	
	}
	
	public void multiClick(String locatorKey) {
		test.log(LogStatus.INFO, "Clicking on " + locatorKey);
		String newLocatorKey = null;
		int numofelements = count(locatorKey);
		for (int i = 1; i <= numofelements; i++) {
			newLocatorKey = "(" + locatorKey + ")[" + i + "]";
			if (driver.findElement(By.xpath(newLocatorKey)).isEnabled()) {
				if (driver.findElement(By.xpath(newLocatorKey)).isDisplayed()) {
					driver.findElement(By.xpath(newLocatorKey)).click();
					break;
				}

			}
			wait(1);
		}
	}


	public void doubleclick(WebElement locatorKey) {
		test.log(LogStatus.INFO, "Doubleclicking on " + locatorKey);
		waitForPageToLoad();
		new Actions(driver).doubleClick(locatorKey).perform();
	}

	public void check(String locatorKey) {
		test.log(LogStatus.INFO, "Checking box " + locatorKey);
		waitVisible(locatorKey);
		if (!getElement(locatorKey).isSelected())
			getElement(locatorKey).click();
	}

	public void uncheck(String locatorKey) {
		test.log(LogStatus.INFO, "unchecking box " + locatorKey);
		waitVisible(locatorKey);
		if (getElement(locatorKey).isSelected())
			getElement(locatorKey).click();
	}
	
	public void type(String locatorKey, String data) {
		clear(locatorKey);
		test.log(LogStatus.INFO, "Typing '" + data + "'");
		getElement(locatorKey).sendKeys(data);
		tab(locatorKey);
	}

	public void select_val(String locatorKey, String value) {
		test.log(LogStatus.INFO, "Selecting by value '" + value + "'");
		Select select = new Select(getElement(locatorKey));
		select.selectByValue(value);
	}
	public void select(String locatorKey, String text) {
		test.log(LogStatus.INFO, "Selecting by text '" + text + "'");
		Select select = new Select(getElement(locatorKey));
		select.selectByVisibleText(text);
	}
	
	public String text(String locatorKey) {
		test.log(LogStatus.INFO, "Getting text of " + locatorKey);
		String text = getElement(locatorKey).getText();
		return text;
	}

	public void radio(String locatorKey) {
		test.log(LogStatus.INFO, "Radiobutton " + locatorKey);
		WebElement e = null;
		try {
			e = driver.findElement(By.xpath(locatorKey));
			if(!e.isSelected())
			e.click();
		} catch (Exception ex) {
			reportFailure(ex.getMessage());
			ex.printStackTrace();
			Assert.fail("Failed the test - " + ex.getMessage());
		}
/*		List<WebElement> button = driver.findElements(By.xpath(locatorKey));
		button.get(0).getAttribute("checked");*/
	}

	public void send(String locatorKey, String key) {
		test.log(LogStatus.INFO, "Sending Key " + key);
		getElement(locatorKey).sendKeys(key);
	}
	public void clear(String locatorKey) {
		test.log(LogStatus.INFO, "Clearing field " + locatorKey);
		getElement(locatorKey).clear();
	}
	

	public void keyPressTab(String locatorKey) {
		getElement(locatorKey).sendKeys(Keys.TAB);
	}
	public void tab(String locatorKey) {
		getElement(locatorKey).sendKeys(Keys.TAB);
	}

	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 500)"); // if the element is on top.
	}

	public void scrollAllWayDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(2000, 2000)"); // if the element is on bottom
		jse.executeScript("scroll(2000, 2000)");
	}
	public void scrollTo(String locatorKey) {
		// test.log(LogStatus.INFO, "Scrolling to "+locatorKey);
		WebElement element = driver.findElement(By.xpath(locatorKey));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + element.getLocation().y + ")");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); // NEW
	}
	public void scrollToElement(String locatorKey) {
		// test.log(LogStatus.INFO, "Scrolling to "+locatorKey);
		WebElement element = driver.findElement(By.xpath(locatorKey));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + element.getLocation().y + ")");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); // NEW
	}

	public void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(500, 0)"); // if the element is on bottom
	}

	public void scrollAllWayUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 0)"); // if the element is on bottom
		jse.executeScript("scroll(0, 0)");
		jse.executeScript("scroll(0, 0)");
	}

	public void javaScriptClick(String locatorKey) {
		test.log(LogStatus.INFO, "javascript click " + locatorKey);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", locatorKey);
	}

	public void doubleclick(String locatorKey) {
		test.log(LogStatus.INFO, "Doubleclick " + locatorKey);
		if (getElement(locatorKey).isEnabled() || getElement(locatorKey).isDisplayed()) {
			Actions action = new Actions(driver);
			action.doubleClick(getElement(locatorKey)).perform();
		}
	}
	public void actionClick(String locatorKey) {
		test.log(LogStatus.INFO, "actionClick " + locatorKey);
		Actions action = new Actions(driver);
		action.click(getElement(locatorKey)).perform();
	}

	
 //##################################################################################################################################################################
		public void softAssert(String msg1, String msg2) {
			test.log(LogStatus.FAIL, msg1 + msg2);
			softAssert.assertTrue(false);
	 		takeScreenShot();
		}

		public boolean verifyText(String locatorKey, String expectedText){
			test = rep.startTest("Verify Text " +expectedText);
			String actualText=getElement(locatorKey).getText().trim();
			if(actualText.equals(expectedText)) {
				test.log(LogStatus.PASS, actualText + " == " + expectedText);
				return true;
			}
			else {
		 		softAssert("Actual: " + actualText, " Expected: " + expectedText);
		 		return false;
			}		
		}
	
		public boolean assertFilingStatus(String expectedText) {
			test = rep.startTest("Assert Filing Status: " + expectedText);
			if (count("//span[contains(.,'" + expectedText + "')]") > 0) {
				highlightElement("//span[contains(.,'" + expectedText + "')]");
				test.log(LogStatus.PASS, "Actual Status is what Expected: " + expectedText);
				return true;
			} else {
				softAssert("Expected Status: '" + expectedText, "' not present");
				return false;
			}
		}
		public boolean verifyNotification(String locatorKey, String expectedText){
			test = rep.startTest("Verify Notification: " +expectedText);
			test.log(LogStatus.INFO, "Expected Text: " +expectedText);
			String actualText=getElement(locatorKey).getText().trim();
			if(actualText.contains(expectedText)) {
				test.log(LogStatus.PASS, actualText + " == " + expectedText);
				return true;
			}
			else {
		 		softAssert("Actual Notification: " +actualText, " not equal to: " +expectedText);
		 		return false;
			}		
		}
		public void assertNotification(String expectedText, String screenShotName) {
			try {
				test.log(LogStatus.INFO, "Assert Notification: " + expectedText);
				waitUntilElementVisible(Constants.global_notification_message, 30);
				String pagesource = driver.getPageSource();
				Assert.assertTrue(pagesource.contains(expectedText));
				test.log(LogStatus.PASS, "Pagesource Contains: " + expectedText);
				String part1 = "//p[contains(.,'";
				String part2 = "')]";
				String elementxpath = part1 + expectedText + part2;
				try {
					highlightElement(elementxpath);
				} catch (Throwable t) {
					System.out.println("cannot highlight");
				}
			} catch (Throwable t) {
				softAssert("assertNotification != ",  expectedText);
				takeScreenShot();
			}
		}
		public boolean verifyElementPresent(String locatorKey) {
			test = rep.startTest("verifyElementPresent: " + locatorKey);
			if (count(locatorKey) > 0) {
				highlightElement(locatorKey);
				test.log(LogStatus.PASS, "Element Present: " + locatorKey);
				return true;
			} else {
				softAssert("Expected Status: '" + locatorKey, "' not present");
				return false;
			}
		}
	public void assertTextPresent(String expectedText, String screenShotName) {
		test = rep.startTest("assertTextPresent: " + expectedText);
		try {
			String pagesource = driver.getPageSource();
			Assert.assertTrue(pagesource.contains(expectedText));
			// Assert.assertTrue(driver.getPageSource().contains(testText));
			String part1 = "//*[contains(.,'";
			String part2 = "')]";
			String elementxpath = part1 + expectedText + part2;
			highlightElement(elementxpath);
		} catch (Throwable t) {
			softAssertion.assertTrue(false, "pagesource does not contains: " + expectedText);
			softAssert("pagesource != contains ", expectedText);
			takeScreenShot();
		}
	}

	public void assertTextNotPresent(String expectedText, String screenShotName) {
		try {
			pagesource = driver.getPageSource();
			Assert.assertTrue(!pagesource.contains(expectedText));
			// Assert.assertTrue(driver.getPageSource().contains(testText));
		} catch (Throwable t) {
			softAssertion.assertEquals(false, "getPageSource !contains " + expectedText);
			takeScreenShot();
		}
	}

	public void assertTwoTextsPresent(String expectedText1, String expectedText2, String screenShotName) {
		try {
			// String pagesource = driver.findElement(By.tagName("body")).getText();
			pagesource = driver.getPageSource();
			// Assert.assertTrue(pagesource.contains(testText));
			if (pagesource.contains(expectedText1) & pagesource.contains(expectedText2)) {
				System.out.println(expectedText1 + " " + expectedText2 + " two texts present");
			}
		} catch (Throwable t) {
			softAssertion.assertEquals(false, "getPageSource !contains " + expectedText1 + " and " + expectedText2);
			takeScreenShot();
		}
	}

	public void assertIntEqual(int int1, int int2, String screenShotName) {
		try {
			Assert.assertEquals(int1, int2);
		} catch (Throwable t) {
			DateFormat dateFormat = new SimpleDateFormat("M-d HH-mm"); // 12-31 16-31
			timestamp = dateFormat.format(Calendar.getInstance().getTime());
			System.out.println("assertIntEqual error " + screenShotName + " " + timestamp);
			ErrorUtil.addVerificationFailure(t);
			takeScreenShot();
		}
	}

	public void assertElementPresent(String locatorKey, String screenShotName) {
		try {
			test = rep.startTest("Assert Element Present");
			test.log(LogStatus.INFO, "assertElementPresent " + locatorKey); 
			Assert.assertTrue(count(locatorKey) > 0);
			reportPass("Element Present");
		} catch (Throwable t) {
			softAssert("Element : " + locatorKey, " not present");
//			softAssertion.assertEquals(false, "Element Not Present " + locatorKey);
			takeScreenShot();
		}
	}
	public boolean veryfyElementCount(String locatorKey, int expectedNumber) {
		test = rep.startTest("Assert Number of Elements: " + expectedNumber);
		if (count(locatorKey) >= expectedNumber) {
			test.log(LogStatus.PASS, "Actual Number of Elements is what Expected: " + expectedNumber);
			return true;
		} else {
			softAssert("Expected number of elements: " + expectedNumber, "But Actual is not.");
			return false;
		}
	}
	public void assertElementNotPresent(String elementxpath, String screenShotName) {
		try {
			Assert.assertTrue(!driver.findElement(By.xpath(elementxpath)).isDisplayed());
		} catch (Throwable t) {
			DateFormat dateFormat = new SimpleDateFormat("M-d-HH-mm"); // 12-31 16:20
			timestamp = dateFormat.format(Calendar.getInstance().getTime());
			System.out.println("assertElementNotPresent " + timestamp);
			ErrorUtil.addVerificationFailure(t);
			takeScreenShot();
		}
	}

	public void getElementText(String elementxpath, String expectedText) {
		try {
			String actualText = driver.findElement(By.xpath(elementxpath)).getText();
			if(actualText.equals(expectedText))
				test.log(LogStatus.PASS, actualText + " == " +expectedText);
		} catch (Throwable t) {
			softAssertion.assertEquals(false, "getElementText != " + expectedText);
			softAssert.assertTrue(false);
//			softAssert.assertTrue(false, actualText + " != " + expectedText);
			takeScreenShot();
		}
	}

	public void elementTextContains(String elementxpath, String expectedText) {
		try {
			String actualText = driver.findElement(By.xpath(elementxpath)).getText();
			// System.out.println(driver.findElement(By.xpath(elementxpath)).getText());
			Assert.assertTrue(actualText.contains(expectedText));
		} catch (Throwable t) {
			softAssertion.assertEquals(false, "actualText does not contains " + expectedText);
			takeScreenShot();
		}
	}

	public void assertColor(String locatorKey, String css_value, String expected_color) {
		try {
			String actual_color = driver.findElement(By.xpath(locatorKey)).getCssValue(css_value);
			Assert.assertTrue(actual_color.contains(expected_color));
		} catch (Throwable t) {
			softAssertion.assertEquals(false, "actual color does not contains " + expected_color);
			takeScreenShot();
		}
	}
	public void elementContainsText(String elementxpath, String expectedText) {
		try{
			String actualText = driver.findElement(By.xpath(elementxpath)).getText();
			Assert.assertTrue(actualText.contains(expectedText));
		}catch(Throwable t){
			softAssertion.assertEquals(false, "Element does not contains " + expectedText);
			takeScreenShot();
		}
	}
	public void elementContainsTextOrText(String elementxpath, String expectedText1, String expectedText2) {
		try {
			String actualText = driver.findElement(By.xpath(elementxpath)).getText();
			Assert.assertTrue(actualText.contains(expectedText1) || actualText.contains(expectedText2));
		} catch (Throwable t) {
			DateFormat dateFormat = new SimpleDateFormat("M-d-HH-mm");
			timestamp = dateFormat.format(Calendar.getInstance().getTime());
			System.out.println(expectedText1 + " or " + expectedText2);
			ErrorUtil.addVerificationFailure(t);
			takeScreenShot();
		}
	}

	public boolean sourceContains(String expectedText) {
		test = rep.startTest("Verify Source Contains " +expectedText);
		pagesource = driver.getPageSource();
		if (pagesource.contains(expectedText)) {
			test.log(LogStatus.PASS, "Source Contains " + expectedText);
			return true;
		} else {
			softAssert("Source does not contains: ", expectedText);
			return false;
		}
	}

	public void quitDriver() {
 		if(driver != null) {
 			driver.close();
 			driver = null;
 		}
 		if(rep != null) {
 			rep.endTest(test);
 			rep.flush();
 		}
	}
	
	public void report() {
 		if(rep != null) {
 			rep.endTest(test);
 			rep.flush();
 		}
	}

	public void wait(int timeToWait) {
		try {
			Thread.sleep(timeToWait * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitTime(long waitseconds) {
		try {
			Thread.sleep(waitseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitUntilElementPresent(String elementxpath, int seconds) {
		new WebDriverWait(driver, seconds).until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementxpath)));
		// WebElement myDynamicElement = (new WebDriverWait(driver,
		// 10)).until(ExpectedConditions.presenceOfElementLocated(By.id(elementxpath)));
	}

	public static int randomNumberOf(int number) {
		double d = Math.random() * number;
		int num = (int) d;
		return num;
	}

	public void mouseOverlocator(int x, int y) {
		try {
			(new Robot()).mouseMove(x,y);
			(new Robot()).mousePress(InputEvent.BUTTON1_DOWN_MASK);
			(new Robot()).mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	public void mouseOverElementXpath(String elementxpath) {
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(elementxpath));
		actions.moveToElement(element);
		actions.perform();
	}

	public void waitUntilElementVisible(String elementxpath, int seconds) {
		waitForPageToLoad();
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementxpath)));
		} catch (Throwable t) {
			takeScreenShot();
			System.out.println("waitVisible " + elementxpath);
		}
	}

	public void waitUntilElementInVisible(String elementxpath, int seconds) {
		waitForPageToLoad();
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementxpath)));
		} catch (Throwable t) {
			takeScreenShot();
			System.out.println("waitInvisible " + elementxpath);
		}
	}

	public String convertedTimestamp() {
		DateFormat dateFormat = new SimpleDateFormat("M-d HH:mm:ss"); // 07/31/2014 16:31
		timestamp = dateFormat.format(Calendar.getInstance().getTime());
		return timestamp;
	}

	public void clickElement(String element_locator) {
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element_locator)));
		driver.findElement(By.xpath(element_locator)).click();
	}

	public void locateElement(String element_locator) {
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element_locator)));
		driver.findElement(By.xpath(element_locator));
	}

	public void loginToPortal(String login_email) {
		if (!login_email.equals("")) {
			for (int i = 1; i < 100; i++) {
				navigate(dob_now_url);
				test = rep.startTest("Login to portal");
					if(!CONFIG.getProperty("env").contains("8085")) {
						while (count("//a[@id='overridelink']") > 0) {
							driver.navigate().to("javascript:document.getElementById('overridelink').click()");
							wait(5);
							if (count("//a[@name='overridelink']") == 0)
								break;
							refreshPage();
						}
					}
//				}
					
				
				type(Constants.welcome_email, login_email);
				type(Constants.welcome_password, OR_PROPERTIES.getProperty("password"));
				click(Constants.welcome_login_button);
				
	//			wait(33);
				
				wait(3);
				while(count("//div[@class='alert alert-info']") > 0) {
					clickButton("OK");
					waitInvisible(Constants.ok_button);
					refreshPage();
					type(Constants.welcome_email, login_email);
					type(Constants.welcome_password, OR_PROPERTIES.getProperty("password"));
					doubleclick(Constants.welcome_login_button);
//					wait(3);
				}
				click(Constants.dob_now_build_component);
//				doubleclick("//div[@ng-show='enableBuildLogo']");
				//div[@ng-show='enableBuildLogo']
				waitInvisible(Constants.dob_now_build_component);
				waitUntilISpinnersInvisible();
				if (count("//input[@ng-model='colFilter.term']") > 0)
					break;
				navigate(dob_now_url+ "/logOut");
			}
		}
	}

	public void loginToCrm(String user_name) {
		for (int i = 1; i <= 10; i++) {
			// navigate(crm_url);
			test = rep.startTest("Login to CRM");
			test.log(LogStatus.INFO, "Login to CRM as " + user_name);
			waitForPageToLoad();
			if (count(Constants.crm_username_label) > 0) {
				driver.manage().window().maximize();
				if (text(Constants.crm_username_label).contains(user_name)) {
					driver.get(crm_url);
					break;
				}
			}
			if (count(Constants.crm_username_label) < 1) {
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				StringSelection url = new StringSelection(crm_url);
				StringSelection username = new StringSelection(user_name);
				StringSelection pass = new StringSelection(OR_PROPERTIES.getProperty("password_crm"));
				clipboard.setContents(url, null);
				try {
					mouseOverlocator(300, 40);
					wait(2);
					new Robot().keyPress(java.awt.event.KeyEvent.VK_CONTROL);
					new Robot().keyPress(java.awt.event.KeyEvent.VK_V);
					new Robot().keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
					new Robot().keyPress(java.awt.event.KeyEvent.VK_TAB);
					mouseOverlocator(0, 400);
					wait(1);
					mouseOverlocator(300, 40);
					new Robot().keyPress(java.awt.event.KeyEvent.VK_ENTER);
					mouseOverlocator(950, 80);
					setWindowfocus();
					wait(5);
					clipboard.setContents(username, null);
					setWindowfocus();
					new Robot().keyPress(java.awt.event.KeyEvent.VK_CONTROL);
					new Robot().keyPress(java.awt.event.KeyEvent.VK_V);
					new Robot().keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
					new Robot().keyPress(java.awt.event.KeyEvent.VK_TAB);
					wait(1);
					clipboard.setContents(pass, null);
					new Robot().keyPress(java.awt.event.KeyEvent.VK_CONTROL);
					new Robot().keyPress(java.awt.event.KeyEvent.VK_V);
					new Robot().keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
					new Robot().keyPress(java.awt.event.KeyEvent.VK_ENTER);
					mouseOverlocator(300, 0);
					// mouseOverlocator(950, 150);
					waitVisible(Constants.crm_username_label);
				} catch (AWTException e) {
					e.printStackTrace();
				}
				if (count(Constants.crm_username_label) <= 0) {
					driver.close();
					wait(2);
					initDriver();
				} else {
					mouseOverlocator(300, 0);
					break;
				}

				/*
				 * if (text(Constants.crm_username_label).contains(user_name)) {
				 * mouseOverlocator(300, 0); break; }
				 */

				driver.close();
				wait(2);
				initDriver();
				getEnvironmentDetails();
			}
		}
	}
	public void loginToCrmOLD(String user_name) {
		for (int i = 1; i <= 10; i++) {
			navigate(crm_url);
			test = rep.startTest("Login to CRM");
			test.log(LogStatus.INFO, "Login to CRM as " + user_name);
			driver.switchTo().defaultContent();
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection username = new StringSelection(user_name);
			StringSelection pass = new StringSelection(OR_PROPERTIES.getProperty("password_crm"));
			clipboard.setContents(username, null);
			try {
				mouseOverlocator(950, 80);
				setWindowfocus();
				new Robot().keyPress(java.awt.event.KeyEvent.VK_CONTROL);
				new Robot().keyPress(java.awt.event.KeyEvent.VK_V);
				new Robot().keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
				new Robot().keyPress(java.awt.event.KeyEvent.VK_TAB);
				wait(1);
				clipboard.setContents(pass, null);
				new Robot().keyPress(java.awt.event.KeyEvent.VK_CONTROL);
				new Robot().keyPress(java.awt.event.KeyEvent.VK_V);
				new Robot().keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
				new Robot().keyPress(java.awt.event.KeyEvent.VK_ENTER);
				waitVisible(Constants.crm_top_nav_search_button);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			if (count(Constants.crm_username_label) <= 0) {
				driver.close();
				wait(2);
				initDriver();
			}
			if (text(Constants.crm_username_label).contains(user_name))
				break;
		}
	}

	public void searchForJobCrm() {
		test = rep.startTest("Search job " + JOB_NUMBER.getProperty("job_number"));
		test.log(LogStatus.INFO, "Search job CRM " + JOB_NUMBER.getProperty("job_number"));
		for (int i = 1; i <= 30; i++) {
			ifAlertExistAccept();
			navigate(crm_url);
			driver.manage().window().maximize();
			setWindowfocus();
			waitForPageToLoad();
			waitVisible(Constants.crm_top_nav_search_button);
			driver.switchTo().frame("contentIFrame0").switchTo().frame("dashboardFrame");
			click(Constants.search_for_records_one);
			type(Constants.search_for_records_one_field, "*" +JOB_NUMBER.getProperty("job_number").substring(1));
			click(Constants.search_for_records_one_image);
			if (count(Constants.search_results_job_subject) > 0)
				break;
			refreshPage();
			wait(5);
		}
		doubleclick(Constants.search_results_job_subject);
		ifAlertExistAccept();
		waitVisible(Constants.crm_top_nav_search_button);
		waitInvisible(Constants.crm_loading_image);
		waitForPageToLoad();
		wait(3);

		driver.switchTo().defaultContent();
	}
	
	public void waitDocStatus() {
		driver.switchTo().frame("contentIFrame0");
		waitForOneOf3Visible("//nobr[text()='Accepted']", "//nobr[text()='Submitted']", "//nobr[text()='Pending']");
	}

	public void filterJob(String user_name) {
		for (int i = 1; i <= 50; i++) {
			loginToPortal(user_name);
			type(Constants.job_number_filter, JOB_NUMBER.getProperty("job_number"));
			wait(1);
			if (count(Constants.found_job_part_one +JOB_NUMBER.getProperty("job_number")+Constants.found_job_part_two) > 0)
				break;
		}
		test = rep.startTest("Filter job " + JOB_NUMBER.getProperty("job_number"));
		if(count(Constants.click_to_view_icon) > 0) {
			click(Constants.click_to_view_icon);
			clickButton("OK");
			waitInvisible(Constants.global_notification_ok_button);
			waitUntilISpinnersInvisible();
			scrollAllWayUp();
		}
		else
			reportFailure("filterJob - unable to filer job");
	}
	
	public void filterJob(String user_name, String job_number) {
		for (int i = 1; i <= 10; i++) {
			loginToPortal(user_name);
			type(Constants.job_number_filter, job_number.trim());
			if (count(Constants.found_job_part_one +job_number +Constants.found_job_part_two) > 0)
				break;
		}
		test = rep.startTest("Filter job " + job_number);
		click(Constants.click_to_view_icon);
		click(Constants.global_notification_ok_button);
		waitInvisible(Constants.global_notification_ok_button);
		waitUntilISpinnersInvisible();
		scrollAllWayUp();
	}

	public void addToProps(String prop_name, String value) {
		if (!prop_name.equals("")) {
			test = rep.startTest("Add To Props " +prop_name+ "=" +value );
			try {
				FileInputStream fileName = new FileInputStream(Constants.JOB_NUMBER);
				Properties props = new Properties();
				props.load(fileName);
				props.setProperty(prop_name, value);
				fileName.close();
				FileOutputStream outFileName = new FileOutputStream(Constants.JOB_NUMBER);
				props.store(outFileName, "# BROWSERS :: IE  Chrome  ENVIRONMENTS ::  443 444 8085 + WORK TYPES:: antenna curbcut plumbing electrical elevators fab4 laa patpa");
				outFileName.close();
				// props.load(fileName);
				FileInputStream fs = new FileInputStream(Constants.JOB_NUMBER);
				JOB_NUMBER.load(fs);
				System.out.println(convertedTimestamp() +  "    JOB NUMBER    ***************************************** "+value);
				test.log(LogStatus.PASS, "addToProps " +prop_name+ " = " +value);
				/*
				 * try { FileInputStream fs = new FileInputStream(Constants.JOB_NUMBER);
				 * JOB_NUMBER.load(fs); } catch (Exception e) { e.printStackTrace();}
				 */
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}

	public void acceptSubmitted() {
		if (count(Constants.crm_document_status_submitted) > 0) {
			for (int i = 1; i <= 20; i++) {
				doubleclick(Constants.crm_document_status_submitted);
				wait(3);
				driver.switchTo().defaultContent();
				while (driver.getWindowHandles().size() < 2) {
					click(Constants.view_document_button);
					wait(3);
				}
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				driver.close();
				wait(1);
				driver.switchTo().window(tabs.get(0));
				driver.switchTo().defaultContent();
				click(Constants.accept_document_button);
				ifAlertExistAccept();
				waitForPageToLoad();
				wait(2);
				driver.switchTo().frame("contentIFrame0");
				waitVisible(Constants.crm_document_accepted);
				driver.switchTo().defaultContent();
				driver.navigate().back();
				waitForPageToLoad();
				wait(2);
				driver.switchTo().frame("contentIFrame0");
				waitVisible(Constants.label_job_filing);
				waitForOneOf3Visible("//nobr[text()='Accepted']", "//nobr[text()='Submitted']", "//nobr[text()='Pending']");
				if (count(Constants.crm_document_status_submitted) == 0) {
					reportPass("viewAcceptDocuments");
					break;
				}
			}
		}
	}
	


	public void setWindowfocus() {
		String currentWindow = driver.getWindowHandle();
		driver.switchTo().window(currentWindow);
	}

	public void ifAlertExistAccept() {
		try {
			Alert alert = new WebDriverWait(driver, 3).until(ExpectedConditions.alertIsPresent());
			if (alert != null) {
				wait(1);
				driver.switchTo().alert().accept();
			} else {
				throw new Throwable();
			}
		} catch (Throwable e) {
			// System.err.println("Alert isn't present!!");
		}
	}

	public void killDriver() {
//		setConfigBrowser("Chrome");
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
//			Runtime.getRuntime().exec("taskkill /F /IM firefox.exe /T");
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe /T");
//			driver.quit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void highlightElement(String locatorKey) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElement(locatorKey);
		if (count(locatorKey) > 0) {
			try {
//				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
				js.executeScript("arguments[0].style.border='3px solid red'", element);
				js.executeScript("arguments[0].style.border='3px solid yellow'", element);
//				js.executeScript("arguments[0].style.border='3px solid green'", element);
			} catch (Throwable t) {
			}
		}
	}

	public void javaMessage(String[] args, String test_name) {
		final JOptionPane pane = new JOptionPane(test_name);
		// final JOptionPane pane = new JOptionPane(test_name,
		// JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
		final JDialog dialog = pane.createDialog(null, test_name);
		Timer timer = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog.dispose();
			}
		});
		timer.start();
		dialog.setVisible(true);
		dialog.dispose();
	}

	public void takeScreenShot(String fileName) {
		File srcFile = ((TakesScreenshot) (TestBase.driver)).getScreenshotAs(OutputType.FILE);
		try {
			// FileUtils.copyFile(srcFile, new
			// File(System.getProperty("user.dir")+"\\src\\test\\java\\screenshots\\"+fileName+".jpg"));
			FileUtils.copyFile(srcFile,
					new File(System.getProperty("user.dir") + "\\screenshots\\" + fileName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

/*	private static Map<ITestResult, List> verificationFailuresMap = new HashMap<ITestResult, List>();

	public static void addVerificationFailure(Throwable e) {
		System.out.println("*addVerificationFailure*");
		List verificationFailures = getVerificationFailures();
		verificationFailuresMap.put(Reporter.getCurrentTestResult(), verificationFailures);
		verificationFailures.add(e);
	}

	public static List getVerificationFailures() {
		System.out.println("*getVerificationFailures*");
		List verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
		return verificationFailures == null ? new ArrayList() : verificationFailures;
	}*/

	public void switchToChrome() {
		// if(!pay_now.equals("")) {
		// initDriver();
		waitTime(2);
		System.setProperty("webdriver.chrome.driver", Constants.chromePath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-web-security");
		options.addArguments("--no-proxy-server");
		options.addArguments("--disable-default-apps");
		options.addArguments("disable-infobars");
		options.addArguments("test-type");
		options.addArguments("no-sandbox");
		options.addArguments("--allow-running-insecure-content");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		driver = new ChromeDriver(options);
		String chrome_window = driver.getWindowHandle();
		driver.switchTo().window(chrome_window);
		driver.switchTo().window(chrome_window);
		// }
	}

	public void switchToIE(String pay_now) {
		if (!pay_now.equals("")) {
//			driver.close();
/*			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,	true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);*/
			System.setProperty("webdriver.ie.driver", Constants.iePath);
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
	}
	public void waitForPageToLoad() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String state = (String) jse.executeScript("return document.readyState");
		int i = 0;
		while (!state.equals("complete")) {
			i++;
			wait(1);
			state = (String) jse.executeScript("return document.readyState");
			if(i == 100) {
				System.out.println("waitForPageToLoad exeed 100 seconds");
				break;
			}

		}
	}
	
	public void viewAcceptDoc(int total_docs) {
		if (total_docs > 0) {
			test = rep.startTest(" View Accept Document");
			test.log(LogStatus.INFO, "viewAcceptDoc");
			waitForPageToLoad();
			waitVisible("//*[contains(.,'Status')]");
			if(count(Constants.crm_document_status_submitted) > 0) {
				while (count(Constants.crm_document_status_submitted) > 0) {
					doubleclick(Constants.crm_document_status_submitted);
					wait(3);

					click(Constants.view_document_button);
					wait(3);
					click(Constants.accept_document_button);
					ifAlertExistAccept();
					wait(1);
/*					
					driver.switchTo().defaultContent();
					while (driver.getWindowHandles().size() < 2) {
						click(Constants.view_document_button);
						wait(3);
					}
					ArrayList<String> tabs_pw2_documents = new ArrayList<String>(driver.getWindowHandles());
					while (driver.getWindowHandles().size() > 1) {
						driver.switchTo().window(tabs_pw2_documents.get(0));
						wait(1);
						driver.switchTo().window(tabs_pw2_documents.get(1));
						driver.close();
						wait(2);
					}
					wait(1);
					driver.switchTo().window(tabs_pw2_documents.get(0));
					driver.switchTo().defaultContent();
					click(Constants.accept_document_button);
					ifAlertExistAccept();
					wait(1);
					waitVisible(Constants.accept_document_button);*/
					driver.switchTo().frame("contentIFrame0");
					waitVisible(Constants.crm_document_accepted);
					driver.switchTo().defaultContent();
					driver.navigate().back();
					ifAlertExistAccept();
					wait(1);
					driver.switchTo().frame("contentIFrame0");
					wait(2);
				}
				driver.navigate().back();
			}
			else
				driver.navigate().back();	
		}
	}
	
	public boolean isElementPresent(String locatorKey) {
		List<WebElement> elementList = null;
		elementList = driver.findElements(By.xpath(locatorKey));
		if (elementList.size() == 0)
			return false;
		else
			return true;
	}

	public void clickAndWait(String locator_clicked, String locator_present) {
		for (int i = 0; i < 10; i++) {
			getElement(locator_clicked).click();
			wait(2);
			ifAlertExistAccept();
			if (isElementPresent(locator_present))
				break;
		}
	}
	
	public void successMessage(String msg) {
		test = rep.startTest("COMPLETED SUCCESSFULLY " +msg);
		test.log(LogStatus.PASS, "SUCCESS " + msg);
		System.out.println("SUCCESS " + convertedTimestamp() + " **************** " + msg);
	}
	
	public void email(String email) {
		email = email.toUpperCase();
		for (int i = 1; i < 100; i++) {
			waitForPageToLoad();
			waitClickableOr(Constants.portal_email_field, "(//input[contains(@id,'mail')])[last()]");
			try {
				driver.findElement(By.xpath(Constants.portal_email_field)).sendKeys(email);
			} catch (Exception e) {
				driver.findElement(By.xpath("(//input[contains(@id,'mail')])[last()]")).sendKeys(email);
			}
			wait(2);
			if (count("//strong[text()='" + email + "']") > 0) {
				doubleclick("//strong[text()='" + email + "']");
				wait(1);
				break;
			} else
				
				try {
					setWindowfocus();
					driver.findElement(By.xpath(Constants.portal_email_field)).clear();
				} catch (Exception e) {
					setWindowfocus();
					driver.findElement(By.xpath("(//input[contains(@id,'mail')])[last()]")).clear();
				}
				
/*				try {
					setWindowfocus();
					new Robot().keyPress(java.awt.event.KeyEvent.VK_CONTROL);
					new Robot().keyPress(java.awt.event.KeyEvent.VK_A);
					new Robot().keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
					new Robot().keyPress(java.awt.event.KeyEvent.VK_BACK_SPACE);
				} catch (AWTException e) {
					e.printStackTrace();
				}*/
			wait(2);
		}
	}
	
	public void clickButton(String button_name) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(getElement("//button[contains(text(),'" +button_name+ "')]")));
		while(count("//button[contains(text(),'" +button_name+ "')]") > 0){
			click("//button[contains(text(),'" +button_name+ "')]");
			wait(2);
		}
	}
	
	public void waitClickable(String locatorKey) {
		WebDriverWait wait=new WebDriverWait(driver, 30); 
		wait.until(ExpectedConditions.elementToBeClickable(getElement(locatorKey)));
	}
	public void waitClickableOr(String locatorKey1, String locatorKey2) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.or(
		    ExpectedConditions.elementToBeClickable(By.xpath(locatorKey1)),
		    ExpectedConditions.elementToBeClickable(By.xpath(locatorKey2))));
	}
	
	public void waitForOneOf3Visible(String locatorKey1, String locatorKey2, String locatorKey3) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.or(
			ExpectedConditions.elementToBeClickable(By.xpath(locatorKey1)),
		    ExpectedConditions.elementToBeClickable(By.xpath(locatorKey2)),
		    ExpectedConditions.elementToBeClickable(By.xpath(locatorKey3))));
	}


	public void reportPass(String msg){
		test.log(LogStatus.PASS, msg);
	}

	public void viewAcceptDocs() {
		System.out.println(convertedTimestamp() + " **************** viewAcceptDocs test base");
		test = rep.startTest("View Accept Submitted Documents. viewAcceptDocs");
		test.log(LogStatus.INFO, "viewAcceptDocuments");
		waitForPageToLoad();
//		driver.switchTo().frame("contentIFrame0");
		waitVisible("//label[@class='ms-crm-List-Sortable'][text()='Document Status']");
		waitForOneOf3Visible("//nobr[text()='Accepted']", "//nobr[text()='Submitted']", "//nobr[text()='Pending']");
		if (count(Constants.crm_document_status_submitted) > 0) {
			doubleclick(Constants.crm_document_status_submitted);
			waitForPageToLoad();
			wait(3);
			driver.switchTo().defaultContent();
			click(Constants.view_document_button);
			wait(3);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			while (tabs.size() > 1) {
				driver.switchTo().window(tabs.get(1));
				driver.close();
				wait(2);
				tabs = new ArrayList<String>(driver.getWindowHandles());
			}
			driver.switchTo().window(tabs.get(0));
			doubleclick(Constants.accept_document_button);
			ifAlertExistAccept();
			waitForPageToLoad();
			wait(2);
			driver.switchTo().frame("contentIFrame0");
			waitVisible(Constants.crm_document_accepted);
			if (count(Constants.crm_document_accepted) > 0)
				reportPass("viewAcceptDocs");
		}
	}
	
	public boolean checkStringIsNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
			int a = Integer.valueOf(str);
			System.out.println("# of Answers is numeric " + d);
		} catch (NumberFormatException nfe) {
			System.out.println("# of Answers not numeric.");
			return false;
		}
		return true;
	}
	
	public void filter(String filter) {
		if (!filter.equals("")) {
			String[] data = filter.split(" :: ");
//			System.out.println(filter);
			System.out.println(convertedTimestamp() + " **************** Filter");
			test = rep.startTest("Filter");
			if (!data[0].equals("")) {
				click(Constants.filter_my_jobs_button);
				click("//a[text()='" + data[0] + Constants.close_xpath);
			}
//			System.out.println(data[5]);
			waitVisible(Constants.global_first_filter_field);
			if (!data[1].equals(""))
				type("//span[text()='Job Number']/following::input[@ng-model='colFilter.term']", data[1]);
			if (!data[2].equals(""))
				type("//span[text()='Filing Number']/following::input[@ng-model='colFilter.term']", data[2]);
			if (!data[3].equals(""))
				type("//span[text()='Filing Type']/following::input[@ng-model='colFilter.term']", data[3]);
			if (!data[4].equals(""))
				type("//span[text()='Filing Status']/following::input[@ng-model='colFilter.term']", data[4]);
			if (!data[5].equals(""))
				type("//span[text()='Address']/following::input[@ng-model='colFilter.term']", data[5]);
			if (!data[6].equals(""))
				type("//span[text()='Borough']/following::input[@ng-model='colFilter.term']", data[6]);
			if (!data[7].equals(""))
				type("//span[text()='Applicant of Record']/following::input[@ng-model='colFilter.term']", data[7]);
			if (!data[8].equals(""))
				type("//span[text()='Owner']/following::input[@ng-model='colFilter.term']", data[8]);
			if (!data[9].equals(""))
				type("//span[text()='Created Date']/following::input[@ng-model='colFilter.term']", data[9]);
			if (!data[10].equals(""))
				type("//span[text()='Modified Date']/following::input[@ng-model='colFilter.term']", data[10]);
			if (!data[11].equals(""))
				type("//span[text()='Payment Status']/following::input[@ng-model='colFilter.term']", data[11]);
		}
		reportPass("filter");
	}
	
	// Action moveToElement("//span[contains(text(),'DOB AHV Permits')]").click().keyDown(Keys.Ctrl).sendkeys(Keys.Down).build().perform();
	
/*	WebElement scroll = driver.findElement(By.id("someId"));
	scroll.sendKeys(Keys.PAGE_DOWN);*/
	
}
