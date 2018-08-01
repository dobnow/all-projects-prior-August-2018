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

public class CrmTR1Page extends TestBase {
	WebDriver driver;

/*	public CrmTR1Page(WebDriver dr) {
		driver = dr;
	}*/

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
	
	public void crmTechnicalReport(String user_name,	String accept_tr) {
		if (!accept_tr.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** " + data[0] + " crmTechnicalReport");
			loginToCrm(data[0]);
			searchForJobCrm();
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			driver.switchTo().frame("contentIFrame0");
//			waitUntilElementVisible(Constants.label_job_filing, 30);
			for (int i=1; i < 20; i++) {
				click(Constants.job_filing_link);
				waitInvisible(Constants.job_filing_link);
				if (count(Constants.job_filing_link) < 1) 
					break;
			}	
			ifAlertExistAccept();
			waitVisible(Constants.qa_admin_application_highlights_label);
			waitVisible(Constants.qa_admin_tr1_tab);
			for (int i = 1; i <= 20; i++) {
				click(Constants.qa_admin_tr1_tab);
				wait(5);
/*				if (count(Constants.public_assembly_emergency_lighting) > 0)
					break;*/				
				if (driver.findElement(By.xpath(Constants.public_assembly_emergency_lighting)).isDisplayed() == true)
					break;
				refreshPage();
				driver.switchTo().frame("contentIFrame0");
			}
			waitVisible(Constants.public_assembly_emergency_lighting);
//			actionClick(Constants.public_assembly_emergency_lighting);
			WebElement public_assembly_emergency_lighting = driver.findElement(By.xpath(Constants.public_assembly_emergency_lighting));
			new Actions(driver).contextClick(public_assembly_emergency_lighting).build().perform();
			wait(1);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			waitUntilElementVisible(Constants.qa_admin_progress_inspector_seal_signature, 30);
			viewAcceptDocs();
		}
	}

	public void viewAcceptTR1Fuel(String user_name,	String accept_tr) {
		if (!accept_tr.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** " + data[0] + " View accept FUEL OIL");
			loginToCrm(data[0]);
			searchForJobCrm();
			driver.switchTo().frame("contentIFrame0");
//			waitUntilElementVisible(Constants.label_job_filing, 30);
			for (int i=1; i < 20; i++) {
				click(Constants.label_job_filing);
				waitInvisible(Constants.label_job_filing);
				if (count(Constants.label_job_filing) < 1) 
					break;
			}	
			ifAlertExistAccept();
			waitInvisible(Constants.label_job_filing);
			waitVisible(Constants.qa_admin_application_highlights_label);
			waitVisible(Constants.qa_admin_tr1_tab);
			for (int i = 1; i <= 20; i++) {
				click(Constants.qa_admin_tr1_tab);
				wait(5);
				if (driver.findElement(By.xpath(Constants.qa_admin_fuel_oil_document)).isDisplayed() == true)
					break;
				refreshPage();
				driver.switchTo().frame("contentIFrame0");
			}
			waitVisible(Constants.qa_admin_fuel_oil_document);
			new Actions(driver).contextClick(qa_admin_fuel_oil_document).build().perform();
			wait(1);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			waitUntilElementVisible(Constants.qa_admin_special_inspector_seal_signature, 30);
			viewAcceptDocs();
		}
	}
	
	public void viewAcceptTR1Fina(String user_name, String accept_tr) {
		if (!accept_tr.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** " + data[0] + " View accept Final");
			loginToCrm(data[0]);
			searchForJobCrm();
			driver.switchTo().frame("contentIFrame0");
			for (int i=1; i < 20; i++) {
				click(Constants.label_job_filing);
				waitInvisible(Constants.label_job_filing);
				if (count(Constants.label_job_filing) < 1) 
					break;
			}			
			ifAlertExistAccept();
			waitInvisible(Constants.label_job_filing);
			waitUntilElementVisible(Constants.qa_admin_tr1_tab, 60);
			for (int i = 1; i <= 20; i++) {
				click(Constants.qa_admin_tr1_tab);
				wait(5);
				if (driver.findElement(By.xpath(Constants.qa_admin_final_document)).isDisplayed() == true)
					break;
				refreshPage();
				driver.switchTo().frame("contentIFrame0");
			}
			waitVisible(Constants.qa_admin_final_document);
			new Actions(driver).contextClick(qa_admin_final_document).build().perform();
			wait(1);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			waitVisible(Constants.qa_admin_progress_inspector_seal_signature);
			viewAcceptDocs();
		}
	}
	public void viewAcceptTR1Plumbing(String tr_docs) {
		if (!tr_docs.equals("")) {
			String[] data = tr_docs.split(" :: ");
			int num_of_docs = Integer.valueOf(data[3]); // Number of documents to upload
			System.out.println(convertedTimestamp() + " **************** " + data[0] + " viewAcceptTR1Plumbing");
			loginToCrm(data[0]);
			searchForJobCrm();
			driver.switchTo().frame("contentIFrame0");
			waitVisible(Constants.label_job_filing);
			for (int i=1; i < 5; i++) {
				if(i > num_of_docs)
					break;
				while(count(Constants.label_job_filing) > 0) {
					clickAndWait(Constants.label_job_filing, Constants.qa_admin_application_highlights_label);
				}
			ifAlertExistAccept();
			waitVisible(Constants.qa_admin_application_highlights_label);
			waitVisible(Constants.qa_admin_tr1_tab);
			//waitUntilElementVisible(Constants.qa_admin_work_on_floors_document, 30);
			click(Constants.qa_admin_tr1_tab);
			waitVisible("//span[text()='" +data[i]+ "']");
			new Actions(driver).contextClick(getElement("//span[text()='" +data[i]+ "']")).build().perform();
			wait(1);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			waitForPageToLoad();
			wait(2);
			waitVisible(Constants.required_documents_label_tr1);
			viewAcceptDocs();
			driver.switchTo().frame("contentIFrame0");
			}
		}
	}
}