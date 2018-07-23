package com.util;

import java.util.Hashtable;

public class Constants {

//PATHs
	public static String TEXT_PROPERTIES = System.getProperty("user.dir")+"//src//com//config//text.properties";
	public static String CONFIG_FILE_PATH = System.getProperty("user.dir")+"//src//com//config/config.properties";
	public static String OR_PROPERTIES = System.getProperty("user.dir")+"//src//com//config//OR.properties";
	public static String JOB_NUMBER = System.getProperty("user.dir")+"//src//com//config//job_number.properties";
//	public static String testCases = System.getProperty("user.dir")+"//src//com//data//Test Cases.xlsx";		// mac

	public static String firefoxPath = System.getProperty("user.home")+"\\AppData\\Local\\Mozilla Firefox\\firefox.exe"; 
	public static String testCases = System.getProperty("user.dir")+"\\src\\com\\data\\Test Cases.xlsx";
	public static String testCasesSubs = System.getProperty("user.dir")+"\\src\\com\\data\\Test Cases subs.xlsx";
	
	
	public static String testCasesPlm = System.getProperty("user.dir")+"\\src\\com\\data\\Test Cases Pl.xlsx";
	public static String testCasesFab4 = System.getProperty("user.dir")+"\\src\\com\\data\\Test Cases Fab4.xlsx";
	public static String testCasesesEctrical = System.getProperty("user.dir")+"\\src\\com\\data\\Test Cases Elc.xlsx";
	public static String testCasesesElevator = System.getProperty("user.dir")+"\\src\\com\\data\\Test Cases Elv.xlsx";
	public static String testCasesesAssembly = System.getProperty("user.dir")+"\\src\\com\\data\\Test Cases Pa.xlsx";
	public static String testCasesesLaa = System.getProperty("user.dir")+"\\src\\com\\data\\Test Cases Laa.xlsx";
	
	public static String testCasesesBoilers = System.getProperty("user.dir")+"\\src\\com\\data\\boilers\\Test Cases.xlsx";
	public static String chromePath = System.getProperty("user.home")+"\\drivers\\chromedriver.exe";
	public static String iePath = System.getProperty("user.home")+"\\drivers\\IEDriverServer.exe";
	public static String geckoPath = System.getProperty("user.home")+"\\drivers\\geckodriver.exe";
//	public static String chromePath = System.getProperty("user.dir")+"\\tools\\chromedriver.exe";
//	public static String iePath = System.getProperty("user.dir")+"\\tools\\IEDriverServer.exe";
//	public static String geckoPath = System.getProperty("user.dir")+"\\tools\\geckodriver.exe"; 
	public static String uploadFolder = System.getProperty("user.dir")+"\\src\\com\\data\\";
	public static String sFilePath = System.getProperty("user.dir")+"\\src\\com\\config\\job_number.txt";
// ENVIRONMENTS
	public static final String dob_now_protocol_qa = "http://";
	public static final String dob_now_protocol_stage = "https://";
	public static final String dob_now_host = "msswvw";
//	public static final String dob_8085 = "mstwva-dobcrm03.buildings.nycnet:8085/index.html";
	public static final String dob_8085 = "mstwva-dobcrm03.buildings.nycnet:8085/Build/index.html";
	
	
	public static final String dob_now_stage_444 = "msswvw-dobcrmpw.nycnet:444/index.html";
	
	public static final String stage_443 = "msswvw-dobcrmpw.nycnet/Publish/DOBNowPortal/index.html";
	public static final String stage_444 = "msswvw-dobcrmpw.nycnet:444/Publish/DOBNowPortal/Build/index.html";
	public static final String electrical_stage_444 = "msswvw-dobcrmpw.nycnet:444/Publish/DOBNowPortal/Build/index.html";
	public static final String crm_stage = "http://msswva-dobcrmfe.nycnet:5555/DOBCRMSTG/main.aspx";
	public static final String crm_test = "http://mstwva-dobcrm01:5555/DOBCRMTEST/main.aspx ";
	public static final String dob_now_waiver_deferral_test = "";
// GLOBAL ITEMS
	public static final String spinner = "//*[contains(.,'spinner')]";
	public static final String spinner2 = "//*[contains(.,'veil-portal')]";
	public static final String please_wait = " //i[@class='fa fa-spinner']"; // REAL VISIBLE
	public static final String loading = "//div[@id='veil']";

	
	public static final String global_dob_logo = "//img[@ng-src='images/DOB-NOW-logo.png']";
	public static final String global_first_filter_field = "//input[@ng-model='colFilter.term']";
	public static final String global_notification_message = "//p[contains(@ng-bind-html,'ngDialogData')]";
	public static final String notification = "//p[contains(@ng-bind-html,'ngDialogData')]";
	public static final String save_button = "//span[@class='glyphicon glyphicon-floppy-disk']";
	public static final String global_save_step_button = "//span[@class='glyphicon glyphicon-floppy-disk']";
	public static final String ok_button = "//button[contains(.,'OK')]";
	public static final String yes_button = "//button[contains(.,'Yes')]";
	public static final String global_notification_ok_button = "//button[contains(.,'OK')]";
	public static final String global_required_label = "//div[@class='ui-grid-cell-contents'][contains(.,'Required')]";
	public static final String filter_my_jobs_button = "//button[@id='filter-dropdown']";
	public static final String portal_email_field = "//input[contains(@id,'mail')]";
	public static final String global_save_form_button = "//button[@ng-click='save()']";
	public static final String items_per_page = "//select[@ng-model='grid.options.paginationPageSize']";
	public static final String global_loading_spinner = "//*[contains(.,'veil-portal')]";
	public static final String global_loading_spinner_2 = "//div[@ng-show='showLoadingJobInfoGrid']";
	public static final String global_loading_spinner_subs = "//div[@class='col-xs-12 col-sm-12 col-md-12 text-center veil-portal-spinner']";
	public static final String global_loading_spinner_subs_2 = "//div[@class='col-xs-12 col-sm-12 col-md-12 veil-portal-AN ng-scope";
	public static final String pay_now_spinner = "//i[@class='fa fa-spinner fa-pulse fa-3x fa-fw build-color']";
	public static final String dialog_box_overlay = "//div[@class='ngdialog-overlay']";
	public static final String document_status_part1 = "//*[@id='fixedviews']/div[2]/div/div/uib-accordion/div/div[2]/div[2]/div/div[4]/div/div[1]/div[2]/div[2]/div/div[";
	public static final String document_status_part2 = "]/div/div[3]/div";
	public static final String global_upload_icon = "//i[@class='fa fa-upload']";
	public static final String global_upload_icon_xparth_part1 = "(//i[@class='fa fa-upload'])[";
	public static final String global_upload_icon_xparth_part2 = "]";
	public static final String my_work_permits_tab = "//a[@ng-click='tab.setTab(2)']";
	public static final String my_sign_off_requests_tab = "//a[@ng-click='tab.setTab(6)']";
	public static final String job_label_subs_part_1 = "(//b[contains(.,'";
	public static final String job_label_subs_part_2 = "')])[1]";
	public static final String job_label_subs_xpath_elec = "//*[@id='fixedSideNav']/nav/div[2]/div/h3/span/strong";

	public static final String click_to_view_icon = "//i[@class='glyphicon glyphicon-new-window window-icon']"; 
			//span[@class='window-icon-text'][contains(.,'Click to View')]";
	public static final String global_email_preview_dropdown = "//*[@id='typeahead-405-1214-option-0']/a/strong";
//	public static final String job_label = "//*[@id='frmportal']/div[1]/span/b";
	public static final String job_label = "//b[contains(text(),'Job#')]";
	
	public static final String job_label_sign = "//*[@id='frmFab4Portal']/div[1]/span[1]/b";
	
	public static final String inspection_label = "//h4[contains(.,'Inspection Category')]";
	public static final String upload_special_inspector_file = "//button[@title='Click Here to Upload/View Special Inspector Seal & Signature']";
	public static final String upload_progress_inspector_file = "//button[@title='Click Here to Upload/View Progress Inspector Seal & Signature']";
	
	public static final String identified_yes_label = "//div[text()='Yes']";
	public static final String identified_no_label = "//div[text()='No']";
	
	public static final String tr1_upload_special_inspector_file = "//button[@title='Click Here to Upload/View Special Inspector Seal & Signature']";
	public static final String tr1_upload_progress_inspector_file = "//button[@title='Click Here to Upload/View Progress Inspector Seal & Signature']";
	public static final String progress_inspection_label = "//*[@id='specialProgressInspSection']/div[2]/div[3]/div/i";
	public static final String global_add_button = "//button[contains(.,'Add')]";
	public static final String upload_icon = "//i[@class='fa fa-upload']";
	public static final String choose_file_button = "//input[@type='file']";
	public static final String upload_button = "//button[text()='Upload']";
	
	public static final String global_cancel_button = "//button[@ng-click='cancel()']";
	public static final String cancel_button = "//button[text()='Cancel']";
	public static final String global_refresh_button = "//span[@class='glyphicon glyphicon-refresh']";
	public static final String link_xpath_part1 = "//a[contains(.,'"; //a[contains(.,'Façade')]
	public static final String link_xpath_part2 = "')]";
/*	public static final String email_xpath_part1 = "//strong[contains(.,'";
	public static final String email_xpath_part2 = "')]";*/
	public static final String email_xpath_part1 = "//strong[text()='";
	public static final String email_xpath_part2 = "']";
	
	public static final String preview_resubmit_button = "//span[@class='glyphicon glyphicon-file']";
		
	public static final String preview_to_file_button = "(//button[contains(.,'Preview to File')])[1]";
	
	public static final String preview_to_file_button_el = "//button[@class='btn btn-info dob_button'][@ng-click='Submit()']";
	
	public static final String resubmit_button = "(//button[contains(.,'Resubmit')])[1]";
	public static final String application_preview_label = "//h4[contains(.,'view')]";
	public static final String return_to_filing_view = "//button[contains(text(),'Return to filing')]"; // ng-click="cancel()"><i class="fa fa-repeat
	public static final String number_of_pages_label = "//span[@class='label pull-right portal-fonts']";
	public static final String number_of_pages = "//span[contains(.,'Page :    /')]";
	public static final String click_go_next_button = "//button[@ng-click='goNext()']";
	public static final String final_legal_contect_checkbox = "//input[@id='finalLegalContentACK']";
	public static final String file_button = "//button[@ng-click='File(frmelvPreview)']";
// DOB NOW HOMEPAGE
	public static final String sign_out_link = "//*[contains(text(),'Sign Out')]";
	public static final String search_house_number = "//input[@id='housenumber']";
	public static final String search_street_number = "//input[@id='streetnumber']";
	public static final String search_borough_list = "//select[@id='sel1']";
	public static final String search_select_borough = "//option[contains(.,'Manhattan')]"; // option value="1">Manhattan</option
	public static final String search_search_button = "()//button[contains(.,'Search')])[1]";
	public static final String welcome_email = "//input[@id='txtLoginUserName']";
	public static final String welcome_password = "//input[@id='txtLoginPassword']";
	public static final String welcome_login_button = "//button[contains(.,'Login')]";
	public static final String job_number_search = "//a[contains(.,'Job Number Search')]";
	public static final String job_search_input_box = "//input[@id='jobSearchInputBox']";
	public static final String search_button = "//button[contains(.,'Search')]";
// SELECT COMPONENT PAGE
	public static final String dob_now_build_component = "//img[@src='images/build-logo-button.png']";
	public static final String dob_now_safety_component = "//img[@src='images/safety-button-logo.png']";
// DASHBOARD 
	public static final String job_filing_button = "//button[@ng-click='NewAppOptions()']";
	public static final String job_filing_label = "//span[contains(.,'Job Filing Id')]";
	public static final String job_filing_modal = "//div[@class='row col-xs-12 col-sm-12 col-md-12 modal-body portal-fonts']";
	
	public static final String paa_confirm_button_yes = "(//a[@title='Process Payment'])[3]";
	public static final String work_type_part1 = "//input[@type='checkbox'][@name='rdWorktype'][@ng-model='";
	public static final String work_type_part2 = "FilingWorktype']";
	
	public static final String new_installation_radio = "//input[@id='rdNewApp1']";
	public static final String alteration_replacement_radio = "//input[@id='rdNewApp2']";
	public static final String elevator_radio = "//input[@type='radio'][@id='rdNewAppDevice4']";
	
	public static final String select_device_submit_button = "//button[@ng-click='ok()']";
	
	public static final String checkbox_antenna = "(//input[@name='rdWorktype'])[4]"; //        ng-model="AntennaFilingWorktype
	public static final String submit_work_type_button = "//button[@ng-click='ok()'][text()='Submit']";
	public static final String filing_next_button = "//button[@ng-click='next()']";
	
	public static final String job_filing_next_button = "//span[@class=''][text()='Next']";
//	public static final String device_elevator = "//input[@type='radio'][@id='rdNewAppDevice4']";
	
	public static final String pw1_tab = "//a[contains(.,'Plans/Work (PW1)')]";
	public static final String filtered_job = "//*[@id='dashboardGrid1']/div[1]/div[3]/div[2]/div/div/div/div[1]/div"; 
	//*[@id='dashboardGrid1']/div[1]/div[3]/div[2]/div/div/div/div[1]/div
	public static final String found_job_part_one = "//div[contains(text(),'";
	public static final String found_job_part_two = "')]";
	
	//div[@class='ui-grid-cell-contents' and contains(text(),'Yes')]
	//a[contains(.,'Plans/Work (PW1)')]
// Plans/Work (PW1)
	//     1. Location Information
	public static final String pw1_1_house_number = "//input[contains(@id,'LocHouse')]";
	public static final String pw1_1_street_name = "//input[contains(@id,'StreetName')]";
	public static final String pw1_1_borough = "//select[contains(@id,'LocBoroughNYC')]";
	public static final String pw1_1_block = "//input[@id='txtPWLocBlock']";
	public static final String pw1_1_lot  = "//input[@id='txtPWLocLot']";
	public static final String pw1_1_bin = "//input[@id='txtPWLocBin']";
	public static final String pw1_1_community_board = "//input[@id='txtPWLocCBNo']";
	public static final String pw1_1_zip_code = "//input[@id='txtPWLocZip']";
	public static final String pw1_1_apt_suite_number = "//input[@id='txtPWLocAptCondoNo']";
	
	public static final String proposed_work_summary = "//textarea[@id='txtPWLocCBNo']";
	// Work on floors
	public static final String plumbing_work_on_floors = "//input[@id='txtPWLocWorkFloor']";
	public static final String pw1_1_add_work_floors_button = "//button[contains(.,'Add')]";//button[contains(.,' Add')]
	public static final String pw1_1_add_work_floors_button_subs = "//button[@ng-click='PlanWorkAntennaLocationModal()']";
	public static final String pw1_work_on_floors_location = "//select[@id='ddlCADescWork']";
	public static final String pw1_1_work_on_floors_select_code_and_description = "//select[@id='ddlCADescWork']";
	public static final String pw1_1_work_on_floors_floor_number_from = "//input[@id='WFfloorNumberFrom']";
	public static final String pw1_1_work_on_floors_floor_number_to = "//input[@id='WFfloorNumberTo']";
	public static final String pw1_1_work_on_floors_description_of_work = "//textarea[@id='txtDOW']";
	public static final String pw1_1_work_on_floors_add_button = "//button[@ng-click='submitForm();']";
	
	//     2. Applicant Information
	public static final String pw1_2_email = "//input[@name='txtPWAppEmail2']";
	public static final String pw1_2_license_type = "//select[@id='txtPWAppLicType']";
	public static final String pw1_2_license_number = "//input[@id='txtPWAppLicNum']";
	public static final String pw1_2_last_name = "//input[@id='txtPWAppLastName']";
	public static final String pw1_2_first_name = "//input[@id='txtPWAppFirstName']";
	public static final String pw1_2_middle_name = "//input[@id='txtPWAppMiddleName']";
	
