package com.pages;

import com.base.TestBase;
import com.util.Constants;

public class ElevatorsDevicedetailsPage extends TestBase {

	// Device Info
	public void deviceInfo(String device_info) {
		if (!device_info.equals("")) {
			System.out.println(convertedTimestamp() +" **************** deviceInfo");
			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			test = rep.startTest("Device Info");
			click(Constants.add_new_device_link);
			for (int i = 1; i <= 20; i++) {
				waitVisible(Constants.yes_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("device_added"));
				click(Constants.yes_button);
				waitInvisible(Constants.yes_button);
				String[] data = device_info.split(" :: ");
				if(!data[0].contains("dismantle") || !data[0].contains("alteration")) {
					select(Constants.elevator_type, data[0]);
					select(Constants.elevator_sub_type, data[1]);
				}
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
				type(Constants.device_job_description, convertedTimestamp());
				// click(Constants.device_information_label);
				if (count(Constants.completed_checkmark) >= 1) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
					scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='2']");
					actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='2']");
					break;
				}
			}
		}
	}
	public void deviceInfo2(String device_info) {
		if (!device_info.equals("")) {
			System.out.println(convertedTimestamp() +" **************** deviceInfoAlteration");
			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			test = rep.startTest("Device Info deviceInfoAlteration");
	
			click(Constants.open_device_details_tab);
//			click(Constants.add_new_device_link);
			for (int i = 1; i <= 20; i++) {
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
					scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='2']");
					actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='2']");
					break;
				}
			}
		}
	}
	public void deviceInfoOther(String device_info) {
		if (!device_info.equals("")) {
			System.out.println(convertedTimestamp() +" **************** deviceInfo");
			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			test = rep.startTest("Device Info");
			click(Constants.add_new_device_link);
			for (int i = 1; i <= 20; i++) {
				waitVisible(Constants.yes_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("device_added"));
				click(Constants.yes_button);
				waitInvisible(Constants.yes_button);
				String[] data = device_info.split(" :: ");
/*				if(!data[0].contains("skip")) {
					select(Constants.elevator_type, data[0]);
					select(Constants.elevator_sub_type, data[1]);
				}
				*/
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
			System.out.println(convertedTimestamp() +" **************** machineRoom");
			/*
			 * filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			 * click("//i[@class='fa fa-edit']");
			 * waitInvisible("//i[@class='fa fa-edit']");
			 */
			test = rep.startTest("Machine Room");
			for (int i = 1; i <= 20; i++) {
				String[] data = machine_room.split(" :: ");
				select(Constants.machine_type, data[0]);
				select(Constants.type_of_machine_brake, data[1]);
				select(Constants.type_of_plunger, data[2]);
				type(Constants.machine_location, data[0]);
				type(Constants.machine_manufacturer, data[0]);
				type(Constants.machine_model, data[0]);
				type(Constants.controller_location, data[0]);
				type(Constants.controller_manufacturer, data[0]);
				type(Constants.controller_model, data[0]);
				// click(Constants.machine_room_label);
				if (count(Constants.completed_checkmark) >= 2) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
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
			System.out.println(convertedTimestamp() +" **************** deviceGeneralinfo");
			test = rep.startTest("Device General Info");
			for (int i = 1; i <= 20; i++) {
				String[] data = device_general_info.split(" :: ");
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
				// click(Constants.device_general_information_label);
				if (count(Constants.completed_checkmark) >= 3) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
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
			System.out.println(convertedTimestamp() +" **************** carsCounterweight");
			
/*			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			waitVisible("//i[@class='fa fa-edit']");
			click("//i[@class='fa fa-edit']");
			waitInvisible("//i[@class='fa fa-edit']");
			scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='4']");
			actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='4']");*/
			
			test = rep.startTest("Device General Info");
			for (int i = 1; i <= 20; i++) {
				String[] data = cars_counterweights.split(" :: ");
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
				if (count(Constants.completed_checkmark) >= 4) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
					scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='5']");
					actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='5']");
					break;
				}
			}
		}
	}

	public void hoistwayOpeneing(String hoistway_opening) {
		if (!hoistway_opening.equals("")) {
			System.out.println(convertedTimestamp() +" **************** hoistwayOpeneing");
			
/*			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			waitVisible("//i[@class='fa fa-edit']");
			click("//i[@class='fa fa-edit']");
			waitInvisible("//i[@class='fa fa-edit']");
			scrollToElement("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='5']");
			actionClick("//i[@class='glyphicon pull-right v-pad-10 glyphicon-chevron-right'][@id='5']");*/
			
			test = rep.startTest("Device General Info");
			for (int i = 1; i <= 20; i++) {
				String[] data = hoistway_opening.split(" :: ");
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
				if (count(Constants.completed_checkmark) >= 5) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
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
			System.out.println(convertedTimestamp() +" **************** pitAndBuffers");
			test = rep.startTest("Pit and Buffers");
			for (int i = 1; i <= 20; i++) {
				String[] data = pit_and_buffers.split(" :: ");
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
				if (count(Constants.completed_checkmark) >= 6) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.ok_button, 30);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					click(Constants.ok_button);
					waitInvisible(Constants.ok_button);
					break;
				}
			}
		}
	}

}