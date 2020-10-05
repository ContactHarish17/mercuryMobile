package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.aspectj.lang.annotation.AdviceName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaudiCheckPageObjects extends MainPageObject {

    public SaudiCheckPageObjects(AndroidDriver<MobileElement> driver)
    {
        super(driver);
    }

       @AndroidFindBy(xpath = "//android.widget.TextView[@text='Saudi Citizen Check']")
       public MobileElement saudiCheckTitle;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@text='Enter national Id']")
    //@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter national Id']")
    public MobileElement nationalID;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.ImageView[@index='1']")
    public MobileElement dob;

    //@AndroidFindBy(id = "android:id/date_picker_header_year")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='2020']")
    public  MobileElement yearButton;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1971']")
    public MobileElement partnerBirthYear;

    //@AndroidFindBy(xpath = "//android.view.View[@content-desc='21 August 1971']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='August']")
    public MobileElement partnerBirthMoth;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='21']")
    public MobileElement partnerBirthDay;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    public MobileElement OkButton;

   // @AndroidFindBy(id = "android:id/next")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='>']")
    public  MobileElement nextMonthButton;

    @AndroidFindBy(xpath = "//android.view.View[@text='5']")
    public  MobileElement partnerBirthdate;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GET DETAILS']")
    public MobileElement getDetailsButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='VERIFY']")
    public MobileElement verifyButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Update Profile']")
    public MobileElement updateprofile;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    public MobileElement datePicker;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GET DETAILS']")
    public MobileElement getdetailsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify']")
    public  MobileElement verifyTitle;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='VERIFY']")
    public MobileElement verifyOTP;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Saudi Citizen Check']")
    public MobileElement saudiCitizenCheck;





}
