package com.common;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pages.AddEmpPage;
import com.pages.DeleteEmpPage;
import com.pages.LoginPage;


public class BasePage {
	public WebDriver driver;
	public LoginPage login;
	public AddEmpPage AddEmp;
	public DeleteEmpPage DeleteEmp;
	public Logger log;
	


	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log = Logger.getLogger(this.getClass().getName());
		login = new LoginPage(driver);
		AddEmp = new AddEmpPage(driver);
		DeleteEmp =  new DeleteEmpPage(driver);
		
	}

}