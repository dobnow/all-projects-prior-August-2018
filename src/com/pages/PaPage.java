package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.util.Constants;

public class PaPage extends TestBase {

	public void selectWorkTypePa(String worktype) {
		if (!worktype.equals("")) {
			System.out.println(convertedTimestamp() + " **************** New Filing - selectWorkTypePa");
			loginToPortal(user);
			test = rep.startTest("selectWorkTypePa");
			click(Constants.job_filing_button);
			waitVisible("//span[@ng-show='!ElevatorsFilingWorktype']");
			if (count("//input[@ng-model='" + worktype + "FilingWorkType']") > 0)
				check("//input[@ng-model='" + worktype + "FilingWorkType']");
			click("//span[@ng-show='!ElevatorsFilingWorktype']");
			waitInvisible("//span[@ng-show='!ElevatorsFilingWorktype']");
			reportPass("selectWorkType");
		}
	}
	

	public void locationImfo(String address) {	
		if(!address.equals("")){
			System.out.println(convertedTimestamp() + " **************** locationImfo");
			test = rep.startTest("PW1");
			String[] data = address.split(" :: ");
			type(Constants.pw1_1_house_number, data[0]);
			type(Constants.pw1_1_street_name,data[1]);
			select(Constants.pw1_1_borough, data[2]);
			type(Constants.pw1_1_block, data[3]);
			type(Constants.pw1_1_lot, data[4]);
		}
	}

	public void applicantInfo(String user_info) {	
		if(!user_info.equals("")){
			String[] data = user_info.split(" :: ");
			test = rep.startTest("Applicant Info");
			email(data[0]);
			select("//select[@id='selLicenseType']", data[1]);
			wait(1);
			select(Constants.business_name_list, data[2]);
	 	}
	}

	//Work on Floor
	public void workOnFloors(String work_on_floors) {	
		if(!work_on_floors.equals("")){
			test = rep.startTest("Work On Floors");
			if(work_on_floors.contains(" :: ")) {
				String[] data = work_on_floors.split(" :: ");
				click(Constants.pw1_1_add_work_floors_button);
				select("(//select[@id='ddlCADescWork'])[last()]", data[0]);
				type(Constants.pw1_1_work_on_floors_floor_number_from, data[1]);
				type(Constants.pw1_1_work_on_floors_floor_number_to, data[2]);
				type("//input[@id='WFMaximumOccupancy']", "22");
				type(Constants.pw1_1_work_on_floors_description_of_work, convertedTimestamp());
				click(Constants.pw1_1_work_on_floors_add_button);
				wait(1);
				if(count("//input[@id='rdIrRegularFloorNumbering'][@value='false']") > 0) // PA only
					radio("//input[@id='rdIrRegularFloorNumbering'][@value='false']");
			} 
		}
	}
	 
	public void reviewtype(String type) {	
		if(!type.equals("")){
			select(Constants.pw1_4_filling_review_type_list, type);
	 	}
	}

	public void ownerinfo(String owner_info) {
		if (!owner_info.equals("")) {
			test = rep.startTest("Work On Floors");
			for (int i = 1; i < 100; i++) {
				if(count(Constants.party_to_renewpalce_assembly_yes) > 0)
					radio(Constants.party_to_renewpalce_assembly_yes);
/*				if(count("//select[@id='ddlPAOperation']") > 0)
					select("//select[@id='ddlPAOperation']", "Yes");*/
				select(Constants.ss_owner_type, "Partnership");
				radio("//input[@ng-model='PAFormObj.IsTheDeedHolderaNonProfitOrganization'][@value='true']");
				clear("//input[@id='txtDPEmail']");
				send("//input[@id='txtDPEmail']", OR_PROPERTIES.getProperty("owner_email"));
				wait(2);
				if (count("//strong[text()='" + OR_PROPERTIES.getProperty("owner_email") + "']") > 0) {
					doubleclick("//strong[text()='" + OR_PROPERTIES.getProperty("owner_email") + "']");
					wait(1);
					break;
				}
			}
		}
	}
	public void party(String party) {
		if (!party.equals("")) {
			String[] data = party.split(" :: ");
			test = rep.startTest("Work On Floors");
			for (int i = 1; i < 100; i++) {
				clear("(//input[@id='txtDPEmail'])[last()]");
				send("(//input[@id='txtDPEmail'])[last()]", data[0]);
				wait(2);
				if (count("//strong[text()='" + data[0] + "']") > 0) {
					doubleclick("//strong[text()='" + data[0] + "']");
					wait(1);
					break;
				}
			}
		}
	}
	public void saveGI(String save) {	
		if(!save.equals("")){
			test = rep.startTest("Save PW1");
			scrollAllWayUp();
			scrollToElement(Constants.save_button);
			click(Constants.save_button);
			wait(2);
			if(count(Constants.pw1_confirm_save_button) > 0)
				click(Constants.pw1_confirm_save_button);
			waitVisible60(Constants.ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "saveGI");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			wait(2);
			addToProps("job_number", text(Constants.el_job_label).substring(0, 10).trim());
	 	}
		reportPass("savePW1");
	}
	
