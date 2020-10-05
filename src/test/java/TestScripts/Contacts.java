package TestScripts;


import io.appium.java_client.MobileElement;
import maindriver.DriverFunction;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.ARTOnBoardingPageObjects;
import pageobjects.ContactPageObject;
import pageobjects.HomePageObject;
import utility.DeviceList;


import java.util.List;

public class Contacts extends DriverFunction {

    HomePageObject homePageObjects;
    ContactPageObject contactPageObjects;
    ARTOnBoardingPageObjects artOnBoardPageObjects;

    public void initialisePageObjects()
    {
        homePageObjects = new HomePageObject(androidDriver);
        contactPageObjects = new ContactPageObject(androidDriver);
        artOnBoardPageObjects = new ARTOnBoardingPageObjects(androidDriver);
        try
        {
            createrReport("Contacts", DeviceList.dname,DeviceList.id, DeviceList.osName);
        }catch (Exception e)
        {}
    }


    @Test(priority = 1)
    public void testOpenARTApp() throws InterruptedException {
        initialisePageObjects();
        waitForElementPresent(artOnBoardPageObjects.languageToggleButton,60);
        startTest("Open ART APP", "check opens the app", "smoke");
        try {
            elementDisplayed(androidDriver,artOnBoardPageObjects.languageToggleButton);
            elementDisplayed(androidDriver,artOnBoardPageObjects.anytimeanywhere);

            Thread.sleep(4000);
        } catch (Exception e) {
        }
    }

