package vodafone.com.page;

import vodafone.com.base.BasePage;
import io.appium.java_client.android.AndroidDriver;

import java.util.Random;

import static vodafone.com.constants.Constants.*;

public class MyAccountPage extends BasePage {
    //AppiumDriver driver;
    public MyAccountPage(AndroidDriver driver) {
        super(driver);
    }

    public MyAccountPage myAccountClick() throws InterruptedException {
        Thread.sleep(1000);
        click(MY_ACCOUNT_BTN);
        infoLog("Hesabım'a tıklandı!");
        return this;
    }

    public MyAccountPage editProfileClick() throws InterruptedException {
        click(EDIT_PROFILE_BTN);
        Thread.sleep(1000);
        infoLog("Profilimi düzenle'ye tıklandı!");
        return this;
    }

    public MyAccountPage accountNameEdit() throws InterruptedException {
        Random random = new Random(10);

        clear(ACCOUNT_NAME_TB);
        passLog("Hesap adı silindi!");
        Thread.sleep(1000);
        sendKeys(ACCOUNT_NAME_TB, "Atmaca" + random.nextInt(10));
        passLog("Hesap adı girişi yapıldı!");
        return this;
    }

    public void swipeUp() throws InterruptedException {
        swipe(400,2000,400,1300);
        infoLog("Ekran yukarı doğru kaydırıldı!");
        Thread.sleep(10000);
    }

}
