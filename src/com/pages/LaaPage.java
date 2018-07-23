package com.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import com.base.TestBase;
import com.util.Constants;

public class LaaPage extends TestBase {
	
	public void filterAndAction(String action) {
		String[] data = action.split(" :: ");
		test = rep.startTest("filterAndAction");
		for (int i = 1; i < 20; i++) {
			loginToPortal(data[0]);
			select("//select[@ng-model='grid.options.paginationPageSize']", "20");
			type("//span[text()='Filing Number']/following::input[@ng-model='colFilter.term']", "i");
			type("//span[text()='Filing Status']/following::input[@ng-model='colFilter.term']", data[1]);
			type("//span[text()='Payment Status']/following::input[@ng-model='colFilter.term']", data[2]);
			wait(1);
			click("(//select[@id='FilingAction'])[" + i + "]/following::option[text()='PAA']");
			click(Constants.yes_button);
			wait(2);
			if (count("//p[@id='desc'][contains(text(), 'PAA already in progress')]") > 0) {
				click(Constants.ok_button);	
				waitInvisible(Constants.ok_button);	
			}				
			else
				break;
		}
		waitInvisible(Constants.ok_button);
		waitInvisible(Constants.yes_button);
		waitUntilISpinnersInvisible();
		waitForPageToLoad();
		reportPass("filterAndAction");
	}
	
	public void laaFromEwn(String action) {
		loginToPortal(user);
		test = rep.startTest("laaFromEwn");
		click(Constants.ewn_tab);
		type("//span[text()='Filing Status']/following::input[@ng-model='colFilter.term']", "received");
		wait(1);
		select(Constants.laa_select_action, action);
		click(Constants.yes_button);
		waitInvisible(Constants.yes_button);
		waitUntilISpinnersInvisible();
		waitForPageToLoad();		
		reportPass("laaFromEwn");
	}
	
	public void pAa(String paa) {	
		if(!paa.equals("")){
			System.out.println(convertedTimestamp() + " **************** pAa");
			test = rep.startTest("pAa");
			type(Constants.proposed_work_summary, convertedTimestamp());
			scrollUp();
			wait(1);
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_has_been_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
//			addToProps("job_number", text(Constants.job_label).trim().substring(6, 15).trim());
			addToProps("job_number", text(Constants.el_job_label).substring(0, 10).trim());
		}
	}
	
	public void clickEWN(String user_info) {	
		if(!user_info.equals("")){
			String[] data = user_info.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** clickEWN");
			loginToPortal(data[1]);
			test = rep.startTest("clickEWN");			
			click(Constants.ewn_button);
			waitForPageToLoad();
			waitUntilISpinnersInvisible();
			
	 	}
	}

