package com.trader.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.trader.stringdata.Strings.Button;

public class DriverHelper extends DriverTestCase {

	// Define objects
	private WebDriver driver;
	protected PropertyReader propertyReader = new PropertyReader();

	// Declare objects
	public DriverHelper(WebDriver webdriver, SoftAssert sa) {
		driver = webdriver;
		softAssert = sa;
	}

	// Return web driver object
	public WebDriver getWebDriver() {
		return driver;
	}

	/**
	 * Returns string representing the text contents of a list of web elements..
	 * 
	 * @param ElementList
	 *            - WebElement list. Elements should contain text.
	 * @param Delimiter
	 *            - Delimiter used to separate each list element
	 * @param doTrim
	 *            - Defaults to false
	 * @return
	 */
	public String getElementListText(List<WebElement> ElementList, String Delimiter, Boolean doTrim) {
		String ListString = "";
		if (ElementList.size() == 0)
			return "";
		// Build the string
		for (WebElement i : ElementList) {
			if (doTrim)
				ListString = ListString + Delimiter + i.getText().trim();
			else
				ListString = ListString + Delimiter + i.getText();
		}
		// Return the string, but subtract the first delimiter so it looks a
		// little nicer
		return ListString.substring(Delimiter.length());
	}

	public String getElementListText(List<WebElement> ElementList, String Delimiter) {
		return getElementListText(ElementList, Delimiter, false);
	}

	/**
	 * Sleep use this if you don't feel like dealing with the
	 * 'InterruptedException'.
	 */
	public void sleep(Integer millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public String getButtonLocator(String button) { return
	 * "//*[contains(@class,'x-button-label') and text()='" + button + "']"; }
	 * 
	 * public String getButtonLocator(Button button) { return
	 * this.getButtonLocator(button.value); }
	 */
	/**
	 * Click on a button containing specified text within a specified dialog
	 * 
	 * @param matchExact
	 *            - Match button text exactly or contains
	 * @param dialogLocator
	 *            - String locator of the dialog containing the button
	 * @param buttonText
	 *            - The button text for the button you want to click on
	 * @param doWait
	 *            - waitForLoading after button click or not
	 */
	public void clickButton(Boolean matchExact, String dialogLocator, String buttonText, Boolean doWait) {
		print("Click on '" + buttonText + "' Button");
		String buttonLocator = "";
		// buttonLocator = this.getButtonLocator(buttonText);
		WebElement button = this.getFirstVisible(dialogLocator + buttonLocator, 20, false);
		// Click the button or throw an assertion failure if there is no button
		// to click
		if (button != null)
			button.click();
		else
			Assert.fail("Button '" + buttonText + "' not found.");		
	}

	public void clickButton(String dialogLocator, String buttonText) {
		clickButton(true, dialogLocator, buttonText, true);
	}

	public void clickButton(String dialogLocator, Button button) {
		clickButton(true, dialogLocator, button.value, true);
	}

	public void clickButton(Boolean matchExact, String buttonText, Boolean doWait) {
		clickButton(matchExact, "", buttonText, doWait);
	}

	public void clickButton(String buttonText, Boolean doWait) {
		clickButton(true, "", buttonText, doWait);
	}

	public void clickButton(Button button, Boolean doWait) {
		clickButton(true, "", button.value, doWait);
	}

	public void clickButton(String buttonText) {
		clickButton(true, "", buttonText, true);
	}

	public void clickButton(Button button) {
		clickButton(true, "", button.value, true);
	}

	public Boolean isButtonDisplayed(Button button) {
		return this.isElementDisplayed("//button[text()='" + button.value + "']");
	}	

	/**
	 * Checks a checkbox
	 * 
	 * @param labelText
	 *            here, wait is defaulted to True
	 */
	public void toggleCheckBox(String labelText) {
		this.toggleCheckBox(labelText, true);
	}

	/**
	 * Checks a checkbox
	 * 
	 * @param labelText
	 *            - Text should match with the text dispalyed in application
	 * @param doWait
	 */
	public void toggleCheckBox(String labelText, Boolean doWait) {
		print("Check box for setting: '" + labelText + "'");
		String checkBoxLocator = "//label[contains(@class,'x-form-') and text()='" + labelText + "']";
		this.getFirstVisible(checkBoxLocator, 30).click();
		
	}

	// Print message on screen
	public void Log(String logMsg) {
		System.out.println(logMsg);
	}

	// Handle locator type
	public By ByLocator(String locator) {
		By result = null;
		if (locator.startsWith("//") || (locator.startsWith("/") || locator.startsWith("(//"))) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.name(locator.replace("#", ""));
		} else if (locator.startsWith("Link=")) {
			result = By.linkText(locator.replace("Link=", ""));
		} else {
			result = By.id(locator);
		}
		return result;
	}

	/**
	 * Returns true if the element is present. Set the timeout to zero if you
	 * don't want to wait for the element to become present.
	 * 
	 * @param locator
	 *            - String
	 * @param timeOut
	 *            - Integer
	 * @return
	 */
	public boolean isElementPresent(String locator) {
		return isElementPresent(locator, 30);
	}

