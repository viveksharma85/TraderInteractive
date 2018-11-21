package com.trader.pagehelper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.trader.locators.Locator;
import com.trader.stringdata.Strings;
import com.trader.stringdata.Strings.FooterLinks;
import com.trader.stringdata.Strings.ModelList;
import com.trader.stringdata.Strings.PopularTabs;
import com.trader.stringdata.Strings.State;
import com.trader.stringdata.Strings.Types;
import com.trader.utils.DriverHelper;

public class HomeHelper extends DriverHelper {
	protected WebDriver driver;

	public HomeHelper(WebDriver driver) {
		super(driver, getSoftAssert());
	}

	/**
	 * Click On Popular Makes tab.
	 */
	public void clickOnPopularMakesTab() {
		print("Click on Popular Makes tab");
		locator = Locator.Home.Popular_Makes.value;
		clickOn(locator);
	}

	/**
	 * Click On BMW icon under Popular Makes tab.
	 */
	public void clickOnBMWIcon() {
		print("Click on BMW");
		locator = Locator.Home.Makes_BMW.value;
		clickOn(locator);
	}

	/**
	 * Click On Can-Am icon under Popular Makes tab.
	 */
	public void clickOnCanAmIcon() {
		print("Click on Can-Am");
		locator = Locator.Home.Makes_CAN_AM.value;
		clickOn(locator);
	}

	/**
	 * Click On Ducati icon under Popular Makes tab.
	 */
	public void clickOnDucatiIcon() {
		print("Click on Ducati");
		locator = Locator.Home.Makes_Ducati.value;
		clickOn(locator);
	}

	/**
	 * Click On Harley-Davidson icon under Popular Makes tab.
	 */
	public void clickOnHarleyIcon() {
		print("Click on Harley");
		locator = Locator.Home.Makes_Harley.value;
		clickOn(locator);
	}

	/**
	 * Click On Honda icon under Popular Makes tab.
	 */
	public void clickOnHondaIcon() {
		print("Click on Honda");
		locator = Locator.Home.Makes_Honda.value;
		clickOn(locator);
	}

	/**
	 * Click On KTM icon under Popular Makes tab.
	 */
	public void clickOnKTMIcon() {
		print("Click on KTM");
		locator = Locator.Home.Makes_KTM.value;
		clickOn(locator);
	}

	/**
	 * Click On Kawasaki icon under Popular Makes tab.
	 */
	public void clickOnKawasakiIcon() {
		print("Click on Kawasaki");
		locator = Locator.Home.Makes_Kawasaki.value;
		clickOn(locator);
	}

	/**
	 * Click On Suzuki icon under Popular Makes tab.
	 */
	public void clickOnSuzukiIcon() {
		print("Click on Suzuki");
		locator = Locator.Home.Makes_Suzuki.value;
		clickOn(locator);
	}

	/**
	 * Click On Yamaha icon under Popular Makes tab.
	 */
	public void clickOnYamahaIcon() {
		print("Click on Yamaha");
		locator = Locator.Home.Makes_Yamaha.value;
		clickOn(locator);
	}

	/**
	 * Click On Triumph icon under Popular Makes tab.
	 */
	public void clickOnTriumphIcon() {
		print("Click on Triumph");
		locator = Locator.Home.Makes_Triumph.value;
		clickOn(locator);
	}

	/**
	 * Click On Victory icon under Popular Makes tab.
	 */
	public void clickOnVictoryIcon() {
		print("Click on Victory");
		locator = Locator.Home.Makes_Victory.value;
		clickOn(locator);
	}

	/**
	 * Click On Search All icon under Popular Makes tab.
	 */
	public void clickOnSearchAllIcon() {
		print("Click on Search All");
		locator = Locator.Home.Makes_SearchAll.value;
		clickOn(locator);
	}

