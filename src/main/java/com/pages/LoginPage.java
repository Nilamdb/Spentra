package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.common.Element;
import com.common.Reporter;
import com.framework.Logs;
import com.utilities.WaitUtility;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
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

//==== Check Negative Login===
	public void checkNegativeLogin(String user, String pass) {

		Element.reporter("Test negative login with  Email :    " + user + "    Password :  " + pass);
		WaitUtility.waitForElementVisible(driver, email);
		email.clear();
		email.sendKeys(user);
		WaitUtility.waitForElementVisible(driver, password);
		password.clear();
		password.sendKeys(pass);
		signinBtn.click();
	}

//==== Verification Of Alert Message====
	public void verifyAlertMessage() {
		if (Element.isVisible(driver, alertError, "alertError")) {
			String msg = alertError.getText();
			Logs.log.info(" Alert_Message " + msg);
			Reporter.pass("Alert Message : " + msg);
		} else {
			String msg = alertmsg.getText();
			Logs.log.info(" Alert_Message : " + msg);
			Reporter.pass("Alert Message : " + msg);
		}
	}

//====Login To Application ====
	public void loginToApplication(String user, String pass) {
		email.clear();
		email.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
		signinBtn.click();
	}

}
