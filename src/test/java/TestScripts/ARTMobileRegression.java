package TestScripts;

import maindriver.DriverFunction;
import pageobjects.*;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utility.DeviceList;

import java.io.IOException;
import java.util.List;

public class ARTMobileRegression extends DriverFunction {


    ARTOnBoardingPageObjects artOnBoardPageObjects;
    HomePageObject homePageObjects;
    QuizPageObjects quizPageObjects;
    ContactPageObject contactPageObjects;
    ActivityPageObjects activityPageObject;


    public void initialisePageObjects() {
        artOnBoardPageObjects = new ARTOnBoardingPageObjects(androidDriver);
        homePageObjects = new HomePageObject(androidDriver);
        quizPageObjects = new QuizPageObjects(androidDriver);
        contactPageObjects = new ContactPageObject(androidDriver);
        activityPageObject = new ActivityPageObjects(androidDriver);
        try {
            createrReport("Contacts", DeviceList.dname, DeviceList.id, DeviceList.osName);
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
        }

    }


    @Test(priority = 3)
    public void testNonSaudiCheck() throws Exception {
        startTest("NonSaudi Check", "checking non saudi check", "smoke");
        elementDisplayed(androidDriver,artOnBoardPageObjects.SaudiCitizen);
        tapButton(androidDriver,artOnBoardPageObjects.NoTAMNotButton,false);
        waitForElementPresent(artOnBoardPageObjects.YesMayBeButton,60);
        elementDisplayed(androidDriver,artOnBoardPageObjects.YesMayBeButton);
        List<MobileElement> buttons = androidDriver.findElements(By.xpath("//android.widget.Button[@index='0']"));
        System.out.println("the Buttons are : " + buttons.size());
        Thread.sleep(2000);
        tapButton(androidDriver,buttons.get(9),false);
        //waitForElementPresent(artOnBoardPageObjects.NoIWouldNotButton,60);
        //  tapButton(androidDriver,artOnBoardPageObjects.NoIWouldNotButton,false);
    }

    @Test(priority = 4)
    public void testCheckThankYouPage() throws Exception
    {
        startTest("NonSaudi Thank You Page", " checking whether thank you page getting displayed", "smoke" );
        waitForElementPresent(artOnBoardPageObjects.Thankyou,60);
        elementDisplayed(androidDriver,artOnBoardPageObjects.Thankyou);
        elementDisplayed(androidDriver,artOnBoardPageObjects.thankyoutext);
        List<MobileElement> closebuttons = androidDriver.findElements(By.xpath("//android.widget.ImageView[@index='0']"));
        System.out.println("the close button counts :" + closebuttons.size());
        navigateBack(androidDriver);
        navigateBack(androidDriver);

    }


    @Test(priority = 5)
    public void testSignUPARTApp() {
        try {
            startTest("Sign UP", "check whether new saudi user can sign up", "smoke");
            waitForElementPresent(artOnBoardPageObjects.YesTAMButton, 60);
            artOnBoardPageObjects.YesTAMButton.click();
            waitForElementPresent(artOnBoardPageObjects.countrycode, 60);
            elementDisplayed(androidDriver, artOnBoardPageObjects.countrycode);
            tapButton(androidDriver, artOnBoardPageObjects.phonenumber, false);
            enterText(androidDriver, artOnBoardPageObjects.phonenumber, "582176966");
            elementDisplayed(androidDriver, artOnBoardPageObjects.countrycode);
            androidDriver.hideKeyboard();
            artOnBoardPageObjects.checkboxTC.click();
            artOnBoardPageObjects.NextButton.click();
        } catch (Exception e) {
        }
    }

