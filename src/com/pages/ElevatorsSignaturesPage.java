package com.pages;

import com.base.TestBase;
import com.util.Constants;

public class ElevatorsSignaturesPage extends TestBase {

	public void signatures(String insurance_fee) {
		if (!insurance_fee.equals("")) {
			System.out.println(convertedTimestamp() + " **************** Signatures");
			filterJob(user);
			test = rep.startTest("Signatures");
			click(Constants.signatures_tab);
			check(Constants.applicant_sign_elv);
			scrollDown();
			check(Constants.design_pro_sign_elv);
			radio(Constants.fee_exempion_request_non_profit_yes);
			check(Constants.owner_sign_elv);
			click(Constants.save_button);
			waitUntilISpinnersInvisible();
			waitUntilElementVisible(Constants.ok_button, 30);
			verifyNotification(Constants.notification,TEXT_PROPERTIES.getProperty("job_filing_saved"));
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
		}
	}
	public void signaturesSignOff(String insurance_fee) {
		if (!insurance_fee.equals("")) {
			System.out.println(convertedTimestamp() + " **************** Signatures");
			filterJob(user);
			test = rep.startTest("Signatures");
			click(Constants.signatures_tab);
			check(Constants.applicant_sign_elv);
			scrollDown();
			check(Constants.replacement_modification_statement);
			scrollDown();
			check(Constants.design_pro_sign_elv);
			radio(Constants.fee_exempion_request_non_profit_yes);
			check(Constants.owner_sign_elv);
			click(Constants.save_button);
			waitUntilISpinnersInvisible();
			waitUntilElementVisible(Constants.ok_button, 30);
			verifyNotification(Constants.notification,TEXT_PROPERTIES.getProperty("job_filing_saved"));
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
		}
	}
}