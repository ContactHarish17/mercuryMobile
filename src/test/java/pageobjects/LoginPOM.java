package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPOM extends MainPageObject {

    public LoginPOM(AndroidDriver<MobileElement> androidDriver)
    {
        super(androidDriver);
    }


    @AndroidFindBy(id = "android:id/button1")
    public MobileElement installupdate;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log In']")
    public MobileElement login;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Register']")
    public MobileElement Register;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log in with Employee SSO ID']")
    public MobileElement ssologin;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='US & Canada']")
    public MobileElement region;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
    public MobileElement savebutton;

    @AndroidFindBy(id = "username")
    public MobileElement name;

    @AndroidFindBy(id = "username")
    public MobileElement Username;

    @AndroidFindBy(id = "password")
    public MobileElement pwd;

    @AndroidFindBy(id = "submitFrm")
    public MobileElement loginButton;


}