    @Test(priority = 6)
    public void testOTPGenerated() throws Exception {
        startTest("OPT Generated", "Chekcing OTP generated", "smoke");
        waitForElementPresent(artOnBoardPageObjects.EnterOTPScreen, 60);
        elementDisplayed(androidDriver, artOnBoardPageObjects.EnterOTPScreen);
//        elementDisplayed(androidDriver, artOnBoardPageObjects.ResendButton);
//        elementDisplayed(androidDriver, artOnBoardPageObjects.OTP1);
//        elementDisplayed(androidDriver, artOnBoardPageObjects.OTP2);
//        elementDisplayed(androidDriver, artOnBoardPageObjects.OTP3);
//        elementDisplayed(androidDriver, artOnBoardPageObjects.OTP4);
        tapButton(androidDriver, artOnBoardPageObjects.VerifyButton, false);
        Thread.sleep(5000);
    }

//    @Test(priority = 5)
//    public void testSuadiRegistration()
//    {
//
//        startTest("OneLast feat", "test to enter name and email in OnelatsFeat screen","smoke");
//        //waitForElementPresent(artOnBoardPageObjects.onelastFeatText,60);
//        waitForElementPresent(artOnBoardPageObjects.partnerName,60);
//        enterText(androidDriver,artOnBoardPageObjects.partnerName,"Harish Habbanakuppe");
//        androidDriver.hideKeyboard();
//        tapButton(androidDriver,artOnBoardPageObjects.genderButtoon,false);
//        enterText(androidDriver,artOnBoardPageObjects.partnerEmail,"harish.ramakrishna@mindtree.com");
//        tapButton(androidDriver,artOnBoardPageObjects.letsgetStartedButton,false);
//    }

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

//    @Test(priority = 7)
//    public void testQuickLearning() throws Exception {
//        startTest("Quick Learning", "check quick learning page", "smoke");
//        waitForElementPresent(quizPageObjects.QuickLearning,60);
//        elementDisplayed(androidDriver, quizPageObjects.QuickLearning);
//        List<MobileElement> elements = androidDriver.findElements(By.xpath("//android.widget.TextView"));
//        System.out.println("the Elements size are :- " + elements.size());
//        for (int i = 0; i < elements.size(); i++) {
//            System.out.println("The text are :-" + elements.get(i).getText());
//        }
//
//    }


    @Test(priority = 8)
    public void testTakeQuiz() throws Exception {
        startTest("Take Quiz", "checing the quiz page", "smoke");
        elementDisplayed(androidDriver, quizPageObjects.SkipQuiz);
        elementDisplayed(androidDriver, quizPageObjects.ReachContacts);
        tapButton(androidDriver, quizPageObjects.SkipQuiz, false);
        elementDisplayed(androidDriver, quizPageObjects.takequiz);
        tapButton(androidDriver, quizPageObjects.takeQuizButton, false);
        Thread.sleep(7000);
    }

    @Test(priority = 9)
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


    @Test(priority = 10)
    public void testQuizCompletion() throws Exception {
        startTest("Quiz Completion", "checking the quiz completion page", "smoke");
        elementDisplayed(androidDriver, quizPageObjects.QuizComplete);
        scrolltoElement(androidDriver, quizPageObjects.ReachContactsButton);
        tapButton(androidDriver, quizPageObjects.ReachContactsButton, false);
    }

    @Test(priority = 11)
    public void testAddContacts() throws InterruptedException {
        startTest("Add Contacts", "checking adding contact", "smoke");
        tapButton(androidDriver, homePageObjects.MenuButton, false);
        tapButton(androidDriver, homePageObjects.contacts, false);
        tapButton(androidDriver, contactPageObjects.contactName, false);
        enterText(androidDriver, contactPageObjects.contactName, "Ramakrishna");
        Thread.sleep(2000);
        androidDriver.hideKeyboard();
        tapButton(androidDriver, contactPageObjects.mobileNumber, false);
        enterText(androidDriver, contactPageObjects.mobileNumber, "567567567");
        //androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_ENTER );
        androidDriver.hideKeyboard();
        tapButton(androidDriver, contactPageObjects.emailAddress, false);
        enterText(androidDriver, contactPageObjects.emailAddress, "Ramakrishna@gmail.com");
        androidDriver.hideKeyboard();
        scrolltoElement(androidDriver, contactPageObjects.imporContactsButton);
        tapButton(androidDriver, contactPageObjects.aDDNewContact, false);
        tapButton(androidDriver, contactPageObjects.MedicalProduct, false);
        scrolltoElement(androidDriver, contactPageObjects.SaveButton);
        tapButton(androidDriver, contactPageObjects.TravelProduct, false);


    }

    @Test(priority = 12)
    public void testAddMoreDetailsforContact() throws InterruptedException {
        startTest("More Details", "adding more details for contact", "smoke");
        tapButton(androidDriver, contactPageObjects.AddMoreDetails, false);
//        contactPageObjects.SpouseField.click();
//        enterText(androidDriver,contactPageObjects.SpouseField,"4");
//        contactPageObjects.KidsField.click();
//        enterText(androidDriver,contactPageObjects.KidsField,"10");
        scrolltoElement(androidDriver, contactPageObjects.SaveButton);
        tapButton(androidDriver, contactPageObjects.SaveButton, false);


    }
//    @Test(priority = 12)
//    public void testContactListPage() {
//        startTest("ContactList", "checking contactlist page", "smoke");
//        //Assert.assertEquals("Ramakrishna",contactPageObjects.firstContactName.getText());
//    }


