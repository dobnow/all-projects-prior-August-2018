package com.pages;

import com.base.TestBase;
import com.util.Constants;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DobDS1Page extends TestBase {
/*	WebDriver driver;
	public DobDS1Page(WebDriver dr) {
		driver = dr;
	}*/

	public void demolitionSubmittal(String ds1) {	
		if(ds1.equals("Y")){
			System.out.println(convertedTimestamp() + " **************** " + "DS1 DemolitionSubmittalTest");
			filterJob(OR_PROPERTIES.getProperty("user_email"));	
			test = rep.startTest("Demolition");
			click(Constants.ds1_demolition_submittal_step);
			type(Constants.ds1_3B_description, "smoke test " + new SimpleDateFormat("MM/dd/yy HH-mm").format(Calendar.getInstance().getTime()));
			click(Constants.ds1_3B_i_prepared_demolition_documents);
			scrollToElement(Constants.save_button);
			click(Constants.save_button);
			waitVisible60(Constants.ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
	}
}