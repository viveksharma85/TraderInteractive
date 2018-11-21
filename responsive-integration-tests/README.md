Projet Name: Interative Trader
====================================================================================================================
Project is based on Page Object Model. We have integrated the Maven into Selenium. Maven makes a project easy to build. It provides a uniform build process. 

=======================================================================================================================================
The framework structure is summarized below:
It Contains six folders > configs, Utils, Pagehelper, locators, stringsdata and scripts.
============
config: 
It contains property file which include the sensitive data related to configurations, credentials, application url etc.
All sensitive data will be kept in the application.properties file in com.trader.Config folder.
============
locators: 
It contains locators of all modules. It’s been created separately that will help to traverse the locators at single location for all modules. 
Locators are kept in enum. Thus, locators will fetch from a single file Locator.java where each module will have separate enum in com.trader.locators folder.
============
stringdata:
 It contains the hard code data. Like locators, data will be kept in enum. enum will categorize according to the behaviour the strings. 
 Example: For buttons, it would have enum 'Button'. For Messages, It would have enum 'Messages' etc.
============
Utils: 
The generic methods which will use in the entire framework are kept in Utils folder. 
Example, DriverHelper file contains the most common methods which are being used by helper files. DriverTest Case file contains the test methods which will execute before and after executing each method etc.
============
Pagehelper: 
Every module would have separate helper file. All helper pages will be independent to each other.
Example: All methods related to Login page are being kept in LoginHelper file, Home page in HomeHelper, MyTrader realted methods in MyTraderHelper file
============
Scripts: 
Every module would have separate script page. 
Example: Smoke tests test cases are being kept in SmokeTest file.
	 	 For Regression, scripts will be maintained in sepaate module pages. Example, Login related scripts are being kept in Login page. Filter related scripts are being kept in Filter page.
=======================================================================================================================================