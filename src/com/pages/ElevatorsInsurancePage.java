package com.pages;

import com.base.TestBase;
import com.util.Constants;

public class ElevatorsInsurancePage extends TestBase {

	public void insuranceFeeInfo(String insurance_fee) {
		if (!insurance_fee.equals("")) {
			System.out.println(convertedTimestamp() + " **************** insuranceFeeInfo");
			filterJob(user);
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
}