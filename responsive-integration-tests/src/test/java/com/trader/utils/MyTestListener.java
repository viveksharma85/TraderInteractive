package com.trader.utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyTestListener extends TestListenerAdapter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.TestListenerAdapter#onTestFailure(org.testng.ITestResult)
	 * 
	 * When the tests fail, take a screen shot and log it in the TestNG reporter output.
	 * Have to do this here since calling this in the after method sends the reporter output
	 * to the afterMethod as well, which we can't see from jenkins.
	 * 
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		// Screenshot name should be "ClassName.TestName"
		// Having trouble getting the 'simple' class name here, so just stripping off the extra bits by hand.. uggh.
		String testClassName = result.getMethod().getTestClass().getName();
		testClassName = testClassName.replace("com.trader.scripts.", "");

		// Capture our DriverTestCase instance from our test, so we
		// can take a screen shot using DriverTestCase methods.
		DriverTestCase instance = ((DriverTestCase) result.getInstance());
		instance.outputTestInfoToReporter(testClassName + "." + result.getMethod().getMethodName());
		instance.printGroupOutput("Failed", result.getEndMillis() - result.getStartMillis());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		DriverTestCase instance = ((DriverTestCase) result.getInstance());
		instance.printGroupOutput("Passed", result.getEndMillis() - result.getStartMillis());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		DriverTestCase instance = ((DriverTestCase) result.getInstance());
		instance.printGroupOutput("Skipped", result.getEndMillis() - result.getStartMillis());
	}

}