package com.pages;

import com.base.TestBase;
import com.util.Constants;

public class ElectricalSignaturesPage extends TestBase {
/*	WebDriver driver;
	public ElectricalSignaturesPage(WebDriver dr) {
		driver = dr;
	}*/
	
	public void signaturesEl(String signatures) {	
		if(!signatures.equals("")){
			System.out.println(convertedTimestamp() + " **************** " + "Statemments Signatures");
//			loginToPortal(OR_PROPERTIES.getProperty("electrical_user_email"));
			filterJob(OR_PROPERTIES.getProperty("electrical_user_email"),JOB_NUMBER.getProperty("job_number"));
			test = rep.startTest("Statemments Signatures");
			waitUntilISpinnersInvisible();
			click(Constants.ss_statement_signatures_step);
			check(Constants.el_i_undersigned);
			scrollDown();
			check(Constants.el_this_electrical_permit_involves);
//			click(Constants.el_application_involve_new_or_amended_yes);
			check(Constants.el_this_electrical_permit_includes);
			click(Constants.global_save_step_button);
			waitUntilElementVisible(Constants.global_loading_spinner_subs, 30);
			waitUntilISpinnersInvisible();
			waitUntilElementVisible(Constants.global_notification_ok_button, 30);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved ss");
			click(Constants.global_notification_ok_button);
		}
	}
}