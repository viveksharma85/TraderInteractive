package com.trader.pagehelper;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.trader.locators.Locator;
import com.trader.stringdata.Strings;
import com.trader.stringdata.Strings.FooterSection;
import com.trader.stringdata.Strings.RefineOptions;
import com.trader.utils.DriverHelper;

public class SearchHelper extends DriverHelper {
	protected WebDriver driver;

	public SearchHelper(WebDriver driver) {
		super(driver, getSoftAssert());
	}

	/**
	 * Assert the Search Tab at Home page.
	 */
	public void assertSearchTab() {
		print("Search tab enabled");
		locator = Locator.Home.Search_Tab.value;
		waitForElementPresentInDom(5);
		WaitForElementEnabled(locator, 20);
		Assert.assertTrue(isTextPresent(locator, Strings.Tab.Search_Tab.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Click on Find/Search button under search section.
	 */
	public void clickOnFindButton() {
		print("Click on find button");
		locator = Locator.Home.Find_Button.value;
		clickOn(locator);
		waitForElementPresentInDom(3);
	}

	/**
	 * Assert Search result page.
	 */
	public void assertSearchResultPage() {
		print("Motorcycles for Sale Page");
		locator = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Search_Result.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Click on Advanced Search Link at home page.
	 */
	public void clickOnAdvancedSearchLink() {
		print("Click on Advanced Search link");
		locator = Locator.Home.Advanced_Search_Link.value;
		clickOn(locator);
	}

	/**
	 * Assert advanced search page.
	 */
	public void assertAdvancedSearchPage() {
		print("Motorcycles for Sale Page");
		waitForElementPresentInDom(5);
		locator = Locator.Search.Advanced_Search_Page.value;
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Advanced_Search.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Enter Search details in all fields under search section.
	 */
	public void enterSearchDetails() {
		String kWord = this.getKeyword();
		String zCODE = this.getZipCode();
		String rADIUS = this.getRadius();
		this.enterKeyWord(kWord);
		this.enterZipCode(zCODE);
		this.selectRadiusFromDropDown(rADIUS);
	}

	/**
	 * Enter Keyword in search section at Home page.
	 * 
	 * @param KW
	 */
	public void enterKeyWord(String KW) {
		print("Enter KeyWord");
		locator = Locator.Home.Keyword_Field.value;
		sendKeys(locator, KW);
		print("Select Options from suggestion");
		sleep(3000);
		clickOn(Locator.Home.Keyword_Suggestion.value);
	}

	/**
	 * Assert Auto Suggestion Drop Down.
	 * 
	 * @param KW
	 */
	public void autoSuggestionDropDown() {
		print("Auto Suggestion Drop Down");
		String kWord = this.getKeyword();
		locator = Locator.Home.Keyword_Field.value;
		sendKeys(locator, kWord);
		print("Select Options from suggestion");
		waitForElementPresentInDom(5);
		Assert.assertTrue(isElementPresent(Locator.Home.Keyword_Auto_Suggestion.value));
	}

	/**
	 * Enter Zip Code in search section at Home page.
	 * 
	 * @param ZCode
	 */
	public void enterZipCode(String ZCode) {
		print("Enter Zip Code");
		sendKeys(Locator.Home.Zip_Code.value, ZCode);
	}

	/**
	 * Select radius from drop down in search section at Home page.
	 * 
	 * @param radius
	 */
	public void selectRadiusFromDropDown(String radius) {
		print("Select Radius");
		locator = Locator.Home.Radius_DropDown.value;
		clickOn(locator);
		selectDropDownByVisibleText(locator, radius);
	}

	/**
	 * This method to get the Keyword from propery file.
	 * 
	 * @return
	 */
	public String getKeyword() {
		print("Get Keyword");
		String keyWord = propertyReader.readApplicationFile("Keyword");
		return keyWord;
	}

	/**
	 * This method to get the Zip Code from propery file.
	 * 
	 * @return
	 */
	public String getZipCode() {
		print("Get Zip Code");
		String zipCode = propertyReader.readApplicationFile("SearchZipCode");
		return zipCode;
	}

	/**
	 * This method to get the Radius from propery file.
	 * 
	 * @return
	 */
	public String getRadius() {
		print("Get Radius");
		String radius = propertyReader.readApplicationFile("Radius");
		return radius;
	}

	/**
	 * Assert search result page.
	 */
	public void assertAdSearchResult() {
		print("Ad's Search Result page.");
		waitForElementPresentInDom(3);
		Assert.assertTrue(isElementPresent(Locator.Search.Ad_SearchResult.value));
	}

	/**
	 * In this method, input all location details and click on See Matches button.
	 * 
	 */
	public void searchWithLocationOption() {
		this.clickOnLocationOption();
		String zCODE = this.getZipCode();
		String lRadius = this.getLocationRadius();
		this.selectLocationRadius(lRadius);
		this.enterLocationZipCode(zCODE);
		this.clickOnLocationUpdateButton();
		this.clickOnSeeMatchesButton();
	}

	/**
	 * Click on Location option at Advanced Search page.
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnLocationOption() {
		print("Click on Location Option on Advanced Search");
		waitForElementPresentInDom(3);
		locator = Locator.AdvancedSearch.Location_Option.value;
		clickOn(locator);
	}

	/**
	 * Select location radius under Location section at Advanced Search page.
	 * 
	 * @param radius
	 */
	public void selectLocationRadius(String radius) {
		print("Select Radius from Location option");
		locator = Locator.AdvancedSearch.Location_Radius.value;
		clickOn(locator);
		selectDropDownByVisibleText(locator, radius);
		clickOn(locator);
	}

	/**
	 * Enter Zip code under Location section at Advanced Search page.
	 * 
	 * @param ZCode
	 */
	public void enterLocationZipCode(String ZCode) {
		print("Enter Zip code");
		sendKeys(Locator.AdvancedSearch.Location_ZipCode.value, ZCode);
	}

	/**
	 * Click on update button under location section at Advanced Search page.
	 * 
	 */
	public void clickOnLocationUpdateButton() {
		print("Click on update button");
		waitForElementPresentInDom(3);
		locator = Locator.AdvancedSearch.Location_Update.value;
		clickOn(locator);
		sleep(5000);
	}

	/**
	 * This method to get radius from property file.
	 * 
	 * @return
	 */
	public String getLocationRadius() {
		print("Get Location Radius");
		String radius = propertyReader.readApplicationFile("LocationRadius");
		return radius;
	}

	/**
	 * Click on See Matches button at Advanced Search page.
	 * 
	 */
	public void clickOnSeeMatchesButton() {
		print("Click on See Matches Button");
		waitForElementPresentInDom(3);
		locator = Locator.AdvancedSearch.See_Matches.value;
		String buttontext = getText(locator);
		buttontext = buttontext.replaceAll("\\D+", "");
		clickOn(locator);
	}

	public List<String> getRefineOptionsList() {
		print("Get refine Options from list");
		EnumSet<RefineOptions> all = EnumSet.allOf(RefineOptions.class);
		List<String> list = new ArrayList<>(all.size());
		for (RefineOptions s : all) {
			list.add(s.value);
		}
		return list;
	}

	/**
	 * Assert All refine options under advanced Search.
	 */
	public void assertRefinedOptionsUnderAdvancedSearch() {
		print("Assert All refine options under advanced Search");
		List<String> allRefineOptionsLists = getRefineOptionsList();
		for (String refineOptionsList : allRefineOptionsLists) {
			locator = "//*[@id='refinePanel']//a[contains(text(),'" + refineOptionsList + "')]";
			String txt = getText(locator);
			print(txt);
			Assert.assertTrue(isElementPresent(locator));
		}
	}

	/**
	 * Click on Keyword option at Advanced Search page.
	 * 
	 */
	public void clickOnAdvancedKeywordOption() {
		print("Click on Keyword option on Advaned Search");
		waitForElementPresentInDom(3);
		locator = Locator.AdvancedSearch.Keyword_Option.value;
		clickOn(locator);
	}

	/**
	 * Enter keyword in field at Advanced Search page.
	 */
	public void enterAdvancedKeyword() {
		print("Enter Keyword option on Advaned Search");
		String kWord = this.getKeyword();
		locator = Locator.AdvancedSearch.Advanced_Keyword.value;
		sendKeys(locator, kWord);
		waitForElementPresentInDom(2);
		String sugg = "(//div[@id='sugs']/li)[1]/span";
		clickOn(sugg);
	}

	/**
	 * Click on Update button under Keyword option at Advanced Search page.
	 */
	public void clickOnAdvancedKeywordUpdateButton() {
		print("Click on update button under Keyword Option");
		locator = Locator.AdvancedSearch.Keyword_Update_Button.value;
		waitForElementPresentInDom(2);
		clickOn(locator);
	}

	/**
	 * Click on Type Option at Advanced Search page
	 */
	public void clickOnAdvancedTypeOption() {
		print("Click on Type Option at Advanced Search page");
		sleep(5000);
		locator = Locator.AdvancedSearch.Advanced_Type.value;
		clickOn(locator);
	}

	/**
	 * Click on Make Option at Advanced Search page
	 */
	public void clickOnAdvancedMakeOption() {
		print("Click on Make Option at Advanced Search page");
		waitForElementPresentInDom(5);
		locator = Locator.AdvancedSearch.Advanced_Make.value;
		clickOn(locator);
	}

	/**
	 * Click on Model Option at Advanced Search page
	 */
	public void clickOnAdvancedModelOption() {
		print("Click on Model Option at Advanced Search page");
		waitForElementPresentInDom(3);
		locator = Locator.AdvancedSearch.Advanced_Model.value;
		clickOn(locator);
	}

	/**
	 * Click on Trim Option at Advanced Search page
	 */
	public void clickOnAdvancedTrimOption() {
		print("Click on Trim Option at Advanced Search page");
		waitForElementPresentInDom(5);
		locator = Locator.AdvancedSearch.Advanced_Trim.value;
		clickOn(locator);
	}

	/**
	 * Click on Category Option at Advanced Search page
	 */
	public void clickOnAdvancedCategoryOption() {
		print("Click on Category Option at Advanced Search page");
		waitForElementPresentInDom(3);
		locator = Locator.AdvancedSearch.Advanced_Category.value;
		clickOn(locator);
	}

	/**
	 * Click on price option at Advanced Search page.
	 */
	public void clickOnAdvancedPriceOption() {
		print("Click on price option at Advanced Search page.");
		waitForElementPresentInDom(5);
		locator = Locator.AdvancedSearch.Advanced_Price.value;
		clickOn(locator);
	}

	/**
	 * Click on New And Used option and select New Option at Advanced Search page.
	 */
	public void clickOnAdvancedNewAndUsedOption() {
		print("Click on New And Used option and select New Option at Advanced Search page.");
		waitForElementPresentInDom(5);
		locator = Locator.AdvancedSearch.Advanced_New_Used.value;
		clickOn(locator);
		String newOption = "//div[@id='conditionDetail']/div[2]/div/div";
		clickOn(newOption);
	}

	/**
	 * Click On year option under Advanced Search page.
	 */
	public void clickOnAdvancedYearOption() {
		print("Click On Advanced Year Option");
		waitForElementPresentInDom(5);
		locator = Locator.AdvancedSearch.Advanced_Year.value;
		clickOn(locator);
	}

	/**
	 * Click On Seller Type And Select Type
	 */
	public void clickOnSellerTypeAndSelectType() {
		print("Click On Seller Type And Select Type");
		waitForElementPresentInDom(3);
		locator = Locator.AdvancedSearch.Advanced_Seller_Type.value;
		clickOn(locator);
		String sellerType = "//div[@id='seller_typeDetail']//div[2]//a";
		clickOn(sellerType);
	}

	/**
	 * Click on Mileage option.
	 */
	public void clickOnMileageOption() {
		print("Click on Milage option.");
		waitForElementPresentInDom(3);
		locator = Locator.AdvancedSearch.Advanced_Mileage.value;
		clickOn(locator);
		waitForElementPresentInDom(2);
	}

	/**
	 * Click on Engine Size option.
	 */
	public void clickOnEngineSizeOption() {
		print("Click on Engine Size option.");
		locator = Locator.AdvancedSearch.Advanced_Engine_Size.value;
		clickOn(locator);
		waitForElementPresentInDom(3);
	}

	/**
	 * Click on State option and select state.
	 */
	public void clickOnStateOptionAndSelectState() {
		print("Click on State option and select state.");
		locator = Locator.AdvancedSearch.Advanced_State.value;
		clickOn(locator);
		waitForElementPresentInDom(3);
		String state = "//*[contains(@id,'popover')]//div[@class='refineOptions']/div[1]/div[1]";
		clickOn(state);
		waitForElementPresentInDom(3);
	}

	/**
	 * Click on City option and select City.
	 */
	public void clickOnCityOptionAndSelectCity() {
		print("Click on City option and select City.");
		locator = Locator.AdvancedSearch.Advanced_City.value;
		clickOn(locator);
		waitForElementPresentInDom(3);
		String city = "//*[contains(@id,'popover')]//div[@class='refineOptions']/div[1]/div[1]";
		clickOn(city);
		waitForElementPresentInDom(3);
	}

	/**
	 * Select Types from Pop Up at Advanced Search page
	 * 
	 * @throws InterruptedException
	 */
	public void selectTypesFromPopUp() {
		print("Select Types Option From Pop up");
		sleep(4000);
		// switchWin(0);
		locator = Locator.AdvancedSearch.Choose_Types.value;
		// String adsCount = getText(locator);

		clickOn(locator);
	}

	/**
	 * Select Makes from Pop Up at Advanced Search page
	 */
	public void selectMakesFromPopUp() {
		print("Select Make Option at Advanced Search page");
		sleep(2000);
		locator = Locator.AdvancedSearch.Choose_Make.value;
		this.getFirstVisible(locator, 20).click();
		// clickOn(locator);
		this.clickOnUpdateButtonOnPopUp();
	}

	/**
	 * Select Model from Pop Up at Advanced Search page
	 */
	public void selectModelFromPopUp() {
		print("Click on Make Option at Advanced Search page");
		waitForElementPresentInDom(5);
		locator = Locator.AdvancedSearch.Choose_Model.value;
		this.getFirstVisible(locator, 20).click();
		this.clickOnUpdateButtonOnPopUp();
	}

	/**
	 * Select Trim from Pop Up at Advanced Search page
	 */
	public void selectTrimFromPopUp() {
		print("Click on trim Option at Advanced Search page");
		waitForElementPresentInDom(5);
		locator = Locator.AdvancedSearch.Choose_Trim.value;
		((JavascriptExecutor) getWebDriver()).executeScript("scroll(0,-800)");
		clickOn(locator);
		waitForElementPresentInDom(5);
		// String update="//div[@id='priceDetail']/div[3]/div[1]";
		// clickOn(update);
	}

	/**
	 * Select Category from Pop Up at Advanced Search page
	 */
	public void selectCategoryFromPopUp() {
		print("Select Category Option from Category pop up at Advanced Search page");
		locator = Locator.AdvancedSearch.Choose_Category.value;
		clickOn(locator);
		// this.getFirstVisible(locator, 20).click();
		this.clickOnUpdateButtonOnPopUp();
	}

	/**
	 * Select Min And Max Price From PopUp.
	 */
	public void selectMinAndMaxPriceFromPopUp() {
		print("Select Min And Max Price From PopUp.");
		String minPrice = Locator.AdvancedSearch.Min_Price.value;
		clickOn(minPrice);
		waitForElementPresentInDom(2);
		String selectMinPrice = "//div[contains(@id,'popover')]//div[2]//select[contains(@class,'minValue')]/option[2]";
		clickOn(selectMinPrice);
		waitForElementPresentInDom(1);
		String maxPrice = Locator.AdvancedSearch.Max_Price.value;
		clickOn(maxPrice);
		String selectMaxPrice = "//div[contains(@id,'popover')]//div[2]//select[contains(@class,'maxValue')]/option[2]";
		clickOn(selectMaxPrice);
		String txt = "(//div[contains(@id,'popover')]//div[2]//span)[1]";
		clickOn(txt);
		String update = "(//div[@data-param='price']/div[3])[2]/div[1]";
		clickOn(update);
	}

	/**
	 * Select Min And Max year From Year PopUp.
	 */
	public void selectMinAndMaxYearFromYearPopUp() {
		print("Select Min And Max year From Year PopUp.");
		String minDropDown = Locator.AdvancedSearch.Min_Price.value;
		clickOn(minDropDown);
		String minYearLocator = "//div[contains(@id,'popover')]//div[2]//select[contains(@class,'minValue')]/option[2]";
		clickOn(minYearLocator);
		waitForElementPresentInDom(1);
		String maxDropDown = Locator.AdvancedSearch.Max_Price.value;
		clickOn(maxDropDown);
		String maxYearLocator = "//div[contains(@id,'popover')]//div[2]//select[contains(@class,'maxValue')]/option[20]";
		clickOn(maxYearLocator);
		String txt = "(//div[contains(@id,'popover')]//div[2]//span)[1]";
		clickOn(txt);
		String update = "(//div[@data-param='year']/div[3])[2]/div[1]";
		clickOn(update);
	}

	/**
	 * Select Min And Max Mileage From PopUp.
	 */
	public void selectMinAndMaxMileage() {
		print("Select Min And Max Mileage From PopUp.");
		String minMilage = Locator.AdvancedSearch.Min_Price.value;
		clickOn(minMilage);
		waitForElementPresentInDom(2);
		String selectMinMilage = "//div[contains(@id,'popover')]//div[2]//select[contains(@class,'minValue')]/option[2]";
		clickOn(selectMinMilage);
		waitForElementPresentInDom(1);
		String maxMileage = Locator.AdvancedSearch.Max_Price.value;
		clickOn(maxMileage);
		String selectMaxMileage = "//div[contains(@id,'popover')]//div[2]//select[contains(@class,'maxValue')]/option[2]";
		clickOn(selectMaxMileage);
		String txt = "(//div[contains(@id,'popover')]//div[2]//span)[1]";
		clickOn(txt);
		String update = "(//div[@data-param='mileage']/div[3])[2]/div[1]";
		clickOn(update);
		waitForElementPresentInDom(5);
	}

	/**
	 * Select Min And Max Engine Size From PopUp.
	 */
	public void selectMinAndMaxEngineSize() {
		print("Select Min And Max Engine Size From PopUp.");
		String minEngineSize = Locator.AdvancedSearch.Min_Price.value;
		clickOn(minEngineSize);
		waitForElementPresentInDom(2);
		String selectMinEngineSize = "//div[contains(@id,'popover')]//div[2]//select[contains(@class,'minValue')]/option[2]";
		clickOn(selectMinEngineSize);
		waitForElementPresentInDom(1);
		String maxEngineSize = Locator.AdvancedSearch.Max_Price.value;
		clickOn(maxEngineSize);
		String selectMaxEngineSize = "//div[contains(@id,'popover')]//div[2]//select[contains(@class,'maxValue')]/option[2]";
		clickOn(selectMaxEngineSize);
		String txt = "(//div[contains(@id,'popover')]//div[2]//span)[1]";
		clickOn(txt);
		String update = "(//div[@data-param='engineSize']/div[3])[2]/div[1]";
		clickOn(update);
		waitForElementPresentInDom(5);
	}

	/**
	 * Click on Update button.
	 */
	public void clickOnUpdateButtonOnPopUp() {
		print("Click on Update button");
		locator = Locator.AdvancedSearch.Update_Button_PopUp.value;
		this.getFirstVisible(locator, 20).click();
	}

	/**
	 * Click on Browse All Icon at Sale By Makes
	 */
	public void clickOnBrowseAllMakes() {
		print("Click on Browse All Icon at Sale By Makes");
		locator = Locator.Search.Browse_All_Makes.value;
		clickOn(locator);
	}

	/**
	 * Assert Sales By Makes links.
	 */
	public void assertSalebyMake() {
		print("Assert Sales By Makes links");
		locator = Locator.Search.Makes_Link.value;
		this.getFirstVisible(locator);
		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * Click On All Makes Breadcrumb Link.
	 */
	public void clickOnAllMakesBreadcrumbLink() {
		print("Click On All Makes Breadcrumb Link");
		locator = Locator.Makes.Home_Breadcrumb.value;
		clickOn(locator);
		waitForElementPresentInDom(5);
		clickOn(Locator.Home.Makes_SearchAll.value);
	}

	/**
	 * Click On BMW Link.
	 */
	public void clickOnBMWLink() {
		print("Click On BMW Link");
		locator = Locator.Makes.BMW_Link.value;
		clickOn(locator);
	}

	/**
	 * Click On Can-Am Link.
	 */
	public void clickOnCanAmLink() {
		print("Click On Can-Am Link");
		locator = Locator.Makes.CAN_AM_Link.value;

	}

	/**
	 * Click On Ducati Link.
	 */
	public void clickOnDucatiLink() {
		print("Click On Ducati Link");
		locator = Locator.Makes.Ducati_Link.value;
		clickOn(locator);
	}

	/**
	 * Click On Harley Davidson Link.
	 */
	public void clickOnHarleyLink() {
		print("Click On Harley Davidson Link");
		locator = Locator.Makes.Harley_Link.value;
		clickOn(locator);
	}

	/**
	 * Click On Honda Link.
	 */
	public void clickOnHondaLink() {
		print("Click On Honda Link");
		locator = Locator.Makes.Honda_Link.value;
		clickOn(locator);
	}

	/**
	 * Click On KTM Link.
	 */
	public void clickOnKTMLink() {
		print("Click On KTM Link");
		locator = Locator.Makes.KTM_Link.value;
		clickOn(locator);
	}

	/**
	 * Click On Kawasaki Link.
	 */
	public void clickOnKawasakiLink() {
		print("Click On Kawasaki Link");
		locator = Locator.Makes.Kawasaki_Link.value;
		clickOn(locator);
	}

	/**
	 * Click On Suzuki Link.
	 */
	public void clickOnSuzukiLink() {
		print("Click On Suzuki Link");
		locator = Locator.Makes.Suzuki_Link.value;
		clickOn(locator);
	}

	/**
	 * Click On Triumph Link
	 */
	public void clickOnTriumphLink() {
		print("Click On Triumph Link");
		locator = Locator.Makes.Triumph_Link.value;
		clickOn(locator);
	}

	/**
	 * Click On Victory Link
	 */
	public void clickOnVictoryLink() {
		print("Click On Victory Link");
		locator = Locator.Makes.Victory_link.value;
		clickOn(locator);
	}

	/**
	 * Click On Yamaha Link
	 */
	public void clickOnYamahaLink() {
		print("Click On Yamaha Link");
		locator = Locator.Makes.Yamaha_Link.value;
		clickOn(locator);
	}

	/**
	 * Click On Yamaha Icon
	 */
	public void clickOnYamahaIcon() {
		print("Click On Yamaha Icon");
		locator = Locator.Makes.Yamaha_Icon.value;
		clickOn(locator);
	}

	/**
	 * Click On Triumph Icon
	 */
	public void clickOnTriumphIcon() {
		print("Click On Triumph Icon");
		locator = Locator.Makes.Triumph_Icon.value;
		clickOn(locator);
	}

	/**
	 * Click On BMW Icon
	 */
	public void clickOnBMWIcon() {
		print("Click On BMW Icon");
		locator = Locator.Makes.BMW_Icon.value;
		clickOn(locator);
	}

	/**
	 * Assert Location updates.
	 */
	public void assertLocationUpdate() {
		print("Assert Location updates");
		waitForElementPresentInDom(3);
		locator = Locator.AdvancedSearch.Location_Updates.value;
		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * Wait for Updating Spinner
	 */
	public void waitForUpdatingSpinner() {
		print("Wait for Updating Spinner");
		locator = Locator.AdvancedSearch.Updating_Spinner.value;
		WaitForElementNotVisible(locator, 50);
	}

	/**
	 * Enter Keyword And Select Suggestion.
	 */
	public void enterKeywordAndSelectSuggestion() {
		print("Enter Keyword And Select Suggestion");
		String kWord = this.getKeyword();
		waitForElementPresentInDom(2);
		locator = Locator.AdvancedSearch.Advanced_Keyword.value;
		sendKeys(locator, kWord);
		waitForElementPresentInDom(2);
		clickOn("//div[@id='keywordDetail']/div[2]/div/li[1]");
	}

	/**
	 * Assert Keyword search Result Page
	 */
	public void assertKeywordSearchResult() {
		print("Assert Keyword search Result Page");
		String expected = propertyReader.readApplicationFile("Keyword");
		locator = Locator.Search.Search_Result_Page.value;
		String actual = getText(locator);
		sleep(5000);
		Assert.assertTrue(expected.contains(actual));
	}

	/**
	 * Search with location from refine search at search result page.
	 * 
	 */
	public void searchWithLocationFormRefineSearch() {
		this.clickOnLocationOption();
		waitForElementPresentInDom(3);
		String zCODE = this.getZipCode();
		String lRadius = this.getLocationRadius();
		this.selectLocationRadius(lRadius);
		this.enterLocationZipCode(zCODE);
		waitForElementPresentInDom(3);
		this.clickOnLocationUpdateButton();
		this.assertLocationUpdate();
	}

	/**
	 * Select Make option from refined section and assert search result page.
	 * 
	 */
	public void selectMakesOptionAndAssertSearchResultPage() {
		print("Select Make Option at Advanced Search page");
		waitForElementPresentInDom(3);
		locator = Locator.AdvancedSearch.Choose_Make.value;
		String txt = this.getFirstVisible(locator, 30).getText();
		this.getFirstVisible(locator, 30).click();
		this.clickOnUpdateButtonOnPopUp();
		//this.waitForUpdatingSpinner();
		waitForElementPresentInDom(3);
		String expected = getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText();
		Assert.assertTrue(expected.contains(txt));
	}

	/**
	 * Select model Option at Advanced Search page and result page.
	 *
	 */
	public void selectModelOptionAndAssertSearchResultPage() {
		print("Select model Option at Advanced Search page");
		this.clickOnAdvancedModelOption();
		waitForElementPresentInDom(2);
		locator = Locator.AdvancedSearch.Choose_Model.value;
		String txt = this.getFirstVisible(locator, 20).getText();
		this.getFirstVisible(locator, 20).click();
		this.clickOnUpdateButtonOnPopUp();
		//this.waitForUpdatingSpinner();
		waitForElementPresentInDom(3);
		String expected = getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText();
		Assert.assertTrue(expected.contains(txt));
	}

	/**
	 * Select Trim Option at Advanced Search page and Assert Result page.
	 * 
	 */
	public void selectTrimOptionAndAssertSearchResultPage() {
		print("Select Trim Option at Advanced Search page");
		this.clickOnAdvancedTrimOption();
		waitForElementPresentInDom(2);
		locator = Locator.AdvancedSearch.Choose_Trim.value;
		String txt = getText(locator);
		System.err.println(txt);
		clickOn(locator);
		waitForElementPresentInDom(2);
		String trimUpdate = "(//*[@data-track='Refine-Add To Search'])[5]";
		clickOn(trimUpdate);
		System.err.println("Click On Update");
		waitForElementPresentInDom(2);
		// .clickOnUpdateButtonOnPopUp();
		// this.waitForUpdatingSpinner();
		String expected = getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText();
		Assert.assertTrue(expected.contains(txt));
	}

	/**
	 * Select Category Option at Advanced Search page and Assert result page.
	 * 
	 */
	public void selectCategoryOptionAndAssertSearchResultPage() {
		print("Select Category Option at Advanced Search page");
		this.clickOnAdvancedCategoryOption();
		waitForElementPresentInDom(2);
		locator = Locator.AdvancedSearch.Choose_Category.value;
		String txt = this.getFirstVisible(locator, 20).getText();
		this.getFirstVisible(locator, 20).click();
		this.clickOnUpdateButtonOnPopUp();
		//this.waitForUpdatingSpinner();
		waitForElementPresentInDom(3);
		String expected = getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText();
		Assert.assertTrue(expected.contains(txt));
	}

	/**
	 * Click on Recent search link and assert result page.
	 */
	public void clickAndAssertRecentSearchLinkResult() {
		print("Recent search link");
		waitForElementPresentInDom(3);
		locator = Locator.AdvancedSearch.Choose_Make.value;
		String txt = this.getFirstVisible(locator, 20).getText();
		this.getFirstVisible(locator, 20).click();
		waitForElementPresentInDom(2);
		this.clickOnUpdateButtonOnPopUp();
		//this.waitForUpdatingSpinner();
		waitForElementPresentInDom(3);
		String expected = getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText();
		Assert.assertTrue(expected.contains(txt));
		clickOn(Locator.Home.Application_Logo.value);
		print("Click on Recent Search section");
		waitForElementPresentInDom(2);
		clickOn(Locator.Home.Recent_Searches.value);
		print("Click on Recent Search link");
		waitForElementPresentInDom(2);
		clickOn(Locator.Home.Recent_Search_Link.value);
		waitForElementPresentInDom(3);
		String resultPage= getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText();
		Assert.assertTrue(resultPage.contains(txt));
	}

	/**
	 * Click on Find by Make, State and Type button and assert result page.
	 */
	public void clickOnFindByButtonsAndAssertResultPage() {
		print("Click On Find By Make Button And Assert Result Page");
		waitForElementPresentInDom(3);
		locator = Locator.AdvancedSearch.Find_By_Search_Result.value;
		print(getText(locator));

		clickOn(Locator.AdvancedSearch.Find_By_Make_Button.value);
		waitForElementPresentInDom(2);
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Find_By_Make.value),
				"Element Locator :" + locator + " Not found");
		waitForElementPresentInDom(2);
		clickOn(Locator.Menus.BUY.value);
		print("Click On Find By Type Button And Assert Result Page");
		waitForElementPresentInDom(2);
		clickOn(Locator.AdvancedSearch.Find_By_Type_Button.value);
		waitForElementPresentInDom(2);
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Find_By_Type.value),
				"Element Locator :" + locator + " Not found");
		waitForElementPresentInDom(2);
		clickOn(Locator.Menus.BUY.value);
		print("Click On Find By State Button And Assert Result Page");
		waitForElementPresentInDom(2);
		clickOn(Locator.AdvancedSearch.Find_By_State_Button.value);
		waitForElementPresentInDom(2);
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Find_By_State.value),
				"Element Locator :" + locator + " Not found");
		// clickOn(Locator.Menus.BUY.value);
	}

	/**
	 * Click On Save This Search And Assert Saved Search.
	 */
	public void clickOnSaveThisSearchAndAssertSavedSearch() {
		print("Click On Save This Search And Assert Saved Search");
		waitForElementPresentInDom(3);
		String saveSearchbutton = Locator.Search.Save_This_Search_Button.value;
		String buttonTxt = getText(saveSearchbutton);
		if (buttonTxt == "Saved") {
			clickOn(saveSearchbutton);
			waitForElementPresentInDom(3);
			clickOn(saveSearchbutton);
		} else {
			clickOn(saveSearchbutton);
		}
		String savedSearchText = propertyReader.readApplicationFile("SaveSearchName");
		getWebDriver().findElement(By.xpath("//div[@id='mytraderModal']//input"))
				.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		sendKeys(Locator.Search.Save_Search_Title.value, savedSearchText);
		clickOn(Locator.Search.Save_Search_Button.value);
		print("Click On Saved Icon in header section");
		sleep(5000);
		clickOn(Locator.Menus.Saved_Icon.value);
		sleep(5000);
		Assert.assertTrue(isElementPresent(Locator.MyTrader.MyTrader_Message.value));
		clickOn(Locator.MyTrader.Saved_Searches.value);
		String savedSearch = getWebDriver().findElement(By.xpath("//*[@class='myt-content']//li[1]//span/span"))
				.getText();
		Assert.assertTrue(savedSearchText.contains(savedSearch));
	}

	/**
	 * This method is to click On save Seacrh icon and assert saved search.
	 */
	public void clickOnSaveIconAndAssertsavedListing() {
		print("Click On Ad And Assert Ad Details Page");
		locator = Locator.Search.Listed_AD.value;
		clickOn(locator);
		print("Assert Listing Name");
		String listingName = getWebDriver().findElement(By.xpath("(//*[@class='detail-title']//h2)[1]")).getText();
		String locator1 = Locator.Search.Save_Listing.value;
		clickOn(locator1);
		waitForElementPresentInDom(2);
		String locator2 = Locator.Search.Save_Listing_Button.value;
		clickOn(locator2);
		print("Click On Saved Icon in header section");
		waitForElementPresentInDom(5);
		clickOn(Locator.Menus.Saved_Icon.value);
		waitForElementPresentInDom(5);
		Assert.assertTrue(isElementPresent(Locator.MyTrader.MyTrader_Message.value));
		clickOn(Locator.MyTrader.Saved_Listing.value);
		String savedListing = getWebDriver().findElement(By.xpath("//*[@class='grid-image-wrapper']//div[3]/a"))
				.getText();
		Assert.assertTrue(listingName.contains(savedListing));
	}

	/**
	 * Click On Save listings link And Assert saved Listings.
	 */
	public void clickOnSaveListingLinkAndAssertSavedListing() {
		print("Click On Save listings link And Assert saved Listings");
		locator = Locator.Search.Save_Listing_Link.value;
		String listingName = getWebDriver().findElement(ByLocator(Locator.Search.Listed_AD.value)).getText();
		clickOn(locator);
		waitForElementPresentInDom(2);
		String SaveListing_locator = Locator.Search.Save_Listing_Button.value;
		clickOn(SaveListing_locator);
		print("Click On Saved Icon in header section");
		waitForElementPresentInDom(5);
		clickOn(Locator.Menus.Saved_Icon.value);
		waitForElementPresentInDom(5);
		Assert.assertTrue(isElementPresent(Locator.MyTrader.MyTrader_Message.value));
		clickOn(Locator.MyTrader.Saved_Listing.value);
		String savedListing = getWebDriver().findElement(By.xpath("//*[@class='grid-image-wrapper']//div[3]/a"))
				.getText();
		Assert.assertTrue(listingName.contains(savedListing));
	}

	/**
	 * Click On Ad listing And Assert Ad Details Page
	 */
	public void clickOnAdAndAssertAdDetailsPage() {
		print("Click On Ad And Assert Ad Details Page");
		locator = Locator.Search.Listed_AD.value;
		waitForElementPresentInDom(2);
		String listing = getText(locator);
		print(listing);
		clickOn(locator);
		print("Assert Listing Name");
		String listingName = getWebDriver().findElement(By.xpath("(//*[@class='detail-title']//h2)[1]")).getText();
		print("Assert Listing Name"+listingName);
		Assert.assertTrue(listing.contains(listingName));
	}

	/**
	 * Click On Email Only icon And Assert Contact seller Section.
	 */
	public void clickOnEmailOnlyAndAssertContactsellerSection() {
		print("Click On Email Only And Assert Contact seller Section");
		locator = Locator.Search.Email_Only.value;
		clickOn(locator);
		Assert.assertTrue(isElementPresent(Locator.Search.Contact_Seller.value));
	}

	/**
	 * Enter First name, Last Name, Email Id and select Verify Checkbox.
	 */
	public void enterSellerDetailsAndClickOnContactButton() {
		print("Enter first Name");
		String fname = propertyReader.readApplicationFile("ContactFname");
		locator = Locator.ListingDetails.Seller_Fname.value;
		sendKeys(locator, fname);

		print("Enter Last Name");
		String lname = propertyReader.readApplicationFile("ContactLname");
		String LastName_locator = Locator.ListingDetails.Seller_Lname.value;
		sendKeys(LastName_locator, lname);

		print("Enter email Id");
		String emailID = propertyReader.readApplicationFile("ContactEmail");
		String ContactEmail_locator = Locator.ListingDetails.Seller_Email.value;
		sendKeys(ContactEmail_locator, emailID);

		print("Click on Verify Captcha check box");

		String VerifyCheckBox_locator = Locator.ListingDetails.Verify_Checkbox.value;
		getWebDriver().switchTo().frame(getWebDriver().findElement(By.xpath("//iframe[@role='presentation']")));
		// javascriptButtonClick(locator3);
		sleep(3000);
		clickOn(VerifyCheckBox_locator);
		sleep(3000);
		print("Clicked");
	}

	/**
	 * This method is for Save Listing
	 */
	public void saveListing() {
		this.assertSearchTab();
		this.enterSearchDetails();
		this.clickOnFindButton();
		this.assertAdSearchResult();
		this.clickOnSaveListingLinkAndAssertSavedListing();
	}

	/**
	 * This method is for save search.
	 */
	public void saveSearch() {
		this.assertSearchTab();
		this.enterSearchDetails();
		this.clickOnFindButton();
		this.assertAdSearchResult();
		this.clickOnSaveThisSearchAndAssertSavedSearch();
	}

	/**
	 * Click on any listing with Price getting first on page and
	 */
	public void clickOnListingWithPriceAndEstimatePaymentIcon() {
		print("Click on any Listing with Price");
		locator = Locator.Search.Listing_With_Price.value;
		waitForElementPresentInDom(2);
		getFirstVisible(locator).click();
		waitForElementPresentInDom(5);
		clickOn(Locator.Search.Estimate_Payment.value);
	}

	/**
	 * In this method, enter all required details on Estimate Payment Window.
	 */
	public void estimatePaymentWindow() {
		print("Input all details and estimat payment");
		waitForElementPresentInDom(3);
		String downPayment = propertyReader.readApplicationFile("DownPayment");
		sendKeys(Locator.ListingDetails.Down_Payment.value, downPayment);
		String interestRate = propertyReader.readApplicationFile("InterestRate");
		sendKeys(Locator.ListingDetails.Interest_Rate.value, interestRate);
		waitForElementPresentInDom(2);
		clickOn(Locator.ListingDetails.Loan_Term.value);
		waitForElementPresentInDom(2);
		Assert.assertTrue(isElementPresent(Locator.ListingDetails.Estimated_Payment.value));
		clickOn(Locator.ListingDetails.Cross_Icon.value);
	}

	/**
	 * Assert Find By Make, State And Type Button At Advanced Search Page.
	 */
	public void assertFindByMakeStateAndTypeButtonAtAdvancedSearchPage() {
		print("Assert Find By Make, State And Type Button At Advanced Search Page");
		String findByMakelocator = Locator.AdvancedSearch.Find_By_Make_Button.value;
		Assert.assertTrue(isTextPresent(findByMakelocator, Strings.Button.Find_By_Make.value),
				"Element Locator :" + findByMakelocator + " Not found");
		String findByTypelocator = Locator.AdvancedSearch.Find_By_Type_Button.value;
		Assert.assertTrue(isTextPresent(findByTypelocator, Strings.Button.Find_By_Type.value),
				"Element Locator :" + findByTypelocator + " Not found");
		String findByStatelocator = Locator.AdvancedSearch.Find_By_State_Button.value;
		Assert.assertTrue(isTextPresent(findByStatelocator, Strings.Button.Find_By_State.value),
				"Element Locator :" + findByStatelocator + " Not found");
	}

	/**
	 * Click On Find By Make Button And Assert Result Page.
	 */
	public void clickOnFindByMakeButtonAndAssertResultPage() {
		print("Click On Find By Make Button And Assert Result Page.");
		clickOn(Locator.AdvancedSearch.Find_By_Make_Button.value);
		locator = Locator.AdvancedSearch.Find_By_Search_Result.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Find_By_Make.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Click On Find By Type Button And Assert Result Page.
	 */
	public void clickOnFindByTypeButtonAndAssertResultPage() {
		print("Click On Find By Type Button And Assert Result Page.");
		clickOn(Locator.AdvancedSearch.Find_By_Type_Button.value);
		locator = Locator.AdvancedSearch.Find_By_Search_Result.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Find_By_Type.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Click On Find By State Button And Assert Result Page.
	 */
	public void clickOnFindByStateButtonAndAssertResultPage() {
		print("Click On Find By State Button And Assert Result Page.");
		clickOn(Locator.AdvancedSearch.Find_By_State_Button.value);
		locator = Locator.AdvancedSearch.Find_By_Search_Result.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Find_By_State.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Click on location and assert location options under advanced search page.
	 */
	public void clickOnLocationAndAssertLocationsOptions() {
		print("Click on location and assert location options under advanced search page.");
		this.clickOnLocationOption();
		Assert.assertTrue(isElementPresent(Locator.AdvancedSearch.Location_Radius.value));
		Assert.assertTrue(isElementPresent(Locator.AdvancedSearch.Location_ZipCode.value));
	}

	/**
	 * Assert Auto suggestion drop down.
	 */
	public void assertAutoSuggestionDropDown() {
		print("Assert Auto suggestion drop down.");
		this.clickOnAdvancedKeywordOption();
		String kWord = this.getKeyword();
		locator = Locator.AdvancedSearch.Advanced_Keyword.value;
		sendKeys(locator, kWord);
		waitForElementPresentInDom(10);
		String autoSuggestion = "//div[@id='keywordDetail']/div[2]/div/li[1]/span";
		Assert.assertTrue(isElementPresent(autoSuggestion));
	}
	
	public void enterKeywordAndAssertResult() {
		print("Enter Keyword And Assert Result");
		this.clickOnAdvancedKeywordOption();
		String kWord = this.getKeyword();
		locator = Locator.AdvancedSearch.Advanced_Keyword.value;
		sendKeys(locator, kWord);
		waitForElementPresentInDom(2);
		String updateButton="//*[@id='keywordDetail']//div[@data-track='Update Keyword']";
		clickOn(updateButton);
		
	}

	/**
	 * Click On See Matches Button And Assert Listing Counts.
	 */
	public void clickOnSeeMatchesButtonAndAssertListingCounts() {
		print("Click On See Matches Button And Assert Listing Counts.");
		waitForElementPresentInDom(10);
		String seeMatchesButton = Locator.AdvancedSearch.See_Matches_Button.value;
		String buttonText = getText(seeMatchesButton);
		String finalButtonText = buttonText.replaceAll("[,]*", "");
		print(finalButtonText);
		clickOn(seeMatchesButton);
		String listingMatchesCount = Locator.AdvancedSearch.Listing_Matches_Counts.value;
		String listingCount = getText(listingMatchesCount);
		String finalListingCount = listingCount.replaceAll("[,]*", "");
		print(finalListingCount);
		Assert.assertTrue(finalButtonText.matches(finalListingCount));
	}

	/**
	 * Click On Start Over Link And Assert Filter Reset.
	 */
	public void clickOnStartOverLinkAndAssertFilterReset() {
		print("Click On Start Over Link And Assert Filter Reset");
		locator = Locator.AdvancedSearch.Start_Over_Link.value;
		clickOn(locator);
		waitForElementPresentInDom(5);
		String remove = "(//*[contains(@class,'resetFilter rfloat hide')])[3]";
		Assert.assertTrue(isElementPresent(remove));
	}

	public List<String> getFindByLinksList() {
		print("Get find by links from list");
		EnumSet<FooterSection> all = EnumSet.allOf(FooterSection.class);
		List<String> list = new ArrayList<>(all.size());
		for (FooterSection s : all) {
			list.add(s.value);
		}
		return list;
	}

	/**
	 * Assert find By links under advanced Search.
	 */
	public void assertFindByLinksUnderAdvancedSearch() {
		print("Assert find By links under advanced Search");
		List<String> allFindByLists = getFindByLinksList();
		for (String findByList : allFindByLists) {
			locator = "//*[@id='page-content-wrapper']//a[contains(text(),'" + findByList + "')]";
			String txt = getText(locator);
			print(txt);
			Assert.assertTrue(isElementPresent(locator));
		}
	}

	/**
	 * Click On Find By Make And Assert Result Page.
	 */
	public void clickOnFindByMakeAndAssertResultPage() {
		print("Click On Find By Make And Assert Result Page");
		locator = Locator.AdvancedSearch.Find_By_Make.value;
		String makeTxt = getText(locator);
		print(makeTxt);
		String[] text2 = makeTxt.split(" ");
		String Finaltext = text2[text2.length - 1];
		print(Finaltext);
		clickOn(locator);
		String resultPage = Locator.Search.Advanced_Search_Page.value;
		String resultPageTxt = getText(resultPage);
		Assert.assertTrue(resultPageTxt.contains(Finaltext));
	}

	/**
	 * Click On Find By Type And Assert Result Page.
	 */
	public void clickOnFindByTypeAndAssertResultPage() {
		print("Click On Find By Type And Assert Result Page");
		locator = Locator.AdvancedSearch.Find_By_Type.value;
		String typeTxt = getText(locator);
		String[] text2 = typeTxt.split(" ");
		String Finaltext = text2[text2.length - 1];
		print(Finaltext);
		clickOn(locator);
		String resultPage = Locator.Search.Advanced_Search_Page.value;
		String resultPageTxt = getText(resultPage);
		Assert.assertTrue(resultPageTxt.contains(Finaltext));
	}

	/**
	 * Click On Find By State And Assert Result Page.
	 */
	public void clickOnFindByStateAndAssertResultPage() {
		print("Click On Find By State And Assert Result Page");
		locator = Locator.AdvancedSearch.Find_By_State.value;
		String stateTxt = getText(locator);
		String[] text2 = stateTxt.split(" ");
		String Finaltext = text2[text2.length - 1];
		clickOn(locator);
		String resultPage = Locator.Search.Advanced_Search_Page.value;
		String resultPageTxt = getText(resultPage);
		Assert.assertTrue(resultPageTxt.contains(Finaltext));
	}

	/**
	 * Click On Find Motorcycle Dealers And Assert Result Page.
	 */
	public void clickOnFindDealerAndAssertResultPage() {
		print("Click On Find Motorcycle Dealers And Assert Result Page");
		locator = Locator.AdvancedSearch.Find_Dealers.value;
		String dealerTxt = getText(locator);
		String[] text2 = dealerTxt.split(" ");
		String Finaltext = text2[text2.length - 1];
		clickOn(locator);
		String resultPage = Locator.Dealer.Find_Motorcyle_Dealer.value;
		String resultPageTxt = getText(resultPage);
		Assert.assertTrue(resultPageTxt.contains(Finaltext));
	}

	/**
	 * Click On all Makes Links Under Find By Make Section And Assert Result Page
	 */
	public void clickOnallMakesLinksUnderFindByMakeSectionAndAssertResultPage() {
		print("Click On all Makes Links Under Find By Make Section And Assert Result Page");
		locator = Locator.AdvancedSearch.Find_Makes_Links.value;
		int links = getWebDriver().findElements(ByLocator(locator)).size();
		System.out.println(links);
		for (int i = 1; i <= links; i++) {
			String makeLinks = "(//*[@class='footerLink']/span)[1]/a[" + i + "]";
			String linkName = getText(makeLinks);
			String[] text2 = linkName.split(" ");
			String Finaltext = text2[0];
			print(Finaltext);
			clickOn(makeLinks);
			String resultPage = Locator.Search.Search_Result_Page.value;
			String expectedResult = getText(resultPage);
			Assert.assertTrue(expectedResult.contains(Finaltext));
			clickOn(Locator.Menus.BUY.value);
		}
	}

	/**
	 * Click On all Type Links Under Find By Type Section And Assert Result Page.
	 */
	public void clickOnallTypeLinksUnderFindByTypeSectionAndAssertResultPage() {
		print("Click On all Type Links Under Find By Type Section And Assert Result Page");
		locator = Locator.AdvancedSearch.Find_Types_Links.value;
		int links = getWebDriver().findElements(ByLocator(locator)).size();
		System.out.println(links);
		for (int i = 1; i <= links; i++) {
			String makeLinks = "(//*[@class='footerLink']/span)[2]/a[" + i + "]";
			String linkName = getText(makeLinks);
			String[] text2 = linkName.split(" ");
			String Finaltext = text2[0];
			print(Finaltext);
			clickOn(makeLinks);
			String resultPage = Locator.Search.Search_Result_Page.value;
			String expectedResult = getText(resultPage);
			print(expectedResult);
			Assert.assertTrue(expectedResult.contains(Finaltext));
			clickOn(Locator.Menus.BUY.value);
		}
	}

	/**
	 * Click On all State Links Under Find By State Section And Assert Result Page.
	 */
	public void clickOnallStateLinksUnderFindByStateSectionAndAssertResultPage() {
		print("Click On all State Links Under Find By State Section And Assert Result Page");
		locator = Locator.AdvancedSearch.Find_State_Links.value;
		int links = getWebDriver().findElements(ByLocator(locator)).size();
		System.out.println(links);
		for (int i = 1; i <= links; i++) {
			String makeLinks = "(//*[@class='footerLink']/span)[3]/a[" + i + "]";
			String linkName = getText(makeLinks);
			String[] text2 = linkName.split(" ");
			String Finaltext = text2[0];
			print(Finaltext);
			clickOn(makeLinks);
			String resultPage = "//*[@id='topicTitle']/em[2]";
			String expectedResult = getText(resultPage);
			print(expectedResult);
			Assert.assertTrue(expectedResult.contains(Finaltext));
			clickOn(Locator.Menus.BUY.value);
		}
	}
	
	public void assertByTypeAndByStateLinks() {
		print("Assert ByType And ByState Links");
		Assert.assertTrue(isElementPresent(Locator.AdvancedSearch.By_State.value));
		Assert.assertTrue(isElementPresent(Locator.AdvancedSearch.By_Type.value));
	}
	
	public void clickOnByStateLinkAndAssertResultPage() {
		print("Click On By State Link And Assert Result Page.");
		waitForElementPresentInDom(2);
		clickOn(Locator.AdvancedSearch.By_State.value);
		waitForElementPresentInDom(2);
		Assert.assertTrue(isElementPresent(Locator.State.State_Search_Result.value));
	}
	
	public void clickOnByTypeLinkAndAssertResultPage() {
		print("Click On By Type Link And Assert Result Page.");
		waitForElementPresentInDom(2);
		clickOn(Locator.AdvancedSearch.By_Type.value);
		waitForElementPresentInDom(2);
		Assert.assertTrue(isElementPresent(Locator.State.State_Search_Result.value));
	}
	
	public void assertAdvancedSearchButton() {
		print("Assert Advanced Search Button.");
		locator = Locator.AdvancedSearch.Advanced_Search_Button.value;
		Assert.assertTrue(isElementPresent(locator));
	}
	
	public void clickOnAdvancedSearchButtonAndAssertResultPage() {
		print("Click On Advanced Search Button And Assert Result Page");
		locator=Locator.AdvancedSearch.Advanced_Search_Button.value;
		clickOn(locator);
		waitForElementPresentInDom(4);
		String advancedSearch = Locator.Search.Advanced_Search_Page.value;
		Assert.assertTrue(isElementPresent(advancedSearch));
	}
}