	public void selectWorkType(String user_info) {
		if (!user_info.equals("")) {
			String[] data = user_info.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** New Filing - selectWorkType");
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
	
	public void emergencyWorkNotification(String ewn) {	
		if(!ewn.equals("")){
			System.out.println(convertedTimestamp() + " **************** emergencyWorkNotification");
			test = rep.startTest("emergencyWorkNotification");
			radio(Constants.have_ewn);
			type(Constants.ewn, JOB_NUMBER.getProperty("ewn_number"));
			click(Constants.search_ewn);			
		}
	}
	
	public void locationImfo(String address) {	
		if(!address.equals("")){
			System.out.println(convertedTimestamp() + " **************** locationImfo");
			test = rep.startTest("locationImfo");
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
			wait(2);
			select("//select[@id='selLicenseType']", data[2]);
			wait(2);
			select(Constants.business_name_list, data[3]);
			waitForPageToLoad();
			waitUntilISpinnersInvisible();
	 	}
	}

	public void feeAssessment(String fee_assesment) {	
		if(!fee_assesment.equals("")){
			String[] data = fee_assesment.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** feeAssessment");
			test = rep.startTest("feeAssessment");
			waitForPageToLoad();
			waitUntilISpinnersInvisible();
			scrollAllWayDown();
			scrollAllWayDown();
			if(fee_assesment.contains("legalization")) {
				scrollToElement(Constants.laa_legalization_yes);
				radio(Constants.laa_legalization_yes);
				wait(1);
				radio("//input[@name='rdIsWorkPermitViolation'][@value='" +data[1]+ "']");
				if(count(Constants.violation_number) > 0)
					type(Constants.violation_number, "34778932");
			}
			else 
				radio(Constants.laa_legalization_no);
			select(Constants.laa_specify_building_type, "1 Family");
			if(fee_assesment.contains("Commercial"))
				select(Constants.laa_building_use, "Commercial");
			else
				select(Constants.laa_building_use, "Residential");
			type(Constants.laa_total_number_of_floors, "3");
			type(Constants.laa_total_construction_roof_area, "555");
			select(Constants.laa_category_type, "Category 1");
			type(Constants.laa_estimated_cost, "1111");		
			if(fee_assesment.contains("exempt"))
				check(Constants.laa_the_deed_holder_is);
			radio(Constants.the_scope_of_work_asbestos);			
	 	}
	}
	
	public void saveGI(String save) {	
		if(!save.equals("")){
			System.out.println(convertedTimestamp() + " **************** saveGI");
			test = rep.startTest("saveGI");
			scrollAllWayUp();
			scrollToElement(Constants.save_button);
			click(Constants.save_button);
			wait(2);
			if(count(Constants.adrress_confirmation) > 0)
				click(Constants.adrress_confirmation);
			waitVisible60(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("saved"));
//			assertNotification(TEXT_PROPERTIES.getProperty("job_has_been_saved"), "saveGI");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			wait(2);
			if(text(Constants.el_job_label).contains("EWN"))
				addToProps("ewn_number", text(Constants.el_job_label).trim().substring(0, 14));
			else				
				addToProps("job_number", text(Constants.el_job_label).substring(0, 10).trim());
	 	}
		reportPass("saveGI");
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
			wait(2);
			select(Constants.laa_item_category, data[3]);	
			wait(2);
			if(data[0].contains("BOILERSOIL")) {
				check(Constants.oil_piping);
				type(Constants.laa_item_quantity, "1");				
			}
			if(sow.contains("Water Piping")) {
				check(Constants.branch_water_filters);
				type(Constants.branch_water_filters_quantity, "1");				
			}
			if(sow.contains("Fixture")) {				
				check(Constants.whirlpooltub_commercial);
				type(Constants.whirlpooltub_quantity, "1");	
				if(count("//input[@id='rdAnswerText1']") > 0) 
					radio("//input[@id='rdAnswerText1']"); // 443 has extra radiobutton
				select(Constants.select_voltage, "110V");				
			}
			if(sow.contains("Gas Work")) {
				check(Constants.gas_sgut_off_valve);
				type(Constants.gas_sgut_off_valve_quantity, "1");
			}
			if(sow.contains("Equipment")) {
				check(Constants.auxilary_hose_cabinets);
				type(Constants.laa_item_quantity, "1");
				radio(Constants.have_associated_job_number_no);			
				radio(Constants.laa_offline_8_hours_no);
			}
			else if(sow.contains("Fire Suppression Work")) {
				check(Constants.sprinkler_heads);
				type(Constants.sprinkler_heads_quantity, "1");	
				radio(Constants.have_associated_job_number_no);			
				radio(Constants.laa_offline_8_hours_no);
			}
			waitForPageToLoad();
			waitUntilISpinnersInvisible();
			scrollUp();
			scrollAllWayUp();
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

	public void uploadDocuments(String upload_file) {
		if (!upload_file.equals("")) {
			System.out.println(convertedTimestamp() + " **************** uploadDocuments");
//			filterJob(user);
			test = rep.startTest("uploadDocuments");			
			click(Constants.documents);
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			scrollAllWayUp();
			while (count(Constants.upload_document_icon) < 1) {
				refreshPage();
				waitForPageToLoad();
				wait(3);
			}
			if(upload_file.contains("CCD1"))
				assertTextPresent(upload_file, "commercial");			
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
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("saved"));
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}
			}
		}
		reportPass("uploadDocuments");
	}
	
