package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.util.Constants;
import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class CrmTaskFormPage extends TestBase {
/*	WebDriver driver;

	public CrmTaskFormPage(WebDriver dr) {
		driver = dr;
	}*/

	@FindBy(xpath = Constants.search_for_records_one_field)
	public WebElement search_for_records_one_field;
	@FindBy(xpath = Constants.search_for_records_one_image)
	public WebElement search_for_records_one_image;
	@FindBy(xpath = Constants.cpe_tasks_search_job)
	public WebElement cpe_tasks_search_job;
	@FindBy(xpath = Constants.cpe_tasks_search_job_field)
	public WebElement cpe_tasks_search_job_field;
	@FindBy(xpath = Constants.cpe_job_app_complte_label)
	public WebElement cpe_job_app_complte_label;
	@FindBy(xpath = Constants.cpe_job_application_complete_yes)
	public WebElement cpe_job_application_complete_yes;
	@FindBy(xpath = Constants.cpe_job_application_complete_no)
	public WebElement cpe_job_application_complete_no;
	@FindBy(xpath = Constants.cpe_description_section)
	public WebElement cpe_description_section;
	@FindBy(xpath = Constants.cpe_description)
	public WebElement cpe_description;
	@FindBy(xpath = Constants.add_objection_image)
	public WebElement add_objection_image;
	@FindBy(xpath = Constants.crm_comments_area)
	public WebElement crm_comments_area;
	@FindBy(xpath = Constants.crm_comments_box)
	public WebElement crm_comments_box;
	
	@FindBy(xpath = Constants.ahv_task_link)
	public WebElement ahv_task_link;

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
	@FindBy(xpath = Constants.option_qa_failed)
	public WebElement option_qa_failed;
	
	@FindBy(xpath = Constants.search_objection_field)
	public WebElement search_objection_field;
/*	@FindBy(xpath = Constants.add_objection_image)
	public WebElement add_objection_image;*/
	@FindBy(xpath = Constants.select_a_value_image)
	public WebElement select_a_value_image;
	@FindBy(xpath = Constants.first_objection)
	public WebElement first_objection;
	@FindBy(xpath = Constants.save_objection_button)
	public WebElement save_objection_button;
	
	@FindBy(xpath = Constants.cpe_action)
	public WebElement cpe_action;
	@FindBy(xpath = Constants.objections_action)
	public WebElement objections_action;
	
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
	@FindBy(xpath = Constants.pe_action_objections)
	public WebElement pe_action_objections;
	@FindBy(xpath = Constants.crm_job_description)
	public WebElement crm_job_description;
	
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

	public static int number_of_documents;
	public static String action_label;

	public void  selectDashboard(String user){
		if (!user.equals("")) {
			System.out.println(convertedTimestamp() + " **************** selectDashboard " +user);
			loginToCrm(user);
			setWindowfocus();
			waitForPageToLoad();
			waitVisible(Constants.crm_top_nav_search_button);
			click(Constants.select_dashboard_arrow);
			click(Constants.pe_dashboard);
		}		
	}
	
	
	
	// 007 ASSIGN TO TEAM
	public void centralAssigner(String cpe_acpe) {
		if (!cpe_acpe.equals("")) {
			String[] data = cpe_acpe.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** centralAssigner ----- " + data[0]+ " Assign to " +data[1]);
			for (int i = 1; i <= 5; i++) {
				loginToCrm(data[0]);
				searchForJobCrm();
				test = rep.startTest(data[0]+ " Assign to " +data[1]);
				test.log(LogStatus.INFO, data[0]+ " Assign to " +data[1]);
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
//				scrollTo(Constants.span_text + "Parent Team" + Constants.close_xpath);
				scrollTo(Constants.cpe_acpe_actions_field);
				click(Constants.cpe_acpe_actions_field);
				click(Constants.cpe_acpe_find_team_image);
				click(Constants.span_text +data[1]+ Constants.close_xpath);
				ifAlertExistAccept();
				driver.switchTo().defaultContent();
				click(Constants.submit_button);
				ifAlertExistAccept();
				waitInvisible(Constants.submit_button);
				driver.switchTo().frame("contentIFrame0");
				ifAlertExistAccept();
				if (count(Constants.crm_completed_message) > 0) {
					reportPass("centralAssigner");
					break;
				}
			}
		}
	}
	
	// 021 ACTION		
	public void cpeActions(String cpe) {
		if (!cpe.equals("")) {
			String[] data = cpe.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** cpeActions " +data[0]+ " Assign to "+data[2]+ " " +data[3]);
			for (int i = 1; i <= 10; i++) {
				loginToCrm(data[0]);
				searchForJobCrm();
				test = rep.startTest(data[0]+ " Assign to " +data[2]+ " " +data[3]);
				test.log(LogStatus.INFO, " " +data[0]+ " Assign to " +data[2]+ " " +data[3]);
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				waitVisible(Constants.is_the_job_application_complete_list);
				scrollToElement(Constants.is_the_job_application_complete_list);
				click(Constants.is_the_job_application_complete_list);
				select(Constants.is_the_job_application_complete_select, data[1]);
				ifAlertExistAccept();
				if (cpe.contains("Yes")) { // Yes == "Is the Job Application Complete ?"
					click(Constants.cpe_acpe_primary_pe_field);
					click(Constants.cpe_acpe_find_primary_pe_image);
					doubleclick(Constants.span_text +data[2]+ Constants.close_xpath); // select Primary PE
//					doubleclick("//span[text()='Assign to Primary Plan Examiner']/following::span[text()='" +data[2]+ Constants.close_xpath);
					ifAlertExistAccept();
					if (!data[3].equals("null")) {
						click(Constants.cpe_acpe_secondary_pe_field);
						click(Constants.cpe_acpe_find_secondary_pe_image);
						doubleclick("(" +Constants.span_text +data[3]+ Constants.close_xpath+ ")[2]"); // select Secondary PE
					}
//						doubleclick("//span[text()='Assign to Secondary Plan Examiner']/following::span[text()='" +data[3]+ Constants.close_xpath);
					ifAlertExistAccept();
				}
				driver.switchTo().defaultContent();
				click(Constants.submit_button);
				ifAlertExistAccept();
				waitInvisible(Constants.submit_button);
				driver.switchTo().frame("contentIFrame0");
				ifAlertExistAccept();
				if (count(Constants.crm_completed_message) > 0) {
					reportPass("cpeAssign");
					break;
				}
			}
		}
	}
	
	public void primaryPeAction(String action) {
		if (!action.equals("")) {
			String[] data = action.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** primaryPeAction " +action);
			for (int i = 1; i <= 10; i++) {
				loginToCrm(data[0]);
				searchForJobCrm();
				waitForPageToLoad();
				test = rep.startTest("primaryPeAction " +action);
				driver.switchTo().frame("contentIFrame0");
				waitVisible(Constants.appoitment_required_list);
				scrollToElement(Constants.appoitment_required_list);
				click(Constants.appoitment_required_list);
				select(Constants.apt_required, data[1]);
				ifAlertExistAccept();
				click(Constants.plan_examiner_action_list);
				select(Constants.job_approved, data[2]);
				ifAlertExistAccept();
				ifAlertExistAccept();
				click(Constants.approved_plans_uploaded_list);
				select(Constants.approved_plans_uploaded, data[3]);
				ifAlertExistAccept();
				click(Constants.crm_comments_area);
				wait(1);
				type(Constants.crm_comments_box, action);
				driver.switchTo().defaultContent();
				click(Constants.submit_button);
				ifAlertExistAccept();
				waitInvisible(Constants.submit_button);
				driver.switchTo().frame("contentIFrame0");
				if (count(Constants.crm_completed_message) > 0) {
					reportPass("peAction");
					break;
				}
			}
		}
	}
	
	
	public void XassignAvhToSelf(String qa_superviser_ahv) {
		if (!qa_superviser_ahv.equals("")) {
			String[] data = qa_superviser_ahv.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** " +data[0]+" assign to "+data[0]);
//			for (int i = 1; i <= 5; i++) {
				loginToCrm(data[0]);
				setWindowfocus();
				waitForPageToLoad();
				waitVisible(Constants.crm_top_nav_search_button);
				driver.switchTo().frame("contentIFrame0").switchTo().frame("dashboardFrame");
				
/*				click(Constants.search_for_records_one);
				type(Constants.search_for_records_one_field, "*" + JOB_NUMBER.getProperty("job_number").substring(2));
				click(Constants.search_for_records_one_image);*/
				
/*				click("//span[@class='ms-crm-View-Name ms-crm-ViewSelector-title-subGrid-lite ms-crm-TextAutoEllipsis']");
				click("(//span[@class='ms-crm-VS-MenuItem-Title ms-crm-VS-MenuItem-Title-Rest'])[2]");*/
				waitForPageToLoad();
				type(Constants.search_for_records_one_field, "*" +JOB_NUMBER.getProperty("job_number").substring(1));
				click(Constants.search_for_records_one_image);
				click(Constants.search_results_job_subject);
				ifAlertExistAccept();
				waitVisible(Constants.crm_top_nav_search_button);
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				scrollToElement(Constants.crm_comments_area);			
				click(Constants.crm_comments_area);
				wait(1);
				type(Constants.crm_comments_box,"assignAvhToSelf");
				click("//div[@jawsreadlabel='dobnyc_pendingqaahvaction_c']");
				select("//select[@id='dobnyc_pendingqaahvaction_i']", "Assign to Self");
				driver.switchTo().defaultContent();
				click(Constants.submit_button);
				ifAlertExistAccept();
				waitInvisible(Constants.submit_button);
				driver.switchTo().frame("contentIFrame0");
				waitInvisible(Constants.submit_button);
				ifAlertExistAccept();
/*				if (count(Constants.crm_completed_message) > 0)
					break;
			}*/
			// ASSERT STATUS
//			assertFilingStatus(TEXT_PROPERTIES.getProperty("permit_entire"));
		}
	}
	
	// Plan Examiner ACTION
	public void cpeAssignToSelfElv(String action) {
		if (!action.equals("")) {
			String[] data = action.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** cpeAssignToSelfElv");
			for (int i = 1; i <= 10; i++) {
				loginToCrm(data[0]);
				searchForJobCrm();
				test = rep.startTest("cpeAssignToSelfElv");
				test.log(LogStatus.INFO, action+" cpeAssignToSelf");
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				scrollToElement(Constants.action_cpe_action_list);
				click(Constants.action_cpe_action_list);
				select(Constants.action_cpe_action, "Assign to Self");
				ifAlertExistAccept();
				driver.switchTo().defaultContent();
				click(Constants.submit_button_elv);
				ifAlertExistAccept();
				waitInvisible(Constants.submit_button_elv);
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				ifAlertExistAccept();
				if (count(Constants.crm_completed_message) > 0) {
					reportPass("cpeAssignToSelfElv");
					break;
				}
			}
/*			filterJob(OR_PROPERTIES.getProperty("user_email"));
			assertFilingStatus(filing_status);*/
		}
	}
	public void assignToSelfAhv(String qa_superviser_ahv) {
		if (!qa_superviser_ahv.equals("")) {
			String[] data = qa_superviser_ahv.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** assignToSelfAhv " +data[0]+" "+data[1]);
//			for (int i = 1; i <= 5; i++) {
				loginToCrm(data[0]);
				setWindowfocus();
				waitForPageToLoad();
				waitVisible(Constants.crm_top_nav_search_button);
				driver.switchTo().frame("contentIFrame0").switchTo().frame("dashboardFrame");
				waitForPageToLoad();
				
				click(Constants.search_for_records_one);
				type(Constants.search_for_records_one_field, "*" + JOB_NUMBER.getProperty("job_number").substring(2));
				click(Constants.search_for_records_one_image);
//				waitVisible(Constants.search_results_job_subject);
				click(Constants.search_results_job_subject);
				waitInvisible(Constants.search_results_job_subject);
				waitForPageToLoad();
				wait(5);
				driver.switchTo().frame("contentIFrame0");
				waitVisible("//span[@class='ms-crm-InlineEditLabelText'][text()='Pending QA AHV action']");
				click("//div[@jawsreadlabel='dobnyc_pendingqaahvaction_c']");
				select("//select[@id='dobnyc_pendingqaahvaction_i']", data[1]);
				driver.switchTo().defaultContent();
				click(Constants.submit_button);
				ifAlertExistAccept();
				waitInvisible(Constants.submit_button);
				
				driver.switchTo().frame("contentIFrame0");
				ifAlertExistAccept();
/*				if (count(Constants.crm_completed_message) > 0)
					break;
			}*/
			// ASSERT STATUS
//			assertFilingStatus(TEXT_PROPERTIES.getProperty("permit_entire"));
		}
	}
	// Approve device
	public void peApproveDevice(String cpe_action) {
		if (!cpe_action.equals("")) {
			String[] data = cpe_action.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** Approve device");
			for (int i = 1; i <= 10; i++) {
				loginToCrm(data[0]);
				test = rep.startTest("Review Approve device");
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				searchForJobCrm();
				waitForPageToLoad();
				wait(2);
				driver.switchTo().frame("contentIFrame0");
				scrollToElement(Constants.crm_need_action_label);
				doubleclick(Constants.crm_need_action_label);
				driver.switchTo().defaultContent();
				click("//span[text()=' Approve Device Sub Type  ']");
				ifAlertExistAccept();
				ifAlertExistAccept();
				driver.navigate().back();
				verifyElementPresent(Constants.crm_approved_label);
				driver.switchTo().frame("contentIFrame0");
				waitForPageToLoad();				
				if (count(Constants.crm_completed_message) > 0) {
					reportPass("peApproveDevice");
					break;
				}
			}
		}
	}

	
	// VIEW ACCEPT DOCS ELV
	public void viewAcceptDocsElv(String user_name) {
		if (!user_name.equals("")) {
			String[] data = user_name.split(" :: ");
				System.out.println(convertedTimestamp() + " **************** " + data[0] + " View Accept viewAcceptDocsElv");
				loginToCrm(data[0]);
				driver.switchTo().frame("contentIFrame0");
				searchForJobCrm();
				test = rep.startTest(data[0] + " View Accept viewAcceptDocsElv");
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				while (count("//nobr[@class='gridcellpadding']") < 1) {
					refreshPage();
					wait(5);
					driver.switchTo().frame("contentIFrame0");
				}
				for (int i = 1; i <= 30; i++) {
					doubleclick(Constants.crm_document_status_submitted);
					wait(3);
					driver.switchTo().defaultContent();
					while (driver.getWindowHandles().size() < 2) {
						click(Constants.view_document_button);
						wait(3);
					}
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					driver.close();
					wait(1);
					driver.switchTo().window(tabs.get(0));
					driver.switchTo().defaultContent();
					click(Constants.accept_document_button);
/*					wait(1);
					ifAlertExistAccept();*/
					wait(1);
					ifAlertExistAccept();
					wait(1);
					waitVisible(Constants.accept_document_button);
					driver.switchTo().frame("contentIFrame0");
					waitVisible(Constants.crm_document_accepted);
					driver.switchTo().defaultContent();
					driver.navigate().back();
					wait(1);
					driver.switchTo().frame("contentIFrame0");
					wait(2);
					if (count(Constants.crm_document_status_submitted) == 0) {
						reportPass("viewAcceptDocsElv");
						break;
					}
//				viewAcceptDocs(); IN CASE OF MORE THEN 4 DOCUMENTS
			}
		}
	}
	
	// VIEW ACCEPT DOCS MAIN
	public void viewAcceptDocuments(String user_name) {
		if (!user_name.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** viewAcceptDocuments " + data[0]);
			loginToCrm(data[0]);
			searchForJobCrm();
			test = rep.startTest("viewAcceptDocuments");
			test.log(LogStatus.INFO, "viewAcceptDocuments");
			waitForPageToLoad();
			waitDocStatus();
			if (count(Constants.crm_document_status_submitted) > 0) {
				for (int i = 1; i <= 20; i++) {
					doubleclick(Constants.crm_document_status_submitted);
					wait(3);
					driver.switchTo().defaultContent();
					click(Constants.view_document_button);
					wait(3);
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					while (tabs.size() > 1) {
						driver.switchTo().window(tabs.get(1));
						driver.close();
						wait(2);
						tabs = new ArrayList<String>(driver.getWindowHandles());
					}
					driver.switchTo().window(tabs.get(0));
					driver.switchTo().defaultContent();
					doubleclick(Constants.accept_document_button);
					ifAlertExistAccept();
					waitForPageToLoad();
					wait(2);
					driver.switchTo().frame("contentIFrame0");
					waitVisible(Constants.crm_document_accepted);
					driver.switchTo().defaultContent();
					driver.navigate().back();
					waitForPageToLoad();
					wait(2);
					driver.switchTo().frame("contentIFrame0");
					waitVisible(Constants.label_job_filing);
					waitClickableOr("//nobr[text()='Accepted']", "//nobr[text()='Submitted']");
					if (count(Constants.crm_document_status_submitted) == 0) {
						reportPass("viewAcceptDocuments");
						break;
					}
				}
			}
			// viewAcceptDocs(); IN CASE OF MORE THEN 4 DOCUMENTS
		}
	}

	public void adressObjections(String objections) {
		if (!objections.equals("")) {
			String[] data = objections.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** adressObjections " +data[0]);
			loginToCrm(data[0]);
			searchForJobCrm();
			test = rep.startTest("adressObjections");
			waitForPageToLoad();
			driver.switchTo().frame("contentIFrame0");
			waitVisible(Constants.label_job_filing);
			waitVisible(Constants.crm_document_title_link);
			for (int i = 1; i <= 5; i++) {
				WebElement document = driver.findElement(By.xpath(Constants.crm_document_status_resolved));
				new Actions(driver).contextClick(document).build().perform();
				wait(1);
				new Actions(driver).sendKeys(Keys.ENTER).build().perform();
				wait(3);
				driver.switchTo().defaultContent();
				click(Constants.objection_addressed_button);
				ifAlertExistAccept();
				driver.switchTo().defaultContent();
				wait(1);
				driver.navigate().back();
				wait(1);
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				wait(3);
				if (count("//nobr[text()='Addressed']") > 0) {
					reportPass("adressObjections");
					break;
				}
			}
		}
	}

	public void assignTo(String superviser) {
		if (!superviser.equals("")) {
			String[] data = superviser.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** assignTo " + superviser);
			for (int i = 1; i <= 10; i++) {
				loginToCrm(data[0]);
				searchForJobCrm();
				test = rep.startTest(data[0] + " assign to " + data[1]);
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				waitVisible(Constants.assign_to_qa_administrator_label);
				scrollToElement(Constants.assign_to_qa_administrator_label);
				click(Constants.assign_to_qa_administrator_label);
				type(Constants.assign_to_qa_administrato_type, data[1]);
				click(Constants.qa_administrator_search);
				doubleclick(Constants.span_text +data[2]+ Constants.close_xpath);
				
//				click(Constants.select_assignee);
				driver.switchTo().defaultContent();
				click(Constants.submit_button);
				ifAlertExistAccept();
				waitInvisible(Constants.submit_button);
				ifAlertExistAccept();
				driver.switchTo().frame("contentIFrame0");
				if (count(Constants.crm_completed_message) > 0)
					break;
			}
		}
		reportPass("assignTo");
	}



	public void cpeAssign(String cpe) {
		if (!cpe.equals("")) {
			String[] data = cpe.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** cpeAssign " +data[0]+ " Assign to "+data[2]+ " " +data[3]);
			for (int i = 1; i <= 10; i++) {
				loginToCrm(data[0]);
				searchForJobCrm();
				test = rep.startTest(data[0]+ " Assign to " +data[2]+ " " +data[3]);
				test.log(LogStatus.INFO, " " +data[0]+ " Assign to " +data[2]+ " " +data[3]);
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				waitVisible(Constants.is_the_job_application_complete_list);
				scrollToElement(Constants.is_the_job_application_complete_list);
				click(Constants.is_the_job_application_complete_list);
				select(Constants.is_the_job_application_complete_select, data[1]);
				ifAlertExistAccept();
				if (cpe.contains("Yes")) { // Yes == "Is the Job Application Complete ?"
					click(Constants.cpe_acpe_primary_pe_field);
					click(Constants.cpe_acpe_find_primary_pe_image);
					doubleclick(Constants.span_text +data[2]+ Constants.close_xpath);
//						doubleclick("//span[text()='Assign to Primary Plan Examiner']/following::span[text()='" +data[2]+ Constants.close_xpath);
					ifAlertExistAccept();
					if (!data[3].equals("null")) {
						click(Constants.cpe_acpe_secondary_pe_field);
						click(Constants.cpe_acpe_find_secondary_pe_image);
						doubleclick("(" +Constants.span_text +data[3]+ Constants.close_xpath+ ")[2]");
					}
//						doubleclick("//span[text()='Assign to Secondary Plan Examiner']/following::span[text()='" +data[3]+ Constants.close_xpath);
					// span[text()='Assign to Secondary Plan Examiner']
//						doubleclick(Constants.span_text  +data[3]+ Constants.close_xpath);
					ifAlertExistAccept();
				}
				driver.switchTo().defaultContent();
				click(Constants.submit_button);
				ifAlertExistAccept();
				waitInvisible(Constants.submit_button);
				driver.switchTo().frame("contentIFrame0");
				ifAlertExistAccept();
				if (count(Constants.crm_completed_message) > 0) {
					reportPass("cpeAssign");
					break;
				}
			}
		}
	}
	
	
	
	
	public void cpeAction(String chief_plan_examiner) {
		if (!chief_plan_examiner.equals("")) {
			String[] data = chief_plan_examiner.split(" :: ");
//			String filing_status = data[3];
			System.out.println(convertedTimestamp() + " **************** cpeAction " + chief_plan_examiner);
			for (int i = 1; i <= 5; i++) {
				loginToCrm(data[0]);
				searchForJobCrm();
				test = rep.startTest(" " +data[1]);
				test.log(LogStatus.INFO, " " +data[1]);
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				if (count("//span[text()='Allow Appointment?']") > 0) { 
					
					click("//span[contains(.,'Allow Appointment?')]/following::div[contains(@jawsreadlabel,'dobnyc')]");
					select("//span[contains(.,'Allow Appointment?')]/following::select[contains(@id,'dobnyc')]", data[1]);
				}
					
//					select("//span[text()='Allow Appointment?']", data[1]);
				if (chief_plan_examiner.contains("Approve")) { // Yes == "Is the Job Application Complete ?"
					waitVisible(Constants.first_plan_examiner_action);
					scrollToElement(Constants.first_plan_examiner_action);
					click(Constants.first_plan_examiner_action);
					select(Constants.plan_examiner_action_select, data[2]);
					ifAlertExistAccept();
					ifAlertExistAccept();
					wait(5);
					waitUntilISpinnersInvisible();
					waitForPageToLoad();
					ifAlertExistAccept();
				}
				if(count(Constants.approved_plans_uploaded_list) > 0) {					
//					click(Constants.approved_plans_uploaded_list);
					select(Constants.approved_plans_uploaded, data[3]);
				}
/*				waitVisible(Constants.is_the_job_application_complete_list);
				scrollToElement(Constants.is_the_job_application_complete_list);
				click(Constants.is_the_job_application_complete_list);
				select(Constants.is_the_job_application_complete_select, data[1]);
				ifAlertExistAccept();
				if (data[1].contains("Yes")) { // Yes == "Is the Job Application Complete ?"
					click(Constants.assign_to_plan_examiner);
					type(Constants.assign_to_assignee, data[2]);
					click(Constants.search_assignee_button);
					click(Constants.select_assignee);
					ifAlertExistAccept();
				}*/
				click(Constants.crm_comments_area);
				wait(1);
				type(Constants.crm_comments_box, chief_plan_examiner);
				driver.switchTo().defaultContent();
				click(Constants.submit_button);
				ifAlertExistAccept();
				waitInvisible(Constants.submit_button);
				driver.switchTo().frame("contentIFrame0");
				ifAlertExistAccept();
				if (count(Constants.crm_completed_message) > 0) {
					reportPass("cpeAction");
					break;
				}
			}
/*			 	filterJob(OR_PROPERTIES.getProperty("user_email"));
			 	assertFilingStatus(TEXT_PROPERTIES.getProperty("filing_status"));*/
		}
	}

	// Plan Examiner ACTION
	public void peAction(String action) {
		if (!action.equals("")) {
			String[] data = action.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** peAction " +action);
			for (int i = 1; i <= 10; i++) {
				loginToCrm(data[0]);
				searchForJobCrm();
				waitForPageToLoad();
				test = rep.startTest("PE ACTION " +action);
				driver.switchTo().frame("contentIFrame0");
				waitVisible(Constants.appoitment_required_list);
				scrollToElement(Constants.appoitment_required_list);
				click(Constants.appoitment_required_list);
				select(Constants.apt_required, data[1]);
				ifAlertExistAccept();
				click(Constants.plan_examiner_action_list);
				select(Constants.job_approved, data[2]);
				ifAlertExistAccept();
				ifAlertExistAccept();
				click(Constants.approved_plans_uploaded_list);
				select(Constants.approved_plans_uploaded, data[3]);
				ifAlertExistAccept();
				click(Constants.crm_comments_area);
				wait(1);
				type(Constants.crm_comments_box, action);
				driver.switchTo().defaultContent();
				click(Constants.submit_button);
				ifAlertExistAccept();
				waitInvisible(Constants.submit_button);
				driver.switchTo().frame("contentIFrame0");
				if (count(Constants.crm_completed_message) > 0) {
					reportPass("peAction");
					break;
				}
			}
/*			filterJob(OR_PROPERTIES.getProperty("user_email"));
			assertFilingStatus(filing_status);*/
		}
	}

	public void cpeActionElv(String cpe_action) {
		if (!cpe_action.equals("")) {
			String[] data = cpe_action.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** CPE cpeActionElv " +data[1]);
			// for (int i = 1; i <= 10; i++) {
			loginToCrm(data[0]);
			ifAlertExistAccept();
			setWindowfocus();
			waitForPageToLoad();
			waitVisible(Constants.crm_top_nav_search_button);
			click(Constants.crm_username_label);
			driver.switchTo().frame("contentIFrame0");
			wait(1);
			driver.switchTo().frame("dashboardFrame");
			click(Constants.search_for_records_one);
			type(Constants.search_for_records_one_field, "*" + JOB_NUMBER.getProperty("job_number").substring(2));
			click(Constants.search_for_records_one_image);
			waitVisible(Constants.search_results_job_subject);
			test = rep.startTest(" " +data[1]);
			click(Constants.pe_task);
			wait(1);
			waitForPageToLoad();
			driver.switchTo().frame("contentIFrame0");
			waitVisible(Constants.first_plan_examiner_action);
			scrollToElement(Constants.first_plan_examiner_action);
			click(Constants.first_plan_examiner_action);
			select(Constants.plan_examiner_action_select, data[1]);
			ifAlertExistAccept();
			if (cpe_action.contains("Elevator :: 1 :: Private residence")) {
				click(Constants.proposed_device_type_for_others_list);
				select(Constants.proposed_device_type_for_others, data[2]);
				ifAlertExistAccept();
				click(Constants.proposed_elevator_sub_type_list);
				select_val(Constants.proposed_elevator_sub_type, data[3]);
				ifAlertExistAccept();
				click(Constants.proposed_passenger_type_list);
				select(Constants.proposed_passenger_type, data[4]);
				ifAlertExistAccept();
			}
			click(Constants.actions_ccd_variance_list);
			select(Constants.actions_ccd_variance, data[5]);
			ifAlertExistAccept();
			click(Constants.actions_under_pilot_list);
			select(Constants.actions_under_pilot, data[6]);
			ifAlertExistAccept();
			click("//div[@jawsreadlabel='dobnyc_et_comments_c']");
			wait(1);
			type("//textarea[@id='dobnyc_et_comments_i']", "cpeActionElv " + cpe_action);
			driver.switchTo().defaultContent();
			click(Constants.submit_button_elv);
			ifAlertExistAccept();
			waitInvisible(Constants.submit_button_elv);
			// }
			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			assertFilingStatus("Permit Entire");
		}
	}
	public void qaSuperviser(String qa_superviser) {
		if (!qa_superviser.equals("")) {
			String[] data = qa_superviser.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** qaSuperviser " + qa_superviser);
			for (int i = 1; i <= 10; i++) {
				loginToCrm(data[0]);
				searchForJobCrm();
				test = rep.startTest(data[0] + " assign to " + data[1]);
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				waitVisible(Constants.assign_to_qa_administrator_label);
				scrollToElement(Constants.assign_to_qa_administrator_label);
				click(Constants.assign_to_qa_administrator_label);
				type(Constants.assign_to_qa_administrato_type, data[1]);
//				click(Constants.qa_administrator_search);
//				click(Constants.select_assignee);
				driver.switchTo().defaultContent();
				click(Constants.submit_button);
				ifAlertExistAccept();
				waitInvisible(Constants.submit_button);
				ifAlertExistAccept();
				driver.switchTo().frame("contentIFrame0");
				if (count(Constants.crm_completed_message) > 0)
					break;
			}
		}
		reportPass("assignTo");
	}

	public void assertCorrection(String user_name, String correction) {
		if (!user_name.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** Assert Correction");
			loginToCrm(data[0]);
			searchForJobCrm();
			waitForPageToLoad();
			driver.switchTo().frame("contentIFrame0");
			click(Constants.job_filing_link);
			ifAlertExistAccept();
			waitInvisible(Constants.job_filing_link);
			waitForPageToLoad();
			wait(10);
			ifAlertExistAccept();
			waitVisible(Constants.crm_job_description);
			scrollToElement(Constants.crm_job_description);
			wait(2);
			assertColor(Constants.crm_job_description, "color", "rgb");
			elementContainsText(Constants.crm_job_description, "My Correction Test");
		}
	}

	public void addObjection(String objections) {
		if (!objections.contains("objection")) {
			String[] data = objections.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** PE ACTION " + data[2]);
			for (int i = 1; i <= 10; i++) {
				loginToCrm(data[0]);
				searchForJobCrm();
				test = rep.startTest("addObjection" + data[2]);
				test.log(LogStatus.INFO, "PE Objections" + data[2]);
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				wait(1);
				click(Constants.add_objection_image);
				wait(2);
				driver.switchTo().defaultContent();
				click(Constants.save_objection_button);
				try {
					(new Robot()).keyPress(java.awt.event.KeyEvent.VK_A);
					wait(1);
					/*
					 * (new Robot()).keyPress(java.awt.event.KeyEvent.VK_ENTER); wait(1); (new
					 * Robot()).keyPress(java.awt.event.KeyEvent.VK_ENTER);
					 */
					click(Constants.save_objection_button);
					(new Robot()).keyPress(java.awt.event.KeyEvent.VK_B);
					wait(1);
					(new Robot()).keyPress(java.awt.event.KeyEvent.VK_ENTER);
					wait(1);
					(new Robot()).keyPress(java.awt.event.KeyEvent.VK_ENTER);
					click(Constants.save_objection_button);
					waitInvisible(Constants.save_objection_button);
					ifAlertExistAccept();
				} catch (AWTException e) {
					e.printStackTrace();
					ifAlertExistAccept();
				}
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				scrollToElement(Constants.plan_examiner_action_list);
				click(Constants.appoitment_required_list);
				select(Constants.apt_required, data[1]);
				ifAlertExistAccept();
				click(Constants.plan_examiner_action_list);
				select(Constants.job_approved, data[2]);
				ifAlertExistAccept();
				ifAlertExistAccept();
				click(Constants.crm_comments_area);
				wait(1);
				type(Constants.crm_comments_box, "addObjection " + data[2]);
				driver.switchTo().defaultContent();
				click(Constants.submit_button);
				ifAlertExistAccept();
				waitInvisible(Constants.submit_button);
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				if (count(Constants.crm_completed_message) > 0) {
					reportPass("addObjection");
					break;
				}
			}
		}
	}

	// Plan Examiner ACTION
	public void qaAction(String qa_action) {
		if (!qa_action.equals("")) {
			String[] data = qa_action.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** QA ACTION qaAction " +data[2]);
			for (int i = 1; i <= 5; i++) {
				loginToCrm(data[0]);
				searchForJobCrm();
				test = rep.startTest("QA ACTION " +data[2]);
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
/*				scrollToElement(Constants.crm_comments_area);
				click(Constants.crm_comments_area);
				wait(1);
				type(Constants.crm_comments_box, "qaAction " +pe_action);*/
				scrollToElement("//div[@jawsreadlabel='dobnyc_qadecision5_c']");
				click("//div[@jawsreadlabel='dobnyc_qadecision5_c']");
				select("//select[@id='dobnyc_qadecision5_i']", data[2]);
				ifAlertExistAccept();
				click("//div[@jawsreadlabel='dobnyc_ahvreasonofapproval_c']");
				select("//select[@id='dobnyc_ahvreasonofapproval_i']", data[3]);
				ifAlertExistAccept();
				driver.switchTo().defaultContent();
				click(Constants.submit_button);
				ifAlertExistAccept();
				waitInvisible(Constants.submit_button);
				waitForPageToLoad();
				driver.switchTo().frame("contentIFrame0");
				if (count(Constants.crm_completed_message) > 0) {
					reportPass("qaAction");
					break;
				}
			}
/*			filterJob(OR_PROPERTIES.getProperty("user_email"));
			assertFilingStatus(filing_status);*/
		}
	}

	// QA DESCISION
	public void qaDecision(String decision) {
		if (!decision.equals("")) {
			String[] data = decision.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** qaDecision " +data[0]+ " " +data[1]);
				for (int i = 1; i <= 10; i++) {
					loginToCrm(data[0]);
					searchForJobCrm();
					test = rep.startTest("QA Decision");
					waitForPageToLoad();
					driver.switchTo().frame("contentIFrame0");
/*					scrollToElement(Constants.crm_comments_area);
					click(Constants.crm_comments_area);
					wait(1);
					type(Constants.crm_comments_box, decision);
					wait(1);*/
					scrollToElement(Constants.qa_descision_list);
					click(Constants.qa_descision_list);
					wait(1);
					select(Constants.qa_descision, data[1]);
					ifAlertExistAccept();
					driver.switchTo().defaultContent();
					waitVisible(Constants.submit_button);
					click(Constants.submit_button);
					ifAlertExistAccept();
					waitInvisible(Constants.submit_button);
					driver.switchTo().frame("contentIFrame0");
					if (count(Constants.crm_completed_message) > 0) {
						reportPass("qaDecision");
						break;
					}
			}
			filterJob(OR_PROPERTIES.getProperty("user_email"));
			assertFilingStatus(TEXT_PROPERTIES.getProperty("approved"));
		}
	}

	public void cpeObjections(String user_name) {
		if (!user_name.equals("")) {
			System.out.println(convertedTimestamp() + " **************** cpeObjections");
				for (int i = 1; i <= 10; i++) {
					String[] data = user_name.split(" :: ");
					loginToCrm(data[0]);
					searchForJobCrm();
					test = rep.startTest("CPE Objections");
					test.log(LogStatus.INFO, "cpeObjections");
					waitForPageToLoad();
					driver.switchTo().frame("contentIFrame0");
					waitVisible(Constants.chief_plan_examiner_action);
					scrollToElement(Constants.chief_plan_examiner_action);
					click(Constants.chief_plan_examiner_action);
					select("//select[@id='dobnyc_reviewactions_i'] ", data[1]);
					ifAlertExistAccept();
					click(Constants.crm_comments_area);
					type(Constants.crm_comments_box, user_name);
					driver.switchTo().defaultContent();
					waitVisible(Constants.submit_button);
					click(Constants.submit_button);
					ifAlertExistAccept();
					waitInvisible(Constants.submit_button);
					driver.switchTo().frame("contentIFrame0");
					if (count(Constants.crm_completed_message) > 0) {
						reportPass("cpeObjections");
						break;
					}
			}
			filterJob(OR_PROPERTIES.getProperty("user_email"));
			assertFilingStatus(TEXT_PROPERTIES.getProperty("objections"));
		}
	}

	// QA FAILED
	public void qaFailed(String action) {
		if (!action.equals("")) {
			String[] data = action.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** QA Failed");
			loginToCrm(data[0]);
			searchForJobCrm();
			test = rep.startTest("QA Failed");
			waitForPageToLoad();
			driver.switchTo().frame("contentIFrame0");
			waitVisible(Constants.qa_action_list);
			scrollToElement(Constants.qa_action_list);
			click(Constants.qa_action_list);
			select(Constants.qa_action_select, data[1]);
			ifAlertExistAccept();
			click(Constants.qa_failed_reason_area);
			type(Constants.qa_failed_reason_box, action);
			driver.switchTo().defaultContent();
			waitVisible(Constants.submit_button);
			click(Constants.submit_button);
			ifAlertExistAccept();
			ifAlertExistAccept();
		}
		filterJob(user);
		waitVisible(Constants.pw2_work_permit_step);
		click(Constants.pw2_work_permit_step);
		waitVisible(Constants.incompleted_work_permit);
		wait(3);
//		assertElementPresent("//div[@class='ui-grid-cell-contents'][contains(.,'QA Failed')]", "QA Failed");
		assertElementPresent("//div[text()='QA Failed']", "QA Failed");
		if(text("//div[text()='QA Failed']").contains("QA Failed"))
			reportPass("qaFailed");
	}

	// ISSUE PERMIT
	public void isuePermit(String action) {
		if (!action.equals("")) {
			String[] data = action.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** " + action);
			loginToCrm(data[0]);
			searchForJobCrm();
			test = rep.startTest("IsuePermit");
			waitForPageToLoad();
			driver.switchTo().frame("contentIFrame0");
			for (int i = 1; i < 100; i++) {
				scrollToElement(Constants.qa_action_label + Constants.following + Constants.first_action);
				click(Constants.qa_action_label + Constants.following + Constants.first_action);
				select(Constants.qa_action_select, data[1]);
				ifAlertExistAccept();
				wait(2);
				if (text(Constants.qa_action_label + Constants.following + Constants.first_action).contains("Permit Issued"))
					break;
			}
			driver.switchTo().defaultContent();
			wait(1);
			click(Constants.submit_button);
			ifAlertExistAccept();
			ifAlertExistAccept();
			waitInvisible(Constants.submit_button);
			driver.switchTo().frame("contentIFrame0");
			filterJob(user);
			assertFilingStatus(TEXT_PROPERTIES.getProperty("permit_entire"));
		}
	}

	
	
	
}