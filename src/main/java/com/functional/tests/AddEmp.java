package com.functional.tests;

import org.testng.annotations.Test;
import com.common.Reporter;
import com.common.BaseTest;
import com.common.Element;
import com.utilities.WaitUtility;

@Test
public class AddEmp extends BaseTest {

	@Test(priority = 1)
	public void navigateToAddEmployee() {
		WaitUtility.waitForPageLoaded(driver);
		Element.reporter("Navigate to menu");
		Reporter.pass("'My Esmployees' is present in the menu");
		Element.reporter("Click on 'My Employees' ");
		Element.reporter("Go to 'Employees Information'");
		page.AddEmp.navigateToMenu("My Employees");
	}

	@Test(dataProvider = "EmployeeInformation", dataProviderClass = com.common.DataProvider.class, priority = 2)
	public void addEmployeeDetails(String run, String slno, String EmpID, String FirstName, String LastName, String SSN,
			String MobileNum, String MailID, String Street, String Appartment, String City, String ZipCode) {
		Element.reporter("Adding employee details in the application");
		page.AddEmp.addEmployeeInfo("Colorado", EmpID, FirstName, LastName, SSN, MobileNum, MailID, Street, Appartment,
				City, ZipCode);
		Reporter.pass("'Colorado' is present in state list");
		page.AddEmp.verifyMessage();
	}

//	@Test(priority = 3)
//	public void verifyEmployeeDetails() {
//		Element.reporter("Navigate To 'Employee Information' ");
//		Element.reporter("Verify that 'Employee ID' is present in the Employee ID list ");
//		WaitUtility.waitForElement();
//		page.AddEmp.verifyEmpInfo("test_Automation1");	
//	}
}