	public static final String pw1_2_business_lookup = "//select[@id='txtPWAppbusiness']"; //select[@id='txtPWAppBusinessName']
	public static final String business_name_list = "//select[contains(@id,'BusinessName')]";
	public static final String pw1_2_business_phone = "//input[@id='txtPWAppBusinessTelephone']";
	public static final String pw1_2_business_address = "//input[@id='txtPWAppBusinessAddress']";
	public static final String pw1_2_business_fax = "//input[@id='txtPWAppBusinessFax']";
	public static final String pw1_2_city = "//input[@name='txtPWAppCity']";
	public static final String pw1_2_state = "//input[@name='txtPWAppState']";
	public static final String pw1_2_zip = "//input[@name='txtPWAppZip']";
	public static final String pw1_2_mobile = "//input[@name='txtPWAppMobileTelephone']";
	//     3. Filing Representative
	public static final String pw1_3_email = "//input[@name='txtPWFRepEmail']";
	public static final String pw1_3_ = "//input[@name='txtPWFRepRegNo']";
	public static final String pw1_3_registration_number = "//input[@name='txtPWFRepRegNo']";
	public static final String pw1_3_first_name = "//input[@name='txtPWFRepFName']";
	public static final String pw1_3_middle_name = "//input[@name='txtPWFRepMName']";
	public static final String pw1_3_last_name = "//input[@name='txtPWFRepLName']";
	public static final String pw1_3_business_name = "//input[@name='txtPWFRepBusinessName']";
	public static final String pw1_3_business_phone = "//input[@name='txtPWFRepBusinessTelephone']";
	public static final String pw1_3_business_address = "//input[@name='txtPWFRepBusinessAddress']";
	public static final String pw1_3_city = "//input[@name='txtPWFRepCity']";
	public static final String pw1_3_state = "//input[@name='txtPWFRepState']";
	public static final String pw1_3_mobile = "//input[@name='txtPWFRepMobileTelephone']";
	//     4. Filing Review Type
	public static final String pw1_4_filling_review_type_list = "//select[@id='ddlPWProfCertificate']";
	public static final String pw1_4_filling_review_select_standard_plan = "//option[contains(.,'Standard Plan Examination')]";
	public static final String pw1_4_filling_review_select_professional_examination = "//option[contains(.,'Professional Certification')]";
	//     5. Job/Project Types
	public static final String pw1_5_acceptance_requested_yes = "//input[@id='radPWDirective14Accept'][@value='true']";
	public static final String pw1_5_acceptance_requested_no = "//input[@id='radPWDirective14Accept'][@value='false']";
	//     6. Work Types
	public static final String pw1_6_sign_new_work = "//input[@name='rdNewApp'][@value='1']";
	public static final String pw1_6_sign_legalization = "//input[@name='rdNewApp'][@value='2']";
	
	public static final String pw1_6_new_antenna = "//input[@name='rdNewApp'][@value='1']"; //input[@ng-click='clearUnSelectedWorkTypeCheckBoxes()']
	public static final String pw1_6_existing_antenna = "//input[@name='rdNewApp'][@value='2']";
	public static final String pw1_6_both_antennas = "//input[@name='rdNewApp'][@value='3']";
	
	public static final String pw1_6_if_structural_work_is_included = "//input[@id='rdstructuralWorkIncluded'][@value='false']";

	
	public static final String pw1_6_structural_work_included_yes = "//input[@id='rdstructuralWorkIncluded'][@value='true']";
	public static final String pw1_6_structural_work_included_no = "//input[@id='rdstructuralWorkIncluded'][@value='false']";
	public static final String antenna_have_no_more_than_8_square_feet_yes = "//input[@id='rdZoningExemptionsdiameter'][@value='true']";
	public static final String antenna_have_no_more_than_8_square_feet_no = "//input[@id='rdZoningExemptionsdiameter'][@value='false']";
	public static final String cellar_equipment_occupy_more_than_5_of_floor_yes = "//input[@id='rdZoningExemptionsSqfeet'][@value='true']";
	public static final String cellar_equipment_occupy_more_than_5_of_floor_no = "//input[@id='rdZoningExemptionsSqfeet'][@value='false']";
	public static final String antennas_higher_than_6_feet_of_the_roof_yes = "//input[@id='rdZoningExemptionsBulkhead'][@value='true']";
	public static final String antennas_higher_than_6_feet_of_the_roof_no = "//input[@id='rdZoningExemptionsBulkhead'][@value='false']";
	/*
	public static final String pw1_6_new_work _only = "//input[@class='ng-pristine ng-valid ng-valid-required ng-touched']";
	public static final String pw1_6_legalization_only = "//input[@class='ng-valid ng-valid-required ng-touched ng-dirty']";
	public static final String pw1_6_both = "//input[@class='ng-valid ng-valid-required ng-dirty ng-touched']";
	public static final String pw1_6_plumbing = "//input[@name='chkPWWrkTypeP2']";
	// chkPWWrkTypePl vs chkPWWrkTypeP2 ?
	public static final String pw1_6_plumbing = "//input[@id='chkPWWrkTypePl']";
	public static final String pw1_6_sprinkler = "//input[@id='chkPWWrkTypeSp1']";
	public static final String pw1_6_standpipe = "//input[@id='chkPWWrkTypeSd1']";
	public static final String pw1_6_sign = "//input[@id='chkPWWrkTypeAntenna']";
	*/
	//     8. Additional Information
	
	
	
	public static final String pw1_8_legalization_cost = "//input[@name='txtPWEstLegalizationJobCost']";
	public static final String pw1_8_total_legalization_floor_area = "//input[contains(@name,'txtPWTotalConsFlrArea2')]";
	
	
	public static final String pw1_8_estimated_new_work_cost = "//input[@name='txtPWEstJobCost']";
	public static final String pw1_8_total_new_work_floor_area = "//input[contains(@name,'txtPWTotalConsFlrArea')]";
	public static final String pw1_8_building_type = "//select[@name='ddlPWBuildingType']";
	public static final String pw1_8_associated_yes = "//input[@id='rdFeeNewBuildingApplicationSubmitPermit'][@value='true']";
	public static final String pw1_8_associated_no = "//input[@id='rdFeeNewBuildingApplicationSubmitPermit'][@value='false']";

	public static final String pw1_8_associated_bis_job_number = "//input[@id='txtNewBuildingJobNumber']";
	public static final String pw1_8_estimate_fee_button = "//button[@ng-click='CalculateModal()']";
	
	public static final String pw1_8_height = "//input[@id='txtPWHeight']";
	/*
	public static final String pw1_8_estimated_legalization_job_cost = "//input[@name='txtPWEstLegalizationJobCost']";
	public static final String pw1_8_total_legalization_floor_area = "//input[@name='txtPWTotalConsFlrArea2']";
	public static final String pw1_8_height= "//input[@id='txtPWHeight']";
	*/
	//     9. Additional Considerations, Limitations or Restrictions

	public static final String pw1_9_review_requested_under_code = "//select[@id='ddlPWReviewReq1']";
	public static final String pw1_9_facade_alteration_yes = "//input[@id='rdPWFaçadeAlteration'][@value='true']"; //input[@id='rdPWFaÃ§adeAlteration' and contains(text(),'Yes')]   //     [position()=1]
	public static final String pw1_9_facade_alteration_no = "//input[@id='rdPWFaçadeAlteration'][@value='false']"; //input[@id='rdPWFaÃ§adeAlteration' and contains(text(),'No')] //     [position()=2]
	public static final String pw1_9_adult_establishment_yes = "//input[@name='rdPWAdultEstablishment'][@value='true']";
	public static final String pw1_9_adult_establishment_no = "//input[contains(@name,'rdPWAdultEstablishment')][@value='false']";
	public static final String pw1_9_quality_housing_yes = "//input[@name='rdPWQualityHousing'][@value='true']";
	public static final String pw1_9_quality_housing_no = "//input[@name='rdPWQualityHousing'][@value='false']";
	public static final String pw1_9_little_e_or_rd_site_yes = "//input[@name='rdPWLittleSite'][@value='1']";
	public static final String pw1_9_little_e_or_rd_site_no = "//input[@name='rdPWLittleSite'][@value='2']";
	public static final String pw1_9_unmapped_cco_street_yes = "//input[@name='rdPWUnmappedCCoStreet1'][@value='true']";
	public static final String pw1_9_unmapped_cco_street_no = "//input[@name='rdPWUnmappedCCoStreet1'][@value='false']";
	
	public static final String pw1_9_requesting_legalization_yes = "//input[@name='rdPWRequestLegalization'][@value='true']";
	public static final String pw1_9_requesting_legalization_no = "//input[@name='rdPWRequestLegalization'][@value='false']";
	public static final String pw1_9_site_safety_job_no = "//input[@name='rdPWSiteSafety'][@value='false']";
	
	
	
	public static final String pw1_9_crfn_restrictive_declaration_easement_yes = "//input[@name='rdPWCrfnRestrictive'][@value='true']";
	public static final String pw1_9_crfn_restrictive_declaration_easement_no = "//input[@name='rdPWCrfnRestrictive'][@value='false']";
	public static final String pw1_9_crfn_zoning_exhibit_yes = "//input[@name='rdPWCRFNZoningExhibit'][@value='true']";
	public static final String pw1_9_crfn_zoning_exhibit_no = "//input[@name='rdPWCRFNZoningExhibit'][@value='false']";
	public static final String pw1_9_address_violations_yes = "//input[@name='rdPWFilingAddrVio'][@value='true']";
	public static final String pw1_9_address_violations_no = "//input[@name='rdPWFilingAddrVio'][@value='false']";
	public static final String pw1_9_comply_with_local_laws_yes = "(xxx)[1]";
	public static final String pw1_9_comply_with_local_laws_no = "(xxx)[2]";
	public static final String pw1_9_bsa_calendar_numbers_yes = "//input[@name='rdPWBSACalender'][@value='true']";
	public static final String pw1_9_provide_bsa = "//textarea[@id='txtPWProvideBSA']";
	public static final String pw1_9_bsa_calendar_numbers_no = "//input[@name='rdPWBSACalender'][@value='false']";
	public static final String pw1_9_cpc_calendar_numbers_yes = "//input[@name='rdPWCPCCalender'][@value='true']";
	public static final String pw1_9_last_each_law_number = "//textarea[@id='txtPWCPCCalendarNumbers']";
	public static final String pw1_9_cpc_calendar_numbers_no = "//input[@name='rdPWCPCCalender'][@value='false']";
	public static final String pw1_9_high_rise_team_tracking = "//input[@id='txtPWHighRiseTeamtracking']";
	public static final String pw1_9_includes_partial_demolition_yes = "//input[@id='rdPWWorkIncludes'][@value='true']";
	public static final String pw1_9_includes_partial_demolition_no = "//input[@id='rdPWWorkIncludes'][@value='false']";
	public static final String pw1_9_stability_affected_by_work_yes = "//input[@name='rdPWStructuralStab'][@value='true']";
	public static final String pw1_9_stability_affected_by_work_no = "//input[@name='rdPWStructuralStab'][@value='false']";
	/*
	public static final String pw1_9_review_building_code_yes = "(//select[@name='ddlPWReviewReq1'])[1]";
	public static final String pw1_9_review_building_code_no = "(//select[@name='ddlPWReviewReq1'])[2]";
	public static final String pw1_9_single_room_occupancy_yes = "(xxx)[1]";
	public static final String pw1_9_single_room_occupancy_no = "(xxx)[2]";
	public static final String pw1_9_loft_board_yes = "(//input[@name='rdLoftBoard'])[1]";
	public static final String pw1_9_loft_board_no = "(//input[@name='rdLoftBoard'])[2]";
	public static final String pw1_9_site_safety_job_yes = "(//input[@name='rdPWSiteSafety'])[1]";
	public static final String pw1_9_site_safety_job_no = "(//input[@name='rdPWSiteSafety'])[2]";
	public static final String pw1_9_included_in_lmccc_yes = "(//input[@name='rdPWLMCC'])[1]";
	public static final String pw1_9_included_in_lmccc_no = "(//input[@name='rdPWLMCC'])[2]";
	public static final String pw1_9_landmark_yes = "(//input[@name='rdPWLandmark'])[1]";
	public static final String pw1_9_landmark_no = "(//input[@name='rdPWLandmark'])[2}";
	*/
	//     10. NYCECC Compliance
	public static final String pw1_10_work_in_compliance_with_nycecc = "//input[@id='rblPWNYCECC'][@value='true']";
	public static final String pw1_10_code_compliance_path = "//select[@id='ddlPWCodeCompliancePath']";
	public static final String pw1_10_energy_nalysis = "//select[@name='ddlPWEnergyAnalysis']";
	public static final String pw1_10_exempt_from_nycecc = "(//input[@name='rblPWNYCECC'])[2]";
	public static final String pw1_10_exempt_type = "//select[@name='ddlPWExemptNYCECC']";
	//     11. Job Description
	public static final String job_description_for_new_work = "//textarea[contains(@id,'JobDesc')]";
	public static final String job_description_legalization = "//textarea[@id='txtPWLegalizationJobDesc']";
	//     12. Zoning Characteristics
	public static final String pw1_12_district = "//input[@id='txtPWDistrictS']";
	public static final String pw1_12_overlay = "//input[@id='txtPWOverlay']";
	public static final String pw1_12_special_district = "//input[@id='txtPWSpecialDist']";
	public static final String pw1_12_map_number = "//input[@id='txtPWMapNumber']";
	//     13. Building Characteristics
/*	public static final String pw1_13_occupancy_classification = "//select[@id='ddlPWOccupancyClassification']";
	public static final String pw1_13_construction_classification = "//select[@id='ddlPWConstructionClassification']";
	public static final String pw1_13_multiple_dwelling_classification = "//select[@id='ddlPWMultipleDwelling']";*/
	public static final String pw1_13_mixed_use_type_yes = "(//input[@name='rblPWMixedBuildType'])[1]";
	public static final String pw1_13_mixed_use_type_no = "(//input[@name='rblPWMixedBuildType'])[2]";
	public static final String pw1_13_building_height_existing = "//input[@id='txtPWBuildingHeightExi']";
	public static final String pw1_13_building_height_proposed = "//input[@id='txtPWBuildingHeightPro']";
	public static final String pw1_13_building_stories_existing = "//input[@id='txtPWBuildingStoriesExi']";
	public static final String pw1_13_building_stories_proposed = "//input[@id='txtPWBuildingStoriesPro']";
	public static final String pw1_13_building_dwelling_units_existing = "//input[@id='txtPWBuildingDwellingUnitsExi']";
	public static final String pw1_13_building_dwelling_units_proposed = "//input[@id='txtPWBuildingDwellingUnitsPro']";
// 15
	
	public static final String construction_material_fence = "//select[@id='ddlPWConstructionMaterial']";
	public static final String describe_construction_material = "//input[@id='txtPWConstructionMaterial']";
	public static final String construction_material_sidewalk = "(//input[@id='txtPWConstructionMaterial'])[last()]";
	
	public static final String size_of_shed = "//input[@id='txtPWShedSize']";
	
// 16. Curb Cut Description
	public static final String pw1_16_size_of_cutout = "//input[@id='txtPWSizeofcut']";
	public static final String pw1_16_distance_to_nearest_corner = "//input[@id='txtPWDistanceToNearestCorner']";
	public static final String pw1_16_distance_from_nearest_property = "//input[@id='txtPWDistancefromNearestProperty']";
	public static final String pw1_16_which_side_nearest_to_property = "//select[@id='ddlSideCCProperty']";
	public static final String pw1_16_to_streat = "//input[@id='txtPWTostreet']";
	public static final String pw1_16_this_curb_will_provide_access_to = "//button[@ng-click='toggleDropdown()']";
	public static final String pw1_16_which_side_of_street_curb_on = "//select[@id='ddlPWSideCCStreet']";
	public static final String pw1_16_on_grade_yes = "(//input[@id='rdPWOnGrade'])[1]";
	public static final String pw1_16_on_grade_no = "(//input[@id='rdPWOnGrade'])[2]";
	public static final String pw1_16_over_vault_yes = "(//input[@id='rdPWOverVault'])[1]";
	public static final String pw1_16_over_vault_no = "(//input[@id='rdPWOverVault'])[2]";
	public static final String pw1_16_other_structure_yes = "(//input[@id='rdPWOtherStructure'])[1]";
	public static final String pw1_16_other_structure_no = "(//input[@id='rdPWOtherStructure'])[1]";
	public static final String pw1_16_sidewalk_within_8ft_yes = "(//input[@id='rdPWSideWalkObstruction'])[1]";
	public static final String pw1_16_sidewalk_within_8ft_no = "(//input[@id='rdPWSideWalkObstruction'])[2]";
	public static final String pw1_16_sidewalk_to_destroy_yes = "(//input[@id='rdPWSideWalkObstructionDestroyed'])[1]";
	public static final String pw1_16_sidewalk_to_destroy_no = "(//input[@id='rdPWSideWalkObstructionDestroyed'])[2]";
	public static final String pw1_16_infront_of_ajoining_yes = "(//input[@id='rdPWCurbCutAdjProperty'])[1]";
	public static final String pw1_16_infront_of_ajoining_no = "(//input[@id='rdPWCurbCutAdjProperty'])[2]";
	public static final String pw1_16_agencies_required_documents = "//select[@id='agenciesAndReqdDoc']";
	//     18. Fire Protection Equipment
	public static final String pw1_18_fire_alarm_existing_yes = "(//input[@name='rblPWExistFireAlarm'])[1]";
	public static final String pw1_18_fire_alarm_existing_no = "//input[contains(@id,'ExistFireAlarm')][@value='false']";
	public static final String pw1_18_fire_alarm_proposed_yes = "(//input[@name='rblPWPropFireAlarm'])[1]";
	public static final String pw1_18_fire_alarm_proposed_no = "//input[contains(@id,'PropFireAlarm')][@value='false']";
	public static final String pw1_18_fire_supression_existing_yes = "(//input[@name='rblPWExistFireSupression'])[1]";
	public static final String pw1_18_fire_supression_existing_no = "//input[@id='rblPWExistFireSupression'][@value='false']";
	public static final String pw1_18_fire_supression_proposed_yes = "(//input[@name='rblPWPropFireSupression'])[1]";
	public static final String pw1_18_fire_supression_proposed_no = "//input[@id='rblPWPropFireSupression'][@value='false']";
//Sign 18	
	public static final String pw1_18_sprinkler_existing_yes = "//input[@id='rblPWExistSprinkler1'][@value='true']";
	public static final String pw1_18_sprinkler_existing_no = "//input[contains(@id,'ExistSprinkler')][@value='false']";
	public static final String pw1_18_sprinkler_proposed_yes = "//input[@id='rblPWPropSprinkler1'][@value='true']";
	public static final String pw1_18_sprinkler_proposed_no = "//input[contains(@id,'PropSprinkler')][@value='false']";
	public static final String pw1_18_standpipe_existing_yes = "//input[@id='rblPWExistStandpipe1'][@value='true']";
	public static final String pw1_18_standpipe_existing_no = "//input[contains(@id,'ExistStandpipe')][@value='false']";
	public static final String pw1_18_standpipe_proposed_yes = "//input[contains(@id,'PropStandpipe')][@value='true']";
	public static final String pw1_18_standpipe_proposed_no = "//input[contains(@id,'PropStandpipe')][@value='false']";
	
