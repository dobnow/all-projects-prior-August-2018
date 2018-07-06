package com.pages;

import org.openqa.selenium.By;

import com.base.TestBase;
import com.util.Constants;

public class DobPW3Page extends TestBase {

	public void costAffidavit(String pw3) {
		if (!pw3.equals("")) {
			String[] data = pw3.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** PW3 costAffidavit");
			filterJob(user);
			test = rep.startTest("PW3");
			click(Constants.pw3_cost_affidavit_step);
			waitVisible(Constants.add_button);
			if (count(Constants.edit_icon) > 0) {
				doubleclick(Constants.edit_icon);
				wait(2);
			} else
			click(Constants.add_button);
			select(Constants.pw3_description_of_work, data[0]);
			type(Constants.pw3_area_units, data[1]);
			type(Constants.pw3_unit_cost, data[2]);
			click(Constants.pw3_cost_details_save_button);
			waitInvisible(Constants.pw3_cost_details_save_button);
			click(Constants.global_save_step_button);
//			waitVisible(Constants.global_loading_spinner);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved");
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			reportPass("Success");
		}
	}
/*	public void costAffidavitPlumbing(String pw3) {
		if (!pw3.equals("")) {
			String[] data = pw3.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** costAffidavitPlumbing");
			filterJob(user);
			test = rep.startTest("costAffidavitPlumbing");
			click(Constants.pw3_cost_affidavit_step);
			int b = 0, c = 1;
			for (int i = 1; i <= 5; i++) {
				waitVisible("//span[text()='Description of Work']");
				multiClick(Constants.add);
				select(Constants.pw3_select_categogy, data[i]);
				type(Constants.pw3_area_units, "1");
				type(Constants.pw3_unit_cost, "1111");
				type(Constants.description_of_work, pw3);
				click(Constants.global_save_form_button);
				wait(3);
				if (count(Constants.trash_can_icon) >= num_items)
					break;
				b = b + 1;
			}
			if(num_items >= 3) {
				b = 0;
				c = 1;
				for (int i = 1; i <= 5; i++) {
					waitVisible("//span[text()='Work Type']");
					multiClick("(" + Constants.add + ")[last()]");
					waitVisible(Constants.sow_modal);
					waitVisible(Constants.sow_detail_select_category);
					select(Constants.sow_detail_select_category, data[b + i]);
					wait(1);
					select(Constants.sow_detail_select_scope_includes, data[c + b + i]);
					if (driver.findElement(By.xpath("//input[@id='txtSDNumOfUnits']")).isDisplayed())
						type("//input[@id='txtSDNumOfUnits']", "1");
					if (driver.findElement(By.xpath("//input[@id='txtSDFloor']")).isDisplayed())
						type("//input[@id='txtSDFloor']", "1");
					if (driver.findElement(By.xpath("//input[@id='txtSDTypeOfUnit']")).isDisplayed())
						type("//input[@id='txtSDTypeOfUnit']", "1");
					click(Constants.global_save_form_button);
					waitInvisible(Constants.global_save_form_button);
//					b = b + 1;
					wait(2);
					if (count(Constants.trash_can_icon) > num_items + 1)
						break;
					b = b + 1;
				}
			}
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
	}*/
	public void costAffidavitPlumbingNew(String pw3) {
		if (!pw3.equals("")) {
			String[] data = pw3.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** PW3 costAffidavitPlumbingNew");
			filterJob(user);
			test = rep.startTest("costAffidavitPlumbingNew");
			for (int i = 1; i <= 5; i++) {
				click(Constants.pw3_cost_affidavit_step);
				waitVisible("//span[text()='Description of Work']");
				multiClick(Constants.add);
				select(Constants.pw3_select_categogy, data[i]);
				type(Constants.pw3_area_units, "1");
				type(Constants.pw3_unit_cost, "1111");
				type(Constants.description_of_work, pw3);
				click(Constants.global_save_form_button);
				wait(2);
				if (count(Constants.trash_can_icon) >= num_items)
					break;
			}
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
		reportPass("costAffidavitPlumbingNew");
	}
	public void costAffidavitPlumbingLegalization(String pw3) {
		if (!pw3.equals("")) {
			String[] data = pw3.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** PW3 costAffidavitPlumbingLegalization");
			filterJob(user);
			test = rep.startTest("costAffidavitPlumbingLegalization");
			for (int i = 1; i <= 5; i++) {
				click(Constants.pw3_cost_affidavit_step);
				waitVisible("//span[text()='Description of Work']");
				multiClick("(" + Constants.add + ")[2]");
				select(Constants.pw3_select_categogy, data[i]);
				type(Constants.pw3_area_units, "1");
				type(Constants.pw3_unit_cost, "1111");
				type(Constants.description_of_work, pw3);
				click(Constants.global_save_form_button);
				wait(2);
				if (count(Constants.trash_can_icon) >= num_items)
					break;
			}
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
		reportPass("costAffidavitPlumbingLegalization");
	}
	public void costAffidavitPlumbing(String pw3) {
		if (!pw3.equals("")) {
			String[] data = pw3.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** PW3 costAffidavitPlumbing");
			filterJob(user);
			test = rep.startTest("PW3");
			for (int i = 1; i <= 5; i++) {
				click(Constants.pw3_cost_affidavit_step);
				waitVisible("//span[text()='Description of Work']");
				multiClick(Constants.add);
				select(Constants.pw3_select_categogy, data[i]);
				type(Constants.pw3_area_units, "1");
				type(Constants.pw3_unit_cost, "1111");
				type(Constants.description_of_work, pw3);
				click(Constants.global_save_form_button);
				wait(2);
				if (count(Constants.trash_can_icon) >= num_items)
					break;
			}
			if(num_items >= 3) {
				for (int i = 1; i <= 5; i++) {
					multiClick("(" + Constants.add + ")[last()]");
					select(Constants.pw3_select_categogy, data[i]);
					type(Constants.pw3_area_units, "1");
					type(Constants.pw3_unit_cost, "1666.5");
					type(Constants.description_of_work, pw3);
					click(Constants.global_save_form_button);
					wait(2);
					if (count(Constants.trash_can_icon) > num_items + 1)
						break;
				}
			}
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
		reportPass("costAffidavitPlumbing");
	}

	public void costAffidavitSignNew(String pw3) {
		if (!pw3.equals("")) {
			String[] data = pw3.split("::");
			System.out.println(convertedTimestamp() + " **************** costAffidavitSignNew");
			filterJob(user);
			test = rep.startTest("PW3 costAffidavitSignNew");
			click(Constants.pw3_cost_affidavit_step);
			waitVisible("//span[text()='Initial Cost Details']");
			multiClick(Constants.add);
			type(Constants.pw3_area_units_sign, data[0]);
			type(Constants.pw3_unit_cost_sign, data[1]);
			type(Constants.pw3_cost_details_description_sign, convertedTimestamp());
			click(Constants.pw3_cost_details_save_button);
			waitInvisible(Constants.pw3_cost_details_save_button);
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			reportPass("costAffidavitSignNew");
		}
	}
	public void costAffidavitSignLegalization(String pw3) {
		if (!pw3.equals("")) {
			String[] data = pw3.split("::");
			System.out.println(convertedTimestamp() + " **************** " + "costAffidavitSign");
			filterJob(user);
			test = rep.startTest("PW3");
			click(Constants.pw3_cost_affidavit_step);
			waitVisible("//span[text()='Initial Cost Details']");
			multiClick("(" + Constants.add + ")[2]");
			type(Constants.pw3_area_units_sign, data[0]);
			type(Constants.pw3_unit_cost_sign, data[1]);
			type(Constants.pw3_cost_details_description_sign, convertedTimestamp());
			click(Constants.pw3_cost_details_save_button);
			waitInvisible(Constants.pw3_cost_details_save_button);
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			reportPass("costAffidavitSignLegalization");
		}
	}
}