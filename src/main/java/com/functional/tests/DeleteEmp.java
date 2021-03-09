package com.functional.tests;

import org.testng.annotations.Test;
import com.common.Reporter;
import com.common.BaseTest;
import com.common.Element;
import com.utilities.WaitUtility;

@Test
public class DeleteEmp extends BaseTest {

	@Test(priority = 0)
	public void navigateToMenu() {
		WaitUtility.waitForPageLoaded(driver);
		Element.reporter("Navigate to menu");
		Reporter.pass("'My Employees' is present in the menu");
		Element.reporter("Click on 'My Employees' ");
		Element.reporter("Go to 'Employees Information'");
		page.DeleteEmp.navigateToMenu("My Employees");
	}
	
	@Test(dataProvider = "EmployeeID", dataProviderClass = com.common.DataProvider.class, priority = 1)
	public void deleteEmp(String run, String slno, String EmpID) {
		page.DeleteEmp.deleteEmp(EmpID);
	}

	@Test(priority = 2)
	public void LogoutFromApplication() {
		Element.reporter("Logout from application");
		page.DeleteEmp.logout();
	}
}