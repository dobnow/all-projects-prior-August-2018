package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class CrmDashboardPage extends TestBase {
	WebDriver driver;
	public CrmDashboardPage(WebDriver dr) {
		driver = dr;
	}
	
/*	public void profSertAdministrator(String user_name,String assert_filing_status,String work_type, String no_pw2,String qa_decision,String accept_docs_pre_pw2,String accept_tr) { 
		if (!user_name.equals("")) {
			System.out.println("BEGIN " + convertedTimestamp() + " **************** " + "profSertAdministratorTest");
//			loginToCrm(user_name);
			CrmTR1Page tr1 = PageFactory.initElements(driver, CrmTR1Page.class);
			CrmTR8Page tr8 = PageFactory.initElements(driver, CrmTR8Page.class);
			CrmPW2Page pw2 = PageFactory.initElements(driver, CrmPW2Page.class);
			CrmDocumentsPage docs = PageFactory.initElements(driver, CrmDocumentsPage.class);
			CrmTaskFormPage taskform = PageFactory.initElements(driver, CrmTaskFormPage.class);
			
			loginToCrm(user_name);
// not required			pw2.viewAcceptPW2Documents(user_name, assert_filing_status, work_type, no_pw2, accept_tr);
			tr8.viewAcceptTR8ProgressInspection(user_name, assert_filing_status, work_type, accept_tr);
//			docs.profSertAdminnViewAcceptDocuments(user_name, assert_filing_status, work_type, accept_documents);
			tr1.viewAcceptTR1FuelOil(user_name, assert_filing_status, work_type, accept_tr);
			tr1.viewAcceptTR1Final(user_name, assert_filing_status, work_type, accept_tr);
//			pw2.viewAcceptPW2Docs(user_name, assert_filing_status, work_type, no_pw2, accept_tr);
			
			taskform.qaDecision(user_name, assert_filing_status, work_type, qa_decision);
//			taskform.isuePermit(user_name, assert_filing_status, work_type, qa_decision);
		}
	}*/
	
	public void qaAdministrator(String user_name, String assert_filing_status, String work_type, String no_pw2, String qa_decision, String accept_documents, String accept_tr) { 
		if (!user_name.equals("")) {
			System.out.println("BEGIN " + convertedTimestamp() + " **************** " + "QaAdministratorTest");
//			loginToCrm(user_name);
			CrmTR1Page tr1 = PageFactory.initElements(driver, CrmTR1Page.class);
			CrmTR8Page tr8 = PageFactory.initElements(driver, CrmTR8Page.class);
			CrmPW2Page pw2 = PageFactory.initElements(driver, CrmPW2Page.class);
/*			CrmDocumentsPage docs = PageFactory.initElements(driver, CrmDocumentsPage.class);
			CrmTaskFormPage taskform = PageFactory.initElements(driver, CrmTaskFormPage.class);*/
			
	//		loginToCrm(user_name);
//			docs.qaAdminViewAcceptDocuments(user_name, assert_filing_status, work_type, accept_documents);

	//		tr8.viewAcceptTR8ProgressInspection(user_name, assert_filing_status, work_type, accept_tr);
	//		tr1.viewAcceptTR1FuelOil(user_name, assert_filing_status, work_type, accept_tr);
	//		tr1.viewAcceptTR1Final(user_name, assert_filing_status, work_type, accept_tr);
//			pw2.viewAcceptPW2Documents(user_name, assert_filing_status, work_type, no_pw2, accept_tr);
//			pw2.viewAcceptPW2Docs(user_name, accept_pw2_docs, work_type);
			
//			docs.qaAdminViewAcceptDocuments(user_name, assert_filing_status, work_type, accept_documents);

//			taskform.qaAction(user_name, assert_filing_status, work_type, qa_decision);
//			taskform.qaDecision(user_name, assert_filing_status, work_type, qa_decision);
		}
	}
	
}