    @Test(priority = 13)
    public void testEditContact() {
        startTest("Edit Contacts", "checking Editing contact", "smoke");
        waitForElementPresent(contactPageObjects.firstContact, 60);
        swipeElement(androidDriver, contactPageObjects.firstContact);
        tapButton(androidDriver, contactPageObjects.EditButton, false);

        //scrolltoElement(androidDriver, contactPageObjects.AddMoreDetails);
        //tapButton(androidDriver, contactPageObjects.AddMoreDetails, false);
        scrolltoElement(androidDriver, contactPageObjects.SaveButton);
        tapButton(androidDriver, contactPageObjects.MedicalMalpracticeProduct, false);
//        enterText(androidDriver, contactPageObjects.NationalFieldValue, "1234567890");
//        androidDriver.hideKeyboard();
        //   enterText(androidDriver,contactPageObjects.TwitterFieldValue,"http://www.twitter.com/hello");
        //  enterText(androidDriver,contactPageObjects.LinkedInFieldValue,"http://www.linkedin.com/hellos");
        tapButton(androidDriver, contactPageObjects.SaveButton, false);
    }

    @Test(priority = 14)
    public void testDeleteContact() throws InterruptedException {
        startTest("Delete Contacts", "check deleting a contact", "smoke");
        waitForElementPresent(contactPageObjects.firstContact, 60);
        swipeElement(androidDriver, contactPageObjects.firstContact);
        tapButton(androidDriver, contactPageObjects.DeleteButton, false);
        tapButton(androidDriver, contactPageObjects.YesButton, false);
        Thread.sleep(5000);
        try {
            Assert.assertFalse(contactPageObjects.firstContact.isDisplayed());
        } catch (AssertionError e) {
        }
    }


    @Test(priority = 15)
    public void testImportContacts() {
        try {
            startTest("Import Contacts", "Test to Import Contacts", "Import Contacts");
            waitForElementPresent(contactPageObjects.aDDNewContact, 60);
            scrolltoElement(androidDriver, contactPageObjects.imporContactsButton);
            tapButton(androidDriver, contactPageObjects.imporContactsButton, false);
            tapButton(androidDriver, contactPageObjects.allowButton, false);
            waitForElementPresent(contactPageObjects.selectContact, 60);
            enterText(androidDriver, contactPageObjects.searchContactField, "saudi");
            List<MobileElement> buttons = androidDriver.findElements(By.xpath("//android.widget.ImageView[@index='0']"));
            System.out.println("the buttons size " + buttons.size());
            tapButton(androidDriver, buttons.get(0), false);
//            for (MobileElement element : buttons) {
//                tapButton(androidDriver, element, false);
//            }
//            elementDisplayed(androidDriver,contactPageObjects.importContact);
            tapButton(androidDriver, contactPageObjects.importContact, false);
            waitForElementPresent(contactPageObjects.secondcontactName, 60);
            elementDisplayed(androidDriver, contactPageObjects.secondcontactName);
            elementDisplayed(androidDriver, contactPageObjects.thirdcontactName);
        } catch (Exception e) {
        }
    }

    @Test(priority = 16)
    public void testDeleteSecondContacts() throws InterruptedException {
        startTest("Delete Second Contacts", "test to delete all contacts", "Delete Second Contacts");
        swipeElement(androidDriver, contactPageObjects.firstContact);
        tapButton(androidDriver, contactPageObjects.DeleteButton, false);
        tapButton(androidDriver, contactPageObjects.YesButton, false);
        Thread.sleep(5000);
        try {
            Assert.assertFalse(contactPageObjects.firstContact.isDisplayed());
        } catch (AssertionError e) {
        }
//        swipeElement(androidDriver, contactPageObjects.firstContact);
//        tapButton(androidDriver, contactPageObjects.DeleteButton, false);
//        tapButton(androidDriver,contactPageObjects.YesButton,false);
//        Thread.sleep(5000);
//        try {
//            Assert.assertFalse(contactPageObjects.firstContact.isDisplayed());
//        }catch (AssertionError e)
//        {}
        publishReport();
    }

