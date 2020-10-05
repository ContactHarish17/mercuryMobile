package maindriver;

import utility.DeviceList;
import utility.AppiumManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.URL;
import java.util.List;

public class DriverFunction extends MainFunction {


    protected static AndroidDriver<MobileElement> androidDriver;

    public static DesiredCapabilities capabilities = new DesiredCapabilities();
    public static String Device_id;
    public static String Device_OS;
    public static String Device_Name;
    public static String App_Path = "D:\\GEMobileAutomation\\cdx-mygehc-mobile-ui-automation\\APK\\MyGEHealthcare.apk";
    public static String Appium_Port;
    public static File file;

    public static String workingDirectory = System.getProperty("user.dir");
    public static String screenshotpath = "\\Screenshots";
    public static String reportfolder = "\\Reports";
    public static String testresultreport = "\\TestResults";


    @BeforeTest
    public static void setUp() {
        try {


            setAppiumdriver();
          //  checkConnection(androidDriver);
            /**
             * checking for screen orientation . if its landscape. it will turn into portrait mode
             */

            ScreenOrientation orientation = androidDriver.getOrientation();
            if (orientation.equals(ScreenOrientation.LANDSCAPE)) {
                androidDriver.rotate(ScreenOrientation.PORTRAIT);
            }

            /**
             *  Unlocking device
             */

            androidDriver.context("NATIVE_APP");

            emptyFolder(screenshotpath);
            emptyFolder(reportsFilePath);
            emptyFolder(testresultreport);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void readDeviceDetailsCommandPrompt() {

        try {

            Device_id = System.getProperty("DeviceID");
            Device_OS = System.getProperty("DeviceOS");
            Device_Name = System.getProperty("DeviceName");
            App_Path = System.getProperty("AppPath");
            Appium_Port = System.getProperty("AppiumPort");
            System.out.println("Passed The Device ID is " + Device_id);
            System.out.println("Passed The Device Name is " + Device_Name);
            System.out.print("The Device OS is :- " + Device_OS);
            System.out.println("Passed The Appium port is " + Appium_Port);
            System.out.println("Passed The Application path  is " + App_Path);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void setdriver() {
        try {
            AppiumManager.startAppiumServer();
            String appium_url = AppiumManager.getAppiulURL();
            System.out.println("Appium Server Address : - " + appium_url);
            capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.UDID, Device_id);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "bbcnews");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            //capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability("appiumversion", "1.8.1");
            capabilities.setCapability("app", App_Path);
         //   capabilities.setCapability("appPackage", "com.alrajhitakaful.Partnerportal");
           // capabilities.setCapability("appActivity", "md555e815c7d9c343c615606e17db1ee20c.MainActivity");
            capabilities.setCapability("--session-override", true);
            androidDriver = new AndroidDriver<MobileElement>(new URL(appium_url), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void setAppiumdriver() {
        try {
            AppiumManager.startAppiumServer();
            String appium_url = AppiumManager.getAppiulURL();
            System.out.println("Appium Server Address : - " + appium_url);
            capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.UDID, DeviceList.id);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "bbcnews");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability("appiumversion", "1.8.1");
            capabilities.setCapability("app", App_Path);
          //  capabilities.setCapability("appPackage", "com.alrajhitakaful.Partnerportal");
           // capabilities.setCapability("appActivity", "md555e815c7d9c343c615606e17db1ee20c.MainActivity");
            capabilities.setCapability("--session-override", true);
            androidDriver = new AndroidDriver<MobileElement>(new URL(appium_url), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /**
     * function to check whether WiFi Connection enabled or not.
     * If not, enables the WiFi Connection
     */

    public static void checkConnections() {
        try {
            ConnectionState state = androidDriver.setConnection(new ConnectionStateBuilder()
                    .withWiFiEnabled()
                    .build());
            System.out.println("The WiFi Status is " + state.isWiFiEnabled());
            if (!state.isWiFiEnabled()) {
                androidDriver.setConnection(state);
            }
        } catch (NullPointerException e) {

        }
    }


    public static void waitForElementPresent(MobileElement element, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(androidDriver, seconds);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){}
    }


    @AfterTest
    public static void tearDown() {
        androidDriver.closeApp();
        // androidDriver.removeApp("com.companyname.art_mobile");
        AppiumManager.stopAppiumServer();

    }

    public void checkScreenText(String expectedText[])
    {
        List<MobileElement> screentext = androidDriver.findElements(By.xpath("//android.widget.TextView"));
        for(int i=0;i<screentext.size();i++)
        {
            for(int j=0;j<expectedText.length;j++)
            {
                Assert.assertEquals(screentext.get(i).getText(),expectedText[j]);
            }
        }

    }
}