	//     20. Site Characteristics
	public static final String pw1_20_tidal_wetlands_yes = "(//input[@id='rdPWSiteTidal'])[1]";
	public static final String pw1_20_tidal_wetlands_no = "//input[@id='rdPWSiteTidal'][@value='false']";
	public static final String pw1_20_coastal_erosion_hazard_area_yes = "(//input[@id='rdPWSiteCoastalErosion'])[1]";
	public static final String pw1_20_coastal_erosion_hazard_area_no = "//input[@id='rdPWSiteCoastalErosion'][@value='false']";
	public static final String pw1_20_fire_districs_yes = "(//input[@id='rdPWSiteFireDistrict'])[1]";
	public static final String pw1_20_fire_districs_no = "//input[@id='rdPWSiteFireDistrict'][@value='false']";
	public static final String pw1_20_freshwater_wetlands_yes = "(//input[@id='rdPWSiteFreshwater'])[1]";
	public static final String pw1_20_freshwater_wetlands_no = "//input[@id='rdPWSiteFreshwater'][@value='false']";
	public static final String pw1_20_urban_renewal_yes = "(//input[@id='rdPWSiteUrbanRenewal'])[1]";
	public static final String pw1_20_urban_renewal_no = "//input[@id='rdPWSiteUrbanRenewal'][@value='false']";
	//     20A. Flood Hazard Area Information
	public static final String pw1_20A_flood_hazard_area_yes = "(//input[@id='rdPWSiteFloodHazardArea'])[1]";
	public static final String pw1_20A_flood_hazard_area_no = "(//input[@id='rdPWSiteFloodHazardArea'])[2]";
	//     22. Asbestos Abatement Compliance
	public static final String pw1_22_requires_asbestos_abatement = "//input[contains(@id,'AsbestosComplaince')][@value='1']";
	public static final String pw1_22_not_asbestos_project = "(//input[@name='rdPWAsbestosComplaince'])[2]";
	public static final String pw1_22_dep_asp_5_ontrol_o = "//input[@id='txtPWBuildingDEP']";
	public static final String pw1_22_exempt_from_asbestos = "//input[contains(@name,'AsbestosComplaince')][@value='3']";  
	public static final String pw1_comments_textarea = "//textarea[@id='txtPWComments']";
	// 22 Sign
	public static final String pw1_22_requires_asbestos_abatement_sign = "//input[@id='ddlPWAsbestosComplaince'][@value='1']";
	
	
	/*
	//     23. Sign Details
	public static final String pw1_23_add_new_sign = "//button[@class='btn btn-link pull-left']";
	public static final String pw1_23_lessee_email = "//input[@id='txtLesseeEmail']";
	public static final String pw1_23_relationship_to_Owner = "//input[@id='txtRelationshiptoOwner']";
	public static final String pw1_23_purpose_of-sign = "//select[@id='ddlPurpose']";
	public static final String pw1_23_material_of_the_sign = "//select[@id='ddlMaterialSign']";
	public static final String pw1_23_weight_of_sign = "//input[@id='txtWeight']";
	public static final String pw1_23_total_surface_area_of_this_sign = "//input[@id='txtTotalsurfacesignarea']";
	public static final String pw1_23_total_square_feet = "//input[@id='txtTotalsquarefeet']";
	public static final String pw1_23_total_zoning_lot_frontage = "//input[@id='txtTotalZoninglotfrontage']";
	public static final String pw1_23_total_surface_area_of_signs_in_zoning_lot= "//input[@id='txtZoningLot']";
	public static final String pw1_23_estimated_Job_cost = "//input[@id='txtEstimatedJobCost']";
	public static final String pw1_23_estimated_sign_fee = "//input[@id='txtEstimatedFeeJobCost']";
	public static final String pw1_23_maximum_allowable_surface_area_on_zoning_lot = "//input[@id='txtAllowableSurface']";
	public static final String pw1_23_sign_type = "//select[@id='ddlType']";
	public static final String pw1_23_sign_location = "//select[@id='ddlLocation']";
	public static final String pw1_23_sign_wording = "//textarea[@id='txtSignWordingDesc']";
	public static final String pw1_23_sign_designed_for_changeable_copy_yes = "(//input[@id='radDesignChangeble'])[1]";
	public static final String pw1_23_sign_designed_for_changeable_copy_no = "(//input[@id='radDesignChangeble'])[2]";
	public static final String pw1_23_oak_have_interest_in_sign_yes = "(//input[@id='radOacIntrest'])[1]";
	public static final String pw1_23_oak_have_interest_in_sign_no = "(//input[@id='radOacIntrest'])[2]";
	public static final String pw1_23_within_900_of_arterial_highway_yes = "(//input[@id='radArterialhighwayt'])[1]";
	public static final String pw1_23_within_900_of_arterial_highway_no = "(//input[@id='radArterialhighwayt'])[2]";
	public static final String pw1_23_within_200_of_park_yes = "(//input[@id='radParkAcre'])[1]";
	public static final String pw1_23_within_200_of_park_no = "(//input[@id='radParkAcre'])[2]";
	public static final String pw1_23_understand_and_agree = "//input[@id='chkSignCompleteStatement']";
	*/
	//     24. Comments
	public static final String pw1_24_comments = "//textarea[@id='txtPWComments']";
	public static final String pw1_confirm_save_button = "//button[@ng-click='addressConfirmationModalOk()']";
// WORK PERMIT (PW2)
	public static final String pw2_work_permit_step = "//a[contains(.,'Work Permit (PW2)')]";
// DEMOLITION SUBMITTAL (DS1)
	public static final String ds1_demolition_submittal_step = "//a[contains(.,'Demolition Submittal (DS1)')]";
	//     2. Applicant Information
	public static final String ds1_2_applicant_ds1same_as_ps1_yes = "//input[@id='rdPw1ApplicantYes']";
	public static final String ds1_2_applicant_ds1same_as_ps1_no = "//input[@id='rdPw1ApplicantNo']";
	//     3. Demolition Description and Certification
	public static final String ds1_3_submittal_type= "//input[@id='chkSubmittalTypeInitial']";
	public static final String ds1_3_demolition_type = "//input[@id='chkDemolitionTypePartial']";
	//     3B.Demolition work will involve , per BC3306.5(authorized preparers indicated in parenthesis)
	public static final String ds1_3B_non_mechanical_demolition_methods = "//input[@id='chkNonMechdem']";
	public static final String ds1_3B_other_than_hand_held_mechanical = "//input[@id='chkOtherHandHeldMechEqui']";
	public static final String ds1_3B_work_on_exterior_of_uilding = "//input[@id='chkWorkOnExterior']";
	public static final String ds1_3B_description = "//textarea[@id='txtextDescdemo']";
	public static final String ds1_3B_i_prepared_demolition_documents = "//input[@id='DesignApplicantStatementsMainCheckPW1']";
	public static final String ds1_3B_save = "//button[contains(.,'Save')]"; //  span class="glyphicon glyphicon-floppy-disk"></span
	public static final String ds1_save_button = "//button[contains(.,'Save')]";
	public static final String ds1_notification_ok_button = "//button[contains(.,'OK')]";
	public static final String pw1_filing_message = "//p[contains(.,'aria-describedby')]";
// ANTENNA SCOPE OF WORK
	public static final String scope_of_work_step = "//a[contains(.,'Scope of Work')]";
	
	public static final String edit_icon = "//i[@class='fa fa-edit']";
	
	public static final String add_button = "//button[contains(.,'Add')]";
	public static final String add_new_sign_button = "//button[contains(.,'Add New Sign')]";
	public static final String sign_relationship = "//input[@id='txtRelationshiptoOwner']";
	public static final String i_hereby_state = "//input[@id='chkSignCompleteStatement']";
	public static final String sign_purpose = "//select[@id='ddlPurpose']";
	public static final String sign_material = "//select[@id='ddlMaterialSign']";
	public static final String sign_weight = "//input[@id='txtWeight']";
	public static final String sign_square_feet = "//input[@id='txtTotalsquarefeet']";
	public static final String sign_zoning = "//input[@id='txtTotalZoninglotfrontage']";
	public static final String sign_surface = "//input[@id='txtZoningLot']";
	public static final String sign_maximum_surface = "//input[@id='txtAllowableSurface']";
	
	
	public static final String sign_type = "//select[@id='ddlType']";
	public static final String sign_type_of_illumination = "//select[@id='ddlTypeIllumination']";
	public static final String sign_location = "//select[@id='ddlLocation']";
	public static final String sign_height_above_curb = "//input[@id='txtHeightroof']";
	public static final String sign_total_surface_area = "//input[@id='txtTotalsurfacesignarea']";
	public static final String sign_estimated_cost = "//input[@id='txtEstimatedJobCost']";
	public static final String sign_description = "//textarea[@id='txtSignWordingDesc']";
	
	public static final String sign_changeable_copy_no = "//input[@id='radDesignChangeble'][@value='0']";
	public static final String sign_oak_have_an_interest_no = "//input[@id='radOacIntrest'][@value='0']";
	public static final String sign_arterial_highway_no = "//input[@id='radArterialhighwayt'][@value='0']";
	public static final String sign_within_view_of_park_no  = "//input[@id='radParkAcre'][@value='0']";
	
	
	public static final String sidewalk_shed = "//input[@id='radParkAcre']";
	public static final String construction_fence = "//input[@id='chkCAWrkTypeSd']";
	
	public static final String scaffold_type = "//select[@id='ddlShedType']";
	public static final String scaffold_going_to_extend_no  = "//input[@id='rdsupportedscaffold'][@value='false']";
	public static final String how_scaffold_supported = "//select[@id='ddlScaffoldSupported']";
	public static final String scaffold_any_related_equipment_no = "//input[@id='rdRelatedConstruction'][@value='false']";
	
	public static final String shed_type = "//select[@id='ddlSidewalkShedType']";
	public static final String sidewalk_going_to_extend_no  = "//input[@id='rdSideWalksupportedscaffold'][@value='false']";
	public static final String how_shed_supported = "//select[@id='ddlSideWalkScaffoldSupported']";
	public static final String sidewalk_any_related_equipment_no  = "//input[@id='rdSideWalkRelatedConstruction'][@value='false']";
	
	public static final String fence_height = "//input[@id='SoWFenceHeight']";
	public static final String fence_location = "//select[@id='ddlLocationOfFence']";
	
	
	public static final String add = "//*[text()='Add']";
	public static final String add2 = "(//*[text()='Add'])[2]";
	
	public static final String sow_modal = "//h4[text()='Scope of Work Detail']";
	
	public static final String sow_detail_select_category = "//select[@id='ModalSectionType']";
	public static final String sow_detail_select_scope_includes = "//select[@id='SystemSelection']";
	
	public static final String trash_can_icon = "//i[@class='fa fa-trash']";
	
	public static final String antenna_scope_of_work_step = "//a[contains(.,'Scope of Work')]";
	// Are new Antennas, RRH and/or Arrays proposed at this location?
	public static final String asw_are_new_antenna_rrh_array_prposed_yes = "//input[@id='rdAnyNewAntenna'][@value='true']";
	public static final String asw_are_new_antenna_rrh_array_prposed_no = "//input[@id='rdAnyNewAntenna'][@value='false']";
	//input[@id='rdAnyNewAntenna']
	public static final String asw_there_any_existing_antennas_yes = "//input[@id='rdAnyExistingAntenna'][@value='true']";
	public static final String asw_there_any_existing_antennas_no = "//input[@id='rdAnyExistingAntenna'][@value='false']";
	// Are there any existing Antennas at this location? YES
	public static final String asw_number_of_existing_antennas = "//input[@id='SoWACExistingAntennaNum']";
	public static final String asw_number_of_existing_rrh = "//input[@id='SoWACExistingRRHNum']";
	public static final String asw_number_of_arays = "//input[@id='SoWACArraysNum']";
	public static final String asw_number_of_sectors = "//input[@id='SoWACSectorsNum']";
	public static final String asw_antennas_to_be_removed = "//input[@id='SoWACAntennaRemNum']";
	public static final String asw_antennas_to_be_modified_replaced = "//input[@id='SoWACAntennaModReplacedNum']";
	public static final String asw_rrh_to_be_removed = "//input[@id='SoWACRRHRemNum']";
	public static final String asw_rrh_to_be_modified_replaced = "//input[@id='SoWACRRHModReplacedNum']";
	public static final String asw_arrays_to_be_removed = "//input[@id='SoWACArraysRemNum']";
	public static final String asw_arrays_to_be_modified_replaced = "//input[@id='SoWACArraysModReplacedNum']";
	public static final String asw_sectors_to_be_removed = "//input[@id='SoWACSectorsRemNum']";
	public static final String asw_sectors_to_be_modified_replaced = "//input[@id='SoWACSectorsModReplacedNum']";
	// Are new Antennas, RRH and/or Arrays proposed at this location? YES
	public static final String asw_number_of_new_antennas_installed = "//input[@id='SoWACNewAntennaNum']";
	public static final String asw_number_of_new_rrh = "//input[@id='SoWACNewRRHNum']";
	public static final String asw_number_of_new_arrays = "//input[@id='SoWACNewArraysNum']";
	public static final String asw_number_of_new_sectors = "//input[@id='SoWACNewSectorsNum']";
	// #############
	public static final String asw_specify_supporting_structures_for_antenna_array_rrh  = "//button[@ng-click='toggleDropdown()']";  //button[contains(.,'SelectÂ ')]
	//public static final String asw_specify_supporting_structures_for_antenna_array_rrh  = "//button[@class='dropdown-toggle btn btn-default']";
	public static final String asw_supporting_structure_list_select = "//a[contains(.,'XXXXXXXXX')]"; //a[contains(.,' Parapet')];
	public static final String asw_structural_work_included = "(//input[@id='rdAnyStructuralWork'])[1]";
	public static final String asw_structural_work_seperate = "(//input[@id='rdAnyStructuralWork'])[2]";
	public static final String asw_emergency_power_system_new = "(//input[@id='rdEmergencyPowerSystem'])[1]";
	public static final String asw_emergency_power_system_existing = "(//input[@id='rdEmergencyPowerSystem'])[2]";
	public static final String asw_associated_mechanical_work_proposed_yes = "(//input[@id='rdMechWorkProposed'])[1]";
	public static final String asw_associated_mechanical_work_proposed_no = "(//input[@id='rdMechWorkProposed'])[2]";
	//public static final String asw_floor_associated_equipment_located = "//textarea[@ng-change='chkScopeOfWorkChanges()']";
	public static final String asw_what_floor_associated_equipment_located = "//textarea[@ng-change='chkScopeOfWorkChanges()']";
	public static final String asw_save_button = "//button[contains(.,'Save')]";
	public static final String asw_notification_ok_button = "//button[contains(.,'OK')]"; 
//	public static final String asw_confirm_save_button = "//button[contains(.,'Yes')]";
	//public static final String asw_save_button = "//span[@class='glyphicon glyphicon-floppy-disk']"; //button[contains(.,'Save')]
// COST AFFIDAVIT (PW3) 
	public static final String pw3_cost_affidavit_step = "//a[contains(.,'Cost Affidavit (PW3)')]";
	
	public static final String pw3_select_categogy = "//select[@id='ddlCAWorkType']";
	
