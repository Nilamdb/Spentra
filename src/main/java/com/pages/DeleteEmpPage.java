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

public class DeleteEmpPage {

	public WebDriver driver;

	public DeleteEmpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='j_username']")
	private WebElement email;
	@FindBy(xpath = "//input[@id='j_password']")
	private WebElement password;
	@FindBy(xpath = "//input[@value='Sign In']")
	private WebElement signinBtn;
	@FindBy(xpath = "//li[@class='parsley-required']  | //li[@class='parsley-type']")
	public WebElement alertError;
	@FindBy(xpath = "//div[@class='message']")
	public WebElement alertmsg;
	@FindBy(xpath = "//a[@class='navbar-brand text-white']")
	public WebElement logo;
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
	private WebElement EmpId;
	@FindBy(xpath = "(//i[@class='mdi mdi-search icon font-size-large'])[1]")
	private WebElement details;
	@FindBy(xpath = "//a[@onclick='deleteProfile()']")
	private WebElement deleteProfile;
	@FindBy(xpath = "//div[@class='text-center']")
	private WebElement ConfirmMsg;
	@FindBy(xpath = "//button[@class='btn btn-space btn-danger']")
	private WebElement yesMsg;
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement successfulMsg;
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	private WebElement noEmpMsg;
	@FindBy(xpath = "//img[@alt='Avatar']")
	private WebElement profile;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
	private WebElement logout;

//====Navigate To Menu  ====
	public void navigateToMenu(String menuName) {
		driver.navigate().refresh();
		WaitUtility.waitForPageLoaded(driver);
		for (WebElement MenuOptions : menuList) {
			if (MenuOptions.getText().trim().equalsIgnoreCase(menuName)) {
				Element.click(driver, MenuOptions, "Menu");
				break;
			}
		}
		WaitUtility.waitForPageLoaded(driver);
		Element.reporter("'Employee Information' is selected");
		WaitUtility.waitForElementsVisible(driver, employeeInfo);
		Element.click(driver, employeeInfo, "Employee Info");
		WaitUtility.waitForElementsVisible(driver, selectCompany);
		Element.click(driver, selectCompany, "Select Company Name");
		WaitUtility.waitForPageLoaded(driver);
		Element.click(driver, companyName, "Company Name");
		WaitUtility.waitForPageLoaded(driver);
		Reporter.pass("Select Company Name 'Ganart Technologies Inc.' ");
	}
	
//====Delete Employee ID====
	public void deleteEmp(String EmpID) {
		driver.navigate().refresh();
		WaitUtility.waitForPageLoaded(driver);
		Element.reporter("Uncheck the 'Show enrolled employees' checkBox ");
		Element.click(driver, cheakbox, "CheakBox");
		Element.reporter("Search for 'Employee ID' ");
		Element.click(driver, searchbox, "SearchBox");
		WaitUtility.waitForElementsVisible(driver, searchbox);
		Element.reporter("Enter 'Employee ID' ");
		Element.clearEnterText(driver, searchbox, EmpID, "search ID");
		Element.enterText(driver, searchbox, Keys.ENTER, "searchbox");
		WaitUtility.waitForElementsVisible(driver, EmpId);
		WaitUtility.waitForElement();
		Element.reporter("'Employee ID' is visible ");
		WaitUtility.waitForSeconds(7);
		Element.reporter("Click on Details ");
		Element.click(driver, details, "Details");
		Element.reporter("Click on Delete profile");
		Element.click(driver, deleteProfile, "delete Profile");
		Element.click(driver, yesMsg, "yes Msg");
		WaitUtility.waitForElement();
		WaitUtility.waitForElementsVisible(driver, EmpId);
		String msg1 = successfulmsg.getText();
		Reporter.pass("Message is displayed : " + msg1);
		Assert.assertEquals("Employee deleted successfully.", successfulmsg.getText());
		String empid = EmpId.getText();
		if (empid.equalsIgnoreCase(EmpID)) {
			Element.reporter("Employee Id " + EmpID + " is present in list");

		} else {
			Element.reporter("Employee Id " + EmpID + " is not present in list");
		}
	}

//====Logout From Application====
	public void logout() {
		WaitUtility.waitForElement();
		Element.click(driver, profile, "Go To Profile");
		WaitUtility.waitForElement();
		Element.reporter("Logged out successfully");
		Element.click(driver, logout, "Logout");
	}
}