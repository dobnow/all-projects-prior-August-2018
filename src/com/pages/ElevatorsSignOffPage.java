package com.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.base.TestBase;
import com.util.Constants;

public class ElevatorsSignOffPage extends TestBase {

	// Device Info
	public void inspectingAgencyinfo(String agency_info) {
		if (!agency_info.equals("")) {
			System.out.println(convertedTimestamp() + " **************** inspectingAgencyinfo");
/*			while (count(Constants.found_job_part_one +JOB_NUMBER.getProperty("job_number") +Constants.found_job_part_two) < 1) {
				loginToPortal(OR_PROPERTIES.getProperty("elevator_applicant_email"));
				click(Constants.my_sign_off_requests_tab);
				type(Constants.job_number_filter, JOB_NUMBER.getProperty("job_number").trim());
			}
			
			click(Constants.click_to_view_icon);
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
			waitUntilISpinnersInvisible();
			scrollAllWayUp();*/
			
			
			
			test = rep.startTest("Inspecting Agency Info");
			String[] data = agency_info.split(" :: ");
			for (int i = 1; i <= 20; i++) {
				email(OR_PROPERTIES.getProperty("elevator_applicant_email"));
				select(Constants.license_type_list, data[0]);
				radio(Constants.did_agency_director_perform_inspection + data[1] + Constants.close_xpath);
				if (count(Constants.completed_checkmark) >= 1) break;
			}
			click(Constants.save_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification,TEXT_PROPERTIES.getProperty("sign_off_saved"));
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
		}
	}
	
	public void testInfo(String sign_off_info) {
		if (!sign_off_info.equals("")) {
			System.out.println(convertedTimestamp() + " **************** insuranceFeeInfo");
			click(Constants.test_information_tab);
			click(Constants.sign_of_calendar_icon);
			DateFormat dateFormat = new SimpleDateFormat("dd");
			timestamp = dateFormat.format(Calendar.getInstance().getTime());
			click(Constants.today_date);
			wait(1);
			click(Constants.satisfactory_slider);
			wait(2);
			click(Constants.save_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification,TEXT_PROPERTIES.getProperty("sign_off_saved"));
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
		}
	}
	
	public void signatures(String sign_off_info) {
		if (!sign_off_info.equals("")) {
			
/*			while (count(Constants.found_job_part_one +JOB_NUMBER.getProperty("job_number") +Constants.found_job_part_two) < 1) {
				loginToPortal(OR_PROPERTIES.getProperty("elevator_applicant_email"));
				click(Constants.my_sign_off_requests_tab);
				type(Constants.job_number_filter, JOB_NUMBER.getProperty("job_number").trim());
			}
			click(Constants.click_to_view_icon);
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
			waitUntilISpinnersInvisible();
			scrollAllWayUp();*/
			
			System.out.println(convertedTimestamp() + " **************** Signatures");
			test = rep.startTest("Signatures");
			click(Constants.statements_tab);

			wait(2);
			scrollToElement(Constants.owner_sign_elv);
			check(Constants.owner_sign_elv);
			wait(1);
			click(Constants.save_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification,TEXT_PROPERTIES.getProperty("sign_off_saved"));
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
			
			scrollToElement(Constants.inspecting_director_sign_elv);
			while(!getElement(Constants.inspecting_director_sign_elv).isSelected()) {
				wait(1);
				check(Constants.inspecting_director_sign_elv);
			}
//				check(Constants.inspecting_director_sign_elv);
				
				click(Constants.save_button);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification,TEXT_PROPERTIES.getProperty("sign_off_saved"));
				click(Constants.ok_button);
				waitInvisible(Constants.ok_button);	
		}
	}
	
	public void submit(String sign_off_info) {
		if (!sign_off_info.equals("")) {
			System.out.println(convertedTimestamp() + " **************** Submit");
			test = rep.startTest("Submit");
			click(Constants.preview_resubmit_button);
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification,TEXT_PROPERTIES.getProperty("sign_off_submitted"));
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
		}
	}
	
	
	
	
	
	
}