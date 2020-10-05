package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ContactPageObject extends  MainPageObject{


    public ContactPageObject(AndroidDriver driver)
    {
        super(driver);
    }

    // @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='5']/android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@text='Enter Name']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter name']")
    public MobileElement contactName;

    @AndroidFindBy(xpath = "//android.widget.Textview[@text='0 Contacts']")
    public MobileElement contactcount;

    //@AndroidFindBy(xpath = "//android.view.ViewGroup[@index='5']/android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@text='Enter mob number']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter mobile number']")
    public MobileElement mobileNumber;

    // @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='5']/android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']android.widget.EditText[@text='Enter email address']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter email address']")
    public MobileElement emailAddress;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='IMPORT CONTACTS']")
    public MobileElement imporContactsButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Add New Contact' and @index='0']")
    public MobileElement aDDNewContact;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='SAVE']")
    public MobileElement SaveButton;

    //  @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='1']/android.view.ViewGroup[@index='0']")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='0']/android.widget.ScrollView[@index='0']")
    public MobileElement firstContact;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='0']/android.widget.ScrollView[@index='0']/android.widget.HorizontalScrollView[@index='0']/android.widget.TextView[@index='0']")
    public MobileElement firstContactName;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='EDIT']")
    public MobileElement EditButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='DELETE']")
    public MobileElement DeleteButton;

    @AndroidFindAll(
            {
                    @AndroidBy(id = "android:id/button1"),
                    @AndroidBy(xpath = "//android.widget.Button[@text='YES']")
            }
    )
    public MobileElement YesButton;



    @AndroidFindAll(
            {
                    @AndroidBy(id = "android:id/button2"),
                    @AndroidBy(xpath = "//android.widget.Button[@text='NO']")
            }
    )
    public MobileElement NoButton;

    @AndroidFindAll(
            {
                    @AndroidBy(id = "android:id/message"),
                    @AndroidBy(xpath = "//android.widget.Button[@text='Delete Ramakrishna']")
            }
    )
    public MobileElement DeleteMessage;

    @AndroidFindAll(
            {
                    @AndroidBy(id = "com.companyname.art_mobile:id/alertTitle"),
                    @AndroidBy(xpath = "//android.widget.Button[@text='Are you sure you want to delete the contact']")
            }
    )
    public MobileElement DeleteTitle;

    @AndroidFindBy(xpath = "//*[@text='Motor']")
    public MobileElement MotorProduct;

    @AndroidFindBy(xpath = "//*[@text='Medical']")
    public MobileElement MedicalProduct;

    @AndroidFindBy(xpath = "//*[@text='Travel']")
    public MobileElement TravelProduct;

    @AndroidFindBy(xpath = "//*[@text='Medical Malpractice']")
    public MobileElement MedicalMalpracticeProduct;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add more details?']")
    public MobileElement AddMoreDetails;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='5']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='0']")
    public MobileElement SelectAllProducts;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Organisation' and @index='11']")
    public MobileElement OrganisationField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Organisation']")
    public MobileElement OrganisationValue;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Job Title']")
    public MobileElement JobTitleField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement JobTitlevalue;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Marital Status']")
    public MobileElement MaritalStatusField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement MaritalStatusValue;

    @AndroidFindBy(id = "android:id/numberpicker_input")
    public MobileElement Married;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Single']")
    public MobileElement Single;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Kids']")
    public MobileElement KidsField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement Organisation;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement OKButton;

    @AndroidFindBy(id = "android:id/button2")
    public MobileElement CancelButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='National ID']")
    public MobileElement NationalField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='5']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement NationalFieldValue;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='3']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement SpouseField;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Twitter']")
    public MobileElement TwitterField;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='5']/android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement TwitterFieldValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LinkedIn']")
    public MobileElement LinkedInField;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='5']/android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement LinkedInFieldValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contacts']")
    public MobileElement ContactsButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='0']")
    public MobileElement AddContactsButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.widget.Button[@text='I'M BUYING THIS FOR MYSELF']")
    public MobileElement BuyingMyself;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Add New Contact']")
    public MobileElement AddNewContactButton;

    //@AndroidFindBy(xpath = "//android.view.ViewGroup[@index='0']/android.widget.TextView[@text='Add your first contact']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add your first contact']")
    public MobileElement AddYourFirstContact;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']/android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement editName;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']/android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement editEmail;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']/android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement editMobileNumber;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='7']/android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='5']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement nationalID;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='7']/android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='4']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement kids;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='7']/android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='3']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement spouse;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='IMPORT CONTACTS']")
    public MobileElement importContacts;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    public  MobileElement okbutton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select contact']")
    public MobileElement selectContactTitle;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@text='Search']")
    public MobileElement searchContactField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search']")
    public MobileElement searchContact;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select All']")
    public MobileElement selectallcontacts;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='0']")
    public MobileElement selectallContactsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='0 of 21 contacts selected']")
    public MobileElement selectsubtext;

    @AndroidFindAll(
            {
                    @AndroidBy(id="com.android.packageinstaller:id/permission_allow_button"),
                    @AndroidBy(xpath = "//android.widget.Button[@text='Allow']")
            }
    )
    public MobileElement allowButton;

    @AndroidFindAll(
            {
                    @AndroidBy(id = "com.android.packageinstaller:id/do_not_ask_checkbox"),
                    @AndroidBy(xpath = "//android.widget.CheckBox[@text='Don't ask again']")
            }
    )
    public MobileElement dontaskAgainbutton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Social Media']")
    public MobileElement socialmedia;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select contact']")
    public MobileElement selectContact;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='IMPORT 3 CONTACTS']")
    public MobileElement importContact;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ramakrishna']")
    public MobileElement firstcontactName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Saudi Number2']")
    public MobileElement secondcontactName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Vinay']")
    public MobileElement thirdcontactName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sankara']")
    public MobileElement FirstcontactName;


//    @AndroidFindBy(xpath = "//android.widget.Button[@text-'Add As Prospect']")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='3']/android.widget.Button[@text='Add As Prospect']")
    public MobileElement addasprospect;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.widget.TextView[@index='0']")
    public  MobileElement contactTitleName;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='1']/android.widget.ImageView[@index='0']")
    public  MobileElement contactCallbutton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='1']/android.widget.ImageView[@index='1']")
    public  MobileElement contactEmailbutton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='1']/android.widget.ImageView[@index='3']")
    public  MobileElement contactEditbutton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='1']/android.widget.ImageView[@index='4']")
    public  MobileElement contactDeletebutton;


    // @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='4']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.ImageButton[@index='0']")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='4']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.ImageButton[@index='0']")
    public  MobileElement AddContact;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='IMPORT CONTACTS']")
    public MobileElement importContactButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']/android.widget.ImageButton[@index='0']")
    public  MobileElement addcontactButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Basic Details']")
    public MobileElement contactBasicDetails;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
    public MobileElement contactMobileNumber;

    @AndroidFindBy(xpath = "//android.widget.ProgressBar[@index='0']")
    public MobileElement porgressBar;



}
