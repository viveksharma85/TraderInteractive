package com.trader.scripts;

import org.testng.annotations.Test;

import com.trader.utils.DriverTestCase;

/**
 * @author viveks
 * 
 *         This class contains all smoke test scenarios.
 */
public class SmokeTest extends DriverTestCase {

	/**
	 * ATD-3: Log in with valid Credentials
	 * 
	 */
	@Test(priority = 1)
	public void verifyLoginToApplication() {
		print("ATD-3: Log in with valid Credentials");
		OpenURL();
		loginHelper.clickOnLogInLink();
		String uname = loginHelper.getUserName();
		String password = loginHelper.getPassword();
		loginHelper.enterEmailID(uname);
		loginHelper.enterPassword(password);
		loginHelper.clickOnSignInButton();
		myTraderHelper.assertMyTraderPage();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-5: Validation message is displayed when trying to login with invalid
	 * details.
	 *
	 */
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		print("ATD-5: Validation message is displayed when trying to login with invalid");
		OpenURL();
		loginHelper.clickOnLogInLink();
		loginHelper.enterEmailID("Testuser");
		loginHelper.enterPassword("TestPwd");
		loginHelper.clickOnSignInButton();
		loginHelper.assertValidationMessage();
	}

	/**
	 * ATD-7: Create an account with valid details.
	 *
	 */
	@Test(priority = 3)
	public void createAccount() {
		OpenURL();
		traderMenus.clickOnMoreHamburgerButton();
		traderMenus.clickOnMyTraderSignIn();
		signUpHelper.signUpToApplication();
		myTraderHelper.assertMyTraderPage();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-9: Trying to create an account with existing Email.
	 */
	@Test(priority = 4)
	public void createAccountWithExistingEmail() {
		OpenURL();
		traderMenus.clickOnMoreHamburgerButton();
		traderMenus.clickOnMyTraderSignIn();
		signUpHelper.signUpWithExistingEmail();
		signUpHelper.assertValidationForExistingEmail();
	}

	/**
	 * ATD-8: Trying to create an account with invalid Email.
	 */
	@Test(priority = 5)
	public void createAccountwithInvalidEmail() {
		OpenURL();
		traderMenus.clickOnMoreHamburgerButton();
		traderMenus.clickOnMyTraderSignIn();
		signUpHelper.signUpWithInvalidEmailID();
		signUpHelper.assertValidationForInvalidEmail();
	}

	/**
	 * ATD-10: Search is working at home page.
	 *
	 */
	@Test(priority = 6)
	public void searchFromHome() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnFindButton();
		searchHelper.assertSearchResultPage();
	}