	public void scopeOfWorkTpa(String save) {
		if (!save.equals("")) {
			System.out.println(convertedTimestamp() + " **************** scopeOfWorkTpa");
//			filterJob(user);
			test = rep.startTest("scopeOfWorkTpa");
			click("//a[@class='ng-binding'][@ng-click='changeCurrentPage(2);']");
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			waitUntilISpinnersInvisible();
/*			scrollDown();
			wait(2);
			System.out.println(count("//input[@id='rdEmergencyPowerorLighting2']"));
			System.out.println(count("//input[@name='rdEmergencyPowerorLighting'][@value='false']"));
			System.out.println(count("//input[@ng-model='PAFormObj.TPAObject.EmergencyPowerorLighting'][@value='false']"));
			radio("//input[@id='rdEmergencyPowerorLighting2']");*/

			type("//input[@ng-model='PAFormObj.TPAObject.FirstName']", "Event Sponsor Name");
			type("//input[@ng-model='PAFormObj.TPAObject.EmailAddress']", "mmazay@buildings.gov");
			type("//input[@ng-model='PAFormObj.TPAObject.Telephone']", "2223334444");
/*			type("//input[@ng-model='PAFormObj.TPAObject.FirstName']", "test");
			type("//input[@ng-model='PAFormObj.TPAObject.LastName']", "test");*/
			type("//input[@ng-model='PAFormObj.TPAObject.Address']", "345 test");
//			type("//input[@ng-model='PAFormObj.TPAObject.City']", "test");
			type("//input[@ng-model='PAFormObj.TPAObject.State']", "Event Sponsor State");
			type("//input[@ng-model='PAFormObj.TPAObject.Zip']", "12345");
			
			select("//select[@ng-model='CategoryLookUpDetails']", "Arcade");
			type("//input[@ng-model='PAFormObj.TPAObject.Name']", "Event Name");
			driver.findElement(By.xpath("//input[@id='outdooreventlocationCheck']")).click();
			
//			click("//input[@id='outdooreventlocationCheck']");
			
			type("//textarea[@id='txtEventDescription']", "Event Description");
			scrollDown();
			radio("//input[@ng-model='PAFormObj.TPAObject.FireGuardsPresent'][@value='false']");
			radio("//input[@ng-model='PAFormObj.TPAObject.TemporaryStructures'][@value='false']");
			radio("//input[@name='rdEmergencyPowerorLighting'][@value='false']");
			radio("//input[@ng-model='PAFormObj.TPAObject.Areyouprovidingparkingspaces'][@value='false']");
			radio("//input[@ng-model='PAFormObj.TPAObject.DoesthisrequireaFDNYopenflamepermit'][@value='false']");
			radio("//input[@ng-model='PAFormObj.TPAObject.ApplicationComplieswithBuildingcode'][@value='false']");
			radio("//input[@ng-model='PAFormObj.TPAObject.ArePortableToiletFacilitiesRequired'][@value='false']");
			radio("//input[@ng-model='PAFormObj.TPAObject.Includesstructuretheevent'][@value='false']");
//			radio("//input[@id='rdEmergencyPowerorLighting2']");
/*			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			waitUntilISpinnersInvisible();*/
//			scrollDown();
			wait(2);
//			click("//h4[@id='2'][text()='Temporary Place of Assembly Request Period']");
			click("//button[contains(@ng-click,'event,0)')]");
			click(Constants.pw2_calendar_active_day);
			click("//button[contains(@ng-click,'event,1)')]");
			click(Constants.pw2_calendar_next_month_arrow);
			click(Constants.pw2_calendar_next_month_arrow);
			click(Constants.pw2_calendar_next_month_arrow);
			click(Constants.pw2_calendar_next_month_arrow);
			click(Constants.pw2_calendar_next_month_arrow);
			click(Constants.pw2_calendar_active_day);
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
//			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			click("//span[text()='Add Event Dates']");
			wait(2);
			click("//button[contains(@ng-click,'event,2)')]");
			click(Constants.pw2_calendar_next_month_arrow);
			click(Constants.pw2_calendar_active_day);
			click("//button[contains(@ng-click,'event,3)')]");
			click(Constants.pw2_calendar_next_month_arrow);
			click(Constants.pw2_calendar_next_month_arrow);
			click(Constants.pw2_calendar_active_day);		
			select("//select[@id='ddlTimeFrom']", "7:00 AM");
			select("//select[@id='ddlTimeTo']", "5:00 PM");
			click("//span[text()='Save']");
			clickButton("OK");
						click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			waitUntilISpinnersInvisible();
		}
		reportPass("eventInfo");
	}
	public void scopeOfWorkPa(String save) {
		if (!save.equals("")) {
			System.out.println(convertedTimestamp() + " **************** scopeOfWorkPa");
//			filterJob(user);
			test = rep.startTest("scopeOfWorkPa");
			click("//a[@class='ng-binding'][@ng-click='changeCurrentPage(2);']");
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			type("//input[@ng-model='PAFormObj.PASpaceInformation.Nba1JobNoEstablishingPA']", JOB_NUMBER.getProperty("job_number"));	
			wait(2);
			radio("//input[@ng-model='PAFormObj.PASpaceInformation.IsTheJobnoPreBis'][@value='false']");
			type("//input[@ng-model='PAFormObj.PASpaceInformation.NameofPaEstablishment']", "1");
			radio("//input[@ng-model='PAFormObj.PASpaceInformation.FDNYOpenFlamePermitReq'][@value='false']");	
			
			click("(//i[@class='fa fa-edit'])[last()]");
		
			wait(1);
			waitVisible("//button[text()='Update']");
			radio("//input[@id='rdIspreBIS'][@value='false']");			
			select("//select[@id='ddlOccupancyDesignation']", "A-2");
			wait(1);			
			type("//input[@id='PANoOfPersons']", "100");
			wait(1);
			select("//select[@id='ddlDescofEvent']", "Cafeteria");
//			click("//button[text()='Update']");
			clickButton("Update");
			
			waitInvisible("//button[text()='Update']");
			clickButton("OK");
			scrollAllWayUp();
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
		reportPass("eventInfo");
	}
	
	public void techReport(String tech_report) {	
			if (!tech_report.equals("")) {
				String[] data = tech_report.split(" :: ");
				System.out.println(convertedTimestamp() + " **************** techReport");
//				filterJob(user);
				test = rep.startTest("techReport");
				click("//a[@class='ng-binding'][@ng-click='changeCurrentPage(3);']");
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				waitVisible("//span[text()='2. Applicant Information']");				
				radio("//input[@ng-model='ProgressInspectionsApplicant'][@value='true']");
/*				wait(51);
				
				if(count("//i[@class='fa fa-upload ng-scope']") > 0) {
					click("//i[@class='fa fa-upload ng-scope']");
					send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
					click(Constants.tr1_upload_button);
					waitInvisible(Constants.tr1_please_wait_message);
					waitVisible(Constants.tr1_upload_succesfull_message);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}*/
				for (int a = 1; a <= 5; a++) {
					wait(2);
					click("(//i[@class='fa fa-edit'])[last()]");
					waitVisible("//h4[text()='Progress Inspection Category']");
					email(data[1]);
					select(Constants.tr1_license_type, data[2]);
					if(text(Constants.tr1_license_type).contains(data[2]))
						break;
				}
				click(Constants.global_save_form_button);
				waitInvisible(Constants.global_save_form_button);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_updated"));
				clickButton("OK");
				waitInvisible(Constants.ok_button);
/*				if(count("//i[@class='fa fa-upload ng-scope']") > 0) {
					click("//i[@class='fa fa-upload ng-scope']");
					send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
					click(Constants.tr1_upload_button);
					waitInvisible(Constants.tr1_please_wait_message);
					waitVisible(Constants.tr1_upload_succesfull_message);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}*/
			}			
			reportPass("techReport");
		}	
	
	public void progressInspector(String tech_report) {
		if (!tech_report.equals("")) {
			String[] data = tech_report.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** progressInspector");
			for (int i = 1; i < 100; i++) {
				filterJob(data[1]);
				test = rep.startTest("progressInspector");
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				
				
				click("//a[@class='ng-binding'][@ng-click='changeCurrentPage(3);']");
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				waitVisible("//span[text()='2. Applicant Information']");				
				radio("//input[@ng-model='ProgressInspectionsApplicant'][@value='true']");
				wait(1);
				if(count("//i[@class='fa fa-upload ng-scope']") > 0) {
					click("//i[@class='fa fa-upload ng-scope']");
					send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
					click(Constants.tr1_upload_button);
					waitInvisible(Constants.tr1_please_wait_message);
					waitVisible(Constants.tr1_upload_succesfull_message);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}
				
				for (int a = 1; a <= 5; a++) {
					click("(//i[@class='fa fa-edit'])[last()]");
					waitVisible("//h4[text()='Progress Inspection Category']");
/*					email(OR_PROPERTIES.getProperty("progress_inspector_email"));
					select(Constants.tr1_license_type, OR_PROPERTIES.getProperty("progress_inspector_lisence"));*/
					check(Constants.tr1_i_take_responcibility);
					check(Constants.tr1_i_understand_my_failure_to_file);
					check(Constants.tr1_i_understand_and_agree);
					if (getElement(Constants.tr1_i_take_responcibility).isSelected()) {
						if (getElement(Constants.tr1_i_understand_my_failure_to_file).isSelected()) {
							if (getElement(Constants.tr1_i_understand_and_agree).isSelected())
								break;
						}
					} else
						click(Constants.global_cancel_button);
				}


				click(Constants.global_save_form_button);
				waitInvisible(Constants.global_save_form_button);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_updated"));
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				if (count(Constants.identified_yes_label) > 1)
					break;
			}
		}
		reportPass("progressInspector");
	}
	
	public void signatures(String signatures) {	
		if(!signatures.equals("")){
			System.out.println(convertedTimestamp() + " **************** applicant signature");
			filterJob(user);	
			test = rep.startTest("signatures");
			click("//a[@class='ng-binding'][@ng-click='changeCurrentPage(6);']");
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			waitVisible("//h3[contains(text(),'Applicant of Record')]");
			for (int a = 1; a <= 10; a++) {
				driver.findElement(By.xpath("//*[@id='ApplicantAuthorizationCheckPW1']")).click();
				wait(2);
				if(driver.findElement(By.xpath("//*[@id='ApplicantAuthorizationCheckPW1']")).isSelected())
					break;
			}
			scrollAllWayUp();
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
		reportPass("signatures");
	}
	
	public void owner(String owner) {	
		if(!owner.equals("")){
			System.out.println(convertedTimestamp() + " **************** owner signature");
			filterJob(owner);	
			test = rep.startTest("owner");
			click("//a[@class='ng-binding'][@ng-click='changeCurrentPage(6);']");
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			waitVisible("//h3[contains(text(),'Applicant of Record')]");
			for (int a = 1; a <= 10; a++) {
				driver.findElement(By.xpath("//*[@id='OwnerAuthorizationCheckPW1']")).click();
				wait(2);
				if(driver.findElement(By.xpath("//*[@id='OwnerAuthorizationCheckPW1']")).isSelected())
					break;
			}
			scrollAllWayUp();
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
		reportPass("signatures");
	}
	
	public void uploadDocuments(String upload_file) {
		if (!upload_file.equals("")) {
			System.out.println(convertedTimestamp() + " **************** uploadDocuments");
			filterJob(user);
			test = rep.startTest("Upload Documents");
			click("//a[@class='ng-binding'][@ng-click='changeCurrentPage(5);']");
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			while (count(Constants.upload_document_icon) < 1) {
				refreshPage();
				waitForPageToLoad();
				wait(3);
			}
			while (count(Constants.document_status_required) > 0) { 
				type(Constants.document_status_filter, "required");
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
				if (count(Constants.document_status_required) == 0) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
//					assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved");
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}
			}
		}
		reportPass("uploadDocuments");
	}
	
	public void previewToFile(String preview_to_file) {
		if(!preview_to_file.equals("")){
			System.out.println(convertedTimestamp() + " **************** PreviewToFile");
//			filterJob(user);
			test = rep.startTest("Preview To File");
			for (int i = 1; i <= 20; i++) {
				click(Constants.preview_resubmit_button);
				waitUntilISpinnersInvisible();
				wait(3);
				waitVisible(Constants.application_preview_label);
				waitVisible("//div[@class='hidden-xs col-md-2 pull-right']");				
				if (count("//*[contains(text(),'Getting Preview... 0%')]") > 0) { //	while (driver.getPageSource().contains("Getting Preview... 0%")) {
					click(Constants.return_to_filing_view);
					waitInvisible(Constants.return_to_filing_view);
					wait(1);
					click(Constants.preview_resubmit_button);
					waitUntilISpinnersInvisible();
					wait(2);
				}
				if (count("//span[@class='label pull-right portal-fonts ng-binding']") > 0)
					break;
			}
			for (int i = 1; i <= 50; i++) {
				click(Constants.click_go_next_button);
				wait(1);
				if (count(Constants.final_legal_contect_checkbox) > 0)
					break;
			}
			check(Constants.final_legal_contect_checkbox);
			click(Constants.file_button);
			waitInvisible(Constants.file_button);
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("filing_message"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			assertFilingStatus("Pending");
		}
		reportPass("previewToFile");
	}	
	

	
 
	public void crmTechnicalReport(String user_name,	String accept_tr) {
		if (!accept_tr.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** " + data[0] + " crmTechnicalReport");
			loginToCrm(data[0]);
			searchForJobCrm();
			waitForPageToLoad();
			waitUntilISpinnersInvisible();
			driver.switchTo().frame("contentIFrame0");
//			waitUntilElementVisible(Constants.label_job_filing, 30);
			for (int i=1; i < 20; i++) {
				click(Constants.job_filing_link);
				waitInvisible(Constants.job_filing_link);
				if (count(Constants.job_filing_link) < 1) 
					break;
			}	
			ifAlertExistAccept();
//			waitInvisible(Constants.job_filing_link);
			waitVisible(Constants.qa_admin_application_highlights_label);
			waitVisible(Constants.qa_admin_tr1_tab);
			for (int i = 1; i <= 20; i++) {
				click(Constants.qa_admin_tr1_tab);
				wait(5);
/*				if (count(Constants.public_assembly_emergency_lighting) > 0)
					break;*/				
				if (driver.findElement(By.xpath(Constants.public_assembly_emergency_lighting)).isDisplayed() == true)
					break;
				refreshPage();
				driver.switchTo().frame("contentIFrame0");
			}
			waitVisible(Constants.public_assembly_emergency_lighting);
//			actionClick(Constants.public_assembly_emergency_lighting);
			WebElement public_assembly_emergency_lighting = driver.findElement(By.xpath(Constants.public_assembly_emergency_lighting));
			new Actions(driver).contextClick(public_assembly_emergency_lighting).build().perform();
			wait(1);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			waitUntilElementVisible(Constants.qa_admin_progress_inspector_seal_signature, 30);
			viewAcceptDocs();
		}
	}
	
}