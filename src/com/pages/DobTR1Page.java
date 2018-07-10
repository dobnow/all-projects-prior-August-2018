package com.pages;

import com.util.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class DobTR1Page extends TestBase {
/*	WebDriver driver;

	public DobTR1Page(WebDriver dr) {
		driver = dr;
	}*/

	@FindBy(xpath = Constants.pw2_work_permit_step)
	public WebElement pw2_work_permit_step;
	@FindBy(xpath = Constants.welcome_email)
	public WebElement welcome_email;
	@FindBy(xpath = Constants.welcome_password)
	public WebElement welcome_password;
	@FindBy(xpath = Constants.welcome_login_button)
	public WebElement welcome_login_button;
	@FindBy(xpath = Constants.dob_now_build_component)
	public WebElement dob_now_build_component;
	@FindBy(xpath = Constants.filtered_job)
	public WebElement filtered_job;
	@FindBy(xpath = Constants.job_number_search)
	public WebElement job_number_search;
	@FindBy(xpath = Constants.job_search_input_box)
	public WebElement job_search_input_box;
	@FindBy(xpath = Constants.search_button)
	public WebElement search_button;
	@FindBy(xpath = Constants.tr1_technical_report_step)
	public WebElement tr1_technical_report_step;
	@FindBy(xpath = Constants.tr1_are_you_applicant)
	public WebElement tr1_are_you_applicant;
	@FindBy(xpath = Constants.tr1_are_you_special_inspector)
	public WebElement tr1_are_you_special_inspector;
	@FindBy(xpath = Constants.tr1_are_you_progress_inspector)
	public WebElement tr1_are_you_progress_inspector;
	@FindBy(xpath = Constants.tr1_edit_special_inspection_category)
	public WebElement tr1_edit_special_inspection_category;
	@FindBy(xpath = Constants.tr1_edit_progress_inspection_category)
	public WebElement tr1_edit_progress_inspection_category;
	// special inspection requirements
	@FindBy(xpath = Constants.inspection_label)
	public WebElement inspection_label;
	@FindBy(xpath = Constants.tr1_select_requirement_code)
	public WebElement tr1_select_requirement_code;
	@FindBy(xpath = Constants.tr1_select_requirement_code_field)
	public WebElement tr1_select_requirement_code_field;
	@FindBy(xpath = Constants.tr1_select_requirement_code_filter)
	public WebElement tr1_select_requirement_code_filter;
	@FindBy(xpath = Constants.tr1_inspector_email)
	public WebElement tr1_inspector_email;
	@FindBy(xpath = Constants.tr1_license_type)
	public WebElement tr1_license_type;
	@FindBy(xpath = Constants.tr1_license_number)
	public WebElement tr1_license_number;
	@FindBy(xpath = Constants.tr1_agency_number)
	public WebElement tr1_agency_number;

	// Edit Progress Inspection
	@FindBy(xpath = Constants.tr1_i_take_responcibility)
	public WebElement tr1_i_take_responcibility;
	@FindBy(xpath = Constants.tr1_i_understand_my_failure_to_file)
	public WebElement tr1_i_understand_my_failure_to_file;
	@FindBy(xpath = Constants.tr1_i_understand_and_agree)
	public WebElement tr1_i_understand_and_agree;
	@FindBy(xpath = Constants.tr1_add_special_inspections_categories)
	public WebElement tr1_add_special_inspections_categories;
	@FindBy(xpath = Constants.tr1_add_requirements_list)
	public WebElement tr1_add_requirements_list;
	@FindBy(xpath = Constants.tr1_add_requirements_list_select)
	public WebElement tr1_add_requirements_list_select;
	@FindBy(xpath = Constants.tr1_add_requirements_save_button)
	public WebElement tr1_add_requirements_save_button;
	// Upload File
	@FindBy(xpath = Constants.upload_special_inspector_file)
	public WebElement upload_special_inspector_file;
	@FindBy(xpath = Constants.upload_progress_inspector_file)
	public WebElement upload_progress_inspector_file;
	@FindBy(xpath = Constants.tr1_confirm_upload_button)
	public WebElement tr1_confirm_upload_button;
	@FindBy(xpath = Constants.tr1_browse_button)
	public WebElement tr1_browse_button;
	@FindBy(xpath = Constants.tr1_upload_button)
	public WebElement tr1_upload_button;
	@FindBy(xpath = Constants.tr1_please_wait_message)
	public WebElement tr1_please_wait_message;
	@FindBy(xpath = Constants.tr1_upload_succesfull_message)
	public WebElement tr1_upload_succesfull_message;
	@FindBy(xpath = Constants.tr1_document_uploaded_ok_button)
	public WebElement tr1_document_uploaded_ok_button;
	@FindBy(xpath = Constants.tr1_add_progress_inspection_categories)
	public WebElement tr1_add_progress_inspection_categories;
	@FindBy(xpath = Constants.tr1_save_progress_inspection_button)
	public WebElement tr1_save_progress_inspection_button;
	@FindBy(xpath = Constants.tr1_add_save_button)
	public WebElement tr1_add_save_button;
	@FindBy(xpath = Constants.global_add_button)
	public WebElement global_add_button;
	@FindBy(xpath = Constants.global_cancel_button)
	public WebElement global_cancel_button;
	@FindBy(xpath = Constants.global_save_step_button)
	public WebElement global_save_step_button;
	@FindBy(xpath = Constants.ok_button)
	public WebElement global_notification_ok_button;
	@FindBy(xpath = Constants.global_loading_spinner)
	public WebElement global_loading_spinner;

	String add_button;

	public void specialInspection(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspection");
			filterJob(user);
			test = rep.startTest("TR1 Inspection");
			click(Constants.tr1_technical_report_step);
			check(Constants.tr1_are_you_special_inspector);
			check(Constants.tr1_are_you_progress_inspector);
			for (int i = 1; i < 100; i++) {
				multiClick(Constants.add);
//				click(Constants.global_add_button);
				click(Constants.tr1_select_requirement_code);
				type(Constants.tr1_select_requirement_code_field, data[0]);
				click(Constants.tr1_select_requirement_code_filter);
				click(Constants.inspection_label);
				email(OR_PROPERTIES.getProperty("special_inspector_email"));
				select(Constants.tr1_license_type, OR_PROPERTIES.getProperty("special_inspector_lisence"));
				type(Constants.tr1_agency_number, data[3]);
				//keyPressTab(Constants.tr1_agency_number);
				wait(2);
				if (count(Constants.green_valid_label) > 0)
					break;
				else
					click(Constants.global_cancel_button);
			}
			click(Constants.tr1_save_progress_inspection_button);
			waitInvisible(Constants.tr1_save_progress_inspection_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			reportPass("Success");
		}
	}

	public void specialInspectorSignature(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectorSignature");
			filterJob(data[1]);
			test = rep.startTest("TR1 specialInspectorSignature");
			for (int i = 1; i < 100; i++) {
				click(Constants.tr1_technical_report_step);
				check(Constants.tr1_are_you_special_inspector);
				check(Constants.tr1_are_you_progress_inspector);
				click("//i[@class='fa fa-edit']"); // DO NOT CAHNGE TO LAST()
				waitVisible("//h4[text()='Special Inspection Category']");
				waitVisible(Constants.tr1_agency_number);
				wait(3);
//				System.out.println(count(Constants.green_valid_label));
				if (count(Constants.green_valid_label) > 0) {
					check(Constants.tr1_i_take_responcibility);
					check(Constants.tr1_i_understand_my_failure_to_file);
					check(Constants.tr1_i_understand_and_agree);
					click(Constants.tr1_save_progress_inspection_button);
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_updated"));
					clickButton("OK");
					waitInvisible(Constants.ok_button);
					waitInvisible(Constants.tr1_save_progress_inspection_button);
				}
				wait(2);
				if (count(Constants.identified_yes_label) > 0)
					break;
//				System.out.println(text(Constants.license_type_list));
				if (!text(Constants.license_type_list).contains(data[2]));
					select(Constants.license_type_list, data[2]); // DO NOT CAHNGE TO LAST()
				if ((count(Constants.tr1_agency_number) > 0))
					type(Constants.tr1_agency_number, "005551");
				wait(2);
				check(Constants.tr1_i_take_responcibility);
				check(Constants.tr1_i_understand_my_failure_to_file);
				check(Constants.tr1_i_understand_and_agree);
				click(Constants.tr1_save_progress_inspection_button);
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_updated"));
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				waitInvisible(Constants.tr1_save_progress_inspection_button);
				if (count(Constants.identified_yes_label) > 0)
					break;
/*				else
					click(Constants.cancel_button);*/
			}
			if(count(Constants.upload_document_icon) > 0) {
				click(Constants.upload_document_icon); // DO NOT CAHNGE TO LAST()
				waitVisible(Constants.tr1_browse_button);
				send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
				wait(1);
				click(Constants.tr1_upload_button);
				waitInvisible(Constants.tr1_please_wait_message);
				waitVisible(Constants.tr1_upload_succesfull_message);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				clickButton("OK");
				waitInvisible(Constants.ok_button);
			}
			reportPass("Success");
		}
	}

	public void specialInspectionSignNew(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectionPlumbingNew");
			filterJob(user);
			test = rep.startTest("TR1 specialInspectionPlumbingNew");
			test.log(LogStatus.INFO, " specialInspectionPlumbingNew");
			clickAndWait(Constants.tr1_technical_report_step, Constants.tr1_are_you_special_inspector);
			check(Constants.tr1_are_you_special_inspector);
//			if (count(Constants.edit_icon) > 0) {
				for (int i = 1; i < 5; i++) {
					waitVisible("//span[text()='Requirement']");
					multiClick("//span[contains(text(),'Special Inspection Categories for New Work')]/following::span[text()='Add']");
					click(Constants.tr1_select_requirement_code);
					type(Constants.tr1_select_requirement_code_field, data[4]);
					click(Constants.tr1_select_requirement_code_filter);
					click(Constants.inspection_label);
					email(data[1]);
					select(Constants.tr1_license_type, data[2]);
					type(Constants.tr1_agency_number, data[3]);
					//keyPressTab(Constants.tr1_agency_number);
					wait(2);
					if (count(Constants.green_valid_label) > 0) {
						click(Constants.tr1_save_progress_inspection_button);
						waitInvisible(Constants.tr1_save_progress_inspection_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification,
								TEXT_PROPERTIES.getProperty("inspection_requirements_updated"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
						break;
					} else {
						i--;
						click(Constants.global_cancel_button);
					}
				}
//			}
		}
	}
	public void specialInspectionPlumbingNew(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectionPlumbingNew");
			filterJob(user);
			test = rep.startTest("TR1 specialInspectionPlumbingNew");
			test.log(LogStatus.INFO, " specialInspectionPlumbingNew");
			clickAndWait(Constants.tr1_technical_report_step, Constants.tr1_are_you_special_inspector);
			check(Constants.tr1_are_you_special_inspector);
//			if (count(Constants.edit_icon) > 0) {
				for (int i = 1; i < 5; i++) {
					waitVisible("//span[text()='Requirement']");
					multiClick("//span[contains(text(),'Special Inspection Categories For New Work')]/following::span[text()='Add']");
					click(Constants.tr1_select_requirement_code);
					type(Constants.tr1_select_requirement_code_field, data[4]);
					click(Constants.tr1_select_requirement_code_filter);
					click(Constants.inspection_label);
					email(data[1]);
					select(Constants.tr1_license_type, data[2]);
					type(Constants.tr1_agency_number, data[3]);
					//keyPressTab(Constants.tr1_agency_number);
					wait(2);
					if (count(Constants.green_valid_label) > 0) {
						click(Constants.tr1_save_progress_inspection_button);
						waitInvisible(Constants.tr1_save_progress_inspection_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification,
								TEXT_PROPERTIES.getProperty("inspection_requirements_updated"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
						break;
					} else {
						i--;
						click(Constants.global_cancel_button);
					}
				}
//			}
		}
	}
	public void specialInspectionPlumbingLegalization(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectionPlumbingLegalization");
			filterJob(user);
			test = rep.startTest("TR1 specialInspectionPlumbingLegalization");
			test.log(LogStatus.INFO, " specialInspectionPlumbingLegalization");
			clickAndWait(Constants.tr1_technical_report_step, Constants.tr1_are_you_special_inspector);
			check(Constants.tr1_are_you_special_inspector);
//			if (count(Constants.edit_icon) > 0) {
				for (int i = 1; i < 5; i++) {
					waitVisible("//span[text()='Requirement']");
					multiClick("//span[contains(text(),'Special Inspection Categories For Legalization')]/following::span[text()='Add']");
					click(Constants.tr1_select_requirement_code);
					type(Constants.tr1_select_requirement_code_field, data[4]);
					click(Constants.tr1_select_requirement_code_filter);
					click(Constants.inspection_label);
					email(data[1]);
					select(Constants.tr1_license_type, data[2]);
					type(Constants.tr1_agency_number, data[3]);
					//keyPressTab(Constants.tr1_agency_number);
					wait(2);
					if (count(Constants.green_valid_label) > 0) {
						click(Constants.tr1_save_progress_inspection_button);
						waitInvisible(Constants.tr1_save_progress_inspection_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification,
								TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
						break;
					} else {
						i--;
						click(Constants.global_cancel_button);
					}
				}
//			}
		}
	}
	public void specialInspectionPlumbing(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectionPlumbing");
			filterJob(user);
			test = rep.startTest("TR1 Inspection");
			test.log(LogStatus.INFO, " specialInspectionPlumbing");
			clickAndWait(Constants.tr1_technical_report_step, Constants.tr1_are_you_special_inspector);
			check(Constants.tr1_are_you_special_inspector);
			if (count(Constants.edit_icon) > 0) {
				// wait(22);
				for (int i = 1; i <= count(Constants.edit_icon); i++) {
					test.log(LogStatus.INFO, " specialInspectionPlumbing");
					click("(//i[@class='fa fa-edit'])[" + i + "]");
					click(Constants.inspection_label);
					email(data[1]);
					select(Constants.tr1_license_type, data[2]);
					type(Constants.tr1_agency_number, data[3]);
					//keyPressTab(Constants.tr1_agency_number);
					wait(2);
					if (count(Constants.green_valid_label) > 0) {
						click(Constants.tr1_save_progress_inspection_button);
						waitInvisible(Constants.tr1_save_progress_inspection_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification,
								TEXT_PROPERTIES.getProperty("inspection_requirements_updated"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
					} else {
						i--;
						click(Constants.global_cancel_button);
					}
				}
			} else {
				if (count("//span[contains(text(),'Legalization')]") > 0)
					add_button = "(//*[text()='Add'])[last()]";
				if (count("//span[contains(text(),'New Work')]") > 0)
					add_button = "//*[text()='Add']";
				for (int i = 1; i < 5; i++) {
					waitVisible("//span[text()='Requirement']");
					multiClick(add_button);
					click(Constants.tr1_select_requirement_code);
					type(Constants.tr1_select_requirement_code_field, data[4]);
					click(Constants.tr1_select_requirement_code_filter);
					click(Constants.inspection_label);
					email(data[1]);
					select(Constants.tr1_license_type, data[2]);
					type(Constants.tr1_agency_number, data[3]);
					//keyPressTab(Constants.tr1_agency_number);
					wait(2);
					if (count(Constants.green_valid_label) > 0) {
						click(Constants.tr1_save_progress_inspection_button);
						waitInvisible(Constants.tr1_save_progress_inspection_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification,
								TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
						break;
					} else {
						i--;
						click(Constants.global_cancel_button);
					}
				}
				if (Integer.valueOf(data[0]) > 1) {
					for (int a = 1; a < 5; a++) {
						add_button = "(//*[text()='Add'])[2]";
						waitVisible("//span[text()='Requirement']");
						multiClick(add_button);
						click(Constants.tr1_select_requirement_code);
						send(Constants.tr1_select_requirement_code_field, data[4]);
						click(Constants.tr1_select_requirement_code_filter);
						click(Constants.inspection_label);
						email(data[1]);
						select(Constants.tr1_license_type, data[2]);
						type(Constants.tr1_agency_number, data[3]);
						//keyPressTab(Constants.tr1_agency_number);
						wait(2);
						if (count(Constants.green_valid_label) > 0) {
							click(Constants.tr1_save_progress_inspection_button);
							waitInvisible(Constants.tr1_save_progress_inspection_button);
							waitUntilISpinnersInvisible();
							waitVisible(Constants.ok_button);
							verifyNotification(Constants.notification,
									TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
							clickButton("OK");
							waitInvisible(Constants.ok_button);
							break;
						} else {
							a--;
							click(Constants.global_cancel_button);
						}
					}

				}
			}
			reportPass("Success");
		}
	}

	public void progressInspecSign(String tr1) {
		if (!tr1.equals("")) {
			
			System.out.println(convertedTimestamp() + " **************** TR1 progressInspecSign");
			for (int i = 1; i < 100; i++) {
				String[] data = tr1.split(" :: ");
				filterJob(data[1]);
				test = rep.startTest("TR1 progressInspecSign");
				click(Constants.tr1_technical_report_step);
//				check(Constants.tr1_are_you_special_inspector);
				check(Constants.tr1_are_you_progress_inspector);
				for (int a = 1; a <= 5; a++) {
					wait(2);
					click("(//i[@class='fa fa-edit'])[last()]");
					waitVisible("//h4[text()='Progress Inspection Category']");
					email(data[1]);
					select(Constants.tr1_license_type, data[2]);
					check(Constants.tr1_i_take_responcibility);
					check(Constants.tr1_i_understand_my_failure_to_file);
					check(Constants.tr1_i_understand_and_agree);
					if (getElement(Constants.tr1_i_take_responcibility).isSelected()) {
						if (getElement(Constants.tr1_i_understand_my_failure_to_file).isSelected()) {
							if (getElement(Constants.tr1_i_understand_and_agree).isSelected()) {
								break;
							}
						}
					} else
						click(Constants.global_cancel_button);
				}
				click(Constants.global_save_form_button);
				waitInvisible(Constants.global_save_form_button);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_updated"));
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				if (count(Constants.identified_yes_label) > 1)
					break;
			}
			if(count(Constants.upload_document_icon) > 0) {
				click(Constants.upload_document_icon);
				send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
				click(Constants.tr1_upload_button);
				waitInvisible(Constants.tr1_please_wait_message);
				waitVisible(Constants.tr1_upload_succesfull_message);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				clickButton("OK");
				waitInvisible(Constants.ok_button);
			}
			reportPass("Success");
		}
	}

			
			
	public void progressInspection(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 progressInspection");
			filterJob(user);
			test = rep.startTest("TR1 progressInspection");
			click(Constants.tr1_technical_report_step);
/*			check(Constants.tr1_are_you_special_inspector);
			check(Constants.tr1_are_you_progress_inspector);*/
//			for (int i = 1; i < 5; i++) {
				click("(//*[text()='Add'])[last()]");
				click(Constants.select_dropdown);
				type(Constants.tr1_select_requirement_code_field, data[0]);
				click(Constants.tr1_select_requirement_code_filter);
				click(Constants.inspection_label);
//				multiClick("//input[@id='txtInspecterEmail']");
				waitClickableOr("//input[@id='txtInspecterEmail']", "(//input[@id='txtInspecterEmail'])[last()]");
				try {
					driver.findElement(By.xpath("//input[@id='txtInspecterEmail']")).sendKeys(data[1]);
					wait(2);
					if (count("//strong[text()='" + data[1] + "']") > 0)
						doubleclick("//strong[text()='" + data[1] + "']");
				} catch (Exception e) {
					driver.findElement(By.xpath("(//input[@id='txtInspecterEmail'])[last()]")).sendKeys(data[1]);
					wait(2);
					if (count("//strong[text()='" + data[1] + "']") > 0)
						doubleclick("//strong[text()='" + data[1] + "']");
				}
/*				wait(2);
//				System.out.println(text("(//input[@id='txtInspecterEmail'])[last()]"));
				System.out.println(text("//input[@id='txtInspecterEmail']"));
				if (text("//input[@id='txtInspecterEmail']").contains(user))
					break;
				else
					click(Constants.global_cancel_button);*/
//			}
			click(Constants.tr1_save_progress_inspection_button);
			waitInvisible(Constants.tr1_save_progress_inspection_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			check(Constants.tr1_are_you_progress_inspector);
			for (int a = 1; a <= 5; a++) {
				click("(//i[@class='fa fa-edit'])[last()]");
				waitVisible("//h4[text()='Progress Inspection Category']");
				email(tr1_user);
				select(Constants.tr1_license_type, tr1_lic);
				check(Constants.tr1_i_take_responcibility);
				check(Constants.tr1_i_understand_my_failure_to_file);
				check(Constants.tr1_i_understand_and_agree);
				if (getElement(Constants.tr1_i_take_responcibility).isSelected()) {
					if (getElement(Constants.tr1_i_understand_my_failure_to_file).isSelected()) {
						if (getElement(Constants.tr1_i_understand_and_agree).isSelected()) {
							break;
						}
					}
				} else
					click(Constants.global_cancel_button);
			}
			
			reportPass("Success");
		}
	}	
	
	public void progressInspectionSign(String progress_inspector_sign_upload) {
		if (!progress_inspector_sign_upload.equals("")) {
			System.out.println(convertedTimestamp() + " **************** TR1 progressInspectionSign");
			for (int i = 1; i < 100; i++) {
				filterJob(tr1_user);
				test = rep.startTest("TR1 progressInspectionSign");
				click(Constants.tr1_technical_report_step);
				check(Constants.tr1_are_you_special_inspector);
				check(Constants.tr1_are_you_progress_inspector);
				for (int a = 1; a <= 5; a++) {
					click("(//i[@class='fa fa-edit'])[last()]");
					waitVisible("//h4[text()='Progress Inspection Category']");
					email(OR_PROPERTIES.getProperty("progress_inspector_email"));
					select(Constants.tr1_license_type, OR_PROPERTIES.getProperty("progress_inspector_lisence"));
					check(Constants.tr1_i_take_responcibility);
					check(Constants.tr1_i_understand_my_failure_to_file);
					check(Constants.tr1_i_understand_and_agree);
					if (getElement(Constants.tr1_i_take_responcibility).isSelected()) {
						if (getElement(Constants.tr1_i_understand_my_failure_to_file).isSelected()) {
							if (getElement(Constants.tr1_i_understand_and_agree).isSelected()) {
								break;
							}
						}
					} else
						click(Constants.global_cancel_button);
				}
				click(Constants.global_save_form_button);
				waitInvisible(Constants.global_save_form_button);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_updated"));
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				if (count(Constants.identified_yes_label) > 1)
					break;
			}
			click(Constants.upload_document_icon);
			send(Constants.tr1_browse_button, Constants.uploadFolder + progress_inspector_sign_upload);
			click(Constants.tr1_upload_button);
			waitInvisible(Constants.tr1_please_wait_message);
			waitVisible(Constants.tr1_upload_succesfull_message);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			clickButton("OK");
			waitInvisible(Constants.ok_button);

		}
		reportPass("Success");
	}
	
	public void specialInspectorSignaturePlumbing(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectorSignaturePlumbing");
			filterJob(data[1]);
			test = rep.startTest("TR1 specialInspectorSignaturePlumbing");
			click(Constants.tr1_technical_report_step);
			waitVisible(Constants.tr1_are_you_special_inspector);
			waitVisible(Constants.tr1_are_you_progress_inspector);
			check(Constants.tr1_are_you_special_inspector);
			check(Constants.tr1_are_you_progress_inspector);
			wait(3);
			for (int i = 1; i <= 20; i++) {
				test.log(LogStatus.INFO, " specialInspectorSignaturePlumbing");
				click("(//i[@class='fa fa-edit'])[" + i + "]");
				wait(2);
				waitVisible(Constants.tr1_valid_label);
				check(Constants.tr1_i_take_responcibility);
				check(Constants.tr1_i_understand_my_failure_to_file);
				check(Constants.tr1_i_understand_and_agree);
				click(Constants.tr1_save_progress_inspection_button);
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_updated"));
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				waitInvisible(Constants.tr1_save_progress_inspection_button);
				wait(2);
				if (count(Constants.identified_yes_label) >= Integer.valueOf(data[0]))
					break;
			}
			for (int i = 1; i <= 10; i++) {
				if (count("//span[text()='Required']") > 0) {
					click("//span[text()='Required']");
					waitVisible(Constants.tr1_browse_button);
					send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
					click(Constants.tr1_upload_button);
					waitInvisible(Constants.tr1_please_wait_message);
					waitVisible(Constants.tr1_upload_succesfull_message);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}
			}
		}
		reportPass("specialInspectorSignaturePlumbing");
	}


}