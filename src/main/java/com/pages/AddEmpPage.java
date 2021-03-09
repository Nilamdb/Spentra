package com.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.common.Element;
import com.common.Reporter;
import com.utilities.WaitUtility;
import org.testng.Assert;

public class AddEmpPage {

	public WebDriver driver;

	public AddEmpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='sidebar-elements']//li")
	private List<WebElement> menuList;
	@FindBy(xpath = "//li[@id='EmployeeInformation']")
	private WebElement employeeInfo;
	@FindBy(xpath = "//b[@role='presentation'][1]")
	private WebElement selectCompany;
	@FindBy(xpath = "//span[@title='Ganart Technologies Inc.']")
	private WebElement companyName;
	@FindBy(xpath = "//a[@id='btnAddEmployee']")
	private WebElement addEmployee;
	@FindBy(xpath = "//input[@id='primaryID']")
	private WebElement employeeID;
	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement employeeFname;
	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement employeeLname;
	@FindBy(xpath = "//i[@class='icon-th mdi mdi-calendar']")
	private WebElement calender;
	@FindBy(xpath = "(//th[@colspan='5'])[3]")
	private WebElement year;
	@FindBy(xpath = "(//th[@class='switch'])[4]")
	private WebElement currentyear;
	@FindBy(xpath = "(//span[@class='icon mdi mdi-chevron-left'])[5]")
	private WebElement priviousyear;
	@FindBy(xpath = "(//span[@class='year old'])[1]")
	private WebElement birthyear;
	@FindBy(xpath = "(//span[@class='month'])[5]")
	private WebElement month;
	@FindBy(xpath = "(//td[@class='day'])[18]")
	private WebElement date;
	@FindBy(xpath = "//input[@id='ssnLastFour']")
	private WebElement employeeSSN;
	@FindBy(xpath = "//input[@id='mobileNumber']")
	private WebElement employeeMnum;
	@FindBy(xpath = "//input[@id='emailAddress']")
	private WebElement employeeEmail;
	@FindBy(xpath = "//input[@id='address1']")
	private WebElement street;
	@FindBy(xpath = "//input[@id='address2']")
	private WebElement apt;
	@FindBy(xpath = "//input[@id='city']")
	private WebElement city;
	@FindBy(xpath = "//ul[@class='select2-results__options']//li")
	private List<WebElement> stateList;
	@FindBy(xpath = "//span[@id='select2-state-container']")
	private WebElement Searchstate;
	@FindBy(xpath = "//li[@id='select2-state-result-31ey-CO']")
	private WebElement state;
	@FindBy(xpath = "//input[@id='zip']")
	private WebElement zipCode;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement unsuccessfulmsg;
	@FindBy(xpath = "//div[@class='message']")
	private WebElement successfulmsg;
	@FindBy(xpath = "(//span[@class='custom-control-label'])[3]")
	private WebElement cheakbox;
	@FindBy(xpath = "//*[text()='Search:']/input")
	private WebElement searchbox;
	@FindBy(xpath = "//tr[@class='odd']")
	private WebElement EmpValidation;
	@FindBy(xpath = "//tr[@class='odd']//td[@class='sorting_1']")
	private WebElement EmpID;
	@FindBy(xpath = "//i[@class='mdi mdi-search icon font-size-large']")
	private WebElement EmpDetails;
	@FindBy(xpath = "(//tr[@class='odd'])[1]/td")
	private List<WebElement> listElement1;
	@FindBy(xpath = "(//tr[@role='row'])[1]//th")
	private List<WebElement> listElement2;
	@FindBy(xpath = "//img[@alt='Avatar']")
	private WebElement profile;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
	private WebElement logout;
	@FindBy(xpath = "(//i[@title='My Employees']")
	private WebElement myemployee;

//====Navigate To Menu ====
	public void navigateToMenu(String menuName) {
		WaitUtility.waitForPageLoaded(driver);
		for (WebElement MenuOptions : menuList) {
			if (MenuOptions.getText().trim().equalsIgnoreCase(menuName)) {
				Element.click(driver, MenuOptions, "Menu");
				break;
			}
		}
		WaitUtility.waitForPageLoaded(driver);
		Element.reporter("'Employee Information' is selected");
		Element.click(driver, employeeInfo, "Employee Info");
		Element.click(driver, selectCompany, "Select Company Name");
		WaitUtility.waitForPageLoaded(driver);
		Element.click(driver, companyName, "Company Name");
		WaitUtility.waitForPageLoaded(driver);
		Reporter.pass("Select company name 'Ganart Technologies Inc.' ");
		WaitUtility.waitForElementsVisible(driver, addEmployee);
		Element.click(driver, addEmployee, "Add Employee");
		Element.reporter("Click on 'Add Employee' button");
	}

