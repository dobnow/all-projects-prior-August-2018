package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.TestBase;
import com.util.Constants;

public class DobHomePage extends TestBase {
	WebDriver driver;
	public DobHomePage(WebDriver dr) {
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
	
	public void houseNumber(String housenumber) {	
		if(!housenumber.equals("")){
	 		waitUntilElementVisible(Constants.search_house_number, 30);
	 		search_house_number.sendKeys(housenumber);
		}
	}	
	
	public void streetNumber(String streetnumber) {	
		if(!streetnumber.equals("")){
	 		waitUntilElementVisible(Constants.search_street_number, 30);
	 		search_street_number.sendKeys(streetnumber);
		}
	}	
		
	public void boroughList(String borough) {	
		if(!borough.equals("")){
	 		waitUntilElementVisible(Constants.search_borough_list, 30);
	 		search_borough_list.sendKeys(borough);
		}
	}	
	
	public void selectBorough(String borough) {	
		if(!borough.equals("")){
	 		waitUntilElementVisible(Constants.search_select_borough, 30);
	 		search_select_borough.sendKeys(borough);
		}
	}	
	
	public void searchProperty(String search) {	
		if(!search.equals("")){
	 		waitUntilElementVisible(Constants.search_search_button, 30);
	 		search_search_button.click();
		}
	}	

	/*
	public void searchLocationInfo(String housenumber, String streetnumber, String borough, String search){	
		if(!housenumber.equals("")){
			houseNumber(housenumber); 
			streetNumber(streetnumber);
			boroughList(borough);
			selectBorough(borough);
			searchProperty(search);
			
		}
	}
*/	
	public void loginToPortal(String login_email) {
		if (!login_email.equals("")) {
			while(driver.findElements(By.xpath(Constants.job_number_search)).size() <= 0) {
				System.out.println("portal login from home");
				navigate(dob_now_url);
				type(Constants.welcome_email, login_email);
				type(Constants.welcome_password, OR_PROPERTIES.getProperty("password"));
				click(Constants.welcome_login_button);
				waitUntilISpinnersInvisible();
				while (count(Constants.incorrect_email_and_password_message) != 0) {
					System.out.println("Email and Password combination is incorrect");
					navigate(dob_now_url);
					type(Constants.welcome_email, login_email);
					type(Constants.welcome_password, OR_PROPERTIES.getProperty("password"));
					click(Constants.welcome_login_button);
					waitInvisible(Constants.welcome_login_button);
				}
				click(Constants.dob_now_build_component);
				waitInvisible(Constants.dob_now_build_component);
				waitUntilISpinnersInvisible();
			}
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
/*			if(component.equals("safety")){
		 		waitUntilElementVisible(Constants.dob_now_safety_component, 30);
		 		dob_now_safety_component.click();
			}*/
		}
	}
	
}