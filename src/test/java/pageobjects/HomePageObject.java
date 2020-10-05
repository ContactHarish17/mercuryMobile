package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.lang.annotation.Native;

public class HomePageObject extends MainPageObject {

    public HomePageObject(AndroidDriver<MobileElement> driver)
    {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Welcome']")
    public MobileElement WelcomePage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='10 Reward Points Earned!']")
    public MobileElement RewardPoint;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Quick Learning']")
    public MobileElement QuickLearning;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reach Out!']")
    public MobileElement ReachOut;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Quote & Policy Delivery']")
    public MobileElement Policy;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Earn Your First Commission']")
    public MobileElement Commission;

    // @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='OK']")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']")
    public MobileElement MenuButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='10']")
    public MobileElement earnedpoints;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='START WITH QUICK LEARNING TOUR']")
    public MobileElement StartQuickLearning;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='0']")
    public MobileElement OTP1;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='0']")
    public MobileElement OTP2;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='0']")
    public MobileElement OTP3;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='3']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='0']")
    public MobileElement OTP4;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    public MobileElement home;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contacts']")
    public MobileElement contacts;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Activities']")
    public MobileElement activities;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Prospects']")
    public MobileElement prospects;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Customers']")
    public MobileElement customers;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
    public MobileElement products;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Learning']")
    public MobileElement learning;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Targets and Digital Wallets']")
    public MobileElement targets;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    public MobileElement settings;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='3']/android.view.ViewGroup[@index='1']/android.widget.ImageView[@index='0']")
    public MobileElement profileIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Saudi Citizen Check']")
    public MobileElement saudicheck;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter national Id']")
    public MobileElement nationalID;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='5']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0')")
    @AndroidFindBy(xpath = "//*{class=")
    public MobileElement dob;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GET DETAILS']")
    public MobileElement getDetailsButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='VERIFY']")
    public MobileElement verifybutton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter OTP']")
    public MobileElement enterOTP;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Anytime, Anywhere']")
    public  MobileElement FirstCarouselTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your phone is your office']")
    public  MobileElement FirstCarouselSubTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Be Partner With Al Rajhi Takaful']")
    public  MobileElement ThirdCarouselTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='And boast about it']")
    public  MobileElement ThirdCarouselSubTitle;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.widget.EditText[@index='0']")
    public MobileElement userNameField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='4']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.widget.EditText[@index='0']")
    public MobileElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='LOGIN']")
    public MobileElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[text='Change Password']")
    public MobileElement changePassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[text='Forgot Password ?']")
    public MobileElement forgotPassword;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='عربى']")
    public  MobileElement arabicLanguage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Targets and Digital Wallet']")
    public  MobileElement targetandwalletText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Take Immediate Action']")
    public  MobileElement takeactionText;




}
