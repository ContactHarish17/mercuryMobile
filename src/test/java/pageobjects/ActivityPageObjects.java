package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ActivityPageObjects extends MainPageObject {

    public ActivityPageObjects(AndroidDriver driver)
    {
        super(driver);
    }

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Activities']")
 public MobileElement Activitybutton;


 @AndroidFindBy(xpath = "//android.widget.TextView[@text='LINK A PERSON']")
 public MobileElement activitylinkPerson;

 //@AndroidFindBy(xpath = "//android.widget.TextView[@text='Search contacts or prospects']")
 @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.FrameLayout[@index='0']")
 public MobileElement Search;

 @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search contacts or prospects']")
 public MobileElement SearchContact;

 // @AndroidFindBy(xpath = "//android.widget.TextView[@text='Harish']")
 @AndroidFindBy(xpath = "//android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']")
 public MobileElement  Contact1;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Don’t have in your contacts yet ?']")
 public MobileElement AddContactText;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD A CONTACT']")
 public MobileElement AddContactButton;

 @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.widget.Button[@index='0']")
 public MobileElement ActivityType;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Calls']")
 public MobileElement ActivityType_Calls;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tasks']")
 public MobileElement ActivityType_Tasks;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Meetings']")
 public MobileElement ActivityType_Meetings;

 @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='4']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
 public MobileElement ActivityTitle;

 @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='5']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
 public MobileElement ActivityDate;

 @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='6']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
 public MobileElement ActivityTime;

 @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='7']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.widget.Button[@index='0']")
 public MobileElement ActivityDuration;

 @AndroidFindBy(xpath = "//android.widget.Button[@text='SAVE']")
 public MobileElement SAVEButton;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='All']")
 public MobileElement AllActivity;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Meetings with Saudi Today']")
 public MobileElement meetingActivityText;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Saudi Number1']")
 public MobileElement contactName;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Calls']")
 public MobileElement CallsActivity;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Meetings']")
 public MobileElement MeetingsActivity;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tasks']")
 public MobileElement TasksActivity;

 @AndroidFindBy(xpath = "android.widget.TextView[@text='Today']")
 public MobileElement TodayActivity;

 @AndroidFindBy(xpath = "android.widget.TextView[@text='This Week']")
 public MobileElement Weekctivity;

 @AndroidFindBy(xpath = "android.widget.TextView[@text='Later']")
 public MobileElement LaterActivity;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='30 mins']")
 public MobileElement Activity_30Mins;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='1 hour']")
 public MobileElement Activity_Hour;

 @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='0']")
 public MobileElement AddActivityButton;

 @AndroidFindBy(xpath = "//android.widget.TextView[@text='MEETINGS (2)']")
 public MobileElement meetingSubMenu;

 @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='0']/android.widget.ScrollView[@index='0']")
 public MobileElement firstactivity;

 @AndroidFindBy(xpath = "//android.widget.Button[@text='DONE']")
 public MobileElement doneButton;

 @AndroidFindBy(xpath = "//android.widget.Button[@text='DELETE']")
 public MobileElement deleteButton;

 @AndroidFindBy(id = "android:id/message")
 public MobileElement activitydeleteMessages;

 @AndroidFindBy(id = "android:id/button2")
 public MobileElement noDelete;

 @AndroidFindBy(id = "android:id/button1")
 public MobileElement yesDelete;













}
