package com.trader.pagehelper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.trader.locators.Locator;
import com.trader.stringdata.Strings;
import com.trader.utils.DriverHelper;

public class DealerHelper extends DriverHelper {
	protected WebDriver driver;

	public DealerHelper(WebDriver driver) {
		super(driver, getSoftAssert());
	}

	/**
	 * Assert Find Motorcycle Dealer Page.
	 */
	public void assertFindMotorcycleDealersPage() {
		print("Assert Find Motorcycle Dealers page.");
		waitForElementPresentInDom(2);
		locator = Locator.Dealer.Find_Motorcyle_Dealer.value;
		WaitForElementVisible(locator, 20);
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Find_Motorcycle_Dealers.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * This method is to click on Search Dealer button.
	 */
	public void clickOnSearchDealerButton() {
		print("Click On Search Dealer Button");
		waitForElementPresentInDom(2);
		locator = Locator.Dealer.Search_Dealer_Button.value;
		clickOn(locator);
	}

	/**
	 * Click on Find Motorcycle Dealers link at Home page.
	 */
	public void clickOnFindMotorcycleDealersLink() {
		print("Click on Find Motorcycle Dealers link at Home page");
		locator = Locator.Home.Find_Motorcycle_Dealers.value;
		waitForElementPresentInDom(2);
		clickOn(locator);
	}

	/**
	 * Assert Find By State section on Find By Dealer Page.
	 */
	public void assertFindByState() {
		print("Assert Find By State Section");
		locator = Locator.Dealer.Find_By_State.value;
		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * Click on Search button at Find Motorcycle Dealers page and assert result
	 * page.
	 */
	public void clickOnSearchButtonAndAssertResultPage() {
		print("Click on Search button at Find Motorcycle Dealers page and assert result page.");
		waitForElementPresentInDom(3);
		clickOn(Locator.Dealer.Search_Button.value);
		waitForElementPresentInDom(3);
		locator = Locator.Dealer.Dealer_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Dealer_Result_Page.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Click On Dealers Links And Assert SearchResult Page.
	 */
	public void clickOnDealersLinksAndAssertSearchResultPage() {
		print("Click On Dealers Links And Assert SearchResult Page");
		waitForElementPresentInDom(3);
		int length = getWebDriver().findElements(By.xpath("//*[@class='dealerPage']//li")).size();
		System.out.println("read loactor");

		System.out.println(length);
		for (int i = 1; i <= length; i++) {
			System.out.println(i);
			locator = "//*[@class='dealerPage']//li[" + i + "]//div/h2";
			clickOn(locator);
			waitForElementPresentInDom(2);
			clickOn(Locator.Home.Application_Logo.value);
			this.clickOnFindMotorcycleDealersLink();
			this.assertFindMotorcycleDealersPage();
			this.clickOnSearchButtonAndAssertResultPage();

		}
	}

	/**
	 * Click On Dealer Login SignUp Button And Assert Result Page
	 */
	public void clickOnDealerLoginSignUpButtonAndAssertResultPage() {
		print("Click On Dealer Login SignUp Button And Assert Result Page");
		clickOn(Locator.Dealer.Dealer_Login_SignUp.value);
		waitForElementPresentInDom(5);
		locator = Locator.Home.Dealer_Centre.value;
		System.out.println(getText(locator));
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Dealer_Centre.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Assert Find Dealers Fields And Button
	 */
	public void assertFindDealersFieldsAndButton() {
		print("Assert Find Dealers Fields And Button");
		Assert.assertTrue(isElementDisplayed(Locator.Dealer.Dealer_Name.value));
		Assert.assertTrue(isElementDisplayed(Locator.Dealer.All_Makes.value));
		Assert.assertTrue(isElementDisplayed(Locator.Dealer.Radius.value));
		Assert.assertTrue(isElementDisplayed(Locator.Dealer.Zip_Code.value));
		Assert.assertTrue(isElementDisplayed(Locator.Dealer.Search_Button.value));
	}

	/**
	 * Find Dealer with name and Assert Results
	 */
	public void findDealerWithNameAndAssertResult() {
		print("Find Dealer with name and Assert Results");
		String dealerName = propertyReader.readApplicationFile("DealerName");
		locator = Locator.Dealer.Dealer_Name.value;
		sendKeys(locator, dealerName);
		clickOn(Locator.Dealer.Search_Button.value);
		String listingName = getText(Locator.Dealer.Listing_Name.value);
		System.out.println(listingName);
		Assert.assertTrue(listingName.contains(dealerName));
	}

	/**
	 * Enter Makes, Zip Code, Radius And Assert Result Page
	 */
	public void enterMakesZipCodeAndRadiusAndAssertResultPage() {
		print("Enter Makes, Zip Code, Radius And Assert Result Page");
		String makes = propertyReader.readApplicationFile("DealerMakes");
		selectDropDownByVisibleText(Locator.Dealer.All_Makes.value, makes);
		String radius = propertyReader.readApplicationFile("DealerRadius");
		selectDropDownByVisibleText(Locator.Dealer.Radius.value, radius);
		String zipCode = propertyReader.readApplicationFile("DealerZipCode");
		sendKeys(Locator.Dealer.Zip_Code.value, zipCode);
		clickOn(Locator.Dealer.Search_Button.value);
		locator = Locator.Dealer.Dealer_Result.value;
		String dealerResultPage = getText(locator);
		System.out.println(dealerResultPage);
		Assert.assertTrue(dealerResultPage.contains(makes));
		waitForElementPresentInDom(2);
	}

	/**
	 * Assert find By State section.
	 */
	public void assertFindByStateSection() {
		print("Assert find By State section.");
		locator = Locator.Dealer.Find_By_State.value;
		Assert.assertTrue(isTextPresent(locator, Strings.SectionHeading.Find_By_State.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Click On All State Links And Assert Result Page.
	 */
	public void clickOnAllStateLinksAndAssertResultPage() {
		print("Click On All State Links And Assert Result Page");
		int stateSections = getWebDriver().findElements(By.xpath("//*[@class='state-search clearfix']/ul")).size();
		System.out.println(stateSections);
		for (int i = 1; i <= stateSections; i++) {
			int stateLinks = getWebDriver()
					.findElements(By.xpath("//*[@class='state-search clearfix']/ul[" + i + "]/li")).size();
			for (int j = 1; j <= stateLinks; j++) {
				locator = "//*[@class='state-search clearfix']/ul[" + i + "]/li[" + j + "]/a";
				String text = getText(locator);
				String[] text2 = text.split("\\s+");
				String Finaltext = text2[0].toLowerCase();
				System.out.println(Finaltext);
				clickOn(locator);
				String statePageTitle = getText(Locator.Dealer.Dealer_Result.value).toLowerCase();
				Assert.assertTrue(statePageTitle.contains(Finaltext));
				clickOn(Locator.Dealer.New_Search.value);
			}
		}
	}

	/**
	 * Click on New Search button at Dealer result page.
	 */
	public void clickOnNewSearchButtonAndAssertResultpage() {
		print("Click on New Search button at Dealer result page.");
		locator = Locator.Dealer.New_Search.value;
		clickOn(locator);
		this.assertFindMotorcycleDealersPage();
	}

	/**
	 * Assert Nearest And Name Sorting Options.
	 */
	public void assertNearestAndNameSortingOptions() {
		print("Assert Nearest And Name Sorting Options.");
		String nearest = Locator.Dealer.Nearest_Sorting.value;
		Assert.assertTrue(isTextPresent(nearest, Strings.DealerSorting.Nearest.value),
				"Element Locator :" + nearest + " Not found");
		String name = Locator.Dealer.Name_Sorting.value;
		Assert.assertTrue(isTextPresent(name, Strings.DealerSorting.Name.value),
				"Element Locator :" + name + " Not found");
	}

	/**
	 * Assert searched dealers at Dealer Result page.
	 */
	public void assertSearchedDealers() {
		print("Assert searched dealers at Dealer Result page.");
		int dealerResult = getWebDriver().findElements(By.xpath("//*[@class='dealerPage']//ul/li")).size();
		System.out.println(dealerResult);
		String txt = Integer.toString(dealerResult);
		locator = Locator.Dealer.Dealer_Result.value;
		String text = getText(locator);
		String[] text2 = text.split("\\s+");
		String Finaltext = text2[0];
		System.out.println(Finaltext);
		Assert.assertTrue(Finaltext.contains(txt));
	}

	/**
	 * Assert Call And Search Listing With Count Buttons
	 */
	public void assertCallAndSearchListingWithCountButtons() {
		print("Assert Call And Search Listing With Count Buttons.");
		locator = Locator.Dealer.Buttons_DealerListed.value;
		int buttons = getWebDriver().findElements(ByLocator(locator)).size();
		System.out.println(buttons);
		for (int i = 1; i <= buttons; i++) {
			String buttonslocator = "//*[@class='list-unstyled margin-top10']//li[1]//a[" + i + "]";
			Assert.assertTrue(isElementDisplayed(buttonslocator));
		}
	}

	/**
	 * Click On Call And Search Listing Button And Assert Result Page.
	 */
	public void clickOnCallAndSearchListingButtonAndAssertResultPage() {
		print("Click On Call And Search Listing Button And Assert Result Page.");
		clickOn(Locator.Dealer.Call_Button.value);
		waitForElementPresentInDom(2);
		locator = Locator.Dealer.SearchListing_Button.value;
		this.getFirstVisible(locator);
		String buttontext = getText(locator);
		String[] text2 = buttontext.split("\\s+");
		String Finaltext = text2[1];
		System.out.println(Finaltext);
		clickOn(getFirstVisible(locator));
		String matchesCount = Locator.Dealer.Matches_Count.value;
		String count = getText(matchesCount);
		Assert.assertTrue(count.contains(Finaltext));
	}

	/**
	 * Click On Dealer Grid And Assert Result Page.
	 */
	public void clickOnDealerGridAndAssertResultPage() {
		print("Click On Dealer Grid And Assert Result Page");
		int dealerGrid = getWebDriver().findElements(ByLocator(Locator.Dealer.Dealer_Grid.value)).size();
		System.out.println(dealerGrid);
		for (int i = 1; i <= dealerGrid; i++) {
			locator = "//*[@class='dealerPage']//ul/li[" + i + "]//h2";
			String dealerName = getText(locator);
			clickOn(locator);
			String dealerResultPage = Locator.Dealer.Dealer_ResultPage.value;
			String dealerResult = getText(dealerResultPage);
			Assert.assertTrue(dealerResult.contains(dealerName));
			clickOn(Locator.Home.Application_Logo.value);
			this.clickOnFindMotorcycleDealersLink();
			this.assertFindMotorcycleDealersPage();
			this.assertFindDealersFieldsAndButton();
			this.findDealerWithNameAndAssertResult();
			this.assertSearchedDealers();
		}
	}
	
	/**
	 * Click On Dealer Grid Link And Assert Page
	 */
	public void clickOnDealerGridLinkAndAssertPage() {
		print("Click On Dealer Grid Link And Assert Page.");
		locator=Locator.Dealer.Dealer_First_Grid.value;
		String dealerName=getText(locator);
		clickOn(locator);
		String dealerResultPage = Locator.Dealer.Dealer_ResultPage.value;
		String dealerResult = getText(dealerResultPage);
		Assert.assertTrue(dealerResult.contains(dealerName));
	}
	
	public void clickOnWebsiteMapAndEmailLinksAndAssertResultPage() throws AWTException {
		this.clickOnMapLinkAndAssertResultPage();
		this.clickOnWebsiteLinkAndAssertResultPage();
		this.clickOnEmailLinkAndAssertResultPage();
	}

	/**
	 * Click On Website Link And Assert Result Page.
	 * @throws AWTException 
	 */
	public void clickOnWebsiteLinkAndAssertResultPage() throws AWTException {
		print("Click On Website Link And Assert Result Page");
		Robot r=new Robot();
		String dealerResultPage = Locator.Dealer.Dealer_ResultPage.value;
		String dealerResult = getText(dealerResultPage);
		clickOn(Locator.Dealer.Website_Link.value);
		Set<String> allWin = getWebDriver().getWindowHandles();
		String parentWindow = getWebDriver().getWindowHandle();
		for (String childWindow : allWin) {
			if (!childWindow.equalsIgnoreCase(parentWindow)) {
				getWebDriver().switchTo().window(childWindow);
				locator = Locator.Dealer.Dealer_ResultPage.value;
				String txt = getText(locator);
				Assert.assertTrue(txt.contains(dealerResult));
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_W);
				getWebDriver().switchTo().window(parentWindow);
			}
		}
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_W);
	}

	/**
	 * Click On Map Link And Assert Result Page.
	 * @throws AWTException 
	 */
	public void clickOnMapLinkAndAssertResultPage() throws AWTException {
		print("Click On Map Link And Assert Result Page");
		Robot r = new Robot();
		clickOn(Locator.Dealer.Map_Link.value);
		Set<String> allWin = getWebDriver().getWindowHandles();
		String parentWindow = getWebDriver().getWindowHandle();
		for (String childWindow : allWin) {
			if (!childWindow.equalsIgnoreCase(parentWindow)) {
				getWebDriver().switchTo().window(childWindow);
				locator = Locator.Dealer.Google_Map.value;
				Assert.assertTrue(isElementPresent(locator));
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_W);
				getWebDriver().switchTo().window(parentWindow);
			}
		}
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_W);
	}

	/**
	 * Click On Email Link And Assert Result Page.
	 */
	public void clickOnEmailLinkAndAssertResultPage() {
		print("Click On Email Link And Assert Result Page");
		clickOn(Locator.Dealer.Email_Link.value);
		Assert.assertTrue(isElementPresent(Locator.Dealer.Contact_Seller.value));
	}
	
	public void clickOnSaveThisSearchButtonAndAssertSavedSearch() {
		print("Click On Save This Search Button And Assert Saved Search");
		locator=Locator.Dealer.Save_Search.value;
		clickOn(locator);
		waitForElementPresentInDom(5);
		String savedSearchText = propertyReader.readApplicationFile("SaveSearchName");
		getWebDriver().findElement(By.xpath("//div[@id='mytraderModal']//input"))
				.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		sendKeys(Locator.Search.Save_Search_Title.value, savedSearchText);
		clickOn(Locator.Search.Save_Search_Button.value);
		waitForElementPresentInDom(10);
		Assert.assertTrue(isTextPresent(locator, Strings.Button.Saved_This_Search.value),
				"Element Locator :" + locator + " Not found");
		clickOn(locator);
	}
	
	public void assertSortingOptions() {
		print("Assert sorting options at Dealer details page.");
		Assert.assertTrue(isElementPresent(Locator.Dealer.Premium_Sorting.value));
		Assert.assertTrue(isElementPresent(Locator.Dealer.Price_Sorting.value));
		Assert.assertTrue(isElementPresent(Locator.Dealer.Year_Sorting.value));
		Assert.assertTrue(isElementPresent(Locator.Dealer.Newly_Listed_Sorting.value));
	}
	
	public void clickOnSortingOptionAndAssertSortingOptionWork() {
		print("Click On Sorting Option And Assert Sorting Option Work");
		clickOn(Locator.Dealer.Premium_Sorting.value);
		locator= Locator.Dealer.Sorting_Options_Enabled.value;
		Assert.assertTrue(isElementPresent(locator));
		waitForElementPresentInDom(2);
		clickOn(Locator.Dealer.Price_Sorting.value);
		Assert.assertTrue(isElementPresent(locator));
		waitForElementPresentInDom(2);
		clickOn(Locator.Dealer.Year_Sorting.value);
		Assert.assertTrue(isElementPresent(locator));
		waitForElementPresentInDom(2);
		clickOn(Locator.Dealer.Newly_Listed_Sorting.value);
		Assert.assertTrue(isElementPresent(locator));
		waitForElementPresentInDom(2);
	}
	
	public void assertRefineSection() {
		print("Assert Refine Section");
		waitForElementPresentInDom(3);
		locator=Locator.Dealer.Refine_Section.value;
		Assert.assertTrue(isElementPresent(locator));
}
	/**
	 * Assert Start Over link.
	 */
	public void assertStartOverLink() {
		print("Assert Start Over");
		waitForElementPresentInDom(3);
		locator=Locator.AdvancedSearch.Start_Over_Link.value;
		Assert.assertTrue(isElementPresent(locator));
	}
	
	/**
	 * Click On Filter Link And Assert Collapse Section.
	 */
	public void clickOnFilterLinkAndAssertCollapseSection() {
		print("Click On Filter Link And Assert Collapse Section.");
		locator=Locator.Dealer.Filter_Link.value;
		clickOn(locator);
		waitForElementPresentInDom(2);
		String collapse="//*[@id='refineHdr']/*[@aria-expanded='false']";
		Assert.assertTrue(isElementPresent(collapse));
	}
	
	/**
	 * Select All refine filter at Dealer details page.
	 */
	public void selectAllRefineFilter() {
		print("Select All refine filter at Dealer details page.");
		String typeOption = Locator.AdvancedSearch.Advanced_Type.value;
		clickOn(typeOption);
		print("Type refine option selected");
		waitForElementPresentInDom(4);
		clickOn(Locator.AdvancedSearch.Choose_Types.value);
		waitForElementPresentInDom(3);
		String makeLink=Locator.AdvancedSearch.Advanced_Make.value;
		clickOn(makeLink);
		waitForElementPresentInDom(3);
		String makeOption = "((//*[contains(text(),'Top Makes')])[2]/parent::div/following-sibling::div[1]//span)[1]";
		clickOn(makeOption);
		
	}
}
