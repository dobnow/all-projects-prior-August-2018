package com.pages;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.util.Constants;

public class ElevatorsDocumentsPage extends TestBase {

	public void documents(String upload_file) {
		if (!upload_file.equals("")) {
			System.out.println(convertedTimestamp() + " **************** Documents");
//			filterJob(OR_PROPERTIES.getProperty("elevator_applicant_email"));
			filterJob(user, JOB_NUMBER.getProperty("job_number"));
			test = rep.startTest("Documents");
			click(Constants.documents_tab);
			waitUntilISpinnersInvisible();
			while (count(Constants.upload_document_icon) < 1) {
				refreshPage();
				waitForPageToLoad();
			}
			int number_of_docs = 0;
			for (int i = 1; i <= 20; i++) {
				number_of_docs = number_of_docs + 1;
				test.log(LogStatus.INFO, "Upload document " + number_of_docs);
				clear(Constants.document_status_filter_elv);
				type(Constants.document_status_filter_elv, "required");
				if (count(Constants.document_status_required) == 0)
					break;
				click(Constants.upload_icon);
				send(Constants.choose_file_button, Constants.uploadFolder + upload_file);
				click(Constants.upload_button);
				waitInvisible(Constants.doc_please_wait_message);
				click(Constants.ok_button);
				waitInvisible(Constants.ok_button);
				waitInvisible(Constants.global_loading_spinner);
			}
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitUntilElementVisible(Constants.global_notification_ok_button, 30);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			click(Constants.global_notification_ok_button);
			waitInvisible(Constants.global_notification_ok_button);
		}
	}

}
