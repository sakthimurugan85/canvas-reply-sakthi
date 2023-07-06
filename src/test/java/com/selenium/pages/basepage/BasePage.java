package com.selenium.pages.basepage;

import com.selenium.driver.SetUp;
import com.selenium.driver.Wait;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected Wait wait;

    public BasePage() {
        this.driver = SetUp.driver;
        this.wait = new Wait(this.driver);
    }
}
