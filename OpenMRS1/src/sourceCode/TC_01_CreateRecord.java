package sourceCode;

//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.AfterSuite;
//
//public class NewTest {
//	package com.automation.testscripts.datadriven;
//import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_01_CreateRecord {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Automation Workspace\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		
		ActionsClass actioncls = new ActionsClass(driver);
	
		//LoginPage logPage= new LoginPage(driver);
		actioncls.setUsername("Admin");
		actioncls.setPassword("Admin123");
		actioncls.clickRegistration();
		actioncls.clickLogin();
		
		
		//HomePage hmePage = new HomePage(driver);
		actioncls.clickReg();
		
		//RegistrationPage regPage = new RegistrationPage(driver);
		actioncls.setName("Scott");
		actioncls.setFamilyName("Tiger");
		actioncls.selectGender("Male");
		actioncls.setBirthLabel("21", "April", "1991");
		actioncls.setAdress("New Delhi");
		actioncls.clickConfirmation();
		actioncls.clickOnLogOut();
		
		driver.quit();

	}

}
