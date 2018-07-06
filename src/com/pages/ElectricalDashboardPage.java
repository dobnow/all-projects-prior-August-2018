package com.pages;

import java.io.BufferedReader;
import java.io.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.TestBase;
import com.util.Constants;

public class ElectricalDashboardPage extends TestBase {
	WebDriver driver;
	public ElectricalDashboardPage(WebDriver dr) {
		driver = dr;
	}

	@FindBy(xpath=Constants.el_select_action)
	public WebElement el_select_action;
	@FindBy(xpath=Constants.el_select_action_subsequent_filing)
	public WebElement el_select_action_subsequent_filing;
	@FindBy(xpath=Constants.el_select_action_paa)
	public WebElement el_select_action_paa;
	@FindBy(xpath=Constants.el_confirm_yes_button)
	public WebElement el_confirm_yes_button;
	@FindBy(xpath=Constants.eljob_number_filter)
	public WebElement eljob_number_filter;
	@FindBy(xpath=Constants.eljob_filing_number_filter)
	public WebElement eljob_filing_number_filter;
	
	@FindBy(xpath=Constants.el_job_filing_includes_new_work_only)
	public WebElement el_job_filing_includes_new_work_only;
	@FindBy(xpath=Constants.el_job_filing_includes_submit_button)
	public WebElement el_job_filing_includes_submit_button;
	
	@FindBy(xpath=Constants.el_subsequent_filing_work_type)
	public WebElement el_subsequent_filing_work_type;
	@FindBy(xpath=Constants.el_subsequent_filing_create_button)
	public WebElement el_subsequent_filing_create_button;
	
	@FindBy(xpath=Constants.job_filing_button)
	public WebElement job_filing_button;
	@FindBy(xpath=Constants.checkbox_antenna)
	public WebElement checkbox_antenna;
	@FindBy(xpath=Constants.submit_work_type_button)
	public WebElement submit_work_type_button;
	@FindBy(xpath=Constants.filtered_job)
	public WebElement filtered_job;
	@FindBy(xpath=Constants.job_number_search)
	public WebElement job_number_search;
	@FindBy(xpath=Constants.job_search_input_box)
	public WebElement job_search_input_box;
	@FindBy(xpath=Constants.search_button)
	public WebElement search_button;
	@FindBy(xpath=Constants.global_save_step_button)
	public WebElement global_save_step_button;
	@FindBy(xpath=Constants.global_notification_ok_button)
	public WebElement global_notification_ok_button;
	@FindBy(xpath=Constants.global_loading_spinner)
	public WebElement global_loading_spinner;
	
	public static String sCurrentLine;
	public static FileReader fr = null;
	public static BufferedReader txtReader = null;
	
	public void selectWorkTypeSubs(String work_type) {	
		String[] data = work_type.split(" :: ");
		System.out.println(convertedTimestamp() + " ****************  selectWorkTypeSubs");
		test = rep.startTest("selectWorkTypeSubs");
 		waitUntilElementVisible(Constants.el_subsequent_filing_create_button, 30);
		String document_xpath =  "//input[@ng-model='rowData." + data[0] +  "FilingWorktype']";
		waitVisible(document_xpath);
		click(document_xpath);
		waitVisible(Constants.global_create_subsequent_button);
		click(Constants.global_create_subsequent_button);
		waitInvisible(Constants.global_create_subsequent_button);
		waitUntilISpinnersInvisible();
		reportPass("selectWorkTypeSubs");
}

