package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.TestBase;
import com.util.Constants;

public class CrmHomePage extends TestBase {
	WebDriver driver;
	public CrmHomePage(WebDriver dr) {
		driver = dr;
	}
	
	@FindBy(xpath=Constants.search_house_number)
	public WebElement search_house_number;
	@FindBy(xpath=Constants.search_street_number)
	public WebElement search_street_number;
	@FindBy(xpath=Constants.search_borough_list)
	public WebElement search_borough_list;
	@FindBy(xpath=Constants.search_select_borough)
	public WebElement search_select_borough;
	@FindBy(xpath=Constants.search_search_button)
	public WebElement search_search_button;
	@FindBy(xpath=Constants.welcome_email)
	public WebElement welcome_email;
	@FindBy(xpath=Constants.welcome_password)
	public WebElement welcome_password;
	@FindBy(xpath=Constants.welcome_login_button)
	public WebElement welcome_login_button;
	@FindBy(xpath=Constants.dob_now_build_component)
	public WebElement dob_now_build_component;
	@FindBy(xpath=Constants.dob_now_safety_component)
	public WebElement dob_now_safety_component;
	@FindBy(xpath=Constants.sign_out_link)
	public WebElement sign_out_link;
	
	public void loginCPE(String user_name) {	
		if(!user_name.equals("")){
			waitTime(5000L);
			navigate(crm_url);
			waitTime(5000L);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection name = new StringSelection(user_name);
			StringSelection pass = new StringSelection(OR_PROPERTIES.getProperty("password_crm"));
			clipboard.setContents(name, null);
			try {
				(new Robot()).keyPress(java.awt.event.KeyEvent.VK_CONTROL);
				(new Robot()).keyPress(java.awt.event.KeyEvent.VK_V);
				waitTime(500);
				(new Robot()).keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
				(new Robot()).keyPress(java.awt.event.KeyEvent.VK_TAB);
				waitTime(500);
				clipboard.setContents(pass, null);
				(new Robot()).keyPress(java.awt.event.KeyEvent.VK_CONTROL);
				(new Robot()).keyPress(java.awt.event.KeyEvent.VK_V);
				waitTime(500);
				(new Robot()).keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
				(new Robot()).keyPress(java.awt.event.KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	}	
	
	public void loginPE(String user_name) {	
		if(!user_name.equals("")){
			waitTime(5000L);
			navigate(crm_url);
			waitTime(5000L);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection name = new StringSelection(user_name);
			StringSelection pass = new StringSelection(OR_PROPERTIES.getProperty("password_crm"));
			clipboard.setContents(name, null);
			try {
				(new Robot()).keyPress(java.awt.event.KeyEvent.VK_CONTROL);
				(new Robot()).keyPress(java.awt.event.KeyEvent.VK_V);
				waitTime(500);
				(new Robot()).keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
				(new Robot()).keyPress(java.awt.event.KeyEvent.VK_TAB);
				waitTime(500);
				clipboard.setContents(pass, null);
				(new Robot()).keyPress(java.awt.event.KeyEvent.VK_CONTROL);
				(new Robot()).keyPress(java.awt.event.KeyEvent.VK_V);
				waitTime(500);
				(new Robot()).keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
				(new Robot()).keyPress(java.awt.event.KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void streetNumber(String streetnumber) {	
		if(!streetnumber.equals("")){
	 		waitUntilElementVisible(Constants.search_street_number, 30);
	 		search_street_number.sendKeys(streetnumber);
		}
	}	
		


	public void login(String signature, String email, String password) {
		if(!signature.equals("")){
			navigate(dob_now_url);
	 		waitUntilElementVisible(Constants.welcome_email, 30);
	 		welcome_email.sendKeys(email);
	 		welcome_password.sendKeys(password);
	 		welcome_login_button.click();
	 		waitUntilElementVisible(Constants.dob_now_build_component, 30);
	 		dob_now_build_component.click();
		}
	}	
	
	
	public void loginEmail(String email) {	
		if(!email.equals("")){
	 		waitUntilElementVisible(Constants.welcome_email, 30);
	 		welcome_email.sendKeys(email);
		}
	}	

	public void loginPassword(String password) {	
		if(!password.equals("")){
		welcome_password.sendKeys(password);
		}
	}
	
	public void clickLoginButton(String login) {	
		if(!login.equals("")){
			welcome_login_button.click();
	 		waitUntilElementVisible(Constants.dob_now_build_component, 30);
	 		dob_now_build_component.click();
		}
	}
	
	public void selectComponent(String runornot, String component) {	
		if(!runornot.equals("")){
			if(component.equals("build")){
		 		waitUntilElementVisible(Constants.dob_now_build_component, 30);
		 		dob_now_build_component.click();
			}
			if(component.equals("safety")){
		 		waitUntilElementVisible(Constants.dob_now_safety_component, 30);
		 		dob_now_safety_component.click();
			}
		}
	}
	
}