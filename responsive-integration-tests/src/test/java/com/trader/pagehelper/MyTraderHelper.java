package com.trader.pagehelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.trader.locators.Locator;
import com.trader.utils.DriverHelper;

/**
 * @author viveks
 * 
 * This class contains all methods related to My Trader Page.
 */
public class MyTraderHelper extends DriverHelper {

	public MyTraderHelper(WebDriver driver) {
		super(driver, getSoftAssert());
	}

	/**
	 * Assert My Trader page message.
	 */
	public void assertMyTraderPage() {
		print("Welcome to My Trader text on My Trader page");
		waitForElementPresentInDom(3);
		locator = Locator.MyTrader.MyTrader_Message.value;
		Assert.assertTrue(isTextPresent(locator, "Welcome to MyTrader"), "Element Locator :" + locator + " Not found");
	}

	/**
	 * Assert Saved Listing and Saved Searches section.
	 */
	public void assertSavedListingAndSavedSearchesSection() {
		print("Assert Saved Listing Section");
		locator = Locator.MyTrader.Saved_Listings_Section.value;
		Assert.assertTrue(isElementPresent(locator));
		print("Assert Saved Searches Section");
		String SavedSearches_locator = Locator.MyTrader.Saved_Searches_Section.value;
		Assert.assertTrue(isElementPresent(SavedSearches_locator));
	}

	/**
	 * Click on Edit button under Saved Listing Section.
	 */
	public void clickOnEditButtonOnSavedListings() {
		print("Click on Edit under Saved Listing Section");
		locator = Locator.MyTrader.Saved_Listing_Edit.value;
		clickOn(locator);
		Assert.assertTrue(isElementPresent(Locator.MyTrader.Your_Saved_Listing.value));
	}

	/**
	 * Click on Edit button under Saved Searches Section.
	 */
	public void clickOnEditButtonOnSavedSearches() {
		print("Click on Edit under Saved Searches Section");
		locator = Locator.MyTrader.Saved_Search_Edit.value;
		clickOn(locator);
		sleep(2000);
		Assert.assertTrue(isElementPresent(Locator.MyTrader.Your_Saved_Searches.value));
	}

	/**
	 * Click on My Trader Home Icon.
	 */
	public void clickOnMyTraderHomeIcon() {
		print("Click on My Trader Home Icon");
		locator = Locator.MyTrader.MyTrader_Home.value;
		clickOn(locator);
	}

	/**
	 * Click on Sell A Motorcycle Link.
	 */
	public void clickOnSellAMotorcycleLink() {
		print("Click on Sell A Motorcycle Link");
		locator = Locator.MyTrader.Sell_A_Motorcycle.value;
		waitForElementPresentInDom(2);
		clickOn(locator);
	}

	/**
	 * Click on Account Setting Link
	 */
	public void clickOnAccountSettingLink() {
		print("Click on Account Setting Link");
		locator = Locator.MyTrader.Account_Setting.value;
		clickOn(locator);
	}

	/**
	 * Update First name and last name
	 */
	public void updateFirstNameAndlastName() {
		print("Update First name and last name");
		DateFormat txt = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String fNamePostFix = "Vivek" + txt.format(date);
		String lNamePostFix = "Sharma" + txt.format(date);
		sendKeys(Locator.MyTrader.First_Name.value, fNamePostFix);
		sendKeys(Locator.MyTrader.Last_Name.value, lNamePostFix);
	}

	/**
	 * Click on Save Changes Button.
	 */
	public void clickOnSaveChangesButton() {
		print("Click on Save Changes Button");
		locator = Locator.MyTrader.Save_Changes_Button.value;
		clickOn(locator);
	}

	/**
	 * Assert Update changes Confirmation message.
	 */
	public void assertUpdateChangesMessage() {
		print("Assert Updates Changes Confirmation Message");
		locator = Locator.MyTrader.Updated_Changes_Messages.value;
		Assert.assertTrue(isElementPresent(locator));
	}
}