	public void jobFiling(String worktype) {	
		if(!worktype.equals("")){
			test = rep.startTest("jobFiling");
			waitVisible(Constants.job_filing_button);
	 		click(Constants.job_filing_button);
//	 		waitVisible(Constants.job_filing_modal);
	 	    if (count("//input[@ng-model='" +worktype+ "FilingWorktype']") > 0)
	 	    	check("//input[@ng-model='" +worktype+ "FilingWorktype']");
	 	    if (count("//input[@ng-model='rowData." +worktype+ "FilingWorktype']") > 0)
	 	    	check("//input[@ng-model='rowData." +worktype+ "FilingWorktype']");
//			check("//input[@ng-model='ElectricalFilingWorktype']");
			click("//button[@ng-disabled='isSelectedWorkType'][@ng-click='next()']");
		}
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
			reportPass("filter");
		}
	}
	
		public void subsFilingAction(String user, String filter) {	
		if(!filter.equals("")){
			test = rep.startTest("Subsequent Filing Test");
			System.out.println(convertedTimestamp() + " **************** Subsequent Filing");
			loginToPortal(user);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.global_first_filter_field);
			filter(filter);
			wait(1);
			select(Constants.filing_action_label, "Subsequent Filing");
	 		click(Constants.yes_button);
	 		waitInvisible(Constants.yes_button);
	 		waitUntilISpinnersInvisible();
	 		reportPass("Success");
		}
	}
	
	public void XfilterInitialJobSubs() {
		waitUntilElementVisible(Constants.global_first_filter_field, 30);
		eljob_number_filter.sendKeys(JOB_NUMBER.getProperty("job_number_subs_elec"));
		waitTime(1000L);
		eljob_filing_number_filter.sendKeys("I");
		waitTime(1000L);
	}
	public void action(String action, String work_type) {	
		if(!action.equals("")){
			System.out.println(convertedTimestamp() + " **************** Action Dash");
			loginToPortal(OR_PROPERTIES.getProperty("electrical_user_email"));
			type(Constants.eljob_number_filter, JOB_NUMBER.getProperty("job_number_el"));
			test = rep.startTest("Subsequent Filing");
			type(Constants.eljob_filing_number_filter, "I");
			wait(1);
			select(Constants.el_select_action, action);
	 		click(Constants.el_confirm_yes_button);
	 		waitInvisible(Constants.el_confirm_yes_button);
			String document_xpath =  "//input[@type='checkbox'][@ng-model='rowData." +work_type+ "FilingWorktype']";
			check(document_xpath);
	 		click(Constants.el_subsequent_filing_create_button);
	 		waitUntilISpinnersInvisible();
		}
	}
	public void actionOnPermitIssued(String action, String work_type) {	
		if(!action.equals("")){
			System.out.println(convertedTimestamp() + " **************** actionOnPermitIssued EL");
			loginToPortal(OR_PROPERTIES.getProperty("electrical_user_email"));
			test = rep.startTest("action On Permit Issued");
			type(Constants.job_filing_number_filter, "I");
			type(Constants.filing_status_field, "permit");
			type("(//input[@ng-model='colFilter.term'])[10]", "exe");
			wait(1);
			select_val(Constants.select_action_dropdown, action);
	 		click(Constants.el_confirm_yes_button);
	 		waitInvisible(Constants.el_confirm_yes_button);
			String document_xpath =  "//input[@type='checkbox'][@ng-model='rowData." +work_type+ "FilingWorktype']";
			if(count(document_xpath) > 0)
				check(document_xpath);
			if(count(Constants.el_subsequent_filing_create_button) > 0)
				click(Constants.el_subsequent_filing_create_button);
	 		waitUntilISpinnersInvisible();
		}
	}
	public void subsequentFiling(String subsequent_filing) {	
		if(!subsequent_filing.equals("")){
			System.out.println(convertedTimestamp() + " **************** subsequentFiling dash");
			loginToPortal(OR_PROPERTIES.getProperty("electrical_user_email"));
			type(Constants.eljob_number_filter, JOB_NUMBER.getProperty("job_number_el"));
			test = rep.startTest("Subsequent Filing");
			type(Constants.eljob_filing_number_filter, "I");
			select_val(Constants.el_select_action, "SubsequentFiling");
	 		click(Constants.el_confirm_yes_button);
	 		waitInvisible(Constants.el_confirm_yes_button);
			String document_xpath =  "//input[@type='checkbox'][@ng-model='rowData." +subsequent_filing+ "FilingWorktype']";
			check(document_xpath);
	 		click(Constants.el_subsequent_filing_create_button);
	 		waitUntilISpinnersInvisible();
		}
	}