	public static final String description_of_work = "//textarea[@id='txtDOW']";
	
//         1. Reason For Filing
	public static final String pw3_initial_filing = "//input[@ng-model='jobFilingACObj.IsInitialFiling']";
//		   3. Cost Details
	public static final String pw3_category_of_work_antenna = "//input[@ng-model='jobFilingACObj.AntennaWorkType']";
	public static final String pw3cost_affidavit_step = "//a[contains(.,'Cost Affidavit (PW3)')]";
	public static final String pw3_add_initial_cost_details_button = "//button[contains(.,'Add')]";
	public static final String add_link_sign = "(//span[text()='Add'])[2]";
	public static final String pw3_category_of_work = "//select[@id='ddlCAWorkType']";
	public static final String pw3_description_of_work = "//select[@id='ddlCADescWork']";
	public static final String pw3_description_of_work_list_select = "//option[@value='string:AN - New sector']";
	public static final String pw3_area_units = "//input[@id='Text1']";
	public static final String pw3_area_units_sign = "//input[@id='txtArea']";
	public static final String pw3_unit_cost = "//input[@id='Text2']";
	public static final String pw3_unit_cost_sign = "//input[@id='txtUnitCost']";
	public static final String pw3_cost_details_description_sign = "(//textarea[@id='txtPWJobDesc'])[2]";
	public static final String save_button_sign = "//span[@class='glyphicon glyphicon-ok-sign']";
	public static final String pw3_cost_details_save_button= "//button[@class='btn btn-primary btnCustom']";
	public static final String pw3_save_button = "//button[contains(.,'Save')]";
	public static final String pw3_notification_ok_button = "//button[contains(.,'OK')]";
// Technical Report (TR1)
//		   2. Applicant Information
	public static final String tr1_technical_report_step = "//a[contains(.,'Technical Report (TR1)')]";
	public static final String tr1_are_you_applicant = "//input[@id='chkTR1DesignApplicantType']";
	public static final String tr1_are_you_special_inspector = "//input[@id='chkTR1SpecialInspectionsType']";
	public static final String tr1_are_you_progress_inspector = "//input[@id='chkTR1ProgressInspectionsType']";
	
	public static final String tr1_add_link_spec_sign = "(//span[text()='Add'])[2]";
	public static final String tr1_add_link_prog_sign = "(//span[text()='Add'])[3]";
	
	public static final String tr1_edit_special_inspection_category = "//*[@id='fixedviews']/div[2]/div/div/div[11]/div/div[1]/div[2]/div[2]/div/div/div/div[9]/button";
	public static final String tr1_edit_special_inspec_icon_sign = "(//i[@class='fa fa-edit'])[2]";
	
	public static final String tr1_edit_progress_inspec_icon_sign = "(//i[@class='fa fa-edit'])[3]";
	
	public static final String tr1_edit_progress_inspection_category = "//*[@id='TR1ProgressInsptGrid']/div[1]/div[2]/div[2]/div/div/div/div[8]/button";
	
	
	public static final String select_dropdown = "//button[@ng-click='toggleSelect()']";
	//button[@ng-click='toggleSelect()']
	public static final String tr1_select_requirement_code = "//button[@class='ui-select-bootstrap'][@ng-click='toggleSelect()']";
	public static final String tr1_select_requirement_code_field = "//input[@placeholder='Filter']";
	public static final String tr1_select_requirement_code_filter = "//a[@ng-click='select(i); focus()']";
	public static final String tr1_inspector_email = "//input[@id='txtInspecterEmail']";
	
	public static final String inspector_email_sign = "(//input[@id='txtInspecterEmail'])[2]";
	
	public static final String tr1_license_type = "//select[@id='txtEn2LicType']";
	
	public static final String license_type_list = "//select[contains(@id, 'LicType')]";
	
	public static final String tr1_license_number = "//input[@id='txtENAppLicNum']";
	public static final String tr1_agency_number = "//input[@id='txtAgencyNumber']";
	public static final String tr1_i_take_responcibility = "//input[@type='checkbox'][@id='chkIdentResponsibility']";
	public static final String tr1_i_understand_my_failure_to_file = "//input[@id='chkTR2DesignAppProgress2']";
	public static final String tr1_i_understand_and_agree = "//input[@id='chkTR2DesignAppProgress1']";
	public static final String tr1_save_progress_inspection_button = "//button[@ng-click='save()']";
	public static final String tr1_add_special_inspections_categories = "(//button[contains(.,'Add')])[1]";
	public static final String tr1_add_requirements_list = "//button[@class='ui-select-bootstrap']"; //button[contains(.,'Select')]
	public static final String tr1_add_requirements_list_select = "//a[contains(.,' XXXXXXXXX')]";
	public static final String tr1_add_requirements_save_button = "//button[@ng-click='save()']";
	public static final String tr1_add_progress_inspection_categories = "(//button[contains(.,'Add')])[2]";
	public static final String tr1_add_save_button = "(//button[contains(.,'Save')])[2]";
//	public static final String tr1_save_button = "//button[contains(.,'Save')]";
	public static final String tr1_notification_ok_button = "//button[contains(.,'OK')]";
	public static final String tr1_confirm_upload_button = "//button[contains(.,'Upload')]";
	public static final String tr1_browse_button = "//input[@type='file']";
	public static final String tr1_upload_button = "//button[@id='btnUpload']";
	public static final String tr1_please_wait_message = "//b[contains(.,'Please Wait...')]";
	public static final String tr1_upload_succesfull_message = "//label[@id='lblMessage']";
	public static final String tr1_document_uploaded_ok_button = "//button[@id='btnOKCancel']";
// Technical Report  (TR8)	
	public static final String tr8_technical_report_energy_step = "//a[contains(.,'Technical Report Energy')]";
	public static final String tr8_technical_report_step = "//a[contains(.,'Technical Report (TR1)')]";
	public static final String tr8_are_you_applicant = "//input[@id='chkTR1DesignApplicantType']";
	public static final String tr8_are_you_special_inspector = "//input[@id='chkTR8SpecialInspectionsType']";
	public static final String tr8_are_you_progress_inspector = "//input[@id='chkTR8ProgressInspectionsType']";
	public static final String tr8_select_requirement_code = "//button[@class='ui-select-bootstrap'][@ng-click='toggleSelect()']";
	public static final String tr8_select_requirement_code_field = "//input[@placeholder='Filter']";
	public static final String tr8_select_requirement_code_filter = "//a[@ng-click='select(i); focus()']";
	public static final String tr8_edit_progress_inspection_category = "//*[@id='fixedviews']/div[2]/div/div/div[10]/div[2]/div/div[2]/div[2]/div/div/div/div[8]/button";
	public static final String tr8_edit_special_inspection_category = "//*[@id='TR8ProgressInsptGrid']/div[1]/div[2]/div[2]/div/div/div/div[8]/button";
	
	public static final String tr8_edit_special_inspection_category_sign = "(//i[@class='fa fa-edit'])[2]";

	public static final String tr8_inspector_email = "//input[@id='txtInspecterEmail']";
	public static final String tr8_license_type = "//select[@id='txtEn2LicType']";
	public static final String tr8_i_take_responcibility = "//input[@id='chkIdentResponsibility']";
	public static final String tr8_i_understand_my_failure_to_file = "//input[@id='chkTR2DesignAppProgress2']";
	public static final String tr8_i_understand_and_agree = "//input[@id='identificationofresponsibilities']";//input[@id='identificationofresponsibilities']
	public static final String tr8_save_progress_inspection_button = "//button[@ng-click='save()']";
	public static final String tr8_add_special_inspections_categories = "(//button[contains(.,'Add')])[1]";
	public static final String tr8_add_requirements_list = "//button[@class='ui-select-bootstrap']"; //button[contains(.,'Select')]
	public static final String tr8_add_requirements_list_select = "//a[contains(.,' XXXXXXXXX')]";
	public static final String tr8_add_requirements_save_button = "//button[@ng-click='save()']";
	public static final String tr8_add_progress_inspection_categories = "(//button[contains(.,'Add')])[2]";
	public static final String tr8_add_save_button = "(//button[contains(.,'Save')])[2]";
//	public static final String tr8_save_button = "//button[contains(.,'Save')]";
	public static final String tr8_notification_ok_button = "//button[contains(.,'OK')]";
//	public static final String tr8_upload_file = "//button[@title='Click Here to Upload/View Special Inspector Seal & Signature']";
	public static final String tr8_confirm_upload_button = "//button[contains(.,'Upload')]";
	public static final String tr8_browse_button = "//input[@id='docUploader']";
	public static final String browse_button = "//input[@type='file']";
	//input[@type='file']
	public static final String tr8_upload_button = "//button[@id='btnUpload']";
	public static final String tr8_please_wait_message = "//b[contains(.,'Please Wait...')]";
	public static final String tr8_upload_succesfull_message = "//label[@id='lblMessage']";
	public static final String tr8_document_uploaded_ok_button = "//button[@id='btnOKCancel']";
	public static final String tr8_document_uploaded_ok_button_sign = "//button[@id='btnClose']";
// Statements & Signatures 
	public static final String ss_statement_signatures_step = "//a[contains(.,'Statements & Signatures')]";
	public static final String project_not_require_commissioning = "//input[@id='chkTR2DesignAppNoCommissioning']";
	public static final String ss_i_havepersonally_reviewed_all_information = "//input[@id='DesignApplicantStatementsMainCheckPW1']";
	public static final String ss_fee_exemption_reques_non_profit_yes= "//input[contains(@id,'rblPWFeeExceptReqNonPro')]";
	public static final String ss_fee_exemption_reques_non_profit_yes_sign = "//input[@id='rblPWFeeExceptReqNonPro'][@value='false']";
	public static final String ss_fee_exemption_reques_nycha_hhc_no_sign = "//input[@id='rblPWFeeExceptReqPro'][@value='false']";
	public static final String ss_owners_certifications_yes = "//input[@id='rblPWOwnerCertication1']";
//	public static final String ss_owners_certifications_yes_sign = "//input[@id='rblPWOwnerCertication2']";
	
	public static final String ss_owners_certifications_no = "//input[@id='rblPWOwnerCertication2']";
	public static final String ss_building_to_be_altered_demolished_no = "//input[@id='rblPWBuildingAltered2']";
	
	public static final String ss_owner_is_not_required_to_notify_yes = "//input[contains(@name,'rblPWOwnerNotReq')][@value='true']";
	public static final String ss_owner_is_not_required_to_notify_yes_sign = "//input[@id='rblPWOwnerNotReq'][@value='true']";
	
	public static final String ss_owner_notified_new_york = "//input[@name='rblPWOwnerNotified'][@value='true']";
	public static final String ss_owner_notified_new_york_yes_sign = "//input[@id='rblPWOwnerNotified'][@value='false']";
	
	public static final String ss_owner_type = "//select[@id='ddlPWOwnerType']";
	public static final String ss_partner_email = "//input[@id='txtPWAppEmail1']";
	public static final String ss_i_understand_and_agrree = "//input[@id='chkPWOwnerAcknowledge']";
	public static final String ss_save_button = "//*[@id='fixedviews']/div[4]/button[1]";
// Documents 
	public static final String documents_step = "//a[contains(.,'Documents')]";
	
	
	public static final String no_documents_found_message = "//td[@class='ms-crm-List-MessageText-Lite'][text()='No Document List records found.']";
	
	public static final String crm_username_label = "//span[@class='navTabButtonUserInfoText navTabButtonUserInfoWorker']";
	public static final String crm_document_title_link = "//a[starts-with(@id,'gridBodyTable_lookup_{')]";
	public static final String documents_loading_spinner = "(//div[@ng-show='showLoadingDocRequiredGrid'])[2]";
	public static final String upload_document_icon = "//i[@class='fa fa-upload']";
//	public static final String upload_document_icon = "//button[@ng-click='grid.appScope.uploadDocument(row)']";
	public static final String document_status_required = "//*[text()='Required']";
	public static final String doc_upload_xpath_part1 = "(//button[@ng-click='grid.appScope.uploadDocument(row)'])[";
	public static final String doc_upload_xpath_part2 = "]";	
//	public static final String doc_upload_xpath_part1 = "//*[@id='fixedviews']/div[2]/div/div/uib-accordion/div/div[2]/div[2]/div/div[4]/div/div[1]/div[2]/div[2]/div/div[";
//	public static final String doc_upload_xpath_part2 = "]/div/div[5]/button";
	public static final String doc_upload_file = "(//button[@ng-click='grid.appScope.uploadDocument(row)'])[1]";
	public static final String doc_confirm_upload_button = "//button[contains(.,'Upload')]";
	public static final String doc_browse_button = "//input[@type='file'][contains(@id,'Upload')]";
	public static final String doc_upload_button = "//button[@id='btnUpload']";
	public static final String doc_please_wait_message = "//b[contains(.,'Please Wait...')]";
	public static final String doc_upload_succesfull_message = "//label[contains(text(),'ploaded')]";
	public static final String doc_document_uploaded_ok_button = "//button[@id='btnOKCancel']";
	public static final String doc_additional_supporting_documents = "(//span[contains(.,'Additional Supporting Documents')])[xxx]";
	public static final String doc_add_new_document = "//button[@ng-click='uploadDocument()']";
	public static final String doc_required_document_upload = "(//button[@ng-click='grid.appScope.uploadDocument(row)'])[1]";
	public static final String doc_save_button = "(//button[contains(.,'Save')])[2]";
// Work Permit (PW2) 
	public static final String pw2_ = "//button[@ng-click='AddWorkPermitModal()']";
	public static final String pw2_documents_tab = "//a[@ng-click='setTab(2)']"; // [contains.,('Documents')]
	
	
	
	public static final String pw2_calendar_icon = "//button[contains(@ng-click,'event,0)')]";
	public static final String pw2_calendar_active_day = "//button[@class='btn btn-default btn-sm active']";
	public static final String pw2_calendar_expected_start_day = "//input[@id='ExpecStartDate']";
	public static final String pw2_email = "//input[@id='txtPWAppEmail']";
	public static final String pw2_license_type = "//select[@id='txtPWAppLicType']";
	
	public static final String pw2_registration_tracking_number = "//input[@id='txtWPProviderRegistration']";
	
	public static final String incompleted_work_permit = "//*[@id='fixedviews']/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div";
														  //*[@id="fixedviews"]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div[1]/div
														  //*[@id="fixedviews"]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[1]/div
// 5. Filing Representative*
	 
	public static final String pw2_different_from_applicant_yes = "(//input[@name='ddlWPDifferentFileApp'])[1]";
	public static final String pw2_different_from_applicant_no = "(//input[@name='ddlWPDifferentFileApp'])[2]";
// 6. 
	public static final String pw2_liability = "//input[@ng-model='WorkPermitObj.LiabilityInsurance.InsuranceName']";
//	public static final String pw2_liability_expiration = "//input[@ng-model='WorkPermitObj.LiabilityInsurance.InsuranceExpiryDate']";
	public static final String pw2_liability_expiration_calendar = "//button[@ng-click='openAppCal($event,1)']";
	public static final String pw2_calendar_next_month_arrow = "//i[@class='glyphicon glyphicon-chevron-right']";
	
	public static final String pw2_workers_compensation = "//input[@ng-model='WorkPermitObj.WorkerCompensationInsurance.InsuranceName ']";
	public static final String pw2_workers_compensation_expiration_calendar = "//button[@ng-click='openAppCal($event,2)']";
	
	public static final String pw2_disability = "//input[@ng-model='WorkPermitObj.DisabilityInsurance.InsuranceName']";
	public static final String pw2_disability_expiration_calendar = "//button[@ng-click='openAppCal($event,3)']";
// 7. 
	public static final String pw2_construction_superintendent = "//input[@value='1']";
	public static final String pw2_site_safety_coordinator = "//input[@value='2']";
	public static final String pw2_site_safety_manager = "//input[@value='3']";
	
	public static final String pw2_superintendent_email = "//input[@ng-model='Sup.Email']";
	public static final String pw2_superintendent_lisence_type = "//select[@id='txtWLicType']";
	public static final String pw2_i_undersigned_will_perform_on_behalf  = "//input[@id='chkAntennaApplicantLegalStatementCheck']";
	
	public static final String pw2_work_not_require_adjacent_insurance = "//input[@id='chkWPNotRequiredInsuranceTerms1']";
	public static final String pw2_information_correct_and_complete = "//input[@id='chkPW2LegalApplicantContractorAcknowledge']";
//	public static final String pw2_documents_tab = "//a[@ng-click='setTab(2)']";
	
	public static final String global_file_button = "//button[text()='File']";
	public static final String pw_file_button = "//button[text()='File']";
	public static final String pw2_file_button = "//button[@ng-show='hideSubmit()']";
	public static final String pw2_save_button = "//button[@ng-click='save()']";
	public static final String pw2_cancel_button = "//button[@ng-click='cancel()']";
	public static final String pw2_upload_document_button = "//i[@class='fa fa-upload']";
	public static final String pw2_permit_not_yet_issued = "//*[@id='fixedviews']/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[1]/div";
	public static final String tr1_valid_label = "//i[@ng-if='ShowAgencyvalid']";
	public static final String green_valid_label = "//i[@style='color:forestgreen'][text()='Valid']";
	
	
	//  ELEVATORS
	public static final String filing_includes = "//select[@class='ng-pristine ng-valid ng-valid-required ng-touched']";
	public static final String building_code = "//select[@ng-model='elvFilingObj.BuildingCode']";
	public static final String select_business = "//select[@id='txtPWAppbusiness']";
	
