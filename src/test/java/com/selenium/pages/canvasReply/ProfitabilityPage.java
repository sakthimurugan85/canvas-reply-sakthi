package com.selenium.pages.canvasReply;

import com.selenium.pages.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitabilityPage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfitabilityPage.class);

    public ProfitabilityPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "grouptab-5")
    private WebElement reportsAndSettingsMenu;

    @FindBy(xpath = "/html/body/nav/div[2]/div[6]/div[1]/a")
    private WebElement reportsSubMenu;

    @FindBy(id = "main-title-module")
    private WebElement reportsTitle;

    @FindBy(id = "filter_text")
    private WebElement reportSearchField;

    @FindBy(xpath = "//a[contains(text(),'Project Profitability')]")
    private WebElement projectProfitabilityLink;

    @FindBy(id = "main-title-text")
    private WebElement reportsTitleText;

    @FindBy(name = "FilterForm_applyButton")
    private WebElement runReportButton;

    @FindBy(xpath = "//*[@id=\"listView-8853-main\"]/tbody")
    private WebElement tableElementList;

    @FindBy(className = "listView")
    private WebElement tableElement;

    public void goToReportsPage() {
        wait.forElementToBeDisplayed(5, reportsAndSettingsMenu, "reportsAndSettingsMenu");
        reportsAndSettingsMenu.click();
        wait.forElementToBeDisplayed(5, reportsSubMenu, "reportsSubMenu");
        reportsSubMenu.click();
        wait.forElementToBeDisplayed(10, reportsTitle, "reportsTitle");
        wait.forceWait(10);
        String actualReportsTitleText = reportsTitle.getText();
        LOGGER.info("Verifying the contacts page title text");
        assertThat("REPORTS")
                .as("Reports page title doesn't match!")
                .isEqualTo(actualReportsTitleText);
        LOGGER.info("User is on Reports page");
    }

    public void goToProjectProfitabilityPage(String searchText) {
        wait.forElementToBeDisplayed(5, reportSearchField, "reportSearchField");
        reportSearchField.sendKeys(searchText);
        reportSearchField.sendKeys(Keys.RETURN);
        wait.forElementToBeDisplayed(10, projectProfitabilityLink, "projectProfitabilityLink");
        projectProfitabilityLink.click();
        wait.forceWait(5);
        String actualReportsTitleText = reportsTitleText.getText();
        LOGGER.info("Verifying the reports page title text");
        assertThat("REPORTS")
                .as("Reports page title text doesn't match!")
                .isEqualTo(actualReportsTitleText);
        LOGGER.info("User is on the project profitability page");
    }

    public void runProjectProfitabilityReport() {
        wait.forElementToBeDisplayed(5, runReportButton, "runReportButton");
        wait.forceWait(5);
        runReportButton.click();
    }

    public void verifyReportsTable() {
        wait.forceWait(5);
        wait.forElementToBeDisplayed(5, tableElement, "tableElementList");
        String numberOfRows = String.valueOf(tableElement.findElements(By.tagName("tr")).size());
        LOGGER.info("Number of results in project profitability table " + numberOfRows);
        assertThat(Integer.valueOf(numberOfRows)).isGreaterThan(0);
    }

}
