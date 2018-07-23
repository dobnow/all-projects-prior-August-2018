package com.pages;

import java.util.ArrayList;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.util.Constants;

public class DobDashboardPage extends TestBase {
	
	public void selectWorkType(String worktype) {	
		if(!worktype.equals("")){
			System.out.println(convertedTimestamp() + " **************** New Filing - selectWorkType");
			loginToPortal(OR_PROPERTIES.getProperty("user_email"));
			test = rep.startTest("Dash Select Work Type");
	 		click(Constants.job_filing_button);
//	 		waitVisible(Constants.job_filing_modal);
	 		waitVisible(Constants.filing_next_button);
	 	    if (count("//input[@ng-model='" +worktype+ "FilingWorktype']") > 0)
	 	    	check("//input[@ng-model='" +worktype+ "FilingWorktype']");
	 	    if (count("//input[@ng-model='rowData." +worktype+ "FilingWorktype']") > 0)
	 	    	check("//input[@ng-model='rowData." +worktype+ "FilingWorktype']");
	 		click(Constants.filing_next_button);
	 		waitInvisible(Constants.filing_next_button);
	 		reportPass("selectWorkType");
		}
	}
	public void selectWorkTypePlumbing(String worktype) {	
		if(!worktype.equals("")){
			System.out.println(convertedTimestamp() + " **************** New Filing - selectWorkTypePlumbing");
			loginToPortal(user);
			test = rep.startTest("Dash Select Work Type");
	 		click(Constants.job_filing_button);
//	 		waitVisible(Constants.job_filing_modal);
	 		waitVisible(Constants.filing_next_button);
	 	    if (count("//input[@ng-model='" +worktype+ "FilingWorktype']") > 0)
	 	    	check("//input[@ng-model='" +worktype+ "FilingWorktype']");
	 		click(Constants.filing_next_button);
	 		waitInvisible(Constants.filing_next_button);
	 		if(!CONFIG.getProperty("env").contains("8085")) {
		 		radio("//input[@ng-model='FilingIncludes'][@ng-value='1']");
		 		click(Constants.submit_work_type_button);
		 		waitInvisible(Constants.submit_work_type_button);
	 		}
//	 		radio("//input[@ng-model='FilingIncludes'][@ng-value='1']");
//	 		click(Constants.submit_work_type_button);
//	 		waitInvisible(Constants.submit_work_type_button);
	 		reportPass("selectWorkTypePlumbing");
		}
	}
	public void jobFilingElev(String work_type) {	
		if(!work_type.equals("")){
			System.out.println(convertedTimestamp() + " **************** jobFilingElev");
			loginToPortal(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			test = rep.startTest("Dash New Filing 'Select Work Type'");
	 		click(Constants.job_filing_button);
	 		wait(1);
			String[] data = work_type.split(" :: ");
	 		if (count("//input[@ng-model='" +data[0]+ "FilingWorktype']") > 0)
	 	    	check("//input[@ng-model='" +data[0]+ "FilingWorktype']");
	 	    if (count("//input[@ng-model='rowData." +data[0]+ "FilingWorktype']") > 0)
	 	    	check("//input[@ng-model='rowData." +data[0]+ "FilingWorktype']");
	 		click(Constants.job_filing_next_button);
	 		wait(1);
	 		radio("//input[@type='radio'][@id='rdNewApp" +data[1] +Constants.close_xpath);
/*	 		
	 		if(data[1].contains("New"))
	 			radio(Constants.new_installation_radio);
	 		if(data[1].contains("Alter"))
	 			radio(Constants.alteration_replacement_radio);
	 		wait(1);*/
	 		click(Constants.job_filing_next_button);
	 		radio("//input[@type='radio'][@id='rdNewAppDevice"+ data[2] +Constants.close_xpath);
	 		wait(1);
	 		click(Constants.select_device_submit_button);
	 		waitInvisible(Constants.select_device_submit_button);
	 		reportPass("Success");
		}
	}

	public void selectWorkTypeTp(String worktype) {
		if (!worktype.equals("")) {
			System.out.println(convertedTimestamp() + " **************** New Filing - selectWorkTypeTp");
			loginToPortal(OR_PROPERTIES.getProperty("user_email"));
			test = rep.startTest("Dash Select Work Type");
			click(Constants.job_filing_button);
			waitVisible("//span[@ng-show='!ElevatorsFilingWorktype']");
//			System.out.println("//input[@ng-model='" + worktype + "FilingWorkType']");
			if (count("//input[@ng-model='" + worktype + "FilingWorkType']") > 0)
				check("//input[@ng-model='" + worktype + "FilingWorkType']");
			click("//span[@ng-show='!ElevatorsFilingWorktype']");
			waitInvisible("//span[@ng-show='!ElevatorsFilingWorktype']");
			reportPass("selectWorkType");
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
		}
		reportPass("filter");
	}
	public void filterPermits(String filter) {
		if (!filter.equals("")) {
//			System.out.println(filter);
			String[] data = filter.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** Filter");
			test = rep.startTest("Filter");
			if (!data[0].equals("")) {
				click(Constants.filter_my_jobs_button);
				click("//a[text()='" + data[0] + Constants.close_xpath);
			}
			if (!data[1].equals(""))
				type("//span[text()='Job Number']/following::input[@ng-model='colFilter.term']", data[1]);
			if (!data[2].equals(""))
				type("//span[text()='Filing Number']/following::input[@ng-model='colFilter.term']", data[2]);
			if (!data[3].equals(""))
				type("//span[text()='Tracking No.']/following::input[@ng-model='colFilter.term']", data[3]);
			if (!data[4].equals(""))
				type("//span[text()='Work Permit No.']/following::input[@ng-model='colFilter.term']", data[4]);
			if (!data[5].equals(""))
				type("//span[text()='Sequence No.']/following::input[@ng-model='colFilter.term']", data[5]);
			if (!data[6].equals(""))
				type("//span[text()='Work Permit Status']/following::input[@ng-model='colFilter.term']", data[6]);
			if (!data[7].equals(""))
				type("//span[text()='Address']/following::input[@ng-model='colFilter.term']", data[7]);
			if (!data[8].equals(""))
				type("//span[text()='Permit Type']/following::input[@ng-model='colFilter.term']", data[8]);
				if (!data[9].equals(""))
				type("//span[text()='Created Date']/following::input[@ng-model='colFilter.term']", data[9]);
			if (!data[10].equals(""))
				type("//span[text()='Contractor']/following::input[@ng-model='colFilter.term']", data[10]);
			reportPass("filterPermits");
		}
	}
	public void actionOnSameWorkTypePermit(String action, String work_type) {	
		if(!action.equals("")){
			System.out.println(convertedTimestamp() + " **************** Action actionOnPermit");
			loginToPortal(OR_PROPERTIES.getProperty("user_email"));
			test = rep.startTest("Action On Permit DOB Dash");
			click(Constants.filter_my_jobs_button);
			click("//a[@class=''][text()='"+work_type+"']");
			
			
			type(Constants.job_filing_number_filter, "I");
			type(Constants.filing_status_field, "permit");
			type("(//input[@ng-model='colFilter.term'])[11]", "exempted");
			wait(1);
			select_val(Constants.select_action_dropdown, action);
	 		click(Constants.el_confirm_yes_button);
	 		waitInvisible(Constants.el_confirm_yes_button);
	 		check("//input[@ng-model='rowData." + work_type + "FilingWorktype']");
	 		click(Constants.el_subsequent_filing_create_button);
	 		waitUntilISpinnersInvisible();
	 		reportPass("Success");
		}
	}
	public void actionOnPermitInit(String action, String work_type) {	
		if(!action.equals("")){
			System.out.println(convertedTimestamp() + " **************** Action actionOnPermit");
			loginToPortal(OR_PROPERTIES.getProperty("user_email"));
			test = rep.startTest("Action On Permit DOB Dash");
			type(Constants.job_filing_number_filter, "I");
			type(Constants.filing_status_field, "permit");
			type("(//input[@ng-model='colFilter.term'])[11]", "exempted");
			wait(1);
			select_val(Constants.select_action_dropdown, action);
	 		click(Constants.el_confirm_yes_button);
	 		waitInvisible(Constants.el_confirm_yes_button);
	 		check("//input[@ng-model='rowData." + work_type + "FilingWorktype']");
	 		click(Constants.el_subsequent_filing_create_button);
	 		waitUntilISpinnersInvisible();
	 		reportPass("Success");
		}
	}
	
	public void actionOnPermitSubs(String action, String work_type) {
		if(!action.equals("")){
			System.out.println(convertedTimestamp() + " **************** Action actionOnSubsPermit");
			loginToPortal(OR_PROPERTIES.getProperty("user_email"));
			test = rep.startTest("action On Permit Issued");
			type(Constants.filing_type_field, "subsequent");
			type(Constants.filing_status_field, "permit");
			wait(1);
			select_val(Constants.select_action_dropdown, action);
	 		click(Constants.el_confirm_yes_button);
	 		waitInvisible(Constants.el_confirm_yes_button);
	 		check("//input[@ng-model='rowData." + work_type + "FilingWorktype']");
	 		click(Constants.el_subsequent_filing_create_button);
	 		waitUntilISpinnersInvisible();
	 		reportPass("Success");
		}
	}
	
	public void filterInitialJob(String work_type) {
		test = rep.startTest("Filter Initial Job");
		waitVisible(Constants.global_first_filter_field);
		type(Constants.job_number_filter, JOB_NUMBER.getProperty("job_number_subs"));
		waitTime(1000L);
		type(Constants.eljob_filing_number_filter, "I");
		waitTime(1000L);
		reportPass("Success");
	}
	

	
	public void subsequentFilingMixed(String subsequent_filing, String work_type) {	
		if(!subsequent_filing.equals("")){
			test = rep.startTest("subsequentFilingMixed");
			waitVisible(Constants.global_first_filter_field);
//			type(Constants.job_number_filter, JOB_NUMBER.getProperty("job_number_subs"));
			type("(//input[@ng-model='colFilter.term'])[4]", "permit");


//			waitVisible(Constants.select_action_dropdown);
	 		click(Constants.select_action_dropdown);
	 		click(Constants.el_select_action_subsequent_filing);
//	 		waitVisible(Constants.el_confirm_yes_button);
	 		click(Constants.el_confirm_yes_button);
	 		waitInvisible(Constants.el_confirm_yes_button);
	 		waitUntilISpinnersInvisible();
	 		reportPass("Success");
		}
	}
	public void subsequentFiling(String subsequent_filing) {	
		if(!subsequent_filing.equals("")){
			test = rep.startTest("subsequentFiling");
			System.out.println(convertedTimestamp() + " **************** " + "subsequentFiling");
			loginToPortal(OR_PROPERTIES.getProperty("user_email"));
			waitVisible(Constants.global_first_filter_field);
			type(Constants.job_number_filter, JOB_NUMBER.getProperty("job_number"));
			wait(1);
			type(Constants.eljob_filing_number_filter, "I");
			wait(1);
			waitVisible(Constants.job_filing_number_filter);
			waitVisible(Constants.select_action_dropdown);
	 		click(Constants.select_action_dropdown);
	 		click(Constants.el_select_action_subsequent_filing);
	 		waitVisible(Constants.el_confirm_yes_button);
	 		click(Constants.el_confirm_yes_button);
	 		waitInvisible(Constants.el_confirm_yes_button);
	 		waitUntilISpinnersInvisible();
	 		reportPass("Success");
		}
	}
	public void selectWorkTypeMixed(String work_type_subs) {	
		if(!work_type_subs.equals("")){
			test = rep.startTest("selectWorkTypeMixed");
	 		waitUntilElementVisible(Constants.el_subsequent_filing_create_button, 30);
	 		String work_type_part1 = "//input[@ng-model='rowData.";
	 		String work_type_part2 =  "FilingWorktype']";
			String document_xpath =  work_type_part1 + work_type_subs + work_type_part2;
//			waitVisible(document_xpath);
			click(document_xpath);
			waitVisible(Constants.global_create_subsequent_button);
			click(Constants.global_create_subsequent_button);
			waitInvisible(Constants.global_create_subsequent_button);
			waitUntilISpinnersInvisible();
			reportPass("Success");
		}
	}
	public void selectWorkTypeSubs(String work_type) {	
			String[] data = work_type.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** selectWorkTypeSubs");
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

	public void correction(String filter) {
		if (!filter.equals("")) {
//			String[] data = filter.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** CorrectionTest");
			loginToPortal(OR_PROPERTIES.getProperty("user_email"));
			test = rep.startTest("Correction");
			waitVisible(Constants.global_first_filter_field);
			select(Constants.items_per_page, "20");
			filter(filter);
			for (int i = 1; i <= 20; i++) {
				select("(//select[@id='FilingAction'])[" + i + "]", "Correction");
				clickButton("Yes");
				waitInvisible(Constants.yes_button);
				waitUntilISpinnersInvisible();
				if (count(Constants.global_notification_message) > 0) {
					if (text(Constants.global_notification_message).contains("Correction in progress")) {
						clickButton("OK");
					}
				}
				else
					break;				
			}
			reportPass("Success");
		}
	}

	public void requestSinOff(String action) {	
		if(!action.equals("")){
			System.out.println(convertedTimestamp() + " **************** requestSinOff");
			loginToPortal(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			test = rep.startTest("Sign Off");
			waitVisible(Constants.global_first_filter_field);
			type(Constants.job_number_filter, JOB_NUMBER.getProperty("job_number"));
			wait(1);
			select(Constants.filing_action_label, action);
	 		click(Constants.yes_button);
	 		waitInvisible(Constants.yes_button);
	 		waitUntilISpinnersInvisible();
	 		reportPass("Success");
		}
	}
	
	public void renewPermitElv(String filter) {
		if (!filter.equals("")) {
			System.out.println(convertedTimestamp() + " **************** renewPermitElv");
			loginToPortal(user);
			test = rep.startTest("renewPermitElv");
			// click(Constants.my_work_permits_tab);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.global_first_filter_field);
			select(Constants.items_per_page, "20");
			filter(filter);
			for (int i = 1; i < 20; i++) {
				// wait(1);
				select("(//select[@id='FilingAction'])[" + i + "]", "Renew Work Permit");
				clickButton("Yes");
				waitInvisible(Constants.yes_button);
				waitVisible("//input[@id='chkAcknowledgement']");
				check("//input[@id='chkAcknowledgement']");
				click("//span[text()='Save']");
				waitVisible(Constants.ok_button);
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				waitVisible("//button[@ng-click='PayRenew()']");
				if (count("//button[@ng-click='PayRenew()'][@disabled='disabled']") == 0)
					break;
				else {
					waitVisible("//button[@ng-click='initRenewPermit(frmElevatorWorkPermit)']");
					if (count("//button[@ng-click='initRenewPermit(frmElevatorWorkPermit)'][@disabled='disabled']") == 0) {
						click("//button[@ng-click='initRenewPermit(frmElevatorWorkPermit)']");
						clickButton("OK");
					}
				}
//					click(Constants.global_cancel_button);
			}
			reportPass("Success");
		}
	}
	
	public void submitPermit(String renew) {
		if (!renew.equals("")) {
			System.out.println(convertedTimestamp() + " **************** submitPermit");
//			filterJob(user);
			test = rep.startTest("submitPermit");
//			click(Constants.my_work_permits_tab);
//			waitUntilISpinnersInvisible();
			driver.switchTo().defaultContent();
			if(count(Constants.ok_button) > 0) {
				clickButton("OK");
				waitInvisible(Constants.ok_button);
			}
			waitVisible("//button[@ng-click='initRenewPermit(frmElevatorWorkPermit)']");
			while(count("//button[@ng-click='initRenewPermit(frmElevatorWorkPermit)'][@disabled='disabled']") > 0) {
				refreshPage();
				wait(5);
				waitVisible("//button[@ng-click='initRenewPermit(frmElevatorWorkPermit)']");
				if(count("//button[@ng-click='initRenewPermit(frmElevatorWorkPermit)'][@disabled='disabled']") == 0)
					break;
			}
			click("//button[@ng-click='initRenewPermit(frmElevatorWorkPermit)']");
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_renewed"));
	 		clickButton("OK");
			waitInvisible(Constants.ok_button);
			reportPass("Success");
		}
	}
	
	public void renewPermit(String filter) {
		if (!filter.equals("")) {
			// System.out.println(filter); // REMOVE
			test = rep.startTest("renewPermit");
			System.out.println(convertedTimestamp() + " **************** " + "renewPermit");
			loginToPortal(OR_PROPERTIES.getProperty("user_email"));
			test = rep.startTest("renewPermit");
			click(Constants.my_work_permits_tab);
			waitUntilISpinnersInvisible();

			filterPermits(filter);

			// type("(//input[@ng-model='colFilter.term'])[1]",
			// JOB_NUMBER.getProperty("job_number") );

			wait(1);
			select(Constants.filing_action_label, "Renew Work Permit");
			click(Constants.yes_button);
			waitInvisible(Constants.yes_button);
			waitUntilISpinnersInvisible();

			addToProps("job_number", text("//h4[contains(.,'Work Permit')]").trim().substring(12, 21).trim());

			/*
			 * type(Constants.job_number_filter, JOB_NUMBER.getProperty("job_number"));
			 * type("(//input[@ng-model='colFilter.term'])[4]",
			 * JOB_NUMBER.getProperty("job_number")); click(Constants.filing_action_label);
			 * wait(1); click(Constants.select_action_renew_permit);
			 * click(Constants.confirm_yes_button); click(Constants.confirm_yes_button);
			 * waitInvisible(Constants.confirm_yes_button); waitUntilISpinnersInvisible();
			 */
			click(Constants.pw2_calendar_icon);
			wait(1);
			click(Constants.pw2_calendar_active_day);
			wait(1);
			check(Constants.pw2_information_correct_and_complete);
			click(Constants.pw2_save_button);
			waitVisible(Constants.global_notification_ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("work_permit_saved"), "renewPermit");
			click(Constants.global_notification_ok_button);
			waitInvisible(Constants.global_notification_ok_button);
			if (!CONFIG.getProperty("env").contains("444")) { // if 444 document not required
				test = rep.startTest("Renew Permit PW2 upload docs");
				System.out.println(convertedTimestamp() + " **************** " + "Renew Permit uploadDocuments");
				scrollAllWayUp();
				click(Constants.pw2_documents_tab);
				int number_of_docs = 0;
				String global_required_label = null;
				if (CONFIG.getProperty("env").contains("444"))
					global_required_label = "//div[@class='ui-grid-cell-contents'][contains(.,'Required')]";
				if (CONFIG.getProperty("env").contains("443")) {
					global_required_label = "//span[@data-ctooltip='Required']";
					doubleclick(Constants.pw2_documents_tab);
				}
				while (count(global_required_label) > 0) {
					number_of_docs = number_of_docs + 1;
					test.log(LogStatus.INFO, "Upload documents " + number_of_docs);
					String uoload_icon_xpath = Constants.global_upload_icon_xparth_part1 + number_of_docs
							+ Constants.global_upload_icon_xparth_part2;
					click(uoload_icon_xpath);
					waitUntilElementVisible(Constants.doc_browse_button, 30);
					send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
					click(Constants.doc_upload_button);
					waitInvisible(Constants.doc_please_wait_message);
					waitVisible(Constants.doc_upload_succesfull_message);
					click(Constants.doc_document_uploaded_ok_button);
					waitInvisible(Constants.doc_document_uploaded_ok_button);
					waitInvisible(Constants.global_loading_spinner);
					waitUntilISpinnersInvisible();
					// TEMP FIX
					click(Constants.pw2_save_button);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.global_notification_ok_button);
					assertNotification(TEXT_PROPERTIES.getProperty("work_permit_saved"), "uploadDocuments");
					click(Constants.global_notification_ok_button);
					waitInvisible(Constants.global_notification_ok_button);
				}
			}
			addToProps("tracking_number",text("//*[@id='frmWorkPermit']/div[2]/div[3]/div[6]/div[1]/div[2]/span").trim());
			reportPass("Success");
		}
	}
	public void renewPermitPay(String filter) {
		if (!filter.equals("")) {
			System.out.println(convertedTimestamp() + " **************** " + "PermitRenewalPay");
			
			wait(10);
				if(!CONFIG.getProperty("env").contains("8085")) {
					while (count("//a[@id='overridelink']") > 0) {
						driver.navigate().to("javascript:document.getElementById('overridelink').click()");
						wait(5);
						if (count("//a[@name='overridelink']") == 0)
							break;
						refreshPage();
					}
				}
			
			
			loginToPortal(user);
			test = rep.startTest("renewPermitPay");
			click(Constants.my_work_permits_tab);
			waitUntilISpinnersInvisible();
			type("(//input[@ng-model='colFilter.term'])[3]", JOB_NUMBER.getProperty("tracking_number").trim());
			doubleclick("//*[@id='dashboardGrid2']/div[1]/div[3]/div[2]/div/div/div/div[1]/div");
			waitUntilISpinnersInvisible();
				for (int i = 1; i < 20; i++) {
				
				click(Constants.pay_now_button_work_permit);
				waitInvisible60(Constants.dialog_box_overlay);
				
				wait(10);
				if (driver.getWindowHandles().size() > 1)
					break;
			}
			ArrayList<String> new_tab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(new_tab.get(1));
			driver.manage().window().maximize();
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			waitVisible60(Constants.pay_continue_button);
			type(Constants.pay_first_name, "Don");
			type(Constants.pay_last_name, "pedro");
			type(Constants.pay_address, "888 5 Ave");
			type(Constants.pay_city, "New York");
			type(Constants.pay_zip, "10021");
			type(Constants.pay_phone, "2125558888");
			type(Constants.pay_email, "mmazay@buildings.nyc.gov");
			type(Constants.pay_email_confirm, "mmazay@buildings.nyc.gov");
			click(Constants.pay_continue_button);
			click(Constants.pay_next_button);
			type(Constants.pay_name_on_account, "don pedro");
			type(Constants.account_number, "123456789");
			type(Constants.account_number_confirm, "123456789");
			type(Constants.aba_routing_number, "021000089");
			click(Constants.pay_next_button);
			click(Constants.pay_pay_now_button);
			waitInvisible60(Constants.pay_pay_now_button);
			assertElementPresent("//button[@id='imgBtnPrint']", "print button");
			assertTextPresent("Receipt Details", "Receipt Details");
			reportPass("Success");
		}
	}
	public void filePermit(String file, String assertion) {
		if (!file.equals("")) {
			System.out.println(convertedTimestamp() + " **************** " + "FilePermit");
			loginToPortal(user); // permit renewal user MRCTEST003@GMAIL.COM
			test = rep.startTest("FilePermit");
			click(Constants.my_work_permits_tab);
			waitUntilISpinnersInvisible();
			type(Constants.job_number_filter, JOB_NUMBER.getProperty("job_number"));
			waitVisible("//*[@id='dashboardGrid2']/div[1]/div[3]/div[2]/div/div[1]/div/div[1]/div");
			doubleclick("//*[@id='dashboardGrid2']/div[1]/div[3]/div[2]/div/div[1]/div/div[1]/div");
//			click(Constants.pw2_work_permit_step);
//			doubleclick(Constants.pw2_permit_not_yet_issued);
	 		wait(5);
			click(Constants.pw2_file_button);
			wait(5);
	 		waitVisible60(Constants.global_notification_ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("work_permit_submitted_for_review"), "work_permit_submitted_for_review");
			click(Constants.global_notification_ok_button);
			waitInvisible(Constants.global_notification_ok_button);
			assertFilingStatus(assertion);
			reportPass("Success");
		}
	}
	public void ahv(String ahv, String filter) {	
		if(!ahv.equals("")){
			test = rep.startTest("Start AHV Test");
			System.out.println(convertedTimestamp() + " **************** " + "AHV dash");
			loginToPortal(OR_PROPERTIES.getProperty("user_email"));
			click(Constants.my_work_permits_tab);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.global_first_filter_field);
			filterPermits(filter);
//			type(Constants.job_number_filter, JOB_NUMBER.getProperty("job_number"));
//			type(Constants.job_filing_number_filter1, JOB_NUMBER.getProperty("job_number"));
			wait(1);
			select(Constants.filing_action_label, "Create AHV");
	 		clickButton("Yes");
	 		waitInvisible(Constants.yes_button);
	 		waitUntilISpinnersInvisible();
	 		reportPass("Success");
		}
	}
	
	public void filterToPay(String filter) {
		if (!filter.equals("")) {
			test = rep.startTest("filterToPay");
			System.out.println(convertedTimestamp() + " **************** filterToPay");
			loginToPortal(user);
			// click(Constants.my_work_permits_tab);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.global_first_filter_field);
			select("//select[@ng-model='grid.options.paginationPageSize']", "20");
			filter(filter);
			
			if(count(Constants.click_to_view_icon) > 0) {
				click(Constants.click_to_view_icon);
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				waitUntilISpinnersInvisible();
			}
/*			for (int i = 1; i < 20; i++) {
				wait(1);
				fdsfdsfdsf
				select("(//select[@id='FilingAction'])[" + i + "]", "PAA");
				// select(Constants.filing_action_label, "PAA");
				click(Constants.yes_button);
				wait(2);
				if (count("//p[@id='desc'][contains(text(), 'PAA already in progress')]") > 0)
					click(Constants.ok_button);
				else
					break;
			}*/
			waitInvisible(Constants.ok_button);
			waitInvisible(Constants.yes_button);
			waitUntilISpinnersInvisible();
			reportPass("Success");
		}
	}

	public void paa(String filter) {
		if (!filter.equals("")) {
			test = rep.startTest("Start PAA Test");
			System.out.println(convertedTimestamp() + " **************** paa dash");
			loginToPortal(user);
			// click(Constants.my_work_permits_tab);
			waitVisible(Constants.global_first_filter_field);
			select("//select[@ng-model='grid.options.paginationPageSize']", "20");
			filter(filter);			
/*			if(count(Constants.click_to_view_icon) > 0) {
				click(Constants.click_to_view_icon);
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				waitUntilISpinnersInvisible();
			}*/
			for (int i = 1; i < 20; i++) {
				wait(1);
				select("(//select[@id='FilingAction'])[" + i + "]", "PAA");
				// select(Constants.filing_action_label, "PAA");
				click(Constants.yes_button);
				wait(2);
				if (count("//p[@id='desc'][contains(text(), 'PAA already in progress')]") > 0)
					click(Constants.ok_button);
				else
					break;
			}
			waitInvisible(Constants.ok_button);
			waitInvisible(Constants.yes_button);
			waitUntilISpinnersInvisible();
			reportPass("Success");
		}
	}
	
	public void subsFilingAction(String filter) {	
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

}