	public static final String designer_email = "//input[@id='txtDPEmail']";
	public static final String designer_license_type = "//select[@id='txtDPLicType']";
	public static final String owner_email = "//input[@id='txtElvOwnerEmail']";
	public static final String owner_license_type = "//select[@id='ddlPWOwnerType']";
	
	public static final String elevator_job_label = "//*[@id='frmElvPortal']/div[2]/div[1]/nav/div[2]/div/h3/span/strong";
	public static final String electrical_permit_number = "//input[@id='txtElectricalNumber']";
	
	public static final String search_by_address = "//input[@name='Address'][@value='2']";
	
	public static final String search_by_house = "//input[contains(@id,'txtHouseNo')]";
	public static final String search_by_street = "//input[contains(@id,'txtStreetName')]";
	public static final String search_by_borough = "//select[contains(@id,'ddlBorough')]";
	
	public static final String search_and_add_button = "//div[@id='addressSearchButton']/button";
	public static final String device_list_checkbox = "//input[@ng-model='device.IsSelected']";
	public static final String add_device_button_disabled = "//button[@ng-click='creatExistingDevice(frmAlterationDevicePopup)'][@disabled='disabled']";
	
	public static final String add_device_button = "//button[@ng-click='creatExistingDevice(frmAlterationDevicePopup)']";

	public static final String device_added_message = "//p[@id='desc'][text()='Device(s) added successfully.']";
	public static final String cannot_use_device_message = "//p[@id='desc'][contains(.,'You cannot select this device')]";
	public static final String open_device_details_tab = "//a[@ng-click='openDeviceDetails(device.DeviceId);']";
	public static final String replace_passenger_with_freight = "//input[@id='rdPassengerToFreight'][value='false']";

	public static final String device_number = "//input[@id='txtDeviceSearch']";
	
	public static final String add_new_device_link = "//button[contains(.,'Add New Device')]";
	public static final String save_device_button = "//span[@class='fa fa-save']";
	public static final String elevator_type = "//select[@id='elevatorOptions']";
	public static final String elevator_sub_type = "//select[@id='elevatorSubOptions']";
	
	public static final String only_elevator_in_building_no = "//input[@id='rdquestion1'][@value='2']";
	public static final String elevator_part_of_destination_dispatch_system_no = "//input[@id='rdquestion2'][@value='2']";
	public static final String an_occupant_evacuation_no = "//input[@id='rdquestion3'][@value='2']";
	public static final String fire_service_access_no = "//input[@id='rdquestion4'][@value='2']";
	public static final String building_meets_stretcher_car_no = "//input[@id='rdquestion5'][@value='2']";
	public static final String device_used_in_conjunction_with_mta_no = "//input[@id='rdquestion6'][@value='2']";
	public static final String device_conforming_with_seismic_no = "//input[@id='rdquestion7'][@value='2']";
	public static final String device_installed_In_ne_hoistway_no = "//input[@id='rdquestion8'][@value='2']";
	public static final String device_equipped_with_fire_fmergency_yes = "//input[@id='rdquestion10'][@value='1']";
	public static final String device_equipped_with_fire_fmergency_no = "//input[@id='rdquestion10'][@value='2']";
	public static final String is_this_loft_law_building_no = "//input[@id='rdquestion12'][@value='2']";
	public static final String device_job_description = "//textarea[@id='txtDeviceJobDescription'] ";
	
	public static final String machine_type = "//select[@id='deviceMachinType']";
	public static final String type_of_machine_brake = "//select[@id='deviceMachinTypeBrake']";
	public static final String type_of_plunger = "//select[@id='devicePlungerType']";
	public static final String machine_location = "//input[@id='txtdeviceMachineLocation']";
	public static final String machine_manufacturer = "//input[@id='txtdeviceMachinManufacture']";
	public static final String machine_model = "//input[@id='txtdeviceMachinModel']";
	public static final String controller_location = "//input[@id='txtdeviceControllerLocation']";
	public static final String controller_manufacturer = "//input[@id='txtdeviceControllerManufacturer']";
	public static final String controller_model = "//input[@id='txtdeviceControllerModel']";

	public static final String completed_checkmark = "//i[@class='fa fa-check-square-o']";
// LABELS	
/*	public static final String device_information_label = "//h4[@id='1'][text()='Device Information']";
	public static final String machine_room_label = "//h4[@id='2'][text()='Machine and Machine Room']";
	public static final String device_general_information_label = "//h4[@id='3'][text()='Device General Information']";
	public static final String cars_and_counterweights_label = "//h4[@id='4'][text()='Cars and Counterweight']";
	public static final String hoistway_opening_label = "//h4[@id='5'][text()='Hoistway Opening']";
	public static final String pit_and_buffers_label = "//h4[@id='6'][text()='Pit and Buffers']";*/
	
	public static final String insurance_fee_information_tab = "//a[@class='ng-binding'][@ng-click='changeCurrentPage(3);']";
	public static final String documents_tab = "//a[@class='ng-binding'][@ng-click='changeCurrentPage(4);']";
	public static final String signatures_tab = "//a[@class='ng-binding'][@ng-click='changeCurrentPage(5);']";
	public static final String test_information_tab = "//a[@class='ng-binding'][@ng-click='changeCurrentPage(2);']";
	public static final String statements_tab = "//a[@class='ng-binding'][@ng-click='changeCurrentPage(4);']";
	
	public static final String device_information_label = "//h4[text()='Device Information']";
	public static final String machine_room_label = "//h4[text()='Machine and Machine Room']";
	public static final String device_general_information_label = "//h4[text()='Device General Information']";
	public static final String cars_and_counterweights_label = "//h4[text()='Cars and Counterweight']";
	public static final String hoistway_opening_label = "//h4[text()='Hoistway Opening']";
	public static final String pit_and_buffers_label = "//h4[text()='Pit and Buffers']";
	
	public static final String elevator_motive_power = "//select[@id='deviceGIElevatorPower']";
	public static final String main_supply_motive_power = "//select[@id='deviceGIMainPower']";
	public static final String travel_from_floor = "//input[@id='txtdeviceGITravelFrom']";
	public static final String travel_to_floor = "//input[@id='txtdeviceGITravelTo']";
	public static final String total_travel = "//input[@id='txtdeviceGITotalTravel']";
	public static final String number_of_stops = "//input[@id='txtdeviceGINumberStop']";
	public static final String capacity = "//input[@id='txtdeviceGICapacity']";
	public static final String speed = "//input[@id='txtdeviceGISpeed']";
	public static final String elevator_control = "//select[@id='deviceGIElevatorControl']";
	public static final String mode_of_operation = "//select[@id='deviceGIModeOperation']";
	
	public static final String load_weightholding_device_yes = "//input[@id='rdbdeviceGILoadweighingdevice'][@value='1']";
	public static final String load_weightholding_device_no = "//input[@id='rdbdeviceGILoadweighingdevice'][@value='2']";
	public static final String glass_hoistway_no = "//input[@id='rdbdeviceGIGlassHoistway'][@value='2']";
	public static final String atrium_evevator_no = "//input[@id='rdbdeviceGIAtriumElevator'][@value='2']";
	public static final String regenerative_drive_no = "//input[@id='rdbdeviceGIRegenerativeDrive'][@value='2']";
	
	public static final String car_safety_type = "//select[@id='dpdeviceCarSafetyType']";
	public static final String counterweight_safety_type = "//select[@id='dpdeviceCounterweightSafetyType']";
	public static final String car_openening = "//select[@id='txtdeviceCarOpening']";
	public static final String car_openening_direction = "//select[@id='deviceCounterweightDirection']";
	public static final String car_gate_door_operation = "//select[@id='deviceCounterweightOperation']";

	public static final String contactType = "//input[@id='txtdeviceContactType']";
	public static final String manufacturer = "//input[@id='txtdeviceManufacturer']";
	public static final String top_emergency_exit_min_area = "//input[@id='txtdeviceTopEmergencyExitMinArea']";
	public static final String top_emergency_exit_min_side = "//input[@id='txtdeviceMinSide']";
	
	public static final String car_inside_dimensions_width_feet = "//input[@id='txtWidthFeet']";
	public static final String car_inside_dimensions_width_inches = "//input[@id='txtWidthinch']";
	public static final String car_inside_dimensions_dept_feet = "//input[@id='txtDepthFeet']";
	public static final String car_inside_dimensions_dept_inches = "//input[@id='txtDepthinch']";
	public static final String car_inside_area = "//input[@id='txtPWTotalConsFlrArea1']";
	
	public static final String sized_for_stretched_requirement_no = "//input[@id='rdbdeviceStrecherRequirement'][@value='2']";
	public static final String glass_car_no = "//input[@id='rdbdeviceGlassCar'][@value='2']";
	public static final String multi_compartment_elevators_no = "//input[@id='rdbdeviceMultiCompartment'][@value='2']";

	public static final String hoist_opening = "//select[@id='deviceHoistwayOpeningDoor']";
	public static final String hoist_opening_direction = "//select[@id='deviceHoistwayOpeningGate']";
	public static final String hoist_operation = "//select[@id='deviceHoistwayOpeningOperation']";
	public static final String hoist_door_features = "//select[@id='deviceHoistwayDoorFeatures']";
	
	
	public static final String landing_on_floors = "//input[@id='txtdeviceHoistwayOpeningLending']";
	public static final String number_of_openings_front = "//input[@id='txtdeviceHoistwayOpeningFront']";
	public static final String number_of_openings_side = "//input[@id='txtdeviceHoistwayOpeningSide']";
	public static final String number_of_openings_rear = "//input[@id='txtdeviceHoistwayOpeningRear']";
	
	public static final String door_monitoring_circuits_no = "//input[@id='rdbDoorMonitoringCircuits1'][@value='2']";
	public static final String free_rated_construction_type_no = "//input[@id='rdbHrFireRatedConstruction1Yes'][@value='2']";
	public static final String self_closing_emergency_door_no = "//input[@id='rdbSelfClosingEmergency1'][@value='2']";
	public static final String interlock_in_hoistway_yes = "//input[@id='rdbInterlockInBlind1'][@value='1']";
	public static final String interlock_in_hoistway_no = "//input[@id='rdbInterlockInBlind1'][@value='2']";
	
	public static final String car_type = "//select[@id='deviceCarBufferType']";
	public static final String car_manufacturer = "//input[@id='txtdeviceCarBufferManufacturer']";
	public static final String engagement_speed = "//input[@id='txtdeviceCarBufferEngagementSpeed']";
	public static final String stroke_feet = "//input[@id='txtdeviceCarBufferStrokeFeet']";
	public static final String stroke_inches = "//input[@id='txtdeviceCarBufferStrokeIn']";
	public static final String car_reduced_stroke_yes = "//input[@id='rdbCarBufferReducedStroke'][@value='1']";
	public static final String car_reduced_stroke_no = "//input[@id='rdbCarBufferReducedStroke'][@value='2']";
	
	public static final String compensation_means = "//select[@id='devicePitBuffersCompensationMeans']";
	public static final String lenght_feet = "//input[@id='txtdevicePitBufferCompensationFeet']";
	public static final String lenght_inches = "//input[@id='txtdevicePitBufferCompensationIn']";
	public static final String buffer_reduced_stroke_no = "//input[@id='rdbCounterweightBufferReducedStroke'][@value='2']";
	public static final String occupied_space_below_no = "//input[@id='rdbOccupiedSpaceBelow'][@value='2']";
	public static final String compensation_tiedown_no = "//input[@id='rdbCompensationtiedown'][@value='2']";
	public static final String counter_weight_guard_no = "//input[@id='rdbCounterweightGuard'][@value='2']";
	
	public static final String sign_of_calendar_icon = "//i[@class='glyphicon glyphicon-calendar']";
	public static final String today_date = "//span[@class='text-info']";
	
	public static final String satisfactory_slider = "//div[@class='slider round']";
	
	
	public static final String estimated_cost = "//input[@id='txtPWEstJobCost']";
	public static final String building_type = "//select[@id='ddlBuildingType']";
	public static final String total_floor_area = "//input[@id='txtTotalFloorArea']";
	public static final String building_stories = "//input[@id='txtBuildingStories']";
	public static final String new_building_app_no = "//input[@id='rdFeeNewBuildingApplicationSubmitPermit2'][@value='false']";
	public static final String job_description = "//textarea[@id='txtPWJobDesc']";	
	// documents
//	driver.findElement(By.CssSelector("a[title='MyServices']")).findElement(By.xpath(".//span[text()='Issues Management']")).click();

	
	public static final String applicant_sign_elv = "//input[@id='DesignApplicantStatementsMainCheck']";
	public static final String design_pro_sign_elv = "//input[@id='DesignProfessionalMainCheck']";
	public static final String replacement_modification_statement = "//input[@id='PERAstatementsMainCheck']";

	public static final String fee_exempion_request_non_profit_yes = "//input[@id='rblPWFeeExceptReqNonPro'][@value='true']";
	public static final String fee_exempion_request_nycha_no = "//input[@id='rblPWFeeExceptReqPro'][@value='false']";
	public static final String owner_sign_elv = "//input[@id='OwnerStatementsMainCheck']";
	
	public static final String inspecting_director_sign_elv = "//input[@id='InspectingDirectorStatementsMainCheck']";
	
	public static final String did_agency_director_perform_inspection = "//input[@id='rdAgencyDirectorPerformedInspection'][@value='";
	
	
	public static final String permit_not_issued_link = "//a[@title='Permit is not yet issued']";
	
	public static final String crm_loading_image = "//img[@id='loading'][@alt='']";
	public static final String crm_close_modal_button = "//button[@id='butBegin'][@class='ms-crm-RefreshDialog-Button'][contains(.,'Close')]";
	public static final String crm_top_nav_search_button = "//*[@id='findCriteriaImg']"; //*[@title='Start search']"; 
	public static final String crm_save_button = "//img[contains(@alt,'Save')]"; //li[@title='Save (CTRL+S) Save the Form']"; 
	public static final String crm_work_permits_label = "//div[@id='customSectionBarr'][contains(.,'Work Permits')]";
	public static final String crm_permit_not_yet_issued_link = "//*[@id='dobnyc_task_clickheretogotoworkpermit']/div[1]/span[1]";
	public static final String crm_certificate_of_insurance_link = "//a[starts-with(@id,'gridBodyTable_lookup_{')]";
	
	public static final String crm_documents_total = "//span[@id='Documents_ItemsTotal']";
	public static final String crm_load_next_page_arrow = "//*[@class='ms-crm-ImageStrip-page_R1']";
	public static final String crm_need_action_label = "//nobr[text()='Need Action']";
	public static final String crm_approved_label = "//nobr[text()='Approved']";

	public static final String crm_completed_message = "//span[text()='Completed']";
	public static final String crm_job_description = "//*[@id='dobnyc_jobdescription']/div[1]";
	public static final String crm_job_description_cc = "//*[@id='dobnyc_jobdescription']/div[1]";
	public static final String crm_document_status_submitted = "//nobr[contains(.,'Submitted')]";
	public static final String crm_document_submitted = "//nobr[@class='gridcellpadding'][@title='Submitted']";
	public static final String crm_document_status_required = "//nobr[contains(.,'Required')]";
	public static final String crm_document_status_resolved = "//nobr[contains(.,'Resolved')]";
//	public static final String search_for_records_one = "//span[contains(text(),' Tasks')]/following::label[text()='Search for records']";
	public static final String search_for_records_one = "//span[@currentviewtype='1039']/following::label[text()='Search for records']";
//	public static final String search_for_records_one = "//label[@class='ms-crm-Dialog-Lookup-QuickFindHint ms-crm-TextAutoEllipsis']";
	public static final String search_for_records_one_field = "//span[@currentviewtype='1039']/following::input[@class='ms-crm-Dialog-Lookup-QuickFind']";
//	public static final String search_for_records_one_field = "//span[contains(text(),' Tasks')]/following::input[@class='ms-crm-Dialog-Lookup-QuickFind']";
//	public static final String search_for_records_one_field = "//input[@class='ms-crm-Dialog-Lookup-QuickFind']";
//	public static final String search_for_records_one_image = "//h3[text()='My Tasks']/following::img[@class='ms-crm-ImageStrip-search']";
	
//	public static final String search_for_records_one_image = "//span[contains(text(),' Tasks')]/following::img[@class='ms-crm-ImageStrip-search']";
	public static final String search_for_records_one_image = "//span[@currentviewtype='1039']/following::img[@class='ms-crm-ImageStrip-search']";
	
//	public static final String search_for_tasks_elv = "//*[class='ms-crm-Form']/following::img[@class='ms-crm-ImageStrip-search']";
//	public static final String search_for_records_one_image = "//img[@class='ms-crm-ImageStrip-search']";
	public static final String add_objection_image = "//*[@title='Add Objections record.'][@alt='Add Objections record.']";
//	public static final String add_objection_image = "//*[@id='Objections_addImageButtonImage'][@title='Add Objections record.']";
	public static final String search_objection_field = "//input[@class='ms-crm-InlineInput ms-crm-InlineLookupEdit'][@id='dobnyc_objectiontypeinobjections_ledit']";
	
