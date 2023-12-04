package vodafone.com.base;

import vodafone.com.reports.ExtentTestReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class BasePage extends ExtentTestReport {
    AndroidDriver driver;
    WebDriverWait wait;
    public ExtentTest startTest = extent.createTest("Vodafone Test", "Hesaplarım");

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(60));
    }

    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void clear(By by) {
        findElement(by).clear();
    }

    public void sendKeys(By by, String txt) {
        findElement(by).sendKeys(txt);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void swipe(int startPointX, int startPointY, int endPointX, int endPointY) throws RuntimeException, InterruptedException {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(startPointX, startPointY);
        Point end = new Point(endPointX, endPointY);
        Sequence swipe = new Sequence(finger, 1);

        try {
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));
        } catch (RuntimeException re) {
            failLog("Ekran kaydırmada sorun oluştu!");
        }

       // Thread.sleep(1000);
    }

    public void infoLog(String str) {
        startTest.log(Status.INFO, str);
    }

    public void passLog(String str) {
        startTest.log(Status.PASS, str);
    }

    public void failLog(String str) {
        startTest.log(Status.FAIL, str);
    }
}
