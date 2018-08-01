package com.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.util.Constants;

public class ElevatorsPage extends TestBase {

//	public String pagesource = driver.getPageSource();

	public void generalInfo(String address) {
		if (!address.equals("")) {
			String[] data = address.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** generalInfo");
			test = rep.startTest("General Info");
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			type(Constants.pw1_1_house_number, data[0]);
			type(Constants.pw1_1_street_name, data[1]);
			select(Constants.pw1_1_borough, data[2]);
			type(Constants.pw1_1_block, data[3]);
			type(Constants.pw1_1_lot, data[4]);
			select(Constants.building_code, "2014 ");
			email(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			select(Constants.pw1_2_license_type, OR_PROPERTIES.getProperty("elevator_applicant_lisence_type"));
			select(Constants.select_business, "DIR BUS NAME");
			for (int i = 1; i < 100; i++) {
				clear(Constants.designer_email);
				send(Constants.designer_email, user.toUpperCase());
				wait(1);
				if (count(Constants.email_xpath_part1+user.toUpperCase()+Constants.close_xpath) > 0) {
					click(Constants.email_xpath_part1+user.toUpperCase()+Constants.close_xpath);
					break;
				}
			}
			keyPressTab(Constants.designer_email);
			select(Constants.designer_license_type, OR_PROPERTIES.getProperty("professional_engineer"));
			for (int i = 1; i < 100; i++) {
				clear(Constants.owner_email);
				send(Constants.owner_email, user.toUpperCase());
				wait(1);
				if (count(Constants.email_xpath_part1+user.toUpperCase()
						+ Constants.email_xpath_part2) > 0) {
					click(Constants.email_xpath_part1+user.toUpperCase()
							+ Constants.email_xpath_part2);
					break;
				}
			}
			keyPressTab(Constants.owner_email);
			select(Constants.owner_license_type, OR_PROPERTIES.getProperty("private_tax_exempt"));
			radio("//input[@name='rdScopeOfWorkRegualtionSnycDep'][@value='1']");
			scrollAllWayUp();
			scrollToElement(Constants.global_save_step_button);
			click(Constants.global_save_step_button);
			if (count(Constants.pw1_confirm_save_button) > 0)
				click(Constants.pw1_confirm_save_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification,TEXT_PROPERTIES.getProperty("applications_created_successfully"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			addToProps("job_number", text(Constants.elevator_job_label).substring(1, 10).trim());
			type(Constants.electrical_permit_number, "M368223");
			wait(2);
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
	}

	public void searchAddDevice(String address) {
		if (!address.equals("")) {
			System.out.println(convertedTimestamp() + " **************** " + "generalInfoAlteration");
			test = rep.startTest("General Info generalInfoAlteration");
			String[] data = address.split(" :: ");
			radio(Constants.search_by_address);
			click(Constants.search_and_add_button);
			waitVisible(Constants.ok_button);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			for (int i = 1; i < 100; i++) {
				for (int a = 1; a < 100; a++) {
					String new_address = String.valueOf(randomNumberOf(1777));
					clear(Constants.search_by_house);
					type(Constants.search_by_house, new_address);
					clear(Constants.search_by_street);
					type(Constants.search_by_street, data[1]);
					select(Constants.search_by_borough, data[2]);
					wait(1);
					click(Constants.search_and_add_button);
					wait(3);
					if (count(Constants.ok_button) > 0)
						clickButton("OK");
					if (count("//p[@id='desc'][contains(.,'Cannot find BIN for the address entered.')]") > 0)
						clickButton("OK");
					if (count(Constants.device_list_checkbox) > 0)
						break;
				}
				for (int a = 1; a < count(Constants.device_list_checkbox); a++) {
					String circle_xpath = "(//button[contains(@class,'btn-circle2')])[" + a + "]";
					String checkbox_xpath = "(//input[@ng-model='device.IsSelected'])[" + a + "]";
					///                                                                                 copyValueOf(data, offset, count)
					
					//button[@class='btn-circle2 pull-right devActive']
					//button class="btn-circle2 pull-right devRemoved
					
//					System.out.println(count(circle_xpath));
//					click(checkbox_xpath);
					
//					System.out.println(getElement(circle_xpath).getCssValue("background-color"));
					if (getElement(circle_xpath).getCssValue("background-color").contains("rgba(98, 152, 40, 1)"))
						check(checkbox_xpath);
					
					if (count("//p[@id='desc'][contains(.,'You cannot select this device')]") > 0)
						clickButton("OK");
					wait(1);
					if (count(Constants.cannot_use_device_message) > 0)
						clickButton("OK");
					if (count(Constants.add_device_button_disabled) > 0) // ADD button still disabled
						wait(2);
					if (count(Constants.cannot_use_device_message) > 0)
						clickButton("OK");
					if (count(Constants.add_device_button_disabled) == 0)
						click(Constants.add_device_button);
					wait(1);
					if (count(Constants.device_added_message) > 0)
						break;
				}
				wait(2);
				if (count(Constants.device_added_message) > 0) {
					clickButton("OK");
					waitInvisible(Constants.ok_button);

					break;
				} else
					click(Constants.global_cancel_button);
			}
			select(Constants.building_code, "2014 ");
			email(user);
			select(Constants.pw1_2_license_type, OR_PROPERTIES.getProperty("elevator_applicant_lisence_type"));
			select(Constants.select_business, "DIR BUS NAME");
			for (int i = 1; i < 100; i++) {
				send(Constants.designer_email, user.toUpperCase());
				wait(1);
				if (count(Constants.email_xpath_part1+user.toUpperCase()
						+ Constants.email_xpath_part2) > 0) {
					click(Constants.email_xpath_part1+user.toUpperCase()+Constants.close_xpath);
					wait(1);
					break;
				}
			}
			select(Constants.designer_license_type, OR_PROPERTIES.getProperty("professional_engineer"));
			for (int i = 1; i < 100; i++) {
				send(Constants.owner_email, OR_PROPERTIES.getProperty("elevator_applicant_email").toUpperCase());
				wait(1);
				if (count(Constants.email_xpath_part1
						+ OR_PROPERTIES.getProperty("elevator_applicant_email").toUpperCase()
						+ Constants.email_xpath_part2) > 0) {
					click(Constants.email_xpath_part1 + OR_PROPERTIES.getProperty("elevator_applicant_email").toUpperCase() + Constants.email_xpath_part2);
					wait(1);
					break;
				}
			}
			select(Constants.owner_license_type, OR_PROPERTIES.getProperty("private_tax_exempt"));
			radio("//input[@name='rdScopeOfWorkRegualtionSnycDep'][@value='1']");
			scrollAllWayUp();
			scrollToElement(Constants.global_save_step_button);
			click(Constants.global_save_step_button);
			if (count(Constants.pw1_confirm_save_button) > 0)
				click(Constants.pw1_confirm_save_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification,
					TEXT_PROPERTIES.getProperty("applications_created_successfully"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			addToProps("job_number", text(Constants.elevator_job_label).substring(1, 10).trim());
			// type(Constants.electrical_permit_number, "M368223");
			wait(2);
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
	}

	// Preview to File
	public void previewToFile(String preview_to_file) {
		if (!preview_to_file.equals("")) {
			System.out.println(convertedTimestamp() + " **************** Preview ToFile");
//			filterJob(user);
			test = rep.startTest("Preview To File");
			for (int i = 1; i <= 20; i++) {
				click(Constants.preview_resubmit_button);
				waitUntilISpinnersInvisible();
				wait(2);
				if (count("//label[@id='lblUsrMessage'][text()='Getting Preview... 0%']") > 0) {
					click(Constants.global_cancel_button);
					waitInvisible(Constants.global_cancel_button);
					wait(1);
					click(Constants.preview_resubmit_button);
					waitUntilISpinnersInvisible();
					wait(2);
				}
				if (count(Constants.number_of_pages_label) > 0)
					break;
			}
			for (int a = 1; a <= 50; a++) {
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
			/*
			 * assertFilingStatus(TEXT_PROPERTIES.getProperty("pending_pe_assignment"));
			 * assertFilingStatus(preview_to_file);
			 */
			assertFilingStatus(TEXT_PROPERTIES.getProperty(preview_to_file));
		}
	}
	
	// ######################################################################################################################           Device Info
	public void deviceInfo(String device_info) {
		if (!device_info.equals("")) {
			String[] data = device_info.split(" :: ");
			System.out.println(convertedTimestamp() +" **************** deviceInfo");
//			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			test = rep.startTest("deviceInfo");
			clickAndWait(Constants.add_new_device_link, Constants.yes_button);
//			waitVisible(Constants.yes_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("device_added"));
			click(Constants.yes_button);
			waitInvisible(Constants.yes_button);
			for (int i = 1; i <= 20; i++) {
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				if (device_info.contains("Accessibility Lift")) { // Accessibility Lift			
					type(Constants.access_lyft_numbers, data[1]);
					select(Constants.accessibility_lift, data[2]);
					wait(1);
					select(Constants.accessibility_lift_type, data[3]);				
					radio(Constants.conjunction_with_mta + "[@value='" +data[4]+ "']");
					radio(Constants.private_residence_lyft + "[@value='" +data[5]+ "']");	
				}
				else if (device_info.contains("Conveyor")) // Conveyor			
					select(Constants.conveyor_type, data[2]);				
				else if (device_info.contains("Dumbwaiter")) // Dumbwaiter			
					radio(Constants.private_residence_no);		
				else if (device_info.contains("Escalator") || device_info.contains("Moving Walk"))  { // Escalator / Moving Walk					
					radio(Constants.in_conjunction_with_mta);	
					type(Constants.device_job_description, convertedTimestamp());
					if (count(Constants.completed_checkmark) >= 1) {
						click(Constants.global_save_step_button);
						waitUntilISpinnersInvisible();
						waitUntilElementVisible(Constants.ok_button, 30);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
						click(Constants.ok_button);
						waitInvisible(Constants.ok_button);
						if(count(Constants.device_details_arrow_down) > 1) 
							click(Constants.device_details_arrow_down);
						scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='8']");
						actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='8']");
						break;
					}
				}
				else {
					select(Constants.elevator_type, data[1]);
					wait(1);
					select(Constants.elevator_sub_type, data[2]);
					radio(Constants.only_elevator_in_building_no);
					radio(Constants.elevator_part_of_destination_dispatch_system_no);
					radio(Constants.an_occupant_evacuation_no);
					radio(Constants.fire_service_access_no);
					radio(Constants.building_meets_stretcher_car_no);
					radio(Constants.device_used_in_conjunction_with_mta_no);
					radio(Constants.device_conforming_with_seismic_no);
					radio(Constants.device_installed_In_ne_hoistway_no);
					radio(Constants.device_equipped_with_fire_fmergency_no);
					radio(Constants.is_this_loft_law_building_no);
				}				
				
				type(Constants.device_job_description, convertedTimestamp());
				// click(Constants.device_information_label);
				if (count(Constants.completed_checkmark) >= 1) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
					if(count(Constants.device_details_arrow_down) > 1) 
						click(Constants.device_details_arrow_down);
					scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='2']");
					actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='2']");
					break;
				}
			}
		}
	}
	public void deviceInfo2(String device_info) {
		if (!device_info.equals("")) {
			System.out.println(convertedTimestamp() +" **************** deviceInfo2");
//			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			test = rep.startTest("deviceInfo2");	
			click(Constants.open_device_details_tab);
//			click(Constants.add_new_device_link);
			for (int i = 1; i <= 20; i++) {
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
/*				waitVisible(Constants.yes_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("device_added"));
				click(Constants.yes_button);
				waitInvisible(Constants.yes_button);*/
				String[] data = device_info.split(" :: ");
				select(Constants.elevator_type, data[0]);
				select(Constants.elevator_sub_type, data[1]);
				if(device_info.contains("alteration"))
					radio("//input[@id='rdPassengerToFreight'][@value='" +data[2]+ Constants.close_xpath);
				wait(1);
				if(count(Constants.yes_button) > 0)
					click(Constants.yes_button);
				waitInvisible(Constants.yes_button);
				wait(1);
				radio(Constants.only_elevator_in_building_no);
				radio(Constants.elevator_part_of_destination_dispatch_system_no);
				radio(Constants.an_occupant_evacuation_no);
				radio(Constants.fire_service_access_no);
				radio(Constants.building_meets_stretcher_car_no);
				radio(Constants.device_used_in_conjunction_with_mta_no);
				radio(Constants.device_conforming_with_seismic_no);
				radio(Constants.device_installed_In_ne_hoistway_no);
				scrollToElement(Constants.device_equipped_with_fire_fmergency_yes);
				radio(Constants.device_equipped_with_fire_fmergency_yes);
//				radio(Constants.device_equipped_with_fire_fmergency_no);
				radio(Constants.is_this_loft_law_building_no);
				type(Constants.device_job_description, convertedTimestamp());
				// click(Constants.device_information_label);
				if (count(Constants.completed_checkmark) >= 1) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
					if(count(Constants.device_details_arrow_down) > 1) 
						click(Constants.device_details_arrow_down);
					scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='2']");
					actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='2']");
					break;
				}
			}
		}
	}
	// Escalatorm
	public void escalatorInfo(String escalator_Info) {
		if (!escalator_Info.equals("")) {
			String[] data = escalator_Info.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** escalatorInfo");
//			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			test = rep.startTest("escalatorInfo");
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			for (int i = 1; i <= 20; i++) {				
				type(Constants.manufacturer, "AUDI");
				type(Constants.model_number_escalator, "I900");
				type(Constants.speed_escalator, "7");
				type(Constants.rise_feet_escalator, "7");
				type(Constants.rise_inches_escalator, "7");
				type(Constants.step_with_feet_escalator, "7");
				type(Constants.step_with_inches_escalator, "7");
				type(Constants.angle_of_inclination, "7");
				type(Constants.capacity_escalator, "7");
				type(Constants.number_of_steps_escalator, "7");
				type(Constants.brake_torque_escalator, "7");
				
				radio(Constants.tandem_operation_escalator);
				radio(Constants.outdoor_escalator);
				radio(Constants.nergy_saving_function_escalator);
				radio(Constants.flame_smoke_heat_escalator);
				radio(Constants.regenerative_driv_escalator);
				radio(Constants.tandem_operation_escalator);				
				if (count(Constants.completed_checkmark) >= 2) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
/*					if(count(Constants.device_details_arrow_down) > 1) 
						click(Constants.device_details_arrow_down);
					scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='3']");
					actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='3']");*/
					if(count(Constants.device_details_arrow_down) > 1) 
					break;
				}
			}
		}
	}
	public void deviceInfoOther(String device_info) {
		if (!device_info.equals("")) {
			String[] data = device_info.split(" :: ");
			System.out.println(convertedTimestamp() +" **************** deviceInfo");
//			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			test = rep.startTest("Device Info");
			click(Constants.add_new_device_link);
			for (int i = 1; i <= 20; i++) {
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				waitVisible(Constants.yes_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("device_added"));
				click(Constants.yes_button);
				waitInvisible(Constants.yes_button);
				waitVisible(Constants.device_job_description);
				radio("//input[@id='rdquestion21'][@value='2']");
				radio("//input[@id='rdquestion22'][@value='2']");
				radio("//input[@id='rdquestion23'][@value='2']");
				radio("//input[@id='rdquestion24'][@value='2']");
				radio("//input[@id='rdquestion25'][@value='2']");
				radio("//input[@id='rdquestion26'][@value='2']");
/*				radio("//*[@value='2'][@id='rdquestion" +data[1] +Constants.close_xpath);
				radio("//*[@value='2'][@id='rdquestion" +data[2] +Constants.close_xpath);
				radio("//*[@value='2'][@id='rdquestion" +data[3] +Constants.close_xpath);
				radio("//*[@value='2'][@id='rdquestion" +data[4] +Constants.close_xpath);
				radio("//*[@value='2'][@id='rdquestion" +data[5] +Constants.close_xpath);*/
				type(Constants.device_job_description, convertedTimestamp());
				// click(Constants.device_information_label);
				if (count(Constants.completed_checkmark) >= 1) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
					if(count(Constants.device_details_arrow_down) > 1) 
						click(Constants.device_details_arrow_down);
					scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='2']");
					actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='2']");
					break;
				}
			}
		}
	}
	// Machine / Machine Room
	public void machineRoom(String machine_room) {
		if (!machine_room.equals("")) {
			String[] data = machine_room.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** machineRoom");
//			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			test = rep.startTest("Machine Room");
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			for (int i = 1; i <= 20; i++) {
				if (machine_room.contains("Accessibility Lift")) { // Accessibility Lift
					select(Constants.machine_type, data[1]);
					type(Constants.machine_manufacturer, "BMW");
					type(Constants.machine_model, "Z300");					
				} 
				else if (machine_room.contains("Conveyor")) { // Conveyor
					select(Constants.machine_type, data[1]);
					wait(1);
					select(Constants.type_of_machine_brake, data[2]);					
				}
				else if (machine_room.contains("Dumbwaiter")) {	// Dumbwaiter	
					select(Constants.machine_type, data[1]);
					type(Constants.machine_location, data[0]);
					type(Constants.machine_manufacturer, data[0]);
					type(Constants.machine_model, data[0]);
					type(Constants.controller_location, data[0]);
					type(Constants.controller_manufacturer, data[0]);
					type(Constants.controller_model, data[0]);
				}
				else {
					select(Constants.machine_type, data[0]);
					select(Constants.type_of_machine_brake, data[1]);
					select(Constants.type_of_plunger, data[2]);
					type(Constants.machine_location, data[0]);
					type(Constants.machine_manufacturer, data[0]);
					type(Constants.machine_model, data[0]);
					type(Constants.controller_location, data[0]);
					type(Constants.controller_manufacturer, data[0]);
					type(Constants.controller_model, data[0]);
				}
				if (count(Constants.completed_checkmark) >= 2) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
					if(count(Constants.device_details_arrow_down) > 1) 
						click(Constants.device_details_arrow_down);
					scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='3']");
					actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='3']");
					break;
				}
			}
		}
	}

	// General Info
	public void deviceGeneralinfo(String device_general_info) {
		if (!device_general_info.equals("")) {
			String[] data = device_general_info.split(" :: ");
			System.out.println(convertedTimestamp() +" **************** deviceGeneralinfo");
//			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			test = rep.startTest("Device General Info");	
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			for (int i = 1; i <= 20; i++) {				
				if (device_general_info.contains("Accessibility Lift")) { // Accessibility Lift
					select(Constants.elevator_motive_power, data[1]);
					select(Constants.main_supply_motive_power, data[2]);
					type(Constants.travel_from_floor, "1");
					type(Constants.travel_to_floor, "1");
					type(Constants.total_travel, "1");
					type(Constants.number_of_stops, "1");
					type(Constants.capacity, "1");
					send(Constants.speed, "1");		
					wait(2);
					driver.findElement(By.xpath("(//input[@id='rdbdeviceGIAttendantOperation'][@value='2'])[2]")).click();
//					driver.findElement(By.xpath("//*[@id='rdbdeviceGIAttendantOperation]")).click();
					radio(Constants.attendant_operation);
					radio(Constants.glass_transperent);
				}
				else if (device_general_info.contains("Conveyor")) { // Conveyor
					select(Constants.elevator_motive_power, data[1]);
					select(Constants.main_supply_motive_power, data[2]);
					type(Constants.travel_from_floor, "1");
					type(Constants.travel_to_floor, "1");
					type(Constants.total_travel, "1");
					type(Constants.number_of_stops, "1");
					type(Constants.capacity, "1");
					send(Constants.speed, "1");		
					select(Constants.elevator_control, data[3]);
					select(Constants.mode_of_operation, data[4]);					
					select(Constants.device_configuration, data[5]);
					driver.findElement(By.xpath("(//input[@id='rdbdeviceGIAttendantOperation'][@value='2'])[1]")).click();				
				} 
				else if (device_general_info.contains("Dumbwaiter")) {	// Dumbwaiter	
					select(Constants.elevator_motive_power, data[1]);
					select(Constants.main_supply_motive_power, data[2]);
					type(Constants.travel_from_floor, "1");
					type(Constants.travel_to_floor, "1");
					type(Constants.total_travel, "1");
					type(Constants.number_of_stops, "1");
					type(Constants.capacity, "1");
					send(Constants.speed, "1");		
					select(Constants.elevator_control, data[3]);			
				}
				else {
					select(Constants.elevator_motive_power, data[0]);
					select(Constants.main_supply_motive_power, data[1]);
					type(Constants.travel_from_floor, "1");
					type(Constants.travel_to_floor, "1");
					type(Constants.total_travel, "1");
					type(Constants.number_of_stops, "1");
					type(Constants.capacity, "1");
					type(Constants.speed, "1");
					select(Constants.elevator_control, data[2]);
					select(Constants.mode_of_operation, data[3]);
					wait(1);
					scrollToElement(Constants.load_weightholding_device_yes);
					radio(Constants.load_weightholding_device_yes);
					radio(Constants.load_weightholding_device_no);					
					radio(Constants.glass_hoistway_no);
					radio(Constants.atrium_evevator_no);
					radio(Constants.regenerative_drive_no);
				}

				// click(Constants.device_general_information_label);
				if (count(Constants.completed_checkmark) >= 3) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
					if(count(Constants.device_details_arrow_down) > 1) 
						click(Constants.device_details_arrow_down);
					scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='4']");
					actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='4']");
					break;
				}
			}
		}
	}

	// Cars And Counterweight
	public void carsCounterweight(String cars_counterweights) {
		if (!cars_counterweights.equals("")) {
			String[] data = cars_counterweights.split(" :: ");
			System.out.println(convertedTimestamp() +" **************** carsCounterweight");
//			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			test = rep.startTest("carsCounterweight");
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			for (int i = 1; i <= 20; i++) {				
				if (cars_counterweights.contains("Accessibility Lift") || cars_counterweights.contains("Dumbwaiter")) { // Accessibility Lift
					select(Constants.car_safety_type, data[1]);
					select(Constants.counterweight_safety_type, data[2]);
					select(Constants.car_openening, data[3]);
					select(Constants.car_openening_direction, data[4]);
					select(Constants.car_gate_door_operation, data[5]);
					type(Constants.contactType, "contact");
					type(Constants.manufacturer, "BMW");
					type(Constants.car_inside_dimensions_width_feet, "12");
					type(Constants.car_inside_dimensions_width_inches, "21");
					type(Constants.car_inside_dimensions_dept_feet, "15");
					type(Constants.car_inside_dimensions_dept_inches, "31");
				}
				else if (cars_counterweights.contains("Conveyor")) { // Conveyor
					select(Constants.car_openening, data[1]);
					select(Constants.car_openening_direction, data[2]);
					select(Constants.car_gate_door_operation, data[3]);
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
					if(count(Constants.device_details_arrow_down) > 1) 
						click(Constants.device_details_arrow_down);
					scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='5']");
					actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='5']");
					break;
				} 
/*				else if (cars_counterweights.contains("Dumbwaiter")) {	// Dumbwaiter						
					dsfsa
				}*/
				else {
					select(Constants.car_safety_type, data[0]);
					select(Constants.counterweight_safety_type, data[1]);
					select(Constants.car_openening, data[2]);
					select(Constants.car_openening_direction, data[3]);
					select(Constants.car_gate_door_operation, data[4]);
					type(Constants.contactType, "contact");
					type(Constants.manufacturer, "BMW");
					type(Constants.top_emergency_exit_min_area, "1");
					type(Constants.top_emergency_exit_min_side, "1");
					type(Constants.car_inside_dimensions_width_feet, "12");
					type(Constants.car_inside_dimensions_width_inches, "21");
					type(Constants.car_inside_dimensions_dept_feet, "15");
					type(Constants.car_inside_dimensions_dept_inches, "31");
					radio(Constants.sized_for_stretched_requirement_no);
					radio(Constants.glass_car_no);
					radio(Constants.multi_compartment_elevators_no);
					click(Constants.cars_and_counterweights_label);
				}
				if (count(Constants.completed_checkmark) >= 4) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
					if(count(Constants.device_details_arrow_down) > 1) 
						click(Constants.device_details_arrow_down);
					scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='5']");
					actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='5']");
					break;
				}
			}
		}
	}

	public void hoistwayOpeneing(String hoistway_opening) {
		if (!hoistway_opening.equals("")) {
			String[] data = hoistway_opening.split(" :: ");
			System.out.println(convertedTimestamp() +" **************** hoistwayOpeneing");			
//			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));			
			test = rep.startTest("hoistwayOpeneing");
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			for (int i = 1; i <= 20; i++) {
				// Accessibility Lift / Conveyor /Dumbwaiter
				if (hoistway_opening.contains("Accessibility Lift") || hoistway_opening.contains("Conveyor") || hoistway_opening.contains("Dumbwaiter")){ 
					select(Constants.hoist_opening, data[1]);
					select(Constants.hoist_opening_direction, data[2]);
					select(Constants.hoist_operation, data[3]);
					select(Constants.hoist_door_features, data[4]);
					type(Constants.number_of_openings_front, "21");
					type(Constants.number_of_openings_side, "15");
					type(Constants.number_of_openings_rear, "31");
					radio(Constants.free_rated_construction_type_no);	
					if (hoistway_opening.contains("Conveyor")) {
						click(Constants.global_save_step_button);
						waitUntilISpinnersInvisible();
						waitUntilElementVisible(Constants.ok_button, 30);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
						click(Constants.ok_button);
						waitInvisible(Constants.ok_button);
						if(count(Constants.device_details_arrow_down) > 1) 
							click(Constants.device_details_arrow_down);
						scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='6']");
						actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='6']");
						break;	
					}
				}
				else if (hoistway_opening.contains("Dumbwaiter")) {	// Dumbwaiter	
					select(Constants.elevator_motive_power, data[1]);
					select(Constants.main_supply_motive_power, data[2]);
					type(Constants.travel_from_floor, "1");
					type(Constants.travel_to_floor, "1");
					type(Constants.total_travel, "1");
					type(Constants.number_of_stops, "1");
					type(Constants.capacity, "1");
					send(Constants.speed, "1");		
					select(Constants.elevator_control, data[3]);			
				}
				else {
					select(Constants.hoist_opening, data[0]);
					select(Constants.hoist_opening_direction, data[1]);
					select(Constants.hoist_operation, data[2]);
					select(Constants.hoist_door_features, data[3]);
					type(Constants.landing_on_floors, "12");
					type(Constants.number_of_openings_front, "21");
					type(Constants.number_of_openings_side, "15");
					type(Constants.number_of_openings_rear, "31");
					radio(Constants.door_monitoring_circuits_no);
					radio(Constants.free_rated_construction_type_no);
					radio(Constants.self_closing_emergency_door_no);
					radio(Constants.interlock_in_hoistway_yes);
					wait(1);
					radio(Constants.interlock_in_hoistway_no);
				}
				if (count(Constants.completed_checkmark) >= 5) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
					if(count(Constants.device_details_arrow_down) > 1) 
						click(Constants.device_details_arrow_down);
					scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='6']");
					actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='6']");
					break;
				}
			}
		}
	}