//====Add Employee Details In The Textfield ====
	public void addEmployeeInfo(String stateName, String EmpID, String FirstName, String LastName, String SSN,
			String MobileNum, String MailID, String Street, String Appartment, String City, String ZipCode) {
		driver.navigate().refresh();
		WaitUtility.waitForPageLoaded(driver);
		WaitUtility.waitForElement();
		Element.clearEnterText(driver, employeeID, EmpID, "ID");
		Element.reporter("Add Employee ID : " + EmpID);
		Element.clearEnterText(driver, employeeFname, FirstName, "FName");
		Element.reporter("Add Employee First Name : " + FirstName);
		Element.clearEnterText(driver, employeeLname, LastName, "LName");
		Element.reporter("Add Employee Last Name : " + LastName);
		Element.click(driver, calender, "Calender");
		Element.click(driver, year, "Add year");
		Element.click(driver, currentyear, "Current year");
		Element.click(driver, priviousyear, "Privious year");
		Element.click(driver, priviousyear, "Privious year");
		Element.click(driver, birthyear, "Birth year");
		Element.click(driver, month, "Add month");
		Element.click(driver, date, "Add date");
		Element.reporter("Add Birthdate : 18 Jun 1999");
		Element.clearEnterText(driver, employeeSSN, SSN, "SSN");
		Element.reporter("Add SSN : " + SSN);
		Element.clearEnterText(driver, employeeMnum, MobileNum, "MNum");
		Element.reporter("Add Mobile Number : " + MobileNum);
		Element.clearEnterText(driver, employeeEmail, MailID, "MailId");
		Element.reporter("Add Mail Id : " + MailID);
		Element.clearEnterText(driver, street, Street, "Street");
		Element.reporter("Add Street : " + Street);
		Element.clearEnterText(driver, apt, Appartment, "Appartment");
		Element.reporter("Add Appartment : " + Appartment);
		Element.clearEnterText(driver, city, City, "City");
		Element.reporter("Add City : " + City);
		Element.click(driver, Searchstate, "State");
		for (WebElement StateOptions : stateList) {
			if (StateOptions.getText().trim().equalsIgnoreCase(stateName)) {
				Element.click(driver, StateOptions, "State");
				break;
			}
		}
		Element.clearEnterText(driver, zipCode, ZipCode, "ZipCode");
		Element.reporter("Add ZipCode : " + ZipCode);
		Element.click(driver, submitBtn, "Submit");
	}

//====Verification Of MSG====
	public void verifyMessage() {
		WaitUtility.waitForElement();
		String msg1 = successfulmsg.getText();
		Reporter.pass("Message is displayed : " + msg1);
		Assert.assertEquals("Employee added successfully.", successfulmsg.getText());
	}

//====Verification Of Employee ID====
//	public void verifyEmpInfo(String Id) {
//		WaitUtility.waitForElement();
//		Element.reporter("'Employee Information' is selected");
//		Element.click(driver, employeeInfo, "Employee Info");
//		Element.reporter("Navigate to 'Employee Information' ");
//		WaitUtility.waitForPageLoaded(driver);
//		WaitUtility.waitForElement();
//		Element.reporter("Uncheck the 'Show Enrolled Employees' checkBox ");
//		Element.click(driver, cheakbox, "CheckBox");
//		Element.click(driver, searchbox, "SearchBox");
//		WaitUtility.waitForElementsVisible(driver, searchbox);
//		Element.clearEnterText(driver, searchbox, Id, "search ID");
//		Element.enterText(driver, searchbox, Keys.ENTER, "searchbox");
//		WaitUtility.waitForElement();
//		Element.reporter("Search for 'Employee ID' ");
//		WaitUtility.waitForElementsVisible(driver, EmpID);
//		WaitUtility.waitForElement();
//		String empid = EmpID.getText();
//		if (empid.equalsIgnoreCase(Id)) {
//			Element.reporter("Employee id " + empid + " is present in list");
//
//			for (int i = 0; i < listElement1.size() - 1; i++) {
//				for (int j = i; j <= i; j++) {
//					String elementText1 = listElement1.get(i).getText();
//					String elementText2 = listElement2.get(j).getText();
//					Element.reporter(elementText2 + " : " + elementText1);
//				}
//			}
//		}
//	}
}