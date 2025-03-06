package com.automation.pages;

import com.automation.utils.ReusableMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private AppiumDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"username_input_field\")")
    private WebElement usernameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"password_input_field\")")
    private WebElement passwordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"date_of_birth_field_calendar_icon\")")
    private WebElement dobCalendarIcon;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login_form_submit_button\")")
    private WebElement loginButton;



    ReusableMethods reusableMethods;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        reusableMethods=new ReusableMethods();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void enterCredentials(String username, String password ,String dateOfBirth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Enter username and password
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);

        // Open the date picker
        wait.until(ExpectedConditions.elementToBeClickable(dobCalendarIcon)).click();

        // Select the date from the picker
        selectDate(dateOfBirth);

        // Click the login button
        loginButton.click();
    }

    private void selectDate(String date) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Select the hardcoded date
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().text(\""+ ReusableMethods.getDate(date)+"\")")
        ));
        dateElement.click();

        // Click Confirm to finalize the date selection
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Confirm\")")
        ));
        confirmButton.click();
    }

}