/*	public void selectWorkTypeSub(String work_type_subs) {	
		if(!work_type_subs.equals("")){
			test = rep.startTest("Select Work Type Sub");
			waitUntilElementVisible(Constants.el_subsequent_filing_create_button, 30);
	 		String work_type_part1 = "//input[@ng-model='rowData.";
	 		String work_type_part2 =  "FilingWorktype']";
			String document_xpath =  work_type_part1 + work_type_subs + work_type_part2;
			waitUntilVisible(document_xpath);
			click(document_xpath);
			waitUntilVisible(Constants.global_create_subsequent_button);
			click(Constants.global_create_subsequent_button);
			waitInvisible(Constants.global_create_subsequent_button);
			waitUntilISpinnersInvisible();
		}
	}*/
/*	public void XsubsequentFilingMixed(String subsequent_filing) {	
		if(!subsequent_filing.equals("")){
			waitUntilElementVisible("//input[@ng-model='colFilter.term']", 30);
//			filterInitialJobSubs();
			test = rep.startTest("subsequentFilingMixed");
			click(Constants.el_select_action);
			click(Constants.el_select_action_subsequent_filing);
	 		el_select_action_subsequent_filing.click();
	 		click(Constants.el_confirm_yes_button);
	 		waitInvisible(Constants.el_confirm_yes_button);
	 		check(Constants.el_subsequent_filing_work_type);
	 		click(Constants.el_subsequent_filing_create_button);
	 		waitUntilISpinnersInvisible();
		}
	}*/
	
	public void pAa(String paa) {	
		if(!paa.equals("")){
			System.out.println(convertedTimestamp() + " **************** pAa dash");
			loginToPortal(OR_PROPERTIES.getProperty("electrical_user_email"));
			type(Constants.eljob_number_filter, JOB_NUMBER.getProperty("job_number_el"));
			type(Constants.eljob_filing_number_filter, "I");
	 		click(Constants.el_select_action);
	 		click(Constants.el_select_action_paa);
	 		click(Constants.el_confirm_yes_button);
	 		waitInvisible(Constants.el_confirm_yes_button);
	 		waitUntilISpinnersInvisible();
		}
	}
		
		public void selectWorkType(String worktype) {	
			if(!worktype.equals("")){
		 		click(Constants.job_filing_button);
				check("//input[@ng-model='ElectricalFilingWorktype']");
				click("//button[@ng-disabled='isSelectedWorkType'][@ng-click='next()']");
			}
		}
	
		public void selectWorkTypeMixed(String work_type_subs) {	
			if(!work_type_subs.equals("")){
		 		waitUntilElementVisible(Constants.el_subsequent_filing_create_button, 30);
//				waitUntilElementVisible(Constants.submit_work_type_button, 30);
		 		String work_type_part1 = "//input[@ng-model='rowData.";
		 		String work_type_part2 =  "FilingWorktype']";
				String document_xpath =  work_type_part1 + work_type_subs + work_type_part2;
//				System.out.println(document_xpath);
				waitUntilElementVisible(document_xpath, 30);
				clickElement(document_xpath);
				waitUntilElementVisible("//button[contains(.,'Create Subsequent')]", 30);
				driver.findElement(By.xpath("//button[contains(.,'Create Subsequent')]")).click();
//				System.out.println(driver.findElements(By.xpath(Constants.el_job_filing_includes_new_work_only)).size());
/*				if(!work_type_subs.contains("Plumbing")){
					waitUntilElementVisible("//button[contains(.,'Create Subsequent')]", 30);
					driver.findElement(By.xpath("//button[contains(.,'Create Subsequent')]")).click();
//					waitUntilElementVisible(Constants.el_job_filing_includes_submit_button, 30);
//					el_subsequent_filing_create_button.click();
//					el_job_filing_includes_submit_button.click();
					System.out.println("Plumbing");
				}*/
			}
		}
		
	public void submitWorkType(String worktype) {	
		if(!worktype.equals("")){
	 		waitUntilElementVisible(Constants.submit_work_type_button, 30);
	 		submit_work_type_button.click();
		}
	}	
	
}