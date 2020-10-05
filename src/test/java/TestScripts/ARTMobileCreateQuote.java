package TestScripts;

import com.aventstack.extentreports.Status;
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

public class ARTMobileCreateQuote extends DriverFunction

    {

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
            createrReport("ARTMobile", DeviceList.dname, DeviceList.id, DeviceList.osName);
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
            //scrollHorizontal(androidDriver, artOnBoardPageObjects.signUPButton);
            tapButton(androidDriver, artOnBoardPageObjects.loginButton, false);
      //      waitForElementPresent(artOnBoardPageObjects.SaudiCitizen, 60);
        }

    }

        @Test(priority = 3)
        public void testSignUPARTApp() {
            try {
                startTest("Sign UP", "check whether new saudi user can sign up", "smoke");
                waitForElementPresent(artOnBoardPageObjects.YesTAMButton, 60);
                artOnBoardPageObjects.YesTAMButton.click();
                Thread.sleep(6000);
                System.out.println("****************************************************************************");
                System.out.println("the country code is " + artOnBoardPageObjects.countrycode.getText());
                System.out.println("****************************************************************************");
                int partnerMobile = new Double(ReadExcel.getCellData(Constant.OnBoadring, 1, 0)).intValue();
                System.out.println("The Partner Mobile is " + partnerMobile);
                Thread.sleep(5000);
                artOnBoardPageObjects.phonenumber.click();
                enterText(androidDriver,artOnBoardPageObjects.phonenumber,String.valueOf(partnerMobile));
                artOnBoardPageObjects.countrycode.isDisplayed();
                Thread.sleep(2000);
                androidDriver.hideKeyboard();
                //artOnBoardPageObjects.generateOTP.click();
              //  artOnBoardPageObjects.checkboxTC.click();
                artOnBoardPageObjects.NextButton.click();
                Thread.sleep(2000);
            } catch (Exception e) {
            }
        }

        @Test(priority = 4)
        public void testOTPGenerated() throws Exception {
            startTest("OPT Generated", "Checking OTP generated", "smoke");
            Thread.sleep(3000);
            enterText(androidDriver,homePageObjects.OTP1,"9");
            enterText(androidDriver,homePageObjects.OTP2,"9");
            enterText(androidDriver,homePageObjects.OTP3,"9");
            enterText(androidDriver,homePageObjects.OTP4,"9");
            androidDriver.hideKeyboard();
            tapButton(androidDriver, artOnBoardPageObjects.VerifyButton, false);

        }

        @Test(priority = 5)
        public void testCreatePartner() throws Exception {
            startTest("Create Partner", "test to create a partner", "Partner");
            waitForElementPresent(registerPage.onelastFeet, 60);
            tapButton(androidDriver,registerPage.FullName,false);
            enterText(androidDriver,registerPage.FullName,ReadExcel.getCellData(Constant.OnBoadring, 1, 1));
            androidDriver.hideKeyboard();
            tapButton(androidDriver,registerPage.email,false);
            enterText(androidDriver,registerPage.email,ReadExcel.getCellData(Constant.OnBoadring, 1, 2));
            androidDriver.hideKeyboard();
            tapButton(androidDriver,registerPage.letsGetStarted,false);
            Thread.sleep(6000);
            waitForElementPresent(homePageObjects.MenuButton,60);
            List<MobileElement> profileIcon = androidDriver.findElements(By.xpath("android.widget.ImageView[@index='0']"));
            System.out.println("the profile icon count is " + profileIcon.size());

        }


        @Test(priority = 6)
        public void testSaudiCheck()
        {
            startTest("SaudiCheck", "test to perform saudi check", "SaudiCheck");
            waitForElementPresent(homePageObjects.profileIcon,60);
            tapButton(androidDriver,homePageObjects.profileIcon,false);
            waitForElementPresent(saudiCheckPageObjects.saudiCitizenCheck,60);
            tapButton(androidDriver,saudiCheckPageObjects.nationalID,false);

            int partnerNID = new Double(ReadExcel.getCellData(Constant.saudiCheck, 1, 0)).intValue();
            System.out.println("The Partner NID  is " + partnerNID);
            enterText(androidDriver,saudiCheckPageObjects.nationalID,String.valueOf(partnerNID));

            androidDriver.hideKeyboard();
            tapButton(androidDriver,saudiCheckPageObjects.dob,false);
            tapButton(androidDriver,saudiCheckPageObjects.yearButton,false);
            scrolltoElementUp(androidDriver,saudiCheckPageObjects.partnerBirthYear);
            tapButton(androidDriver,saudiCheckPageObjects.partnerBirthYear,false);
            for (int i = 0; i <= 20; i++) {
                try {

                    saudiCheckPageObjects.partnerBirthMoth.isDisplayed();
                    break;
                } catch (Exception e) {
                    tapButton(androidDriver,saudiCheckPageObjects.nextMonthButton,false);
                }
            }
            tapButton(androidDriver, saudiCheckPageObjects.partnerBirthMoth,false);
            tapButton(androidDriver, saudiCheckPageObjects.partnerBirthDay,false);
            tapButton(androidDriver,saudiCheckPageObjects.OkButton,false);
            tapButton(androidDriver,saudiCheckPageObjects.getDetailsButton,false);
            waitForElementPresent(saudiCheckPageObjects.verifyButton,60);
            enterText(androidDriver,homePageObjects.OTP1,"9");
            enterText(androidDriver,homePageObjects.OTP2,"9");
            enterText(androidDriver,homePageObjects.OTP3,"9");
            enterText(androidDriver,homePageObjects.OTP4,"9");
            tapButton(androidDriver,saudiCheckPageObjects.verifyButton,false);
            waitForElementPresent(saudiCheckPageObjects.updateprofile,60);
            navigateBack(androidDriver);

        }

