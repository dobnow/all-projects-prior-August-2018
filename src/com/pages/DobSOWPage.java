package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.TestBase;
import com.util.Constants;

public class DobSOWPage extends TestBase {
/*	WebDriver driver;
	public DobSOWPage(WebDriver dr) {
		driver = dr;
	}*/
	
	public void scopeOfWork(String asw) {	
		if(!asw.equals("")){
			System.out.println(convertedTimestamp() + " **************** ScopeOfWorkTest");
			filterJob(user);		
			test = rep.startTest("ASW");
			click(Constants.antenna_scope_of_work_step);
			waitVisible(Constants.asw_specify_supporting_structures_for_antenna_array_rrh);
			String[] data = asw.split(" :: ");
			if(data[0].contains("Y"))
				radio(Constants.asw_are_new_antenna_rrh_array_prposed_yes);
			else
				radio(Constants.asw_are_new_antenna_rrh_array_prposed_no);
			if(count("//button[contains(text(),'Select')]") > 0){
				click("//button[contains(text(),'Select')]");
//				click(Constants.asw_specify_supporting_structures_for_antenna_array_rrh);
				click(Constants.link_xpath_part1 + data[1] + Constants.link_xpath_part2);
			}
			if(data[2].contains("separate"))
				radio(Constants.asw_structural_work_seperate);
			if(data[3].contains("existing"))
				radio(Constants.asw_emergency_power_system_existing);	
			if(data[4].contains("N"))
				radio(Constants.asw_associated_mechanical_work_proposed_no);
			type(Constants.asw_what_floor_associated_equipment_located, "1");
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.global_notification_ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			click(Constants.global_notification_ok_button);
			waitInvisible(Constants.global_notification_ok_button);
		}
	}
	public void scopeOfWorkPlumbingNew(String sow) {
		if (!sow.equals("")) {
			String[] data = sow.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** scopeOfWorkPlumbingNew");
			filterJob(user);
			test = rep.startTest("scopeOfWorkPlumbingNew");
			click(Constants.scope_of_work_step);
			int b = 0, c = 1;
			for (int i = 1; i <= 5; i++) {
				waitVisible("//span[text()='Work Type']");
				multiClick(Constants.add);
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
				wait(3);
				if (count(Constants.trash_can_icon) == num_items)
					break;
				b = b + 1;
			}
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
	}
	public void scopeOfWorkPlumbingLegalization(String sow) {
		if (!sow.equals("")) {
			String[] data = sow.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** scopeOfWorkPlumbingLegalization");
			filterJob(user);
			test = rep.startTest("scopeOfWorkPlumbingLegalization");
			click(Constants.scope_of_work_step);
			int b = 0, c = 1;
			for (int i = 1; i <= 5; i++) {
				waitVisible("//span[text()='Work Type']");
				multiClick("(" + Constants.add + ")[2]");
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
				wait(3);
				if (count(Constants.trash_can_icon) >= num_items)
					break;
				b = b + 1;
			}
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
	}
	public void scopeOfWorkPlumbing(String sow) {
		if (!sow.equals("")) {
			String[] data = sow.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** ScopeOfWorkTest");
			filterJob(user);
			test = rep.startTest("ASW");
			click(Constants.scope_of_work_step);
			int b = 0, c = 1;
			for (int i = 1; i <= 5; i++) {
				waitVisible("//span[text()='Work Type']");
				multiClick(Constants.add);
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
				wait(3);
				if (count(Constants.trash_can_icon) == num_items)
					break;
				b = b + 1;
			}
			if(num_items >= 2) {
				b = 0;
				c = 1;
				for (int i = 1; i <= 5; i++) {
					waitVisible("//span[text()='Work Type']");
					multiClick("(" + Constants.add + ")[2]");
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
					if (count(Constants.trash_can_icon) >+ num_items)
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
	}
	
	public void scopeOfWorkScaffold(String asw) {
		if (!asw.equals("")) {
			String[] data = asw.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** scopeOfWorkScaffold");
			filterJob(user);
			test = rep.startTest("scopeOfWorkScaffold");
			click(Constants.scope_of_work_step);
			for (int i = 1; i <= 5; i++) {
				waitVisible("//span[text()='Supported Scaffold']");
				if (!data[1].contains("N"))
					check(Constants.sidewalk_shed);
				if (!data[2].contains("N"))
					check(Constants.construction_fence);
				select(Constants.scaffold_type, data[3]);
				radio(Constants.scaffold_going_to_extend_no);
				select(Constants.how_scaffold_supported, data[5]);
				radio(Constants.scaffold_any_related_equipment_no);
				wait(1);
				if (count(Constants.completed_checkmark) > 0) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}
				scrollAllWayDown();
				if(count("//span[text()='Sidewalk Shed']") > 0) {
					select(Constants.shed_type, data[7]);
					radio(Constants.sidewalk_going_to_extend_no);
					select(Constants.how_shed_supported, data[9]);
					radio(Constants.sidewalk_any_related_equipment_no);
					if(count("//button[contains(text(),'Select')]") > 0) {
						click("//button[contains(text(),'Select')]");
						click("(//a[contains(.,'" + data[11] + "')])[last()]");
					}
					wait(1);
					if (count(Constants.completed_checkmark) > 1) {
						click(Constants.global_save_step_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
					}
				}
				scrollAllWayDown();
				if(count("//span[text()='Construction Fence']") > 0) {
					type(Constants.fence_height, data[12]);
					select(Constants.fence_location, data[13]);
					wait(1);
					if (count(Constants.completed_checkmark) > 2) {
						click(Constants.global_save_step_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
					}
				}
				if (count(Constants.completed_checkmark) == num_items) {
					reportPass("scopeOfWorkScaffold");
					break;
				}
			}
		}
	}
	public void scopeOfWorkSidewalk(String asw) {
		if (!asw.equals("")) {
			String[] data = asw.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** scopeOfWorkSidewalk");
			filterJob(user);
			test = rep.startTest("scopeOfWorkSidewalk");
			click(Constants.scope_of_work_step);
			for (int i = 1; i <= 5; i++) {
/*				waitVisible("//span[text()='Supported Scaffold']");
				if (!data[1].contains("N"))
					check(Constants.sidewalk_shed);
				if (!data[2].contains("N"))
					check(Constants.construction_fence);
				select(Constants.scaffold_type, data[3]);
				radio(Constants.scaffold_going_to_extend_no);
				select(Constants.how_scaffold_supported, data[5]);
				radio(Constants.scaffold_any_related_equipment_no);
				wait(1);
				if (count(Constants.completed_checkmark) > 0) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}*/
				scrollAllWayDown();
				if(count("//span[text()='Sidewalk Shed']") > 0) {
					select(Constants.shed_type, data[3]);
					radio(Constants.sidewalk_going_to_extend_no);
					select(Constants.how_shed_supported, data[5]);
					radio(Constants.sidewalk_any_related_equipment_no);
					if(count("//button[contains(text(),'Select')]") > 0) {
						click("//button[contains(text(),'Select')]");
						click("(//a[contains(.,'" + data[7] + "')])[last()]");
					}
					wait(1);
					if (count(Constants.completed_checkmark) > 0) {
						click(Constants.global_save_step_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
					}
				}
/*				scrollAllWayDown();
				if(count("//span[text()='Construction Fence']") > 0) {
					type(Constants.fence_height, data[12]);
					select(Constants.fence_location, data[13]);
					wait(1);
					if (count(Constants.completed_checkmark) > 2) {
						click(Constants.global_save_step_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
					}
				}*/
				if (count(Constants.completed_checkmark) == num_items) {
					reportPass("scopeOfWorkSidewalk");
					break;
				}
			}
		}
	}
	public void scopeOfWorkFence(String asw) {
		if (!asw.equals("")) {
			String[] data = asw.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** scopeOfWorkFence");
			filterJob(user);
			test = rep.startTest("scopeOfWorkFence");
			click(Constants.scope_of_work_step);
			for (int i = 1; i <= 5; i++) {
				scrollAllWayDown();
				if(count("//span[text()='Construction Fence']") > 0) {
					type(Constants.fence_height, data[3]);
					select(Constants.fence_location, data[4]);
					wait(1);
					if (count(Constants.completed_checkmark) > 0) {
						click(Constants.global_save_step_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
					}
				}
				if (count(Constants.completed_checkmark) == num_items) {
					reportPass("scopeOfWorkFence");
					break;
				}
			}
		}
	}

}