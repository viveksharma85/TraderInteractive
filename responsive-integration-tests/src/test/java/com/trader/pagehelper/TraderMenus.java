package com.trader.pagehelper;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.trader.locators.Locator;
import com.trader.stringdata.Strings;
import com.trader.stringdata.Strings.MenuLinks;
import com.trader.utils.DriverHelper;

/**
 * This class contains all methods related to Menu.
 * 
 * @author viveks
 *
 */
public class TraderMenus extends DriverHelper {

	public TraderMenus(WebDriver driver) {
		super(driver, getSoftAssert());
	}

	/**
	 * This method is used to click on More Hamburger Button in header.
	 */
	public void clickOnMoreHamburgerButton() {
		print("Click on More Hamburger Button");
		locator = Locator.Menus.More_HamburgerButton.value;
		Assert.assertTrue(isElementPresent(locator), "More Hamburger Button Not found");
		this.clickOn(locator);
		this.assertHamburgerListing();
	}

	/**
	 * This method is used to click on My Trader Sign In menu.
	 */
	public void clickOnMyTraderSignIn() {
		print("Welcome to My Trader text on My Trader page");
		sleep(2000);
		locator = Locator.Menus.MyTrader_SignIn.value;
		Assert.assertTrue(isElementPresent(locator), "Menu Trader Sign In Not found");
		this.clickOn(locator);
		Assert.assertTrue(isElementPresent(Locator.Login.JoinMYTrader_Link.value));
		// getWebDriver().findElement(By.linkText("Join MyTrader"));
	}

	/**
	 * This method is used to click on Signout link.
	 */
	public void clickOnSignOutMyTraderLink() {
		print("Click on Sign out of My Trader link");
		locator = Locator.Menus.SignOut_MyTrader.value;
		Assert.assertTrue(isElementPresent(locator), "Menu Trader Sign In Not found");
		this.clickOn(locator);
		Assert.assertTrue(isElementPresent(Locator.Login.JoinMYTrader_Link.value));
		// getWebDriver().findElement(By.linkText("Join MyTrader"));
	}

	/**
	 * This method is used to click on hamburger and click on signout.
	 */
	public void signOutMyTrader() {
		this.clickOnMoreHamburgerButton();
		waitForElementPresentInDom(3);
		this.clickOnSignOutMyTraderLink();
	}

	/**
	 * This method used to click on Research menu.
	 */
	public void clickOnResearchMenu() {
		print("Click On Research Menu");
		waitForElementPresentInDom(2);
		locator = Locator.Menus.Research.value;
		clickOn(locator);
	}

