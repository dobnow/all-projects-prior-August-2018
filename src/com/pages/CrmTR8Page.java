package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.base.TestBase;
import com.util.Constants;

public class CrmTR8Page extends TestBase {
	WebDriver driver;

	public CrmTR8Page(WebDriver dr) {
		driver = dr;
	}

	@FindBy(xpath = Constants.cpe_search_job_button)
	public WebElement cpe_search_job_button;
	@FindBy(xpath = Constants.pe_search_job_button)
	public WebElement pe_search_job_button;

	@FindBy(xpath = Constants.crm_top_nav_search_button)
	public WebElement crm_top_nav_search_button;
	@FindBy(xpath = Constants.submit_work_type_button)
	public WebElement submit_work_type_button;
	@FindBy(xpath = Constants.filtered_job)
	public WebElement filtered_job;
	@FindBy(xpath = Constants.job_number_search)
	public WebElement job_number_search;
	@FindBy(xpath = Constants.search_for_records_one)
	public WebElement search_for_records_one;
	@FindBy(xpath = Constants.search_for_records_one_field)
	public WebElement search_for_records_one_field;
	@FindBy(xpath = Constants.search_for_records_one_image)
	public WebElement search_for_records_one_image;

	@FindBy(xpath = Constants.cpe_tasks_search_job)
	public WebElement cpe_tasks_search_job;
	@FindBy(xpath = Constants.cpe_tasks_search_job_field)
	public WebElement cpe_tasks_search_job_field;
	@FindBy(xpath = Constants.pe_tasks_search_job)
	public WebElement pe_tasks_search_job;
	@FindBy(xpath = Constants.pe_tasks_search_job_field)
	public WebElement pe_tasks_search_job_field;
	@FindBy(xpath = Constants.qa_super_tasks_search_job)
	public WebElement qa_super_tasks_search_job;
	@FindBy(xpath = Constants.qa_super_tasks_search_job_field)
	public WebElement qa_super_tasks_search_job_field;
	@FindBy(xpath = Constants.qa_super_search_job_button)
	public WebElement qa_super_search_job_button;
	@FindBy(xpath = Constants.qa_admin_tasks_search_job)
	public WebElement qa_admin_tasks_search_job;
	@FindBy(xpath = Constants.qa_admin_tasks_search_job_field)
	public WebElement qa_admin_tasks_search_job_field;
	@FindBy(xpath = Constants.qa_admin_search_job_button)
	public WebElement qa_admin_search_job_button;

	@FindBy(xpath = Constants.qa_super_job_subject)
	public WebElement qa_super_job_subject;
	@FindBy(xpath = Constants.prof_sert_qa_super_job_subject)
	public WebElement prof_sert_qa_super_job_subject;

	@FindBy(xpath = Constants.search_results_job_subject)
	public WebElement search_results_job_subject;
	@FindBy(xpath = Constants.qa_admin_job_subject)
	public WebElement qa_admin_job_subject;
	@FindBy(xpath = Constants.qa_administrator_search_button)
	public WebElement qa_administrator_search_button;

	@FindBy(xpath = Constants.job_search_input_box)
	public WebElement job_search_input_box;
	@FindBy(xpath = Constants.search_button)
	public WebElement search_button;
	@FindBy(xpath = Constants.actions_dropdown)
	public WebElement actions_dropdown;
	@FindBy(xpath = Constants.appoitment_required)
	public WebElement appoitment_required;
	@FindBy(xpath = Constants.option_yes)
	public WebElement option_yes;
	@FindBy(xpath = Constants.option_no)
	public WebElement option_no;
	@FindBy(xpath = Constants.qa_action)
	public WebElement qa_action;
	@FindBy(xpath = Constants.option_permit_issued)
	public WebElement option_permit_issued;
	@FindBy(xpath = Constants.label_job_filing)
	public WebElement label_job_filing;
	@FindBy(xpath = Constants.qa_admin_tr1_tab)
	public WebElement qa_admin_tr1_tab;
	@FindBy(xpath = Constants.qa_admin_tr8_tab)
	public WebElement qa_admin_tr8_tab;
	@FindBy(xpath = Constants.qa_admin_antenna_pw2_tab)
	public WebElement qa_admin_antenna_pw2_tab;
	@FindBy(xpath = Constants.qa_admin_documents_tab)
	public WebElement qa_admin_documents_tab;
/*	@FindBy(xpath = Constants.qa_admin_work_on_floors_document)
	public WebElement qa_admin_work_on_floors_document;*/

	@FindBy(xpath = Constants.qa_admin_fuel_oil_document)
	public WebElement qa_admin_fuel_oil_document;
	@FindBy(xpath = Constants.qa_admin_electrical_energy_document)
	public WebElement qa_admin_electrical_energy_document;
	@FindBy(xpath = Constants.qa_admin_final_document)
	public WebElement qa_admin_final_document;
	@FindBy(xpath = Constants.qa_admin_permit_not_yet_issued)
	public WebElement qa_admin_permit_not_yet_issued;
	@FindBy(xpath = Constants.qa_admin_certificate_of_insurance_document)
	public WebElement qa_admin_certificate_of_insurance_document;
	@FindBy(xpath = Constants.seal_and_signature)
	public WebElement seal_and_signature;

	@FindBy(xpath = Constants.qa_admin_special_inspector_seal_signature)
	public WebElement qa_admin_special_inspector_seal_signature;
	@FindBy(xpath = Constants.qa_admin_progress_inspector_seal_signature)
	public WebElement qa_admin_progress_inspector_seal_signature;