// Pit and Buffers
	public void pitAndBuffers(String pit_and_buffers) {
		if (!pit_and_buffers.equals("")) {
			String[] data = pit_and_buffers.split(" :: ");
			System.out.println(convertedTimestamp() +" **************** pitAndBuffers");
//			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			test = rep.startTest("pitAndBuffers");					
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			for (int i = 1; i <= 20; i++) {
				if (pit_and_buffers.contains("Accessibility Lift")) { // Accessibility Lift
					select(Constants.car_buffer, data[1]);	
					type(Constants.pit_depth_inches, "15");
					select(Constants.counterweight_buffer, data[2]);					
				}
				else if (pit_and_buffers.contains("Conveyor")) { // Conveyor
					select(Constants.car_buffer, data[1]);	
					select(Constants.car_type, data[2]);
					select(Constants.counterweight_buffer, data[3]); 
					select(Constants.counterweight_buffer_type, data[4]);
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
					break;				
				} 
				else if (pit_and_buffers.contains("Dumbwaiter")) { // Dumbwaiter
					select(Constants.car_buffer, data[1]);	
					select(Constants.counterweight_buffer, data[2]); 
					radio(Constants.occupied_space_below_no);
				} 
				else {
					select(Constants.car_type, data[0]);
					type(Constants.car_manufacturer, "BMW");
					type(Constants.engagement_speed, "55");
					type(Constants.stroke_feet, "15");
					type(Constants.stroke_inches, "31");
					radio(Constants.car_reduced_stroke_yes);
					radio(Constants.car_reduced_stroke_no);
					select(Constants.compensation_means, data[1]);
					type(Constants.lenght_feet, "21");
					type(Constants.lenght_inches, "15");
					radio(Constants.buffer_reduced_stroke_no);
					radio(Constants.occupied_space_below_no);
					radio(Constants.compensation_tiedown_no);
					radio(Constants.counter_weight_guard_no);
				}
				if (count(Constants.completed_checkmark) >= 6) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
					if(count(Constants.device_details_arrow_down) > 1) 
						click(Constants.device_details_arrow_down);
					break;
				}
			}
		}
	}
	
	// ###########################################################################################################    INSURANCE
	
	public void insuranceFeeInfo(String insurance_fee) {
		if (!insurance_fee.equals("")) {
			System.out.println(convertedTimestamp() + " **************** insuranceFeeInfo");
//			filterJob(user);
			test = rep.startTest("Insurance Fee Info");
			click(Constants.insurance_fee_information_tab);
			String[] data = insurance_fee.split(" :: ");
			type(Constants.estimated_cost, data[0]);
			select(Constants.building_type, data[1]);
			type(Constants.total_floor_area, data[2]);
			type(Constants.building_stories, data[3]);
			radio(Constants.new_building_app_no);
			type(Constants.job_description, convertedTimestamp());
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitUntilElementVisible(Constants.global_notification_ok_button, 30);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			click(Constants.global_notification_ok_button);
			waitInvisible(Constants.global_notification_ok_button);
		}
	}
	
	// ###########################################################################################################    SIGNATURES
	public void signatures(String insurance_fee) {
		if (!insurance_fee.equals("")) {
			System.out.println(convertedTimestamp() + " **************** Signatures");
//			filterJob(user);
			test = rep.startTest("Signatures");
			click(Constants.signatures_tab);
			check(Constants.applicant_sign_elv);
			scrollDown();
			check(Constants.design_pro_sign_elv);
			radio(Constants.fee_exempion_request_non_profit_yes);
			check(Constants.owner_sign_elv);
			click(Constants.save_button);
			waitUntilISpinnersInvisible();
			waitUntilElementVisible(Constants.ok_button, 30);
			verifyNotification(Constants.notification,TEXT_PROPERTIES.getProperty("job_filing_saved"));
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
		}
	}
	public void signaturesSignOff(String insurance_fee) {
		if (!insurance_fee.equals("")) {
			System.out.println(convertedTimestamp() + " **************** Signatures");
//			filterJob(user);
			test = rep.startTest("Signatures");
			click(Constants.signatures_tab);
			check(Constants.applicant_sign_elv);
			scrollDown();
			check(Constants.replacement_modification_statement);
			scrollDown();
			check(Constants.design_pro_sign_elv);
			radio(Constants.fee_exempion_request_non_profit_yes);
			check(Constants.owner_sign_elv);
			click(Constants.save_button);
			waitUntilISpinnersInvisible();
			waitUntilElementVisible(Constants.ok_button, 30);
			verifyNotification(Constants.notification,TEXT_PROPERTIES.getProperty("job_filing_saved"));
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
		}
	}
	
	// ###########################################################################################################    DOCUMENTS
	public void documents(String upload_file) {
		if (!upload_file.equals("")) {
			System.out.println(convertedTimestamp() + " **************** Documents");
//			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
//			filterJob(user, JOB_NUMBER.getProperty("job_number"));
			test = rep.startTest("Documents");
			click(Constants.documents_tab);
			waitUntilISpinnersInvisible();
			while (count(Constants.upload_document_icon) < 1) {
				refreshPage();
				waitForPageToLoad();
			}
			int number_of_docs = 0;
			for (int i = 1; i <= 20; i++) {
				number_of_docs = number_of_docs + 1;
				test.log(LogStatus.INFO, "Upload document " + number_of_docs);
				clear(Constants.document_status_filter_elv);
				type(Constants.document_status_filter_elv, "required");
				if (count(Constants.document_status_required) == 0)
					break;
				click(Constants.upload_icon);
				send(Constants.choose_file_button, Constants.uploadFolder + upload_file);
				click(Constants.upload_button);
				waitInvisible(Constants.doc_please_wait_message);
				click(Constants.ok_button);
				waitInvisible(Constants.ok_button);
				waitInvisible(Constants.global_loading_spinner);
			}
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitUntilElementVisible(Constants.global_notification_ok_button, 30);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			click(Constants.global_notification_ok_button);
			waitInvisible(Constants.global_notification_ok_button);
		}
	}
	
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
	
	public void signature(String sign_off_info) {
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