	public static final String select_a_value_image = "//*[@id='dobnyc_objectiontypeinobjections_i']";
	public static final String first_objection = "//span[@class='ms-crm-IL-MenuItem-Title ms-crm-IL-MenuItem-Title-Rest']";
	public static final String save_objection_button = "//button[@id='globalquickcreate_save_button_Objections_gridcontrol_quickcreate']";
	
	
	public static final String cpe_tasks_search_job = "//*[@id='Component6372579_findHintText']";
	public static final String cpe_tasks_search_job_field = "//input[@id='Component6372579_findCriteria']";
	public static final String cpe_search_job_button = "//*[@id='Component6372579_findCriteriaImg']";
	public static final String cpe_action = "//*[@id='dobnyc_reviewactions']/div[1]";
//	public static final String objections_action = "//option[@id='dobnyc_reviewactions_i']/option[3]";
	
	public static final String objections_action = "//option[@title='Objections'][@value='2']";
	public static final String cpe_job_app_complte_label = "//*[@id='dobnyc_isthejobapplicationcomplete2']/div[1]";
	public static final String cpe_job_app_complte_list = "//div[@jawsreadlabel='dobnyc_isthejobapplicationcomplete2_c']";
	public static final String cpe_job_app_complte = "//select[@id='dobnyc_isthejobapplicationcomplete2']";
	
	
	public static final String cpe_acpe_actions_field = "//div[contains(@jawsreadlabel,'cpeacpeteam')]";
	public static final String cpe_acpe_primary_pe_field = "//div[contains(@jawsreadlabel,'primaryplanexaminer')]";
	
	public static final String cpe_acpe_secondary_pe_field = "//div[contains(@jawsreadlabel,'secondaryplanexaminer')]";
	
	public static final String cpe_acpe_find_team_image = "//img[@id='dobnyc_ms_cpeacpeteam_i']";
	public static final String cpe_acpe_find_primary_pe_image = "//img[@id='dobnyc_ms_primaryplanexaminer_i']";
	public static final String cpe_acpe_find_secondary_pe_image = "//img[@id='dobnyc_ms_secondaryplanexaminer_i']";
	
	public static final String span_text = "//span[text()='";

	
	//input[@id='dobnyc_ms_cpeacpeteam_ledit']
	
	public static final String cpe_job_application_complete_yes = "//*[@id='dobnyc_isthejobapplicationcomplete2_i']/option[3]";
	public static final String cpe_job_application_complete_no = "//*[@id='dobnyc_isthejobapplicationcomplete2_i']/option[2]";

	public static final String crm_comments_area = "//span[text()='Please provide comments below']/following::div[contains(@jawsreadlabel,'description')]";
	public static final String crm_comments_box = "//span[text()='Please provide comments below']/following::textarea[contains(@id,'description')]";
	
	
/*	public static final String crm_comments_area = "//*[@id='description']/div[1]";
	public static final String crm_comments_box = "//*[@id='description_i']";*/
	public static final String cpe_description_section = "//*[@id='description']/div[1]"; //*[@id='description_i']";
	public static final String cpe_description = "//textarea[@id='description_i']";
	public static final String qa_super_tasks_search_job = "//*[@id='Component8733077_findHintText']";
	public static final String qa_super_tasks_search_job_field = "//*[@id='Component8733077_findCriteria']";
	public static final String qa_super_search_job_button = "//*[@id='Component8733077_findCriteriaImg']";
	public static final String pe_tasks_search_job = "//*[@id='Component1705811_findHintText']";
	public static final String pe_tasks_search_job_field = "//*[@id='Component1705811_findCriteria']";
	public static final String pe_search_job_button = "//*[@id='Component1705811_findCriteriaImg']";
	public static final String qa_admin_tasks_search_job = "//*[@id='Component8543035_findHintText']";
	public static final String qa_admin_tasks_search_job_field = "//input[@id='Component8543035_findCriteria']";
	public static final String qa_admin_search_job_button = "//*[@id='Component8543035_findCriteriaImg']";
	
	public static final String qa_super_job_subject = "//a[contains(.,'QA Supervisor Work Permit Request Task form for Work Permit Tracking')]";
	public static final String prof_sert_qa_super_job_subject = "//a[contains(.,'Prof Cert QA Supervisor Task Form')]";
	public static final String qa_admin_job_subject = "//*[@id='gridBodyTable']/tbody/tr/td[2]/div";
	public static final String objections_view_details_button = "//button[@class='ui-grid-cell-contents'][contains(.,'Details')]";
	public static final String objections_status = "//select[@id='ddlObjectionStatus']";
	
	public static final String search_results_job_subject = "//a[contains(.,' Task ')]"; //a[@class='ms-crm-List-Link'][contains(.,'Task Form')]
	public static final String task_link = "//a[@class='ms-crm-List-Link'][contains(.,'Task Form')]";
	
	public static final String pending_qa_ahv_action = "//*[@id='dobnyc_pendingqaahvaction']/div[1]";
	public static final String assign_to_self = "//option[@title='Assign to Self']";
	public static final String build020_qa_superviser_link = "//*[@id='dobnyc_assigntoqaclerk']/div[1]/span[1]";
	
	public static final String ahv_task_link = "//a[starts-with(@id,'gridBodyTable_primaryField_{')]";
	

//	public static final String search_results_job_subject = "//a[contains(.,' Task  Form for')]";
//	public static final String prof_sert_qa_admin_job_subject = "//*[@id='gridBodyTable']/tbody/tr/td[2]/div";
	
	public static final String incorrect_email_and_password_message = "//p[@class='alert-desc ng-binding']";
//	public static final String click_here_to_go_to_job_filing = "//span[text()='Job Filing']/following::span[@otypename='dobnyc_jobfiling']";	// 443 444
	public static final String label_job_filing = "//span[text()='Job Filing']";
	public static final String job_filing_link = "//span[text()='Job Filing']/following::span[@otypename='dobnyc_jobfiling']";
//	public static final String click_here_to_go_to_job_filing = "//*[@id='dobnyc_task_clickheretogotojobfiling']/div[1]/span[1]";	
	public static final String qa_admin_actions_label = "//div[contains(.,'Actions')]";
	public static final String qa_admin_tr1_tab = "//span[contains(.,'Technical Report - Statement Of Responsibility')]";
	public static final String qa_admin_tr8_tab = "//span[contains(.,'Technical Report - Energy Code Progress Inspection')]";
	public static final String qa_admin_antenna_pw2_tab = "//*[@id='stage_8']/div[2]/div/div/div/span";
	public static final String qa_admin_curbcut_pw2_tab = "//*[@id='stage_21']/div[2]/div/div/div/span";
	
	public static final String crm_user_info = "//*[@id='navBarUserInfoTextId']/span[1]";
	public static final String select_dashboard_arrow = "//img[@class='ms-crm-View-icon ms-crm-ImageStrip-Dropdown_Arrow']";
	public static final String cpe_dashboard = "//span[text()='Elevator Plan Examiner Assignment Dashboard']";
	
	public static final String pe_dashboard = "//span[text()='Elevator Plan Examiner Dashboard']";
	public static final String actions_plan_examiner_action_list = "//div[@jawsreadlabel='dobnyc_et_pereviewactions_c']";
	
	public static final String proposed_device_type_for_others_list = "//div[@jawsreadlabel='dobnyc_et_peselecteddevicetype_c']";
	public static final String proposed_device_type_for_others = "//select[@id='dobnyc_et_peselecteddevicetype_i']";
	public static final String proposed_elevator_sub_type_list = "//div[@jawsreadlabel='dobnyc_et_elevatorsubtype_c']";
	public static final String proposed_elevator_sub_type = "//select[@id='dobnyc_et_elevatorsubtype_i']";
	public static final String proposed_passenger_type_list = "//div[@jawsreadlabel='dobnyc_proposedpassengertype_c']";
	public static final String proposed_passenger_type = "//select[@id='dobnyc_proposedpassengertype_i']";
	public static final String pe_task = "//a[@class='ms-crm-List-Link'][contains(@title,'Plan Examiner Review Task')]";
	public static final String actions_pe_action = "//select[@id='dobnyc_et_pereviewactions_i']";
	public static final String actions_ccd_variance_list = "//div[@jawsreadlabel='dobnyc_et_ccdvariance_c']";
	public static final String actions_ccd_variance = "//select[@id='dobnyc_et_ccdvariance_i']";
	public static final String actions_under_pilot_list = "//div[@jawsreadlabel='dobnyc_et_isthisfiledunderpilotprogram_c']";
	public static final String actions_under_pilot = "//select[@id='dobnyc_et_isthisfiledunderpilotprogram_i']";
	
	public static final String qa_admin_application_highlights_label = "//div[contains(.,'Application Highlights')]";
	public static final String qa_admin_work_permits_label = "//div[contains(.,'Work Permits')]";
	public static final String qa_admin_required_documents_label = "//div[contains(.,'Required Documents')]";
	//public static final String required_documents_label = "//iframe[@id='WebResource_DocumentsRequired']";
	
	public static final String required_documents_label_tr1 = "//iframe[@id='WebResource_SICRequiredDocuments']";
	public static final String required_documents_label_tr8 = "//iframe[@id='WebResource_PICRequiredDocuments']";


	public static final String crm_documents_tab = "//span[@class='stageNameContent'][contains(.,'Documents')]";

	
	
//	public static final String qa_admin_curbcut_pw2_tab = "//div[@title='Entity: Job Filing, Stage: Work Permit";
	public static final String qa_admin_documents_tab = "//span[contains(.,'Documents')]";
//	public static final String qa_admin_curbcut_documents_tab = "//*[@id='stage_20']/div[2]/div/div/div/span";
	public static final String qa_admin_curbcut_documents_tab = "(//span[@class='stageNameContent' and contains(text(), 'Documents')])[3]";
	
//	public static final String qa_admin_work_on_floors_document = "//*[@id='gridBodyTable']/tbody/tr/td[2]/nobr";
	//*[@id='gridBodyTable']/tbody/tr/td[2]/nobr
	public static final String qa_admin_fuel_oil_document = "//a[contains(.,'Fuel-Oil Storage and Fuel-Oil Piping Systems')]";
	public static final String qa_admin_electrical_energy_document = "//a[contains(.,'Electrical Energy Consumption')]";
	public static final String qa_admin_final_document = "//a[contains(.,'Final')]";
	
	public static final String qa_admin_permit_not_yet_issued = "//a[contains(.,'Permit is not yet issued')]";
	public static final String qa_admin_certificate_of_insurance_document = "//a[contains(.,'Certificate of Insurance Document')]";

//	public static final String qa_admin_document_subject = "//*[@id='gridBodyTable']/tbody/tr/td[2]/div";

	
	public static final String seal_and_signature = "//title[contains(.,'Seal & Signature')]"; //span[@title='Special Inspector Seal & Signature']";
	public static final String qa_admin_special_inspector_seal_signature = "//span[@title='Special Inspector Seal & Signature']";
	public static final String qa_admin_progress_inspector_seal_signature = "//span[@title='Progress Inspector Seal & Signature']";
	
	
	
	//div[@class='ms-crm-Inline-Value ms-crm-Inline-EmptyValue'][starts-with(@jawsreadlabel,'dobnyc_task_sdpappointment')] 
	
	public static final String actions_dropdown = "//*[@id='dobnyc_isthejobapplicationcomplete2']/div[1]";
	
	public static final String appoitment_required_list = "//div[@jawsreadlabel='dobnyc_task_sdpappointment_c']";
	public static final String apt_required = "//select[@id='dobnyc_task_sdpappointment_i']";
	public static final String plan_examiner_action_list = "//div[@jawsreadlabel='dobnyc_isjobapplicationapproved_c']";
	public static final String job_approved = "//select[@id='dobnyc_isjobapplicationapproved_i']";
	
	
	public static final String appoitment_required = "//div[@id='dobnyc_task_sdpappointment']/div[1]";
	public static final String appoitment_required_no = "//option[@title='No'][@value='1'] ";
	public static final String plan_examiner_action = "//div[@id='dobnyc_isjobapplicationapproved']/div[1]";
	public static final String plan_examiner_action_approved = "//select[@id='dobnyc_isjobapplicationapproved_i']/option[2]";
	public static final String plan_examiner_action_objection = "//select[@id='dobnyc_isjobapplicationapproved_i']/option[3]";
	
		
	public static final String action_cpe_action_list = "//div[@jawsreadlabel='dobnyc_pendingplanexaminerassignmentactions_c']";
	public static final String action_cpe_action = "//select[@id='dobnyc_pendingplanexaminerassignmentactions_i']";
	public static final String assign_to_pe_link = "//span[@role='link'][@title='BUILD031 Elevator Plan Examiner']";	
	public static final String pe_action = "//*[@id='dobnyc_isjobapplicationapproved']/div[1]";
	public static final String option_yes = "//option[@title='Yes']";
	public static final String option_no = "//option[@title='No']";
	
	public static final String pe_action_approved = "//option[@value='625470000']"; 
	public static final String pe_action_approved_no = "//option[@value='625470001']"; //*[@id='dobnyc_task_sdpappointment_i']/option[2]
	
	public static final String pe_action_objections = "//*[@id='dobnyc_isjobapplicationapproved_i']/option[3]";
	
	public static final String first_plan_examiner_action = "//span[contains(.,'Examiner Action')]/following::div[contains(@jawsreadlabel,'dobnyc')]";
	
	public static final String first_action = "div[contains(@jawsreadlabel,'dobnyc')]";
	
	public static final String qa_action_label = "//span[text()='QA Action']";
	public static final String following = "/following::";
	
	
	public static final String plan_examiner_action_select = "//span[contains(.,'Examiner Action')]/following::select[contains(@id,'dobnyc')]";
	//span[contains(.,'Examiner Action')]/following::select [contains(@id,'dobnyc')]
	
	public static final String qa_action = "//*[@id='dobnyc_qadecision']/div[1]";
	public static final String qa_action_list = "//div[@jawsreadlabel='dobnyc_qadecision_c']";
	public static final String qa_action_select = "//select[@id='dobnyc_qadecision_i']";
	
//	public static final String approved_plans_uploaded = "//*[@id='dobnyc_approvedplansuploaded']/div[1]";
	
	
	public static final String approved_plans_uploaded_list = "//*[@id='dobnyc_approvedplansuploaded_c']";
	public static final String approved_plans_uploaded = "//*[@id='dobnyc_approvedplansuploaded_i']";
//	public static final String pe_appoitment_required_no = "//option[@value='1'][@title='No'][contains(.,'No')]";
	
	public static final String qa_descision_list = "//div[@jawsreadlabel='dobnyc_task_qadecision6_c']";
	public static final String qa_descision = "//select[@id='dobnyc_task_qadecision6_i']";
	
	
	//select[@id'dobnyc_task_qadecision6_i']
	
//	public static final String qa_descision_list = "//*[@id='dobnyc_task_qadecision6_d']";
	public static final String qa_descision_approved = "//*[@id='dobnyc_task_qadecision6_i']/option[3]"; //*[@id='gridBodyTable']/tbody/tr[3]/td[2]/div
	public static final String option_permit_issued = "(//option[@title='Permit Issued'])[3]"; //option[contains(@title,'Permit Issued')]
	public static final String option_qa_failed = "//option[@value='1'][@title='QA Failed'][contains(.,'QA Failed')]";
	
	
	
	
	public static final String qa_failed_reason_area = "//div[@jawsreadlabel='dobnyc_qafailedreason_c']";
	public static final String qa_failed_reason_box = "//textarea[@id='dobnyc_qafailedreason_i']";
	

	public static final String approved_plan_uploaded = "//*[@id='dobnyc_approvedplansuploaded']/div[1]";
	public static final String approved_plan_uploaded_yes = "//*[@id='dobnyc_approvedplansuploaded_i']/option[2]";
	public static final String approved_plan_uploaded_no = "//*[@id='dobnyc_approvedplansuploaded_i']/option[2]";
	public static final String total_number_of_documents = "//*[@id='Documents_ItemsTotal']";
	
	public static final String document_status_filter_elv = "(//input[@ng-model='colFilter.term'])[7]";
	public static final String document_status_filter = "//span[text()='Required Documents']/following::span[text()='Document Status']/following::input[@ng-model='colFilter.term']";
	
	public static final String crm_document_accepted = "//span[contains(.,'Accepted')]";
//	public static final String document_xpath_part1 = "(//a[starts-with(@id,'gridBodyTable_lookup_')])[";
	public static final String document_xpath_part1 = "//*[@id='gridBodyTable']/tbody/tr[";
	public static final String document_xpath_part2 = "]/td[2]/div";
	
	public static final String close_xpath = "']";

	public static final String load_next_page_image = "(//*[@id='_nextPageImg'])[2]";
//	public static final String view_document_button = "//*[@alt='View Document']";
	
	public static final String view_document_button = "//img[@class='ms-crm-ImageStrip-Copy_16 ms-crm-commandbar-image16by16'][@alt='View Document']";
	public static final String objection_addressed_button = "//img[@class='ms-crm-ImageStrip-Activate_16 ms-crm-commandbar-image16by16'][@alt='Objection Addressed']";
	
