package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends MainPageObject {

    public RegisterPage(AndroidDriver<MobileElement> driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//html/body/div[3]/div[1]/div[2]/div/div/a[2]")
    public WebElement ArabicButton;

    @FindBy(xpath = "//html/body/div[3]/div[1]/div[2]/div/div/a[1]")
    public WebElement EnglishButton;

    @FindBy(xpath = "//*[contains(text(),'Are you a Saudi Citizen?')]")
    public WebElement SaudiCheck;

    @FindBy(xpath = "//*[@id=\"CFE90E99-8332-43FD-BE89-1AA708A9AF10\"]/div/div[1]/a[2]")
    public WebElement NonSaudi;

    @FindBy(xpath = "//*[@id=\"saudhiReferral\"]/div/div/a[1]")
    public WebElement nosaudi_yesmaybeButton;

    @FindBy(xpath = "//*[@id=\"saudhiReferral\"]/div/div/a[2]")
    public WebElement nonsaudi_noButton;

    @FindBy(xpath = "//*[@id=\"inviteName\"]")
    public WebElement invitename;

    @FindBy(xpath = "//*[@id=\"inviteMobile\"]")
    public WebElement invitemobile;

    @FindBy(xpath = "//*[@id=\"inviteEmail\"]")
    public WebElement inviteemail;

    @FindBy(xpath = "//*[@id=\"form-list\"]/div/div[2]/h3")
    public WebElement invitedName;

    @FindBy(xpath = "//*[@id=\"form-list\"]/div/div[2]/p[1]/span[2]")
    public WebElement invitedmobile;

    @FindBy(xpath = "//*[@id=\"form-invite\"]")
    public WebElement inviteNow;

    @FindBy(xpath = "//*[@id=\"form-invite-cancel\"]")
    public WebElement cancelInvite;

    @FindBy(xpath = "//*[@id=\"referralThankyou\"]/div/div/h2")
    public WebElement thankyoumessage;

    @FindBy(xpath = "//*[@id=\"add-item-id\"]")
    public WebElement addnew;


    @FindBy(xpath = "//*[@id=\"CFE90E99-8332-43FD-BE89-1AA708A9AF10\"]/div/div[1]/a[1]")
    public WebElement Saudi;

    @FindBy(css = "input[id=\"mobileNumber\"]")
    public WebElement MobileNumber;

   // @FindBy(css = "input[id=\"checkbox12-FB92CEC7-ECE7-4559-BFD7-C600F7EB0F5A\"][value=\"true\"]")
    @FindBy(xpath = "//*[@id=\"FB92CEC7-ECE7-4559-BFD7-C600F7EB0F5A\"]/form/div[3]/label/input[2]")
    public WebElement CheckBox_Terms;

    @FindBy(css = "input[id=\"otpDigit_1\"]")
    public WebElement otp1;

    @FindBy(css = "input[id=\"otpDigit_2\"]")
    public WebElement otp2;

    @FindBy(css = "input[id=\"otpDigit_3\"]")
    public WebElement otp3;

    @FindBy(css = "input[id=\"otpDigit_4\"]")
    public WebElement otp4;


    //@FindBy(css = "input[name=\"ConsentCheckBox\"]")
 //   @FindBy(xpath = "//label[@for='checkbox12-FB92CEC7-ECE7-4559-BFD7-C600F7EB0F5A']")
   // @FindBy(xpath = "//label[contains(@class,'checkmark')]")
   // @FindBy(xpath = "//*[@id='checkbox12-FB92CEC7-ECE7-4559-BFD7-C600F7EB0F5A']//parent::*")
    //@FindBy(xpath = ".//*[@class='checkmark']/parent::*")
    //@FindBy(xpath = "//*[@class=\"checkbox-content\"]/label")
    @FindBy(xpath = "//*[@class='checkmark']//parent::*")
    public WebElement consentCheckBox;

    @FindBy(xpath = "//*[contains(text(),'Next')]")
    public WebElement NextButton;

    @FindBy(xpath = "//*[contains(text(),'START WITH QUICK LEARNING TOUR')]")
    public WebElement startwithQLT;

    @FindBy(xpath = "//*[contains(text(),'Quick Learning')]")
    public WebElement quicklearning;

    @FindBy(xpath = "//*[contains(text(),'Reach Out!')]")
    public WebElement reachout;

    @FindBy(xpath = "//*[contains(text(),'Quote & Policy Delivery')]")
    public WebElement quotepolicy;

    @FindBy(xpath = "//*[contains(text(),'Earn Money easily')]")
    public WebElement earnMoney;

    @FindBy(xpath = "//*[contains(text(),'ADD CONTACT')]")
    public WebElement addContactButton;

    @FindAll(

            {
                    @FindBy(id = "validateOTP"),
                    @FindBy(xpath = "//*[@id=\"validateOTP\"]")
            }
    )
    public WebElement validateOTP;



    @FindBy(id = "Resend")
    public WebElement ResendButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your name ']")
    public MobileElement FullName;

    @FindBy(id="gender")
    public WebElement gender;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your email']")
    public MobileElement email;


  //  @AndroidFindBy(xpath = "//android.widget.Button[@text='LET'S GET STARTED']")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@index='4']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.Button[@index='0']")
    public MobileElement letsGetStarted;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='One Last Feet!']")
    public MobileElement onelastFeet;


}
