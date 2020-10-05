package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.annotation.Native;

public class ProspectPageObjects extends MainPageObject {

    public ProspectPageObjects(AndroidDriver<MobileElement> driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//*[@class=\"cell medium-6 large-6 small-12 \"]/h2")
    public WebElement prospecttitle;

    @FindBy(id="pro-search-tab-1-label")
    public WebElement individual;

    @FindBy(id="pro-search-tab-2-label")
    public WebElement orgnizations;

    @FindBy(xpath = "//*[@id=\"pro-search-tab-2-label\"]/span[1]")
    public WebElement orgnizationText;

    @FindBy(xpath = "//*[@id=\"pro-search-tab-1-label\"]/span[1]")
    public WebElement individualText;

    @FindBy(xpath = "//*[@id=\"pro-search-tab-2-label\"]/span[2]")
    public WebElement orgnizationCount;

    @FindBy(xpath = "//*[@id=\"pro-search-tab-1-label\"]/span[2]")
    public WebElement individualCount;

    @FindBy(xpath = "//*[@id=\"pro-search-tab-1\"]/div[1]/ul/li")
    public WebElement prospectsort;

    @FindBy(xpath = "//*[@id=\"sort-by\"]/li[1]/a")
    public WebElement mostrecentsort;

    @FindBy(xpath = "//*[@id=\"sort-by\"]/li[2]/a")
    public WebElement quotestatussort;

    @FindBy(xpath = "//*[@id=\"serachList\"]/div[1]/div[3]/a")
    public WebElement createNewQuoteButton;

    @FindBy(id="viewQuote")
    public WebElement prospectInitial;

   // @FindBy(xpath = "//*[@id=\"serachList\"]/div[1]/div[2]/h4")
    @FindBy(xpath = "//*[contains(text(),\"Harish\")]")
    public WebElement prospectName;

   // @FindBy(xpath = "//*[@id=\"serachList\"]/div[1]/div[2]/div[1]/text()")
    @FindBy(xpath = "//*[contains(text(),\"Not quoted\")]")
    public WebElement prospectstatus;

    @FindBy(xpath = "//*[@id=\"serachList\"]/div[2]/a")
    public WebElement addmorebutton;

    @FindBy(id = "search-input")
    public WebElement searchprospect;

    @FindBy(xpath = "//*[@class=\"search-btn\"]/i")
    public WebElement searchIcon;

    @FindBy(id="sort-by")
    public WebElement prospectsortmenu;

    @FindBy(xpath = "//*[@id=\"serachList\"]/p")
    public WebElement noprospecttext;

    @FindBy(xpath = "//android.widget.TextView[@text='Congratulations! Since you have made your first successful contact with Khalid, he is already added to your Prospects.']")
    public MobileElement prospectsuccessmessage;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    public  MobileElement closeButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search']")
    public MobileElement prospectsearch;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='CREATE NEW QUOTE']")
    public MobileElement createQuote;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Generate A Quote']")
    public MobileElement generateQuoteText;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement ownerID;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.ImageView[@index='1']")
    public MobileElement ownerDOB;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter Sequence No']")
    public  MobileElement sequencenumber;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GET DETAILS']")
    public MobileElement getDetailsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Processing please wait ...']")
    public  MobileElement quoteprocessing;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Total Premium']")
    public MobileElement totalpremium;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.widget.Button[@index='0']")
    public MobileElement drivingexpdropdown;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='7']")
    public MobileElement drivingexp;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='4']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.widget.Button[@index='0']")
    public MobileElement drivingusagedropdown;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='111 - Commercial Use - Governement Vehicle']")
    public MobileElement drivingusage;

    @AndroidFindBy(xpath ="//android.widget.Button[@text='CALCULATE PREMIUM']")
    public  MobileElement calculatePremium;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.widget.ImageView[@index='1']")
    public  MobileElement sharequote;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='1']/android.widget.TextView[@index='0']")
    public MobileElement premiumamount;


    @AndroidFindBy(xpath = "//android.widget.Button[@text='2020']")
    public MobileElement owneryear;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1959']")
    public  MobileElement sequenceYear;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='June']")
    public MobileElement montNavigate;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='December']")
    public MobileElement sequqnceMonth;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='30']")
    public MobileElement sequenceday;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    public MobileElement datepickerOK;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Prospect']")
    public MobileElement prospectTitle;


    @AndroidFindBy(xpath = "//android.widget.Button[@text='ORGANIZATION']")
    public MobileElement organizationTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Processing please wait ...']")
    public MobileElement processingMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Policy Type']")
    public MobileElement policyType;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wafi Basic']")
    public MobileElement basicQuoteType;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wafi Smart']")
    public MobileElement smartQuoteType;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wafi Comprehensive']")
    public MobileElement ComprehensiveQuoteType;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Show Comparison']")
    public MobileElement Policycomparsion;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    public MobileElement driverUsageOKButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Owner & Driver Details']")
    public MobileElement ownerDetails;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Vehicle Details']")
    public MobileElement vehicleDetails;


    @AndroidFindBy(xpath = "//android.widget.Button[@text='SEND A REMINDER']")
    public MobileElement sendReminderButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Waiting for quotation confirmation']")
    public MobileElement waitingforConsent;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create New Quote']")
    public MobileElement createNewQuote;




}