	/**
	 * Assert BMW search Result Page.
	 */
	public void assertBMWSearchResultPage() {
		print("Assert BMW search result page.");
		locator = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.BMW_Search_Result.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Assert Can-Am search Result Page.
	 */
	public void assertCanAmSearchResultPage() {
		print("Assert CAN-Am search result page.");
		locator = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.CANAM_Search_Result.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Assert Ducati search Result Page.
	 */
	public void assertDucatiSearchResultPage() {
		print("Assert Ducati search result page.");
		locator = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Ducati_Search_Result.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Assert Harley-Davidson search Result Page.
	 */
	public void assertHarleySearchResultPage() {
		print("Assert Harley search result page.");
		locator = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Harley_Search_Result.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Assert Honda search Result Page.
	 */
	public void assertHondaSearchResultPage() {
		print("Assert Honda search result page.");
		locator = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Honda_Search_Result.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Assert KTM search Result Page.
	 */
	public void assertKTMSearchResultPage() {
		print("Assert KTM search result page.");
		locator = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.KTM_Search_Result.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Assert Kawasaki search Result Page.
	 */
	public void assertKawasakiSearchResultPage() {
		print("Assert Kawasaki search result page.");
		locator = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Kawasaki_Search_Result.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Assert Suzuki search Result Page.
	 */
	public void assertSuzukiSearchResultPage() {
		print("Assert Suzuki search result page.");
		locator = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Suzuki_Search_Result.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Assert Triumph search Result Page.
	 */
	public void assertTriumphSearchResultPage() {
		print("Assert Triumph search result page.");
		locator = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Triumph_Search_Result.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Assert Victory search Result Page.
	 */
	public void assertVictorySearchResultPage() {
		print("Assert Victory search result page.");
		locator = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Victory_Search_Result.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Assert Yamaha search Result Page.
	 */
	public void assertYamahaSearchResultPage() {
		print("Assert Yamaha search result page.");
		locator = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Yamaha_Search_Result.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Assert Search all search Result Page.
	 */
	public void assertSearchAllMakesSearchResultPage() {
		print("Assert BMW search result page.");
		waitForElementPresentInDom(4);
		locator = Locator.Search.SearchAllMakes_Result.value;
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.SearchAll_Search_Result.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Click on application logo in header section.
	 */
	public void clickOnApplicationLogo() {
		print("Click on application logo in header");
		locator = Locator.Home.Application_Logo.value;
		clickOn(locator);
	}

	/**
	 * Click on BMW icon under Popular Makes and assert BMW search Result Page.
	 */
	public void searchBMWMakes() {
		print("Search BMW Makes");
		this.clickOnBMWIcon();
		this.assertBMWSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Can-Am icon under Popular Makes and assert Can-Am search Result
	 * Page.
	 */
	public void searchCanAmMakes() {
		print("Search Can-Am Makes");
		this.clickOnCanAmIcon();
		this.assertCanAmSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Ducati icon under Popular Makes and assert Ducati search Result
	 * Page.
	 */
	public void searchDucatiMakes() {
		print("Search Ducati Makes");
		this.clickOnDucatiIcon();
		this.assertDucatiSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Harley-Davidson icon under Popular Makes and assert Harley -
	 * Davidson search Result Page.
	 */
	public void searchHarleyMakes() {
		print("Search Harley Makes");
		this.clickOnHarleyIcon();
		this.assertHarleySearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Honda icon under Popular Makes and assert Honda search Result Page.
	 */
	public void searchHondaMakes() {
		print("Search Honda Makes");
		this.clickOnHondaIcon();
		this.assertHondaSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on KTM icon under Popular Makes and assert KTM search Result Page.
	 */
	public void searchKTMMakes() {
		print("Search KTM Makes");
		this.clickOnKTMIcon();
		this.assertKTMSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Kawasaki icon under Popular Makes and assert Kawasaki search Result
	 * Page.
	 */
	public void searchKawasakiMakes() {
		print("Search Kawasaki Makes");
		this.clickOnKawasakiIcon();
		this.assertKawasakiSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Suzuki icon under Popular Makes and assert Suzuki search Result
	 * Page.
	 */
	public void searchSuzukiMakes() {
		print("Search Suzuki Makes");
		this.clickOnSuzukiIcon();
		this.assertSuzukiSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Triumph icon under Popular Makes and assert Triumph search Result
	 * Page.
	 */
	public void searchTriumphMakes() {
		print("Search Triumph Makes");
		this.clickOnTriumphIcon();
		this.assertTriumphSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Victory icon under Popular Makes and assert Victory search Result
	 * Page.
	 */
	public void searchVictoryMakes() {
		print("Search Victory Makes");
		this.clickOnVictoryIcon();
		this.assertVictorySearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Yamaha icon under Popular Makes and assert Yamaha search Result
	 * Page.
	 */
	public void searchYamahaMakes() {
		print("Search Yamaha Makes");
		this.clickOnYamahaIcon();
		this.assertYamahaSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Search All under Popular Makes and assert search Result Page.
	 */
	public void searchSearchAllMakes() {
		print("Search All Makes");
		this.clickOnSearchAllIcon();
		this.assertSearchAllMakesSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Assert Top Motorcycle Makes Section.
	 */
	public void assertTopMakesSection() {
		print("Top Motorcycle Makes Section");
		locator = Locator.Home.Top_Makes.value;
		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * Click on Can-Am link under Top Motorcycles Makes section
	 */
	public void clickOnCanAmTopMakeLink() {
		print("Click on Can Am Top Make link");
		locator = Locator.Home.Top_Makes_CanAm.value;
		clickOn(locator);
		this.assertCanAmSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Harley Davidson link under Top Motorcycles Makes section
	 */
	public void clickOnHarleyDavidsonTopMakeLink() {
		print("Click on Harley-Davidson Top Make link");
		locator = Locator.Home.Top_Makes_Harley.value;
		clickOn(locator);
		this.assertHarleySearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Honda link under Top Motorcycles Makes section
	 */
	public void clickOnHondaTopMakeLink() {
		print("Click on Honda Top Make link");
		locator = Locator.Home.Top_Makes_Honda.value;
		clickOn(locator);
		this.assertHondaSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Yamaha link under Top Motorcycles Makes section
	 */
	public void clickOnYamahaTopMakeLink() {
		print("Click on Yamaha Top Make link");
		locator = Locator.Home.Top_Makes_Yamaha.value;
		clickOn(locator);
		this.assertYamahaSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Kawasaki link under Top Motorcycles Makes section
	 */
	public void clickOnKawasakiTopMakeLink() {
		print("Click on Kawasaki Top Make link");
		locator = Locator.Home.Top_Makes_Kawasaki.value;
		clickOn(locator);
		this.assertKawasakiSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on BMW link under Top Motorcycles Makes section
	 */
	public void clickOnBMWTopMakeLink() {
		print("Click on BMW Top Make link");
		locator = Locator.Home.Top_Makes_BMW.value;
		clickOn(locator);
		this.assertBMWSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Triumph link under Top Motorcycles Makes section
	 */
	public void clickOnTriumphTopMakeLink() {
		print("Click on Triumph Top Make link");
		locator = Locator.Home.Top_Makes_Triumph.value;
		clickOn(locator);
		this.assertTriumphSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on KTM link under Top Motorcycles Makes section
	 */
	public void clickOnKTMTopMakeLink() {
		print("Click on KTM Top Make link");
		locator = Locator.Home.Top_Makes_KTM.value;
		clickOn(locator);
		this.assertKTMSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Victory link under Top Motorcycles Makes section
	 */
	public void clickOnVictoryTopMakeLink() {
		print("Click on Victory Top Make link");
		locator = Locator.Home.Top_Makes_Victory.value;
		clickOn(locator);
		this.assertVictorySearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Suzuki link under Top Motorcycles Makes section
	 */
	public void clickOnSuzukiTopMakeLink() {
		print("Click on Suzuki Top Make link");
		locator = Locator.Home.Top_Makes_Suzuki.value;
		clickOn(locator);
		this.assertSuzukiSearchResultPage();
		this.clickOnApplicationLogo();
	}

	/**
	 * Assert Top Model section.
	 */
	public void assertTopModelSection() {
		print("Assert Top Model Section");
		locator = Locator.Home.Top_Model.value;
		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * Click on Kawasaki Ninja link and assert search result page.
	 */
	public void clickOnKawasakiNinJaLink() {
		print("Click on Kawasaki Ninja");
		locator = Locator.Home.Top_KAWASAKI_NINJA.value;
		clickOn(locator);
		waitForElementPresentInDom(1);
		String locator1 = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator1, Strings.PageName.KAWASAKI_NINJA.value),
				"Element Locator :" + locator1 + " Not found");
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Harley Daviderson link and assert search result page.
	 */
	public void clickOnHarleyDavidsonELECTRAGLIDELink() {
		print("Click on Harley-davidson ELECTRA GLIDE");
		locator = Locator.Home.Top_ELECTRA_GLIDE.value;
		clickOn(locator);
		String locator1 = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator1, Strings.PageName.ELECTRA_GLIDE.value),
				"Element Locator :" + locator1 + " Not found");
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Honda CRF link and assert search result page.
	 */
	public void clickOnHondaCRFLink() {
		print("Click on Honda CRF");
		locator = Locator.Home.Top_HONDA_CRF.value;
		clickOn(locator);
		String locator1 = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator1, Strings.PageName.HONDA_CRF.value),
				"Element Locator :" + locator1 + " Not found");
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Honda CBR link and assert search result page.
	 */
	public void clickOnHondaCBRLink() {
		print("Click on Honda CBR");
		locator = Locator.Home.Top_HONDA_CBR.value;
		clickOn(locator);
		String locator1 = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator1, Strings.PageName.HONDA_CBR.value),
				"Element Locator :" + locator1 + " Not found");
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Harley Davidson Street Glide link and assert search result page.
	 */
	public void clickOnHarleyDavidsonSTREETGLIDELink() {
		print("Click on Harley-davidson STREET GLIDE");
		locator = Locator.Home.Top_Street_Glide.value;
		clickOn(locator);
		String locator1 = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator1, Strings.PageName.Street_Glide.value),
				"Element Locator :" + locator1 + " Not found");
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Kawasaki VULCAN link and assert search result page.
	 */
	public void clickOnKawasakiVULCANLink() {
		print("Click on Kawasaki VULCAN");
		locator = Locator.Home.Top_KAWASAKI_VULCAN.value;
		clickOn(locator);
		String locator1 = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator1, Strings.PageName.KAWASAKI_VULCAN.value),
				"Element Locator :" + locator1 + " Not found");
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Can-Am Spyder link and assert search result page.
	 */
	public void clickOnCanAmSPYDERLink() {
		print("Click on Can-am SPYDER");
		locator = Locator.Home.Top_Spyder_Can.value;
		clickOn(locator);
		String locator1 = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator1, Strings.PageName.Spyder_Can.value),
				"Element Locator :" + locator1 + " Not found");
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Yamaha YZF link and assert search result page.
	 */
	public void clickOnYamahaYZFLink() {
		print("Click on Yamaha YZF");
		locator = Locator.Home.Top_YAMAHA_YZF.value;
		clickOn(locator);
		String locator1 = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator1, Strings.PageName.YAMAHA_YZF.value),
				"Element Locator :" + locator1 + " Not found");
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Yamaha V Star link and assert search result page.
	 */
	public void clickOnYamahaVSTARLink() {
		print("Click on Yamaha V STAR");
		locator = Locator.Home.Top_YAMAHA_V_STAR.value;
		clickOn(locator);
		String locator1 = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator1, Strings.PageName.YAMAHA_V_STAR.value),
				"Element Locator :" + locator1 + " Not found");
		this.clickOnApplicationLogo();
	}

	/**
	 * Click on Harley Davidson Road Glide link and assert search result page.
	 */
	public void clickOnHarleyDavidsonROADGLIDE() {
		print("Click on Harley-davidson ROAD GLIDE");
		locator = Locator.Home.Top_Road_Glide.value;
		clickOn(locator);
		String locator1 = Locator.Search.Search_Result_Page.value;
		Assert.assertTrue(isTextPresent(locator1, Strings.PageName.Road_Glide.value),
				"Element Locator :" + locator1 + " Not found");
		this.clickOnApplicationLogo();
	}

	/**
	 * Assert Top Type Section
	 */
	public void assertTopTypeSection() {
		print("Assert Top Type Section");
		locator = Locator.Home.Top_Type.value;
		waitForElementPresentInDom(5);
		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * Set Types links list
	 * 
	 * @param locator
	 * @param index
	 * @param topModelList
	 */
	@SuppressWarnings("unused")
	public void setTypeList(String locator, int index, String topModelList) {
		print("set Type List '" + topModelList + "'");
		this.waitForElementPresentInDom(5);
		List<WebElement> layout = this.getElementList(locator);
		// setModelList(layout, index, topModelList);
	}

	/**
	 * Get search result page locator.
	 * 
	 * @param text
	 * @return
	 */
	public String getSearchResultPageLocator(String text) {
		locator = "//*[@id='topicLinks']//em[contains(text(),'" + text + "')]";
		return locator;
	}

	/**
	 * Assert Type result page.
	 * 
	 * @param popularTypeList
	 */
	public void assertTypePage(String popularTypeList) {
		String TopType = getSearchResultPageLocator(popularTypeList);
		Assert.assertTrue(isElementDisplayed(TopType), "Expected to display Top Model List " + TopType);
		// Assert.assertTrue(assertTextPresentIgnoreCase(TopModel), "Expected to display
		// Top Model List " + TopModel);
	}

	/**
	 * Get popular type links List.
	 * 
	 * @return
	 */
	public List<String> getPopularTypeList() {
		print("Assert Top Model Section");
		EnumSet<Types> all = EnumSet.allOf(Types.class);
		List<String> list = new ArrayList<>(all.size());
		for (Types s : all) {
			list.add(s.value);
		}
		return list;
	}

	/**
	 * Click on Type links and assert Type link result page.
	 */
	public void clickAndAssertPopularTypeLinks() {
		List<String> allpopularTypeLists = getPopularTypeList();
		for (String popularTypeList : allpopularTypeLists) {
			this.clickOnPopularTypesTab();

			locator = "//*[@id='typeIcons']/li/a[contains(@title,'" + popularTypeList + "')]";

			print("set Popular Type" + popularTypeList + "'");
			this.setTypeList(locator, 0, popularTypeList);
			clickOn(locator);

			assertTypePage(popularTypeList);
			this.clickOnApplicationLogo();

		}
	}

	/**
	 * Click on Popular Types Tab.
	 */
	public void clickOnPopularTypesTab() {
		print("Click on Popular Type Tab");
		locator = Locator.Types.Popular_Types.value;
		clickOn(locator);
	}

	/**
	 * Click on Search All under Popular Type Tab.
	 */
	public void clickOnSearchAllUnderPopularTypesTab() {
		print("Click on search all under Popular Type Tab");
		locator = Locator.Types.Search_All.value;
		clickOn(locator);
	}

	@SuppressWarnings("unused")
	public String getModelResultPageLocator(String text) {
		locator = "//div[@id='topicLinks']/h1[contains(text(),'" + text + "')]";
		boolean loc = locator.toString().equalsIgnoreCase(text);
		return locator;
	}

	public void assertModelPage(String modelList) {
		String TopModel = getModelResultPageLocator(modelList);
		Assert.assertTrue(isElementDisplayed(TopModel), "Expected to display Top Model List " + TopModel);
		// Assert.assertTrue(assertTextPresentIgnoreCase(TopModel), "Expected to display
		// Top Model List " + TopModel);
	}

	public List<String> getTopModelList() {
		print("Assert Top Model Section");
		EnumSet<ModelList> all = EnumSet.allOf(ModelList.class);
		List<String> model = new ArrayList<>(all.size());
		for (ModelList s : all) {
			model.add(s.value);
		}
		return model;
	}

	/**
	 * Click on Model links and assert result page.
	 */
	public void clickAndAssertTopModelLinks() {
		List<String> allTopModelLists = getTopModelList();
		for (String modelList : allTopModelLists) {
			// this.clickOnPopularTypesTab();

			locator = "//div[@class='col-md-4']//li/a[contains(text(),'" + modelList + "')]";

			print("set Popular Model" + modelList + "'");
			this.setTypeList(locator, 0, modelList);
			clickOn(locator);

			assertTypePage(modelList);
			this.clickOnApplicationLogo();

		}
	}

	/**
	 * Click type link and assert search result page.
	 * 
	 * @throws InterruptedException
	 */
	public void clickAndAssertTypesLink() {
		sleep(2000);
		int length = getWebDriver()
				.findElements(By.xpath("//*[@id='page-content-wrapper']//div[3]/ul[@class='list-unstyled']/li")).size();
		System.out.println("read loactor");

		System.out.println(length);
		for (int i = 1; i <= length; i++) {

			locator = "//*[@id='page-content-wrapper']//div[3]/ul[@class='list-unstyled']/li[" + i + "]/a";
			String text = getText(locator);
			String[] text2 = text.split(" ");
			String Finaltext = text2[text2.length - 1].toLowerCase();
			clickOn(locator);
			String expected = getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText().toLowerCase();
			Assert.assertTrue(expected.contains(Finaltext));
			this.clickOnApplicationLogo();
		}
	}

	@SuppressWarnings("unused")
	public void setStateList(String locator, int index, String topStatelList) {
		print("set State List '" + topStatelList + "'");
		this.waitForElementPresentInDom(10);
		List<WebElement> layout = this.getElementList(locator);
		// setModelList(layout, index, topModelList);
	}

	/**
	 * Get State search Result page locator.
	 * 
	 * @param text
	 * @return
	 */
	public String getStateSearchResultPageLocator(String text) {
		locator = "//*[@id='topicLinks']//em[contains(text(),'" + text + "')]";
		return locator;
	}

	/**
	 * Assert state page
	 * 
	 * @param popularStateList
	 */
	public void assertStatePage(String popularStateList) {
		String popularState = getSearchResultPageLocator(popularStateList);
		Assert.assertTrue(isElementDisplayed(popularState), "Expected to display popular state List " + popularState);

	}

	/**
	 * Get popular state list
	 * 
	 * @return
	 */
	public List<String> getPopularStateList() {
		print("Assert Popular State Section");
		EnumSet<State> all = EnumSet.allOf(State.class);
		List<String> list = new ArrayList<>(all.size());
		for (State s : all) {
			list.add(s.value);
		}
		return list;
	}

	/**
	 * Click state link under Popular state tab and assert result page.
	 */
	public void clickAndAssertPopularStateLinks() {
		List<String> allpopularStateLists = getPopularStateList();
		for (String popularStateList : allpopularStateLists) {

			this.clickOnPopularStateTab();

			locator = "//*[@id='statesIcons']/li/a[contains(@title,'" + popularStateList + "')]";

			print("set Popular State" + popularStateList + "'");
			this.setTypeList(locator, 0, popularStateList);
			clickOn(locator);

			assertStatePage(popularStateList);
			this.clickOnApplicationLogo();
		}
	}

	/**
	 * Click on Popular State Tab.
	 */
	public void clickOnPopularStateTab() {
		print("Click on Popular State tab");
		locator = Locator.State.Popular_State_Tab.value;
		clickOn(locator);
	}

	/**
	 * Click on Search All under Popular State tab.
	 */
	public void clickOnSearchAllUnderState() {
		print("Click on Search All under Popular State tab");
		locator = Locator.State.Search_All.value;
		clickOn(locator);
	}

	/**
	 * Assert State Result Page.
	 */
	public void assertStateResultPage() {
		print("Assert State result page");
		locator = Locator.State.State_Search_Result.value;
		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * In this method, Click on State links and assert result page.
	 */
	public void clickAndAssertStateLinks() {
		int length = getWebDriver().findElements(By.xpath("//div[@class='browseContainer']/div")).size();
		System.out.println("read loactor");

		System.out.println(length);
		for (int i = 1; i <= length; i++) {
			sleep(2000);

			locator = "//div[@class='browseContainer']/div[" + i + "]/div/a";
			String text = getText(locator);
			String[] text2 = text.split(" ");
			System.out.println(text2);
			String Finaltext = text2[text2.length - 1].toLowerCase();
			clickOn(locator);
			String expected = getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText().toLowerCase();
			System.out.println(expected);
			Assert.assertTrue(expected.contains(Finaltext));
			clickOn("//a[@title='Browse All States']");
		}
	}

	/**
	 * Click on Buy menu and assert result page.
	 */
	public void clickOnBuyMenuAndAssertResultPage() {
		print("Click on Buy Menu and assert Result page");
		locator = Locator.Menus.BUY.value;
		waitForElementPresentInDom(2);
		clickOn(locator);
		waitForElementPresentInDom(5);
		Assert.assertTrue(isElementPresent(Locator.Search.Buy_Result_Page.value));
	}

	/**
	 * Assert home page.
	 */
	public void assertHomePage() {
		print("Assert home page");
		Assert.assertTrue(isElementPresent(Locator.Home.Search_Tab.value));
	}

	/**
	 * Assert Sell Motorcycle And Search tabs at home page.
	 */
	public void assertSellMotorcycleAndSearchtabs() {
		print("Assert Sell Motorcycle And Search tabs");
		Assert.assertTrue(isElementPresent(Locator.Home.Sell_Motorcycle.value));
		this.assertHomePage();
	}

	/**
	 * Assert search fields under search tab at home page.
	 */
	public void assertSearchFieldsAndButton() {
		print("Assert Search Fields And Button");
		Assert.assertTrue(isElementPresent(Locator.Home.Keyword_Field.value));
		Assert.assertTrue(isElementPresent(Locator.Home.Zip_Code.value));
		Assert.assertTrue(isElementPresent(Locator.Home.Radius_DropDown.value));
		Assert.assertTrue(isElementPresent(Locator.Home.Find_Button.value));
	}

	/**
	 * Assert Advanced Search And Find MotorCycle Dealer Links under search tab at
	 * home page.
	 */
	public void assertAdvancedSearchAndFindMotorCycleDealerLinks() {
		print("Assert Advanced Search And Find MotorCycle Dealer Links");
		Assert.assertTrue(isElementPresent(Locator.Home.Advanced_Search_Link.value));
		Assert.assertTrue(isElementPresent(Locator.Home.Find_Motorcycle_Dealers.value));
	}

	/**
	 * Click on Sell a Motorcycle tab at home page.
	 */
	public void clickOnSellMotorcycleTab() {
		print("Click on Sell a Motorcycle tab.");
		clickOn(Locator.Home.Sell_Motorcycle.value);
	}

	/**
	 * Get popular tabs name.
	 * 
	 * @return
	 */
	public List<String> getPopularTabs() {
		EnumSet<PopularTabs> all = EnumSet.allOf(PopularTabs.class);
		List<String> pTab = new ArrayList<>(all.size());
		for (PopularTabs s : all) {
			pTab.add(s.value);
		}
		return pTab;
	}

	/**
	 * Assert Popular Makes, Types and state tabs.
	 */
	public void assertPopularMakesTypesAndStateTab() {
		print("Assert Popular Makes, Types and state tabs.");
		List<String> popularMakesTypesAndState = getPopularTabs();
		for (@SuppressWarnings("unused")
		String modelList : popularMakesTypesAndState)
			locator = "//div[@id='browse-section']/div/a[contains(text(),'" + popularMakesTypesAndState + "')]";
	}

	/**
	 * Click on all makes icon under popular Makes tab and assert result page.
	 */
	public void searchWithPopularMakesAndAssertResultPage() {
		print("Click on all makes icon and assert result page");
		int length = getWebDriver().findElements(By.xpath("//ul[@id='makeIcons']/li")).size();
		for (int i = 1; i < length; i++) {
			sleep(2000);
			locator = "//ul[@id='makeIcons']/li[" + i + "]";
			String text = getText(locator);
			String[] text2 = text.split(" ");
			String Finaltext = text2[text2.length - 1].toLowerCase();
			clickOn(locator);
			String expected = getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText().toLowerCase();
			Assert.assertTrue(expected.contains(Finaltext));
			this.clickOnApplicationLogo();
		}
	}

	/**
	 * Assert Sell Your Motorcycle section and assert Post for Free Button at home
	 * page.
	 */
	public void assertSellYourMotorcycleSection() {
		print("Assert Sell Your Motorcycle section and assert Post for Free Button");
		Assert.assertTrue(isElementPresent(Locator.Home.Sell_Motorcycle_Section.value));
		locator = Locator.Home.Post_For_Free.value;
		Assert.assertTrue(isTextPresent(locator, Strings.Button.Post_For_Free.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Click on Post For Free button and assert Result Page.
	 */
	public void clickOnPostForFreeAndAssertResultPage() {
		print("Click on Post For Free button and assert Result Page.");
		clickOn(Locator.Home.Post_For_Free.value);
		getWebDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "PageDown");
		locator = Locator.Sell.Sell_Your_Motorcycle.value;
		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * Assert Sell Used MOTORCYCLE Section
	 */
	public void assertSellUsedMOTORCYCLESection() {
		print("Assert Sell Used MOTORCYCLE Section");
		Assert.assertTrue(
				isTextPresent(Locator.Home.Interested_Used_Bikes.value,
						Strings.SectionHeading.Interested_Used_Bikes.value),
				"Element Locator :" + locator + " Not found");
		Assert.assertTrue(isTextPresent(Locator.Home.Check_It_Out.value, Strings.Button.Check_It_Out.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Click On Check It Out Button
	 * 
	 */
	public void clickOnCheckItOutButtonAndAssertResultPage() {
		print("Click On Check It Out Button and Assert Result page.");
		clickOn(Locator.Home.Check_It_Out.value);
		waitForElementPresentInDom(5);
		Set<String> allWin = getWebDriver().getWindowHandles();
		String parentWindow = getWebDriver().getWindowHandle();
		for (String childWindow : allWin) {
			if (!childWindow.equalsIgnoreCase(parentWindow)) {
				getWebDriver().switchTo().window(childWindow);
				String url = getWebDriver().getCurrentUrl();
				System.out.println(url);
				String exceptedURL = "https://issuu.com/cycletrader150/docs/booklet";
				Assert.assertEquals(exceptedURL, url);
			}
		}
	}

	/**
	 * Assert Stay Connected Section in footer
	 */
	public void assertStayConnected() {
		print("Assert Stay Connected Section");
		locator = Locator.Home.Stay_Connected.value;
		Assert.assertTrue(isTextPresent(locator, Strings.SectionHeading.StayConnect.value),
				"Element Locator :" + locator + " Not found");
		Assert.assertTrue(
				isTextPresent(Locator.Home.Give_Us_Feedback.value, Strings.SectionHeading.Give_Feedback.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Enter email id and click on Sign Up for Newsletter subscription.
	 */
	public void newsletterSignUp() {
		print("Enter Email id and click On Sign Up under Stay Connect");
		String email = email();
		locator = Locator.Home.Enter_Email.value;
		sendKeys(locator, email);
		clickOn(Locator.Home.Sign_Up_Button.value);
		// sleep(2000);
	}

	/**
	 * Assert newsletter sign up confirmation message.
	 */
	public void assertNewsletterConfirmationMessage() {
		print("Assert Nesletter Confirmation Message");
		locator = Locator.Home.Newsletter_SignUp_ConfirmatioMessage.value;
		waitForElementPresentInDom(5);
		Assert.assertTrue(isTextPresent(locator, Strings.Messages.Newsletter_Signup.value),
				"Element Locator :" + locator + " Not found");

	}

	/**
	 * Assert Top Makes, Model And Types Section at home page.
	 */
	public void assertTopMakeModelAndTypesSection() {
		this.assertTopMakesSection();
		this.assertTopModelSection();
		this.assertTopTypeSection();
	}

	/**
	 * Assert all sections in footer section.
	 */
	public void assertSectionsInFooter() {
		print("Assert sections in footer");
		Assert.assertTrue(
				isTextPresent(Locator.Home.Explore_CycleTrader.value, Strings.SectionHeading.Explore_CycleTrader.value),
				"Element Locator :" + Locator.Home.Explore_CycleTrader.value + " Not found");
		Assert.assertTrue(
				isTextPresent(Locator.Home.CycleTrader_Newsletter.value,
						Strings.SectionHeading.CycleTrader_Newsletter.value),
				"Element Locator :" + Locator.Home.CycleTrader_Newsletter.value + " Not found");
		Assert.assertTrue(
				isTextPresent(Locator.Home.CycleTrader_Affiliates.value,
						Strings.SectionHeading.CycleTrader_Affiliates.value),
				"Element Locator :" + Locator.Home.CycleTrader_Affiliates.value + " Not found");
		Assert.assertTrue(isTextPresent(Locator.Home.Dealer_Fuel.value, Strings.SectionHeading.Dealer_Fuel.value),
				"Element Locator :" + Locator.Home.Dealer_Fuel.value + " Not found");
		Assert.assertTrue(isTextPresent(Locator.Home.FollowUs.value, Strings.SectionHeading.Follow_US.value),
				"Element Locator :" + Locator.Home.FollowUs.value + " Not found");
		// Assert.assertTrue(isElementPresent(Locator.Home.Give_Feedback.value));
		Assert.assertTrue(isTextPresent(Locator.Home.Career.value, Strings.Button.Career.value),
				"Element Locator :" + locator + " Not found");
	}

	/**
	 * Click on All links under Top Makes section and assert result page.
	 */
	public void clickOnTopMakesLinksAndAssertResultPage() {
		print("Click on All links under Top Makes/Model section and assert result page");
		int length = getWebDriver().findElements(By.xpath("(//div[contains(@class,'topLinks')]/div)[1]//li")).size();
		System.out.println(length);
		for (int i = 1; i <= length; i++) {
			waitForElementPresentInDom(2);
			locator = "(//div[contains(@class,'topLinks')]/div)[1]//li[" + i + "]/a";
			String text = getText(locator);
			System.out.println(text);
			String[] text2 = text.split(" ");
			String Finaltext = text2[text2.length - 1].toLowerCase();
			clickOn(locator);
			String expected = getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText().toLowerCase();
			Assert.assertTrue(expected.contains(Finaltext));
			this.clickOnApplicationLogo();
		}
	}

	/**
	 * Click on All links under Top Makes/Model section and assert result page
	 */
	public void clickOnTopModelLinksAndAssertResultPage() {
		print("Click on All links under Top Makes/Model section and assert result page");
		int length = getWebDriver().findElements(By.xpath("(//div[contains(@class,'topLinks')]/div)[2]//li")).size();
		System.out.println(length);
		for (int i = 1; i <= length; i++) {
			waitForElementPresentInDom(2);
			locator = "(//div[contains(@class,'topLinks')]/div)[2]//li[" + i + "]/a";
			String text = getText(locator);
			System.out.println(text);
			String[] text2 = text.split(" ");
			String Finaltext = text2[text2.length - 1].toLowerCase();
			clickOn(locator);
			String expected = getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText().toLowerCase();
			Assert.assertTrue(expected.contains(Finaltext));
			this.clickOnApplicationLogo();
		}
	}

	/**
	 * Click on All links under Top Makes/Model section and assert result page.
	 */
	public void clickOnTopTypesLinksAndAssertResultPage() {
		print("Click on All links under Top Makes/Model section and assert result page");
		int length = getWebDriver().findElements(By.xpath("(//div[contains(@class,'topLinks')]/div)[3]//li")).size();
		System.out.println(length);
		for (int i = 1; i <= length; i++) {
			waitForElementPresentInDom(2);
			locator = "(//div[contains(@class,'topLinks')]/div)[3]//li[" + i + "]/a";
			String text = getText(locator);
			System.out.println(text);
			String[] text2 = text.split(" ");
			String Finaltext = text2[text2.length - 1].toLowerCase();
			clickOn(locator);
			String expected = getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText().toLowerCase();
			Assert.assertTrue(expected.contains(Finaltext));
			this.clickOnApplicationLogo();
		}
	}

	/**
	 * Click on All links under Top Makes/Model section and assert result page.
	 */
	public void clickOnExploreLinksAndAssertResultPage() {
		print("Click on All links under Top Makes/Model section and assert result page");
		int length = getWebDriver().findElements(By.xpath("(//*[contains(@class,'footerList')])[1]/li")).size();
		System.out.println(length);
		for (int i = 1; i <= length; i++) {
			waitForElementPresentInDom(2);
			locator = "(//*[contains(@class,'footerList')])[1]/li[" + i + "]/a";
			String text = getText(locator);
			System.out.println(text);
			//String[] text2 = text.split(" ");
			//String Finaltext = text2[text2.length - 1].toLowerCase();
			clickOn(locator);
			// String expected =
			// getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText().toLowerCase();
			// Assert.assertTrue(expected.contains(Finaltext));
			getWebDriver().findElement(By.cssSelector("body")).sendKeys(Keys.ALT + "PageDownLeftArrow");
		}
	}

	/**
	 * Click on Email Us button under Give Us Feedback Section.
	 */
	public void assertEmailUSButtonLinkUnderGiveUsFeedback() {
		print("Click on Email Us button under Give Us Feedback Section.");
		//clickOn(Locator.Home.Email_Us_Feedback.value);
		waitForElementPresentInDom(5);
		String string = getWebDriver().findElement(ByLocator(Locator.Home.Email_Us_Feedback.value)).getAttribute("href");
		System.out.println(string);
		String emailID="cyclemobilefeedback@cycletrader.com";
		Assert.assertTrue(string.contains(emailID));
}

	/**
	 * Click on trader Affiliates links and assert result page.
	 */
	@SuppressWarnings("unused")
	public void traderAffiliatesLinksAndAssertResultPage() {
		int length = getWebDriver().findElements(By.xpath("(//*[contains(@class,'footerList')])[3]/li")).size();
		System.out.println(length);
		for (int i = 1; i <= length; i++) {
			waitForElementPresentInDom(2);
			locator = "(//*[contains(@class,'footerList')])[3]/li[" + i + "]/a";
			String text = getText(locator);
			System.out.println(text);
			String[] text2 = text.split(" ");
			String Finaltext = text2[text2.length - 1].toLowerCase();
			clickOn(locator);
			waitForElementPresentInDom(5);
			Set<String> allWin = getWebDriver().getWindowHandles();
			String parentWindow = getWebDriver().getWindowHandle();
			for (String childWindow : allWin) {
				if (!childWindow.equalsIgnoreCase(parentWindow)) {
					getWebDriver().switchTo().window(childWindow);
					String url = getWebDriver().getCurrentUrl();
					String affiliPage = "(//div/*[contains(text(),'Advanced Search')])[1]";
					waitForElementPresentInDom(5);
					// Assert.assertTrue(isElementPresent(affiliPage));
					System.out.println(url);
					// String expected =
					// getWebDriver().findElement(By.xpath("//*[@id='topicTitle']")).getText().toLowerCase();
					// Assert.assertTrue(expected.contains(Finaltext));
					getWebDriver().findElement(By.cssSelector("html")).sendKeys(Keys.COMMAND + "w");
					getWebDriver().switchTo().window(parentWindow);
				}
			}
		}
	}

	/**
	 * Enter email is and click on SignUp button.
	 */
	public void newsletterSubscription() {
		print("Enter email is and click on SignUp button");
		String emailID = email();
		sendKeys(Locator.Home.Newsletter_Email.value, emailID);
		waitForElementPresentInDom(2);
		clickOn(Locator.Home.Newsletter_SignUp.value);
		waitForElementPresentInDom(2);
		Assert.assertTrue(
				isTextPresent(Locator.Home.Newsletter_SignUp_ConfirmatioMessage.value,
						Strings.Messages.Newsletter_Signup.value),
				"Element Locator :" + Locator.Home.Newsletter_SignUp_ConfirmatioMessage.value + " Not found");
	}

	/**
	 * Click On DealerLogin_SignUp Button And Assert Result Page.
	 * 
	 * @throws AWTException
	 */
	public void clickOnDealerLogin_SignUpButtonAndAssertResultPage() throws AWTException {
		print("Click On DealerLogin_SignUp Button And Assert Result Page");
		String dealerLogin_SignUp = Locator.Home.Dealer_Login_Signup.value;
		clickOn(dealerLogin_SignUp);
		waitForElementPresentInDom(5);
		locator = Locator.Home.Dealer_Centre.value;
		System.out.println(getText(locator));
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Dealer_Centre.value),
				"Element Locator :" + locator + " Not found");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_LEFT);
	}

	/**
	 * Click On Dealer Search Button And Assert Result Page.
	 * @throws AWTException
	 */
	public void clickOnDealerSearchButtonAndAssertResultPage() throws AWTException {
		print("Click On Dealer Search Button And Assert Result Page");
		String dealerSearch = Locator.Home.Dealer_Search.value;
		waitForElementPresentInDom(5);
		clickOn(dealerSearch);
		locator = Locator.Dealer.Find_Motorcyle_Dealer.value;
		WaitForElementVisible(locator, 20);
		Assert.assertTrue(isTextPresent(locator, Strings.PageName.Find_Motorcycle_Dealers.value),
				"Element Locator :" + locator + " Not found");
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ALT);
		r.keyRelease(KeyEvent.VK_LEFT);
	}

	/**
	 * Click On All Social Site Icon And Assert Result Page.
	 */
	public void clickOnAllSocialSiteIconAndAssertResultPage() {
		print("Click On All Social Site Icon And Assert Result Page.");
		int length = getWebDriver().findElements(By.xpath("//*[contains(@class,'socialLinks')]/a")).size();
		System.out.println(length);

		for (int i = 1; i <= length; i++) {
			waitForElementPresentInDom(2);
			locator = "//*[contains(@class,'socialLinks')]/a[" + i + "]/i";
			String text = getText(locator);
			System.out.println(text);
			clickOn(locator);
			waitForElementPresentInDom(5);
			Set<String> allWin = getWebDriver().getWindowHandles();
			String parentWindow = getWebDriver().getWindowHandle();
			for (String childWindow : allWin) {
				if (!childWindow.equalsIgnoreCase(parentWindow)) {
					getWebDriver().switchTo().window(childWindow);
					String url = getWebDriver().getCurrentUrl();
					waitForElementPresentInDom(5);
					// Assert.assertTrue(isElementPresent(affiliPage));
					System.out.println(url);
					getWebDriver().switchTo().window(parentWindow);
				}
			}
		}
	}
	
	/**
	 * Assert Give Trader Feedback Button Link.
	 */
	public void assertGiveTraderFeedbackButtonLink() {
		print("Assert Give Trader Feedback Button Link.");
		waitForElementPresentInDom(5);
		locator=Locator.Home.Give_Trader_Feedback.value;
		String string = getWebDriver().findElement(ByLocator(locator)).getAttribute("href");
		System.out.println(string);
		String emailID="cyclemobilefeedback@cycletrader.com";
		Assert.assertTrue(string.contains(emailID));
	}

	/**
	 * Click On Career Link And Assert Result Page.
	 */
	public void clickOnCareerLinkAndAsssertResultPage() {
		print("click On Career Link And Asssert Result Page");
		clickOn(Locator.Home.Career.value);
		Assert.assertTrue(isElementPresent(Locator.Home.Careers_ResultPage.value));
	}

	/**
	 * click On Footer Logo And Assert Result Page
	 */
	public void clickOnFooterLogoAndAssertResultPage() {
		print("click On Footer Logo And Assert Result Page");
		String url = "https://www.cycletrader.com/";
		clickOn(Locator.Home.Footer_Logo.value);
		String url1 = getWebDriver().getCurrentUrl();
		System.out.println(url1);
		Assert.assertEquals(url, url1);
	}

	public List<String> getFooterLinks() {
		EnumSet<FooterLinks> all = EnumSet.allOf(FooterLinks.class);
		List<String> list = new ArrayList<>(all.size());
		for (FooterLinks fl : all) {
			list.add(fl.value);
		}
		return list;
	}

	public void assertFooterLinks() {
		List<String> allFooterLinksList = getFooterLinks();
		for (String footerLinksList : allFooterLinksList) {
			locator = "//a[contains(text(),'" + footerLinksList + "')]";
			print("Footer Links Name: " + footerLinksList + "'");
			Assert.assertTrue(isElementPresent(locator));
		}
	}

	public void clickFooterLinksAndAssertResultPage() throws AWTException {
		List<String> allFooterLinksList = getFooterLinks();
		Robot r = new Robot();
		for (String footerLinksList : allFooterLinksList) {
			locator = "//a[contains(text(),'" + footerLinksList + "')]";
			print("Footer Links Name: " + footerLinksList + "'");
			Assert.assertTrue(isElementPresent(locator));
			clickOn(locator);
			waitForElementPresentInDom(5);
			Set<String> allWin = getWebDriver().getWindowHandles();
			String parentWindow = getWebDriver().getWindowHandle();
			for (String childWindow : allWin) {
				if (!childWindow.equalsIgnoreCase(parentWindow)) {
					getWebDriver().switchTo().window(childWindow);
					String url = getWebDriver().getCurrentUrl();
					waitForElementPresentInDom(5);
					System.out.println(url);
					
					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_W);
					getWebDriver().switchTo().window(parentWindow);
				}
			}
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_W);
		}
	}
	
	/**
	 * Assert Find Motorcycles For Sale Section.
	 */
	public void assertFindMotorcyclesForSaleSection() {
		print("Assert Find Motorcycles For Sale Section");
		locator=Locator.Home.Motorcycle_Sale.value;
		Assert.assertTrue(isTextPresent(locator, Strings.SectionHeading.Find_Motorcycle_Sale.value),
				"Element Locator :" + locator + " Not found");
	}
	
	/**
	 * Click On find MotorCycle For Sale Link.
	 */
	public void clickOnfindMotorCycleForSaleLink() {
		print("Click On find MotorCycle For Sale Link ");
		locator=Locator.Home.Motorcycle_Sale.value;
		clickOn(locator);
	}
}