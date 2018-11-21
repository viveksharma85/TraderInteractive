package com.trader.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.jacob.com.LibraryLoader;
import com.trader.pagehelper.DealerHelper;
import com.trader.pagehelper.HomeHelper;
import com.trader.pagehelper.LoginHelper;
import com.trader.pagehelper.MyTraderHelper;
import com.trader.pagehelper.SearchHelper;
import com.trader.pagehelper.SellYourMotorcycleHelper;
import com.trader.pagehelper.SignUpHelper;
import com.trader.pagehelper.TraderMenus;

import autoitx4java.AutoItX;

public class DriverTestCase {

	enum DriverType {
		Firefox, IE, Chrome
	}

	protected WebDriver driver;
	protected LoginHelper loginHelper;
	protected MyTraderHelper myTraderHelper;
	protected SignUpHelper signUpHelper;
	protected TraderMenus traderMenus;
	protected SearchHelper searchHelper;
	protected HomeHelper homeHelper;
	protected DealerHelper dealerHelper;
	protected SellYourMotorcycleHelper sellYourMotorcycleHelper;
	protected String locator;
	protected static int testNumber;
	protected static String timeGMT;
	protected String theBrowser;
	protected static SoftAssert softAssert;
	public String testName = "";
	protected static int totalTests;
	protected PropertyReader propertyReader = new PropertyReader();
	protected String applicationUrl = propertyReader.readApplicationFile("Application-URL");
	protected String uname;
	protected String password;
	public String groupsOutputFile = "/test-output/" + getJobName() + ".csv";

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method testMethod) throws Exception {
		uname = propertyReader.readApplicationFile("UName");
		password = propertyReader.readApplicationFile("PWD");
		String browser = propertyReader.readApplicationFile("BROWSER");

		// used by a couple of tests
		testName = testMethod.getName();

		// Removed the skip parameters from the setup method since we haven't used these
		// in ages.
		Runtime runtime = Runtime.getRuntime();

		clearmemory();
		Long totalHeap = (runtime.totalMemory() / 1024 / 1024);
		Long freeHeap = (runtime.freeMemory() / 1024 / 1024);

		// Logging
		System.out.println("Initial heap MB: " + (totalHeap - freeHeap) + ", Total heap MB: " + totalHeap
				+ ", Free heap MB: " + freeHeap);

		if (DriverType.Firefox.toString().toLowerCase().equals(browser.toLowerCase())) {
			// TODO: Remove this assert when bug SDM-2641 is fixed
			//System.setProperty("webdriver.marionette.driver", getPath() + "//Browsers//geckodriver.exe");
			System.setProperty("webdriver.marionette.driver", getPath() + "//Browsers//geckodriver");
			
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			GeckoDriverService service = new GeckoDriverService.Builder()
					.usingDriverExecutable(new File(getPath() + "//Browsers//geckodriver.exe")).usingAnyFreePort()
					.build();
			driver = new FirefoxDriver(service, options);

		} else if (DriverType.Chrome.toString().toLowerCase().equals(browser.toLowerCase())) {
			String path1 = getPath();
			//String chromeDriverPath = path1 + "//Browsers//chromedriver.exe";
			String chromeDriverPath = path1 + "//Browsers//chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
options.addArguments("start-maximized"); // open Browser in maximized mode
options.addArguments("disable-infobars"); // disabling infobars
options.addArguments("--disable-extensions"); // disabling extensions
options.addArguments("--disable-gpu"); // applicable to windows os only
options.addArguments("--no-sandbox"); // Bypass OS security model
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(chromeDriverPath)).usingAnyFreePort().build();
			driver = new ChromeDriver(service, options);
		}

		else if (DriverType.IE.toString().toLowerCase().equals(browser.toLowerCase())) {
			// String path = getPath();
			// File file = new File(path + "//IEDriverServer.exe");
			// System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			// Wow IE is a pain.. I had to disable native events to get some clicks to work,
			// but that broke hover events. So had to turn native events back on and use
			// 'require window focus'
			// to get both clicks and hovers to work.. Phew, got it working.
			options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			driver = new InternetExplorerDriver(options);
		} else {

			String path1 = getPath();
			//String chromeDriverPath = path1 + "//Browsers//chromedriver.exe";
			String chromeDriverPath = path1 + "//Browsers//chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
options.addArguments("start-maximized"); // open Browser in maximized mode
options.addArguments("disable-infobars"); // disabling infobars
options.addArguments("--disable-extensions"); // disabling extensions
options.addArguments("--disable-gpu"); // applicable to windows os only
options.addArguments("--no-sandbox"); // Bypass OS security model
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			ChromeDriverService service = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File(chromeDriverPath)).usingAnyFreePort().build();
			driver = new ChromeDriver(service, options);
		}
		// Maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Delete cookies
		driver.manage().deleteAllCookies();

		// Logging
		System.out.println("Middle heap MB: " + (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024);
		print("Launching browser " + this.getBrowserString());

		this.initializeHelpers();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		// Send the stack trace to the execution logs.
		if (result.getStatus() == ITestResult.FAILURE) {
			ExecutionLog.LogStackTrace(result.getThrowable());
		}

		// we still want to close the browser when tests pass though

		if (result.getStatus() == ITestResult.FAILURE) {
			driver.quit();
			driver = null;
		}
		if (result.getStatus() == ITestResult.SUCCESS) {
			driver.quit();
			driver = null;
		}
		if (result.getStatus() == ITestResult.SKIP) {
			driver.quit();
			driver = null;
		}
		// driver.quit();
		// driver = null;

		loginHelper = null;
		myTraderHelper = null;
		signUpHelper = null;
		traderMenus = null;
		searchHelper = null;
		homeHelper = null;
		sellYourMotorcycleHelper = null;
		dealerHelper = null;
	}

	public void initializeHelpers() {
		loginHelper = new LoginHelper(getWebDriver());
		myTraderHelper = new MyTraderHelper(getWebDriver());
		signUpHelper = new SignUpHelper(getWebDriver());
		traderMenus = new TraderMenus(getWebDriver());
		searchHelper = new SearchHelper(getWebDriver());
		homeHelper = new HomeHelper(getWebDriver());
		sellYourMotorcycleHelper = new SellYourMotorcycleHelper(getWebDriver());
		dealerHelper = new DealerHelper(getWebDriver());
	}

	// Open the application
	public void OpenURL() {
		try {
			System.out.println("###opening application url: " + applicationUrl);
			getWebDriver().navigate().to(applicationUrl);
			ExecutionLog.Log("open application url: " + applicationUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void OpenURL(String URL) {
		try {
			System.out.println("###opening url: " + URL);
			getWebDriver().navigate().to(URL);
			ExecutionLog.Log("open url: " + URL);
		} catch (Exception e) {
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

	/**
	 * Log into SDM mode.
	 * 
	 * @param credential
	 * @param isIncompleteEquiv
	 *            - Set to true to click OK on the 'incomplete equiv' message during
	 *            login.
	 * @throws InterruptedException
	 */
	/*
	 * public void LogIn(CredentialException credential, String server, Boolean
	 * isIncompleteEquiv) throws InterruptedException { loginHelper = new
	 * LoginHelper(this.getWebDriver()); // Enter user credentials and click the
	 * login button loginHelper.simpleLogIn(credential, server);
	 * ExecutionLog.Log("Login complete"); }
	 * 
	 * public void SimpleLogIn(Credential credential, String server) throws
	 * InterruptedException { loginHelper = new LoginHelper(this.getWebDriver()); //
	 * Enter user credentials and click the login button
	 * loginHelper.simpleLogIn(credential, server, true); }
	 * 
	 * /** Log in without clicking 'OK' the 'incomplete equiv' message
	 * 
	 * @param credential
	 * 
	 * @throws InterruptedException
	 */
	/*
	 * public void LogIn(Credential credential) throws InterruptedException {
	 * serverURL = getServerURL(); if
	 * (serverURL.equals("http://grawlix/SDM_EXTJS5")) { isServerEXTJS5 = true; }
	 * LogIn(credential, serverURL, false); }
	 */

	public WebDriver getWebDriver() {
		return driver;
	}

	// Handle child windows
	public String switchPreviewWindow() {
		Set<String> windows = getWebDriver().getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		getWebDriver().switchTo().window(iter.next());
		return parent;
	}

	/**
	 * Compare two images to see if they match. If the images are different sizes, I
	 * think it will just try to find the 2nd image within the 1st image (doesn't
	 * appear to effect the match percent which might be a problem)..
	 * 
	 * @param imageOld
	 *            - image path 1
	 * @param imageNew
	 *            - image path 2
	 * @param tolerance
	 *            - minimum tolerable percent match between images
	 * @return
	 * @throws IOException
	 */
	public boolean compareImages(String imageOld, String imageNew, Number tolerance) throws IOException {
		// Make sure the image paths exist before comparing the images
		if (!(new File(imageOld).exists())) {
			System.out.println("Image file was not found: '" + imageOld);
			ExecutionLog.Log("Image file was not found: '" + imageOld);
			return false;
		}
		if (!(new File(imageNew).exists())) {
			System.out.println("Image file was not found: '" + imageNew);
			ExecutionLog.Log("Image file was not found: '" + imageNew);
			return false;
		}
		// Compare the images.
		if (this.getMatchPercent(imageOld, imageNew) >= tolerance.doubleValue()) {
			return true;
		}
		return false;
	}

	/**
	 * Compares two images aren returns the match percent..
	 * 
	 * @param baseImage
	 *            - Path to the baseImage. Example: "images//baseImage//base.png";
	 * @param tempImage
	 *            - Path to temp image
	 * @return - Return the match percent (0 to 1)
	 * @throws IOException
	 */
	public double getMatchPercent(String baseImage, String tempImage) throws IOException {
		// Just an FYI, but I don't know what any of these variables mean (p? q? smw?).
		int q = 0, p = 0;
		File fileInput = new File(baseImage);
		BufferedImage image = ImageIO.read(fileInput);
		int width = image.getWidth(null);
		int height = image.getHeight(null);
		print("Base image dimensions: " + width + " x " + height);
		int[][] clr = new int[width][height];
		File fileOutPut = new File(tempImage);
		BufferedImage images = ImageIO.read(fileOutPut);
		int widthe = images.getWidth(null);
		int heighte = images.getHeight(null);
		print("Temp image dimensions: " + widthe + " x " + heighte);
		int[][] clre = new int[widthe][heighte];
		int smw = 0;
		int smh = 0;
		// CALUCLATING THE SMALLEST VALUE AMONG WIDTH AND HEIGHT
		if (width > widthe) {
			smw = widthe;
		} else {
			smw = width;
		}
		if (height > heighte) {
			smh = heighte;
		} else {
			smh = height;
		}
		// CHECKING NUMBER OF PIXELS SIMILARITY
		for (int a = 0; a < smw; a++) {
			for (int b = 0; b < smh; b++) {
				clre[a][b] = images.getRGB(a, b);
				clr[a][b] = image.getRGB(a, b);
				if (clr[a][b] == clre[a][b]) {
					p = p + 1;
				} else
					q = q + 1;
			}
		}
		float s = (smw * smh);
		// CALUCLATING PERCENTAGE
		double x = ((p) / s);
		print("Match percent = " + String.format("%.2f", x * 100) + "%");
		// We should probably fail if the images are not the same size.
		// We will tolerate a difference of 3 pixels in width and height to account for
		// small
		// styling variations, but anything about that we should fail..
		// Set the match percent to 0 in this case
		if (Math.abs(width - widthe) > 3 || Math.abs(height - heighte) > 3) {
			x = 0;
			print("Image dimensions don't match. Setting match percent to 0%");
		}
		return x;
	}

	// Clear memory
	public void clearmemory() {
		Runtime runtime;
		int MAXJVMMemoryUsage = 50;
		// Get the Java runtime
		runtime = Runtime.getRuntime();
		// System.out.println("Initial Memory consumed (in MB)
		// "+runtime.totalMemory()/MEGABYTE);
		System.out.println("Initial Memory consumed (in MB) "
				+ ((runtime.totalMemory() - runtime.freeMemory()) / runtime.totalMemory()) * 100);
		if (((runtime.totalMemory() - runtime.freeMemory()) / runtime.totalMemory()) * 100 >= MAXJVMMemoryUsage) {
			runtime.gc();
			runtime.gc();
		}
	}

	// Get random integer
	public int getRandomInteger(int aStart, int aEnd) {
		Random aRandom = new Random();
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * aRandom.nextDouble());
		int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

	// Get random string
	public String randomString(int len) {
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	// Get random number
	public String getRandomNumber(int len) {
		Random aRandom = new Random();
		String count = "1234567890";
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(count.charAt(aRandom.nextInt(count.length())));
		return sb.toString();
	}

	// Get absolute path
	public String getPath() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return path;
	}

	// Get UNC Path - \\host-name\drive-letter$\folder
	public String getUNC_Path() {
		String path = getPath();
		path = "\\\\" + getComputerName() + "/" + path.replace(":", "$");
		return path;
	}

	// Get absolute path
	public String getPathUpload() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("/", "//");
		return path;
	}

	// Switch frame
	public void switchFrame(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			getWebDriver().switchTo().frame(arr[i]);
		}
	}

	// Switch frame
	public void switchFrame(String xpathExpression) {
		getWebDriver().switchTo().frame(getWebDriver().findElement(By.xpath(xpathExpression)));
		System.out.println("Switched to Frame");
	}

	// Unselect a frame
	public void unSelectFrame() {
		getWebDriver().switchTo().defaultContent();
	}

	public String getComputerName() {
		Map<String, String> env = System.getenv();
		if (env.containsKey("COMPUTERNAME"))
			return env.get("COMPUTERNAME");
		else if (env.containsKey("HOSTNAME"))
			return env.get("HOSTNAME");
		else
			return "Unknown Computer";
	}

	// capturing screenshot
	public void captureScreenshot(String fileName) {
		Capabilities cap = ((RemoteWebDriver) getWebDriver()).getCapabilities();
		String browser = cap.getBrowserName() + " " + cap.getVersion();
		String date = getCurrentDate();
		String screenshotDatedFolderPath = getPath() + "\\screenshots\\Screenshot_" + date;
		File fl = new File(screenshotDatedFolderPath);
		fl.mkdirs();
		try {
			String screenshotName = this.createFile(fileName);
			String screenshotPath = fl.getPath() + "\\" + screenshotName + ".jpg";
			FileOutputStream out = new FileOutputStream(screenshotPath);
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			Reporter.log("<div style='clear:both;' >" + "<b>" + this.getDateTime() + "</b><br><br>" + "<b>URL:</b> "
					+ getApplicationURL() + "<br><b>Browser:</b> " + browser + "<br><b>Ran On:</b> " + getComputerName()
					+ "<br><br>" + getImageBase64String(screenshotPath, "jpg") + "</div>");
			File screenshotFile = new File(screenshotPath);
			screenshotFile.delete();
			// this.scanErrors();
		} catch (Exception e) {
		}
	}

	public static String getImageBase64String(String imagePath, String imageExtension, String style)
			throws IOException {
		String imageString = null;
		// Catch file not found exception since we want tests to still fail
		// with an assertion failure if the diff image doesn't get generated for
		// whatever reason
		try {
			File file = new File(imagePath);
			FileInputStream fis = new FileInputStream(file);
			imageString = Base64.getEncoder().encodeToString(IOUtils.toByteArray(fis));
			fis.close();
		} catch (java.io.FileNotFoundException e) {
			ExecutionLog.Log(e.toString());
			System.out.print(e);
		}
		return "<img src='data:image/" + imageExtension + ";base64," + imageString + "' style='" + style + "' />";
	}

	public static String getImageBase64String(String imagePath, String imageExtension) throws IOException {
		return getImageBase64String(imagePath, imageExtension, "width:1000px;");
	}

	/**
	 * Capture screenshot method for use with migration testing.. Saves the images
	 * to the migration folder..
	 * 
	 * @param path
	 *            - Path within the Screenshots folder. Use double slashes //
	 *            between directories.. Example: "migration//capture//"
	 * @param fileName
	 *            - File name of image to save excluding the file extension.
	 */
	public void captureScreen(String path, String fileName) {
		try {
			String fileOutput = "screenshots//" + path + fileName + ".jpg";
			ExecutionLog.Log("Save file: '" + fileOutput + "'");
			FileOutputStream out = new FileOutputStream(fileOutput);
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (Exception e) {
		}
	}

	// Creating file name
	public String createFile(String file) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat1 = new SimpleDateFormat("hh-mm-ss");
		Calendar cal = Calendar.getInstance();
		String fileName = file + "_" + dateFormat.format(cal.getTime()) + "_" + dateFormat1.format(cal.getTime());
		return fileName;
	}

	public String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String currentDate = dateFormat.format(cal.getTime());
		return currentDate;
	}

	public String getMonth() {
		DateFormat dateFormat = new SimpleDateFormat("MMMM");
		Calendar cal = Calendar.getInstance();
		String currentMonth = dateFormat.format(cal.getTime());
		return currentMonth;
	}

	public String getDayOfMonth() {
		Calendar now = Calendar.getInstance();
		int day = now.get(Calendar.DAY_OF_MONTH);
		DecimalFormat mFormat = new DecimalFormat("00");
		String dayOfMonth = mFormat.format(Double.valueOf(day));
		return dayOfMonth;
	}

	/**
	 * returns a date/time stamp. Example "04/06/2016 05:00:28 PM"
	 * 
	 * @return
	 */
	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
		Calendar cal = Calendar.getInstance();
		String currentDate = dateFormat.format(cal.getTime());
		String currentTime = timeFormat.format(cal.getTime());
		return currentDate + " " + currentTime;
	}

	/**
	 * @param userType
	 * @param doClickYes
	 *            - Do you wish to LogOut?, or Do you wish to Save? - Boolean
	 */
	public void LogOut() {
		ExecutionLog.Log("Logging out user");
		print("Logging out user");
		locator = ("//*[@id='sidebar-wrapper']//a[@href='/myt/logout']");
		// dashboardHelper.getWhenVisible(locator).click();
		ExecutionLog.Log("Log out button clicked");
	}

	/**
	 * Log troubleshooting information to the reporter output (called when a test
	 * fails).
	 * 
	 * @param fileName
	 *            - Name to use for the screenshot
	 */
	public void outputTestInfoToReporter(String fileName) {
		String date = getCurrentDate();
		String screenshotDatedFolderPath = getPath() + "\\screenshots\\Screenshot_" + date;
		File fl = new File(screenshotDatedFolderPath);
		fl.mkdirs();
		try {
			String screenshotName = this.createFile(fileName);
			String screenshotPath = fl.getPath() + "\\" + screenshotName + ".jpg";
			FileOutputStream out = new FileOutputStream(screenshotPath);
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			Reporter.log("<div style='clear:both;' >" + "<b>" + this.getDateTime() + "</b><br><br>"
					+ "<b>Test Name:</b> " + getClass().getSimpleName() + "." + testName + "<br><b>URL:</b> "
					+ getApplicationURL() + "<br><b>Browser:</b> " + this.getBrowserString() + "<br><b>Ran On:</b> "
					+ getComputerName() + "<br><b>Console output:</b><br> " + this.getConsoleOutput() + "<br><br>"
					+ getImageBase64String(screenshotPath, "jpg") + "</div>");
			// File screenshotFile = new File(screenshotPath);
			// screenshotFile.delete();
		} catch (Exception e) {
		}
	}

	public String getBrowserString() {
		Capabilities cap = ((RemoteWebDriver) getWebDriver()).getCapabilities();
		return cap.getBrowserName() + " " + cap.getVersion();
	}

	/**
	 * Move the mouse to the top left corner of the screen. Using this
	 * in @BeforeMethod because the mouse is in the way and causing tooltips and
	 * things to pop up when they shouldn't.
	 */
	public void moveMouseToCorner() {
		getNewAutoItX().mouseMove(0, 0);
	}

	/**
	 * Return new AutoIt
	 */
	public AutoItX getNewAutoItX() {
		String jacobDllVersionToUse;
		// Selects what dll to use
		if (getJvmBitVersion().contains("32")) {
			jacobDllVersionToUse = "libs/jacob-1.18-x86.dll";
		} else {
			jacobDllVersionToUse = "libs/jacob-1.18-x64.dll";
		}
		File file = new File("lib", jacobDllVersionToUse);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		AutoItX x = new AutoItX();
		return x;
	}

	public String getConsoleOutput() {
		String consoleOutput = "";

		try {
			Logs logs = getWebDriver().manage().logs();
			List<LogEntry> browserLogs = logs.get(LogType.BROWSER).filter(Level.ALL);

			for (LogEntry entry : browserLogs) {
				// consoleOutput = entry.toString() + System.getProperty("line.separator");
				consoleOutput = entry.toString() + "<br>";
			}

		} catch (org.openqa.selenium.WebDriverException e) {
		}

		return consoleOutput;
	}

	/**
	 * I added this so that test failures will show the string contents instead of
	 * just saying "Expected True but found False"..
	 * 
	 * @param actual
	 * @param expected
	 * @param message
	 */
	public void assertStringContains(String actual, String expected, String message) {
		Assert.assertTrue(actual.contains(expected),
				message + "String '" + expected + "' not found in string '" + actual + "' ");
	}

	/**
	 * Method as similar to assertStringContains, but here the string should be
	 * exactly same as expected
	 * 
	 * @param actual
	 * @param expected
	 * @param message
	 */
	public void assertStringEquals(String actual, String expected, String message) {
		Assert.assertTrue(actual.equalsIgnoreCase(expected),
				message + " String '" + expected + "' is not same as string '" + actual + "' ");
	}

	/**
	 * Method used to verify that string does not Expected string
	 * 
	 * @param actual
	 * @param expected
	 * @param message
	 */
	public void assertStringNotContain(String actual, String expected, String message) {
		Assert.assertFalse(actual.contains(expected),
				message + "String '" + expected + "' not found in string '" + actual + "' ");
	}

	public void assertStringContains(String actual, String expected) {
		this.assertStringContains(actual, expected, "");
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

	// Method to delete any file
	public void deleteFile(String path) {
		final File dir = new File(path);
		final Pattern pattern = Pattern.compile("results(.*)");
		final File[] files = dir.listFiles();
		try {
			for (final File file : files) {
				if (file.isDirectory()) {
				} else if (pattern.matcher(file.getName()).matches()) {
					file.delete();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
			// TODO: handle exception
		}
	}

	/**
	 * Method scans for javascript errors. If there are severe errors, then it
	 * throws an assertion failure. Method gets called in captureScreenshot and
	 * LogOut
	 */
	public void scanJavascriptErrors() {
		try {
			String errors = "";
			Integer skipCount = 0;
			Logs logs = getWebDriver().manage().logs();
			List<LogEntry> severeLogs = logs.get(LogType.BROWSER).filter(Level.SEVERE);
			if (severeLogs.size() > 0) {
				print("Javascript error(s): ");
				for (LogEntry entry : severeLogs) {
					print(entry.toString());
					errors += entry.toString() + "\n";
					// we don't want to fail on these specific errors.
					if (entry.toString().contains("the server responded with a status of 599")
							|| entry.toString().matches(".*/images/cursors/setup.cur.*status of 404.*")
							|| entry.toString().contains(
									"Failed to load resource: the server responded with a status of 503 (Service Unavailable"))
						skipCount++;
				}
				if (severeLogs.size() - skipCount > 0)
					Assert.fail("There were javascript errors: \n" + errors);
			}
		} catch (org.openqa.selenium.WebDriverException e) {
			print("Failed to scan for javascript errors.  The browser is probably IE.");
		}
	}

	public void printConsoleOutput() {
		try {
			Logs logs = getWebDriver().manage().logs();
			List<LogEntry> browserLogs = logs.get(LogType.BROWSER).filter(Level.ALL);
			print("Browser logs: ");
			for (LogEntry entry : browserLogs) {
				print(entry.toString());
			}
		} catch (org.openqa.selenium.WebDriverException e) {
		}
	}

	/**
	 * Added this because I'm tired of adding two lines to print things to the
	 * console and to the logs..
	 * 
	 * @param printString
	 */
	public void print(String printString) {
		System.out.println(printString);
		ExecutionLog.Log(printString);
	}

	/**
	 * Return JVM version
	 */
	public static String getJvmBitVersion() {
		return System.getProperty("sun.arch.data.model");
	}

	/**
	 * Get the application URL. The URL is either set as a system properly via the
	 * XML/Jenkins, or it uses the default URL in the application.config file
	 * 
	 * @return
	 */
	public String getApplicationURL() {
		String URL = System.getProperty("applicationURL");
		// If the URL is null, then read the URL from the application.config file.
		// (will show null if no URL variable exists at all, will return the variable
		// name if the variable exists but no
		// URL is passed)
		if (URL == null || URL.equals("${applicationURL}")) {
			return propertyReader.readApplicationFile("Application-URL");
		} else {
			return URL;
		}
	}

	public String getApplicationName() {
		return System.getProperty("ApplicationName");
	}

	// Return the soft assert so that other helpers and stuff can use it
	protected static SoftAssert getSoftAssert() {
		return softAssert;
	}

	public int getRunTestNumberOfTimes() {
		String runTestTimes = System.getProperty("runTestNumberOfTimes");
		if (runTestTimes == null || runTestTimes.equals("${runTestNumberOfTimes}")) {
			return 1;
		} else {
			return Integer.parseInt(runTestTimes);
		}
	}

	/**
	 * This method to handle multiple window
	 * 
	 * @param windowNum
	 * @throws InterruptedException
	 */
	public void switchWin(int windowNum) throws InterruptedException {
		Thread.sleep(5000);
		Object[] win = driver.getWindowHandles().toArray();
		driver.switchTo().window((String) win[windowNum]);
	}

	public String getJobName() {
		return System.getProperty("jobName");
	}

	public void printGroupOutput(String result, long executionTime) {
		double duration = executionTime / 1000.0;
		try {
			// Write to the all file
			PrintWriter writer = new PrintWriter(new FileOutputStream(new File(getPath() + groupsOutputFile), true));
			if (result.length() == 0) {
				writer.println(timeGMT + "," + getJobName() + "," + getClass().getSimpleName() + "," + testName + ","
						+ result + "," + (result.equals("Skipped") ? "TRUE" : "FALSE") + ",None," + duration);
			}
			// else {
			// for (String group : groups) {
			// writer.println(timeGMT + "," + getJobName() + "," +
			// getClass().getSimpleName() + "," + testName
			// + "," + result + "," + (result.equals("Skipped") ? "TRUE" : "FALSE") + "," +
			// group + ","
			// + duration);
			// }
			//// }
			writer.close();

		} catch (IOException e) {
			// do something
		}
	}
}
