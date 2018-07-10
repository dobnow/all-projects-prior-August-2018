package com.pages;

import com.base.TestBase;
import com.util.Constants;
import org.openqa.selenium.WebDriver;

public class DobSignaturesPage extends TestBase {

	public void applicantStatementsSignature(String signatures) {
		if(!signatures.equals("")){
			System.out.println(convertedTimestamp() + " **************** Applicant Sign");
			filterJob(OR_PROPERTIES.getProperty("user_email"));	
			test = rep.startTest("Statemments Signatures");
			click(Constants.ss_statement_signatures_step);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ss_save_button);
			if(count(Constants.project_not_require_commissioning) > 0)
				radio(Constants.project_not_require_commissioning);
			if(count(Constants.ss_i_havepersonally_reviewed_all_information) > 0)
				check(Constants.ss_i_havepersonally_reviewed_all_information);
			scrollTo("//h3[contains(text(),'Owner - Statements & Signatures')]");
			radio(Constants.ss_fee_exemption_reques_non_profit_yes);
			radio(Constants.ss_owners_certifications_yes);
			radio(Constants.ss_building_to_be_altered_demolished_no);
			radio(Constants.ss_building_to_be_altered_demolished_no);
			radio(Constants.ss_owner_is_not_required_to_notify_yes);
			radio(Constants.ss_owner_notified_new_york);
			select(Constants.ss_owner_type, "Partnership");
			email(OR_PROPERTIES.getProperty("owner_email"));
			click(Constants.save_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved ss");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
	}
	public void signatures(String signatures) {	
		if(!signatures.equals("")){
			System.out.println(convertedTimestamp() + " **************** StatementsSignaturesTest");
//			loginToPortal(OR_PROPERTIES.getProperty("user_email"));
			filterJob(user);	
			test = rep.startTest("signatures");
			waitUntilElementVisible(Constants.ss_statement_signatures_step, 30);
			click(Constants.ss_statement_signatures_step);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ss_save_button);
			if(count(Constants.project_not_require_commissioning) > 0)
				radio(Constants.project_not_require_commissioning);
			check(Constants.ss_i_havepersonally_reviewed_all_information);
			radio(Constants.ss_fee_exemption_reques_non_profit_yes);
			scrollToElement(Constants.ss_owners_certifications_yes);
			radio(Constants.ss_owners_certifications_yes);
			radio(Constants.ss_building_to_be_altered_demolished_no);
			radio(Constants.ss_building_to_be_altered_demolished_no);
			radio(Constants.ss_owner_is_not_required_to_notify_yes);
			radio(Constants.ss_owner_notified_new_york);
			select(Constants.ss_owner_type, "Partnership");
	 		emailpreview = Constants.email_xpath_part1 + OR_PROPERTIES.getProperty("owner_email") + Constants.email_xpath_part2;
			waitUntilElementVisible(Constants.ss_partner_email, 30);
	 		for(int i=1; i < 100; i++) {
	 			clear(Constants.ss_partner_email);
	 			type(Constants.ss_partner_email, OR_PROPERTIES.getProperty("owner_email"));
	 			wait(1);
	 			if(count(emailpreview) > 0)
	 				break;
	 		}
/*			
//			if(!description.contains("Correction") ) {
				type(Constants.ss_partner_email, OR_PROPERTIES.getProperty("owner_email"));
		 		wait(2);
				while(count(emailpreview) < 0) {
					clear(Constants.ss_partner_email);
					type(Constants.ss_partner_email, OR_PROPERTIES.getProperty("owner_email"));
					wait(1);
				}*/
				clickElement(emailpreview);
//			}
			click(Constants.ss_save_button);
//			waitUntilElementVisible(Constants.global_loading_spinner, 10);
			waitUntilISpinnersInvisible();
			waitUntilElementVisible(Constants.global_notification_ok_button, 30);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved ss");
			clickButton("OK");
			waitInvisible(Constants.global_notification_ok_button);
		}
	}

	public void applicantSignature(String statements_signatures) {	
		if(!statements_signatures.equals("")){
			System.out.println(convertedTimestamp() + " **************** " + "applicantSignature");
			filterJob(user);	
			test = rep.startTest("Applicant Sign");
			click(Constants.ss_statement_signatures_step);
			wait(2);
			scrollToElement(Constants.ss_i_havepersonally_reviewed_all_information);
/*			if(!ss_i_havepersonally_reviewed_all_information.isSelected())
				ss_i_havepersonally_reviewed_all_information.click();*/
			check(Constants.ss_i_havepersonally_reviewed_all_information);
			wait(2);
			scrollToElement(Constants.ss_save_button);
			click(Constants.ss_save_button);
//			waitUntilElementVisible(Constants.global_loading_spinner, 10);
			waitUntilISpinnersInvisible();
			waitUntilElementVisible(Constants.global_notification_ok_button, 30);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved ss");
			clickButton("OK");
			waitInvisible(Constants.global_notification_ok_button);
		}
	}
	public void ownerSignature(String owner_signature) {	
		if(!owner_signature.equals("")){
			System.out.println(convertedTimestamp() + " **************** Owner Sign");
			filterJob(OR_PROPERTIES.getProperty("owner_email"));
			test = rep.startTest("Owner Sign");
			click(Constants.ss_statement_signatures_step);
			wait(2);
			scrollToElement(Constants.ss_i_understand_and_agrree);
			check(Constants.ss_i_understand_and_agrree);
			scrollToElement(Constants.ss_save_button);
			click(Constants.ss_save_button);
			waitInvisible(Constants.global_loading_spinner);
			waitVisible(Constants.ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved owner sign");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
	}


}