package com.automation.steps;

import com.automation.pages.AllHolidayHotelPage;
import com.automation.pages.LoginPage;
import com.automation.utils.ReusableMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class AllHolidayHotelPageSteps {

    private AllHolidayHotelPage allHolidayHotelPage;

    public AllHolidayHotelPageSteps() throws MalformedURLException {
        allHolidayHotelPage = new AllHolidayHotelPage(Driver.getDriver("Android"));
    }
    @Then("I should see a list of all available items")
    public void iShouldSeeAListOfAllAvailableItems() {
        // Implementation pending
    }

    @Then("validates all available items with relevant details like name, description, and price")
    public void theListShouldDisplayRelevantDetails() {
        allHolidayHotelPage.allItems();
        // Implementation pending
    }


    @Then("validates all holiday destination, duration, and pricing")
    public void eachItemShouldDisplayHolidayDetails() {
        allHolidayHotelPage.allHolidayItems();
    }



    @Then("validates all hotel names, locations, and ratings")
    public void theHotelListShouldShowHotelDetails() {
        allHolidayHotelPage.allHotelItems();
    }
    @Then("Validate home screen is loaded")
    public void validate_home_screen_is_loaded() {
        if (allHolidayHotelPage.isDashboardDisplayed()) {
            System.out.println("Home Screen displayed successfully!");
        } else {
            System.out.println("Login failed.");
        }
    }

    @Given("User is on the home screen")
    public void user_is_on_the_home_screen() {
        if (allHolidayHotelPage.isDashboardDisplayed()) {
            System.out.println("User is on the home screen.");
        } else {
            System.out.println("User is not on the home screen.");
        }
    }

    @When("User selects {string}")
    public void user_selects_option(String option) {
        if ("Hotels".equalsIgnoreCase(option)) {
            allHolidayHotelPage.navigateToHotels();
            System.out.println("Navigated to Hotels.");
        } else if ("Holidays".equalsIgnoreCase(option)) {
            allHolidayHotelPage.navigateToHolidays();
            System.out.println("Navigated to Holidays.");
        } else {
            System.out.println("Unknown option: " + option);
        }
    }

    @Then("Validate {string} screen is loaded")
    public void validate_screen_is_loaded(String screenName) {
        if ("Hotels".equalsIgnoreCase(screenName)) {
            if (allHolidayHotelPage.isHotelsTabDisplayed()) {
                System.out.println("Hotels screen displayed successfully!");
            } else {
                System.out.println("Failed to load Hotels screen.");
            }
        } else if ("Holidays".equalsIgnoreCase(screenName)) {
            if (allHolidayHotelPage.isHolidaysTabDisplayed()) {
                System.out.println("Holidays screen displayed successfully!");
            } else {
                System.out.println("Failed to load Holidays screen.");
            }
        } else {
            System.out.println("Unknown screen: " + screenName);
        }
    }


}
