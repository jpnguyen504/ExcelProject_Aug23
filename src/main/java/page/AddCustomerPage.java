package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import bsh.classpath.BshClassPath.GeneratedClassSource;

public class AddCustomerPage extends BasePage{
	
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElement List
	@FindBy(how = How.XPATH, using = "//h5")
	WebElement ADD_CONTACT_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@name = 'account']")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id = 'cid']")
	WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'email']")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'phone']")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'address']")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'city']")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'state']")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'zip']")
	WebElement ZIP_CODE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id = 'country']")
	WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@id = 'submit']")
	WebElement SAVE_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[3]/a")
	WebElement SAVED_USER_NAME_ELEMENT;

	String insertedName;
	
	// Corresponding methods
	public void validateAddCustomerPage(String validAddCustomerText) {
//		explicitWait(ADD_CONTACT_HEADER_ELEMENT);
		Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), validAddCustomerText, "Add Contact page not found");
	}
	public void insertFullName(String fullName) {
		insertedName = fullName + generateRandomNum(999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
	}
	
	public void selectCompanyDropdown(String company) {
		selectFromDropDown(COMPANY_DROPDOWN_ELEMENT, company);
	}
	
	public void insertEmail(String email) {
		String insertedEmail = generateRandomNum(999) + email;
		EMAIL_ELEMENT.sendKeys(insertedEmail);
	}
	
	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + generateRandomNum(999));
	}
	
	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}
	
	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}
	
	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}
	
	public void insertZipCode (String zipCode) {
		ZIP_CODE_ELEMENT.sendKeys(zipCode);
	}
	
	public void selectCountryDropdown(String country) {
		selectFromDropDown(COUNTRY_DROPDOWN_ELEMENT, country);
	}
	
	public void clickSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
	}
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]/a";
	String after_xpath_delete = "]/td[3]/following-sibling::td[4]/a[2]";
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
	
	public void verifyInsertedNameAndDelete() throws InterruptedException {
		for(int i = 1; i <= 10; i++) {
			String savedName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//			System.out.println(savedName);
			//Assert.assertEquals(savedName, insertedName, "Inserted name does not match");
			if(savedName.contentEquals(insertedName)) {
				System.out.println("Saved name matches.");
				Thread.sleep(2000);
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
			}
			break;
		}
	}
}
