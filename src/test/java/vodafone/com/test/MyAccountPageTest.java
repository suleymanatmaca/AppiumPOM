package vodafone.com.test;

import vodafone.com.base.BaseTest;
import vodafone.com.page.MyAccountPage;
import vodafone.com.reports.ExtentTestReport;
import org.testng.annotations.*;

public class MyAccountPageTest extends BaseTest {

    MyAccountPage myAccountPage;

    @BeforeSuite
    public void setupSuit() {
        ExtentTestReport.beforeTest();
    }

    @AfterSuite
    public void afterSuit(){
        ExtentTestReport.afterTest();
    }

    @BeforeClass
    public void before() {
        myAccountPage = new MyAccountPage(getAndroidDriver());
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(1000);

        myAccountPage
                .myAccountClick()
                .editProfileClick()
                .accountNameEdit()
                .swipeUp();
    }

    @AfterClass
    public void after() {
        tearDown();
    }
}
