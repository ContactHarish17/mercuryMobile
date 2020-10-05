package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.validator.routines.checkdigit.ABANumberCheckDigit;

public class GenerateQuotePageObject extends  MainPageObject {

    public GenerateQuotePageObject(AndroidDriver<MobileElement> androidDriver)
    {
        super(androidDriver);
    }


    @AndroidFindBy(xpath = "//android.widget.Button[@text='MULTI VEHICLE']")
    public MobileElement multivehicleButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement vehicleOwnerID;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='1']/android.widget.ImageView[@index='0']")
    public MobileElement ownerDOB;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='0']/android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@text='Enter Sequence No']")
    public MobileElement sequenceNumberOne;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']/android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@text='Enter Sequence No']")
    public MobileElement sequenceNumbertwo;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@text='Enter Sequence No']")
    public MobileElement sequenceNumberThree;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='ADD A VEHICLE']")
    public MobileElement Addvehcilebutton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GET DETAILS']")
    public MobileElement getDetailsButton;

}