	public static final String accept_document_button = "//span[contains(text(),'Accept Document')]";
	
	public static final String crm_documents_first_document_link  = "//*[@id='gridBodyTable']/tbody/tr[1]/td[2]/div";
	public static final String crm_submitted_label = ">Submitted<";

	public static final String actions_is_the_job_application_complete = "//select[@id='dobnyc_isthejobapplicationcomplete2_i']";
	public static final String is_the_job_application_complete_list = "//span[contains(.,'Is the Job Application Complete')]/following::div[contains(@jawsreadlabel,'isthejobapplicationcomplete')]";
	public static final String is_the_job_application_complete_select = "//span[contains(.,'Is the Job Application Complete')]/following::select[contains(@id,'complete')]";
	
	public static final String is_the_job_application_complete = "//div[@class='ms-crm-Inline-Value ms-crm-Inline-EmptyValue'][starts-with(@jawsreadlabel,'dobnyc_')]";
	public static final String is_the_job_application_complete_yes = "//option[@title='Yes'][@value='2']";
	
	public static final String assign_to_plan_examiner = "//div[@class='ms-crm-Inline-Value ms-crm-Inline-EmptyValue ms-crm-Inline-Lookup']";
	public static final String assign_to_assignee = "//input[@class='ms-crm-InlineInput ms-crm-InlineLookupEdit']";
	public static final String search_assignee_button = "//img[@id='new_planexaminer_i']";
	public static final String select_assignee = "//*[@id='item0']/a[2]/span/nobr/span";
	public static final String chief_plan_examiner_action = "//div[@class='ms-crm-Inline-Value ms-crm-Inline-EmptyValue'][starts-with(@jawsreadlabel,'dobnyc_reviewactions')]";
	public static final String assign_to_qa_administrator_field = "//*[@id='dobnyc_assigntoqaclerk_ledit']";
	public static final String prof_cert_qa_assinment_actions_list = "//div[@jawsreadlabel='dobnyc_assigntoqaclerk_c']";
	public static final String prof_cert_qa_assinment_action = "//select[@id='dobnyc_ts_pendingprofcertqaassignmentactions_i']";
	public static final String assign_to_prof_cert_qa_administrator_area = "//div[@jawsreadlabel='dobnyc_assigntoqaclerk_c']";
	public static final String assign_to_qa_administrator_label = "//span[contains(text(),'QA Administrator')]";
	public static final String assign_to_qa_administrator = "//div[contains(@jawsreadlabel,'dobnyc_assigntoqaclerk')]";
	public static final String assign_to_qa_administrato_type = "//input[@id='dobnyc_assigntoqaclerk_ledit']";
	public static final String qa_administrator_search = "//img[@id='dobnyc_assigntoqaclerk_i']";
	public static final String qa_administrator_search_button = "//*[@id='dobnyc_assigntoqaclerk_i']";
	public static final String select_qa_administrator = "//*[@id='item0']/a[2]/span/nobr/span";
	//*[@id="item0"]/a[2]/span/nobr/span
	public static final String plan_examiner_text_field = "//*[@id='new_planexaminer_ledit']";
	public static final String plan_examiner_search_button = "//img[@id='new_planexaminer_i']";
	public static final String select_examiner = "//*[@id='item0']/a[2]/span/nobr/span";
	public static final String comments_textbox = "//*[@id='description']/div[1]"; //*[@id='description_i']";
	public static final String submit_button = "//*[@alt='Mark Complete']"; //*[@id='task|NoRelationship|Form|Mscrm.Form.task.SaveAsComplete']/span/a/img";
	public static final String submit_button_elv = "//*[@alt='Submit']";
// ELECTRICAL
// Subsequent Filing 
	public static final String filing_action_label = "//select[@id='FilingAction']";
	public static final String select_action_correction = "//option[@value='Correction']";
	public static final String select_action_renew_permit = "//option[@value='RenewWorkPermit']";
	public static final String select_action_ahv = "//option[@value='CreateAHV']";
// AHV
	public static final String search_for_records_ahv = "//span[contains(text(),'AHV Permits')]/following::label[text()='Search for records']";
	
	public static final String search_for_records_ahv_field = "//span[contains(text(),'AHV Permits')]/following::input[@class='ms-crm-Dialog-Lookup-QuickFind']";
	
	public static final String search_for_records_ahv_image = "//span[contains(text(),'AHV Permits')]/following::img[@class='ms-crm-ImageStrip-search']";
	
	public static final String bod_ahv_permits_label = "//span[contains(text(),'DOB AHV Permits')]";
	
	public static final String click_here_to_go_to_ahv = "//span[text()='Click here to go to AHV']";
	

	public static final String ahv_last_name = "//input[@id='txtPW5MainPointLastName']";
	public static final String ahv_first_name = "//input[@id='txtPW5MainPointFirstName']";
	public static final String ahv_mobile = "//input[@id='txtPW5MainPointMobileTelephone']";
	public static final String ahv_email = "//input[@id='txtPW5MainPointEmail']";
	public static final String ahv_residence_within_200_feet_no = "//input[@id='rbtPW5ResiWithinNo']";
	public static final String ahv_all_work_done_within_enclosed_building = "//input[@id='rbtPW5EnclosedBuildingNo']";
	public static final String ahv_work_involve_full_partial_demolition_no = "//input[@id='rbtPW5FullPartialDemoNo']";
	public static final String ahv_work_involve_crane_use_no = "//input[@id='rbtPW5CraneUseNo']";
	public static final String ahv_request_approval_reason = "//select[@id='ddlRequestApprovalReasonValue']";
	public static final String ahv_reason_debris_removal = "//option[@value='2']";
	
	public static final String ahv_liability = "//input[@ng-model='jobFilingObj.NameOftheInsurerLiabilityInsurance']";
	public static final String ahv_worker_comp = "//input[@ng-model='jobFilingObj.NameOfTheInsurerWorkerCompensation']";
	public static final String ahv_disability = "//input[@ng-model='jobFilingObj.NameOfTheInsurerDisabilityInsurance']";
	
	public static final String ahv_application_fee_exempt_yes = "//input[@id='rbIsAHVApplicationFeeExempt'][@value='1']";
	
	public static final String ahv_exempt_type = "//select[@id='ddlFeeExempt']";

	public static final String ahv_from0 = "//input[@id='Day0From']";
	public static final String ahv_from1 = "//input[@id='Day1From']";
	public static final String ahv_from2 = "//input[@id='Day2From']";
	public static final String ahv_from3 = "//input[@id='Day3From']";
	public static final String ahv_from4 = "//input[@id='Day4From']";
	public static final String ahv_from5 = "//input[@id='Day5From']";
	public static final String ahv_from6 = "//input[@id='Day6From']";
	public static final String ahv_to0 = "//input[@id='Day0To']";
	public static final String ahv_to1 = "//input[@id='Day1To']";
	public static final String ahv_to2 = "//input[@id='Day2To']";
	public static final String ahv_to3 = "//input[@id='Day3To']";
	public static final String ahv_to4 = "//input[@id='Day4To']";
	public static final String ahv_to5 = "//input[@id='Day5To']";
	public static final String ahv_to6 = "//input[@id='Day6To']";
	public static final String ahv_date1 = "//input[@id='chk01']";
	public static final String ahv_date2 = "//input[@id='chk02']";
	public static final String ahv_description_of_work = "//textarea[@id='txtPW5WorkDescription']";
	public static final String ahv_i_understand_and_agree = "//input[@id='chkPW5Acknowledge']";
	
	public static final String ahv_submit_button = "//button[@type='submit'][@class='btn btn-primary btnCustom']";
	public static final String filing_type_field = "(//input[@ng-model='colFilter.term'])[3]";
	public static final String filing_status_field = "(//input[@ng-model='colFilter.term'])[4]";
	public static final String el_select_action = "//select[@id='FilingAction']";
	public static final String select_action_dropdown = "(//select[@id='FilingAction'])[1]";
	
	public static final String el_select_action_subsequent_filing = "//option[@value='SubsequentFiling']";
	public static final String el_select_action_paa = "//option[@value='PAA']";
	public static final String confirm_yes_button = "//button[contains(.,'Yes')]";
	public static final String el_confirm_yes_button = "//button[contains(.,'Yes')]";
	public static final String paa_confirm_yes_button = "//button[contains(.,'Yes')]";
	public static final String global_create_subsequent_button = "//button[contains(.,'Create Subsequent')]";
	public static final String job_number_filter = "//span[text()='Job Number']/following::input[@ng-model='colFilter.term']";
	public static final String job_filing_number_filter = "(//input[@ng-model='colFilter.term'])[2]";
	
/*	public static final String job_filing_number_filter1 = "(//input[@ng-model='colFilter.term'])[1]";
	public static final String job_filing_number_filter2 = "(//input[@ng-model='colFilter.term'])[2]";
	public static final String job_filing_number_filter3 = "(//input[@ng-model='colFilter.term'])[3]";
	public static final String job_filing_number_filter4 = "(//input[@ng-model='colFilter.term'])[4]";
	public static final String job_filing_number_filter5 = "(//input[@ng-model='colFilter.term'])[5]";
	public static final String job_filing_number_filter6 = "(//input[@ng-model='colFilter.term'])[6]";
	public static final String job_filing_number_filter7 = "(//input[@ng-model='colFilter.term'])[7]";
	public static final String job_filing_number_filter8 = "(//input[@ng-model='colFilter.term'])[8]";
	public static final String job_filing_number_filter9 = "(//input[@ng-model='colFilter.term'])[9]";
	public static final String job_filing_number_filter10 = "(//input[@ng-model='colFilter.term'])[10]";
	public static final String job_filing_number_filter11 = "(//input[@ng-model='colFilter.term'])[11]";
	public static final String job_filing_number_filter12 = "(//input[@ng-model='colFilter.term'])[12]";*/

	public static final String eljob_number_filter = "(//input[@ng-model='colFilter.term'])[1]";
	public static final String eljob_filing_number_filter = "(//input[@ng-model='colFilter.term'])[2]";
	public static final String el_subsequent_filing_work_type = "//input[@ng-model='rowData.ElectricalFilingWorktype']";
	
	public static final String el_subsequent_filing_create_button = "//button[@ng-click='Create()']";
	public static final String el_job_filing_includes_new_work_only = "(//input[@name='rdNewApp'])[1]";
	
	public static final String el_job_filing_includes_submit_button = "//button[@ng-click='ok()']";
	
	public static final String el_gi_house_number = "//input[@id='txtPWLocHouse']";
	public static final String el_gi_street_name = "//input[@id='txtJobLocationStreetName']";
	public static final String el_gi_borough = "//select[@id='ddlPWLocBoroughNYC']";
	public static final String el_gi_block = "//input[@id='txtPWLocBlock']";
	public static final String el_gi_lot = "//input[@id='txtPWLocLot']";
	public static final String el_ge1_job_description = "//textarea[@id='txtPWLocCBNo']";
	public static final String el_gi_job_start_date_calendar  = "//button[@id='btnStartCalender']";
	public static final String el_gi_calendar_active_day = "//button[@class='btn btn-default btn-sm active']";
	public static final String el_gi_job_completion_date_calendar = "//button[@id='btnCompletionCalender']";
	public static final String el_gi_job_completion_last_day = "(//button[@class='btn btn-default btn-sm'])[last()]";	
	public static final String el_gi_job_is_this_joint_venture_yes = "//*[@id='fixedviews']/div[2]/div[1]/div/div[17]/div/input[1]";
	public static final String el_gi_job_is_this_joint_venture_no = "//*[@id='fixedviews']/div[2]/div[1]/div/div[17]/div/input[2]";
	public static final String el_gi_building_use_type = "//select[@id='ddlBuildingUseType']";
	public static final String el_gi_applicant_email = "//input[@id='txtPWAppEmail2']";
	public static final String el_gi_applicant_license_type = "//select[@id='txtPWAppLicType']";
	public static final String el_gi_owner_email = "//input[@id='txtElvOwnerEmail']";
	public static final String el_gi_owner_type = "//select[@id='ddlOwnerType']";

	public static final String el_gi_is_this_build_back_job_yes = "//input[@ng-model='FormED16AObj.IsBuildItBack'][@value='true']";
	public static final String el_gi_is_this_build_back_job_no = "//input[@ng-model='FormED16AObj.IsBuildItBack'][@value='false']";
	public static final String legalization_yes = "//input[@ng-change='CheckLegalization()'][@value='true']";
	public static final String legalization_no = "//input[@ng-change='CheckLegalization()'][@value='false']";
/*	public static final String el_gi_is_this_job_certification_of_ccupancy_yes = "//input[@ng-change='jobCofoChange()'][@value='true']";
	public static final String el_gi_is_this_job_certification_of_ccupancy_no = "//input[@ng-change='jobCofoChange()'][@value='false']";*/
	public static final String c_o_related_yes = "//input[@ng-change='jobCofoChange()'][@value='true']";
	public static final String c_o_related_no = "//input[@ng-change='jobCofoChange()'][@value='false']";
	
	public static final String electric_sign_description_tab = "//div[@slidediv='SignDescriptions']";
	public static final String add_sign_description_button = "//button[@ng-click='addEditElectricSignInfo()']";
	public static final String el_job_number_field = "//input[@id='txtPW1JobNumber']";
	public static final String sign_dimentions = "//input[@id='txtSigndimensionsfeet']";
	public static final String total_sq_feet_of_sign = "//input[@id='txtTotalSqfeetofSign']";
	public static final String total_circuit_in_sign = "//input[@id='txTotalCircuitSinsign']";
	public static final String total_lamps = "//input[@id='txtTotalLamps']";
	public static final String total_wats = "//input[@id='txtWattsLamps']";
	public static final String number_of_transformenrs = "//input[@id='txtNumberofTransformers']";
	public static final String va_of_each_transformer = "//input[@id='txtVaofeachtransformer']";
	public static final String total_wats_of_va = "//input[@id='txtTotalWattsorvaVoltAmpere']";
	public static final String avg_gauge_of_wires = "//input[@id='txtAmericanWireAwggaugeofwire']";
	public static final String number_of_sockets_per_circuit = "//input[@id='txtNoofSocketsPerCircuit']";
	public static final String material_and_gauge_used = "//input[@id='txtMaterialandGaugeUsed']";
	public static final String make_of_sign = "//input[@id='txtMakeofSign']";
	public static final String manufacturer_of_sign = "//input[@id='txtManufacturerofSign']";
	public static final String manufacturer_address = "//input[@id='txtManufacturerAddress']";
	public static final String el_save_modal_button = "//span[@class='glyphicon glyphicon-ok-sign']";
	public static final String el_gi_confirm_save_button = "//button[@ng-click='ngDialogData.SaveED16AFiling(false)']";
	public static final String el_job_label	= "//span[@class='pad-left-10']";
// SCOPE OF WORK	
	public static final String el_scope_of_work_tab = "//a[contains(.,'Electrical Scope of Work')]";
	public static final String el_boiler_controls_tab= "//div[@slidediv='BoilerControls']";
	public static final String el_boiler_controls_quantity = "//input[@name='Boiler Controls-Quantity']";
	public static final String el_boiler_controls_number_size = "//input[@name='Boiler Controls-IndicateNoAndSize']";
	
