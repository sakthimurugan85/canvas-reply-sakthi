package com.selenium.pages.canvasReply;

import com.selenium.pages.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.apache.commons.lang3.RandomStringUtils.*;

public class ContactsPage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsPage.class);

    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "grouptab-1")
    private WebElement salesAndMarketingMenu;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    private WebElement contactsSubMenu;

    @FindBy(id = "main-title-module")
    private WebElement contactsTitle;

    @FindBy(xpath = "//*[@id=\"left-sidebar\"]/div[2]/a")
    private WebElement createContactSubMenu;

    @FindBy(xpath = "//p[contains(text(),'First Name')]")
    private WebElement firstNameFieldLabel;

    @FindBy(id = "main-title-text")
    private WebElement newRecordTitleText;

    @FindBy(id = "DetailFormfirst_name-input")
    private WebElement firstNameInputField;

    @FindBy(id = "DetailFormlast_name-input")
    private WebElement lastNameInputField;

    @FindBy(id = "DetailFormtitle-input")
    private WebElement newContactTitleField;

    @FindBy(id = "DetailFormemail1-input")
    private WebElement contactPrimaryEmailField;

    @FindBy(id = "DetailFormphone_work-input")
    private WebElement workPhoneNumberField;

    @FindBy(id = "DetailFormdepartment-input")
    private WebElement contactDepartmentField;

    @FindBy(id = "DetailFormprimary_address_street-input")
    private WebElement contactPrimaryAddressField;

    private WebElement contactBusinessRoleDropdown;

    @FindBy(id = "DetailFormprimary_address_city-input")
    private WebElement contactCityField;

    @FindBy(id = "DetailFormprimary_address_state-input")
    private WebElement contactStateField;

    @FindBy(id = "DetailFormprimary_address_country-input")
    private WebElement contactCountryField;

    @FindBy(id = "DetailFormprimary_address_postalcode-input")
    private WebElement contactPostcodeField;

    @FindBy(id = "DetailFormdescription-input")
    private WebElement contactDescriptionField;

    @FindBy(id = "DetailForm_save2")
    private WebElement createContactSaveButton;

    @FindBy(id = "main-title-text")
    private WebElement newlyAddedContactTitle;

    @FindBy(id = "_form_header")
    private WebElement firstNameLastnameLabelField;

    @FindBy(id = "_form_subheader")
    private WebElement newContactTitleLabelField;

    @FindBy(className = "tabDetailViewDFLink")
    private WebElement contactPrimaryEmailLabelField;

    @FindBy(xpath = "//*[@id=\"le_section__summary\"]/div/div[2]/div/div[1]/div[4]/span[1]/span[2]")
    private WebElement workPhoneNumberLabelField;

    @FindBy(xpath = "//*[@id=\"main-0\"]/div[1]/div[1]/div/div")
    private WebElement contactDepartmentLabelField;

    public String contactFirstName;
    public String contactLastname;
    public String contactTitle;
    public String contactPrimaryEmail;
    public String workPhoneNumber;
    public String contactDepartment;
    public String contactPrimaryAddress;
    public String contactCity;
    public String contactState;
    public String contactCountry;
    public String contactPostcode;
    public String contactDescription;

    public void goToContactsPage() {
        wait.forElementToBeDisplayed(5, salesAndMarketingMenu, "SalesAndMarketingMenu");
        salesAndMarketingMenu.click();
        wait.forElementToBeDisplayed(5, contactsSubMenu, "ContactsSubMenu");
        contactsSubMenu.click();
        wait.forElementToBeDisplayed(10, contactsTitle, "ContactsTitle");
        wait.forceWait(10);
        String actualContactsTitleText = contactsTitle.getText();
        LOGGER.info("Verifying the contacts page title text");
        assertThat("CONTACTS")
                .as("Contacts page title doesn't match!")
                .isEqualTo(actualContactsTitleText);
        LOGGER.info("User is on contacts page");
    }

    public void goToCreateContactPage() {
        wait.forElementToBeDisplayed(10, createContactSubMenu, "CreateContactSubMenu");
        createContactSubMenu.click();
        wait.forceWait(5);
        wait.forElementToBeDisplayed(5, firstNameFieldLabel, "firstNameFieldLabel");
        String actualNewContactTitleText = newRecordTitleText.getText();
        LOGGER.info("Verifying the create new contact page title text");
        assertThat("(NEW RECORD)")
                .as("New contact page title text doesn't match!")
                .isEqualTo(actualNewContactTitleText);
        LOGGER.info("User is on the create new contact page");
    }

    public void fillNewContactForm() {
        contactFirstName = "Auto_FN_" + randomAlphabetic(10);
        contactLastname = "Auto_LN_" + randomAlphabetic(10);
        contactTitle = randomAlphabetic(2).toUpperCase();
        contactPrimaryEmail = "Auto_PEmail_" + randomAlphabetic(10) + "@test.com";
        workPhoneNumber = "07" + randomNumeric(9);
        contactDepartment = "Auto_Dep_" + randomAlphabetic(5);
        contactPrimaryAddress = "Auto_Address_" + randomAlphabetic(10);;
        contactCity = "Auto_City_" + randomAlphabetic(5);
        contactState = "Auto_State_" + randomAlphabetic(5);
        contactCountry = "Auto_Coun_" + randomAlphabetic(5);
        contactPostcode = randomAlphabetic(2)
                + randomNumeric(1)
                + " "
                + randomNumeric(1)
                + randomAlphabetic(2);
        contactDescription = "Auto_Desc_" + randomAlphabetic(20);

        wait.forElementToBeDisplayed(5, firstNameInputField, "firstNameInputField");
        firstNameInputField.sendKeys(contactFirstName);
        lastNameInputField.sendKeys(contactLastname);
        newContactTitleField.sendKeys(contactTitle);
        contactPrimaryEmailField.sendKeys(contactPrimaryEmail);
        workPhoneNumberField.sendKeys(workPhoneNumber);
        contactDepartmentField.sendKeys(contactDepartment);
        contactPrimaryAddressField.sendKeys(contactPrimaryAddress);
        contactCityField.sendKeys(contactCity);
        contactStateField.sendKeys(contactState);
        contactCountryField.sendKeys(contactCountry);
        contactPostcodeField.sendKeys(contactPostcode);
        contactDescriptionField.sendKeys(contactDescription);

        createContactSaveButton.click();
        wait.forceWait(10);

        wait.forElementToBeDisplayed(5, newlyAddedContactTitle, "newlyAddedContactTitle");
        String actualNewContactTitleText = newlyAddedContactTitle.getText();
        LOGGER.info("Verifying the newly created contact title text");
        assertThat(actualNewContactTitleText)
                .as("Campaign sign up status doesn't match!")
                .contains("AUTO");
        LOGGER.info("User is on the newly created contact details page");
    }

    public void verifyTheNewContactDetails() {
        String expectedContactName = contactFirstName + " " + contactLastname;
        LOGGER.info("Trying to get contact's full name from contact details page");
        String actualContactName = firstNameLastnameLabelField.getText();
        assertThat(actualContactName.trim())
                .as("New contact first and last name doesn't match!")
                .isEqualTo(expectedContactName);
        assertThat(newContactTitleLabelField.getText().trim())
                .as("New contact title doesn't match!")
                .isEqualTo(contactTitle);
        assertThat(contactPrimaryEmailLabelField.getText())
                .as("New contact primary email doesn't match!")
                .isEqualTo(contactPrimaryEmail);
        assertThat(workPhoneNumberLabelField.getText())
                .as("New contact work phone number doesn't match!")
                .isEqualTo(workPhoneNumber);
    }
}
