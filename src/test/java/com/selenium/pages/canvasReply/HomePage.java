package com.selenium.pages.canvasReply;

import com.selenium.pages.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    private static final String HOME_PAGE_URL = "https://demo.1crmcloud.com";

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login_user")
    private WebElement userName;

    @FindBy(id = "login_pass")
    private WebElement password;

    @FindBy(id = "login_button")
    private WebElement loginButton;

    @FindBy(id = "main-title-module")
    private WebElement homeDashboardTitle;

    public void goToHomePage() {
        driver.get(HOME_PAGE_URL);
        wait.forLoading(5);
    }

    public void loginAction() {
        wait.forElementToBeDisplayed(5, userName, "UserNameField");
        userName.sendKeys("admin");
        wait.forElementToBeDisplayed(5, password, "PasswordField");
        password.sendKeys("admin");
        wait.forElementToBeDisplayed(5, loginButton, "LoginButton");
        loginButton.click();
        wait.forceWait(5);
        wait.forElementToBeDisplayed(5, homeDashboardTitle, "HomeDashboardTitle");
        String actualHomeDashboardText = homeDashboardTitle.getText();
        LOGGER.info("Verifying the home dashboard title text");
        Assert.assertEquals("HOME DASHBOARD", actualHomeDashboardText);
        LOGGER.info("User successfully logged in to CRM");
    }

}
