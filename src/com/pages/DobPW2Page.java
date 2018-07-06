package com.pages;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.util.Constants;

public class DobPW2Page extends TestBase {
/*	WebDriver driver;
	public DobPW2Page(WebDriver dr) {
		driver = dr;
	}*/

	public void workPermit(String pw2) {	
		if(!pw2.equals("")){
			String[] data = pw2.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** workPermit");
			filterJob(OR_PROPERTIES.getProperty("user_email"));
			test = rep.startTest("PW2");
			test.log(LogStatus.INFO, "workPermit PE2");
			click(Constants.pw2_work_permit_step);
			wait(2);
			waitVisible("//div[@class='ui-grid-viewport']");
			while(count(Constants.global_add_button) <= 0) {
				refreshPage();
				click(Constants.pw2_work_permit_step);
				wait(1);
			}
			if (count(Constants.trash_can_icon) > 0) {
				click(Constants.trash_can_icon);
				waitVisible(Constants.yes_button);
				clickButton("Yes");
				waitInvisible(Constants.yes_button);
			}
			clickAndWait(Constants.global_add_button, Constants.pw2_calendar_icon);
			wait(2);
				click(Constants.pw2_calendar_icon);
				click(Constants.pw2_calendar_active_day);
				email(data[0]);
				select(Constants.license_type_list, data[1]);
				select(Constants.license_type_list, OR_PROPERTIES.getProperty("user_licence_type"));
				radio(Constants.pw2_different_from_applicant_no);
		 		type(Constants.pw2_liability, "liability");
				click(Constants.pw2_liability_expiration_calendar);
				click(Constants.pw2_calendar_next_month_arrow);
				click(Constants.pw2_calendar_active_day);
		 		type(Constants.pw2_workers_compensation, "workers");
		 		click(Constants.pw2_workers_compensation_expiration_calendar);
				click(Constants.pw2_calendar_next_month_arrow);
				click(Constants.pw2_calendar_active_day);
				type(Constants.pw2_disability, "disability");
				click(Constants.pw2_disability_expiration_calendar);
				click(Constants.pw2_calendar_next_month_arrow);
				click(Constants.pw2_calendar_active_day);
				waitTime(1000);
		 		check(Constants.pw2_information_correct_and_complete);
		 		click(Constants.pw2_save_button);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_saved"));
				clickButton("OK");
				waitInvisible(Constants.ok_button);
			test = rep.startTest("PW2 upload docs");
			System.out.println(convertedTimestamp() + " **************** uploadDocuments PW2");
			scrollAllWayUp();
			for (int i = 1; i < 10; i++) {
				doubleclick(Constants.pw2_documents_tab);
				waitVisible("//span[text()='Document Status']");
				if (count(Constants.document_status_required) == 0)
					break;
				click(Constants.upload_document_icon);
				send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
				click(Constants.doc_upload_button);
				waitInvisible(Constants.doc_please_wait_message);
				waitVisible(Constants.doc_upload_succesfull_message);				
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				waitUntilISpinnersInvisible();
				waitForPageToLoad();	
		 		click(Constants.pw2_save_button);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_saved"));
				clickButton("OK");
			}
		}
		reportPass("workPermit");
	}
	public void workPermitPlumbing(String pw2) {	
		if(!pw2.equals("")){
//			String[] data = pw2.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** workPermitPlumbing");
			filterJob(user);
			click(Constants.pw2_work_permit_step);
			while(count(Constants.pw2_save_button) <= 0) {
				refreshPage();
				click(Constants.global_add_button);
				wait(2);
			}
			test = rep.startTest("PW2");
			test.log(LogStatus.INFO, "PE2 workPermit");
			click(Constants.pw2_calendar_icon);
			click(Constants.pw2_calendar_active_day);
			select("//select[@id='txtWPPermitType']", "Plumbing");
			email(OR_PROPERTIES.getProperty("mrctest003"));
			select(Constants.license_type_list, pw2_lic);
			select("//select[@id='txtPWAppbusiness']", "JCG INDUSTRIES INC");
			radio(Constants.pw2_different_from_applicant_no);
			radio("//input[@id='chkWPNotRequiredInsuranceTerms2']");
//			check(Constants.pw2_information_correct_and_complete);
			click(Constants.pw2_save_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			
			filterJob(OR_PROPERTIES.getProperty("mrctest003"));
			scrollAllWayUp();
			click(Constants.pw2_work_permit_step);
			doubleclick("//div[text()='Permit is not yet issued']");
			check(Constants.pw2_information_correct_and_complete);
			click(Constants.pw2_save_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			doubleclick(Constants.pw2_documents_tab);
			// Preparation for upload documents	
			reportPass("workPermitPlumbing");
		}
	}
	public void XuploadDocuments(String upload_file) {	
		if(!upload_file.equals("")){
			test = rep.startTest("PW2 upload docs");
			System.out.println(convertedTimestamp() + " **************** " + "PW2 uploadDocuments");
			scrollAllWayUp();
/*			if(CONFIG.getProperty("env").contains("443") || CONFIG.getProperty("env").contains("8085")) {
			doubleclick(Constants.pw2_documents_tab);
			}*/
			for (int i = 1; i < 10; i++) {
				waitVisible("//span[text()='Document Status']");
				if (count(Constants.document_status_required) == 0)
					break;
				click(Constants.upload_document_icon);
				send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
				click(Constants.doc_upload_button);
				waitInvisible(Constants.doc_please_wait_message);
				waitVisible(Constants.doc_upload_succesfull_message);				
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				
			}
/*			doubleclick(Constants.pw2_documents_tab);
			while (count(Constants.document_status_required) > 0) { 
//				type(Constants.document_status_filter, "required");
				wait(1);
				click(Constants.upload_document_icon);
				send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
				click(Constants.doc_upload_button);
				waitInvisible(Constants.doc_please_wait_message);
				waitVisible(Constants.doc_upload_succesfull_message);				
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
			}	*/
/*			for (int i=0; count(Constants.document_status_required) > 0; i++) {
				test.log(LogStatus.INFO, "Upload documents " +i);
//				if(CONFIG.getProperty("env").contains("8085"))
				doubleclick(Constants.pw2_documents_tab);
				doubleclick("(//i[@class='fa fa-upload'])[" +i+ "]");
				waitVisible(Constants.doc_browse_button);
				send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
				click(Constants.doc_upload_button);
				waitInvisible(Constants.doc_please_wait_message);
				waitVisible(Constants.doc_upload_succesfull_message);
				click(Constants.doc_document_uploaded_ok_button);
				waitInvisible(Constants.doc_document_uploaded_ok_button);
				waitInvisible(Constants.global_loading_spinner);
				waitUntilISpinnersInvisible();

			}*/
	 		click(Constants.pw2_save_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			if (upload_file.contains("File")) {
				click(Constants.pw2_file_button);
//				clickButton("File");
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_submitted_for_review"));
				clickButton("OK");
				waitInvisible(Constants.ok_button);
			}
			else
				click(Constants.cancel_button);
		}
		reportPass("uploadDocuments");
	}

}