	/**
	 * Returns true if the element is present. Set the timeout to zero if you
	 * don't want to wait for the element to become present.
	 * 
	 * @param locator
	 *            - String
	 * @param timeOut
	 *            - Integer
	 * @return
	 */
	public boolean isElementPresent(String locator, Integer timeOut) {
		getWebDriver().manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		return getWebDriver().findElements(ByLocator(locator)).size() != 0;
	}

	// Wait for element present
	public void WaitForElementPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator, 0)) {
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// * Wait for an element not to be present.
	public void WaitForElementNotPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (!isElementPresent(locator, 0)) {
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Wait for an element not to be present. Does not use implicit wait like
	 * 'waitForElementNotPresent'
	 * 
	 * @param locator
	 * @param timeout
	 *            - Seconds to wait
	 * @return - Boolean: Returns false if the wait times out
	 */
	public Boolean WaitForNotPresent(String locator, int timeout) {
		// I doubled 'timeout' cause we sleep for 500 miliseconds.
		// This way 'timeout' is measured in seconds
		for (int i = 0; i < timeout * 2; i++) {
			if (!isElementPresent(locator, 0)) {
				// We are done waiting
				return true;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// If we've timed out, then return false
		return false;
	}

	/**
	 * Wait until an element is not displayed..
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public Boolean WaitForNotVisible(String locator, int timeout) {
		// Loop until timeout, or until the element is no longer visible.
		for (int i = 0; i < timeout; i++) {
			// Return true if the element is not displayed, or if the
			// element is not present..
			try {
				if (!getWebDriver().findElement(ByLocator(locator)).isDisplayed()) {
					return true;
				}
			} catch (org.openqa.selenium.NoSuchElementException e) {
				return true;
			} catch (org.openqa.selenium.StaleElementReferenceException e) {
				// do nothing (sleep for 1 more second and try again)
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	// Wait for element enabled
	public void WaitForElementEnabled(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator, 0)) {
				if (getWebDriver().findElement(ByLocator(locator)).isEnabled()) {
					break;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Wait for element not enabled
	public void WaitForElementNotEnabled(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator, 0)) {
				if (!getWebDriver().findElement(ByLocator(locator)).isEnabled()) {
					break;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Wait for element visible
	public void WaitForElementVisible(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator, 0)) {
				if (getWebDriver().findElement(ByLocator(locator)).isDisplayed()) {
					break;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * getFirstVisible with a default timeout of 10 seconds.
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement getFirstVisible(String locator) {
		return this.getFirstVisible(locator, 30);
	}

	/**
	 * Return the FIRST element to become visible..
	 * 
	 * @param locator
	 *            - String locator of the element
	 * @param timeout
	 *            - Integer
	 * @return - Returns the FIRST visible element it finds or null
	 */
	public WebElement getFirstVisible(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator, 0)) {
				List<WebElement> el = getWebDriver().findElements(ByLocator(locator));
				for (WebElement j : el) {
					if (j.isDisplayed()) {
						return j;
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("No visible elements found..");
		return null;
	}

	/**
	 * Return the FIRST element to become visible..
	 * 
	 * @param locator
	 *            - String locator of the element
	 * @param timeout
	 *            - Integer
	 * @param doAssertFound
	 * @return - Returns the FIRST visible element it finds or null
	 */
	public WebElement getFirstVisible(String locator, int timeout, Boolean doAssertFound) {
		return this.getFirstVisible(locator, (double) timeout, doAssertFound);
	}

	public WebElement getFirstVisible(String locator, Double timeout, Boolean doAssertFound) {
		for (int i = 0; i < timeout * 10; i++) {
			if (isElementPresent(locator, 0)) {
				List<WebElement> el = getWebDriver().findElements(ByLocator(locator));
				for (WebElement j : el) {
					try {
						if (j.isDisplayed()) {
							return j;
						}
					} catch (org.openqa.selenium.StaleElementReferenceException e) {
						// do nothing (sleep for 1 more second and try again)
					}
				}
			}
			this.sleep(1000);
		}
		// To avoid null pointer exceptions when we use this method, allow the
		// option to fail when no element is found
		if (doAssertFound)
			Assert.fail("Element not found '" + locator + "'");
		return null;
	}

	// is Element enabled
	public boolean isElementEnabled(String locator) {
		boolean isEnabled = getWebDriver().findElement(ByLocator(locator)).isEnabled();
		return isEnabled;
	}

	/**
	 * @param locator
	 * @return
	 */
	public boolean isElementDisplayed(String locator) {
		boolean status = false;
		if (isElementPresent(locator)) {
			if (getWebDriver().findElement(ByLocator(locator)).isDisplayed()) {
				status = true;
			}
		}
		return status;
	}

	// Wait for element not visible
	public void WaitForElementNotVisible(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {

			if (!this.isElementDisplayed(locator)) {
				break;
			}
			;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Wait for text present
	public void WaitForTextPresent(String locator, String text, int timeout) {
		WaitForElementPresent(locator, timeout);
		for (int i = 0; i < timeout; i++) {
			if (isTextPresent(locator, text)) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Handle mouse over action
	public void mouseOver(String locator) {
		WebElement el = this.getWhenPresent(locator, 50);
		// build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(getWebDriver());
		builder.moveToElement(el).build().perform();
	}

	/**
	 * @author Vivek
	 * To click on Web element
	 * This is using double click to click on an element
	 * @param element
	 * 
	 */

	public void mouseOverClick(WebElement element) {
		Actions builder = new Actions(getWebDriver());
		builder.moveToElement(element).click().build().perform();
	}

	public void mouseOverClick(String locator) {
		WebElement el = this.getWhenPresent(locator, 50);
		Actions builder = new Actions(getWebDriver());
		builder.moveToElement(el).click().build().perform();
	}

	public void mouseOverDoubleClick(WebElement element) {
		Actions builder = new Actions(getWebDriver());
		builder.moveToElement(element).perform();
		builder.doubleClick().perform();
	}

	public void mouseOverDoubleClick(String locator) {
		WebElement el = this.getWhenPresent(locator, 50);
		Actions builder = new Actions(getWebDriver());
		builder.moveToElement(el).perform();
		builder.doubleClick().perform();
	}

	// Handle mouse over action
	public void mouseOver(String locator, Integer xPos, Integer yPos) {
		WebElement el = this.getWhenPresent(locator, 50);
		// build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(getWebDriver());
		builder.moveToElement(el, xPos, yPos).build().perform();
	}

	/**
	 * Moves the mouse a specified number of pixels
	 * 
	 * @param xOffset
	 * @param yOffset
	 */
	public void moveMouse(Integer xOffset, Integer yOffset) {
		// build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(getWebDriver());
		builder.moveByOffset(xOffset, yOffset).build().perform();
	}

	// Handle drag by offset action
	public void dragAndDropBy(String locator, int xOffset, int yOffset) {
		WebElement el = this.getWhenPresent(locator, 50);
		// build and perform drag and drop with Advanced User Interactions API
		Actions builder = new Actions(getWebDriver());
		// 'dragAndDropBy' stopped working in chrome..
		// This is a work around..
		builder.clickAndHold(el);
		builder.moveByOffset(xOffset, yOffset);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		builder.release().perform();
	}

	// Handle drag and drop action
	public void dragAndDrop(String draggable, String to) {
		this.WaitForElementPresent(draggable, 50);
		this.WaitForElementPresent(to, 50);
		WebElement elDraggable = getWebDriver().findElement(ByLocator(draggable));
		WebElement todrag = getWebDriver().findElement(ByLocator(to));
		// build and perform drag and drop with Advanced User Interactions API
		Actions builder = new Actions(getWebDriver());
		builder.dragAndDrop(elDraggable, todrag).perform();
	}
	
	public void selectDropDownByValue(String locator, String targetValue){ 
		Assert.assertTrue(isElementPresent(locator),"Element Locator :"+locator+" Not found");
		this.WaitForElementPresent(locator, 30);
		new Select(getWebDriver().findElement(ByLocator(locator))).selectByVisibleText(targetValue);
		
    }
	
	public void selectDropDownByVisibleText(String locator, String text) {
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 30);
		new Select(getWebDriver().findElement(ByLocator(locator)))
				.selectByVisibleText(text);
	}
	
	public void selectDropDownByIndex(String locator, int index) {
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		Select dropdown = new Select(driver.findElement(By.id(locator)));
		dropdown.selectByIndex(index);
	}

	/**
	 * Scrolls an element into view
	 * 
	 * @param elementLocator
	 *            - XPath locator of element
	 */
	public void scrollIntoView(String elementLocator) {
		WebElement element = this.getWhenVisible(elementLocator);
		scrollIntoView(element);
	}

	/**
	 * Scrolls an element into view
	 * 
	 * @param element
	 *            - WebElement
	 */
	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(false);", element);
	}

	/**
	 * @param locator
	 *            -The container that contains the overflow
	 */
	public void assertVerticalScrollBarPresent(String locator) {
		// may need to use getWhenPresent.. Inner container may not be visible,
		// but so far no problems
		WebElement container = this.getWhenVisible(locator);
		boolean verticalScrollBarPresent = (Boolean) ((JavascriptExecutor) getWebDriver())
				.executeScript("return arguments[0].scrollHeight>arguments[0].clientHeight;", container);
		Assert.assertTrue(verticalScrollBarPresent, "Vertical scroll bar is not present - ");
	}

	// Get Element count
	public Integer getElementCount(String locator) {
		WaitForElementPresent(locator, 50);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		return driver.findElements(ByLocator(locator)).size();
	}

	// Get Count and Dragby name
	public int getlistcount(String locator) {
		List<WebElement> getlistcount = getWebDriver().findElements(ByLocator(locator));
		int returnlistcount = getlistcount.size();
		return returnlistcount;
	}

	public List<WebElement> getlist(String locator) {
		List<WebElement> getlist = getWebDriver().findElements(ByLocator(locator));
		return getlist;
	}

	// Handle click action
	public void clickOn(String locator) {
		//clickOn(locator, false);
		waitForElementPresentInDom(3);
		this.WaitForElementPresent(locator, 50);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		el.click();
	}

	public void clickOn(String locator, boolean doWait) {
		WebElement el = this.getFirstVisible(locator);
		el.click();
		
		
	}

	public void clickOn(WebElement element) {
		element.click();
	} 

	// Method used to getClassName
	public String storeClassName(String locator) {
		String className = getAttribute(locator, "class");
		System.out.println("Class Name displayed: " + className);
		return className;
	}

	/**
	 * Wait for an element to be visible and then return the element. Timeout
	 * defaults to 10 seconds..
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement getWhenVisible(String locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByLocator(locator)));
		return element;
	}

	/**
	 * Wait for an element to be visible and then return the element. Timeout
	 * defaults to 10 seconds..
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement getWhenVisible(String locator) {
		return getWhenVisible(locator, 50);
	}

	/**
	 * Returns a WebElement after waiting for it to be present.
	 * 
	 * @param locator
	 * @param timeout
	 *            - Defaults to 10 seconds
	 * @return
	 */
	public WebElement getWhenPresent(String locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ByLocator(locator)));
		return element;
	}

	/**
	 * Returns a WebElement after waiting for it to be present.
	 * 
	 * @param locator
	 * @param timeout
	 *            - Defaults to 10 seconds
	 * @return
	 */
	public WebElement getWhenPresent(String locator) {
		return getWhenPresent(locator, 30);
	}

	// Handle send keys action
	public void sendKeys(String locator, String text) {
			this.WaitForElementPresent(locator, 50);
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			WebElement el = getWebDriver().findElement(ByLocator(locator));
		el.sendKeys(Keys.CONTROL + "a");
		// el.sendKeys(Keys.DELETE);
		// el.clear();
			el.sendKeys(text);
		}
	

	public int getSize(String locator) {
		this.WaitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		int total = getWebDriver().findElements(ByLocator(locator)).size();
		return total;
	}

	public void waitForExportLoading() {
		locator = "css=.ext-mb-text";
		WaitForElementNotPresent(locator, 200);
		ExecutionLog.Log("Wait Completed");
	}

	public void Clickandselect(String locator, String targetValue) {
		clickOn(locator);
		new Select(getWebDriver().findElement(ByLocator(locator))).selectByVisibleText(targetValue);
	}

	/**
	 * Check to see if specific text is present within a specific element.
	 * 
	 * @param locator
	 *            - XPath locator of element
	 * @param str
	 *            - Text to verify
	 * @return
	 */
	public boolean isTextPresent(String locator, String str) {
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		String message = getWebDriver().findElement(ByLocator(locator)).getText();
		if (message.contains(str)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Triggers an assertion error if the specified text is found on the page.
	 * 
	 * @param text
	 */
	public void verifyTextNotPresent(String text) {
		String message = getWebDriver().findElement(ByLocator("//body")).getText();
		Assert.assertFalse(message.contains(text), "The text '" + text + "' is present:");
		System.out.println(text + " is not found");
		ExecutionLog.Log(text + " is not found");
	}

	/**
	 * Assert that the specified text is not present in the page source. This
	 * assertion ignores case.
	 * 
	 * @param text
	 *            - Text to assert
	 */
	public void assertTextNotPresentIgnoreCase(String text) {
		Boolean isTextPresent = getWebDriver().getPageSource().toLowerCase().contains(text.toLowerCase());
		Assert.assertFalse(isTextPresent, "The text '" + text + "' is present.");
		ExecutionLog.Log("The text '" + text + "' is not present.");
	}

	/**
	 * Assert that the specified text is not present in the page source by
	 * ignoring case.
	 * 
	 * @param text
	 *            - Text to assert
	 */
	public void assertTextPresentIgnoreCase(String text) {
		Boolean isTextPresent = getWebDriver().getPageSource().toLowerCase().contains(text.toLowerCase());
		Assert.assertTrue(isTextPresent, "The text '" + text + "' is NOT present.");
		ExecutionLog.Log("The text '" + text + "' is NOT present.");
	}

	/**
	 * Asserts whether specified text is present on the page. Note that this is
	 * case sensative.
	 * 
	 * @param text
	 */
	public void verifyTextPresent(String text) {
		Boolean isTextPresent = getWebDriver().getPageSource().contains(text);
		Assert.assertTrue(isTextPresent, "The text '" + text + "' is not present.");
		ExecutionLog.Log("The text '" + text + "' is not present.");
	}

	// Retrieve text from a locator
	public String getText(String locator) {
		return getText(locator, 30);
	}

	// Store text from a locator
	public String getText(String locator, Integer timeOut) {
		WaitForElementPresent(locator, timeOut);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		String text = getWebDriver().findElement(ByLocator(locator)).getText();
		return text;
	}

	public String getVisibleText(String locator, Integer timeOut) {
		String text = getFirstVisible(locator, timeOut).getText();
		return text;
	}

	/**
	 * Get the text of an element without getting the text of the child elements
	 * 
	 * @param element
	 * @return
	 */
	public String getNodeText(String locator) {
		WebElement element = getWebDriver().findElement(ByLocator(locator));
		String text = element.getText();
		for (WebElement child : element.findElements(By.xpath("./*"))) {
			text = text.replaceFirst(Pattern.quote(child.getText()), "");
		}
		return text;
	}

	/**
	 * Get the text of an element without getting the text of the child elements
	 * 
	 * @param element
	 * @return
	 */
	public String getNodeText(WebElement element) {
		String text = element.getText();
		for (WebElement child : element.findElements(By.xpath("./*"))) {
			text = text.replaceFirst(Pattern.quote(child.getText()), "");
		}
		return text;
	}

	// Assert check box selected
	public boolean isChecked(String locator) {
		boolean checkStatus = false;
		WaitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		checkStatus = el.isSelected();
		return checkStatus;
	}

	// Get attribute value
	public String getAttribute(String locator, String attribute) {
		this.getWhenPresent(locator, 30);
		String attributeValue = getWebDriver().findElement(ByLocator(locator)).getAttribute(attribute);
		return attributeValue;
	}

	// Execute java script
	public void javaScriptExecute(String javascrpt) {
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		js.executeScript(javascrpt);
	}

	public void acceptAlert_() {
		sleep(1000);
		Alert alert = getWebDriver().switchTo().alert();
		alert.accept();
		sleep(2000);
	}

	/**
	 * @param locator
	 * @param doWait
	 *            - Boolean
	 */
	public void doubleClickOn(String locator, Boolean doWait) {
		WebElement el = this.getWhenVisible(locator);
		// build and perform the mouse click with Advanced User Interactions API
		Actions builder = new Actions(getWebDriver());
		builder.doubleClick(el).build().perform();
	}

	/**
	 * @author Vivek
	 * @param locator
	 * @param doWait
	 *            - Boolean
	 */
	public void mouseClickOn(String locator, Boolean doWait) {
		WebElement el = this.getWhenVisible(locator);
		// build and perform the mouse click with Advanced User Interactions API
		Actions builder = new Actions(getWebDriver());
		builder.click(el).build().perform();
	}

	/**
	 * Double click an element at specific coordinates (no waits)
	 * Using double click
	 * @param locator
	 * @param xPos
	 * @param yPos
	 */
	public void actionClassClick(String locator, Integer xPos, Integer yPos) {
		print("Double click element '" + locator + "' at coords (" + xPos + "," + yPos + ")");
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		Actions builder = new Actions(getWebDriver());
		builder.moveToElement(el, xPos, yPos).perform();
		this.sleep(2000);
		builder.doubleClick().perform();
	}

	/**
	 * Click an element at specific coordinates (no waits)
	 * Using Single Click
	 * @param locator
	 * @param xPos
	 * @param yPos
	 */
	public void clickAt(String locator, Integer xPos, Integer yPos) {
		print("Click element '" + locator + "' at coords (" + xPos + "," + yPos + ")");
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		Actions builder = new Actions(getWebDriver());
		builder.moveToElement(el, xPos, yPos).click().perform();
	}

	/**
	 * @param locator
	 * @param doWait
	 *            - Boolean
	 */
	public void doubleClickOn(String locator) {
		doubleClickOn(locator, true);
	}

	// Verify an element is available
	public boolean verifyElementPresent(String locator) {
		Boolean isPresent = isElementPresent(locator);
		Assert.assertTrue(isPresent, "Element Locator :" + locator);
		return isPresent;
	}

	// Verify an element is unavailable
	public boolean verifyElementNotPresent(String locator) {
		Boolean isPresent = isElementPresent(locator);
		Assert.assertFalse(isElementPresent(locator), "Element Locator :" + locator + " found");
		return isPresent;
	}

	// Verify an element is disabled
	public void assertElementDisabled(String locator) {
		verifyElementPresent(locator);
		Assert.assertFalse(isElementEnabled(locator), "Element '" + locator + "' is enabled");
	}

	// Verify an element is enabled
	public void assertElementEnabled(String locator) {
		this.getWhenVisible(locator);
		Assert.assertTrue(isElementEnabled(locator), "Element '" + locator + "' is not enabled");
	}

	// Click on User Settings
	public String getUserName(String user) {
		String userName = propertyReader.readApplicationFile(user + "_User");
		return userName;
	}

	// Bring an element into focus
	public void scrollIntoFocus(String element) {
		print("Scroll to an element into focus");
		((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(false);", element);
	}

	// Get filename extension
	public String getFileExtension(String FilePath) {
		String extension = FilenameUtils.getExtension(FilePath);
		print("File Extension is : " + extension);
		return extension;
	}

	// Check running tasks
	public void killProcess(String serviceName) {
		if (isProcessRunning(serviceName))
			try {
				Runtime.getRuntime().exec("taskkill /F /IM" + serviceName + " /T");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	// Check running tasks
	public static boolean isProcessRunning(String serviceName) {
		try {
			Process p = Runtime.getRuntime().exec("tasklist");
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(serviceName))
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// send keys using keyboard via Action class
	public void sendActionKeys(Keys Key) {
		Actions action = new Actions(driver);
		action.sendKeys(Key).build().perform();
	}

	public String getFileName(String filePath) {
		File f = new File(filePath);
		String fileName = f.getName();
		System.out.println("File name: " + fileName);
		return fileName;
	}

	/**
	 * Assert an image at a specific locator matches the baseimage with the
	 * specified image name.
	 * 
	 * @param image
	 *            - image name in baseImage folder
	 * @param locator
	 * @throws IOException
	 */
	public void assertImage(String image, String locator) throws IOException {
		this.captureElementClip(locator, image);
		this.verifyElementClip(image);
	}

	public void assertImage(String image, String locator, SoftAssert softAssert) throws IOException {
		this.captureElementClip(locator, image);
		this.verifyElementClip(image, softAssert);
	}

	public void assertImage(String baseImagePath, String image, String locator, SoftAssert softAssert)
			throws IOException {
		this.captureElementClip(locator, image);
		this.verifyElementClip(baseImagePath, image, softAssert);
	}

	/**
	 * Capture an image of an element and store it in the specified folder (for
	 * use with 'verifyElementClip' to assert it equals the baseline)
	 * 
	 * @throws IOException
	 */
	public void captureElementClip(String path, String locator, String imageName) throws IOException {
		// take screen shot
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		WebElement webElement = driver.findElement(ByLocator(locator));
		Point point = webElement.getLocation();
		// get element dimension
		int width = webElement.getSize().getWidth();
		int height = webElement.getSize().getHeight();
		BufferedImage img = ImageIO.read(screen);
		BufferedImage dest = img.getSubimage(point.getX(), point.getY(), width, height);
		ImageIO.write(dest, "png", screen);
		File file = new File(path + imageName + ".png");
		FileUtils.copyFile(screen, file);
	}

	/**
	 * Capture an image of an element and store it in the /images/temp folder
	 * (for use with 'verifyElementClip' to assert it equals the baseline)
	 * 
	 * @throws IOException
	 */
	public void captureElementClip(String locator, String imageName) throws IOException {
		this.captureElementClip("images\\temp\\", locator, imageName);
	}

	/**
	 * Compare an image in the temp folder with an image in the baseline folder.
	 * Images should have the same name to keep things simple.
	 * 
	 * @throws IOException
	 */
	public Boolean verifyElementClip(String baselinePath, String tempPath, String imageName, Boolean doAssert)
			throws IOException {
		double matchPercent = this.getMatchPercent(baselinePath + imageName + ".png", tempPath + imageName + ".png");
		double tolerance = .99;
		// If the image similarity is not within tolerance:
		// output a diff image.
		// output the images to the reporter log so they show up in Jenkins logs
		// then throw an assertion failure
		if (!(matchPercent >= tolerance)) {
			generateDiffClip(imageName, imageName);
			String path = getPath() + "/images/";
			String storedImgPath = path + "baseImage/" + imageName + ".png";
			String capturedImgPath = path + "temp/" + imageName + ".png";
			String diffImgPath = path + "temp/" + imageName + "_diff.png";
			String styleImg = "border: 1px solid black;";
			String storedImgBase64 = getImageBase64String(storedImgPath, "jpg", styleImg);
			String capturedImgBase64 = getImageBase64String(capturedImgPath, "jpg", styleImg);
			String diffImgBase64 = getImageBase64String(diffImgPath, "jpg", styleImg);
			Reporter.log("<div><p><b>Percent match: " + matchPercent + "%</b></p>" + "<div style='padding:10px;' >"
					+ "<b>Old:</b><br>" + storedImgBase64 + "</div>" + "<div style='padding:10px;' >"
					+ "<b>New:</b><br>" + capturedImgBase64 + "</div>" + "<div style='padding:10px;' >"
					+ "<b>Diff:</b><br>" + diffImgBase64 + "</div>" + "<br><br><br><br><br></div>");
			// FAIL
			if (doAssert)
				Assert.fail("Image " + imageName + " does not match baseline.");
			return false;
		} else {
			// pass
			return true;
		}
	}

	public Boolean verifyElementClip(String baselinePath, String tempPath, String imageName, SoftAssert softAssert)
			throws IOException {
		double matchPercent = this.getMatchPercent(baselinePath + imageName + ".png", tempPath + imageName + ".png");
		double tolerance = .99;
		// If the image similarity is not within tolerance:
		// output a diff image.
		// output the images to the reporter log so they show up in Jenkins logs
		// then throw an assertion failure
		if (!(matchPercent >= tolerance)) {
			generateDiffClip(imageName, imageName);
			String path = getPath() + "/images/";
			String storedImgPath = path + "baseImage/" + imageName + ".png";
			String capturedImgPath = path + "temp/" + imageName + ".png";
			String diffImgPath = path + "temp/" + imageName + "_diff.png";
			String styleImg = "border: 1px solid black;";
			String storedImgBase64 = getImageBase64String(storedImgPath, "jpg", styleImg);
			String capturedImgBase64 = getImageBase64String(capturedImgPath, "jpg", styleImg);
			String diffImgBase64 = getImageBase64String(diffImgPath, "jpg", styleImg);
			Reporter.log("<div><p><b>Percent match: " + matchPercent + "%</b></p>" + "<div style='padding:10px;' >"
					+ "<b>Old:</b><br>" + storedImgBase64 + "</div>" + "<div style='padding:10px;' >"
					+ "<b>New:</b><br>" + capturedImgBase64 + "</div>" + "<div style='padding:10px;' >"
					+ "<b>Diff:</b><br>" + diffImgBase64 + "</div>" + "<br><br><br><br><br></div>");
			// FAIL
			softAssert.fail("Image " + imageName + " does not match baseline.");
			return false;
		} else {
			// pass
			return true;
		}
	}

	public Boolean verifyElementClip(String imageName) throws IOException {
		return this.verifyElementClip("images\\baseImage\\", "images\\temp\\", imageName, true);
	}

	public Boolean verifyElementClip(String imageName, Boolean doAssert) throws IOException {
		return this.verifyElementClip("images\\baseImage\\", "images\\temp\\", imageName, doAssert);
	}

	public Boolean verifyElementClip(String imageName, SoftAssert softAssert) throws IOException {
		return this.verifyElementClip("images\\baseImage\\", "images\\temp\\", imageName, softAssert);
	}

	public Boolean verifyElementClip(String baseImagePath, String imageName, SoftAssert softAssert) throws IOException {
		return this.verifyElementClip("images\\baseImage\\" + baseImagePath, "images\\temp\\", imageName, softAssert);
	}

	/**
	 * Compare two images and generate a diff image to show the differences.
	 * Assumes that ImageMagick command line tool is installed and added to
	 * windows path variable. Note: ImageMagick will return an exit code 2 if
	 * the paths are incorrect, if either of the images does not exist, OR if
	 * the images are different sizes.
	 * 
	 * @param storedImage
	 *            - The image names should be the same ideally to prevent
	 *            confusion and to maintain consistency..
	 * @param capturedImage
	 */
	public void generateDiffClip(String storedImage, String capturedImage) {
		// Build the command line
		String[] commandLineMagick = new String[] { "cmd", "/c", "compare",
				"images\\baseImage\\" + storedImage + ".png", // Baseline image
				"images\\temp\\" + capturedImage + ".png", // Current live image
				"images\\temp\\" + capturedImage + "_diff.png" };// Diff image.
		// Prly
		// should
		// put these
		// somewhere
		// else..
		// debug line
		for (String j : commandLineMagick) {
			System.out.print(j + " ");
		}
		try {
			// Run the command.. Should exit 1 for success, 2 for failure
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(commandLineMagick);
			int exitVal = proc.waitFor();
			print("\nImageMagick exit value: " + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	/**
	 * Added this for the _MigrationTest since it uses different paths.. Too
	 * lazy to just make the original one more robust.
	 * 
	 * @param storedImage
	 * @param capturedImage
	 */
	public void generateDiffClip_Migration(String imageName) {
		print("screenshots//migration//capture//" + imageName + ".jpg");
		print("screenshots//migration//verification//" + imageName + ".jpg");
		// Build the command line
		String[] commandLineMagick = new String[] { "cmd", "/c", "compare",
				"screenshots\\migration\\capture\\" + imageName + ".jpg", // Baseline
				// image
				"screenshots\\migration\\verification\\" + imageName + ".jpg", // Current
				// live
				// image
				"screenshots\\migration\\verification\\" + imageName + "_diff.jpg" };// Diff
		// image.
		// Prly
		// should
		// put
		// these
		// somewhere
		// else..
		// debug line
		for (String j : commandLineMagick) {
			System.out.print(j + " ");
		}
		try {
			// Run the command.. Should exit 1 for success, 2 for failure
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(commandLineMagick);
			int exitVal = proc.waitFor();
			print("\nImageMagick exit value: " + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	/**
	 * Returns the 'value' attribute as a string. Use this to get the text from
	 * an input box.
	 * 
	 * @return
	 */
	public String getValue(String locator) {
		return this.getWhenVisible(locator).getAttribute("value").trim();
	}

	/**
	 * <<<<<<< HEAD Return a list of web elements.
	 * 
	 * @param locator
	 * @return
	 */
	public List<WebElement> getElementList(String locator) {
		return this.getWebDriver().findElements(ByLocator(locator));
	}

	/**
	 * @author Vivek
	 * Get list of visible Elements 
	 * @param locator
	 * @return
	 */
	public List<WebElement> getVisibleElementsList(String locator) {
		List<WebElement> els = this.getWebDriver().findElements(ByLocator(locator));
		List<WebElement> visibleEls = new ArrayList<WebElement>();
		for (WebElement el : els) {
			if (el.isDisplayed())
				visibleEls.add(el);
		}
		return visibleEls;
	}

	/**
	 *	 * 
	 * @author Vivek Return true when the first element become visible. *
	 * @param timeout
	 *            - Integer to set the time out
	 * @param locator
	 *            - String locator of the element
	 * @param doAssertFound
	 * @return - Return true when the first element become visible or false
	 */

	public Boolean getFirstVisible(int timeout, String locator) {
		Boolean isDisplayed = false;
		for (int i = 0; i < timeout * 10; i++) {
			if (isElementPresent(locator, 0)) {
				List<WebElement> el = getWebDriver().findElements(ByLocator(locator));
				for (WebElement j : el) {
					try {
						if (j.isDisplayed()) {
							isDisplayed = true;
							return isDisplayed;
						}
					} catch (org.openqa.selenium.StaleElementReferenceException e) {
						// do nothing (sleep for 1 more second and try again)
					}
				}
			}
			this.sleep(1000);
		}
		return isDisplayed;
	}


	/**
	 * @author Vivek This method assert that locator is visible on
	 *         page. 

	 * @param locator
	 *            - String - locator of the element
	 * @param text
	 *            - String to print the text in console or logs to check the
	 *            element name for better user understanding.
	 */
	public void assertElemenentIsVisibile(String locator, String text) {
		print("Assert that '" + text + "' is visible");
		Boolean isVisible = this.getFirstVisible(30, locator);
		Assert.assertTrue(isVisible, "Expected that '" + text + "' should visible");
	}

	/**
	 * @author Vivek This method assert that locator is not visible on
	 *         page.	 
	 * @param locator
	 *            - String - locator of the element
	 * @param text
	 *            - String to print the text in console or logs to check the
	 *            element name for better user understanding.
	 */	
	public void assertElemenentIsNotVisibile(String locator, String text) {
		print("Assert that '" + text + "' is not visible");
		Boolean isVisible = this.getFirstVisible(30, locator);
		Assert.assertFalse(isVisible, "Expected that '" + text + "' should not visible");
	}

	/**
	 * @author Vivek
	 * Get element list and element
	 * @param elements
	 * @param text
	 * @return
	 */
	public WebElement getElement(List<WebElement> elements, String text) {

		WebElement element = null;
		String actualText = "";
		for (int i = 0; i < elements.size(); i++) {
			actualText = elements.get(i).findElement(By.xpath(".//input")).getAttribute("value");
			if (actualText.equalsIgnoreCase(text)) {
				print(actualText);
				element = elements.get(i);
				break;
			}
		}
		return element;
	}

	/**
	 * @author Vivek
	 * click on an element using java scripts
	 * @param webElement
	 */

	public void javascriptButtonClick(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", webElement);
	}

	public void javascriptButtonClick(String locator, boolean doWait) {
		WebElement el = this.getFirstVisible(locator);
		javascriptButtonClick(el);
	}	
	
	public void javascriptButtonClick(String locator) {
		javascriptButtonClick(locator, false);
	}

	/**
	 * @author Vivek
	 * Restore down browser window
	 * @param x
	 * @param y
	 */
	public void restoreDownBrowser(int x, int y){
		Dimension d = new Dimension(x,y);
		getWebDriver().manage().window().setSize(d);
	}


	/**
	 * @author Vivek
	 * @param locator
	 * It returns integer value of height
	 * @return
	 */
	public int getElementHeight(String locator){
		this.waitForElementPresentInDom(20);
		print ("gets element's height");
		int height = getFirstVisible(locator).getSize().getHeight();
		return height;
	}

	/**
	 * @author Vivek
	 * This method returns total count of the items who contains "text"
	 * @param elements
	 * @param text
	 * @return
	 * @throws InterruptedException 
	 */
	public int getListElementsCount(String elements, String text){
		List<WebElement> elementList=getlist(elements);
		int actualItemNumebr = 0;
		for (int i = 0; i < elementList.size(); i++) {
			String actualText = elementList.get(i).getText().trim();
			if (actualText.isEmpty())
				actualText = elementList.get(i).getAttribute("value");
			if(actualText==null)
				actualText="";
			if (actualText.contains(text)) {
				actualItemNumebr++;
			}
		}
		return actualItemNumebr;
	}

	/**
	 * @author Vivek
	 * This method gets the class name of button and checks the expected value in it
	 * @param element
	 * @return
	 */
	public boolean getElementVisibility(String element, String classElement){
		String str = getWebDriver().findElement(ByLocator(element)).getAttribute("class");
		boolean visibilityMode = str.contains(classElement);
		return visibilityMode;	

	}	

	/**
	 * @author Vivek
	 * Click on element with Java script code
	 * @param locator
	 */
	public void javaScriptClick(String locator)
	{
		WebElement el = getWebDriver().findElement(ByLocator(locator));		
		scrollToElement(locator);
		((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].click();",el);
	}

	/**
	 * @author Vivek
	 * Scroll to specific element pass in the method paramenter
	 * @param locator
	 */
	public void scrollToElement(String locator){
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		((JavascriptExecutor)getWebDriver()).executeScript("arguments[0].scrollIntoView();",el);
	}	

	/**
	 * @author Vivek
	 * @param timeout
	 */
	public void waitForElementPresentInDom(int timeout) {
		try{
			for(int i=0; i<timeout; i++){
				if(((JavascriptExecutor) getWebDriver()).executeScript("return document.readyState")!="complete"){
					sleep(2000);  
				}
			}
		}catch(Exception e){}
	}

	/**
	 * @param tolerance
	 * @param pointA
	 * @param pointB
	 * @return
	 */
	public boolean pointIsWithinTolerance(int tolerance, Point pointA, Point pointB) {
		if (Math.abs(pointA.x - pointB.x) <= tolerance && Math.abs(pointA.y - pointB.y) <= tolerance)
			return true;
		return false;
	}

	public int getElementWidth(String locator) {
		int width = getWhenVisible(locator).getSize().getWidth();
		print("Width: " + width + " (" + locator + ")");
		return width;
	}	
	
	/**
	 * This method to get the unique email Id.
	 * @return
	 */
	public static String email()
	{
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new Date();
	String email = "test"+dateFormat.format(date)+"@mailinator.com";
	return email;
	}

	public void switchToFrame(String locator) {
		try {
			driver.switchTo().frame(locator);
			System.out.println("Navigated to frame with id " + locator);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + locator + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with id " + locator + e.getStackTrace());
		}
	}
	
	public void switchWin(int windowNum){
		sleep(5000);
		Object[] win = driver.getWindowHandles().toArray();
		driver.switchTo().window((String) win[windowNum]);
	}

}