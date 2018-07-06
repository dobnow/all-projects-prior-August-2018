package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.TestBase;
import com.util.Constants;

public class ElectricalSOWPage extends TestBase {
/*	WebDriver driver;
	public ElectricalSOWPage(WebDriver dr) {
		driver = dr;
	}*/
	

// Work Description	
	public void workDescription(String sow) {	
		if(!sow.equals("")){
			System.out.println(convertedTimestamp() + " **************** Scope Of Work Elctrical");
//			loginToPortal(OR_PROPERTIES.getProperty("electrical_user_email"));
			filterJob(OR_PROPERTIES.getProperty("electrical_user_email"),JOB_NUMBER.getProperty("job_number"));
			test = rep.startTest("Scope Of Work");
			waitUntilISpinnersInvisible();
			click(Constants.el_scope_of_work_tab);
			waitUntilISpinnersInvisible();
			waitUntilElementVisible(Constants.el_select_category_of_work, 30);
			if(sow.contains("New Installation")) {
				scrollAllWayUp();
				waitUntilElementVisible("//*[@id='toggle-chk1']", 30);
				check(Constants.el_sow_service_work);
				check(Constants.el_sow_general_wiring);
				check(Constants.el_sow_lighting_work);
				select(Constants.el_sow_lighting_work_type, sow);
				scrollAllWayDown();
				wait(2);
				scrollToElement(Constants.el_boiler_controls_tab);
				click(Constants.el_boiler_controls_tab);
				type(Constants.el_boiler_controls_quantity, "1");
				type(Constants.el_boiler_controls_number_size, "2");
				click(Constants.el_boiler_controls_tab);
				click(Constants.el_service_meter_equipment);
//				waitUntilElementVisible(Constants.el_number_3_wire, 30);
				type(Constants.el_number_3_wire, "11");
				type(Constants.el_number_4_wire, "12");
				type(Constants.el_number_10_points, "14");
				type(Constants.el_number_existing_meters, "15");
				type(Constants.el_number_new_meters, "16");
				type(Constants.el_number_removed_meters, "17");
				click(Constants.el_service_meter_equipment);
			}
			if(sow.contains("Minor Work")){
//				select(Constants.el_select_category_of_work, "4");
				select(Constants.el_select_category_of_work, sow);

				click(Constants.global_save_step_button);
				click(Constants.global_notification_ok_button);
				waitInvisible(Constants.global_notification_ok_button);
				waitUntilISpinnersInvisible();
				waitUntilElementVisible(Constants.el_minor_work_description_slider, 30);
				scrollToElement(Constants.el_minor_work_description_slider);
				click(Constants.el_minor_work_description_slider);
				click(Constants.el_add_minor_work_description_button);
				select(Constants.el_minor_work_options, "(E) Repair of Defective Fixtures");
				select(Constants.el_minor_work_location, "Pit");
				type(Constants.el_minor_work_quantity, "1");
				type(Constants.el_minor_work_description, "minor test description");
/*				waitUntilElementVisible(Constants.el_minor_work_options, 30);
				el_minor_work_options.sendKeys("(E) Repair of Defective Fixtures");
				el_minor_work_location.sendKeys("Pit");
				el_minor_work_quantity.sendKeys("1");
				el_minor_work_description.sendKeys("minor test description");*/
				click(Constants.el_minor_work_save_button);
//				el_minor_work_save_button.click();
				click(Constants.global_notification_ok_button);
				waitInvisible(Constants.global_notification_ok_button);
			}
			if(sow.equals("Field Sign Inspection")){
				select(Constants.el_select_category_of_work, sow);
				if(CONFIG.getProperty("env").contains("8085"))
					type(Constants.el_job_number_field, "B00007126");
				else
					type(Constants.el_job_number_field, "B00330512");
				click(Constants.electric_sign_description_tab);
				click(Constants.global_save_step_button);
				click(Constants.global_notification_ok_button);
				waitInvisible(Constants.global_notification_ok_button);
				waitUntilISpinnersInvisible();
				click(Constants.add_sign_description_button);
				type(Constants.sign_dimentions, "111");
				type(Constants.total_sq_feet_of_sign, "222");
				type(Constants.total_circuit_in_sign, "333");
				type(Constants.total_lamps, "444");
				type(Constants.total_wats, "555");
				type(Constants.number_of_transformenrs, "777");
				type(Constants.va_of_each_transformer, "888");
				type(Constants.total_wats_of_va, "999");
				type(Constants.avg_gauge_of_wires, "789");
				type(Constants.number_of_sockets_per_circuit, "211");
				type(Constants.material_and_gauge_used, "233");
				type(Constants.make_of_sign, "244");
				type(Constants.manufacturer_of_sign, "IBM");
				type(Constants.manufacturer_address, "100 Main");
				click(Constants.el_save_modal_button);
				click(Constants.global_notification_ok_button);
				waitInvisible(Constants.global_notification_ok_button);
				waitInvisible(Constants.el_save_modal_button);
				waitUntilISpinnersInvisible();
			}
			click(Constants.global_save_step_button);
			waitVisible(Constants.global_notification_ok_button);
// ASSERT NOTIFICATION	
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved");
/*			waitUntilElementVisible(Constants.global_notification_ok_button, 30);
			if(sow.equals("NEW INSTALLATION"))
				assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved");
			if(sow.equals("Minor Work"))
				assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved");*/
			click(Constants.global_notification_ok_button);
			waitInvisible(Constants.global_notification_ok_button);
		}
	}
}