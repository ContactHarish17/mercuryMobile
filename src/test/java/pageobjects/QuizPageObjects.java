package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class QuizPageObjects extends MainPageObject{

    public QuizPageObjects(AndroidDriver androidDriver)
    {
        super(androidDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Step 1: Quick Learning']")
    public MobileElement QuickLearning;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='SKIP AND REACH OUT QUIZ']")
    public MobileElement SkipQuiz;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='SKIP AND REACH OUT CONTACTS']")
    public MobileElement ReachContacts;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Learn More ?']")
    public MobileElement LearnMore;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Take a quiz']")
    public MobileElement takequiz;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video Overview']")
    public MobileElement videoOverview;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Product Documentation']")
    public MobileElement productdocument;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Take A Quick Quiz & Get Recognized']")
    public MobileElement quizTitle;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='TAKE THE QUIZ']")
    public MobileElement takeQuizButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='REACH OUT CONTACTS']")
    public MobileElement ReachContactsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Question 1 of 3']")
    public MobileElement question1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Question 2 of 3']")
    public MobileElement question2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Question 3 of 3']")
    public MobileElement question3;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='True']")
    public MobileElement WrongAnswerTrue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Other Party']")
    public MobileElement Question3_Asnwer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Third Party Liability Motor Insurance']")
    //@AndroidFindBy(xpath = "//android.widget.ScrollView[@index='6']/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='2']")
    public MobileElement Question1_Answer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='It’s ok, you get one more shot!']")
    public MobileElement WrongAnswerMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='False']")
    public MobileElement CorrectAnswerFalse;


    //@AndroidFindBy(xpath = "//android.widget.Button[@index='8']")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='5']/android.view.ViewGroup[@index='2']/android.widget.Button[@index='0']")
    public MobileElement NextQuestionButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='7']")
    public MobileElement PrevioustQuestionButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Congratulations!']")
    public MobileElement QuizComplete;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='It’s ok, you get one more shot!']")
    public MobileElement wronganswerText;
    public static String[]  quicklearningpage1 = {"Step 1: Quick Learning",
                                                   "Before you begin, here is what you essentially need to know about Third Party Liability Motor Insurance.",
                                                    "The Motor Insurance Third Party Plan will cover your customer against damages he/she has to pay to a third party."};


    public static String[] Quicklearningpage2 = {"Step 1: Quick Learning",
                                                    "The TPL Plan provides the customer with the following benefits: ",
                                                    "Physical damages caused to a third party inside or outside the vehicle",
                                                    "Material damages outside the vehicle"};

    public static String[] Quicklearningpage3 = {"Step 1: Quick Learning",
                                                 "Did you know that TPL motor insurance policy is mandatory for all vehicles in KSA?"};





    public static String[] Question1 = {
                                        "Question 1 of 3",
                                        "What is the name of the car insurance that pays for the damage you do to others?",
                                        "Comprehensive Motor Insurance",
                                        "Third Party Liability Motor Insurance",
                                        "Other’s Liability Motor Insurance"};

    public static String[] Question2 = {
            "Question 2 of 3",
            "TPL motor insurance policy is not manadatory for all vehicles in KSA?",
            "True",
            "False"};

    public static String[] Question3 = {
            "Question 3 of 3",
            "Who is the Third Party in the following picture?",
            "Your Customer",
            "Al Rajhi Takaful",
            "Other Party"};

    @AndroidFindBy(id="android:id/message")
    public MobileElement quotesharedText;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement okButton;

    @AndroidFindBy(xpath = "//android.widget.Button]@text='SEND A REMINDER']")
    public  MobileElement sendReminderButton;


}
