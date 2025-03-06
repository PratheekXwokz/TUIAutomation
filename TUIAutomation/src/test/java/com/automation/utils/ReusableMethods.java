package com.automation.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class ReusableMethods {

    private static Properties properties = new Properties();
    private static final String JSON_FILE_PATH = "src/test/resources/HolidayandHotels.json";


    public static String getDate(String inputDate){

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");

        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        String formattedDate = date.format(outputFormatter);

        System.out.println(formattedDate); // Output: Sunday, March 2, 2025
        return formattedDate;
    }


    public static Properties loadProperties() {
        try (FileInputStream input = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(input);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }




    public static JSONArray getAllItems() {
        try (InputStream is = new FileInputStream(JSON_FILE_PATH)) {
            JSONTokener tokener = new JSONTokener(is);
            JSONObject jsonObject = new JSONObject(tokener);

            JSONArray tabs = jsonObject.getJSONArray("tabs");
            for (int i = 0; i < tabs.length(); i++) {
                JSONObject tab = tabs.getJSONObject(i);
                if ("All List".equalsIgnoreCase(tab.getString("name"))) {
                    return tab.getJSONArray("items");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }

    public boolean findElementByDynamicResourceId(String baseResourceId,  AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Scroll until the element is visible or the end of the scrollable area is reached
        boolean isVisible = false;
        while (!isVisible) {
            try {
                // Scroll down
                driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().resourceId(\"" + baseResourceId + "\"))"));

                // Check if the element is now visible
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"" + baseResourceId + "\")")));
                isVisible = element.isDisplayed();
            } catch (Exception e) {
                // If the element is still not visible, continue scrolling
                break;
            }
        }

        return isVisible;
    }
}
