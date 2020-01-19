import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Ex7 {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","E:\\!Software_Testing\\!!GitHub\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");
        //capabilities.setCapability("app","/Users/perekcicdservicemanager/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }


    @Test
    public void checkLandscapeOrientation()
    {
        WebElement element_SKIP = driver.findElementByXPath("//*[contains(@text, 'SKIP')]");
        element_SKIP.click();

        //driver.rotate(ScreenOrientation.LANDSCAPE);
        ScreenOrientation currentOrientation = driver.getOrientation();
        if (currentOrientation != ScreenOrientation.PORTRAIT){
            driver.rotate(ScreenOrientation.PORTRAIT);
        }

        try{Thread.sleep(2000);}  catch (Exception e){}//пауза
    }
}
