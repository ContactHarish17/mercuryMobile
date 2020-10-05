package TestScripts;

import io.appium.java_client.MobileElement;
import maindriver.DriverFunction;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.*;
import utility.DeviceList;


import java.io.IOException;
import java.util.List;

public class ARTMobileSmoke extends DriverFunction {

    HomePageObject homePageObjects;
    ContactPageObject contactPageObjects;
    ARTOnBoardingPageObjects artOnBoardPageObjects;
    ActivityPageObjects activityPageObject;
    QuizPageObjects quizPageObjects;

    public void initialisePageObjects() {
        homePageObjects = new HomePageObject(androidDriver);
        contactPageObjects = new ContactPageObject(androidDriver);
        artOnBoardPageObjects = new ARTOnBoardingPageObjects(androidDriver);
        activityPageObject = new ActivityPageObjects(androidDriver);
        quizPageObjects = new QuizPageObjects(androidDriver);
        try {
            createrReport("ART MobileAPP Automation", DeviceList.dname, DeviceList.id, DeviceList.osName);
        } catch (Exception e) {
        }
    }


    @Test(priority = 1)
    public void testOpenARTApp() throws InterruptedException {
        initialisePageObjects();
        waitForElementPresent(artOnBoardPageObjects.languageToggleButton, 60);
        startTest("Open ART APP", "check opens the app", "smoke");
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
            scrollHorizontal(androidDriver, artOnBoardPageObjects.SiginUpNowButton);
            tapButton(androidDriver, artOnBoardPageObjects.SiginUpNowButton, false);
            waitForElementPresent(artOnBoardPageObjects.SaudiCitizen, 60);
        }

    }

    @Test(priority = 3)
    public void testNonSaudiCheck() throws Exception {
        startTest("NonSaudi Check", "checking non saudi check", "smoke");
        elementDisplayed(androidDriver, artOnBoardPageObjects.SaudiCitizen);
        tapButton(androidDriver, artOnBoardPageObjects.NoTAMNotButton, false);
        waitForElementPresent(artOnBoardPageObjects.YesMayBeButton, 60);
        elementDisplayed(androidDriver, artOnBoardPageObjects.YesMayBeButton);
        List<MobileElement> buttons = androidDriver.findElements(By.xpath("//android.widget.Button[@index='0']"));
        System.out.println("the Buttons are : " + buttons.size());
        Thread.sleep(2000);
        tapButton(androidDriver, buttons.get(9), false);
        //waitForElementPresent(artOnBoardPageObjects.NoIWouldNotButton,60);
        //  tapButton(androidDriver,artOnBoardPageObjects.NoIWouldNotButton,false);
    }

    @Test(priority = 4)
    public void testCheckThankYouPage() throws Exception {
        startTest("NonSaudi Thank You Page", " checking whether thank you page getting displayed", "smoke");
        waitForElementPresent(artOnBoardPageObjects.Thankyou, 60);
        elementDisplayed(androidDriver, artOnBoardPageObjects.Thankyou);
        elementDisplayed(androidDriver, artOnBoardPageObjects.thankyoutext);
        List<MobileElement> closebuttons = androidDriver.findElements(By.xpath("//android.widget.ImageView[@index='0']"));
        System.out.println("the close button counts :" + closebuttons.size());
        //tapButton(androidDriver,closebuttons.get(0),false);
    }

    @Test(priority = 5)
    public void testSignUPARTApp() {
        try {
            navigateBack(androidDriver);
            navigateBack(androidDriver);
            startTest("Sign UP", "check whether new saudi user can sign up", "smoke");
            waitForElementPresent(artOnBoardPageObjects.YesTAMButton, 60);
            artOnBoardPageObjects.YesTAMButton.click();
            Thread.sleep(6000);
            System.out.println("****************************************************************************");
            System.out.println("the country code is " + artOnBoardPageObjects.countrycode.getText());
            System.out.println("****************************************************************************");
            artOnBoardPageObjects.phonenumber.click();
            artOnBoardPageObjects.phonenumber.sendKeys("582176682");
            artOnBoardPageObjects.countrycode.isDisplayed();
            Thread.sleep(2000);
            androidDriver.hideKeyboard();
            //artOnBoardPageObjects.generateOTP.click();
            artOnBoardPageObjects.checkboxTC.click();
            artOnBoardPageObjects.NextButton.click();
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }

    @Test(priority = 6)
    public void testOTPGenerated() throws Exception {
        startTest("OPT Generated", "Checking OTP generated", "smoke");
//        enterText(androidDriver, homePageObjects.OTP1, "9");
//        enterText(androidDriver, homePageObjects.OTP2, "9");
//        enterText(androidDriver, homePageObjects.OTP3, "9");
//        enterText(androidDriver, homePageObjects.OTP4, "9");
        Thread.sleep(3000);
        tapButton(androidDriver, artOnBoardPageObjects.VerifyButton, false);
    }

    @Test(priority = 7)
    public void testMenuItems() {
        startTest("Menu Items", "test to check menu items are dispplayed", "MenuItems");
        waitForElementPresent(homePageObjects.MenuButton, 60);
        tapButton(androidDriver, homePageObjects.MenuButton, false);
        try {
            elementDisplayed(androidDriver, homePageObjects.home);
            elementDisplayed(androidDriver, homePageObjects.contacts);
            elementDisplayed(androidDriver, homePageObjects.activities);
            elementDisplayed(androidDriver, homePageObjects.prospects);
            elementDisplayed(androidDriver,homePageObjects.customers);
            elementDisplayed(androidDriver,homePageObjects.targets);
            elementDisplayed(androidDriver,homePageObjects.products);
            navigateBack(androidDriver);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 8)
    public void testHomePageDisplayed() throws Exception {
        startTest("HomePage", "test home page is loaded", "smoke");
        waitForElementPresent(homePageObjects.WelcomePage, 60);
        elementDisplayed(androidDriver, homePageObjects.WelcomePage);
        elementDisplayed(androidDriver, homePageObjects.earnedpoints);
        elementDisplayed(androidDriver, homePageObjects.QuickLearning);
        elementDisplayed(androidDriver, homePageObjects.ReachOut);
        elementDisplayed(androidDriver, homePageObjects.Policy);
        elementDisplayed(androidDriver, homePageObjects.Commission);
        scrolltoElement(androidDriver, homePageObjects.StartQuickLearning);
        tapButton(androidDriver, homePageObjects.StartQuickLearning, false);
    }

    @Test(priority = 9)
    public void testTakeQuiz() throws Exception {
        startTest("Take Quiz", "checing the quiz page", "smoke");
        elementDisplayed(androidDriver, quizPageObjects.SkipQuiz);
        elementDisplayed(androidDriver, quizPageObjects.ReachContacts);
        tapButton(androidDriver, quizPageObjects.SkipQuiz, false);
        elementDisplayed(androidDriver, quizPageObjects.takequiz);
        tapButton(androidDriver, quizPageObjects.takeQuizButton, false);
        Thread.sleep(7000);
    }

    @Test(priority = 10)
    public void testQuizQuestions() throws Exception {
        startTest("Quiz Questions", "checking the quiz questions page", "smoke");
        //checkScreenText(QuizPageObjects.Question1);
        tapButton(androidDriver, quizPageObjects.Question1_Answer, false);
        tapButton(androidDriver, quizPageObjects.NextQuestionButton, false);
        //  checkScreenText(QuizPageObjects.Question2);
        tapButton(androidDriver, quizPageObjects.WrongAnswerTrue, false);
        //elementDisplayed(androidDriver, quizPageObjects.WrongAnswerMessage);
        tapButton(androidDriver, quizPageObjects.CorrectAnswerFalse, false);
        tapButton(androidDriver, quizPageObjects.NextQuestionButton, false);
        //checkScreenText(QuizPageObjects.Question3);
        tapButton(androidDriver, quizPageObjects.Question3_Asnwer, false);
        tapButton(androidDriver, quizPageObjects.NextQuestionButton, false);

    }


    @Test(priority = 11)
    public void testQuizCompletion() throws Exception {
        startTest("Quiz Completion", "checking the quiz completion page", "smoke");
        elementDisplayed(androidDriver, quizPageObjects.QuizComplete);
        scrolltoElement(androidDriver, quizPageObjects.ReachContactsButton);
        tapButton(androidDriver, quizPageObjects.ReachContactsButton, false);
    }



    @Test(priority = 12)
    public void testImportContacts() throws InterruptedException {
        startTest("Import Contacts","test to imports concat from phone book", "ImportContacts");
        waitForElementPresent(contactPageObjects.AddYourFirstContact,40);
        scrolltoElement(androidDriver,contactPageObjects.imporContactsButton);
        tapButton(androidDriver,contactPageObjects.imporContactsButton,false);
        tapButton(androidDriver,contactPageObjects.okbutton,false);
        if(contactPageObjects.allowButton.isDisplayed())
        {
            contactPageObjects.allowButton.click();
        }
        else {
            System.out.println("The Button isn't displayed");
        }
        try
        {
            elementDisplayed(androidDriver, contactPageObjects.selectContactTitle);
            elementDisplayed(androidDriver, contactPageObjects.selectallcontacts);
            elementDisplayed(androidDriver, contactPageObjects.selectallContactsButton);
            elementDisplayed(androidDriver, contactPageObjects.selectsubtext);

        } catch (Exception e) {
            e.printStackTrace(); }
       // enterText(androidDriver, contactPageObjects.searchContactField, "saudi");
        List<MobileElement> buttons = androidDriver.findElements(By.xpath("//android.widget.ImageView[@index='0']"));
        System.out.println("the buttons size " + buttons.size());
        tapButton(androidDriver, buttons.get(0), false);
//            for (MobileElement element : buttons) {
//                tapButton(androidDriver, element, false);
//            }
//            elementDisplayed(androidDriver,contactPageObjects.importContact);
        tapButton(androidDriver, contactPageObjects.importContact, false);
      //  androidDriver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(5000);
//        tapButton(androidDriver, contactPageObjects.importContact, false);
//        androidDriver.findElement(By.id("android:id/button1")).click();
//        Thread.sleep(5000);
//        waitForElementPresent(contactPageObjects.secondcontactName, 60);
        try {
            elementDisplayed(androidDriver, contactPageObjects.secondcontactName);
            elementDisplayed(androidDriver, contactPageObjects.thirdcontactName);
            elementDisplayed(androidDriver,contactPageObjects.FirstcontactName);
        }catch (Exception e)
        {}
        publishReport();
    }


//    @Test(priority = 13)
//    public void testAddActivity() throws InterruptedException {
//
//        startTest("Add Activity", "Test to add an activity", "Add Acivity");
//        navigateBack(androidDriver);
//        navigateBack(androidDriver);
//        tapButton(androidDriver, homePageObjects.MenuButton, false);
//        Thread.sleep(3000);
//        tapButton(androidDriver, homePageObjects.activities, false);
//        waitForElementPresent(activityPageObject.activitylinkPerson, 60);
//        tapButton(androidDriver, activityPageObject.Activitybutton, false);
//        tapButton(androidDriver, activityPageObject.AddActivityButton, false);
//        tapButton(androidDriver, activityPageObject.Search, false);
//        tapButton(androidDriver, activityPageObject.SearchContact, false);
//        enterText(androidDriver, activityPageObject.SearchContact, "Saudi");
//        tapButton(androidDriver, activityPageObject.Contact1, false);
//        tapButton(androidDriver, activityPageObject.ActivityType, false);
//        try {
//            elementDisplayed(androidDriver, activityPageObject.MeetingsActivity);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        tapButton(androidDriver, activityPageObject.MeetingsActivity, false);
//        tapButton(androidDriver, activityPageObject.ActivityTitle, false);
//        enterText(androidDriver, activityPageObject.ActivityTitle, "Meetings with Saudi Today");
//        androidDriver.hideKeyboard();
//        scrolltoElement(androidDriver, activityPageObject.SAVEButton);
//        tapButton(androidDriver, activityPageObject.ActivityDuration, false);
//        try {
//            elementDisplayed(androidDriver, activityPageObject.Activity_30Mins);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        tapButton(androidDriver, activityPageObject.Activity_30Mins, false);
//        tapButton(androidDriver, activityPageObject.SAVEButton, false);
//    }
//
//    @Test(priority = 14)
//    public void testCheckActivityAdded() {
//        startTest("Activity Added", "test to check the activtiy added", "Activity Added");
//        tapButton(androidDriver, activityPageObject.meetingSubMenu, false);
//        try {
//           // elementDisplayed(androidDriver, activityPageObject.contactName);
//            elementDisplayed(androidDriver, activityPageObject.meetingActivityText);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        publishReport();
//    }
//
////    @Test(priority = 15)
////    public void testDeleteActivity() throws InterruptedException {
////        startTest("Delete Activity", "test to delete an added activity", "Delete Activity");
////        swipeElement(androidDriver, activityPageObject.firstactivity);
////        tapButton(androidDriver, activityPageObject.doneButton, false);
////
////        try {
////            elementDisplayed(androidDriver, activityPageObject.noDelete);
////            elementDisplayed(androidDriver, activityPageObject.activitydeleteMessages);
////            elementDisplayed(androidDriver, activityPageObject.yesDelete);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        tapButton(androidDriver, activityPageObject.yesDelete, false);
////        Thread.sleep(5000);
////        try {
//////            Assert.assertFalse(activityPageObject.meetingActivityText.isDisplayed());
////        } catch (AssertionError e) {
////        }
////        publishReport();
////    }




    @AfterMethod
    public void getResult(ITestResult result) {
        try {
            getTestResult(androidDriver, result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}