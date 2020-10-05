package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.aspectj.lang.annotation.AdviceName;

public class ARTOnBoardingPageObjects extends  MainPageObject{

    public ARTOnBoardingPageObjects(AndroidDriver<MobileElement> androidDriver)
    {
        super(androidDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='SIGN UP NOW']")
    public MobileElement SiginUpNowButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    public MobileElement languageToggleButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Anytime, Anywhere']")
    public MobileElement anytimeanywhere;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your phone is your office']")
    public MobileElement yourphoneyouroffice;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='3']/android.widget.TextView[@index='0']")
    public MobileElement screen1text;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    public MobileElement Languagetogglebutton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='LOGIN']")
    public MobileElement LoginButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    public MobileElement BackButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='First things first']")
    public MobileElement carousel2_tile1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Are you a Saudi Citizen?']")
    public MobileElement carousel2_title2;

    @AndroidFindBy(xpath="//android.view.ViewGroup[@index='2']/android.widget.TextView[@index='0] ")
    public MobileElement carousel_title3;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='3']/android.widget.Button[@text='YES, I AM']")
    public MobileElement YesTAMButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Are you a Saudi Citizen?']")
    public MobileElement SaudiCitizen;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Thank you!']")
    public MobileElement Thankyou;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='If you have Saudi friends you can always invite them!']")
    public MobileElement thankyoutext;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='0']/android.widget.Button[@index='0']")
    public MobileElement closebutton;

    //@AndroidFindBy(xpath = "//android.widget.Button[@text='NO, I AM NOT']")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='3']/android.view.ViewGroup[@index='1']/android.widget.Button[@index='0']")
    public MobileElement NoTAMNotButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Just a step away!']")
    public MobileElement carousel3_ttitle2;

   // @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.TextView[@text='+966']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='+966']")
    public MobileElement countrycode;

    //@AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='2']/android.widget.EditText[@text='Enter Mobile Number']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='5XXXXXXXX' and @index='0']")
    public MobileElement phonenumber;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.widget.Button[@index='0']")
    public MobileElement generateOTP;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='10']")
    public MobileElement checkBox;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter OTP']")
    public MobileElement enterOTPtext;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']/android.widget.TextView[@index='0']")
    public MobileElement OTP_title1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Resend it']")
    public MobileElement resendButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='VERFIY']")
    public MobileElement verifyButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NO,I WOULDN'T"+"']")
//    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='3']/android.view.ViewGroup[@index='1']/android.widget.Button[@index='0']")
    public MobileElement NoIWouldNotButton;

    //@AndroidFindBy(xpath = "//android.widget.Button[@text='YES, MAYBE']")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='3']/android.view.ViewGroup[@index='0']/android.widget.Button[@index='0']")
    public MobileElement YesMayBeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Before you leave']")
    public MobileElement BeforeYouLeave;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='4']")
    public MobileElement nonsaudiTitle;

//    @AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
//    public MobileElement thankyoutext;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='3']")
    public MobileElement nonsaudiExitTile;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='8']")
    public MobileElement GenerateOTP;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
    public MobileElement enterOTPTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='And boast about it']")
    public MobileElement thirdCarousel;

    @AndroidFindBy(xpath = "//android.widget.TextView[#text='Be Partner With Al Rajhi Takaful']")
    public MobileElement thirdCarouselText;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='SIGN UP NOW']")
    public MobileElement signUPButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='LOGIN']")
    public MobileElement loginButton;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='0']")
    public MobileElement OTP1;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='0']")
    public MobileElement OTP2;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='0']")
    public MobileElement OTP3;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='3']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='0']")
    public MobileElement OTP4;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Resend it']")
    public MobileElement ResendButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='VERIFY']")
    public MobileElement VerifyButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter OTP']")
    public MobileElement EnterOTPScreen;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
    public MobileElement NextButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='3']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.Button[@index='0']")
    public MobileElement checkboxTC;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your name']")
    //@AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@text='Enter your name' and @index='0']")
    public MobileElement partnerName;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='FEMALE' and @index='0']")
    public MobileElement genderButtoon;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your email']")
    public MobileElement partnerEmail;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='LET'S GET STARTED' and @index='0']")
    public MobileElement letsgetStartedButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='One Last Feet!']")
    public MobileElement onelastFeatText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Just a step away!']")
    public MobileElement mobilenumberTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Becoming Al Rajhi Takaful partner is']")
    public MobileElement mobilenumberSubTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter OTP']")
    public MobileElement enterOTPText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Resend it']")
    public MobileElement resendOTP;




}

