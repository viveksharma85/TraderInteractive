package com.trader.scripts;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.trader.utils.DriverTestCase;

public class DealersPage extends DriverTestCase {

	/**
	 * ATD-112: 'Find Motorcycle Dealers' page should be opened when click on 'Find
	 * Motorcycle Dealers' under search tab at home page.
	 */
	@Test
	public void findMotorcycleDealersRedirectionAndAssertResultPage() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
	}

	/**
	 * ATD-113: 'Dealer Login/Signup button should be displayed at Find Motorcycle
	 * Dealers page and user redirecting to Dealer page when click on 'Dealer
	 * Login/Signup button.
	 */
	@Test
	public void dealerLoginAndSignUpButtonRedirection() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.clickOnDealerLoginSignUpButtonAndAssertResultPage();
	}

	/**
	 * ATD-114: Following fields and buttons should be displayed at Find Motorcycle
	 * Dealers page: 1. Enter a dealer name 2. All Makes drop down 3. Zip code 4.
	 * Radius 5. Search button
	 */
	@Test
	public void assertAllFieldsAtFindDealersPage() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
	}

	/**
	 * ATD-115: User should be able to find motorcycle dealer with name at Find
	 * Motorcycle Dealers page.
	 */
	@Test
	public void findDealersWithName() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.findDealerWithNameAndAssertResult();
	}

	/**
	 * ATD-116: User should be able to find motorcycle dealers with zip code/radius
	 * and makes at Find Motorcycle Dealers page.
	 */
	@Test
	public void findDealerWithMakesZipCodeAndRadius() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.enterMakesZipCodeAndRadiusAndAssertResultPage();
	}

	/**
	 * ATD-117: Find By State section with state links should be displayed below
	 * Dealer search section at Find Motorcycle Dealers page.
	 */
	@Test
	public void stateLinksUnderFindByStateSection() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindByStateSection();
	}

	/**
	 * ATD-118: All state links should be redirected to concern page when click on
	 * any link under Find By State section at Find Motorcycle Dealers page.
	 */
	@Test
	public void allStateLinksRedirection() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindByStateSection();
		dealerHelper.clickOnAllStateLinksAndAssertResultPage();
	}

	/**
	 * ATD-119: User should be redirected to Motorcycle Dealers page when click on search button at Find Motorcycle Dealers page.
	 */
	@Test
	public void searchDealersWithSearchButton() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.clickOnSearchButtonAndAssertResultPage();
	}
	
	/**
	 * ATD-120: 'New Search' button should be displayed and user redirect to 'Find Motorcycle Dealers page' when click on New Search button at Motorcycle Dealers page.
	 */
	@Test
	public void newDealerSearchButtonRedirection() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.clickOnSearchButtonAndAssertResultPage();
		dealerHelper.clickOnNewSearchButtonAndAssertResultpage();
	}
	
	/**
	 * ATD-121: Nearest and name sorting options should be displayed and sorting works correctly at Motorcycles Dealer page.
	 */
	@Test
	public void assertSortingOptions() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.clickOnSearchButtonAndAssertResultPage();
		dealerHelper.assertNearestAndNameSortingOptions();
	}
	
	/**
	 * ATD-122: All search dealers should be listed at Motorcycle Dealers page.
	 */
	@Test
	public void assertDealersResults() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.findDealerWithNameAndAssertResult();
		dealerHelper.assertSearchedDealers();
	}
	
	/**
	 * ATD-123: Call and Listing count button should be displayed on all searched dealer grid.
	 */
	@Test
	public void assertCallAndListingCountButton() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.findDealerWithNameAndAssertResult();
		dealerHelper.assertSearchedDealers();
		dealerHelper.assertCallAndSearchListingWithCountButtons();
	}
	
	/**
	 * ATD-124: Call and Listing count button should be worked correctly and redirect to concern page on all searched dealer grid.
	 */
	@Test
	public void callAndSearchListingButtonRedirection(){
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.findDealerWithNameAndAssertResult();
		dealerHelper.assertSearchedDealers();
		dealerHelper.assertCallAndSearchListingWithCountButtons();
		dealerHelper.clickOnCallAndSearchListingButtonAndAssertResultPage();
	}
	
	/**
	 * ATD-125: User should be redirected to dealer details page when click on any dealer grid at Motorcycle Dealers page.
	 */
	@Test
	public void dealerGridRedirectionAndAssertResultPage() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.findDealerWithNameAndAssertResult();
		dealerHelper.assertSearchedDealers();
		dealerHelper.clickOnDealerGridAndAssertResultPage();
	}
	
	/**
	 * ATD-126: Website, Email and Map links should be displayed below dealer image and all links redirect to concern page when click on all links at Dealer details page.
	 * 
	 * @throws AWTException
	 */
	@Test
	public void websiteEmailMapLinksRedirectionAndAssertResultPage() throws AWTException {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.findDealerWithNameAndAssertResult();
		dealerHelper.assertSearchedDealers();
		dealerHelper.clickOnDealerGridLinkAndAssertPage();
		dealerHelper.clickOnWebsiteMapAndEmailLinksAndAssertResultPage();
	}
	
	/**
	 * ATD-127: 'Save This Search' button should be displayed on listing section and user able to save search at dealer details page.
	 */
	@Test
	public void saveThisSearchButtonWorking() {
		OpenURL();
		loginHelper.clickOnLogInLink();
		String uname = loginHelper.getUserName();
		String password = loginHelper.getPassword();
		loginHelper.enterEmailID(uname);
		loginHelper.enterPassword(password);
		loginHelper.clickOnSignInButton();
		myTraderHelper.assertMyTraderPage();
		homeHelper.clickOnApplicationLogo();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.findDealerWithNameAndAssertResult();
		dealerHelper.assertSearchedDealers();
		dealerHelper.clickOnDealerGridLinkAndAssertPage();
		dealerHelper.clickOnSaveThisSearchButtonAndAssertSavedSearch();
	}
	
	/**
	 * ATD-128: 'Premium', Year', 'Price' and Newly listed sorting options should be displayed on Listing section at Dealer details page and sorting work correctly.
	 */
	@Test
	public void sortingOptionsWorking() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.findDealerWithNameAndAssertResult();
		dealerHelper.assertSearchedDealers();
		dealerHelper.clickOnDealerGridLinkAndAssertPage();
		dealerHelper.assertSortingOptions();
		dealerHelper.clickOnSortingOptionAndAssertSortingOptionWork();
	}
	
	/**
	 * ATD-165: Filter section should be displayed at dealer details page.
	 */
	@Test
	public void assertFilterSectionAtDealerResultPage() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.findDealerWithNameAndAssertResult();
		dealerHelper.assertSearchedDealers();
		dealerHelper.clickOnDealerGridLinkAndAssertPage();
		dealerHelper.assertRefineSection();
}
	
	/**
	 * ATD-166: Start over link should be displayed under filter section at dealer details page.
	 */
	@Test
	public void assertStartOverLinkAtDealerResultPage() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.findDealerWithNameAndAssertResult();
		dealerHelper.assertSearchedDealers();
		dealerHelper.clickOnDealerGridLinkAndAssertPage();
		dealerHelper.assertStartOverLink();
}
	
	/**
	 * ATD-167: Filter section should be collapsed when click on Filter link at Dealer details page. 
	 */
	@Test
	public void filterSectionCollapseOnClickAtDealerPage(){
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.findDealerWithNameAndAssertResult();
		dealerHelper.assertSearchedDealers();
		dealerHelper.clickOnDealerGridLinkAndAssertPage();
		dealerHelper.assertStartOverLink();
		dealerHelper.clickOnFilterLinkAndAssertCollapseSection();
	}
	
	/**
	 * ATD-168: User should be able to applied filter with keyword at dealer details page.
	 */
	@Test
	public void searchWithKeywordAtDealerDetailsPage() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.findDealerWithNameAndAssertResult();
		dealerHelper.assertSearchedDealers();
		dealerHelper.clickOnDealerGridLinkAndAssertPage();
		searchHelper.enterKeywordAndAssertResult();
	}
	
	@Test
	public void searchWithAllRefinedFilterAtDetailsPage() {
		OpenURL();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		dealerHelper.assertFindDealersFieldsAndButton();
		dealerHelper.findDealerWithNameAndAssertResult();
		dealerHelper.assertSearchedDealers();
		dealerHelper.clickOnDealerGridLinkAndAssertPage();
		searchHelper.clickOnAdvancedTypeOption();
		searchHelper.selectTypesFromPopUp();
		searchHelper.clickOnAdvancedMakeOption();
		searchHelper.selectMakesFromPopUp();
		searchHelper.clickOnAdvancedModelOption();
		searchHelper.selectModelFromPopUp();
		searchHelper.clickOnAdvancedTrimOption();
		searchHelper.selectTrimFromPopUp();
		searchHelper.clickOnAdvancedCategoryOption();
		searchHelper.selectCategoryFromPopUp();
	}
}
