package com.automation.pages;

import com.automation.utils.ReusableMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AllHolidayHotelPage {
    ReusableMethods reusableMethods;
    private AppiumDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"All\")")
    private WebElement dashboard;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Hotels\")")
    private WebElement hotelsTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Holidays\")")
    private WebElement holidaysTab;
    public AllHolidayHotelPage(AppiumDriver driver) {
        this.driver = driver;
        reusableMethods = new ReusableMethods();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }


    public boolean isDashboardDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(dashboard)).isDisplayed();
    }

    public boolean isHotelsTabDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(hotelsTab)).isDisplayed();
    }

    public boolean isHolidaysTabDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(holidaysTab)).isDisplayed();
    }

    public void navigateToHotels() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(hotelsTab)).click();
    }

    public void navigateToHolidays() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(holidaysTab)).click();
    }

    public void allItems() {
        ReusableMethods reusableMethods = new ReusableMethods();
        JSONArray items = ReusableMethods.getAllItems();

        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            String type = item.getString("type");

            String expectedTitle = item.getString("name");
            String expectedDescription = item.getString("description");
            String expectedBoardType = item.getString("boardType");
            String expectedPrice = item.getString("price");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Example locator - adjust as per  app
            if(reusableMethods.findElementByDynamicResourceId("content_card_board_type_"+i,driver)) {
                WebElement actualTitle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"content_card_hotel_name_" + i + "\")"));
                WebElement actualDescription = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"content_card_destination_" + i + "\")"));
                WebElement actualBoardType = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"content_card_board_type_" + i + "\")"));
                //WebElement actualPrice = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"content_card_hotel_name_0\")"));
                Assert.assertEquals(actualTitle.getText(), type + ": " + expectedTitle);
                Assert.assertEquals(actualDescription.getText(), expectedDescription);
                Assert.assertEquals(actualBoardType.getText(), expectedBoardType);
            }
        }
    }
    public void allHotelItems() {
        ReusableMethods reusableMethods = new ReusableMethods();
        JSONArray items = ReusableMethods.getAllItems();
       int index=0;
        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            String type = item.getString("type");
            if (type == "Hotel") {

                String expectedTitle = item.getString("name");
                String expectedDescription = item.getString("description");
                String expectedBoardType = item.getString("boardType");
                String expectedPrice = item.getString("price");

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                // Example locator - adjust as per  app
                if (reusableMethods.findElementByDynamicResourceId("content_card_board_type_" + index, driver)) {
                    WebElement actualTitle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"content_card_hotel_name_" + index + "\")"));
                    WebElement actualDescription = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"content_card_destination_" + index + "\")"));
                    WebElement actualBoardType = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"content_card_board_type_" + index + "\")"));
                    //WebElement actualPrice = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"content_card_hotel_name_0\")"));
                    Assert.assertEquals(actualTitle.getText(), type + ": " + expectedTitle);
                    Assert.assertEquals(actualDescription.getText(), expectedDescription);
                    Assert.assertEquals(actualBoardType.getText(), expectedBoardType);
                }
                index++;
            }
        }
    }

    public void allHolidayItems() {
        ReusableMethods reusableMethods = new ReusableMethods();
        JSONArray items = ReusableMethods.getAllItems();
        int index=0;
        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            String type = item.getString("type");
            if (type == "Holiday") {
                String expectedTitle = item.getString("name");
                String expectedDescription = item.getString("description");
                String expectedBoardType = item.getString("boardType");
                String expectedPrice = item.getString("price");

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                // Example locator - adjust as per  app
                if (reusableMethods.findElementByDynamicResourceId("content_card_board_type_" + index, driver)) {
                    WebElement actualTitle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"content_card_hotel_name_" + index + "\")"));
                    WebElement actualDescription = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"content_card_destination_" + index + "\")"));
                    WebElement actualBoardType = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"content_card_board_type_" + index + "\")"));
                    //WebElement actualPrice = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"content_card_hotel_name_0\")"));
                    Assert.assertEquals(actualTitle.getText(), type + ": " + expectedTitle);
                    Assert.assertEquals(actualDescription.getText(), expectedDescription);
                    Assert.assertEquals(actualBoardType.getText(), expectedBoardType);
                }
            }
        }
    }
}