    @Test(priority = 2)
    public void testSwipeCarousle() {
        startTest("Swipe Carousel", "test to check whether we can swipe carousel", "smoke");
        {
            scrollHorizontal(androidDriver, artOnBoardPageObjects.SiginUpNowButton);
            tapButton(androidDriver,artOnBoardPageObjects.SiginUpNowButton,false);
            waitForElementPresent(artOnBoardPageObjects.SaudiCitizen,60);
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
        //tapButton(androidDriver,closebuttons.get(0),false);


    }


        @Test(priority = 5)
        public void testSignUPARTApp() {
        try {
            navigateBack(androidDriver);
            navigateBack(androidDriver);
            startTest("Sign UP", "check whether new saudi user can sign up", "smoke");
            waitForElementPresent(artOnBoardPageObjects.YesTAMButton,60);
            artOnBoardPageObjects.YesTAMButton.click();
            Thread.sleep(6000);
            System.out.println("****************************************************************************");
            System.out.println("the country code is " + artOnBoardPageObjects.countrycode.getText());
            System.out.println("****************************************************************************");
            artOnBoardPageObjects.phonenumber.click();
            artOnBoardPageObjects.phonenumber.sendKeys("582176697");
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
        enterText(androidDriver,homePageObjects.OTP1,"9");
        enterText(androidDriver,homePageObjects.OTP2,"9");
        enterText(androidDriver,homePageObjects.OTP3,"9");
        enterText(androidDriver,homePageObjects.OTP4,"9");
        tapButton(androidDriver, artOnBoardPageObjects.VerifyButton, false);
    }


    @Test(priority = 7)
    public void testSuadiRegistration()
    {

        startTest("OneLast feat", "test to enter name and email in OnelatsFeat screen","smoke");
        //waitForElementPresent(artOnBoardPageObjects.onelastFeatText,60);
        waitForElementPresent(artOnBoardPageObjects.partnerName,60);
        enterText(androidDriver,artOnBoardPageObjects.partnerName,"Harish Habbanakuppe");
        androidDriver.hideKeyboard();
        tapButton(androidDriver,artOnBoardPageObjects.genderButtoon,false);
        enterText(androidDriver,artOnBoardPageObjects.partnerEmail,"harish.ramakrishna@mindtree.com");
        tapButton(androidDriver,artOnBoardPageObjects.letsgetStartedButton,false);
    }

    @Test(priority = 7)
    public void testContactListPage() throws Exception {
        startTest("Contact List Page", "test Contact List page loaded", "smoke");
        waitForElementPresent(homePageObjects.WelcomePage,60);
        tapButton(androidDriver, homePageObjects.MenuButton, false);
        elementDisplayed(androidDriver,contactPageObjects.ContactsButton);
        tapButton(androidDriver,contactPageObjects.ContactsButton,false);
////        //Assert.assertTrue(contactPageObjects.contactcount.isDisplayed());
////        List<MobileElement> imageviews = androidDriver.findElements(By.xpath("//android.widget.ImageView"));
////        System.out.println("the Image views are :" + imageviews.size());
////        for(int i=0;i<imageviews.size();i++) {
////            System.out.println("the image text are " + imageviews.get(i).getText());
////            imageviews.get(i).click();
////            System.out.println("the image number for add contact is " + i);
////            System.out.println("the image text are " + imageviews.get(i).getTagName());
////
////        }
    }

    @Test(priority = 8)
    public void testImportContacts()
    {
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
            enterText(androidDriver, contactPageObjects.searchContactField, "Saudi");
            List<MobileElement> buttons = androidDriver.findElements(By.xpath("//android.widget.ImageView[@index='0']"));
            System.out.println("the buttons size " + buttons.size());
            for (MobileElement element : buttons) {
                tapButton(androidDriver, element, false);
            }
        publishReport();
        }

//
//
////    @Test(priority = 7)
////    public void testAddContact() throws InterruptedException {
////        try {
////            startTest("Adding Contact", "test to add contact from contact list page", "smoe");
////            waitForElementPresent(contactPageObjects.AddYourFirstContact);
////            Assert.assertEquals("Add your first contact",getText(contactPageObjects.AddYourFirstContact));
////            tapButton(androidDriver,contactPageObjects.contactName,false);
////            enterText(androidDriver,contactPageObjects.contactName,"Divyas");
////            androidDriver.hideKeyboard();
////            tapButton(androidDriver,contactPageObjects.mobileNumber,false);
////            enterText(androidDriver,contactPageObjects.mobileNumber,"546489599");
////            androidDriver.hideKeyboard();
////            scrolltoElement(androidDriver, contactPageObjects.AddNewContactButton);
////            tapButton(androidDriver,contactPageObjects.emailAddress,false);
////            enterText(androidDriver,contactPageObjects.emailAddress,"divyas@mindtree.com");
////            androidDriver.hideKeyboard();
////            tapButton(androidDriver, contactPageObjects.AddNewContactButton, false);
////        }catch (Exception e){}
////        catch (AssertionError e)
////        {}
////
////    }
////
////
////    @Test(priority = 8)
////    public void testAddContactAdditionalDetails() throws InterruptedException {
////        try {
////            startTest("Additional Contact Details", " test to add additional contact details", "smoke");
////            Thread.sleep(5000);
////            tapButton(androidDriver,contactPageObjects.SelectAllProducts,false);
////            scrolltoElement(androidDriver, contactPageObjects.AddMoreDetails);
////            tapButton(androidDriver, contactPageObjects.AddMoreDetails, false);
//////            Assert.assertTrue(contactPageObjects.MotorProduct.isSelected());
//////            Assert.assertTrue(contactPageObjects.MedicalProduct.isSelected());
//////            Assert.assertTrue(contactPageObjects.TravelProduct.isSelected());
//////            Assert.assertTrue(contactPageObjects.MedicalMalpracticeProduct.isSelected());
////            scrolltoElement(androidDriver, contactPageObjects.SaveButton);
////
////            tapButton(androidDriver,contactPageObjects.spouse,false);
////            enterText(androidDriver,contactPageObjects.spouse,"2");
////
////            tapButton(androidDriver,contactPageObjects.kids,false);
////            enterText(androidDriver,contactPageObjects.kids,"10");
////
////            tapButton(androidDriver,contactPageObjects.nationalID,false);
////            enterText(androidDriver,contactPageObjects.nationalID,"1234567890");
////
////            tapButton(androidDriver, contactPageObjects.SaveButton, false);
////           // enterText(androidDriver, contactPageObjects.Organisation, "Mindtree");
////            Thread.sleep(5000);
////        }catch (AssertionError e)
////        {}
////        publishReport();
////
////    }
    @AfterMethod
    public void getResult(ITestResult result)
    {
        try
        {
            getTestResult(androidDriver,result);
        }catch (Exception e)
        {}
    }


    }
