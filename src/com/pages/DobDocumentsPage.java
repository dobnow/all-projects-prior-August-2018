package com.pages;

import com.base.TestBase;
import com.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DobDocumentsPage extends TestBase {
/*	WebDriver driver;
	public DobDocumentsPage(WebDriver dr) {
		driver = dr;
	}*/

	public void uploadDocuments(String upload_file) {
		if (!upload_file.equals("")) {
			System.out.println(convertedTimestamp() + " **************** uploadDocuments");
			filterJob(user);
			test = rep.startTest("Upload Documents");
			click(Constants.documents_step);
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			if (driver.findElement(By.xpath(Constants.documents_loading_spinner)).isDisplayed()) {
				refreshPage();
				waitForPageToLoad();
				wait(3);
			}
			while (count(Constants.upload_document_icon) < 1) {
				refreshPage();
				waitForPageToLoad();
				wait(3);
			}
			while (count(Constants.document_status_required) > 0) { 
				type(Constants.document_status_filter, "required");
				wait(1);
				click(Constants.upload_document_icon);
				send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
				click(Constants.doc_upload_button);
				waitInvisible(Constants.doc_please_wait_message);
				waitVisible(Constants.doc_upload_succesfull_message);				
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				if (driver.findElement(By.xpath(Constants.documents_loading_spinner)).isDisplayed()) {
					refreshPage();
					waitForPageToLoad();
					wait(5);
				}
				if (count(Constants.document_status_required) == 0) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
//					assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved");
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}
			}
			reportPass("uploadDocuments");
		}
	}
	
}