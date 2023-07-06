package com.selenium.pages.canvasReply;

import com.selenium.pages.basepage.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class ActivityLogPage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityLogPage.class);

    public ActivityLogPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "grouptab-5")
    private WebElement reportsAndSettingsMenu;

    @FindBy(xpath = "/html/body/nav/div[2]/div[6]/div[3]/a")
    private WebElement activityLogSubMenu;

    @FindBy(id = "main-title-module")
    private WebElement activityLogTitle;

    @FindBy(xpath = "//body[1]/div[7]/div[1]/div[3]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]")
    private WebElement activityLogFirstEntry;

    @FindBy(xpath = "//body[1]/div[7]/div[1]/div[3]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[1]/div[1]")
    private WebElement activityLogSecondEntry;

    @FindBy(xpath = "//body[1]/div[7]/div[1]/div[3]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[3]/td[1]/div[1]")
    private WebElement activityLogThirdEntry;

    @FindBy(xpath = "//tbody/tr[1]/td[2]/span[1]")
    private WebElement entryOneContactName;

    @FindBy(xpath = "//tbody/tr[2]/td[2]/span[1]")
    private WebElement entryTwoContactName;

    @FindBy(xpath = "//tbody/tr[3]/td[2]/span[1]")
    private WebElement entryThreeContactName;

    @FindBy(xpath = "/html/body/div[7]/div/div[3]/div/div/div[2]/div/div[1]/div/button/div")
    private WebElement actionsMenu;

    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    private WebElement deleteOption;

    private String firstContactName;
    private String secondContactName;
    private String thirdContactName;

    public void goToActivityLogPage() {
        wait.forElementToBeDisplayed(5, reportsAndSettingsMenu, "reportsAndSettingsMenu");
        reportsAndSettingsMenu.click();
        wait.forElementToBeDisplayed(5, activityLogSubMenu, "activityLogSubMenu");
        activityLogSubMenu.click();
        wait.forElementToBeDisplayed(10, activityLogTitle, "activityLogTitle");
        wait.forceWait(10);
        String actualActivityLogTitleText = activityLogTitle.getText();
        LOGGER.info("Verifying the activity log title text");
        assertThat("ACTIVITY LOG")
                .as("Activity log page title doesn't match!")
                .isEqualTo(actualActivityLogTitleText);
        LOGGER.info("User is on the Activity log page");
    }

    public void deleteActivityLogs() {
        firstContactName = entryOneContactName.getText();
        secondContactName = entryTwoContactName.getText();
        thirdContactName = entryThreeContactName.getText();

        wait.forElementToBeDisplayed(10, activityLogFirstEntry, "activityLogFirstEntry");
        LOGGER.info("Selecting first three items from activity log list");
        activityLogFirstEntry.click();
        activityLogSecondEntry.click();
        activityLogThirdEntry.click();
        wait.forceWait(2);
        LOGGER.info("Selecting first three items from the activity log list");
        actionsMenu.click();

        // Execute JavaScript code to click the desired option
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].selectedIndex = 0; arguments[0].dispatchEvent(new Event('delete'));", actionsMenu);

        LOGGER.info("Deleting first three items from the activity log list");
        wait.forceWait(5);
    }

    public void verifyTheDeletedItems() {
        assertThat(firstContactName)
                .as("First entry from activity log is not deleted!")
                .isEqualTo(entryOneContactName.getText());
        assertThat(secondContactName)
                .as("Second entry from activity log is not deleted!")
                .isEqualTo(entryTwoContactName.getText());
        assertThat(thirdContactName)
                .as("Third entry from activity log is not deleted!")
                .isEqualTo(entryThreeContactName.getText());
    }
}
