package com.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import com.base.TestBase;
import com.util.Constants;

public class CityPayPage extends TestBase {
/*	WebDriver driver;
	public CityPayPage(WebDriver dr) {
		driver = dr;
	}*/
	
/*	@FindBy(xpath=Constants.resubmit_button)
	public WebElement resubmit_button;
	@FindBy(xpath=Constants.preview_to_file_button)
	public WebElement preview_to_file_button;
	@FindBy(xpath=Constants.click_go_next_button)
	public WebElement click_go_next_button;
	@FindBy(xpath=Constants.final_legal_contect_checkbox)
	public WebElement final_legal_contect_checkbox;
	@FindBy(xpath=Constants.file_button)
	public WebElement file_button;
	@FindBy(xpath=Constants.global_cancel_button)
	public WebElement global_cancel_button;*/
	
	
	// City Pay
	public void cityPay(String pay_now) {
		if (!pay_now.equals("")) {
			if (count(Constants.pay_now_button_disabled) == 0) {
				System.out.println(convertedTimestamp() + " **************** " + "PayNowTest");
				String parentWindowContact = driver.getWindowHandle();
				for (int i = 1; i < 20; i++) {
					wait(2);
					if (pay_now.contains("Elevator")) { // ELEVATOR
						// DO NOTHING
					} 
					else
						filterJob(user);
					test = rep.startTest("City Pay");
					if (pay_now.contains("Elevator")) { // ELEVATOR
						clickAndWait("//span[text()='Pay Now']", "//button[text()='Yes']");
//						click("//span[text()='Pay Now']");
						clickButton("Yes");
						waitInvisible("//button[text()='Yes']");
					} else {
						clickAndWait(Constants.pay_now_button, Constants.pay_now_confirm_button);
//						click(Constants.pay_now_button); // REST OF WORK TYPES
						waitUntilISpinnersInvisible();
						wait(3);
						waitVisible60(Constants.pay_now_confirm_button);
						doubleclick(Constants.pay_now_confirm_button);
//						clickAndWait(Constants.pay_now_confirm_button, "//b[contains(text(),'Please do not click Back')]");
						waitInvisible(Constants.pay_now_confirm_button);
					}
					wait(5);
					if ((driver.getWindowHandles().size()) > 1) {
						// driver.close();
						wait(1);
						break;
					}
				}
				for (int i = 1; i < 20; i++) {
					
/*					Set<String> handleswindow = driver.getWindowHandles();
					for (String windowHandle : handleswindow) {
						wait(1);
						driver.switchTo().window(windowHandle);
						driver.manage().window().maximize();
					}*/
					
					
					
					Set<String> handles = driver.getWindowHandles();
					Iterator<String> itr = handles.iterator();
					String newWindow = itr.next();
					driver.switchTo().window(newWindow);
					driver.manage().window().maximize();

					Set<String> handleswindow = driver.getWindowHandles();
					for (String windowHandle : handleswindow) {
						wait(1);
						driver.switchTo().window(windowHandle);
						driver.manage().window().maximize();
					}
					if (!driver.getTitle().equals("Certificate Error: Navigation Blocked")) {
						
						System.out.println(" You are in the wrong window");
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().defaultContent();
						driver.switchTo().window(tabs.get(0));
						driver.switchTo().window(tabs.get(1));
						
						
						
					if (count("//a[@id='overridelink']") > 0)
						break;
					}
/*						System.out.println(" You are in the wrong window");
					if (count("//a[@id='overridelink']") > 0)
						break;*/
				}
				while (count("//a[@id='overridelink']") > 0) {
					driver.navigate().to("javascript:document.getElementById('overridelink').click()");
					wait(5);
					if (count("//a[@name='overridelink']") == 0)
						break;
					refreshPage();
				}
				waitVisible60(Constants.pay_continue_button);
				if (pay_now.contains("credit")) {
//					click("//a[@title='Pay by Credit Card']"); 
					clickAndWait("//a[@title='Pay by Credit Card']", "//p[@class='intro'][contains(.,'charged a service fee')]");
					
//					waitInvisible("//p[@class='intro'][contains(.,'pay by electronic check')]");
					waitVisible("//p[@class='intro'][contains(.,'Credit and debit card payments')]");
					type(Constants.pay_first_name_cc, "Bob");
					type(Constants.pay_last_name_cc, "Smith");
					type(Constants.pay_address_cc, "888 5 Ave");
					type(Constants.pay_city_cc, "New York");
					type(Constants.pay_zip_cc, "10021");
					type(Constants.pay_phone_cc, "2125558888");
					type(Constants.pay_email_cc, "mmazay@buildings.nyc.gov");
					type(Constants.pay_email_confirm_cc, "mmazay@buildings.nyc.gov");
					click(Constants.pay_continue_button_cc);
					waitInvisible60(Constants.pay_continue_button_cc);
					click(Constants.pay_next_button);
					type(Constants.pay_name_on_card, "Bob Smith");
					type(Constants.pay_card_number, "4111111111111111");
					select(Constants.pay_exp_month, "01");
					select(Constants.pay_exp_year, "2020");
					type(Constants.pay_cvv, "333");
				} else {
					type(Constants.pay_first_name, "Bob");
					type(Constants.pay_last_name, "Smith");
					type(Constants.pay_address, "888 5 Ave");
					type(Constants.pay_city, "New York");
					type(Constants.pay_zip, "10021");
					type(Constants.pay_phone, "2125558888");
					type(Constants.pay_email, "mmazay@buildings.nyc.gov");
					type(Constants.pay_email_confirm, "mmazay@buildings.nyc.gov");
					click(Constants.pay_continue_button_ec);
					waitInvisible60(Constants.pay_continue_button_ec);
					click(Constants.pay_next_button);
					type(Constants.pay_name_on_account, "Bob Smith");
					type(Constants.account_number, "123456789");
					type(Constants.account_number_confirm, "123456789");
					type(Constants.aba_routing_number, "021000089");
				}
				click(Constants.pay_next_button);
				waitInvisible60(Constants.pay_next_button);
				click(Constants.pay_now_button_final);
				waitInvisible60(Constants.pay_now_button_final);
				
				wait(10);
				if(!CONFIG.getProperty("env").contains("8085")) {
					while (count("//a[@id='overridelink']") > 0) {
						driver.navigate().to("javascript:document.getElementById('overridelink').click()");
						wait(5);
						if (count("//a[@name='overridelink']") == 0)
							break;
						refreshPage();
					}
				}
				
				assertTextPresent("Receipt Details", "Receipt Details");
				
				wait(2);
				setConfigBrowser("Chrome");
				driver.switchTo().window(parentWindowContact);
				waitVisible(Constants.ok_button);
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				
			    try {
			        Set<String> windows = driver.getWindowHandles();
			        Iterator<String> iter = windows.iterator();
			        String[] winNames=new String[windows.size()];
			        int i=0;
			        while (iter.hasNext()) {
			            winNames[i]=iter.next();
			            i++;
			        }

			        if(winNames.length > 1) {
			            for(i = winNames.length; i > 1; i--) {
			            	driver.switchTo().window(winNames[i - 1]);
			            	driver.close();
			            }
			        }
			        driver.switchTo().window(winNames[0]);
			    }
			    catch(Exception e){         
			        e.printStackTrace();
			    }
			}
			driver.close();
		}
		successMessage("cityPay");
	}

}