package com.functional.tests;

import com.common.Reporter;
import org.testng.annotations.Test;
import com.common.BaseTest;
import com.common.Constants;
import com.common.Element;
import com.utilities.WaitUtility;

public class Login extends BaseTest {

	String email, pass;

	@Test(priority = 1, dataProvider = "EmployeeInfo", dataProviderClass = com.common.DataProvider.class)
	public void negativeLoginTest(String run, String slno, String email, String pass) {
		Element.reporter("Check negative login");
		Element.reporter("Verify that the user is able to login with invalid email and invalid password.");
		driver.get(Constants.URL);
		page.login.checkNegativeLogin(email, pass);
		WaitUtility.waitForPageLoaded(driver);

		if (WaitUtility.checkIfElementVisibleInstant1(driver, page.login.logo)) {
			Element.reporter("Logged in : " + Constants.regEmail);
			Reporter.pass("Logged in :  " + Constants.regEmail);
		} else {
			Element.reporter("Not able to login for   " + email + "   and   " + pass);
			page.login.verifyAlertMessage();
		}
		driver.navigate().refresh();
}

	@Test(priority = 2)
	public void logintoApplication() {
		Element.reporter("Verify that the user is able to login with valid email and valid password.");
		Element.reporter("Login to application");
		driver.get(Constants.URL);
		page.login.loginToApplication(Constants.regEmail, Constants.regPass);
		WaitUtility.waitForPageLoaded(driver);
		try {
			if (Element.isVisible(driver, page.login.logo, "Logo")) {
				Reporter.pass("Login : " + Constants.regEmail);
			}
		} catch (Exception e) {
			Reporter.fail("Login Failed : " + Constants.regEmail);
		}
	}
}