	/**
	 * ATD-11: Advanced search page opens when click on Advanced Search link.
	 *
	 */
	@Test(priority = 7)
	public void advancedSearchLinkAtHome() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
	}

	/**
	 * ATD-62: Search with keyword, Zip code and Radius from home page.
	 *
	 */
	@Test(priority = 8)
	public void searchWithKeyWordZipCodeAndRadius() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.enterSearchDetails();
		searchHelper.clickOnFindButton();
		searchHelper.assertAdSearchResult();
	}

	/**
	 * ATD-12: Search with location from Advanced Search page.
	 *
	 */
	@Test(priority = 9)
	public void searchWithLocation() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.searchWithLocationOption();
		searchHelper.assertAdSearchResult();
	}

	/**
	 * ATD-13: Search with Keyword from advanced search page
	 *
	 */
	@Test(priority = 10)
	public void advancedSearchWithKeyword() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.clickOnAdvancedKeywordOption();
		searchHelper.enterAdvancedKeyword();
		searchHelper.clickOnAdvancedKeywordUpdateButton();
		searchHelper.clickOnSeeMatchesButton();
		searchHelper.assertAdSearchResult();
	}

	/**
	 * ATD-14: Search with Type, Make and Category option from Advanced Search page.
	 *
	 */
	@Test(priority = 11)
	public void advancedSearchWithAllRefineOptions() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.clickOnAdvancedTypeOption();
		searchHelper.selectTypesFromPopUp();
		searchHelper.clickOnAdvancedMakeOption();
		searchHelper.selectMakesFromPopUp();
		searchHelper.clickOnAdvancedCategoryOption();
		searchHelper.selectCategoryFromPopUp();
		searchHelper.clickOnSeeMatchesButton();
		searchHelper.assertAdSearchResult();
	}

	/**
	 * ATD-16: Makes and all search icons should work correctly under Popular makes.
	 * 
	 */
	@Test(priority = 12)
	public void searchWithPopularMakes() {
		OpenURL();
		homeHelper.clickOnPopularMakesTab();
		homeHelper.searchWithPopularMakesAndAssertResultPage();
		// OpenURL();
		// homeHelper.clickOnPopularMakesTab();
		// homeHelper.searchBMWMakes();
		// homeHelper.searchCanAmMakes();
		// homeHelper.searchDucatiMakes();
		// homeHelper.searchHarleyMakes();
		// homeHelper.searchHondaMakes();
		// homeHelper.searchKTMMakes();
		// homeHelper.searchKawasakiMakes();
		// homeHelper.searchSuzukiMakes();
		// homeHelper.searchTriumphMakes();
		// homeHelper.searchVictoryMakes();
		// homeHelper.searchYamahaMakes();
		// homeHelper.searchSearchAllMakes();
	}

	/**
	 * ATD-17: All Makes link should displayed when click on 'Browse All Makes' link
	 * at 'Make' page.
	 *
	 */
	@Test(priority = 13)
	public void searchWithBrowseAllMakes() {
		OpenURL();
		homeHelper.clickOnPopularMakesTab();
		homeHelper.clickOnSearchAllIcon();
		homeHelper.assertSearchAllMakesSearchResultPage();
		searchHelper.clickOnBrowseAllMakes();
		searchHelper.assertSalebyMake();
	}

	/**
	 * ATD-18: User should redirected to respective 'Make Search Result' page when
	 * click on any Make link at 'Make' page.
	 */
	@Test(priority = 14)
	public void searchWithMakesLink() {
		OpenURL();
		homeHelper.clickOnPopularMakesTab();
		homeHelper.clickOnSearchAllIcon();
		homeHelper.assertSearchAllMakesSearchResultPage();
		searchHelper.clickOnBrowseAllMakes();
		searchHelper.assertSalebyMake();
		searchHelper.clickOnBMWLink();
		homeHelper.assertBMWSearchResultPage();
		searchHelper.clickOnAllMakesBreadcrumbLink();
		searchHelper.clickOnBrowseAllMakes();
		searchHelper.clickOnYamahaLink();
		homeHelper.assertYamahaSearchResultPage();
		searchHelper.clickOnAllMakesBreadcrumbLink();
		searchHelper.clickOnBrowseAllMakes();
		searchHelper.clickOnHondaLink();
		homeHelper.assertHondaSearchResultPage();
	}

	/**
	 * ATD-19: User should redirect to respective Make Search Result page when click
	 * on any make icon at 'Make' page.
	 */
	@Test(priority = 15)
	public void searchWithMakesIcon() {
		OpenURL();
		homeHelper.clickOnPopularMakesTab();
		homeHelper.clickOnSearchAllIcon();
		homeHelper.assertSearchAllMakesSearchResultPage();
		searchHelper.clickOnBMWIcon();
		homeHelper.assertBMWSearchResultPage();
		searchHelper.clickOnAllMakesBreadcrumbLink();
		searchHelper.clickOnTriumphIcon();
		homeHelper.assertTriumphSearchResultPage();
		searchHelper.clickOnAllMakesBreadcrumbLink();
		searchHelper.clickOnYamahaIcon();
		homeHelper.assertYamahaSearchResultPage();
	}

	/**
	 * ATD-20: 'Top Motorcycle Makes' section should be displayed under 'Footer'
	 * section at Home page.
	 */
	@Test(priority = 16)
	public void assertTopMotorcycleMakes() {
		OpenURL();
		homeHelper.assertTopMakesSection();
	}

	/**
	 * ATD-21: User should be redirected to respective Make Search Result page when
	 * click on any top make link under 'Footer' section at Home page.
	 */
	@Test(priority = 17)
	public void searchWithTopMakesLinks() {
		OpenURL();
		homeHelper.assertTopMakesSection();
		homeHelper.clickOnHarleyDavidsonTopMakeLink();
		homeHelper.clickOnHondaTopMakeLink();
		homeHelper.clickOnYamahaTopMakeLink();
		homeHelper.clickOnKawasakiTopMakeLink();
		homeHelper.clickOnCanAmTopMakeLink();
		homeHelper.clickOnSuzukiTopMakeLink();
		homeHelper.clickOnBMWTopMakeLink();
		homeHelper.clickOnTriumphTopMakeLink();
		homeHelper.clickOnKTMTopMakeLink();
		homeHelper.clickOnVictoryTopMakeLink();
	}

	/**
	 * ATD-22: Top Motorcycle Make/Models' section should displayed under 'Footer'
	 * section at Home page.
	 */
	@Test(priority = 18)
	public void assertTopModel() {
		OpenURL();
		homeHelper.assertTopModelSection();
	}

	/**
	 * ATD-23: User should redirected to respective Make/Model Search Result page
	 * when click on any top make/models link under 'Footer' section at Home page.
	 *
	 */
	@Test(priority = 19)
	public void searchWithTopModellinks() {
		OpenURL();
		homeHelper.assertTopModelSection();
		homeHelper.clickOnKawasakiNinJaLink();
		homeHelper.clickOnHarleyDavidsonELECTRAGLIDELink();
		homeHelper.clickOnHondaCRFLink();
		homeHelper.clickOnHondaCBRLink();
		homeHelper.clickOnHarleyDavidsonSTREETGLIDELink();
		homeHelper.clickOnKawasakiVULCANLink();
		homeHelper.clickOnCanAmSPYDERLink();
		homeHelper.clickOnYamahaYZFLink();
		homeHelper.clickOnYamahaVSTARLink();
		homeHelper.clickOnHarleyDavidsonROADGLIDE();
	}

	/**
	 * ATD-24: User should redirect to 'Types Search Result' page when click on
	 * Search All icon under 'Popular Types' section at Home page.
	 */
	@Test(priority = 20)
	public void searchWithSearchAllUnderPopularType() {
		OpenURL();
		homeHelper.clickOnPopularTypesTab();
		homeHelper.clickOnSearchAllUnderPopularTypesTab();
		searchHelper.assertSearchResultPage();
	}

	/**
	 * ATD-25:User should be redirected to respective 'Type Search Result' page when
	 * click on any Type icon under 'Popular Types' section at Home page.
	 */
	@Test(priority = 21)
	public void searchWithPopularTypesIcon() {
		OpenURL();
		homeHelper.clickAndAssertPopularTypeLinks();
	}

	/**
	 * ATD-26: 'Top Motorcycle Types' section should be displayed under 'Footer'
	 * section at Home page.
	 */
	@Test(priority = 22)
	public void assertTopTypesSection() {
		OpenURL();
		homeHelper.assertTopTypeSection();
	}

	/**
	 * ATD-27: User should be redirected to respective Type Search Result page when
	 * click on any top type link under 'Footer' section at Home page.
	 *
	 */
	@Test(priority = 23)
	public void searchWithAllTypesLinks() {
		OpenURL();
		homeHelper.assertTopTypeSection();
		homeHelper.clickAndAssertTypesLink();
	}

	/**
	 * ATD-28: User should be redirected to States Search page when click on Search
	 * All icon under 'Popular States' section at Home page.
	 *
	 */
	@Test(priority = 24)
	public void searchWithSearchAllUnderPopularState() {
		OpenURL();
		homeHelper.clickOnPopularStateTab();
		homeHelper.clickOnSearchAllUnderState();
		homeHelper.assertStateResultPage();
	}

	/**
	 * ATD-29: User should be redirected to respective 'State Search Result' page
	 * when click on any State link at States Search page.
	 *
	 */
	@Test(priority = 25)
	public void searchWithStateUnderPopularState() {
		OpenURL();
		homeHelper.clickAndAssertPopularStateLinks();
	}

	/**
	 * ATD-30: User should be able to refine search with Location at Search Result
	 * page.
	 *
	 */
	@Test(priority = 26)
	public void refineSearchWithLocation() {
		OpenURL();
		searchHelper.clickOnFindButton();
		searchHelper.searchWithLocationFormRefineSearch();
	}

	/**
	 * ATD-31: User should be able to refine search with Keywords at Search Result
	 * page.
	 *
	 */
	@Test(priority = 27)
	public void refineSearchWithKeywords() {
		OpenURL();
		searchHelper.clickOnFindButton();
		searchHelper.clickOnAdvancedKeywordOption();
		searchHelper.enterKeywordAndSelectSuggestion();
		searchHelper.clickOnAdvancedKeywordUpdateButton();
		searchHelper.waitForUpdatingSpinner();
		searchHelper.assertAdSearchResult();
	}

	/**
	 * ATD-32: User should able to refine search with select options(Type, Make,
	 * Model, Trim, Category and other all options) at Search Result page.
	 *
	 */
	@Test(priority = 28)
	public void refineSearchWithAllRefinedOption() {
		OpenURL();
		searchHelper.clickOnFindButton();
		searchHelper.clickOnAdvancedMakeOption();
		searchHelper.selectMakesOptionAndAssertSearchResultPage();
		searchHelper.selectModelOptionAndAssertSearchResultPage();
		searchHelper.selectTrimOptionAndAssertSearchResultPage();
		searchHelper.selectCategoryOptionAndAssertSearchResultPage();
	}

	/**
	 * ATD-15: Correct page should open when click on any link under recent search.
	 *
	 */
	@Test(priority = 29)
	public void searchWithRecentSearchLink() {
		OpenURL();
		searchHelper.clickOnFindButton();
		searchHelper.clickOnAdvancedMakeOption();
		searchHelper.clickAndAssertRecentSearchLinkResult();
	}

	/**
	 * ATD-33: User should be redirected to application home page when click on Logo
	 * from any page.
	 *
	 */
	@Test(priority = 30)
	public void applicationLogoRedirectOnHomePage() {
		OpenURL();
		searchHelper.clickOnFindButton();
		searchHelper.clickOnAdvancedMakeOption();
		searchHelper.selectMakesOptionAndAssertSearchResultPage();
		homeHelper.clickOnApplicationLogo();
		searchHelper.assertSearchTab();
	}

	/**
	 * ATD-34: User should be redirected to 'Find Trader For Sale' page when click
	 * on 'Buy' link in header.
	 */
	@Test(priority = 31)
	public void buyMenuRedirectionAndAssertResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		homeHelper.clickOnBuyMenuAndAssertResultPage();
	}

	/**
	 * ATD-35: User should be redirected to correct page when click on any button at
	 * 'Find Trader For Sale' page.
	 */
	@Test(priority = 32)
	public void buttonsRedirectionFromFindTrader() {
		OpenURL();
		searchHelper.assertSearchTab();
		homeHelper.clickOnBuyMenuAndAssertResultPage();
		searchHelper.clickOnFindByButtonsAndAssertResultPage();
	}

	/**
	 * ATD-36: User should be redirected to 'All Types' category page when click on
	 * 'See Matches' button.
	 *
	 */
	@Test(priority = 33)
	public void searchWithSeeMatchesButton() {
		OpenURL();
		searchHelper.assertSearchTab();
		homeHelper.clickOnBuyMenuAndAssertResultPage();
		searchHelper.clickOnSeeMatchesButton();
		searchHelper.assertAdSearchResult();
	}

	/**
	 * ATD-37: Sell your Trader fast, free & secure' page opens when click on Sell
	 * Your Trader button.
	 */
	@Test(priority = 34)
	public void SellForFreeLink() {
		OpenURL();
		sellYourMotorcycleHelper.clickOnSellForFreeMenuAndAssertResultPage();
	}

	/**
	 * ATD-41: Research menu should be redirected to correct page.
	 */
	@Test(priority = 35)
	public void clickAndAssertResearchMenuAndPage() {
		OpenURL();
		traderMenus.clickOnResearchMenu();
		traderMenus.assertResearchPage();
	}

	/**
	 * ATD-43: User should be redirected to Race Team page when click on 'Race Team'
	 * link in header.
	 */
	@Test(priority = 36)
	public void clickAndAssertRaceTeamMenuAndPage() {
		OpenURL();
		traderMenus.clickOnRaceTeamMenu();
		traderMenus.assertRaceTeamPage();
	}

	/**
	 * ATD-44: User should be redirected to Trader News page when click on 'News'
	 * link in header.
	 */
	@Test(priority = 37)
	public void clickAndAssertNewsMenuAndPage() {
		OpenURL();
		traderMenus.clickOnNewsMenu();
		traderMenus.assertNewsPage();
	}

	/**
	 * ATD-38: User should be able to post Ad with Selecting Free Package.
	 */
	@Test(priority = 38)
	public void postAdWithSelectingFreePackage() {
		OpenURL();
		traderMenus.clickOnMoreHamburgerButton();
		traderMenus.clickOnMyTraderSignIn();
		signUpHelper.signUpToApplication();
		myTraderHelper.assertMyTraderPage();

		// loginHelper.clickOnLogInLink();
		// String uname = loginHelper.getUserName();
		// String password = loginHelper.getPassword();
		// loginHelper.enterEmailID(uname);
		// loginHelper.enterPassword(password);
		// loginHelper.clickOnSignInButton();
		// myTraderHelper.assertMyTraderPage();

		homeHelper.clickOnApplicationLogo();
		sellYourMotorcycleHelper.clickOnSellForFreeMenuAndAssertResultPage();
		sellYourMotorcycleHelper.fillListingDetailsForFreePackage();
		searchHelper.waitForUpdatingSpinner();
		sellYourMotorcycleHelper.assertListingConfirmationPage();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-45: User should be redirected to Find Trader Dealers page when click on
	 * 'Dealers' link in header.
	 */
	@Test(priority = 39)
	public void dealersMenuRedirectionAndAssertResultPage() {
		OpenURL();
		traderMenus.clickOnDealersMenu();
		dealerHelper.clickOnSearchDealerButton();
		dealerHelper.assertFindMotorcycleDealersPage();
	}

	/**
	 * ATD-46: User should be redirected to Find Trader Dealers page when click on
	 * 'Find Trader Dealers' link under Search section at Home page.
	 */
	@Test(priority = 40)
	public void findMotorcycleDealersLinkRedirection() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
	}

	/**
	 * ATD-47: All states link should be displayed under 'Find by State' section at
	 * Find Trader Dealers page.
	 */
	@Test(priority = 41)
	public void assertFindByStateSectionAtDealerPage() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindByState();
	}

	/**
	 * ATD-48: User should be redirected to Trader Dealers category page when click
	 * on 'Search' button at Find Trader Dealers page.
	 */
	@Test(priority = 42)
	public void dealerSearchAndAssertResultPage() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.clickOnSearchButtonAndAssertResultPage();
	}

	/**
	 * ATD-49: User should be redirected to respective Dealer search result page
	 * when click on any dealer link at Trader Dealers category page.
	 */
	@Test(priority = 43)
	public void dealersLinkredirectionFromDealersResultPage() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.clickOnSearchButtonAndAssertResultPage();
		dealerHelper.clickOnDealersLinksAndAssertSearchResultPage();
	}

	/**
	 * ATD-50: User should be able to save search when click on 'Save This Search'
	 * button at Search Result page.
	 */
	@Test(priority = 44)
	public void ableToSaveSearch() {
		OpenURL();
		traderMenus.clickOnMoreHamburgerButton();
		traderMenus.clickOnMyTraderSignIn();
		signUpHelper.signUpToApplication();
		myTraderHelper.assertMyTraderPage();
		// loginHelper.clickOnLogInLink();
		// String uname = loginHelper.getUserName();
		// String password = loginHelper.getPassword();
		// loginHelper.enterEmailID(uname);
		// loginHelper.enterPassword(password);
		// loginHelper.clickOnSignInButton();
		// myTraderHelper.assertMyTraderPage();
		homeHelper.clickOnApplicationLogo();
		// searchHelper.assertSearchTab();
		searchHelper.enterSearchDetails();
		searchHelper.clickOnFindButton();
		searchHelper.assertAdSearchResult();
		searchHelper.clickOnSaveThisSearchAndAssertSavedSearch();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-53: User should be able to save listing when click on 'Save This Listing'
	 * link/Save button at Ad/Listing detail page.
	 */
	@Test(priority = 45)
	public void ableToSaveListing() {
		OpenURL();
		traderMenus.clickOnMoreHamburgerButton();
		traderMenus.clickOnMyTraderSignIn();
		signUpHelper.signUpToApplication();
		myTraderHelper.assertMyTraderPage();
		// loginHelper.clickOnLogInLink();
		// String uname = loginHelper.getUserName();
		// String password = loginHelper.getPassword();
		// loginHelper.enterEmailID(uname);
		// loginHelper.enterPassword(password);
		// loginHelper.clickOnSignInButton();
		// myTraderHelper.assertMyTraderPage();
		homeHelper.clickOnApplicationLogo();
		// searchHelper.assertSearchTab();
		searchHelper.enterSearchDetails();
		searchHelper.clickOnFindButton();
		searchHelper.assertAdSearchResult();
		searchHelper.clickOnSaveIconAndAssertsavedListing();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-51: User should be able to save listing when click on 'Save Listing' link
	 * under any listing at Search Result page.
	 */
	@Test(priority = 46)
	public void ableToSaveListingFromSearchResultPage() {
		OpenURL();
		traderMenus.clickOnMoreHamburgerButton();
		traderMenus.clickOnMyTraderSignIn();
		signUpHelper.signUpToApplication();
		myTraderHelper.assertMyTraderPage();
		// loginHelper.clickOnLogInLink();
		// String uname = loginHelper.getUserName();
		// String password = loginHelper.getPassword();
		// loginHelper.enterEmailID(uname);
		// loginHelper.enterPassword(password);
		// loginHelper.clickOnSignInButton();
		// myTraderHelper.assertMyTraderPage();
		homeHelper.clickOnApplicationLogo();
		searchHelper.assertSearchTab();
		searchHelper.enterSearchDetails();
		searchHelper.clickOnFindButton();
		searchHelper.assertAdSearchResult();
		searchHelper.clickOnSaveListingLinkAndAssertSavedListing();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-52: AD details page should be opened when click on any AD image.
	 */
	@Test(priority = 47)
	public void ADImageRedirectOnDetailsPage() {
		OpenURL();
		loginHelper.clickOnLogInLink();
		String uname = loginHelper.getUserName();
		String password = loginHelper.getPassword();
		loginHelper.enterEmailID(uname);
		loginHelper.enterPassword(password);
		loginHelper.clickOnSignInButton();
		myTraderHelper.assertMyTraderPage();
		homeHelper.clickOnApplicationLogo();
		searchHelper.assertSearchTab();
		searchHelper.enterSearchDetails();
		searchHelper.clickOnFindButton();
		searchHelper.assertAdSearchResult();
		searchHelper.clickOnAdAndAssertAdDetailsPage();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-54: User should be redirected to 'Contact Seller' section when click on
	 * 'Email Only' button at Ad/Listing detail page.
	 */
	@Test(priority = 48)
	public void EmailOnlyRedirectOnContactSellerSection() {
		OpenURL();
		loginHelper.clickOnLogInLink();
		String uname = loginHelper.getUserName();
		String password = loginHelper.getPassword();
		loginHelper.enterEmailID(uname);
		loginHelper.enterPassword(password);
		loginHelper.clickOnSignInButton();
		myTraderHelper.assertMyTraderPage();
		homeHelper.clickOnApplicationLogo();
		searchHelper.assertSearchTab();
		searchHelper.enterSearchDetails();
		searchHelper.clickOnFindButton();
		searchHelper.assertAdSearchResult();
		searchHelper.clickOnAdAndAssertAdDetailsPage();
		searchHelper.clickOnEmailOnlyAndAssertContactsellerSection();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-39: User should be able to post Ad with Selecting Enhanced Package.
	 */
	@Test(priority = 49)
	public void postAnListingADWithEnhancedPackageSelected() {
		OpenURL();
		traderMenus.clickOnMoreHamburgerButton();
		traderMenus.clickOnMyTraderSignIn();
		signUpHelper.signUpToApplication();
		myTraderHelper.assertMyTraderPage();

		// loginHelper.clickOnLogInLink();
		// String uname = loginHelper.getUserName();
		// String password = loginHelper.getPassword();
		// loginHelper.enterEmailID(uname);
		// loginHelper.enterPassword(password);
		// loginHelper.clickOnSignInButton();
		// myTraderHelper.assertMyTraderPage();
		homeHelper.clickOnApplicationLogo();
		sellYourMotorcycleHelper.clickOnSellForFreeMenuAndAssertResultPage();
		sellYourMotorcycleHelper.fillListingDetailsForEnhancedPackage();
		searchHelper.waitForUpdatingSpinner();
		sellYourMotorcycleHelper.assertListingConfirmationPage();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-40: User should be able to post Ad with Selecting Best Package.
	 */
	@Test(priority = 50)
	public void postAnListingADWithBestPackageSelected() {
		OpenURL();
		traderMenus.clickOnMoreHamburgerButton();
		traderMenus.clickOnMyTraderSignIn();
		signUpHelper.signUpToApplication();
		myTraderHelper.assertMyTraderPage();
		// loginHelper.clickOnLogInLink();
		// String uname = loginHelper.getUserName();
		// String password = loginHelper.getPassword();
		// loginHelper.enterEmailID(uname);
		// loginHelper.enterPassword(password);
		// loginHelper.clickOnSignInButton();
		// myTraderHelper.assertMyTraderPage();
		homeHelper.clickOnApplicationLogo();
		sellYourMotorcycleHelper.clickOnSellForFreeMenuAndAssertResultPage();
		sellYourMotorcycleHelper.fillListingDetailsForBestPackage();
		searchHelper.waitForUpdatingSpinner();
		sellYourMotorcycleHelper.assertListingConfirmationPage();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/*
	 * @Test public void contactSellerEmail() { OpenURL();
	 * searchHelper.enterSearchDetails(); searchHelper.clickOnFindButton();
	 * searchHelper.assertAdSearchResult();
	 * searchHelper.clickOnAdAndAssertAdDetailsPage();
	 * searchHelper.clickOnEmailOnlyAndAssertContactsellerSection();
	 * searchHelper.enterSellerDetailsAndClickOnContactButton(); }
	 */

	/**
	 * ATD-58: All Saved Listings should be displayed under Saved Listings tab.
	 */
	@Test(priority = 51)
	public void savedListingShownUnderSavedListingPage() {
		OpenURL();
		traderMenus.clickOnMoreHamburgerButton();
		traderMenus.clickOnMyTraderSignIn();
		signUpHelper.signUpToApplication();
		myTraderHelper.assertMyTraderPage();
		homeHelper.clickOnApplicationLogo();
		searchHelper.assertSearchTab();
		searchHelper.enterSearchDetails();
		searchHelper.clickOnFindButton();
		searchHelper.assertAdSearchResult();
		searchHelper.clickOnSaveListingLinkAndAssertSavedListing();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-59: All Saved Searches should be displayed under Saved Searches tab.
	 */
	@Test(priority = 52)
	public void savedSearchShownUnderSavedSearchesPage() {
		OpenURL();
		traderMenus.clickOnMoreHamburgerButton();
		traderMenus.clickOnMyTraderSignIn();
		signUpHelper.signUpToApplication();
		myTraderHelper.assertMyTraderPage();
		homeHelper.clickOnApplicationLogo();
		// searchHelper.assertSearchTab();
		searchHelper.enterSearchDetails();
		searchHelper.clickOnFindButton();
		searchHelper.assertAdSearchResult();
		searchHelper.clickOnSaveThisSearchAndAssertSavedSearch();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-57: All Listings, saved search should be displayed under My Listings page
	 * and user is able to edit listing.
	 */
	@Test(priority = 53)
	public void allSavedListingAndSearchesOnMyTraderPage() {
		OpenURL();
		traderMenus.clickOnMoreHamburgerButton();
		traderMenus.clickOnMyTraderSignIn();
		signUpHelper.signUpToApplication();
		myTraderHelper.assertMyTraderPage();
		homeHelper.clickOnApplicationLogo();
		searchHelper.saveListing();
		homeHelper.clickOnApplicationLogo();
		searchHelper.saveSearch();
		myTraderHelper.clickOnMyTraderHomeIcon();
		myTraderHelper.assertSavedListingAndSavedSearchesSection();
		myTraderHelper.clickOnEditButtonOnSavedListings();
		myTraderHelper.clickOnMyTraderHomeIcon();
		myTraderHelper.clickOnEditButtonOnSavedSearches();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-56: User should be able to calculate estimate Payment.
	 */
	@Test(priority = 54)
	public void calculateEstimatePayment() {
		OpenURL();
		searchHelper.clickOnFindButton();
		searchHelper.clickOnListingWithPriceAndEstimatePaymentIcon();
		searchHelper.estimatePaymentWindow();
	}

	/**
	 * ATD-60: User should be redirected to Sell page when click on 'Sell A
	 * Motorcycle' link.
	 */
	@Test(priority = 55)
	public void sellAMotorcycleLinkWorking() {
		OpenURL();
		loginHelper.clickOnLogInLink();
		String uname = loginHelper.getUserName();
		String password = loginHelper.getPassword();
		loginHelper.enterEmailID(uname);
		loginHelper.enterPassword(password);
		loginHelper.clickOnSignInButton();
		myTraderHelper.assertMyTraderPage();
		myTraderHelper.clickOnSellAMotorcycleLink();
		sellYourMotorcycleHelper.assertSellAMotorcyclePage();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-61: User should be able to edit/save details at Account
	 * Setting/Information page.
	 */
	@Test(priority = 56)
	public void updateAccountSetting() {
		OpenURL();
		loginHelper.clickOnLogInLink();
		String uname = loginHelper.getUserName();
		String password = loginHelper.getPassword();
		loginHelper.enterEmailID(uname);
		loginHelper.enterPassword(password);
		loginHelper.clickOnSignInButton();
		myTraderHelper.assertMyTraderPage();
		myTraderHelper.clickOnAccountSettingLink();
		myTraderHelper.updateFirstNameAndlastName();
		myTraderHelper.clickOnSaveChangesButton();
		myTraderHelper.assertUpdateChangesMessage();
		traderMenus.signOutMyTrader();
		traderMenus.assertPageAfterSignout();
	}

	/**
	 * ATD-42: User should be redirected to link/button related page when click on
	 * 'Learn More/Sign Up' Button under any section 'Research Trader - Trader
	 * Resources' page.
	 */
	@Test(priority = 57)
	public void assertLearnMoreButtonPages() {
		OpenURL();
		traderMenus.clickOnResearchMenu();
		traderMenus.assertResearchPage();
		traderMenus.clickOnLearnMoreButtonAtResearchPage();
	}
}
