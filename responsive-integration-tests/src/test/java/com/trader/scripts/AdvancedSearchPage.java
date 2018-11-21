package com.trader.scripts;

import org.testng.annotations.Test;

import com.trader.utils.DriverTestCase;

public class AdvancedSearchPage extends DriverTestCase {

	/**
	 * ATD-129: Following buttons should be displayed at Find Motorcycles For Sale
	 * page. 1. Find By Make 2. Find By Type 3. Find By State
	 */
	@Test
	public void assertFindByMakeTypeAndStateButton() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.assertFindByMakeStateAndTypeButtonAtAdvancedSearchPage();
	}

	/**
	 * ATD-130: Motorcycles For Sale by Make page should be displaying when click on
	 * 'Find By Make' button at Advanced Search page.
	 */
	@Test
	public void findByMakeButtonRedirectionAndAssertResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.clickOnFindByMakeButtonAndAssertResultPage();
	}

	/**
	 * ATD-131: Motorcycles For Sale by Type should be displaying when click on
	 * 'Find By Type' button at Advanced Search page.
	 */
	@Test
	public void findByTypeButtonRedirectionAndAssertResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.clickOnFindByTypeButtonAndAssertResultPage();
	}

	/**
	 * ATD-132: Motorcycles For Sale by State should be displaying when click on
	 * 'Find By State' button at Advanced Search page.
	 */
	@Test
	public void findByStateButtonRedirectionAndAssertResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.clickOnFindByStateButtonAndAssertResultPage();
	}

	/**
	 * ATD-133: Following options and button are displayed under Advanced Search section: 1. Location 2. Keyword 3. Type 4. Make 5. Model 6. Trim 7. Category 8. Price 9. New or Used 10. Year 11. Seller Type 12. Mileage 13. Engine Size 14. State 15. City
	 */
	@Test
	public void followingRefinedOptionsUnderAdvancedSearchPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.assertRefinedOptionsUnderAdvancedSearch();

	}

	/**
	 * ATD-134: Location option should be clickable under Advanced Search section.
	 */
	@Test
	public void locationOptionClickableUnderAdvancedSearchPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.clickOnLocationAndAssertLocationsOptions();
	}

	/**
	 * ATD-135: User should be able to find search with Zip code and selected radius
	 * from Location option under Advanced Search section.
	 */
	@Test
	public void searchWithLocationAndAssertLocationDetails() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.searchWithLocationFormRefineSearch();
	}

	/**
	 * ATD-136: Auto suggestion list should be displayed when enter any text in
	 * Enter keywords field under Keyword option and user able to select any auto
	 * suggestion from list.
	 */
	@Test
	public void autoSuggestionDropDownForKeywordOption() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.assertAutoSuggestionDropDown();
	}

	/**
	 * ATD-137: Type pop up should be displaying when click on Type option and user
	 * able to select any option and click on Search button.
	 */
	@Test
	public void selectTypesOptionsAndAssertListingCountAtResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.clickOnAdvancedTypeOption();
		searchHelper.selectTypesFromPopUp();
		searchHelper.clickOnSeeMatchesButtonAndAssertListingCounts();
	}

	/**
	 * ATD-138: Make pop up should be displayed when click on Make option and user
	 * able to select any options, click update and click on Search button.
	 */
	@Test
	public void selectMakeOptionsAndAssertListingCountAtResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.clickOnAdvancedTypeOption();
		searchHelper.selectTypesFromPopUp();
		searchHelper.clickOnAdvancedMakeOption();
		searchHelper.selectMakesFromPopUp();
		searchHelper.clickOnSeeMatchesButtonAndAssertListingCounts();
	}

	/**
	 * ATD-139: Model pop up should be displayed when click on Model option after
	 * selecting Make and user able to select any model options, click update and
	 * click on Search button.
	 */
	@Test
	public void selectModelOptionsAndAssertListingCountAtResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.clickOnAdvancedTypeOption();
		searchHelper.selectTypesFromPopUp();
		searchHelper.clickOnAdvancedMakeOption();
		searchHelper.selectMakesFromPopUp();
		searchHelper.clickOnAdvancedModelOption();
		searchHelper.selectModelFromPopUp();
		searchHelper.clickOnSeeMatchesButtonAndAssertListingCounts();
	}

	/**
	 * ATD-140: Trim pop up should be displayed when click on Trim option after selecting Make/Model and user able to select any trim options, click update and click on Search button.
	 */
	@Test
	public void selectTrimOptionsAndAssertListingCountAtResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.clickOnAdvancedTypeOption();
		searchHelper.selectTypesFromPopUp();
		searchHelper.clickOnAdvancedMakeOption();
		searchHelper.selectMakesFromPopUp();
		searchHelper.clickOnAdvancedModelOption();
		searchHelper.selectModelFromPopUp();
		searchHelper.clickOnAdvancedTrimOption();
		searchHelper.selectTrimFromPopUp();
		searchHelper.clickOnSeeMatchesButtonAndAssertListingCounts();
	}

	/**
	 * ATD-141: Category pop up should be displayed when click on Category option and user able to select any option and click on Search button. 
	 */
	@Test
	public void selectCategoryOptionsAndAssertListingCountAtResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
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
		searchHelper.clickOnSeeMatchesButtonAndAssertListingCounts();
	}
	
	/**
	 * ATD-142: Price pop up should be displayed when click on Price option and user able to select any price option and click on Search button.
	 */
	@Test
	public void selectPriceOptionsAndAssertListingCountAtResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
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
		searchHelper.clickOnAdvancedPriceOption();
		searchHelper.selectMinAndMaxPriceFromPopUp();
		searchHelper.clickOnSeeMatchesButtonAndAssertListingCounts();
	}
	
	/**
	 * ATD-143: New and Used two options should be displayed when click on 'New or Used' option and user able to any one option and click on Search button.
	 */
	@Test
	public void selectNewAndUsedOptionsAndAssertListingCountAtResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
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
		searchHelper.clickOnAdvancedPriceOption();
		searchHelper.selectMinAndMaxPriceFromPopUp();
		searchHelper.clickOnAdvancedNewAndUsedOption();
		searchHelper.clickOnSeeMatchesButtonAndAssertListingCounts();
	}
	
	/**
	 * ATD-144: Year pop up should be displayed when click on 'Year' option and user able to any one option and click on Search button.
	 */
	@Test
	public void selectYearOptionsAndAssertListingCountAtResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
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
		searchHelper.clickOnAdvancedPriceOption();
		searchHelper.selectMinAndMaxPriceFromPopUp();
		searchHelper.clickOnAdvancedNewAndUsedOption();
		searchHelper.clickOnAdvancedYearOption();
		searchHelper.selectMinAndMaxYearFromYearPopUp();
		searchHelper.clickOnSeeMatchesButtonAndAssertListingCounts();
	}
	
	/**
	 * ATD-145: Dealer and Private Seller two options should be displayed when click on 'Seller Type' option and user able to any one option and click on Search button.
	 */
	@Test
	public void selectSellerTypeOptionsAndAssertListingCountAtResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
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
		searchHelper.clickOnAdvancedPriceOption();
		searchHelper.selectMinAndMaxPriceFromPopUp();
		searchHelper.clickOnAdvancedNewAndUsedOption();
		searchHelper.clickOnAdvancedYearOption();
		searchHelper.selectMinAndMaxYearFromYearPopUp();
		searchHelper.clickOnSellerTypeAndSelectType();
		searchHelper.clickOnSeeMatchesButtonAndAssertListingCounts();
	}
	
	/**
	 * ATD-146: Mileage pop up should be displayed when click on 'Mileage' option and user able to any one option and click on Search button.
	 */
	@Test
	public void selectMileageOptionsAndAssertListingCountAtResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
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
		searchHelper.clickOnAdvancedPriceOption();
		searchHelper.selectMinAndMaxPriceFromPopUp();
		searchHelper.clickOnAdvancedNewAndUsedOption();
		searchHelper.clickOnAdvancedYearOption();
		searchHelper.selectMinAndMaxYearFromYearPopUp();
		searchHelper.clickOnSellerTypeAndSelectType();
		searchHelper.clickOnMileageOption();
		searchHelper.selectMinAndMaxMileage();
		searchHelper.clickOnSeeMatchesButtonAndAssertListingCounts();
	}
	
	/**
	 * ATD-147: Engine Size pop up should be displayed when click on 'Engine Size' option and user able to any one option and click on Search button.
	 */
	@Test
	public void selectEngineSizeAndAssertListingCountAtResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
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
		searchHelper.clickOnAdvancedPriceOption();
		searchHelper.selectMinAndMaxPriceFromPopUp();
		searchHelper.clickOnAdvancedNewAndUsedOption();
		searchHelper.clickOnAdvancedYearOption();
		searchHelper.selectMinAndMaxYearFromYearPopUp();
		searchHelper.clickOnSellerTypeAndSelectType();
		searchHelper.clickOnMileageOption();
		searchHelper.selectMinAndMaxMileage();
		searchHelper.clickOnEngineSizeOption();
		searchHelper.selectMinAndMaxEngineSize();
		searchHelper.clickOnSeeMatchesButtonAndAssertListingCounts();
	}
	
	/**
	 * ATD-148: State pop up should be displayed when click on 'State' option and user able to any one option and click on Search button.
	 */
	@Test
	public void selectStateAndAssertListingCountAtResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
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
		searchHelper.clickOnAdvancedPriceOption();
		searchHelper.selectMinAndMaxPriceFromPopUp();
		searchHelper.clickOnAdvancedNewAndUsedOption();
		searchHelper.clickOnAdvancedYearOption();
		searchHelper.selectMinAndMaxYearFromYearPopUp();
		searchHelper.clickOnSellerTypeAndSelectType();
		searchHelper.clickOnMileageOption();
		searchHelper.selectMinAndMaxMileage();
		searchHelper.clickOnEngineSizeOption();
		searchHelper.selectMinAndMaxEngineSize();
		searchHelper.clickOnStateOptionAndSelectState();
		searchHelper.clickOnSeeMatchesButtonAndAssertListingCounts();
	}
	
	/**
	 * ATD-149: City pop up should be displayed when click on 'City' option and user able to any one option and click on Search button.
	 */
	@Test
	public void selectCityAndAssertListingCountAtResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
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
		searchHelper.clickOnAdvancedPriceOption();
		searchHelper.selectMinAndMaxPriceFromPopUp();
		searchHelper.clickOnAdvancedNewAndUsedOption();
		searchHelper.clickOnAdvancedYearOption();
		searchHelper.selectMinAndMaxYearFromYearPopUp();
		searchHelper.clickOnSellerTypeAndSelectType();
		searchHelper.clickOnMileageOption();
		searchHelper.selectMinAndMaxMileage();
		searchHelper.clickOnEngineSizeOption();
		searchHelper.selectMinAndMaxEngineSize();
		searchHelper.clickOnStateOptionAndSelectState();
		searchHelper.clickOnCityOptionAndSelectCity();
		searchHelper.clickOnSeeMatchesButtonAndAssertListingCounts();
	}
	
	/**
	 * ATD-150: Applied filter should be removed when click on 'Start Over' link/icon at Advanced Search page.
	 */
	@Test
	public void startOverLinkWorkingAndRemoveAppledFilter() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
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
		searchHelper.clickOnAdvancedPriceOption();
		searchHelper.selectMinAndMaxPriceFromPopUp();
		searchHelper.clickOnAdvancedNewAndUsedOption();
		searchHelper.clickOnAdvancedYearOption();
		searchHelper.selectMinAndMaxYearFromYearPopUp();
		searchHelper.clickOnSellerTypeAndSelectType();
		searchHelper.clickOnMileageOption();
		searchHelper.selectMinAndMaxMileage();
		searchHelper.clickOnEngineSizeOption();
		searchHelper.selectMinAndMaxEngineSize();
		searchHelper.clickOnStateOptionAndSelectState();
		searchHelper.clickOnCityOptionAndSelectCity();
		searchHelper.clickOnStartOverLinkAndAssertFilterReset();
	}
	
	/**
	 * ATD-152: Following section should be displayed below Advanced Search at Find Motorcycles For Sale page. 1. Find by Make 2. Find by Type 3. Find by State 4. Find Motorcycle Dealers
	 */
	@Test
	public void followingFindByLinksUnderAdvancedSearchSection() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.assertFindByLinksUnderAdvancedSearch();
	}
	
	/**
	 * ATD-153: Motorcycles For Sale by Make page should be displayed when click on 'Find By Make' link below  Advanced Search at Advanced Search page.
	 */
	@Test
	public void findByMakeLinkWorkingAndAssertResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.assertFindByLinksUnderAdvancedSearch();
		searchHelper.clickOnFindByMakeAndAssertResultPage();
	}
	
	/**
	 * ATD-154: Related Make Search Result page should be displayed when click on any Make link below  Advanced Search at Find Motorcycles For Sale page.
	 */
	@Test
	public void allMakesLinksWorkingUnderFindByMakeSection() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.assertFindByLinksUnderAdvancedSearch();
		searchHelper.clickOnallMakesLinksUnderFindByMakeSectionAndAssertResultPage();
	}
	
	/**
	 * ATD-155: Motorcycles For Sale by Type should be displayed when click on 'Find By Type' link at Advanced Search page.
	 */
	@Test
	public void findByTypeLinkWorkingAndAssertResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.assertFindByLinksUnderAdvancedSearch();
		searchHelper.clickOnFindByTypeAndAssertResultPage();
	}
	
	/**
	 * ATD-156: Related Type Search Result page is displaying when click on any Type link below  Advanced Search at Find Motorcycles For Sale page.
	 */
	@Test
	public void allTypeLinksWorkingUnderFindByTypeSection() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.assertFindByLinksUnderAdvancedSearch();
		searchHelper.clickOnallTypeLinksUnderFindByTypeSectionAndAssertResultPage();
	}
	
	/**
	 * ATD-157: Motorcycles For Sale by State should be displayed when click on 'Find By State' button at Advanced Search page.
	 */
	@Test
	public void findByStateLinkWorkingAndAssertResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.assertFindByLinksUnderAdvancedSearch();
		searchHelper.clickOnFindByStateAndAssertResultPage();
	}
	
	/**
	 * ATD-158: Related State Search Result page should be displayed when click on any State link below  Advanced Search at Find Motorcycles For Sale page.
	 */
	@Test
	public void allStateLinksWorkingUnderFindByStateSection() {
		OpenURL();
		searchHelper.assertSearchTab();
		searchHelper.clickOnAdvancedSearchLink();
		searchHelper.assertAdvancedSearchPage();
		searchHelper.assertFindByLinksUnderAdvancedSearch();
		searchHelper.clickOnallStateLinksUnderFindByStateSectionAndAssertResultPage();
	}
	
	/**
	 * ATD-159: Find Motorcycle Dealers page should be displayed when click on Find Motorcycle Dealers link below  Advanced Search at Find Motorcycles For Sale page.
	 */
	@Test
	public void findCycleTraderDealerLinkWorkingAndAssertResultPage() {
		OpenURL();
		searchHelper.assertSearchTab();
		dealerHelper.clickOnFindMotorcycleDealersLink();
		dealerHelper.assertFindMotorcycleDealersPage();
		}
	
	/**
	 * ATD-160: By State and by Type link should be under Header section displaying at Motorcycles For Sale by Make page.
	 */
	@Test
	public void assertByTypeAndByStateLinksAtSaleByMakePage() {
		OpenURL();
		homeHelper.clickOnPopularMakesTab();
		homeHelper.clickOnSearchAllIcon();
		homeHelper.assertSearchAllMakesSearchResultPage();
		searchHelper.assertByTypeAndByStateLinks();
	}
	
	/**
	 * ATD-161: Motorcycles For Sale by State page should be displayed when click on by State link at Motorcycles For Sale by Make page.
	 */
	@Test
	public void byStateLinkWorkingAndAssertResultPage() {
		OpenURL();
		homeHelper.clickOnPopularMakesTab();
		homeHelper.clickOnSearchAllIcon();
		homeHelper.assertSearchAllMakesSearchResultPage();
		searchHelper.assertByTypeAndByStateLinks();
		searchHelper.clickOnByStateLinkAndAssertResultPage();
	}
	
	/**
	 * ATD-162: Motorcycles For Sale by Type page should be displayed when click on by Type link at Motorcycles For Sale by Make page.
	 */
	@Test
	public void byTypeLinkWorkingAndAssertResultPage() {
		OpenURL();
		homeHelper.clickOnPopularMakesTab();
		homeHelper.clickOnSearchAllIcon();
		homeHelper.assertSearchAllMakesSearchResultPage();
		searchHelper.assertByTypeAndByStateLinks();
		searchHelper.clickOnByTypeLinkAndAssertResultPage();
		}
	
	/**
	 * ATD-163: Advanced Search button should be displayed on top right at Motorcycles For Sale by Make page.
	 */
	@Test
	public void assertAdvancedSearchButtonAtSaleByMakePage() {
		OpenURL();
		homeHelper.clickOnPopularMakesTab();
		homeHelper.clickOnSearchAllIcon();
		homeHelper.assertSearchAllMakesSearchResultPage();
		searchHelper.assertAdvancedSearchButton();
	}
	
	/**
	 * ATD-164: Find Motorcycles For Sale page should be displayed when click on Advanced Search button at Motorcycles For Sale by Make page.
	 */
	@Test
	public void advancedSearchButtonRedirectionAndAssertResultPage() {
		OpenURL();
		homeHelper.clickOnPopularMakesTab();
		homeHelper.clickOnSearchAllIcon();
		homeHelper.assertSearchAllMakesSearchResultPage();
		searchHelper.assertAdvancedSearchButton();
		searchHelper.clickOnAdvancedSearchButtonAndAssertResultPage();
	}
}
