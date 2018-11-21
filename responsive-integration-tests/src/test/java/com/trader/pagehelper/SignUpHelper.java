package com.trader.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.trader.locators.Locator;
import com.trader.stringdata.Strings;
import com.trader.utils.DriverHelper;

/**
 * @author viveks This helper file used for Trader Sign Up Page.
 *
 */
public class SignUpHelper extends DriverHelper {
	public SignUpHelper(WebDriver driver) {
		super(driver, getSoftAssert());
	}

	/**
	 * Click on Join My Trader link / Button at Reasons to join MyTrader Page.
	 */
	public void clickOnJoinMyTraderlink() {
		print("Click On Join My Trader Button");
		locator = Locator.Login.JoinMYTrader_Link.value;
		clickOn(locator);
	}

	/**
	 * Enter First Name at Join MyTrader for free today! page.
	 * 
	 * @param fname
	 */
	public void enterFirstName(String fname) {
		print("Enter First Name");
		sendKeys(Locator.JoinMyTrader.First_Name.value, fname);
	}

	/**
	 * Enter Last Name at Join MyTrader for free today! page.
	 * 
	 * @param lname
	 */
	public void enterLastName(String lname) {
		print("Enter Last Name");
		sendKeys(Locator.JoinMyTrader.Last_Name.value, lname);
	}

	/**
	 * Enter Email ID at Join MyTrader for free today! page.
	 */
	public void enterEmailID() {
		print("Enter Email ID");
		locator = Locator.JoinMyTrader.Email_Field.value;
		String EmailAddress = email();
		sendKeys(locator, EmailAddress);
	}

	/**
	 * Enter existing email ID in email field.
	 * 
	 * @param EEID
	 */
	public void enterExistingEmail(String EEID) {
		print("Enter Existing Email ID");
		sendKeys(Locator.JoinMyTrader.Email_Field.value, EEID);
	}

	/**
	 * Enter Password at Join MyTrader for free today! page.
	 * 
	 * @param PWD
	 */
	public void enterPassword(String PWD) {
		print("Enter Password");
		sendKeys(Locator.JoinMyTrader.Password_Field.value, PWD);
	}

	/**
	 * Enter Re-Password at Join MyTrader for free today! page.
	 * 
	 * @param RPWD
	 */
	public void enterRepassword(String RPWD) {
		print("Enter Re-Password");
		sendKeys(Locator.JoinMyTrader.Re_Password.value, RPWD);
	}

	/**
	 * Enter Zip Code at Join MyTrader for free today! page.
	 * 
	 * @param ZCODE
	 */
	public void enterZipCode(String ZCODE) {
		print("Enter Zip Code");
		sendKeys(Locator.JoinMyTrader.Zip_Code.value, ZCODE);
	}

	/**
	 * Click on Join My Trader Button at Join MyTrader for free today! page.
	 */
	public void clickOnJoinMyTraderButton() {
		print("Click On Join My Tader Button at Join Trader page");
		locator = Locator.JoinMyTrader.JoinMyTrader_Button.value;
		clickOn(locator);
	}

	/**
	 * This method enter the all valid details in all sign up fields and click on
	 * Join My Trader Button.
	 */
	public void signUpToApplication() {
		clickOnJoinMyTraderlink();
		// String fName = this.getFirstName();
		// String lName = this.getLastName();
		String pwd = this.getPassword();
		String rePWD = this.getRepassword();
		// String zipCode = this.getZipCode();
		// this.enterFirstName(fName);
		// this.enterLastName(lName);
		this.enterEmailID();
		this.enterPassword(pwd);
		this.enterRepassword(rePWD);
		// this.enterZipCode(zipCode);
		this.clickOnJoinMyTraderButton();
	}

	/**
	 * In This method, trying to Sign Up with existing email ID.
	 */
	public void signUpWithExistingEmail() {
		clickOnJoinMyTraderlink();
		// String fName = this.getFirstName();
		// String lName = this.getLastName();
		String eEID = this.getExistingEmailID();
		String pwd = this.getPassword();
		String rePWD = this.getRepassword();
		// String zipCode = this.getZipCode();
		// this.enterFirstName(fName);
		// this.enterLastName(lName);
		this.enterExistingEmail(eEID);
		this.enterPassword(pwd);
		this.enterRepassword(rePWD);
		// this.enterZipCode(zipCode);
		this.clickOnJoinMyTraderButton();
	}
	
	/**
	 * This method is for trying to Sign Up with invalid Email ID.
	 */
	public void signUpWithInvalidEmailID() {
		clickOnJoinMyTraderlink();
		// String fName = this.getFirstName();
		// String lName = this.getLastName();
		String pwd = this.getPassword();
		String rePWD = this.getRepassword();
		// String zipCode = this.getZipCode();
		// this.enterFirstName(fName);
		// this.enterLastName(lName);
		this.enterExistingEmail("testuser@");
		this.enterPassword(pwd);
		this.enterRepassword(rePWD);
		// this.enterZipCode(zipCode);
		this.clickOnJoinMyTraderButton();
	}

	/**
	 * This method to get the First name from propery file.
	 * 
	 * @return
	 */
	public String getFirstName() {
		print("Get First name");
		String firstName = propertyReader.readApplicationFile("FirstName");
		return firstName;
	}

	/**
	 * This method to get the Last name from propery file.
	 * 
	 * @return
	 */
	public String getLastName() {
		print("Get Last name");
		String lastName = propertyReader.readApplicationFile("LastName");
		return lastName;
	}

	/**
	 * This method to get the password from propery file.
	 * 
	 * @return
	 */
	public String getPassword() {
		print("Get Password");
		String password = propertyReader.readApplicationFile("UserPassword");
		return password;
	}

	/**
	 * This method to get the Re-Password from propery file.
	 * 
	 * @return
	 */
	public String getRepassword() {
		print("Get Re-password");
		String rePassword = propertyReader.readApplicationFile("UserPassword");
		return rePassword;
	}

	/**
	 * This method to get the Zip Code from propery file.
	 * 
	 * @return
	 */
	public String getZipCode() {
		print("Get Zip Code");
		String zipCode = propertyReader.readApplicationFile("ZipCode");
		return zipCode;
	}

	/**
	 * This method to get existing email ID from propery file.
	 * 
	 * @return
	 */
	public String getExistingEmailID() {
		print("Get ExistingEmailID");
		String existingEmailID = propertyReader.readApplicationFile("UserName");
		return existingEmailID;
	}
	
	/**
	 *  Assert validation message for existing email ID.
	 */
	public void assertValidationForExistingEmail() {
		print("User should fail to Sign Up with Existing email");
		locator = Locator.JoinMyTrader.SignUp_ExistingEmail_Message.value;
		Assert.assertTrue(isElementPresent(locator));
	}
	
	/**
	 * Assert validation message for invalid email ID.
	 */
	public void assertValidationForInvalidEmail() {
		print("User should fail to Sign Up with invalid email");
		locator = Locator.JoinMyTrader.SignUp_InvalidEmail_Message.value;
		Assert.assertTrue(isTextPresent(locator, Strings.Messages.Invalid_Email.value),
				"Element Locator :" + locator + " Not found");
	}
}
