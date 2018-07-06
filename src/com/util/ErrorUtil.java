package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.Reporter;

public class ErrorUtil {
	private static Map<ITestResult, List> verificationFailuresMap = new HashMap<ITestResult, List>();

	public static void addVerificationFailure(Throwable e) {
		System.out.println("*addVerificationFailure*");
		List verificationFailures = getVerificationFailures();
		verificationFailuresMap.put(Reporter.getCurrentTestResult(), verificationFailures);
		verificationFailures.add(e);
	}

	public static List getVerificationFailures() {
//		System.out.println("*getVerificationFailures*");
		List verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
		return verificationFailures == null ? new ArrayList() : verificationFailures;
	}
}


/*
int size = driver.findElements(By.tagName("iframe")).size();
System.out.println(size);


List<WebElement> el = driver.findElements(By.xpath("//*"));
int count=0;
for ( WebElement e : el ) {
 System.out.println( e.getTagName()+"    "+e.getText());
 count++;
}
System.out.println(count );

*/
/*
	System.out.println(driver.findElements(By.cssSelector("#findCriteriaButton")).size());
	System.out.println(driver.findElements(By.xpath("//*[@class='ms-crm-ImageStrip-msgbar_close_button_cold']")).size());
	driver.findElement(By.xpath("//*[@class='ms-crm-ImageStrip-msgbar_close_button_cold']")).click();

	waitUntilElementVisible(Constants.crm_top_nav_search_button, 30);
	crm_top_nav_search_button.click();
//	driver.findElement(By.xpath(zzzzz)).click(); */
//	waitUntilElementVisible(Constants.crm_top_nav_search_button, 30);
//	driver.navigate().to(Constants.crm_stage);
//	driver.navigate().back();
	
/*			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();


String date = text("//span[@id='txt14']");

System.out.println(text("//span[@id='txt14']"));

List<WebElement> element = driver.findElements(By.xpath("(//span[@class='pad-left-5'])[14]"));
for(WebElement ele:element) {
	System.out.println(ele.getText());
	System.out.println(ele.getAttribute("id"));
	
}

List<WebElement> el = driver.findElements(By.xpath("//*"));
int count=0;
for ( WebElement e : el ) {
 System.out.println( e.getTagName()+"    "+e.getText());
 count++;
}
System.out.println(count );

try {
    List<WebElement> links = driver.findElements(By.tagName("a"));
    int linkcount = links.size(); 
     System.out.println(links.size()); 
      for (WebElement myElement : links){
     String link = myElement.getText(); 
//     System.out.println(link);
//     System.out.println(myElement);   
    if (link !=""){
//         myElement.click();
         System.out.println(link);
        }
        //Thread.sleep(5000);
      } 
    }catch (Exception e){
        System.out.println("error "+e);
    }

/*					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
StringSelection name = new StringSelection(sCurrentLine);
clipboard.setContents(name, null);
try {
	(new Robot()).keyPress(java.awt.event.KeyEvent.VK_CONTROL);
	(new Robot()).keyPress(java.awt.event.KeyEvent.VK_V);
	(new Robot()).keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
	waitUntilElementVisible(Constants.cpe_search_job_button, 30);
	cpe_search_job_button.click();
	String job = Constants.link_xpath_part1 + sCurrentLine + Constants.link_xpath_part2;
	waitUntilElementVisible(job, 10);
	driver.findElement(By.xpath(job)).click();
} catch (AWTException e) {
	e.printStackTrace();
}*/


//driver.findElements(By.xpath("//class[contains(.,'Submit')]")).size();

//*[@id='task|NoRelationship|Form|Mscrm.Form.task.SaveAsComplete']/span/a/span

/*			waitUntilElementVisible(Constants.comments_textbox, 30);
comments_textbox.click();
comments_textbox.sendKeys("test");*/
/*			waitTime(1000L);
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
StringSelection name = new StringSelection(job_number);
clipboard.setContents(name, null);
try {
	(new Robot()).keyPress(java.awt.event.KeyEvent.VK_CONTROL);		
	(new Robot()).keyPress(java.awt.event.KeyEvent.VK_V);
	(new Robot()).keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
} catch (AWTException e) {
	e.printStackTrace();
}
waitUntilElementVisible(Constants.pe_search_job_button, 30);
pe_search_job_button.click();
String job = Constants.link_xpath_part1 + job_number + Constants.link_xpath_part2;
waitUntilElementVisible(job, 10);
driver.findElement(By.xpath(job)).click();*/
//driver.switchTo().defaultContent();	
/*			
			int size = driver.findElements(By.tagName("iframe")).size();
			System.out.println(size);
			List<WebElement> el = driver.findElements(By.xpath("//*"));
		    int count=0;
		    for ( WebElement e : el ) {
		     System.out.println( e.getTagName()+"    "+e.getText());
		     count++;
		    }
			*/