	public void signatures(String signatures) {	
		if(!signatures.equals("")){
			System.out.println(convertedTimestamp() + " **************** signatures");
//			filterJob(user);	
			test = rep.startTest("signatures");
			click(Constants.statements_signatures_tab);
			waitForPageToLoad();
			waitUntilISpinnersInvisible();
			scrollAllWayUp();
			for (int a = 1; a <= 10; a++) {
				wait(2);
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
//			assertNotification(TEXT_PROPERTIES.getProperty("job_has_been_saved"), "signatures");
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
		reportPass("signatures");
	}
	
	public void submitEwn(String signatures) {	
		if(!signatures.equals("")){
			System.out.println(convertedTimestamp() + " **************** submitEwn");
//			filterJob(user);	
			test = rep.startTest("submitEwn");
			click(Constants.preview_resubmit_button);
			waitForPageToLoad();
			waitUntilISpinnersInvisible();
			wait(2);
			waitVisible60(Constants.ok_button);
//			assertNotification(TEXT_PROPERTIES.getProperty("job_has_been_saved"), "signatures");
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("ewn_submitted"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
		reportPass("submitEwn");
	}
	
	public void previewToFile(String file) {
		if(!file.equals("")){
			System.out.println(convertedTimestamp() + " **************** PreviewToFile");
			filterJob(file);
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
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_has_been_submitted"));
//			assertNotification(TEXT_PROPERTIES.getProperty("job_has_been_submitted"), "previewToFile");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			assertFilingStatus("Permitted");
		}
		reportPass("previewToFile");
	}	
	
	public void cityPay(String pay_now) {
		if (!pay_now.equals("")) {
			String[] data = pay_now.split(" :: ");
			if (count(Constants.pay_now_button_disabled) == 0) {
				System.out.println(convertedTimestamp() + " **************** " + "PayNowTest");
				String parentWindowContact = driver.getWindowHandle();
				for (int i = 1; i < 20; i++) {
					wait(2);
					if (pay_now.contains("Elevator")) { // ELEVATOR
						// DO NOTHING
					} 
					else
						filterJob(data[0]);
					test = rep.startTest("City Pay");
					if (pay_now.contains("Elevator")) { // ELEVATOR
						clickAndWait("//span[text()='Pay Now']", "//button[text()='Yes']");
//						click("//span[text()='Pay Now']");
						clickButton("Yes");
						waitInvisible("//button[text()='Yes']");
					} else {
						clickAndWait(Constants.pay_now_button, Constants.pay_now_confirm_button);
//						click(Constants.pay_now_button); // REST OF WORK TYPES
						waitUntilISpinnersInvisible();
						wait(3);
						waitVisible60(Constants.pay_now_confirm_button);
						doubleclick(Constants.pay_now_confirm_button);
//						clickAndWait(Constants.pay_now_confirm_button, "//b[contains(text(),'Please do not click Back')]");
						waitInvisible(Constants.pay_now_confirm_button);
					}
					wait(5);
					if ((driver.getWindowHandles().size()) > 1) {
						// driver.close();
						wait(1);
						break;
					}
				}
				for (int i = 1; i < 20; i++) {
					
/*					Set<String> handleswindow = driver.getWindowHandles();
					for (String windowHandle : handleswindow) {
						wait(1);
						driver.switchTo().window(windowHandle);
						driver.manage().window().maximize();
					}*/
					
					
					
					Set<String> handles = driver.getWindowHandles();
					Iterator<String> itr = handles.iterator();
					String newWindow = itr.next();
					driver.switchTo().window(newWindow);
					driver.manage().window().maximize();

					Set<String> handleswindow = driver.getWindowHandles();
					for (String windowHandle : handleswindow) {
						wait(1);
						driver.switchTo().window(windowHandle);
						driver.manage().window().maximize();
					}
					if (!driver.getTitle().equals("Certificate Error: Navigation Blocked")) {
						
						System.out.println(" You are in the wrong window");
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().defaultContent();
						driver.switchTo().window(tabs.get(0));
						driver.switchTo().window(tabs.get(1));
						
						
						
					if (count("//a[@id='overridelink']") > 0)
						break;
					}
/*						System.out.println(" You are in the wrong window");
					if (count("//a[@id='overridelink']") > 0)
						break;*/
				}
				while (count("//a[@id='overridelink']") > 0) {
					driver.navigate().to("javascript:document.getElementById('overridelink').click()");
					wait(5);
					if (count("//a[@name='overridelink']") == 0)
						break;
					refreshPage();
				}
				waitVisible60(Constants.pay_continue_button);
				if (pay_now.contains("credit")) {
//					click("//a[@title='Pay by Credit Card']"); 
					clickAndWait("//a[@title='Pay by Credit Card']", "//p[@class='intro'][contains(.,'charged a service fee')]");
					
//					waitInvisible("//p[@class='intro'][contains(.,'pay by electronic check')]");
					waitVisible("//p[@class='intro'][contains(.,'Credit and debit card payments')]");
					type(Constants.pay_first_name_cc, "Bob");
					type(Constants.pay_last_name_cc, "Smith");
					type(Constants.pay_address_cc, "888 5 Ave");
					type(Constants.pay_city_cc, "New York");
					type(Constants.pay_zip_cc, "10021");
					type(Constants.pay_phone_cc, "2125558888");
					type(Constants.pay_email_cc, "mmazay@buildings.nyc.gov");
					type(Constants.pay_email_confirm_cc, "mmazay@buildings.nyc.gov");
					click(Constants.pay_continue_button_cc);
					waitInvisible60(Constants.pay_continue_button_cc);
					click(Constants.pay_next_button);
					type(Constants.pay_name_on_card, "Bob Smith");
					type(Constants.pay_card_number, "4111111111111111");
					select(Constants.pay_exp_month, "01");
					select(Constants.pay_exp_year, "2020");
					type(Constants.pay_cvv, "333");
				} else {
					type(Constants.pay_first_name, "Bob");
					type(Constants.pay_last_name, "Smith");
					type(Constants.pay_address, "888 5 Ave");
					type(Constants.pay_city, "New York");
					type(Constants.pay_zip, "10021");
					type(Constants.pay_phone, "2125558888");
					type(Constants.pay_email, "mmazay@buildings.nyc.gov");
					type(Constants.pay_email_confirm, "mmazay@buildings.nyc.gov");
					click(Constants.pay_continue_button_ec);
					waitInvisible60(Constants.pay_continue_button_ec);
					click(Constants.pay_next_button);
					type(Constants.pay_name_on_account, "Bob Smith");
					type(Constants.account_number, "123456789");
					type(Constants.account_number_confirm, "123456789");
					type(Constants.aba_routing_number, "021000089");
				}
				click(Constants.pay_next_button);
				waitInvisible60(Constants.pay_next_button);
				click(Constants.pay_now_button_final);
				waitInvisible60(Constants.pay_now_button_final);
				
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
				
				assertTextPresent("Receipt Details", "Receipt Details");
				driver.close();
				wait(2);
				setConfigBrowser("Chrome");
				driver.switchTo().window(parentWindowContact);
				waitVisible(Constants.ok_button);
				clickButton("OK");
				waitInvisible(Constants.ok_button);
//				driver.close();
			}
		}
		successMessage("cityPay");
	}
	
 
	
	
}