	public static final String el_sow_service_work = "//input[@id='toggle-chk1']";
	public static final String el_sow_general_wiring = "//input[@id='toggle-chk2']";
	public static final String el_sow_lighting_work = "//input[@id='toggle-chk3']";
	public static final String el_calendar_next_month_arrow = "//i[@class='glyphicon glyphicon-chevron-right']";
	public static final String el_service_meter_equipment = "//div[@slidediv='ServiceMeterEquipment']";
	public static final String el_number_3_wire = "//input[@id='txtSWPWLocHouseNo']";
	public static final String el_number_4_wire = "//input[@id='txtServiceMeterEquipmentNo4Wire']";
	public static final String el_number_10_points = "//input[@id='txtServiceMeterEquipmentNo10Wire']";
	public static final String el_number_existing_meters = "//input[@id='txtPWLocHouseNo']";
	public static final String el_number_new_meters = "//input[@id='txtServiceMeterEquipmentNoNewMeters']";
	public static final String el_number_removed_meters = "//input[@id='txtServiceMeterEquipmentStreetName']";
	public static final String el_sow_lighting_work_type = "//select[@data-validationmsg='Lighting Worktype']";
	public static final String el_select_category_of_work = "//select[@id='selCategoryWorklist']";
	public static final String el_category_of_work_slider = "//div[@slidediv='categoryOfWork']";
	public static final String el_minor_work_description_slider = "//div[@slidediv='MinorWorkDescription']";
	public static final String el_add_minor_work_description_button = "//button[@ng-click='addEditMinorWorkDescription()']";
	public static final String el_minor_work_options = "//select[@id='txtMinorWorkType']";
	public static final String el_minor_work_location = "//select[@id='FloorSelCategoryWorklist']";
	public static final String el_minor_work_quantity = "//input[@id='txtQuantity']";
	public static final String el_minor_work_description = "//textarea[@id='txtMWDescription']";
	public static final String el_minor_work_save_button = "//button[@ng-click='ngDialogData.saveMinorWorkDescription(ngDialogData.frmMinorFloorDesc)']";
	public static final String el_minor_work_type = "(//input[@class='ui-grid-filter-input ng-pristine ng-untouched ng-valid'])[2]";
	public static final String el_minor_work_floor = "(//input[@class='ui-grid-filter-input ng-pristine ng-untouched ng-valid'])[2]";
	public static final String el_minor_work_device = "(//input[@class='ui-grid-filter-input ng-pristine ng-untouched ng-valid'])[3]";
	public static final String el_first_document = "//a[@ng-click='grid.appScope.downloadDocument(row)']";
	public static final String el_application_involve_new_or_amended_yes = "//input[@data-validationmsg='Owner Authorization New or Amended'][@value='true']";
	public static final String el_i_undersigned= "//input[@id='ApplicantAuthorizationCheckPW1']";
	public static final String el_this_electrical_permit_involves = "//input[@id='DesignApplicantStatementsMainCheckPW1']";
	public static final String el_this_electrical_permit_includes = "//input[@ng-change='setED16AOwnerNewAmendedStatements()']";
//	public static final String pay_now_button = "//button[@ng-disabled='DisablePayNow()']";
	public static final String pay_now_button_disabled = "//button[@ng-click='showPaymentConfirmationModal()'][@disabled='disabled']";
	public static final String pay_now_button = "//button[contains(text(),'Pay')]";
	public static final String pay_now_button_ant = "//button[contains(.,'Pay Now')] ";
	public static final String pay_now_button_work_permit = "//button[@type='button'][@ng-click='PayNow()']";
	public static final String continue_to_this_site_not_recommended = "//a[text()='Continue to this website (not recommended).']";
	public static final String pay_now_confirm_button = "//button[@ng-click='paymentConfirmationModalOk()']";
	public static final String pay_method_echeck = "//input{@id='ctl00_MainContent_rbtnNewECheck']";
	public static final String pay_method_card ="//input[@id='ctl00_MainContent_rbtnNewCreditCard']";
	public static final String pay_by_credit_card_link = "//a[@title='Pay by Credit Card']";
	public static final String pay_agree_to_terms = "//input[@id='agree-to-terms']";
	public static final String pay_continue_button = "//button[@id='ec_process_payment_button'][@data-disable-with='Continuing...']";
	public static final String pay_next_button = "//input[@value='Next']";
	public static final String pay_advanced_button = "//button[@id='advancedButton']";
	public static final String pay_add_exeption_button = "//button[@id='advancedButton']";
	public static final String pay_do_not_click_back_message = "//b[contains(.,'Please do not click Back or Forward buttons while payment is in progress!')]";
	
	

	public static final String pay_name_on_account = "//input[@id='ctl00_MainContent_txtECNameOnAccount']";
	public static final String aba_routing_number = "//input[@id='ctl00_MainContent_txtECRoutingNumber']";
	public static final String account_number = "//input[@id='ctl00_MainContent_txtECAccountNumber']";
	public static final String account_number_confirm = "//input[@id='ctl00_MainContent_txtConfirmAccountNumber']";
	public static final String pay_pay_now_button = "//input[@value='Pay Now']";
	
	
	public static final String account_type = "//a[contains(.,'AccountType')]";
	public static final String checking_account = "//li[@class='active-result' and  contains(.,'Checking')]";
	public static final String pay_first_name = "//input[@id='bill_to_forename_echk_entry']";
	public static final String pay_last_name = "//input[@id='bill_to_surname_echk_entry']";
	public static final String pay_address = "//input[@id='bill_to_address_line1_echk_entry']";
	public static final String pay_city = "//input[@id='bill_to_address_city_echk_entry']";
	public static final String pay_zip = "//input[@id='bill_to_address_postal_code_echk_entry']";
	public static final String pay_phone = "//input[@id='bill_to_phone_echk_entry']";
	public static final String pay_email = "//input[@id='bill_to_email_echk_entry']";
	public static final String pay_email_confirm = "//input[@id='email-confirmation-echk']";
	public static final String pay_continue_button_ec = "//button [@id='ec_process_payment_button']";
	
	public static final String pay_first_name_cc = "//input [@id='bill_to_forename_cc_entry']";
	public static final String pay_last_name_cc = "//input [@id='bill_to_surname_cc_entry']";
	public static final String pay_address_cc = "//input [@id='bill_to_address_line1_cc_entry']";
	public static final String pay_city_cc = "//input [@id='bill_to_address_city_cc_entry']";
	public static final String pay_zip_cc = "//input [@id='bill_to_address_postal_code_cc_entry']";
	public static final String pay_phone_cc = "//input [@id='bill_to_phone_cc_entry']";
	public static final String pay_email_cc = "//input [@id='bill_to_email_cc_entry']";
	public static final String pay_email_confirm_cc = "//input [@id='email-confirmation']";
	public static final String pay_continue_button_cc = "//button [@id='cc_process_payment_button']";

	public static final String pay_name_on_card = "//input[@id='ctl00_MainContent_txtCCCardName']";
	public static final String pay_card_number = "//input[@id='ctl00_MainContent_txtCCCardNumber']";
	
	public static final String pay_exp_month = "//select[@id='ctl00_MainContent_lstCCExpMonth']";
	public static final String pay_exp_year = "//select[@id='ctl00_MainContent_lstCCExpYear']";
	public static final String pay_cvv = "//input[@id='ctl00_MainContent_txtCCCVV2']";
	
	public static final String pay_now_button_final = "//input[@id='ctl00_MainContent_btnNext']";
	
//	public static final String pay_by_clicking_process_payment = "//input[@id='confirm-payment-terms-echk']";
//	public static final String pay_process_payment_button = "(//a[@title='Process Payment'])[1]";
	public static final String pay_process_payment_button = "(//a[@title='Process Payment'])[2]";
 // BOILERS
	// Links
	
	public static final String boiler_link = "//a[text()='Boiler']";
	// Buttons
	public static final String safety_button = "//img[@src='images/safety-button-logo.png']";
	public static final String boiler_inspection_report = "//button[@ng-click='LoadNewForm(1)']";
	public static final String boiler_extension_request = "//button[@ng-click='LoadNewForm(2)']";
	public static final String make_civil_penalties_payment = "//button[@ng-click='LoadNewForm(4)']";
	public static final String search_boiler = "//button[@ng-click='SearchBoiler()']";
	// Tabs
	public static final String general_information_link = "//a[contains(text(),'General Information')]";
	// Lists
	public static final String filing_year = "//select[@id='ddlReportYear']";
	
	// Radio
	public static final String search_by_value ="//input[@name='ctrlShow'][@value='";

	public static final String stg443 = "https://msswvw-dobcrmpw.nycnet/Publish/DOBNowPortal/index.html";
	public static final String stg444 = "https://msswvw-dobcrmpw.nycnet:444/Publish/DOBNowPortal/Index.html#";
	public static final String tst8085 = "http://mstwva-dobcrm03.buildings.nycnet:8085/Index.html#";
	

	public static final String AJOETEST2 = "AJOETEST2@GMAIL.COM";
	public static final String APPLEROME18 = "APPLEROME18@GMAIL.COM";
	public static final String UAT_PASSWORD = "uat_Ashish@123";
	public static final String MRCTEST003 = "MRCTEST003@GMAIL.COM";
	public static final String MSTRPLMR = "Master Plumber";
	public static final String DOBTESTING123 = "DOBTESTING123@GMAIL.COM";
	public static final String PROFENG = "Professional Engineer";
	public static final String DOBELVDIRECTOR = "DOBELVDIRECTOR@GMAIL.COM";
	public static final String DOBELECTRICIAN8 = "DOBELECTRICIAN8@GMAIL.COM";
	
	public static final String SGNHNGR = "Sign Hanger";
	public static final String DOBTEST05 = "DOBTEST05@GMAIL.COM";

	
	// LAA
	public static final String laa_legalization_yes = "//input[@id='rdIsLegalization']";
	public static final String laa_legalization_no = "//input[@id='rdIsNonLegalization']";

	public static final String laa_specify_building_type = "//select[@id='ddlBuildingType']";
	public static final String laa_building_use = "//select[@id='ddlBuildingUseType']";
	public static final String laa_total_number_of_floors = "//input[@id='totalNumberOfFloors']";
	public static final String laa_total_construction_roof_area = "//input[@id='totalConstructionArea']";
	public static final String laa_category_type = "//select[@ng-model='FormLAAObj.FeeAssesment.CategoryType']";
	public static final String laa_estimated_cost = "//input[@id='txtEstimatedCost']";
	public static final String laa_the_deed_holder_is = "//input[@ng-model='FormLAAObj.FeeExemptionApplicationValue1']";
	public static final String the_scope_of_work_asbestos = "//input[@id='rbAsbestos1']";
	public static final String adrress_confirmation = "//button[@ng-click='ngDialogData.SaveLAAFiling(false)']";
	public static final String scope_of_work_tab = "//a[@class='ng-binding'][contains(text(),'Scope of Work')]";
	
	
	
	public static final String add_scope_of_work = "//button[contains(.,'Add Scope of Work')]";

	
	public static final String laa_limited_alteration_scope = "//select[@id='selWorkType']";
	public static final String laa_filing_includes = "//select[@ng-model='ScopeOfWork.FileIncludes']";
	public static final String laa_item_category = "//select[@id='selItemCategory']";
	
	public static final String auxilary_hose_cabinets = "//input[@id='Auxiliary hose cabinets']";
	public static final String sprinkler_heads = "//input[@id='Sprinkler heads']";
	public static final String sprinkler_heads_quantity = "//input[@id='Sprinkler heads']/following::input[@ng-model='item.Quantity']";
	
	
	
	public static final String sprinkler_piping = "//input[@id='Sprinkler Piping']";
	public static final String sprinkler_piping_quantity = "//input[@id='Sprinkler Piping']/following::input[@ng-model='item.Quantity']";
	
	public static final String gas_sgut_off_valve = "//input[@id='Gas Emergency Shut Off Valve']";
	public static final String gas_sgut_off_valve_quantity = "//input[@id='Gas Emergency Shut Off Valve']/following::input[@ng-model='item.Quantity']";
	public static final String gas_light = "//input[@id='Gas Light (Commercial and Residential)']";
	public static final String gas_light_quantity = "//input[@id='Gas Light (Commercial and Residential)']/following::input[@ng-model='item.Quantity']";
	public static final String gas_light_additional_meters = "//input[@id='Gas Light (Commercial and Residential)']/following::input[@id='rdAnswerText2']";
	public static final String gas_oil_burner_pilot = "//input[@id='Gas Oil Burner Pilot']";
	public static final String gas_oil_burner_pilot_quantity = "//input[@id='Gas Oil Burner Pilot']/following::input[@ng-model='item.Quantity']";	
	public static final String gas_oil_burner_pilot_additional_meters = "//input[@id='Gas Oil Burner Pilot']/following::input[@id='rdAnswerText2']";
	public static final String gas_for_cooking = "//input[@id='Gas piping for residential cooking']";
	public static final String gas_for_cooking_quantity = "//input[@id='Gas piping for residential cooking']/following::input[@ng-model='item.Quantity']";
	public static final String for_sro_restricted = "//div[contains(text(),'SRO restricted property')]/following::input[@id='rdAnswerText2']";
	
	public static final String laa_item_quantity = "//input[@ng-model='item.Quantity']";
	
	public static final String have_associated_job_number_no = "//div[contains(text(),'associated Job Number')]/following::input[@id='rdAnswerText2']";
	public static final String laa_offline_8_hours_no = "//div[contains(text(),'offline for more than 8 hours')]/following::input[@id='rdAnswerText2']";
	
	public static final String branch_water_filters = "//input[@id='Branch Water Filters']";
	public static final String branch_water_filters_quantity = "//input[@id='Branch Water Filters']/following::input[@ng-model='item.Quantity']";
	
	public static final String whirlpooltub_commercial = "//input[@id='Commercial Whirlpool']";
	public static final String whirlpooltub_quantity = "//input[@id='Commercial Whirlpool']/following::input[@ng-model='item.Quantity']";
	public static final String select_voltage = "//select[@id='questionSel']";
	
	
	
	public static final String tub_with = "(//input[@ng-model='question.AnswerText'])[1]";
	public static final String tub_lenght = "(//input[@ng-model='question.AnswerText'])[2]";
	public static final String tub_dept = "(//input[@ng-model='question.AnswerText'])[3]";
//	public static final String tub_dept = "(//input[@ng-model='question.AnswerText'])[4]";
//	public static final String branch_water_filters_quantity = "//input[@id='Branch Water Filters']/following::input[@ng-model='item.Quantity']";
	
	
	public static final String violation_number = "//input[@id='workPermitViolationNumber']";
	
//	public static final String save_scope_of_work = "//button[@ng-click='SaveScopeofWork(ScopeOfWork)']";
	public static final String save_scope_of_work = "//span[@class='glyphicon glyphicon-ok-sign']";
	public static final String add_appliance_data = "//button[contains(.,'Add Appliance Data')]";
	public static final String floor_location = "//select[@id='FloorFDSelCategoryWorklist']";
	public static final String total_number_of_appliances = "//input[@ng-model='ngDialogData.ApplianceData.TotalNumberofAppliance']";
	public static final String manyfacturer_name = "//input[@ng-model='ngDialogData.ApplianceData.ManufacturerName']";
	public static final String listing_agency_name = "//select[@name='selListingAgency']";
	public static final String certification_number = "//input[@ng-model='ngDialogData.ApplianceData.Certification']";
	public static final String model_number = "//input[@ng-model='ngDialogData.ApplianceData.ModelNumber']";
	public static final String input_btu = "//input[@ng-model='ngDialogData.ApplianceData.InputBtuhr']";
	
	public static final String oil_piping = "//input[@id='Oil piping']";

	public static final String statements_signatures_tab = "//a[@class='ng-binding'][contains(text(),'Statements & Signatures')]";
	public static final String i_understand_and_agree = "//input[@id='ApplicantAuthorizationCheckPW1']";
	public static final String documents = "//a[@class='ng-binding'][contains(text(),'Documents')]";
	
	public static final String document_status_field = "//span[text()='Document Status']/following::input[@ng-model='colFilter.term']";
	
	public static final String laa_spinner = "//i[@class='fa fa-spinner fa-pulse fa-3x fa-fw build-color']";
	
	public static final String ewn_button = "//button[@ng-click='EmergencyNewAppOptions()']";
	public static final String ewn_tab = "//a[@ng-click='tab.setTab(7)']";
	
	public static final String laa_select_action = "//select[@ng-model='grid.appScope.LaaFilingActionChange[rowRenderIndex]']";
	
	public static final String have_ewn = "//input[@id='rdIsEmergencyWork']";
	public static final String ewn = "//input[@id='txtEmergencyFilingNo']";
	public static final String search_ewn = " //span[@class='glyphicon glyphicon-search']";
	
//	public static final String ENV="PROD"; //PROD, UAT,SAT 
	//paths
/*	public static final String REPORTS_PATH = "D:\\reports\\";
	public static final String DATA_XLS_PATH = System.getProperty("user.dir")+"\\data\\Data.xlsx";
	public static final String TESTDATA_SHEET = "TestData";
	public static final Object RUNMODE_COL = "Runmode";
	public static final String TESTCASES_SHEET = "TestCases";*/
	
//	public static Hashtable<String,String> table;
	
/*	public static Hashtable<String,String> getEnvDetails(){
		if(table==null){
			table = new Hashtable<String,String>();
			if(ENV.equals("ant444")){
				table.put("url", stg444);
				table.put("user_name", AJOETEST2);
				table.put("owner", APPLEROME18);
			}else if(ENV.equals("plb8085")){
				table.put("url", tst8085);
				table.put("user_name", AJOETEST2);
				table.put("owner", APPLEROME18);
				table.put("tr1", DOBTESTING123);
				table.put("tr8", DOBTESTING123);
				
				table.put("pw2", MRCTEST003);
				
			}
		}
		return table;
	}*/	
	
	//SavingAccounts/SavingAccount[ServiceOnline/text()='yes' or ServiceByPhone/text()='yes']
	// //input[@type='checkbox'][contains(@value,'/')]
/*	List<WebElement> el = driver.findElements(By.xpath("//*"));
    for ( WebElement e : el ) {
     System.out.println( e.getTagName() +" " +e.getText());
    }*/
/*	String[] elements = { "a","a","a","a" };   
	for (String s: elements) {           
	        System.out.println(s); 
	    }*/
	//*[contains(@id, 'idNumber1') or contains(@id, 'idNumber2')]
	
	//div[.//a[text()='SELENIUM']]/ancestor::div[@class='rt-grid-2 rt-omega']
	//div[.//a[text()='SELENIUM']]/following-sibling::div
}
