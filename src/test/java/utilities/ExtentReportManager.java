package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter reporter;
	public ExtentReports report;
	public ExtentTest test;
	String reportName;

	public void onStart(ITestContext testContext) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String timestamp = date.format(dt);

		reportName = "Test-Report" + timestamp + ".html";
		reporter = new ExtentSparkReporter(".\\reports\\" + reportName);

		reporter.config().setDocumentTitle("Hansa Automation Report");
		reporter.config().setReportName("Hansa Login Report");
		reporter.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Application", "Hansa");
		report.setSystemInfo("Module", "Login");
		report.setSystemInfo("User Name", System.getProperty("user.name"));
		report.setSystemInfo("Environment", "QA");

		String OS = testContext.getCurrentXmlTest().getParameter("os");
		report.setSystemInfo("Operating System", OS);

		String Browser = testContext.getCurrentXmlTest().getParameter("Browser");
		report.setSystemInfo("Browser", Browser);

		List<String> IncludedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if (!IncludedGroups.isEmpty()) {
			report.setSystemInfo("Groups", IncludedGroups.toString());
		}

	}

	public void onTestSuccess(ITestResult result) {

		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + "  -  Test case successfully executed");

	}

	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());

		test.log(Status.FAIL, result.getName() + "  -  Test case is failed");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String imgPath = new BaseClass().captureScreenshot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + "test case is skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext context) {
		report.flush();
		
		String reportPath = System.getProperty("user.dir")+"\\reports\\"+reportName;
		File extentReport = new File(reportPath);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
