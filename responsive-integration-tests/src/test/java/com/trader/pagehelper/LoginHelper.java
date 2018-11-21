package com.trader.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.trader.locators.Locator;
import com.trader.stringdata.Strings;
import com.trader.utils.DriverHelper;

/**
 * @author viveks
 * 
 *         This class contains all methods related to Login page.
 */
public class LoginHelper extends DriverHelper {

	public LoginHelper(WebDriver driver) {
		super(driver, getSoftAssert());
	}

	/**
	 * Click on Login Link in Menu bar.
	 */
	public void clickOnLogInLink() {

		print("Click Login link");
		clickOn(Locator.Login.Login_Link.value);
	}

	/**
	 * Enter Email ID.
	 * 
	 * @param uname
	 */
	public void enterEmailID(String uname) {
		print("Enter Email ID");
		sendKeys(Locator.Login.Email_Field.value, uname);
	}

	/**
	 * Enter Password.
	 * 
	 * @param password
	 */
	public void enterPassword(String password) {
		print("Enter Password");
		sendKeys(Locator.Login.Password_Field.value, password);
	}

	/**
	 * Click on Sign In Button.
	 */
	public void clickOnSignInButton() {
		print("Click on Sign in button");
		clickOn(Locator.Login.SignIn_Button.value);
		waitForElementPresentInDom(2);
	}

	/**
	 * This method to get user name from propery file.
	 * 
	 * @return
	 */
	public String getUserName() {
		print("Get user name");
		String userName = propertyReader.readApplicationFile("UserName");
		return userName;
	}

	/**
	 * This method to get password from propery file.
	 * 
	 * @return
	 */
	public String getPassword() {
		print("Get password");
		String pwd = propertyReader.readApplicationFile("UserPassword");
		return pwd;
	}

	/**
	 * This method is for login with valid details.
	 */
	public void loginToApplicaton() {
		this.clickOnLogInLink();
		String userName = this.getUserName();
		String pwd = this.getPassword();
		this.enterEmailID(userName);
		this.enterPassword(pwd);
		this.clickOnSignInButton();
		this.assertValidationMessage();
	}

	/**
	 * This method is assert the validation message.
	 */
	public void assertValidationMessage() {
		print("User should fail to Login");
		locator = Locator.Login.Login_Failed_Message.value;
		Assert.assertTrue(isTextPresent(locator, Strings.Messages.Invalid_UserName_Password.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Click on Forgot Your Password and Assert Forgot Password Page.
	 */
	public void clickOnForgotYourPasswordLinkAndAssertResultPage() {
		print("Click On Forgot Your Password Link");
		locator = Locator.Login.Forgot_Your_Password.value;
		clickOn(locator);
		Assert.assertTrue(isElementPresent(Locator.Login.Forgot_Password_Page.value));
	}

	public void assertLoginPage() {
		print("Assert Login Page.");
		locator = Locator.Login.Login_Page.value;
		Assert.assertTrue(isElementPresent(locator));	
	}
}