	@FindBy(xpath = Constants.pe_action)
	public WebElement pe_action;
	@FindBy(xpath = Constants.pe_action_approved)
	public WebElement pe_action_approved;
	@FindBy(xpath = Constants.approved_plan_uploaded)
	public WebElement approved_plan_uploaded;
	@FindBy(xpath = Constants.approved_plan_uploaded_yes)
	public WebElement approved_plan_uploaded_yes;

	@FindBy(xpath = Constants.total_number_of_documents)
	public WebElement total_number_of_documents;
	@FindBy(xpath = Constants.load_next_page_image)
	public WebElement load_next_page_image;
	@FindBy(xpath = Constants.view_document_button)
	public WebElement view_document_button;
	@FindBy(xpath = Constants.accept_document_button)
	public WebElement accept_document_button;
	@FindBy(xpath = Constants.assign_to_plan_examiner)
	public WebElement assign_to_plan_examiner;
	@FindBy(xpath = Constants.assign_to_qa_administrator)
	public WebElement assign_to_qa_administrator;
	@FindBy(xpath = Constants.assign_to_qa_administrator_field)
	public WebElement assign_to_qa_administrator_field;
	@FindBy(xpath = Constants.select_qa_administrator)
	public WebElement select_qa_administrator;

	@FindBy(xpath = Constants.plan_examiner_text_field)
	public WebElement plan_examiner_text_field;
	@FindBy(xpath = Constants.plan_examiner_search_button)
	public WebElement plan_examiner_search_button;
	@FindBy(xpath = Constants.select_examiner)
	public WebElement select_examiner;
	@FindBy(xpath = Constants.comments_textbox)
	public WebElement comments_textbox;
	@FindBy(xpath = Constants.submit_button)
	public WebElement submit_button;

	@FindBy(xpath = Constants.global_save_step_button)
	public WebElement global_save_step_button;
	@FindBy(xpath = Constants.global_notification_ok_button)
	public WebElement global_notification_ok_button;
	@FindBy(xpath = Constants.global_loading_spinner)
	public WebElement global_loading_spinner;

	public void XviewAcceptTR8ProgressInspection(String user_name, String assert_filing_status, String work_type,
			String accept_tr) {
		if (!accept_tr.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** " + data[0] + " View accept ENERGY");
			loginToCrm(data[0]);
			searchForJobCrm();
			driver.switchTo().frame("contentIFrame0");
			waitUntilElementVisible(Constants.label_job_filing, 30);
			for (int i=1; i < 20; i++) {
				label_job_filing.click();
				wait(2);
				if (count(Constants.label_job_filing) < 1) 
					break;
			}			
			ifAlertExistAccept();
			waitInvisible(Constants.label_job_filing);
			waitVisible(Constants.qa_admin_application_highlights_label);
			waitUntilElementVisible(Constants.qa_admin_tr8_tab, 60);
			for (int i = 1; i <= 20; i++) {
				click(Constants.qa_admin_tr8_tab);
				wait(5);
				if (driver.findElement(By.xpath(Constants.qa_admin_electrical_energy_document)).isDisplayed() == true)
					break;
				refreshPage();
				driver.switchTo().frame("contentIFrame0");
			}
			waitVisible(Constants.qa_admin_electrical_energy_document);
			new Actions(driver).contextClick(qa_admin_electrical_energy_document).build().perform();
			wait(1);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			waitUntilElementVisible(Constants.qa_admin_progress_inspector_seal_signature, 30);
			new Actions(driver).contextClick(qa_admin_progress_inspector_seal_signature).build().perform();
			wait(1);
			viewAcceptDoc(1);
			wait(1);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			waitTime(3000L);
			driver.switchTo().defaultContent();
			
			wait(3);
			while(driver.getWindowHandles().size() < 2) {
			waitUntilElementVisible(Constants.view_document_button, 30);
			view_document_button.click();
			wait(5);
			}
			ArrayList<String> tabs_final = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs_final.get(1));
			driver.close();
			driver.switchTo().window(tabs_final.get(0));
			driver.switchTo().defaultContent();
			waitVisible(Constants.crm_save_button);
			click(Constants.crm_save_button);
			waitUntilElementVisible(Constants.accept_document_button, 30);
			accept_document_button.click();
			ifAlertExistAccept();
		}
	}
	
	public void viewAcceptTR8PDocs(String user_name, String accept_tr) {
		if (!accept_tr.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** " + data[0] + " View accept Energy");
			loginToCrm(data[0]);
			searchForJobCrm();
			driver.switchTo().frame("contentIFrame0");
			waitUntilElementVisible(Constants.label_job_filing, 30);
			for (int i=1; i < 20; i++) {
				click(Constants.label_job_filing);
				wait(2);
				if (count(Constants.label_job_filing) < 1) 
					break;
			}			
			ifAlertExistAccept();
			waitInvisible(Constants.label_job_filing);
			waitVisible(Constants.qa_admin_application_highlights_label);
			waitVisible(Constants.qa_admin_tr8_tab);
			for (int i = 1; i <= 20; i++) {
				click(Constants.qa_admin_tr8_tab);
				wait(5);
				if (count(Constants.qa_admin_electrical_energy_document) > 0)
					break;
				refreshPage();
				driver.switchTo().frame("contentIFrame0");
			}
			waitVisible(Constants.qa_admin_electrical_energy_document);
			new Actions(driver).contextClick(qa_admin_electrical_energy_document).build().perform();
			wait(1);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			waitForPageToLoad();
			wait(2);
			waitVisible(Constants.required_documents_label_tr8);
			viewAcceptDocs();
		}
	}
}