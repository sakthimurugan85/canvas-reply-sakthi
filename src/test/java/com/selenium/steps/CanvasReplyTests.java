package com.selenium.steps;

import com.selenium.pages.canvasReply.ActivityLogPage;
import com.selenium.pages.canvasReply.ContactsPage;
import com.selenium.pages.canvasReply.HomePage;
import com.selenium.pages.canvasReply.ProfitabilityPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CanvasReplyTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(CanvasReplyTests.class);

    private final HomePage homePage;
    private final ContactsPage contactsPage;
    private final ProfitabilityPage profitabilityPage;
    private final ActivityLogPage activityLogPage;


    public CanvasReplyTests() {
        this.contactsPage = new ContactsPage();
        this.homePage = new HomePage();
        this.profitabilityPage = new ProfitabilityPage();
        this.activityLogPage = new ActivityLogPage();
    }

    @Given("user is logged in to crm cloud")
    public void theUserIsLoggedInToCrmCloud() {
        LOGGER.info("Opening the home page");
        homePage.goToHomePage();
        LOGGER.info("Trying to login to the CRM");
        homePage.loginAction();
    }

    @When("the user navigates to the contacts page under sales and marketing")
    public void theUserNavigatesToTheContactsPageUnderSalesAndMarketing() {
        LOGGER.info("User trying to navigate to contacts page");
        contactsPage.goToContactsPage();
    }

    @And("the user fills in the new contact form")
    public void theUserFillsInTheNewContactForm() {
        LOGGER.info("User trying to navigate to create new contact page");
        contactsPage.goToCreateContactPage();
        LOGGER.info("User fills in the new contact page and trying to submit it");
        contactsPage.fillNewContactForm();
    }

    @Then("the user verifies the created contact details")
    public void theUserVerifiesTheCreatedContactDetails() {
        LOGGER.info("Verifying the newly created contact details!");
        contactsPage.verifyTheNewContactDetails();
    }

    @When("the user navigates to the {string} page")
    public void theUserNavigateToTheProjectProfitabilityPage(String searchText) {
        LOGGER.info("User trying to navigate to reports page!");
        profitabilityPage.goToReportsPage();
        LOGGER.info("User trying to navigate to project profitability page!");
        profitabilityPage.goToProjectProfitabilityPage(searchText);
    }

    @And("the user runs the project profitability report")
    public void theUserRunsTheProjectProfitabilityReport() {
        LOGGER.info("User trying to run the project profitability report!");
        profitabilityPage.runProjectProfitabilityReport();
    }

    @Then("the user verifies some results are returned in the table")
    public void theUserVerifiesSomeResultsAreReturnedInTheTable() {
        LOGGER.info("User trying to verify the project profitability report!");
        profitabilityPage.verifyReportsTable();
    }

    @When("the user navigates to the activity log page")
    public void theUserNavigatesToTheActivityLogPage() {
        LOGGER.info("User trying to navigate to activity log page!");
        activityLogPage.goToActivityLogPage();
    }

    @And("the user deletes the first three items from the table")
    public void theUserDeletesTheFirstThreeItemsFromTheTable() {
        LOGGER.info("User trying to delete first three entries from the activity log page!");
        activityLogPage.deleteActivityLogs();
    }

    @Then("the user verifies the items were deleted")
    public void theUserVerifiesTheItemsWereDeleted() {
        LOGGER.info("User verifies the first three deleted entries from the activity log page!");
        activityLogPage.verifyTheDeletedItems();
    }
}
