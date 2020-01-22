package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{

    private static final String
            CLICK_NO_THANKS = "//*[@text='NO THANKS']",
            MY_LISTS_LINK = "//android.widget.FrameLayout[@content-desc='My lists']";

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyList()
    {
        this.waitForElementAndClick(
                By.xpath(CLICK_NO_THANKS),//"//*[@text='NO THANKS']"
                "Cannot find button 'Create new'",
                5
        );

        this.waitForElementAndClick(
                By.xpath(MY_LISTS_LINK),//"//android.widget.FrameLayout[@content-desc='My lists']"
                "Cannot find navigation button to my list",
                5
        );
    }
}
