package vodafone.com.base;

import vodafone.com.reports.ExtentTestReport;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest extends ExtentTestReport {

    static AndroidDriver androidDriver = null;
    public static WebDriverWait wait;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities capabilities;
            capabilities = new DesiredCapabilities();
            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            capabilities.setCapability("deviceName", "Atmaca");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "R58M42ZC90Z");
            capabilities.setCapability("platformVersion", "11.0");
            capabilities.setCapability("appPackage", "com.vodafone.selfservis");
            capabilities.setCapability("appActivity", "com.vodafone.selfservis.feature.growth.activities.LandingPageActivity");
            capabilities.setCapability("skipUnlock", "true");
            capabilities.setCapability("noReset", "true");

            androidDriver = new AndroidDriver(url, capabilities);
            wait = new WebDriverWait(androidDriver, Duration.ofMillis(10));

        } catch (MalformedURLException mx) {
            System.out.println("Hatalı oluşturulmuş URL hatası!");
        }
    }

    public static AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public static void setAndroidDriver(AndroidDriver androidDriver) {
        BaseTest.androidDriver = androidDriver;
    }

    public void tearDown() {
        getAndroidDriver().quit();
    }
}
