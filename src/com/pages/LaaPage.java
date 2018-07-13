package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.util.Constants;

public class LaaPage extends TestBase {

	public void selectWorkType(String user_info) {
		if (!user_info.equals("")) {
			String[] data = user_info.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** New Filing - selectWorkTypePa");
			loginToPortal(data[1]);
			test = rep.startTest("selectWorkType");
			click(Constants.job_filing_button);
			waitVisible("//h4[text()='Job filing includes:']");
			waitVisible("//span[text()='Submit']");
/*			System.out.println(count("//input[@ng-model='" + data[0] + "FilingWorktype']"));
			System.out.println(count("//input[@ng-model='LaaFilingWorktype']"));
			System.out.println(count("//input[@ng-model='" +data[0]+"FilingWorktype']"));*/
			check("//input[@ng-model='" +data[0]+"FilingWorktype']");
//			click("//input[@ng-model='" + data[0] + "FilingWorkType']");
			click("//span[text()='Submit']");
			waitInvisible("//span[text()='Submit']");
		}
		reportPass("selectWorkType");
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
			type(Constants.proposed_work_summary, convertedTimestamp());			
		}
	}

	public void applicantInfo(String user_info) {	
		if(!user_info.equals("")){
			String[] data = user_info.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** applicantInfo");
			test = rep.startTest("Applicant Info");
			email(data[1]);
			select("//select[@id='selLicenseType']", data[2]);
			wait(1);
			select(Constants.business_name_list, data[3]);
			waitForPageToLoad();
			waitUntilISpinnersInvisible();
	 	}
	}

	public void feeAssessment(String fee_assesment) {	
		if(!fee_assesment.equals("")){
			scrollDown();
			scrollDown();
			if(fee_assesment.contains("legalization"))
				radio(Constants.laa_legalization_yes);
			else
				radio(Constants.laa_legalization_no);
			select(Constants.laa_specify_building_type, "1 Family");
			select(Constants.laa_building_use, "Residential");
			type(Constants.laa_total_number_of_floors, "3");
			type(Constants.laa_total_construction_roof_area, "555");
			select(Constants.laa_category_type, "Category 1");
			type(Constants.laa_estimated_cost, "1111");			
			check(Constants.laa_the_deed_holder_is);
			radio(Constants.the_scope_of_work_asbestos);			
	 	}
	}
	
	public void saveGI(String save) {	
		if(!save.equals("")){
			test = rep.startTest("Save PW1");
			scrollAllWayUp();
			scrollToElement(Constants.save_button);
			click(Constants.save_button);
			wait(2);
			if(count(Constants.adrress_confirmation) > 0)
				click(Constants.adrress_confirmation);
			waitVisible60(Constants.ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "saveForm savePW1");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			wait(2);
			addToProps("job_number", text(Constants.el_job_label).substring(0, 10).trim());
	 	}
		reportPass("savePW1");
	}
	
	public void scopeOfWork(String sow) {
		if (!sow.equals("")) {			
			String[] data = sow.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** scopeOfWork");
//			filterJob(data[0]);
			test = rep.startTest("scopeOfWork");
			click(Constants.scope_of_work_tab);
			waitForPageToLoad();
			waitUntilISpinnersInvisible();
			click(Constants.add_scope_of_work);
			select(Constants.laa_limited_alteration_scope, data[1]);
			select(Constants.laa_filing_includes, data[2]);
			wait(1);
			select(Constants.laa_item_category, data[3]);			
			if(data[0].contains("BOILERSOIL")) {
				check(Constants.oil_piping);
				type(Constants.laa_item_quantity, "1");				
			}
			else if(data[0].contains("BOILERPLUMBER")) {
				check(Constants.gas_sgut_off_valve);
				type(Constants.gas_sgut_off_valve_quantity, "1");
				check(Constants.gas_light);
				type(Constants.gas_light_quantity, "1");
				radio(Constants.gas_light_additional_meters);			
				check(Constants.gas_oil_burner_pilot);
				type(Constants.gas_oil_burner_pilot_quantity, "1");				
				radio(Constants.gas_oil_burner_pilot_additional_meters);			
				check(Constants.gas_for_cooking);
				type(Constants.gas_for_cooking_quantity, "1");
				radio(Constants.for_sro_restricted);			
			}
			else {
				check(Constants.auxilary_hose_cabinets);
				type(Constants.laa_item_quantity, "1");
				radio(Constants.have_associated_job_number_no);			
				radio(Constants.laa_offline_8_hours_no);
			}
//			type(Constants.laa_item_quantity, "1");
			click(Constants.save_scope_of_work);
			clickButton("OK");
			waitForPageToLoad();
			waitUntilISpinnersInvisible();
			scrollDown();
			waitUntilISpinnersInvisible();
			if(count(Constants.add_appliance_data) > 0) {
				click(Constants.add_appliance_data);
				select(Constants.floor_location, "Pit");
				type(Constants.total_number_of_appliances, "2");
				type(Constants.manyfacturer_name, "BMW");
				select(Constants.listing_agency_name, "Other");
				type(Constants.certification_number, "3333333");
				type(Constants.model_number, "4444");
				type(Constants.input_btu, "555");
				click(Constants.save_scope_of_work);			
				clickButton("OK");
				waitUntilISpinnersInvisible();
				waitInvisible(Constants.ok_button);		
			}	
		}
		reportPass("scopeOfWork");
	}

	public void signatures(String signatures) {	
		if(!signatures.equals("")){
			System.out.println(convertedTimestamp() + " **************** signatures");
//			filterJob(user);	
			test = rep.startTest("signatures");
			click(Constants.statements_signatures_tab);
			waitForPageToLoad();
			waitUntilISpinnersInvisible();
			
			for (int a = 1; a <= 10; a++) {
				driver.findElement(By.xpath(Constants.i_understand_and_agree)).click();
				wait(2);
				if(driver.findElement(By.xpath(Constants.i_understand_and_agree)).isSelected())
					break;
			}
			click(Constants.save_button);
			wait(2);
			if(count(Constants.adrress_confirmation) > 0)
				click(Constants.adrress_confirmation);
			waitVisible60(Constants.ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "saveForm savePW1");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
		reportPass("signatures");
	}
	
	public void uploadDocuments(String upload_file) {
		if (!upload_file.equals("")) {
			System.out.println(convertedTimestamp() + " **************** uploadDocuments");
//			filterJob(user);
			test = rep.startTest("uploadDocuments");			
			click(Constants.documents);
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			while (count(Constants.upload_document_icon) < 1) {
				refreshPage();
				waitForPageToLoad();
				wait(3);
			}
			while (count(Constants.document_status_required) > 0) { 
				type(Constants.document_status_field, "required");
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
	

	
 
	
	
}