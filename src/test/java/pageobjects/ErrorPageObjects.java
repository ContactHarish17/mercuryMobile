package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorPageObjects extends MainPageObject {

    public ErrorPageObjects(AndroidDriver<MobileElement> driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//*[@class=\"showValidationSummary form-error is-visible mt20\"]")
    public WebElement otperrormessage;

    @FindBy(id = "mobileNumber-error")
    public WebElement mobilenumberError;

    @FindBy(id = "ConsentCheckBox-error")
    public WebElement consentCheckboxError;

    @FindBy(id = "FullName-error")
    public WebElement fullnameError;

    @FindBy(id="MobileNumber-error")
    public WebElement contactmobilenumberError;

    @FindBy(id = "noErr")
    public WebElement noactiivitycontacterror;

    @FindBy(xpath = "//*[contains(text(),\"Please select the Activity Title!\")]")
    public WebElement activitytitleError;

    @FindBy(xpath = "//*[contains(text(),\"Please select the Activity Type!\")]")
    public WebElement activityTypeError;

    @FindBy(xpath = "//*[contains(text(),\"Please enter the valid date format!\")]")
    public WebElement activitydateError;

    @FindBy(xpath = "//*[contains(text(),\"Please enter the valid time!\")]")
    public WebElement activitytimeError;
}