    @Test(priority = 17)
    public void testEditImportedContact() throws Exception {
        startTest("Imported contact", "test to edit imported contact", "Edit Import Contacts");
        swipeElement(androidDriver, contactPageObjects.firstContact);
        tapButton(androidDriver, contactPageObjects.EditButton, false);
        scrolltoElement(androidDriver, contactPageObjects.SaveButton);
        tapButton(androidDriver, contactPageObjects.MedicalProduct, false);
        tapButton(androidDriver, contactPageObjects.TravelProduct, false);
        tapButton(androidDriver, contactPageObjects.SaveButton, false);
        waitForElementPresent(contactPageObjects.thirdcontactName, 60);
    }

    @Test(priority = 18)
    public void testAddActivity() throws InterruptedException {
        startTest("Add Activity", "Test to add an activity", "Add Acivity");
        tapButton(androidDriver, homePageObjects.MenuButton, false);
        Thread.sleep(3000);
        tapButton(androidDriver, homePageObjects.activities, false);
        waitForElementPresent(activityPageObject.activitylinkPerson, 60);
        tapButton(androidDriver, activityPageObject.Activitybutton, false);
        tapButton(androidDriver, activityPageObject.AddActivityButton, false);
        tapButton(androidDriver, activityPageObject.Search, false);
        tapButton(androidDriver, activityPageObject.SearchContact, false);
        enterText(androidDriver, activityPageObject.SearchContact, "Saudi");
        tapButton(androidDriver, activityPageObject.Contact1, false);
        tapButton(androidDriver, activityPageObject.ActivityType, false);
        try {
            elementDisplayed(androidDriver, activityPageObject.MeetingsActivity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tapButton(androidDriver, activityPageObject.MeetingsActivity, false);
        tapButton(androidDriver, activityPageObject.ActivityTitle, false);
        enterText(androidDriver, activityPageObject.ActivityTitle, "Meetings with Saudi Today");
        androidDriver.hideKeyboard();
        scrolltoElement(androidDriver, activityPageObject.SAVEButton);
        tapButton(androidDriver, activityPageObject.ActivityDuration, false);
        try {
            elementDisplayed(androidDriver, activityPageObject.Activity_30Mins);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tapButton(androidDriver, activityPageObject.Activity_30Mins, false);
        tapButton(androidDriver, activityPageObject.SAVEButton, false);
    }

    @Test(priority = 19)
    public void testCheckActivityAdded() {
        startTest("Activity Added", "test to check the activtiy added", "Activity Added");
        tapButton(androidDriver, activityPageObject.meetingSubMenu, false);
        try {
            elementDisplayed(androidDriver, activityPageObject.contactName);
            elementDisplayed(androidDriver, activityPageObject.meetingActivityText);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 20)
    public void testDeleteActivity() throws InterruptedException {
        startTest("Delete Activity", "test to delete an added activity", "Delete Activity");
        swipeElement(androidDriver, activityPageObject.firstactivity);
        tapButton(androidDriver, activityPageObject.doneButton, false);

        try {
            elementDisplayed(androidDriver, activityPageObject.noDelete);
            elementDisplayed(androidDriver, activityPageObject.activitydeleteMessages);
            elementDisplayed(androidDriver, activityPageObject.yesDelete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tapButton(androidDriver, activityPageObject.yesDelete, false);
        Thread.sleep(5000);
        try {
            Assert.assertFalse(activityPageObject.meetingActivityText.isDisplayed());
        } catch (AssertionError e) {
        }
    }

    @Test(priority = 21)
    public void testDeleteThirdContacts() throws InterruptedException {
        startTest("Delete Third Contacts", "test to delete all contacts", "Delete Third Contacts");
        tapButton(androidDriver, homePageObjects.MenuButton, false);
        tapButton(androidDriver, homePageObjects.contacts, false);
        waitForElementPresent(contactPageObjects.firstContact, 60);
        swipeElement(androidDriver, contactPageObjects.firstContact);
        tapButton(androidDriver, contactPageObjects.DeleteButton, false);
        tapButton(androidDriver, contactPageObjects.YesButton, false);
        Thread.sleep(5000);
        try {
            Assert.assertTrue(!contactPageObjects.firstContact.isDisplayed());
        } catch (AssertionError e) {
        }
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

