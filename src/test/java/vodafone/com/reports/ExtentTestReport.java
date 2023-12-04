package vodafone.com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentTestReport {
    public static ExtentReports extent;

    public static void beforeTest() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("myaccountpage.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void afterTest(){
        extent.flush();
    }
}