	/**
	 * This method used to assert Research page.
	 */
	public void assertResearchPage() {
		print("Assert Research page");
		locator = Locator.Menus.Research_Page.value;
		waitForElementPresentInDom(4);
		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * Click on Learn More button and assert page.
	 */
	public void clickOnLearnMoreButtonAtResearchPage() {
		print("Click on Learn More button and assert page.");
		waitForElementPresentInDom(3);
		locator = Locator.Menus.Learn_More.value;
		getFirstVisible(locator).click();
		Assert.assertTrue(isElementPresent(Locator.Menus.Loan_Finance.value));
	}

	/**
	 * This method used to click on Race Team menu
	 */
	public void clickOnRaceTeamMenu() {
		print("Click On Race Team Menu");
		locator = Locator.Menus.Race_Team.value;
		WaitForElementPresent(locator, 20);
		clickOn(locator);
	}

	/**
	 * This method used to Assert Race Team page.
	 */
	public void assertRaceTeamPage() {
		print("Assert Race Team page");
		locator = Locator.Menus.Race_Team_Page.value;
		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * This method used to click on News menu.
	 */
	public void clickOnNewsMenu() {
		print("Click On News Menu");
		locator = Locator.Menus.News.value;
		WaitForElementPresent(locator, 20);
		clickOn(locator);
	}

	/**
	 * This method used to Assert News page.
	 */
	public void assertNewsPage() {
		print("Assert News page");
		locator = Locator.Menus.News_Page.value;
		waitForElementPresentInDom(3);
		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * This method used to click on Dealers menu
	 */
	public void clickOnDealersMenu() {
		print("Click On Dealers Menu");
		waitForElementPresentInDom(3);
		locator = Locator.Menus.Dealers.value;
		clickOn(locator);
	}

	public void clickOnRealmForSaleMenuAndAssertResultPage() {
		print("Click on Motorcycle for Sale and assert result page.");
		locator = Locator.Menus.BUY.value;
		clickOn(locator);
		String findMotorcycleForSale = Locator.Search.Advanced_Search_Page.value;
		Assert.assertTrue(isTextPresent(findMotorcycleForSale, Strings.PageName.Advanced_Search.value),
				"Element Locator :" + locator + " Not found");
	}

	public void clickOnSellForFreeAndAssertResultPage() {
		print("Click on Sell For Free and assert result page.");
		locator = Locator.Menus.Sell_For_Free.value;
		clickOn(locator);
		Assert.assertTrue(isElementPresent(Locator.Menus.SellForFree_MenuDropDown.value));
	}

	/**
	 * Assert Sign out page
	 */
	public void assertPageAfterSignout() {
		print("Assert successfully signout");
		waitForElementPresentInDom(5);
		Assert.assertTrue(isElementPresent(Locator.Login.Login_Link.value));
		Assert.assertTrue(isElementPresent(Locator.Login.Login_Page.value));
	}

	/**
	 * Assert All Menu links in header
	 */
	public void assertAllMenusInHeader() {
		print("Assert All Menu links in header");
		String sale = Locator.Menus.BUY.value;
		Assert.assertTrue(isTextPresent(sale, Strings.Menus.MotorcyclesForSale.value),
				"Element Locator :" + locator + " Not found");

		String sellForFree = Locator.Menus.Sell_For_Free.value;
		Assert.assertTrue(isTextPresent(sellForFree, Strings.Menus.SellForFree.value),
				"Element Locator :" + locator + " Not found");

		String research = Locator.Menus.Research.value;
		Assert.assertTrue(isTextPresent(research, Strings.Menus.Research.value),
				"Element Locator :" + locator + " Not found");

		String raceTeam = Locator.Menus.Race_Team.value;
		Assert.assertTrue(isTextPresent(raceTeam, Strings.Menus.RaceTeam.value),
				"Element Locator :" + locator + " Not found");

		String news = Locator.Menus.News.value;
		Assert.assertTrue(isTextPresent(news, Strings.Menus.News.value), "Element Locator :" + locator + " Not found");

		String motorcycleDealers = Locator.Menus.Dealers.value;
		Assert.assertTrue(isTextPresent(motorcycleDealers, Strings.Menus.MotorcycleDealers.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Click on all menus and assert result pages.
	 */
	public void menusLinksRedirationAndAssertResultPage() {
		print("Click on menus and assert resuklt page.");
		locator = Locator.Home.Application_Logo.value;
		this.clickOnRealmForSaleMenuAndAssertResultPage();
		clickOn(locator);
		this.clickOnSellForFreeAndAssertResultPage();
		clickOn(locator);
		this.clickOnResearchMenu();
		this.assertResearchPage();
		clickOn(locator);

		this.clickOnNewsMenu();
		this.assertNewsPage();
		clickOn(locator);

		this.clickOnRaceTeamMenu();
		this.assertRaceTeamPage();
		clickOn(locator);

		this.clickOnDealersMenu();
		Assert.assertTrue(isElementPresent(Locator.Menus.DealerMenu_DropDown.value));
		clickOn(locator);
	}

	/**
	 * Assert hamburger listing and close icon.
	 */
	public void assertHamburgerListing() {
		print("Assert Hamburger listing and close icon");
		Assert.assertTrue(isElementPresent(Locator.Menus.Close_Icon.value));
		Assert.assertTrue(isElementPresent(Locator.Menus.Hamburger_Listing.value));
	}

	/**
	 * Click on close icon
	 */
	public void clickOnCloseLink() {
		print("Click on close icon");
		clickOn(Locator.Menus.Close_Icon.value);
	}

	public List<String> getHamburgerLinks() {
		EnumSet<MenuLinks> all = EnumSet.allOf(MenuLinks.class);
		List<String> list = new ArrayList<>(all.size());
		for (MenuLinks s : all) {
			list.add(s.value);
		}
		return list;
	}

	/**
	 * Assert Links Under Hamburger List.
	 */
	public void assertLinksUnderHamburgerList() {
		print("Assert Links Under Hamburger List.");
		List<String> allHamburgerLinks = getHamburgerLinks();
		for (String hamburgerLinks : allHamburgerLinks) { 
			locator = "//*[@id='sidebar-wrapper']//li/a[contains(text(),'" + hamburgerLinks + "')]";			
		String txt = getText(locator);
		System.out.println(txt);
		}
	}

	public void clickLinksUnderHamburgerListAndAssertResultPage() {
		print("Assert Links Under Hamburger List.");
		List<String> hamburgerLinks = getHamburgerLinks();
		for (@SuppressWarnings("unused")String modelList : hamburgerLinks)
			locator = "//*[@id='sidebar-wrapper']/ul/a[contains(text(),'" + hamburgerLinks + "')]";
	}
	
	@SuppressWarnings("unused")
	public void testMethod() {
		print("Hamburger List");
		List<String> hamburgerLinks = getHamburgerLinks();
		locator="//*[@id='sidebar-wrapper']//li/a";
		int menu = getWebDriver().findElements(ByLocator(locator)).size();
		System.out.println(menu);
		for (int i=2; i<=menu;i++) {
				String menuLinks= "//*[@id='sidebar-wrapper']//li["+i+"]/a";
				String text = getText(menuLinks);
					System.out.println(text);
				//Assert.assertTrue(hamburgerLinks.contains(text));
					
		}
	}
}
//		String menuLinks= "//*[@id='sidebar-wrapper']//li[not (contains(@class,'hidden')) and not (contains(@class,'noShow'))]/a";
//			String text = getWebDriver().findElements(By.xpath("")
//			System.out.println(text);
	//		}
	//	}