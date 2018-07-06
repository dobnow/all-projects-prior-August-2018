package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.TestBase;
import com.util.Constants;

public class DobAHVPage extends TestBase {
	WebDriver driver;
	public DobAHVPage(WebDriver dr) {
		driver = dr;
	}
	
// Location Info	
	public void antennaAHV(String ahv) {	
		if(!ahv.equals("")){
			System.out.println(convertedTimestamp() + " **************** " + "Antenna AHV");
/*			loginToPortal(OR_PROPERTIES.getProperty("user_email"));
			filterJob(OR_PROPERTIES.getProperty("user_email"));	*/	
			test = rep.startTest("AHV");
			type(Constants.ahv_last_name, "Pedro");
			type(Constants.ahv_first_name, "Don");
			type(Constants.ahv_mobile, "2123334444");
			type(Constants.ahv_email, OR_PROPERTIES.getProperty("user_email"));
//			scrollDown();
			radio(Constants.ahv_residence_within_200_feet_no);
			radio(Constants.ahv_residence_within_200_feet_no);
			radio(Constants.ahv_all_work_done_within_enclosed_building);
			radio(Constants.ahv_work_involve_full_partial_demolition_no);
			radio(Constants.ahv_work_involve_crane_use_no);
			select(Constants.ahv_request_approval_reason, "Debris Removal");
/*			click(Constants.ahv_request_approval_reason);
			click(Constants.ahv_reason_debris_removal);*/
			radio(Constants.ahv_application_fee_exempt_yes);
			select(Constants.ahv_exempt_type, "ACRIS Report");
	 		type(Constants.ahv_liability, "liability");
			click(Constants.pw2_liability_expiration_calendar);
			click(Constants.pw2_calendar_next_month_arrow);
			waitUntilElementVisible(Constants.pw2_calendar_active_day, 30);
			click(Constants.pw2_calendar_active_day);
	 		type(Constants.ahv_worker_comp, "workers");
			click(Constants.pw2_workers_compensation_expiration_calendar);
			click(Constants.pw2_calendar_next_month_arrow);
			waitUntilElementVisible(Constants.pw2_calendar_active_day, 30);
			click(Constants.pw2_calendar_active_day);
	 		type(Constants.ahv_disability, "disability");
			click(Constants.pw2_disability_expiration_calendar);
			click(Constants.pw2_calendar_next_month_arrow);
			waitUntilElementVisible(Constants.pw2_calendar_active_day, 30);
			click(Constants.pw2_calendar_active_day);

			type(Constants.ahv_from0, "11:00 PM");
			type(Constants.ahv_from1, "11:00 PM");
			type(Constants.ahv_from2, "11:00 PM");
			type(Constants.ahv_from3, "11:00 PM");
			type(Constants.ahv_from4, "11:00 PM");
			type(Constants.ahv_from5, "11:00 PM");
			type(Constants.ahv_from6, "11:00 PM");
			type(Constants.ahv_to0, "06:00 AM");
			type(Constants.ahv_to1, "06:00 AM");
			type(Constants.ahv_to2, "06:00 AM");
			type(Constants.ahv_to3, "06:00 AM");
			type(Constants.ahv_to4, "06:00 AM");
			type(Constants.ahv_to5, "06:00 AM");
			type(Constants.ahv_to6, "06:00 AM");
			type(Constants.ahv_description_of_work, "AHV description " +convertedTimestamp());
			check(Constants.ahv_i_understand_and_agree);
			for(int a = 0; a <= 25; a++) {
				driver.findElements(By.xpath("//input[@type='checkbox'][contains(@value,'/')]")).get(a).click();
				click(Constants.global_save_form_button);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				if(count(Constants.notification) > 0) {
					if(text(Constants.notification).contains("Following date times has conflicts")) {
						clickButton("OK");
						waitInvisible(Constants.ok_button);
						driver.findElements(By.xpath("//input[@type='checkbox'][contains(@value,'/')]")).get(a).click();
					} else
						break;
				}
			}
//			check("//input[@value='" + text("//span[@id='txt15']") + "']");
			assertNotification(TEXT_PROPERTIES.getProperty("saved_successfully"), "saved_successfully ahv");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			addToProps("ahv_number", text("//span[@class='segoeUILight visible-lg-inline visible-md-inline']"));
// UPLOAD DOCS			
			int number_of_uploads = driver.findElements(By.xpath(Constants.upload_document_icon)).size();
			for(int i = 1; i <= number_of_uploads; i++) {
				String document_xpath = Constants.doc_upload_xpath_part1 + i + Constants.doc_upload_xpath_part2;
				click(document_xpath);
				send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
				click(Constants.doc_upload_button);
				waitInvisible(Constants.doc_please_wait_message);
				waitVisible(Constants.doc_upload_succesfull_message);
				click(Constants.doc_document_uploaded_ok_button);
				waitUntilISpinnersInvisible();
			}
		}
		click(Constants.ahv_submit_button);
		
		waitUntilISpinnersInvisible();
		waitVisible(Constants.global_notification_ok_button);
		assertNotification(TEXT_PROPERTIES.getProperty("ahv_permit_applied_successfully"), "ahv_permit_applied_successfully");
		click(Constants.global_notification_ok_button);
		waitInvisible(Constants.global_notification_ok_button);

	}
}