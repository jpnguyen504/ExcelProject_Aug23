package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;
	ExcelReader exlRead = new ExcelReader("mockData\\\\TF_TestData.xlsx");
	String username = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboardValidText = exlRead.getCellData("LoginInfo", "DashboardValidation", 2);
	String addCustomerValidText = exlRead.getCellData("AddContactInfo", "AddCustomerValidation", 2);
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String company = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String phoneNum = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String state = exlRead.getCellData("AddContactInfo", "State", 2);
	String zipCode = exlRead.getCellData("AddContactInfo", "Zip", 2);
	String country = exlRead.getCellData("AddContactInfo", "Country", 2);
	
	
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(username);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidText);
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickAddCustomerMenuButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddCustomerPage(addCustomerValidText);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropdown(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phoneNum);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZipCode(zipCode);
		addCustomerPage.selectCountryDropdown(country);
		addCustomerPage.clickSaveButton();
		
		dashboardPage.clickListCustomerMenuButton();
		try {
			addCustomerPage.verifyInsertedNameAndDelete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		BrowserFactory.tearDown();
	}
}
