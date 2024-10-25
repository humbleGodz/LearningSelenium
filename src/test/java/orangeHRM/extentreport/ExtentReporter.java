package orangeHRM.extentreport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import orangeHRM.constant.Constants;

public class ExtentReporter implements ITestListener {

	private static ExtentSparkReporter htmlReporter;
	private static ExtentReports extent;
	private static ExtentTest test;
	private static final Logger log = LogManager.getLogger(ExtentReporter.class);

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
		log.info("Test Passed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
		test.fail(result.getThrowable());
		log.error("Test Failed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
		log.warn("Test Skipped: " + result.getMethod().getMethodName());

	}

	@Override
	public void onStart(ITestContext context) {
		htmlReporter = new ExtentSparkReporter(Constants.EXTENT_REPORT);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public void info(String message) {
		if (test != null) {
			test.info(message); // Log the step in Extent Report
		}
	}

}