//        @Test(priority = 5)
//        public void testSaudiCheck()
//        {
//            startTest("SaudiCheck", "test to click on profile and doing saudi check","SaudiCheck");
//            tapButton(androidDriver, homePageObjects.profileIcon,false);
//            enterText(androidDriver,homePageObjects.nationalID,"1038493233");
//            enterText(androidDriver,homePageObjects.dob,"15 Oct 1966");
//            waitForElementPresent(homePageObjects.enterOTP,60);
//            tapButton(androidDriver,homePageObjects.verifybutton,false);
//        }


        @Test(priority = 7)
        public void testAddContacts() throws InterruptedException {
            startTest("Add Contacts", "checking adding contact", "smoke");
            tapButton(androidDriver, homePageObjects.MenuButton, false);
            tapButton(androidDriver, homePageObjects.contacts, false);
            waitForElementPresent(contactPageObjects.AddYourFirstContact, 60);
                tapButton(androidDriver, contactPageObjects.contactName, false);
                enterText(androidDriver, contactPageObjects.contactName, ReadExcel.getCellData(Constant.contact, 1, 0));
                androidDriver.hideKeyboard();
                //androidDriver.navigate().back();

                tapButton(androidDriver, contactPageObjects.mobileNumber, false);
                int contactMobile = new Double(ReadExcel.getCellData(Constant.contact, 1, 1)).intValue();
                System.out.println("The Partner Mobile is " + contactMobile);
                enterText(androidDriver, contactPageObjects.mobileNumber, String.valueOf(contactMobile));
                androidDriver.hideKeyboard();
              //  androidDriver.navigate().back();


                tapButton(androidDriver, contactPageObjects.emailAddress, false);
                enterText(androidDriver, contactPageObjects.emailAddress, ReadExcel.getCellData(Constant.contact, 1, 2));
                androidDriver.hideKeyboard();
                //androidDriver.navigate().back();
                tapButton(androidDriver, contactPageObjects.aDDNewContact, false);
                scrolltoElement(androidDriver, contactPageObjects.SaveButton);
                tapButton(androidDriver, contactPageObjects.SaveButton, false);
//                Thread.sleep(8000);
//                List<MobileElement> buttons = androidDriver.findElements(By.xpath("//android.widget.ImageButton[@index='0']"));
//                System.out.println("the buttons size " + buttons.size());
//                Thread.sleep(4000);
//                tapButton(androidDriver, contactPageObjects.AddContact, false);
//                Thread.sleep(5000);
//
        }

        @Test(priority = 8)
        public void testAddContactAsProspect() throws InterruptedException {
            startTest("Add As Prospect", "Test to add as an Prospect", "Add As Prospect");
            tapButton(androidDriver, homePageObjects.MenuButton, false);
            tapButton(androidDriver, homePageObjects.prospects, false);
            Thread.sleep(8000);
                waitForElementPresent(contactPageObjects.searchContact, 60);
                tapButton(androidDriver, contactPageObjects.searchContact, false);
                enterText(androidDriver, contactPageObjects.searchContact, ReadExcel.getCellData(Constant.contact, 1, 0));
                androidDriver.hideKeyboard();
                waitForElementPresent(contactPageObjects.addasprospect, 60);
                tapButton(androidDriver, contactPageObjects.addasprospect, false);
                waitForElementPresent(prospectPageObjects.prospectsuccessmessage,60);
            }




        @Test(priority = 9)
        public void testProspectpage() throws InterruptedException {
            startTest("prsopectpage", "test prospect page", "prospectpage");
            tapButton(androidDriver,homePageObjects.MenuButton,false);
            tapButton(androidDriver,homePageObjects.prospects,false);
            Thread.sleep(10000);
            waitForElementPresent(prospectPageObjects.prospectsearch,60);
            tapButton(androidDriver,prospectPageObjects.prospectsearch,false);
            enterText(androidDriver,prospectPageObjects.prospectsearch,ReadExcel.getCellData(Constant.contact, 1, 0));
            androidDriver.hideKeyboard();
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

            for (int i = 0; i <= 20; i++) {
                try {

                    prospectPageObjects.sequqnceMonth.isDisplayed();
                    break;
                } catch (Exception e) {
                    tapButton(androidDriver,prospectPageObjects.montNavigate,false);

                }

            }
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
            tapButton(androidDriver,prospectPageObjects.drivingusagedropdown,false);
            tapButton(androidDriver,prospectPageObjects.drivingusage,false);
            scrolltoElement(androidDriver,prospectPageObjects.calculatePremium);
            tapButton(androidDriver,prospectPageObjects.calculatePremium,false);
            waitForElementPresent(prospectPageObjects.sharequote,120);
            tapButton(androidDriver,prospectPageObjects.sharequote,false);
            waitForElementPresent(quizPageObjects.quotesharedText,60);
            elementDisplayed(androidDriver,quizPageObjects.quotesharedText);
            tapButton(androidDriver,quizPageObjects.okButton,false);

        }

        @Test(priority = 12)
        public void testShareQuote() throws Exception {
            startTest("Quote Shared", "test to check quote is shared", "Share Quote");
            navigateBack(androidDriver);
            navigateBack(androidDriver);
            tapButton(androidDriver,homePageObjects.MenuButton,false);
            tapButton(androidDriver,homePageObjects.contacts,false);
            tapButton(androidDriver,homePageObjects.MenuButton,false);
            tapButton(androidDriver,homePageObjects.prospects,false);
            waitForElementPresent(quizPageObjects.sendReminderButton,60);
            elementDisplayed(androidDriver,quizPageObjects.sendReminderButton);
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
