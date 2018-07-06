package com.pages;

import com.base.TestBase;
import com.util.Constants;
import org.openqa.selenium.By;

public class ElectricalDocsPage extends TestBase {

	public void uploadDocumentsEl(String upload_file) {
		if (!upload_file.equals("")) {
			System.out.println(convertedTimestamp() + " **************** " + "Upload Documents Electrical");
//			loginToPortal(OR_PROPERTIES.getProperty("electrical_user_email"));
			filterJob(OR_PROPERTIES.getProperty("electrical_user_email"), JOB_NUMBER.getProperty("job_number"));
			test = rep.startTest("Upload Documents");
			waitUntilISpinnersInvisible();
			click(Constants.documents_step);
			scrollUp();
			waitUntilElementVisible(Constants.el_first_document, 30);
			waitUntilElementVisible(Constants.upload_document_icon, 30);
			int number_of_uploads = driver.findElements(By.xpath(Constants.upload_document_icon)).size();
			for (int i = 1; i <= number_of_uploads; i++) {
				String document_xpath = Constants.doc_upload_xpath_part1 + i + Constants.doc_upload_xpath_part2;
				click(document_xpath);
				send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
				click(Constants.doc_upload_button);
				waitInvisible(Constants.doc_please_wait_message);
				click(Constants.doc_document_uploaded_ok_button);
				waitUntilISpinnersInvisible();
			}
			click(Constants.global_save_step_button);
			waitVisible(Constants.global_notification_ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "save form docs page");
			click(Constants.global_notification_ok_button);
			waitInvisible(Constants.global_notification_ok_button);
			waitUntilISpinnersInvisible();
//			click("//a[@ng-click='changeCurrentPage(1);']");
		}
	}
}