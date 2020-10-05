package TestScripts;

import io.appium.java_client.MobileElement;
import maindriver.DriverFunction;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.*;
import utility.Constant;
import utility.DeviceList;
import utility.ReadExcel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ARTMobileQuoteCreation extends DriverFunction {

    HomePageObject homePageObjects;
    ContactPageObject contactPageObjects;
    ARTOnBoardingPageObjects artOnBoardPageObjects;
    ActivityPageObjects activityPageObject;
    QuizPageObjects quizPageObjects;
    SaudiCheckPageObjects saudiCheckPageObjects;
    ProspectPageObjects prospectPageObjects;
    RegisterPage registerPage;

    public void initialisePageObjects() {


        homePageObjects = new HomePageObject(androidDriver);
        contactPageObjects = new ContactPageObject(androidDriver);
        artOnBoardPageObjects = new ARTOnBoardingPageObjects(androidDriver);
        activityPageObject = new ActivityPageObjects(androidDriver);
        quizPageObjects = new QuizPageObjects(androidDriver);
        saudiCheckPageObjects = new SaudiCheckPageObjects(androidDriver);
        prospectPageObjects = new ProspectPageObjects(androidDriver);
        registerPage = new RegisterPage(androidDriver);
        try {
            createrReport("ART MobileAPP Automation", DeviceList.dname, DeviceList.id, DeviceList.osName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ReadExcel.OpenExcel(Constant.ExcelFilepath);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

    }



    @Test(priority = 1)
    public void testOpenARTApp() throws InterruptedException {
        initialisePageObjects();
        waitForElementPresent(artOnBoardPageObjects.languageToggleButton, 60);
        startTest("Open ART APP", "Test to opens the app", "smoke");
        try {
            elementDisplayed(androidDriver, artOnBoardPageObjects.languageToggleButton);
            elementDisplayed(androidDriver, artOnBoardPageObjects.anytimeanywhere);

            Thread.sleep(4000);
        } catch (Exception e) {
        }
    }

    @Test(priority = 2)
    public void testSwipeCarousle() {
        startTest("Swipe Carousel", "test to check whether we can swipe carousel", "smoke");
        {
            waitForElementPresent(artOnBoardPageObjects.loginButton, 120);
            try {
                elementDisplayed(androidDriver,artOnBoardPageObjects.signUPButton);
                elementDisplayed(androidDriver,artOnBoardPageObjects.loginButton);
            } catch (Exception e) {
                e.printStackTrace();
            }
            scrollHorizontal(androidDriver, homePageObjects.ThirdCarouselTitle);
            tapButton(androidDriver, artOnBoardPageObjects.loginButton, false);
            //      waitForElementPresent(artOnBoardPageObjects.SaudiCitizen, 60);
        }

    }

    @Test(priority = 3)
    public void testSignUPARTApp() {
        try {
            startTest("Sign UP", "check whether new saudi user can sign up", "smoke");
            waitForElementPresent(artOnBoardPageObjects.phonenumber, 60);
            elementDisplayed(androidDriver,artOnBoardPageObjects.mobilenumberTitle);
            elementDisplayed(androidDriver,artOnBoardPageObjects.mobilenumberSubTitle);
            System.out.println("****************************************************************************");
            System.out.println("the country code is " + artOnBoardPageObjects.countrycode.getText());
            System.out.println("****************************************************************************");
            int partnerMobile = new Double(ReadExcel.getCellData(Constant.LoggedInUser, 1, 0)).intValue();
            System.out.println("The Partner Mobile is " + partnerMobile);
            Thread.sleep(5000);
            artOnBoardPageObjects.phonenumber.click();
            enterText(androidDriver,artOnBoardPageObjects.phonenumber,String.valueOf(partnerMobile));
            artOnBoardPageObjects.countrycode.isDisplayed();
            Thread.sleep(2000);
            androidDriver.hideKeyboard();
            tapButton(androidDriver,artOnBoardPageObjects.NextButton,false);
           // artOnBoardPageObjects.NextButton.click();
            waitForScreenToLoad(androidDriver,artOnBoardPageObjects.enterOTPtext,60);
        } catch (Exception e) {
        }
    }

    @Test(priority = 4)
    public void testOTPGenerated() throws Exception {
        startTest("OPT Generated", "Checking OTP generated", "smoke");

        elementDisplayed(androidDriver,artOnBoardPageObjects.enterOTPText);
        elementDisplayed(androidDriver,artOnBoardPageObjects.resendOTP);
        enterText(androidDriver,homePageObjects.OTP1,"9");
        enterText(androidDriver,homePageObjects.OTP2,"9");
        enterText(androidDriver,homePageObjects.OTP3,"9");
        enterText(androidDriver,homePageObjects.OTP4,"9");
        androidDriver.hideKeyboard();
        tapButton(androidDriver, artOnBoardPageObjects.VerifyButton, false);

    }

    @Test(priority = 5)
    public void testLoginL1User() throws Exception {
        startTest("L1 user", "test to check logging using L1 user", "Login");
        waitForScreenToLoad(androidDriver,homePageObjects.userNameField,60);
        tapButton(androidDriver,homePageObjects.userNameField,false);
        enterText(androidDriver,homePageObjects.userNameField,ReadExcel.getCellData(Constant.LoggedInUser, 1, 1));
        tapButton(androidDriver,homePageObjects.passwordField,false);
        enterText(androidDriver,homePageObjects.passwordField,ReadExcel.getCellData(Constant.LoggedInUser, 1, 2));
       // elementDisplayed(androidDriver,homePageObjects.changePassword);
       // elementDisplayed(androidDriver,homePageObjects.forgotPassword);
        androidDriver.hideKeyboard();
        tapButton(androidDriver,homePageObjects.loginButton,false);
        waitForScreenToLoad(androidDriver,homePageObjects.targetandwalletText,60);

    }

    @Test(priority = 6)
    public void testMenuItems() throws Exception {
        startTest("Menu Items", "test to check menu items are dispplayed", "MenuItems");
        tapButton(androidDriver, homePageObjects.MenuButton, false);
        try {
            elementDisplayed(androidDriver, homePageObjects.home);
            elementDisplayed(androidDriver, homePageObjects.contacts);
            elementDisplayed(androidDriver, homePageObjects.activities);
            elementDisplayed(androidDriver, homePageObjects.prospects);
            elementDisplayed(androidDriver,homePageObjects.customers);
            elementDisplayed(androidDriver,homePageObjects.products);
            elementDisplayed(androidDriver,homePageObjects.settings);
            elementDisplayed(androidDriver,homePageObjects.learning);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 7)
    public void testAddContacts() throws Exception {
        startTest("Add Contacts", "checking adding contact", "smoke");
        tapButton(androidDriver, homePageObjects.contacts, false);
      //  elementDisplayed(androidDriver,contactPageObjects.importContactButton);
        waitForElementPresent(contactPageObjects.addcontactButton, 60);

        List<MobileElement> addbutton = androidDriver.findElements(By.xpath("android.widget.ImageButton"));
        System.out.println("the buttons size are " + addbutton.size());
        Thread.sleep(3000);

        tapButton(androidDriver,contactPageObjects.addcontactButton,false);
        tapButton(androidDriver, contactPageObjects.contactName, false);
        enterText(androidDriver, contactPageObjects.contactName, ReadExcel.getCellData(Constant.contact, 1, 0));
        androidDriver.hideKeyboard();
        //androidDriver.navigate().back();

        tapButton(androidDriver, contactPageObjects.contactMobileNumber, false);
        int contactMobile = new Double(ReadExcel.getCellData(Constant.contact, 1, 1)).intValue();
        System.out.println("The Partner Mobile is " + contactMobile);
        enterText(androidDriver, contactPageObjects.contactMobileNumber, String.valueOf(contactMobile));
        androidDriver.hideKeyboard();
        //  androidDriver.navigate().back();


        tapButton(androidDriver, contactPageObjects.emailAddress, false);
        enterText(androidDriver, contactPageObjects.emailAddress, ReadExcel.getCellData(Constant.contact, 1, 2));
        androidDriver.hideKeyboard();
        //androidDriver.navigate().back();
        scrolltoElement(androidDriver, contactPageObjects.SaveButton);
        tapButton(androidDriver, contactPageObjects.SaveButton, false);

    }

    @Test(priority = 8)
    public void testAddContactAsProspect() throws Exception {
        startTest("Add As Prospect", "Test to add as an Prospect", "Add As Prospect");
        tapButton(androidDriver, homePageObjects.MenuButton, false);
        tapButton(androidDriver, homePageObjects.prospects, false);
        Thread.sleep(8000);
        waitForElementPresent(contactPageObjects.searchContact, 60);
        tapButton(androidDriver, contactPageObjects.searchContact, false);
        enterText(androidDriver, contactPageObjects.searchContact, ReadExcel.getCellData(Constant.contact, 1, 0));
        androidDriver.hideKeyboard();
        waitForElementPresent(contactPageObjects.addasprospect, 60);
        elementDisplayed(androidDriver,contactPageObjects.contactTitleName);
        elementDisplayed(androidDriver,contactPageObjects.contactCallbutton);
        elementDisplayed(androidDriver,contactPageObjects.contactEditbutton);
        elementDisplayed(androidDriver,contactPageObjects.contactEmailbutton);
        elementDisplayed(androidDriver,contactPageObjects.contactDeletebutton);
        tapButton(androidDriver, contactPageObjects.addasprospect, false);
    }

    @Test(priority = 9)
    public void testProspectpage() throws InterruptedException {
        startTest("prsopectpage", "test prospect page", "prospectpage");
        tapButton(androidDriver,homePageObjects.MenuButton,false);
        tapButton(androidDriver,homePageObjects.prospects,false);
        Thread.sleep(9000);
        waitForElementPresent(prospectPageObjects.prospectsearch,60);
        tapButton(androidDriver,prospectPageObjects.prospectsearch,false);
        enterText(androidDriver,prospectPageObjects.prospectsearch,ReadExcel.getCellData(Constant.contact, 1, 0));
        //androidDriver.hideKeyboard();
        tapButton(androidDriver,prospectPageObjects.createQuote,false);
        waitForElementPresent(prospectPageObjects.generateQuoteText,60);

    }

    @Test(priority = 10)
    public void testgetDetails()
    {
        startTest("getDetails", "test to do get details", "getDetails");
        tapButton(androidDriver,prospectPageObjects.ownerID,false);

        int nid = new Double(ReadExcel.getCellData(Constant.createQuoteSheet,1, 0)).intValue();
        System.out.println("The Partner Mobile is " + nid);
        enterText(androidDriver,prospectPageObjects.ownerID,String.valueOf(nid));
        tapButton(androidDriver,prospectPageObjects.ownerDOB,false);
        //  enterText(androidDriver,prospectPageObjects.ownerDOB,"5 July 1964");
        tapButton(androidDriver,prospectPageObjects.owneryear,false);
        scrolltoElement(androidDriver,prospectPageObjects.sequenceYear);
        tapButton(androidDriver,prospectPageObjects.sequenceYear,false);

        tapButton(androidDriver,prospectPageObjects.montNavigate,false);
        scrolltoElement(androidDriver,prospectPageObjects.sequqnceMonth);
        tapButton(androidDriver, prospectPageObjects.sequqnceMonth,false);
        tapButton(androidDriver,prospectPageObjects.sequenceday,false);

        tapButton(androidDriver,prospectPageObjects.datepickerOK,false);

        scrolltoElement(androidDriver,prospectPageObjects.getDetailsButton);

        int Sequencevalue = new Double(ReadExcel.getCellData(Constant.createQuoteSheet, 1, 2)).intValue();
        System.out.println("The sequence number is " + String.valueOf(Sequencevalue));
        enterText(androidDriver,prospectPageObjects.sequencenumber,String.valueOf(Sequencevalue));
        tapButton(androidDriver,prospectPageObjects.getDetailsButton,false);

    }


    @Test(priority = 11)
    public void  testCalculatePremium() throws Exception {
        startTest("calculate", "test to calculate premium", "calculate");
        waitForElementPresent(prospectPageObjects.totalpremium,120);
       // tapButton(androidDriver,prospectPageObjects.drivingusagedropdown,false);
       // tapButton(androidDriver,prospectPageObjects.drivingusage,false);
        scrolltoElement(androidDriver,prospectPageObjects.calculatePremium);
        tapButton(androidDriver,prospectPageObjects.calculatePremium,false);
        waitForElementPresent(prospectPageObjects.sharequote,120);
        tapButton(androidDriver,prospectPageObjects.sharequote,false);
        waitForElementPresent(quizPageObjects.quotesharedText,60);
        elementDisplayed(androidDriver,quizPageObjects.quotesharedText);
        tapButton(androidDriver,quizPageObjects.okButton,false);
        tapButton(androidDriver, homePageObjects.MenuButton, false);
        tapButton(androidDriver, homePageObjects.contacts, false);
        tapButton(androidDriver, homePageObjects.MenuButton, false);
        tapButton(androidDriver, homePageObjects.prospects, false);
        waitForElementPresent(prospectPageObjects.prospectsearch,60);
        tapButton(androidDriver,prospectPageObjects.prospectsearch,false);
        enterText(androidDriver,prospectPageObjects.prospectsearch,ReadExcel.getCellData(Constant.contact, 1, 0));
        androidDriver.hideKeyboard();
        elementDisplayed(androidDriver,prospectPageObjects.sendReminderButton);
        elementDisplayed(androidDriver,prospectPageObjects.waitingforConsent);
        elementDisplayed(androidDriver,prospectPageObjects.createNewQuote);
        publishReport();
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        try {
            getTestResult(androidDriver, result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
